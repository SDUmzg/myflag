package com.example.sdu.myflag.activity;

import android.os.Bundle;
import android.view.View;

import com.example.sdu.myflag.R;
import com.example.sdu.myflag.base.BaseActivity;

/**
 * 设置界面
 */
public class SettingActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_setup;
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
    }

    public void modifyPassword(View view) {
        startNewActivity(ModifyPasswordActivity.class);
    }

    public void aboutUs(View view) {
        startNewActivity(AboutUsActivity.class);
    }

    public void exitLogin(View view) {
        startNewActivity(LoginActivity.class);
        MainActivity.getInstance().finish();
        finish();
    }

    public void settingBack(View view) {
        this.finish();
    }
}
