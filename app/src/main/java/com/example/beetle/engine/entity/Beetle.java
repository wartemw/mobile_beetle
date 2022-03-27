package com.example.beetle.engine.entity;

import android.graphics.Bitmap;
import java.util.Random;
public class Beetle extends Sprite {

    public enum Type {
        EVIL,BIND,FLY;
    }
    Random random = new Random();

    private Type type;
    private float speed;
    private final float movementSpeed;

    public Beetle(Bitmap texture, Position position) {
        super(texture, position);
        this.movementSpeed = 3f;
    }

    public void randomCreate(int wightFrame, int heightFrame) {
        int x = random.nextInt(wightFrame);
        int y = random.nextInt(heightFrame);
        float scaleAdd = random.nextInt(5)*0.01f;
        int rotate = random.nextInt(360);
        speed = random.nextInt(6);
        setX(x);
        setY(y);
        setScale(getScale()-scaleAdd);
        setRotation(rotate);

    }

    public void moving() {
        System.out.println(getRotation());
        setRotation(getRotation()+speed);

        if (getRotation() > 360) setRotation(getRotation()-360);;
        if (getRotation() < 0) setRotation(getRotation()+360);

        double xVel = 0;
        double yVel = 0;

        xVel += Math.cos(getRotation()) * movementSpeed;
        yVel += Math.sin(getRotation()) * movementSpeed;

        setX((float) (getX()+ xVel));
        setY((float) (getY()+ yVel));
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
