package com.example.mobilebootcamp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mobilebootcamp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        openModulesActivity();
    }

    private void openModulesActivity() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent openMainActivity =  new Intent(SplashActivity.this, ModulesActivity.class);
            startActivity(openMainActivity);
            finish();
        }, 2000);

    }
}