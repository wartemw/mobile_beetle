package com.example.beetle.engine.entity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.beetle.MainActivity;
import com.example.beetle.R;

import java.util.Random;

public class SpriteUtil {

    public static Sprite createBackground(MainActivity mainActivity) {
        Bitmap image = BitmapFactory.decodeResource(mainActivity.getResources(),
                R.drawable.backgorund_1);
        Sprite sprite = new Sprite(image, new Position(0,0));
        sprite.setScale(1.8f);
        return sprite;
    }

    public static Beetle create(MainActivity mainActivity, FliesEnum fliesEnum, Position position) {
        Bitmap image = BitmapFactory.decodeResource(mainActivity.getResources(),
                fliesEnum.getDrawableId());
        Beetle beetle = new Beetle(image, position);
        beetle.setScale(0.2f);
        beetle.getShape().setScale(-(beetle.getScale()/2f));

        return beetle;
    }

    public static Beetle createRandom(MainActivity mainActivity) {
        int index = new Random().nextInt(FliesEnum.values().length);
        FliesEnum fliesEnum = FliesEnum.values()[index];
        Beetle beetle = create(mainActivity,fliesEnum,new Position(0,0));
        beetle.setType(fliesEnum.getType());
        beetle.randomCreate((int)mainActivity.getCore().getSceneWidth(),(int)mainActivity.getCore().getSceneHeight());
        return beetle;
    }

    public static Beetle createEvilIvan(MainActivity mainActivity, Position position) {
        Beetle beetle = create(mainActivity,FliesEnum.IVAN_EVIL,position);
        beetle.setName("IVAN_EVIL");
        beetle.setType(Beetle.Type.EVIL);
        return beetle;
    }

    public static Beetle createEvilLeva(MainActivity mainActivity, Position position) {
        Beetle beetle = create(mainActivity,FliesEnum.LEVA_EVIL,position);
        beetle.getShape().setHeight(500);
        beetle.getShape().setY(-10);
        beetle.setName("LEVA_EVIL");
        beetle.setType(Beetle.Type.EVIL);
        return beetle;
    }

    public static Beetle createEvilArkady(MainActivity mainActivity, Position position) {
        Beetle beetle = create(mainActivity,FliesEnum.ARKADY_EVIL,position);
        beetle.getShape().setHeight(300);
        beetle.getShape().setWidth(100);
        beetle.getShape().setY(-2);
        beetle.getShape().setX(-7);
        beetle.setName("ARKADY_EVIL");
        beetle.setType(Beetle.Type.EVIL);
        return beetle;
    }

    public static Beetle createEvilJora(MainActivity mainActivity, Position position) {
        Beetle beetle = create(mainActivity,FliesEnum.JORA_EVIL,position);
        beetle.getShape().setHeight(300);
        beetle.getShape().setWidth(-100);
        beetle.getShape().setY(+5);
        beetle.getShape().setX(-5);
        beetle.setName("JORA_EVIL");
        beetle.setType(Beetle.Type.EVIL);
        return beetle;
    }

    public static Beetle createEvilSema(MainActivity mainActivity, Position position) {
        Beetle beetle = create(mainActivity,FliesEnum.SEMA_EVIL,position);
        beetle.getShape().setHeight(500);
        beetle.getShape().setWidth(-100);
        beetle.getShape().setY(-10);
        beetle.getShape().setX(5);
        beetle.setName("SEMA_EVIL");
        beetle.setType(Beetle.Type.EVIL);
        return beetle;
    }

    public static Beetle createFlyKolya(MainActivity mainActivity, Position position) {
        Beetle beetle = create(mainActivity,FliesEnum.KOLYA_FLY,position);
        beetle.getShape().setHeight(400);
        beetle.getShape().setWidth(0);
        beetle.getShape().setY(0);
        beetle.getShape().setX(-5);
        beetle.setName("KOLYA_FLY");
        beetle.setType(Beetle.Type.FLY);
        return beetle;
    }

    public static Beetle createBindMatvey(MainActivity mainActivity, Position position) {
        Beetle beetle = create(mainActivity,FliesEnum.MATVEY_KIND,position);
        beetle.getShape().setHeight(300);
        beetle.getShape().setWidth(100);
        beetle.getShape().setY(+5);
        beetle.getShape().setX(-7);
        beetle.setName("MATVEY_KIND");
        beetle.setType(Beetle.Type.BIND);

        return beetle;
    }

    public static Beetle createBindMakar(MainActivity mainActivity, Position position) {
        Beetle beetle = create(mainActivity,FliesEnum.MAKAR_KIND,position);
        beetle.getShape().setHeight(300);
        beetle.getShape().setWidth(0);
        beetle.getShape().setY(13);
        beetle.getShape().setX(0);
        beetle.setName("MAKAR_KIND");
        beetle.setType(Beetle.Type.BIND);
        return beetle;
    }
}
