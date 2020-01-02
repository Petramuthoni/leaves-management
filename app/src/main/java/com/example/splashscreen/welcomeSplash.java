package com.example.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class welcomeSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_splash);
        ImageView img=(ImageView)findViewById(R.id.imageView);
        TextView t=(TextView)findViewById(R.id.tv);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_2);
        img.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //when you want to delay some time
                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                //when animate finish load mainsctivity
                finish();
                startActivity(new Intent(getApplicationContext(),AdminEmployee.class));


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}



