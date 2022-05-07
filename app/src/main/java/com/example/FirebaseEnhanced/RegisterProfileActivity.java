package com.example.FirebaseEnhanced;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;

public class RegisterProfileActivity extends AppCompatActivity {

    //Firebase Data
    private Button RegisterProfileBtn;
    private EditText ProfileDetailsNameText;

    //Getters
    public String getProfileDetailsNameRegProfile() {
        return ProfileDetailsNameText.toString();
    }
    public String getProfileDetailsSirnameRegProfile() {
        return ProfileDetailsSirnameText.toString();
    }
    public Uri getImageRegProfile() {
        return image;
    }
    private EditText ProfileDetailsSirnameText;

    //Archive & Image (Uri)
    private static final int IMAGE_REQUEST = 1;
    private ImageView imageView;
    private Uri image;
    private Button ProfileDetailsArchiveBtn;

    //FireBase Image Upload / References
    private StorageReference storageRef;
    private DatabaseReference dataRef;

    //FireBase User register / References
    final private FirebaseDatabase firebaseDatabaseReg = FirebaseDatabase.getInstance();
    public DatabaseReference dataUserRef = firebaseDatabaseReg.getReference("server/saving-data/fireblog");
    // private StorageTask uploadImageTask; --> if only once is allowed

    //FireBase auth object --> ( DataBase )
    private FirebaseAuth authRegProf;

    static int uploadCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_profile);

        ProfileDetailsSirnameText = findViewById(R.id.ProfileDetailsSirnameText);
        ProfileDetailsNameText = findViewById(R.id.ProfileDetailsNameText);

        RegisterProfileBtn=  findViewById(R.id.RegisterProfileBtn);
        ProfileDetailsArchiveBtn = findViewById(R.id.ProfileDetailsArchiveBtn);

        //Image PlaceHolder --> ImageView
        imageView = findViewById(R.id.imageView);

        //FireBase Image References
        storageRef = FirebaseStorage.getInstance().getReference("Profile_Picture_DataBase");
        dataRef = FirebaseDatabase.getInstance().getReference("Profile_Picture_DataBase");

        //FireBase User authentication reference
        authRegProf = FirebaseAuth.getInstance();

        RegisterProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**  --> if only once is allowed
                 if(uploadImageTask != null && uploadImageTask.isInProgress()){
                 Toast.makeText(RegisterProfileActivity.this, "Unable to upload", Toast.LENGTH_LONG);
                 }
                 else {
                 UploadImage();
                 }
                 */
                //UploadImage();
                UploadUser();
                Intent intent = new Intent(RegisterProfileActivity.this, RegisterActivity.class );
                startActivity(intent);
                finish();
            }
        });
    // Image
        ProfileDetailsArchiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                archiveChooser();
            }
        });
    }
    //User
    private void UploadUser() {
        Intent intent = getIntent();
            String username = intent.getStringExtra(RegisterActivity.EXTRA_USERNAME);
            String password = intent.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
            String mail = intent.getStringExtra(RegisterActivity.EXTRA_MAIL);
        User user = new User(getProfileDetailsNameRegProfile(), getProfileDetailsSirnameRegProfile(), username, password, mail ,getImageRegProfile());

        //FireBase User register References
        DatabaseReference userRef =  dataUserRef.child("Users");
        HashMap<String, User> userList = new HashMap<>();
            //Dynamic Renaming
            String userId = "user" + uploadCounter;
            userList.put(userId,user);
        userRef.setValue(userList);
        userRef.push();
    }
    // User

    // Ouside Source https://developer.android.com/reference/android/content/ContentResolver
    private String getImageExt(Uri image){
        ContentResolver contRes = getContentResolver();
        MimeTypeMap mapMime = MimeTypeMap.getSingleton();
        return ""+mapMime.getExtensionFromMimeType(contRes.getType(image));
    }

    // Ouside Source https://firebase.google.com/docs/reference/android/com/google/firebase/storage/StorageReference
    // https://gist.github.com/codinginflow/afbbb9060cdd9898bdef2c554844e5f4
    private void UploadImage() {
      //  if(image != null){
        StorageReference newStorageRef = storageRef.child(System.currentTimeMillis() + "." + getImageExt(image));
        // uploadImageTask =  --> if only once is allowed
        newStorageRef.putFile(image).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(RegisterProfileActivity.this, "Succesfully uploaded", Toast.LENGTH_SHORT).show();
                uploadCounter++;
                //Instances
                //Dynamic renaming
                String nameImage = "UploadedImage" + uploadCounter;
                String uploadId = dataRef.push().getKey();

                Upload uloadImage = new Upload(nameImage, taskSnapshot.getUploadSessionUri().toString());
                dataRef.child(uploadId).setValue(uloadImage);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterProfileActivity.this, "Something went wrong... Try again", Toast.LENGTH_SHORT).show();
            }
        });
       // }
       //  else {
       // Toast.makeText(RegisterProfileActivity.this, "Select a image for profile picture ", Toast.LENGTH_SHORT).show();
       //  }
    }

    private void archiveChooser() {
        Intent archive = new Intent();
        archive.setType("image/*");
        archive.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(archive,IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == IMAGE_REQUEST ){
            if( resultCode == RESULT_OK ){
                if( data !=null){
                    if( data.getData() != null){
                        image = data.getData();
                        Picasso.with(this).load(image).into(imageView);
                    }
                }
            }
        }
    }
    //Image

}


