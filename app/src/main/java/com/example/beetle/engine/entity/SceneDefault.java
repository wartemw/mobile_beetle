package com.example.beetle.engine.entity;

import com.example.beetle.engine.CoreDefault;
import com.example.beetle.engine.TouchListenerDefault;
import com.example.beetle.engine.graphics.GraphDefault;

public abstract class SceneDefault {
    public CoreDefault core;
    public TouchListenerDefault touchListener;
    public  int sceneWidth;
    public  int sceneHeight;
    public GraphDefault graph;

    public SceneDefault(CoreDefault core){
        this.core = core;
        sceneWidth = core.getGraph().getWidthFrameBuffer();
        sceneHeight = core.getGraph().getHeightFrameBuffer();
        graph = core.getGraph();
        touchListener = core.getTouchListener();

    }

    public abstract void update();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();

}
