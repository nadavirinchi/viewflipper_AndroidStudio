package com.example.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewAnimator viewAnimator;
    ViewFlipper viewFlipper;
    ImageButton animalnxt;
    ImageButton animalprev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       viewAnimator = findViewById(R.id.animate);
       viewFlipper = findViewById(R.id.flip);
       animalnxt = findViewById(R.id.btnnext);
       animalprev = findViewById(R.id.btnprev);

       letsAddImagesToViewflipper(viewFlipper);
       letsaddimagestoviewanimator(viewAnimator);

       useanimationforviewflipper(viewFlipper);
       useanimationforviewanimator(viewAnimator);

       animalnxt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               viewFlipper.showNext();
               viewAnimator.showNext();
           }
       });

       animalprev.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               viewFlipper.showPrevious();
               viewAnimator.showPrevious();
           }
       });

    }
    public void letsSetlayoutParamsforImageView(ImageView imageView){
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));
    }
    private void letsAddImagesToViewflipper(ViewFlipper viewFlipper){
        for (int index = 0;index<Animal.animalimages.length;index++){
            ImageView imgview = new ImageView(MainActivity.this);
            imgview.setImageResource(Animal.animalimages[index]);
            letsSetlayoutParamsforImageView(imgview);
            imgview.setPadding(100,100,100,100);
            viewFlipper.addView(imgview);
        }
    }
    private void letsaddimagestoviewanimator(ViewAnimator viewAnimator){
        for (int index = 0;index<Animal.animalimages.length;index++){
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(Animal.animalimages[index]);
            letsSetlayoutParamsforImageView(imageView);
            imageView.setPadding(100,100,100,100);
            viewAnimator.addView(imageView);
        }
    }
    private void useanimationforviewflipper(ViewFlipper viewFlipper){
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_in_left));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_out_right));
    }
    private void useanimationforviewanimator(ViewAnimator viewAnimator){
        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.fade_in));
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.fade_out));
    }
}