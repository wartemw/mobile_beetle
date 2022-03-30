package com.example.beetle.engine.graphics;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

import com.example.beetle.engine.entity.Sprite;

import java.io.InputStream;

public class GraphDefault {

    private AssetManager assetManager;
    private Bitmap frameBufferMain;
    private Canvas canvas;
    private Paint paint;
    private Bitmap texture;

    public GraphDefault(AssetManager assetManager, Bitmap frameBufferMain) {
        this.assetManager = assetManager;
        this.frameBufferMain = frameBufferMain;
        this.canvas = new Canvas(frameBufferMain);
        this.paint = new Paint();
    }

    public void ClearScene(int colorRGB) {
        canvas.drawRGB(colorRGB, colorRGB, colorRGB);
    }

    public void drawPoint(int x, int y, int color) {
        paint.setColor(color);
        canvas.drawPoint(x, y, paint);
    }

    public void drawLine(int x1, int y1, int x2, int y2, int color) {
        paint.setColor(color);
        canvas.drawLine(x1, y1, x2, y2, paint);
    }
    public void drawCircle(float x, float y, int wight, int height, float rotate,float scale, int color, Paint.Style style) {
        paint.setColor(color);
        paint.setStyle(style);
        canvas.save();
        canvas.translate(x, y);
        canvas.rotate(rotate);
        canvas.scale(scale,scale);

        int dW = wight / 2;
        int dH = height / 2;

        canvas.drawOval(-dW, -dH, dW, dH, paint);
        canvas.restore();
    }

    int scale = 100;

    public void drawSprite(Sprite sprite) {
       /* for (int i = 0; i < 11; i++) {
            drawLine(i * scale, 0, i * scale, frameBufferMain.getHeight(), Color.CYAN);
        }

        for (int j = 0; j < 23; j++) {
            drawLine(0, j * scale, frameBufferMain.getWidth(), j * scale, Color.WHITE);
        }*/

       canvas.drawBitmap(sprite.get(), sprite.getMatrix(), paint);
        if (sprite.isViewPoint()) drawCircle(sprite.getX(), sprite.getY(),20,20,0,1,  Color.BLACK, Paint.Style.FILL);

        if (sprite.isViewBorder())
        drawCircle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight(), sprite.getRotation(),sprite.getScale(), Color.BLACK, Paint.Style.STROKE);
    }


    private void drawText(String text, int x, int y, int color, int sizeText, Typeface font) {
        paint.setColor(color);
        paint.setTextSize(sizeText);
        paint.setTypeface(font);
        canvas.drawText(text, x, y, paint);
    }

    public int getWidthFrameBuffer() {
        return frameBufferMain.getWidth();
    }

    public int getHeightFrameBuffer() {
        return frameBufferMain.getHeight();
    }

    public Bitmap newTexture(String fileName) {
        try (InputStream inputStream = assetManager.open(fileName)) {
            texture = BitmapFactory.decodeStream(inputStream);
            if (texture == null)
                throw new Exception();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return texture;
    }
}
