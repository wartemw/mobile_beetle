package com.example.beetle.viewManager.form;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.beetle.viewManager.display.DisplayMenuEnum;
import com.example.beetle.MainActivity;
import com.example.beetle.R;

public class FormSettings {

    private final MainActivity mainActivity;
    private final CheckBox turnOffSound;
    private final CheckBox turnOffMusic;
    private final Button settingBack;

    public FormSettings(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        turnOffSound = mainActivity.findViewById(R.id.turn_off_sound_checkbox);
        turnOffMusic = mainActivity.findViewById(R.id.turn_off_music_checkbox);
        settingBack = mainActivity.findViewById(R.id.setting_back_btn);


        turnOffSound.setOnCheckedChangeListener(this::turnOffSoundOnClickListener);
        turnOffMusic.setOnCheckedChangeListener(this::turnOffMusicOnClickListener);
        settingBack.setOnClickListener(this::settingBackOnClickListener);
    }

    private void turnOffSoundOnClickListener(CompoundButton compoundButton, boolean b) {
        turnOffSound.setTextColor(b ? MainActivity.BUTTON_SELECTED_TEXT_COLOR : MainActivity.BUTTON_TEXT_COLOR);
    }

    private void turnOffMusicOnClickListener(CompoundButton compoundButton, boolean b) {
        turnOffMusic.setTextColor(b ? MainActivity.BUTTON_SELECTED_TEXT_COLOR : MainActivity.BUTTON_TEXT_COLOR);
    }

    private void settingBackOnClickListener(View view) {
        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
    }

    public CheckBox getTurnOffSound() {
        return turnOffSound;
    }

    public CheckBox getTurnOffMusic() {
        return turnOffMusic;
    }

    public Button getSettingBack() {
        return settingBack;
    }
}
