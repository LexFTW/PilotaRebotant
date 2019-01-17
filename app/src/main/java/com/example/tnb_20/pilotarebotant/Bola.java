package com.example.tnb_20.pilotarebotant;

import android.support.constraint.solver.widgets.Rectangle;
import android.widget.ImageView;

public class Bola extends Rectangle {

    private ImageView ball;
    private int width, height, x, y;
    private double displacementX, displacementY;

    public Bola(){}

    public ImageView getBall() {
        return ball;
    }

    public void setBall(ImageView ball){
        this.ball = ball;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public double getDisplacementX() {
        return displacementX;
    }

    public double getDisplacementY() {
        return displacementY;
    }

    public void setDisplacementX(double displacementX){
        this.displacementX = displacementX;
    }

    public void setDisplacementY(double displacementY){
        this.displacementY = displacementY;
    }
}
