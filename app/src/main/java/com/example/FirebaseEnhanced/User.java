package com.example.FirebaseEnhanced;

import android.net.Uri;

public class User {
        /**
         * Initially all variables are automatically null or 0
         * no need for duplicated implications
         */
        String name;
        String sirname;
        String userName;
        String email;
        String password;
        Uri profilePhoto;
        // Solution solution;
        String profileColor;
        double gasEmission;
        double motorEmission;
        double nutritionEmission;
        double totalEmission;
        double totalSecondaryEmission;
        double totalPrimaryEmission;
        double paperEmission;
        double itEmission;
        double hotelEmission;
        double clothingEmission;
        double score;
        double pharmaceuticalsEmission;

        public User(String name, String sirname, String userName, String email, String password,Uri profilePhoto) {
            this.name = name;
            this.sirname = sirname;
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.profilePhoto = profilePhoto;
        }

        //getters

        public String getName() {
            return name;
        }

        public String getUserName() {
            return userName;
        }

        public String getEmail() {
            return email;
        }

        public String getProfileColor() {
            return profileColor;
        }

        /**
         public Solution getSolution() {
         return solution;
         }
         */
        public double getMotorEmission() {
            return motorEmission;
        }

        public double getTotalEmission() {
            return totalEmission;
        }

        public double getTotalSecondaryEmission() {
            return totalSecondaryEmission;
        }

        public double getTotalPrimaryEmission() {
            return totalPrimaryEmission;
        }

        public double getPharmaceuticalsEmission() {
            return pharmaceuticalsEmission;
        }

        public double getPaperEmission() {
            return paperEmission;
        }

        public double getItEmission() {
            return itEmission;
        }

        public double getHotelEmission() {
            return hotelEmission;
        }

        public double getClothingEmission() {
            return clothingEmission;
        }

        public double getScore() {
            return score;
        }

        //setter for score
        public void setScore(int s){
            score += s;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setProfileColor(String profileColor) {
            this.profileColor = profileColor;
        }

        /**
         public void setSolution(Solution solution) {
         this.solution = solution;
         }*/

        public void setGasEmission(double gasEmission) {
            this.gasEmission = gasEmission;
        }

        public void setMotorEmission(double motorEmission) {
            this.motorEmission = motorEmission;
        }

        public void setNutritionEmission(double nutritionEmission) {
            this.nutritionEmission = nutritionEmission;
        }

        public void setTotalEmission(double totalEmission) {
            this.totalEmission = totalEmission;
        }

        public void setTotalSecondaryEmission(double totalSecondaryEmission) {
            this.totalSecondaryEmission = totalSecondaryEmission;
        }

        public void setTotalPrimaryEmission(double totalPrimaryEmission) {
            this.totalPrimaryEmission = totalPrimaryEmission;
        }

        public void setPaperEmission(double paperEmission) {
            this.paperEmission = paperEmission;
        }

        public void setItEmission(double itEmission) {
            this.itEmission = itEmission;
        }

        public void setHotelEmission(double hotelEmission) {
            this.hotelEmission = hotelEmission;
        }

        public void setClothingEmission(double clothingEmission) {
            this.clothingEmission = clothingEmission;
        }
    }

