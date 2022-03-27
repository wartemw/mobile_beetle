package com.example.beetle.engine;

import android.view.MotionEvent;
import android.view.View;

import com.example.beetle.engine.entity.Sprite;

public class TouchListenerDefault implements View.OnTouchListener {

    private float touchX;
    private float touchY;

    private boolean isTouchDown;
    private boolean isTouchUp;

    private float sceneWidth;
    private float sceneHeight;

    public TouchListenerDefault(View view, float sceneWidth, float sceneHeight) {
        view.setOnTouchListener(this);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

            isTouchDown = false;
            isTouchUp = false;
            touchX = event.getX();
            touchY = event.getY() ;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    isTouchUp = true;
                    isTouchDown = false;
                    break;
                case MotionEvent.ACTION_UP:
                    isTouchDown = true;
                    isTouchUp = false;
                    break;
            }
        return true;
    }

    public boolean touchSprite(Sprite sprite) {
        System.out.println("touch-> " + touchX + " " + touchY);
        if (isTouchUp) {
            return sprite.contains(touchX, touchY);
        }
        return false;
    }


}
