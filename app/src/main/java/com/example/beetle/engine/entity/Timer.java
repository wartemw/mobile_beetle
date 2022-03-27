package com.example.beetle.engine.entity;

public class Timer {
    private long timer = 0;
    private long second;

    public Timer(long second,long per) {
        this.second = second*per;
    }

    public Timer(long second) {
        this.second = second*1000;
    }

    public boolean updateInfo() {
        if(timer==0)
            timer = System.currentTimeMillis()-second;
        if (System.currentTimeMillis() - timer > second) {
            timer+=second;

            return true;
        }
        return false;
    }
}
