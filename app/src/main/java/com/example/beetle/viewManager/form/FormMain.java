package com.example.beetle.viewManager.form;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.beetle.viewManager.display.DisplayMenuEnum;
import com.example.beetle.MainActivity;
import com.example.beetle.R;

public class FormMain {

    private final MainActivity mainActivity;
    private final TextView check;
    private final TextView time;
    private final Button exit;


    public FormMain(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        check = mainActivity.findViewById(R.id.check_text);
        time = mainActivity.findViewById(R.id.time_text);
        exit = mainActivity.findViewById(R.id.exit_btn);


        exit.setOnClickListener(this::exitOnClickListener);
    }

    public void exitOnClickListener(View view) {
        mainActivity.getDisplayMenu().setView(DisplayMenuEnum.MENU);
    }

    public TextView getCheck() {
        return check;
    }

    public TextView getTime() {
        return time;
    }

    public Button getExit() {
        return exit;
    }
}
