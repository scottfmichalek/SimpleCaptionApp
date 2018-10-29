package com.example.scott.simplecaptionapp;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;
    Button editButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.captionLayout);
        textView = findViewById(R.id.captionTextView);
        editButton = findViewById(R.id.editButton);
    }

    // OnTouch method for the imageview. Make caption appear
    public void onTouchImage(View view)
    {
        captionVisible = !captionVisible;

        if (captionVisible)
        {
            textView.setText(imageCaption);
//            slideUp();
            float height = linearLayout.getHeight();
            ObjectAnimator mover = ObjectAnimator.ofFloat(linearLayout, "translationY", 0, -height);
            mover.start();
        }
        else
        {
            slideDown();
        }
    }

    // OnTouch method for the textview. Make edit button appear
    public void onTouchCaption(View view)
    {
        buttonVisible = !buttonVisible;

        if (buttonVisible)
        {
            // Make the edit button visible
            editButton.setVisibility(VISIBLE);
        }
        else
        {
            // Later on, remove this if/else and make the edit button
            // disappear after a certain amount of time of the caption
            // not getting pressed
            editButton.setVisibility(INVISIBLE);
        }

        // If the caption isn't touched again in 5 seconds, make it invisible

    }

    // OnTouch method for the button. Allow caption editing
    public void onTouchButton(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setMessage("Add a caption");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                // Do something with value!
                imageCaption = input.getText().toString();
                textView.setText(imageCaption);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();

        // Update the caption
    }

    // Animate a view to slide up onto the bottom of the screen
    public void slideUp()
    {
        float height = linearLayout.getHeight();
        ObjectAnimator mover = ObjectAnimator.ofFloat(linearLayout, "translationY", 0, -height);
        mover.start();
    }

    // Animate a view to slide off the bottom of the screen
    public void slideDown()
    {
        float height = linearLayout.getHeight();
        ObjectAnimator mover = ObjectAnimator.ofFloat(linearLayout, "translationY", -height, 0);
        mover.start();
    }


    boolean captionVisible = false;
    boolean buttonVisible = false;
    String imageCaption = "Lovely little island";
}
