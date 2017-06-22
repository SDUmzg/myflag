package com.example.sdu.myflag.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sdu.myflag.R;
import com.example.sdu.myflag.base.BaseActivity;

/**
 * 我的flag打卡界面
 *
 */
public class MyFlagClockActivity extends BaseActivity {

    TextView picHint;
    EditText inputText;

    @Override
    public int getLayoutId() {
        return R.layout.activity_flag_clock;
    }

    @Override
    public void afterCreate(Bundle savedInstanceState) {
        picHint = (TextView) findViewById(R.id.pic_hint);
        inputText = (EditText) findViewById(R.id.clock_comment);

    }

    /*
    点击更换图片按钮
     */
    public void changePic(View view) {

    }

    /*
    点击发送按钮
     */
    public void sendClock(View view) {
    }
}
