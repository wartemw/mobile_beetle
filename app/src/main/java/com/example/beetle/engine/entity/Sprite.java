package com.example.beetle.engine.entity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;

import com.example.beetle.game.GameManager;

import java.util.ArrayList;
import java.util.List;

public class Sprite extends Transformation {
    private Bitmap texture;
    private Matrix matrix;
    private Shape shape;
    private List<Point> pointList;
    private String name;

    private boolean isViewPoint;
    private boolean isViewBorder;

    public Sprite(Bitmap texture, Position position) {
        this(texture, position, new Size(texture.getWidth(), texture.getHeight()), 1f, 0f);
    }

    public Sprite(Bitmap texture, Position position, Size size, float scale, float rotation) {
        super(position,size);
        this.texture = texture;

        this.matrix = new Matrix();

        shape = new Shape(this);
        pointList = new ArrayList<>();

        setX(position.getX());
        setY(position.getY());
        setWidth(size.getWidth());
        setHeight(size.getHeight());
        setScale(scale);
        setRotation(rotation);
    }

    public Bitmap get() {
        return texture;
    }


    public Matrix getMatrix() {

        Matrix matrix = this.matrix;
        matrix.reset();

        float vw = getWidth();
        float vh = getHeight();
        float hvw = vw / 2;
        float hvh = vh / 2;
        float bw = (float) texture.getWidth();
        float bh = (float) texture.getHeight();

        float s1x = vw / bw;
        float s1y = vh / bh;
        matrix.postScale(s1x, s1y);

        matrix.postTranslate(-hvw, -hvh);

        int rotation = (int) getRotation();
        matrix.postRotate(rotation);

        float offsetX = getX(), offsetY = getY();


            matrix.postScale(getScale(), getScale());

        matrix.postTranslate(offsetX, offsetY);

        return matrix;
    }

    public Shape getShape() {
        return shape;
    }

    public boolean isViewPoint() {
        return isViewPoint;
    }

    public void setViewPoint(boolean viewPoint) {
        isViewPoint = viewPoint;
    }

    public boolean isViewBorder() {
        return isViewBorder;
    }

    public void setViewBorder(boolean viewBorder) {
        isViewBorder = viewBorder;
    }

    public boolean contains(float x, float y) {
        return shape.contains(x, y);
    }

    public void update(GameManager gameManager) {
        pointList.clear();
    }

    public void render(GameManager gameManager) {
        gameManager.graph.drawSprite(this);

        for (Point point : pointList)
            gameManager.graph.drawPoint(point.getX(), point.getY(), point.getColor());
    }


    public void fillCirce(List<Point> pointList) {
        // Consider a rectangle of size N*N
        int N_X = 1080;
        int N_Y = 2400;

        float x, y; // Coordinates inside the rectangle

        // Draw a square of size N*N.
        for (int i = 0; i < N_X; i += 3) {
            for (int j = 0; j < N_Y; j += 3) {
                x = i;
                y = j;

                if (contains(x, y))
                    pointList.add(new Point(x, y, Color.WHITE));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
