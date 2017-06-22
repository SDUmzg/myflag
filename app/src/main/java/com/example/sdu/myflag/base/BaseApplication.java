package com.example.sdu.myflag.base;

import android.app.Application;

import com.example.sdu.myflag.R;


public class BaseApplication extends Application {

    private static BaseApplication instance;
    public static int HeadIcon[] = {
                    R.drawable.head_icon_default,
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three,
                    R.drawable.four,
                    R.drawable.five,
                    R.drawable.six,
                    R.drawable.seven,
                    R.drawable.eight,
                    R.drawable.nine
            };

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
