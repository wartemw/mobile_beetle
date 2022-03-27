package com.example.beetle.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LoopDefault implements Runnable {
    private final float FPS = 60;
    private final float SECOND = 1000000000;
    private final float UPDATE_TIME = SECOND / FPS;

    private boolean running = false;

    Thread gameThread = null;

    CoreDefault core;
    private SurfaceView surfaceView;
    Bitmap frameBuffer;
    SurfaceHolder.Callback callback;
    SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private Rect rect;


    public LoopDefault(CoreDefault coreDefault, SurfaceView surfaceView, Bitmap frameBuffer) {
        this.surfaceView = surfaceView;
        this.frameBuffer = frameBuffer;
        this.core = coreDefault;
        this.surfaceHolder = surfaceView.getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }

    public void start() {
        if (running)
            return;

        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stop() {
        if (!running)
            return;

        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        core.getScene().update();
    }

    private void render() {
        if (running && surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            core.getScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void run() {
        float lastTime = System.nanoTime();
        float delta = 0;

        LoopInfo.updateTimer();

        while (running) {
            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lastTime;
            lastTime = nowTime;
            delta += elapsedTime / UPDATE_TIME;
            if (delta > 1) {
                update();
                LoopInfo.updateUpdate();

                render();
                LoopInfo.updateRender();
                delta--;
            }


            LoopInfo.updateInfo();
        }
    }

    public SurfaceView getSurfaceView() {
        return surfaceView;
    }
}
