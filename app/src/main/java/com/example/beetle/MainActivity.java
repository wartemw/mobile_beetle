package com.example.beetle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.beetle.engine.CoreDefault;
import com.example.beetle.engine.LoopDefault;
import com.example.beetle.game.GameManager;
import com.example.beetle.viewManager.display.DisplayMenu;
import com.example.beetle.viewManager.display.DisplayMenuEnum;
import com.example.beetle.viewManager.form.FormComplexity;
import com.example.beetle.viewManager.form.FormMain;
import com.example.beetle.viewManager.form.FormMenu;
import com.example.beetle.viewManager.form.FormMode;
import com.example.beetle.viewManager.form.FormSettings;

public class MainActivity extends AppCompatActivity {
    public static final int BUTTON_TEXT_COLOR = Color.parseColor("#B3B3B3");
    public static final int BUTTON_SELECTED_TEXT_COLOR = Color.parseColor("#8A3A3A");

    private int width;
    private int height;
    private CoreDefault core;
    private DisplayMenu displayMenu;
    private FormMenu formMenu;
    private FormMain formMain;
    private FormComplexity formComplexity;
    private FormMode formMode;
    private FormSettings formSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        displayMenu = new DisplayMenu(this);
        formMain = new FormMain(this);
        formComplexity = new FormComplexity(this);
        formMenu = new FormMenu(this);
        formMode = new FormMode(this);
        formSettings = new FormSettings(this);

        core = new CoreDefault(this);
        core.setScene(new GameManager(this,core));

        displayMenu.setView(DisplayMenuEnum.MENU);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public DisplayMenu getDisplayMenu() {
        return displayMenu;
    }


    public FormMain getFormMain() {
        return formMain;
    }

    public FormMenu getFormMenu() {
        return formMenu;
    }

    public FormComplexity getFormComplexity() {
        return formComplexity;
    }

    public FormMode getFormMode() {
        return formMode;
    }

    public FormSettings getFormSettings() {
        return formSettings;
    }


    public CoreDefault getCore() {
        return core;
    }
}
