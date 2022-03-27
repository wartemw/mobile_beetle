package com.example.beetle.engine.entity;

public class Transformation {
    private Position position;
    private float scale;
    private Size size;
    private float rotation;

    public Transformation(Position position, Size size) {
        this.position = position;
        this.size = size;
        scale = 1;
        rotation = 0;
    }

    public float getX() {
        return position.getX();
    }

    public void setX(float x) {
        position.setX(x);
    }

    public float getY() {
        return position.getY();
    }

    public void setY(float y) {
        position.setY(y);
    }

    public int getWidth() {
        return size.getWidth();
    }

    public void setWidth(int width) {
        size.setWidth(width);
    }

    public int getHeight() {
        return size.getHeight();
    }

    public void setHeight(int height) {
        size.setHeight(height);
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
