package com.example.mygopets.utils;

public class TokenUtils {
    public static String getToken() {
        return SharedPreferenceStorage.getInstance().getString(GlobalValues.SHARED_TOKEN, "");

    }

    public static void setToken(String token) {
        SharedPreferenceStorage.getInstance().putString(GlobalValues.SHARED_TOKEN, token);
    }

    public static boolean isLogin() {
        return SharedPreferenceStorage.getInstance()
                .getBoolean(GlobalValues.IS_LOGIN, false);

    }

    public static void setLogin(boolean login) {
        SharedPreferenceStorage.getInstance().putBoolean(GlobalValues.IS_LOGIN, login);
    }

    public static boolean welcomeVisited() {
        return SharedPreferenceStorage.getInstance()
                .getBoolean(GlobalValues.WELCOME_KEY, false);

    }


    public static void setWelcomeVisited(boolean welcomeVisited) {
        SharedPreferenceStorage.getInstance().putBoolean(GlobalValues.WELCOME_KEY, welcomeVisited);
    }

    public static int getUserId() {
        return SharedPreferenceStorage.getInstance().getInt(GlobalValues.SHARED_ID, 0);
    }

    public static void setUserId(int UserId) {
        SharedPreferenceStorage.getInstance().putInt(GlobalValues.SHARED_ID, UserId);
    }

}
