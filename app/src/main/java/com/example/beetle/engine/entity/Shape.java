package com.example.beetle.engine.entity;

public class Shape {
    private Transformation shapeTransformation;
    private Transformation transformation;

    public Shape(Transformation transformation) {
        this.transformation = transformation;
        shapeTransformation = new Transformation(new Position(0, 0), new Size(0, 0));
        shapeTransformation.setScale(0);
    }

    public void setShapeTransformation(Transformation transformation) {
        this.shapeTransformation = transformation;
    }

    public float getX() {
        return transformation.getX() + shapeTransformation.getX();
    }

    public void setX(float x) {
        shapeTransformation.setX(x);
    }

    public float getY() {
        return transformation.getY() + shapeTransformation.getY();
    }

    public void setY(float y) {
        shapeTransformation.setY(y);
    }

    public int getWidth() {
        return transformation.getWidth() + shapeTransformation.getWidth();
    }

    public void setWidth(int width) {
        shapeTransformation.setWidth(width);
    }

    public int getHeight() {
        return transformation.getHeight() + shapeTransformation.getHeight();
    }

    public void setHeight(int height) {
        shapeTransformation.setHeight(height);
    }

    public float getScale() {
        return transformation.getScale() + shapeTransformation.getScale();
    }

    public void setScale(float scale) {
        shapeTransformation.setScale(scale);
    }

    public float getRotation() {
        return transformation.getRotation() + shapeTransformation.getRotation();
    }

    public void setRotation(float rotation) {
        shapeTransformation.setRotation(rotation);
    }

    public boolean contains(float x, float y) {
        float x_pos = x - getX();
        float y_pos = y - getY();

        double degrees = -Math.toRadians(getRotation());

        float r_sin = (float) Math.sin(degrees);
        float r_cos = (float) Math.cos(degrees);

        float x_pos_r_cos = x_pos * r_cos;
        float x_pos_r_sin = x_pos * r_sin;
        float y_pos_r_cos = y_pos * r_cos;
        float y_pos_r_sin = y_pos * r_sin;

        float x_pos_r_cos_y_pos_r_sin = x_pos_r_cos - y_pos_r_sin;
        float x_pos_r_sin_y_pos_r_cos = x_pos_r_sin + y_pos_r_cos;

        float x_pos_r_cos_y_pos_r_sin_pow = (float) Math.pow(x_pos_r_cos_y_pos_r_sin, 2);
        float x_pos_r_sin_y_pos_r_cos_pow = (float) Math.pow(x_pos_r_sin_y_pos_r_cos, 2);

        float wight_d_2 = getWidth() / 2f * getScale();
        float height_d_2 = getHeight() / 2f * getScale();

        float wight_d_2_pow = (float) Math.pow(wight_d_2, 2);
        float height_d_2_pow = (float) Math.pow(height_d_2, 2);
        float x_pos_r_cos_y_pos_r_sin_pow_wight = (float) (x_pos_r_cos_y_pos_r_sin_pow / wight_d_2_pow);
        float x_pos_r_sin_y_pos_r_cos_pow_height = (float) (x_pos_r_sin_y_pos_r_cos_pow / height_d_2_pow);

        return x_pos_r_cos_y_pos_r_sin_pow_wight + x_pos_r_sin_y_pos_r_cos_pow_height <= 1;
    }
}
