package com.example.beetle.engine.entity;

public class Point {
    private int x;
    private  int y;
    private int color;

    public Point(float x, float y, int color) {
        this.x = (int) x;
        this.y = (int) y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return color;
    }
}
