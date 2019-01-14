package com.example.tnb_20.pilotarebotant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity01 extends AppCompatActivity {

    // Atributos de la Clase:
    private ImageView ball;
    private int width;
    private int height;
    private double displacementX;
    private double displacementY;
    private int x, y;
    private int status;
    private DisplayMetrics displayMetrics; // Serveix per obtenir les dimensions de la pantalla.
    private ArrayList<Bola> bolas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createWindow();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                moveBall();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000, 30);
    }

    private void moveBall() {
        double positionX = this.ball.getX() + (this.x * this.displacementX);
        double positionY = this.ball.getY() + (this.y * this.displacementY);

        checkPositionX(positionX);
        checkPositionY(positionY);
    }

    private void checkPositionY(double positionY) {
        if(this.ball.getY() > 0){
            if(positionY + this.ball.getHeight() + this.status < this.height){
                this.ball.setY((float) positionY);
            }else{
                this.ball.setY((float) height - this.ball.getHeight() - this.status);
                this.displacementY = this.displacementY * (-1);
            }
        }else{
            if (positionY > 0) {
                this.ball.setY((float) positionY);
            } else{
                this.ball.setY(0);
                this.displacementY = this.displacementY * (-1);
            }
        }
    }

    private void checkPositionX(double positionX) {
        if(this.ball.getX() > 0){
            if(positionX + this.ball.getWidth() < this.width){
                this.ball.setX((float) positionX);
            }else{
                this.ball.setX((float) width - this.ball.getWidth());
                this.displacementX = this.displacementX * (-1);
            }
        }else{
            if (positionX > 0) {
                this.ball.setX((float) positionX);
            } else{
                this.ball.setX(0);
                this.displacementX = this.displacementX * (-1);
            }
        }
    }

    private void createWindow() {
        this.displacementX = 4.0;
        this.displacementY = 4.0;
        this.x = 2;
        this.y = 2;
        this.ball = (ImageView) findViewById(R.id.ball);
        this.displayMetrics = this.getBaseContext().getResources().getDisplayMetrics();
        this.width = this.displayMetrics.widthPixels;
        this.height = this.displayMetrics.heightPixels;
        this.status = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }
}
