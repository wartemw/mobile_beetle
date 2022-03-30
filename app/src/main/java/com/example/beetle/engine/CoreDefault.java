package com.example.beetle.engine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.view.Display;

import com.example.beetle.MainActivity;
import com.example.beetle.R;
import com.example.beetle.engine.entity.SceneDefault;
import com.example.beetle.engine.graphics.GraphDefault;

public class CoreDefault {

    private LoopDefault loop;
    private GraphDefault graph;
    private MediaPlayer backgroundMusic;
    private MediaPlayer evilMusic;
    private MediaPlayer kindMusic;

    private Display display;
    private Bitmap frameBuffer;
    private Point sizeDisplay;
    private TouchListenerDefault touchListenerDefault;
    private SceneDefault scene;
    private float sceneWidth;
    private float sceneHeight;
    private MainActivity mainActivity;

    public CoreDefault(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        sizeDisplay = new Point();
        display = mainActivity.getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);

        frameBuffer = Bitmap.createBitmap(sizeDisplay.x, sizeDisplay.y, Bitmap.Config.ARGB_8888);
        sceneWidth = sizeDisplay.x;
        sceneHeight = sizeDisplay.y;

        loop = new LoopDefault(this, mainActivity.getDisplayMenu().getSurfaceView(), frameBuffer);
        graph = new GraphDefault(mainActivity.getAssets(), frameBuffer);
        backgroundMusic = MediaPlayer.create(mainActivity, R.raw.background);
        evilMusic = MediaPlayer.create(mainActivity, R.raw.kill_evil);
        kindMusic = MediaPlayer.create(mainActivity, R.raw.kill_kind);

        backgroundMusic.setLooping(true);
        backgroundMusic.start();
        touchListenerDefault = new TouchListenerDefault(loop.getSurfaceView(), sceneWidth, sceneHeight);
    }

    public void start() {
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

    public void playBackMusic() {
        boolean checked = mainActivity.getFormSettings().getTurnOffMusic().isChecked();
        if (!checked)
            backgroundMusic.start();
    }

    public void playEvilKill() {
        boolean checked = mainActivity.getFormSettings().getTurnOffSound().isChecked();
        if (!checked)
            evilMusic.start();
    }

    public void playKindKill() {
        boolean checked = mainActivity.getFormSettings().getTurnOffSound().isChecked();
        if (!checked)
            kindMusic.start();
    }

    public void pauseBackMusic() {
        backgroundMusic.pause();
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
