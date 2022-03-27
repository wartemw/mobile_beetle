package com.example.beetle.engine.entity;

import com.example.beetle.R;

public enum FliesEnum {
    IVAN_EVIL(R.drawable.evil_1,Beetle.Type.EVIL),
    LEVA_EVIL(R.drawable.evil_2,Beetle.Type.EVIL),
    ARKADY_EVIL(R.drawable.evil_3,Beetle.Type.EVIL),
    JORA_EVIL(R.drawable.evil_4,Beetle.Type.EVIL),
    SEMA_EVIL(R.drawable.evil_5,Beetle.Type.EVIL),
    KOLYA_FLY(R.drawable.fly_1,Beetle.Type.FLY),
    MATVEY_KIND(R.drawable.kind_1,Beetle.Type.BIND),
    MAKAR_KIND(R.drawable.kind_2,Beetle.Type.BIND);

    private int drawableId;
    private Beetle.Type type;

    FliesEnum(int drawableId, Beetle.Type type) {
        this.drawableId = drawableId;
        this.type = type;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public Beetle.Type getType() {
        return type;
    }
}
