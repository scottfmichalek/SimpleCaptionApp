package com.example.scott.simplecaptionapp;

import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTouchMainSquare(View view)
    {
        captionVisible = !captionVisible;

        if (captionVisible)
        {
            String caption = getCaption();

            TextView textView = findViewById(R.id.captionTextView);
            textView.setText(caption);
            slideIn(textView);
        }
        else
        {
            TextView textView = findViewById(R.id.captionTextView);
            slideOut(textView);
        }
    }

    // Animate a view to slide up onto the bottom of the screen
    public void slideIn(View view)
    {
        ObjectAnimator animation = ObjectAnimator.ofFloat(
                view,
                "translationY",
                -view.getHeight());
        animation.setDuration(300);
        animation.start();
    }

    // Animate a view to slide off the bottom of the screen
    public void slideOut(View view)
    {
        ObjectAnimator animation = ObjectAnimator.ofFloat(
                view,
                "translationY",
                view.getHeight());
        animation.setDuration(300);
        animation.start();
    }

    // Get caption depending on image
    public String getCaption()
    {
        String caption;

        caption = "Beautiful island";

        return caption;
    }

    boolean captionVisible = false;
}
