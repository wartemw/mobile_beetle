package com.example.beetle.viewManager.form;

import android.view.View;
import android.widget.Button;

import com.example.beetle.viewManager.display.DisplayMenuEnum;
import com.example.beetle.MainActivity;
import com.example.beetle.R;

public class FormMode {

    public static final String TIME_LIMIT_SELECTED = "timeLimit";
    public static final String TIME_INCREASES_KILLING_SELECTED = "timeIncreasesKilling";

    private final MainActivity mainActivity;
    private final Button timeLimit;
    private final Button timeIncreasesKilling;

    public String selected;

    public FormMode(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        timeLimit = mainActivity.findViewById(R.id.time_limit_btn);
        timeIncreasesKilling = mainActivity.findViewById(R.id.time_increases_killing_btn);


        timeLimit.setOnClickListener(this::timeLimitOnClickListener);
        timeIncreasesKilling.setOnClickListener(this::timeIncreasesKillingOnClickListener);

        selected = TIME_LIMIT_SELECTED;
    }

    public void endlessLevelsOnClickListener(View view) {
        timeLimit.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        timeIncreasesKilling.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        selected = TIME_LIMIT_SELECTED;

        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
    }

    public void timeLimitOnClickListener(View view) {
        timeLimit.setTextColor(MainActivity.BUTTON_SELECTED_TEXT_COLOR);
        timeIncreasesKilling.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        selected = TIME_LIMIT_SELECTED;

        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
    }

    public void timeIncreasesKillingOnClickListener(View view) {
        timeLimit.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        timeIncreasesKilling.setTextColor(MainActivity.BUTTON_SELECTED_TEXT_COLOR);
        selected = TIME_INCREASES_KILLING_SELECTED;

        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
    }

    public Button getTimeLimit() {
        return timeLimit;
    }

    public Button getTimeIncreasesKilling() {
        return timeIncreasesKilling;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
