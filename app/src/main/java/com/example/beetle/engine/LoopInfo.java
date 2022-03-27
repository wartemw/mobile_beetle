package com.example.beetle.engine;

public class LoopInfo {
    private static float tick = 0;
    private static float fps = 0;
    private static float updates = 0;
    private static float render = 0;
    private static long timer = 0;

    private static long second = 0;

    private LoopInfo() {
        second = 0;
    }

    public static float getTick() {
        return tick;
    }

    public static float getFps() {
        return fps;
    }

    protected static void updateUpdate() {
        updates++;
    }

    protected static void updateRender() {
        render++;
    }

    protected static void updateTimer() {
        timer = System.currentTimeMillis();
    }

    protected static void updateInfo() {
        if (System.currentTimeMillis() - timer > 1000) {
            second++;
            tick = updates;
            fps = render;
            updates=0;
            render=0;
            timer+=1000;
        }
    }

    public static long getSecond() {
        return second;
    }
}
