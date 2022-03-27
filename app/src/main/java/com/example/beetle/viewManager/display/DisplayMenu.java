package com.example.beetle.viewManager.display;

import android.support.constraint.ConstraintLayout;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.beetle.MainActivity;
import com.example.beetle.R;

public class DisplayMenu {

    private MainActivity mainActivity;

    private boolean gameOver;
    private int check;
    private final ConstraintLayout gameOverView;
    private final TextView gameOverText;
    private final TextView gameOverInfo;
    private final SurfaceView surfaceView;
    private final LinearLayout mainView;
    private final LinearLayout menuView;
    private final LinearLayout complexityView;
    private final LinearLayout modeView;
    private final LinearLayout settingsView;

    public DisplayMenu(MainActivity mainActivity) {
        gameOverView = mainActivity.findViewById(R.id.game_over);
        gameOverText = mainActivity.findViewById(R.id.game_over_text);
        gameOverInfo = mainActivity.findViewById(R.id.ckeck_info);

        surfaceView = mainActivity.findViewById(R.id.surface_view);
        mainView = mainActivity.findViewById(R.id.main_view);
        menuView = mainActivity.findViewById(R.id.menu_view);
        complexityView = mainActivity.findViewById(R.id.complexity_view);
        modeView = mainActivity.findViewById(R.id.mode_view);
        settingsView = mainActivity.findViewById(R.id.settings_view);
        this.mainActivity = mainActivity;
    }

    public void setView(DisplayMenuEnum type) {
        switch (type) {
            case MAIN:
                mainActivity.getCore().resume();
                gameOver = false;
                check = 0;
                gameOverView.setVisibility(View.INVISIBLE);
                surfaceView.setVisibility(View.VISIBLE);
                mainView.setVisibility(View.VISIBLE);
                menuView.setVisibility(View.INVISIBLE);
                complexityView.setVisibility(View.INVISIBLE);
                modeView.setVisibility(View.INVISIBLE);
                settingsView.setVisibility(View.INVISIBLE);
                break;
            case MENU:
                mainActivity.getCore().pause();
                surfaceView.setVisibility(View.INVISIBLE);
                mainView.setVisibility(View.INVISIBLE);
                menuView.setVisibility(View.VISIBLE);
                complexityView.setVisibility(View.INVISIBLE);
                modeView.setVisibility(View.INVISIBLE);
                settingsView.setVisibility(View.INVISIBLE);
                break;
            case COMPLEXITY:
                surfaceView.setVisibility(View.INVISIBLE);
                mainView.setVisibility(View.INVISIBLE);
                menuView.setVisibility(View.INVISIBLE);
                complexityView.setVisibility(View.VISIBLE);
                modeView.setVisibility(View.INVISIBLE);
                settingsView.setVisibility(View.INVISIBLE);
                break;
            case MODE:
                surfaceView.setVisibility(View.INVISIBLE);
                mainView.setVisibility(View.INVISIBLE);
                menuView.setVisibility(View.INVISIBLE);
                complexityView.setVisibility(View.INVISIBLE);
                modeView.setVisibility(View.VISIBLE);
                settingsView.setVisibility(View.INVISIBLE);
                break;
            case SETTINGS:
                surfaceView.setVisibility(View.INVISIBLE);
                mainView.setVisibility(View.INVISIBLE);
                menuView.setVisibility(View.INVISIBLE);
                complexityView.setVisibility(View.INVISIBLE);
                modeView.setVisibility(View.INVISIBLE);
                settingsView.setVisibility(View.VISIBLE);
                break;
            default:
                surfaceView.setVisibility(View.INVISIBLE);
                mainView.setVisibility(View.INVISIBLE);
                menuView.setVisibility(View.INVISIBLE);
                complexityView.setVisibility(View.INVISIBLE);
                modeView.setVisibility(View.INVISIBLE);
                settingsView.setVisibility(View.INVISIBLE);
        }
        if(gameOver) {
            gameOverView.setVisibility(View.VISIBLE);
            gameOverText.setText("Игра окончена");
            gameOverInfo.setText("Вас счет:" + check);
        }
    }

    public SurfaceView getSurfaceView() {
        return surfaceView;
    }

    public LinearLayout getMainView() {
        return mainView;
    }

    public LinearLayout getMenuView() {
        return menuView;
    }

    public LinearLayout getComplexityView() {
        return complexityView;
    }

    public LinearLayout getModeView() {
        return modeView;
    }

    public LinearLayout getSettingsView() {
        return settingsView;
    }

    public void setGameOver(boolean is) {
        this.gameOver = is;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
