package com.example.beetle.engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.Display;

import com.example.beetle.MainActivity;
import com.example.beetle.engine.entity.SceneDefault;
import com.example.beetle.engine.graphics.GraphDefault;

public class CoreDefault {

    private LoopDefault loop;
    private GraphDefault graph;

    private Display display;
    private Bitmap frameBuffer;
    private Point sizeDisplay;
    private TouchListenerDefault touchListenerDefault;
    private SceneDefault scene;
    private float sceneWidth;
    private float sceneHeight;

    public CoreDefault(MainActivity mainActivity) {

        sizeDisplay = new Point();
        display = mainActivity.getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);

        frameBuffer = Bitmap.createBitmap(sizeDisplay.x, sizeDisplay.y, Bitmap.Config.ARGB_8888);
        sceneWidth =sizeDisplay.x;
        sceneHeight =sizeDisplay.y;

        loop = new LoopDefault(this, mainActivity.getDisplayMenu().getSurfaceView(), frameBuffer);
        graph = new GraphDefault(mainActivity.getAssets(), frameBuffer);
        touchListenerDefault = new TouchListenerDefault(loop.getSurfaceView(), sceneWidth,sceneHeight);
    }

    public void start(){
        loop.start();
    }

    public GraphDefault getGraph() {
        return graph;
    }

    public SceneDefault getScene() {
        return scene;
    }

    public LoopDefault getLoop() {
        return loop;
    }

    public void setScene(SceneDefault scene) {
        this.scene = scene;
    }

    public TouchListenerDefault getTouchListener() {
        return touchListenerDefault;
    }

    public void resume() {
        loop.start();
        scene.resume();
    }

    public void pause() {
        loop.stop();
        scene.pause();
    }

    public float getSceneWidth() {
        return sceneWidth;
    }

    public float getSceneHeight() {
        return sceneHeight;
    }
}
