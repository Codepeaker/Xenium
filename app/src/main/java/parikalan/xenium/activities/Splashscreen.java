package parikalan.xenium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import parikalan.xenium.R;


public class Splashscreen extends AppCompatActivity {

    public static final long SPLASH_TIME = 2500;
    Runnable mjumprunnable;
    Handler mhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        mjumprunnable = new Runnable() {
            @Override
            public void run() {
                jump();
            }
        };
        mhandler = new Handler();
        mhandler.postDelayed(mjumprunnable, SPLASH_TIME);

        ImageView imageView2 = (ImageView) findViewById(R.id.splashpgdav);

        Animation in = AnimationUtils.loadAnimation(this, R.anim.fadein);
        imageView2.startAnimation(in);
        imageView2.setVisibility(View.VISIBLE);

    }

    public void jump() {

        if (isFinishing()) {
            return;
        }

        Intent in = new Intent(this, Event_List.class);
        startActivity(in);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump();
        return true;
    }
}

