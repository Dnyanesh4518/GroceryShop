package com.example.groceryshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView groceryimg;
    TextView textView ;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        groceryimg = findViewById(R.id.groceryimg);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        Animation slideAnimation = AnimationUtils.loadAnimation(this,R.anim.side_slide);
        groceryimg.startAnimation(slideAnimation);
        textView.startAnimation(slideAnimation);
        textView2.startAnimation(slideAnimation);






        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },5000);
    }
}