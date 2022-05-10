package com.example.mygopets.utils;

import android.app.Activity;
import android.content.res.Configuration;

import java.util.Locale;

public class LanguageUtils {


    public static String getLanguage() {

        return SharedPreferenceStorage.getInstance()
                .getString(GlobalValues.SHARED_LANGUAGE, "ar");

    }

    public static void setLanguage(Activity activity, String language) {
        try {
            Locale locale = new Locale(language);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            activity.getResources().updateConfiguration(config, null);
        } catch (NullPointerException a) {
            a.printStackTrace();
        } catch (RuntimeException a) {
            a.printStackTrace();
        }
        SharedPreferenceStorage.getInstance().putString(GlobalValues.SHARED_LANGUAGE, language);
    }


}
