package com.example.mygopets.utils;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Context context;
    private static App app;

    public static App getApp() {
        return app;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        app = this;

    }


}
