package com.example.beetle.viewManager.form;

import android.view.View;
import android.widget.Button;

import com.example.beetle.viewManager.display.DisplayMenuEnum;
import com.example.beetle.MainActivity;
import com.example.beetle.R;

public class FormMenu {

    private final MainActivity mainActivity;
    private final Button begin;
    private final Button complexity;
    private final Button mode;
    private final Button settings;
    private final Button close;


    public FormMenu(MainActivity mainActivity) {
        begin = mainActivity.findViewById(R.id.begin_btn);
        complexity = mainActivity.findViewById(R.id.complexity_btn);
        mode = mainActivity.findViewById(R.id.mode_btn);
        settings = mainActivity.findViewById(R.id.settings_btn);
        close = mainActivity.findViewById(R.id.close_btn);
        this.mainActivity = mainActivity;

        begin.setOnClickListener(this::beginOnClickListener);
        complexity.setOnClickListener(this::complexityOnClickListener);
        mode.setOnClickListener(this::modeOnClickListener);
        settings.setOnClickListener(this::settingsOnClickListener);
        close.setOnClickListener(this::closeOnClickListener);
    }

    public void beginOnClickListener(View view) {
        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MAIN);
    }

    public void complexityOnClickListener(View view) {
        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.COMPLEXITY);
    }

    public void modeOnClickListener(View view) {
        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MODE);
    }

    public void settingsOnClickListener(View view) {
        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.SETTINGS);
    }

    public void closeOnClickListener(View view) {
        mainActivity.finish();
    }

    public Button getBegin() {
        return begin;
    }

    public Button getComplexity() {
        return complexity;
    }

    public Button getMode() {
        return mode;
    }

    public Button getSettings() {
        return settings;
    }

    public Button getClose() {
        return close;
    }
}
