package com.example.mobilebootcamp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mobilebootcamp.R;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.iv_logo);
        openModulesActivity();
    }

    @Override
    protected void onStart() {
        super.onStart();
        logo.startAnimation(AnimationUtils.loadAnimation(this ,
                R.anim.left_to_right));
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