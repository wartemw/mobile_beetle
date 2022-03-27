package com.example.beetle.viewManager.form;

import android.view.View;
import android.widget.Button;

import com.example.beetle.viewManager.display.DisplayMenuEnum;
import com.example.beetle.MainActivity;
import com.example.beetle.R;

public class FormComplexity {

    public static final String EASY_SELECTED = "easy";
    public static final String MIDDLE_SELECTED = "middle";
    public static final String DIFFICULT_SELECTED = "difficult";

    private final MainActivity mainActivity;
    private final Button easy;
    private final Button middle;
    private final Button difficult;

    public String selected;

    public FormComplexity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        easy = mainActivity.findViewById(R.id.easy_btn);
        middle = mainActivity.findViewById(R.id.middle_btn);
        difficult = mainActivity.findViewById(R.id.difficult_btn);


        easy.setOnClickListener(this::easyOnClickListener);
        middle.setOnClickListener(this::middleOnClickListener);
        difficult.setOnClickListener(this::difficultOnClickListener);

        easy.setTextColor(MainActivity.BUTTON_SELECTED_TEXT_COLOR);
        selected = EASY_SELECTED;
    }

    public void easyOnClickListener(View view) {
        easy.setTextColor(MainActivity.BUTTON_SELECTED_TEXT_COLOR);
        middle.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        difficult.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        selected = EASY_SELECTED;

        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
    }

    public void middleOnClickListener(View view) {
        easy.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        middle.setTextColor(MainActivity.BUTTON_SELECTED_TEXT_COLOR);
        difficult.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        selected = MIDDLE_SELECTED;

        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
    }

    public void difficultOnClickListener(View view) {
        easy.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        middle.setTextColor(MainActivity.BUTTON_TEXT_COLOR);
        difficult.setTextColor(MainActivity.BUTTON_SELECTED_TEXT_COLOR);
        selected = DIFFICULT_SELECTED;

        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
    }

    public Button getEasy() {
        return easy;
    }

    public Button getMiddle() {
        return middle;
    }

    public Button getDifficult() {
        return difficult;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
