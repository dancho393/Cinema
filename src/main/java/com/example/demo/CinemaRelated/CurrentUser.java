package com.example.demo.CinemaRelated;

public class CurrentUser {
    private static Users currentUser;

    public static Users getCurrentUser() {
        if (currentUser == null) {
            return null;
        }
        return currentUser;
    }

    public static void setCurrentUser(Users user) {
        currentUser = user;
    }
}
