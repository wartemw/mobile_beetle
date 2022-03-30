package com.example.beetle.game;

import android.graphics.Color;

import com.example.beetle.MainActivity;
import com.example.beetle.R;
import com.example.beetle.engine.CoreDefault;
import com.example.beetle.engine.LoopInfo;
import com.example.beetle.engine.entity.Beetle;
import com.example.beetle.engine.entity.SpriteUtil;
import com.example.beetle.engine.entity.Position;
import com.example.beetle.engine.entity.SceneDefault;
import com.example.beetle.engine.entity.Sprite;
import com.example.beetle.engine.entity.Timer;
import com.example.beetle.viewManager.display.DisplayMenuEnum;
import com.example.beetle.viewManager.form.FormComplexity;
import com.example.beetle.viewManager.form.FormMode;

import java.util.Arrays;
import java.util.Random;


public class GameManager extends SceneDefault {
    private MainActivity mainActivity;

    private final Sprite background;
    private final int max = 1000;
    private final Beetle spriteList[];

    int check = 0;
    int timer = 0;

    Timer timerSecond = new Timer(1);
    Timer spawnTimer = new Timer(1);

    public GameManager(MainActivity mainActivity, CoreDefault core) {
        super(core);
        this.mainActivity = mainActivity;

        background = SpriteUtil.createBackground(mainActivity);

        spriteList = new Beetle[max];
    }


    @Override
    public void update() {
        if (timer < 0) {
            mainActivity.runOnUiThread(() -> {
                mainActivity.getDisplayMenu().setGameOver(true);
                mainActivity.getDisplayMenu().setCheck(check);
                mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
            });
        }
        if (timerSecond.updateInfo()) {
            mainActivity.runOnUiThread(() -> mainActivity.getFormMain().getTime().setText("Время: " + timer));
            timer--;
        }
        if (spawnTimer.updateInfo()) {
            for (int i = 0; i < spriteList.length; i++) {
                Beetle beetle = spriteList[i];
                if (beetle == null) {
                    spriteList[i] = SpriteUtil.createRandom(mainActivity);
                    break;
                }
            }
        }

        for (int i = 0; i < spriteList.length; i++) {
            Beetle beetle = spriteList[i];
            if (beetle == null)
                continue;
            if (core.getTouchListener().touchSprite(beetle)) {
                String mode = mainActivity.getFormMode().selected;
                synchronized (mainActivity.getCore().getLoop()) {
                    switch (beetle.getType()) {
                        case FLY:
                            timer = 0;
                            break;
                        case EVIL:
                            if (mode.equals(FormMode.TIME_INCREASES_KILLING_SELECTED))
                                timer += new Random().nextInt(5);
                            addCheck(1);
                            core.playEvilKill();
                            break;
                        case BIND:
                            if (mode.equals(FormMode.TIME_INCREASES_KILLING_SELECTED))
                                timer -= new Random().nextInt(3);
                            awayCheck(1);
                            core.playKindKill();
                            break;
                    }
                }
                spriteList[i] = null;
            }
        }
        for (Beetle beetle : spriteList)
            if (beetle != null)
                beetle.update(this);

    }

    @Override
    public void drawing() {
        graph.ClearScene(Color.RED);
        graph.drawSprite(background);
        for (Beetle beetle : spriteList) {
            if (beetle != null) {
                beetle.render(this);
                beetle.moving();
            }
        }

    }

    @Override
    public void pause() {
        Arrays.fill(spriteList, null);
    }

    @Override
    public void resume() {
        timerSecond = new Timer(1);
        check = 0;
        String complexity = mainActivity.getFormComplexity().selected;
        switch (complexity) {
            case FormComplexity.EASY_SELECTED:
                timer = 60;
                spawnTimer = new Timer(1);
                break;
            case FormComplexity.MIDDLE_SELECTED:
                timer = 40;
                spawnTimer = new Timer(2);
                break;
            case FormComplexity.DIFFICULT_SELECTED:
                timer = 30;
                spawnTimer = new Timer(3);
                break;
        }
    }

    public void addCheck(int count) {
        check += count;
        mainActivity.runOnUiThread(() -> mainActivity.getFormMain().getCheck().setText("Счет: " + check));
    }

    public void awayCheck(int count) {

        check -= count;
        if (check < 0)
            check = 0;
        mainActivity.runOnUiThread(() -> mainActivity.getFormMain().getCheck().setText("Счет: " + check));
    }
}
