package com.example.ex03_graphicsprimitives;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button blue =findViewById(R.id.Blue);
        Button red = findViewById(R.id.Red);
        Button green = findViewById(R.id.Green);
        Bitmap bg = Bitmap.createBitmap(720,1080, Bitmap.Config.ARGB_8888);
        ImageView i = findViewById(R.id.imageView);
        i.setBackgroundDrawable(new BitmapDrawable(bg));

        Canvas canvas = new Canvas(bg);

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                paint.setTextSize(30);
                //To draw a Rectangle
                canvas.drawText("Rectangle", 420, 150, paint);
                canvas.drawRect(400, 200, 650, 700, paint);

                //To draw a Circle
                canvas.drawText("Circle", 120, 150, paint);
                canvas.drawCircle(200, 350, 150, paint);

                //To draw an arc
                canvas.drawText("Arc", 120, 800, paint);
                canvas.drawArc(50, 850, 350, 1150, 135, 120, true, paint);

                //To draw a Line
                canvas.drawText("Line", 480, 800, paint);
                canvas.drawLine(520, 850, 520, 1150, paint);

            }
        });

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Paint paint = new Paint();
                paint.setColor(Color.RED);
                paint.setTextSize(30);
                //To draw a Rectangle
                canvas.drawText("Rectangle", 420, 150, paint);
                canvas.drawRect(400, 200, 650, 700, paint);

                //To draw a Circle
                canvas.drawText("Circle", 120, 150, paint);
                canvas.drawCircle(200, 350, 150, paint);

                //To draw an arc
                canvas.drawText("Arc", 120, 800, paint);
                canvas.drawArc(50, 850, 350, 1150, 135, 120, true, paint);

                //To draw a Line
                canvas.drawText("Line", 480, 800, paint);
                canvas.drawLine(520, 850, 520, 1150, paint);

            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paint paint = new Paint();
                paint.setColor(Color.GREEN);
                paint.setTextSize(30);
                //To draw a Rectangle
                canvas.drawText("Rectangle", 420, 150, paint);
                canvas.drawRect(400, 200, 650, 700, paint);

                //To draw a Circle
                canvas.drawText("Circle", 120, 150, paint);
                canvas.drawCircle(200, 350, 150, paint);

                //To draw an arc
                canvas.drawText("Arc", 120, 800, paint);
                canvas.drawArc(50, 850, 350, 1150, 135, 120, true, paint);

                //To draw a Line
                canvas.drawText("Line", 480, 800, paint);
                canvas.drawLine(520, 850, 520, 1150, paint);
            }
        });






        // canvas.drawRect(50, 50, 450, 200, paint);
        // paint.setColor(Color.BLUE);
        //canvas.drawCircle(150, 200, 50, paint);
        //canvas.drawCircle(350, 200, 50, paint);

        // ObjectAnimator animCar = ObjectAnimator.ofFloat(i, "x",  700);
        //animCar.setDuration(1000);
        //AnimatorSet animation = new AnimatorSet();
        // animation.play(animCar).before(ObjectAnimator.ofFloat(i, "x", 0).setDuration(1000));
        // animation.start();


        //i.animate().translationX(300f).setDuration(6000);
        //i.animate().translationX(-300f).setDuration(6000);





    }
}
