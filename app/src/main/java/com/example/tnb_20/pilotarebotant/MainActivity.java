package com.example.tnb_20.pilotarebotant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // Atributos de la Clase:
    private ImageView ball;
    private int width;
    private int height;
    private double displacementX;
    private double displacementY;
    private int x, y;
    // Atributos correctos.
    private int status;
    private DisplayMetrics displayMetrics; // Serveix per obtenir les dimensions de la pantalla.
    private ArrayList<Bola> bolas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.displayMetrics = this.getBaseContext().getResources().getDisplayMetrics();
        this.status = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));

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
        for (Bola bola: bolas) {
            double positionX = bola.getBall().getX() + (bola.getX() * bola.getDisplacementX());
            double positionY = bola.getBall().getY() + (bola.getY() * bola.getDisplacementY());

            checkPositionX(bola, positionX);
            checkPositionY(bola, positionY);

            intersection();
        }
    }

    private void intersection(){
        // Si 0a >= 0b || 0a <= 0b + width{}
        if(bolas.get(0).getBall().getX() >= bolas.get(1).getBall().getX() || bolas.get(0).getBall().getX() <= bolas.get(1).getBall().getX() + bolas.get(1).getBall().getWidth()){
            bolas.get(0).setDisplacementX(bolas.get(0).getDisplacementX() * (-1));
            bolas.get(1).setDisplacementX(bolas.get(1).getDisplacementX() * (-1));
        }
    }

    private void checkPositionX(Bola bola, double positionX){
        if(bola.getBall().getX() > 0){
            if(positionX + bola.getBall().getWidth() < bola.getWidth()){
                bola.getBall().setX((float) positionX);
            }else{
                bola.getBall().setX((float) bola.getWidth() - bola.getBall().getWidth());
                bola.setDisplacementX(bola.getDisplacementX() * (-1));
            }
        }else{
            if (positionX > 0) {
                bola.getBall().setX((float) positionX);
            } else{
                bola.getBall().setX(0);
                bola.setDisplacementX(bola.getDisplacementX() * (-1));
            }
        }
    }

    private void checkPositionY(Bola bola, double positionY) {
        if (bola.getBall().getY() > 0) {
            if (positionY + bola.getBall().getHeight() + this.status < bola.getHeight()) {
                bola.getBall().setY((float) positionY);
            } else {
                bola.getBall().setY((float) bola.getHeight() - bola.getBall().getHeight() - this.status);
                bola.setDisplacementY(bola.getDisplacementY() * (-1));
            }
        } else {
            if (positionY > 0) {
                bola.getBall().setY((float) positionY);
            } else {
                bola.getBall().setY(0);
                bola.setDisplacementY(bola.getDisplacementY() * (-1));
            }
        }
    }

    private void createWindow() {
        this.bolas = new ArrayList<>();
        Bola bola = new Bola();
        bola.setDisplacementY(20.0);
        bola.setDisplacementX(20.0);
        bola.setX(4);
        bola.setY(4);
        bola.setBall((ImageView) findViewById(R.id.ball));
        bola.setWidth(this.displayMetrics.widthPixels);
        bola.setHeight(this.displayMetrics.heightPixels);
        this.bolas.add(bola);

        Bola bola2 = new Bola();
        bola2.setDisplacementY(8.0);
        bola2.setDisplacementX(8.0);
        bola2.setX(2);
        bola2.setY(2);
        bola2.setBall((ImageView) findViewById(R.id.ball2));
        bola2.setWidth(this.displayMetrics.widthPixels);
        bola2.setHeight(this.displayMetrics.heightPixels);

        this.bolas.add(bola2);
    }
}
