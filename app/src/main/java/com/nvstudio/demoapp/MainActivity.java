package com.nvstudio.demoapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private int y = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawingView(this));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //int x = 10/y;
                //System.out.println(x);
            }
        }, 10000);
    }
}
