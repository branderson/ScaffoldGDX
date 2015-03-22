package com.brad.SnakeGDX.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.brad.SnakeGDX.SnakeGDX;

public class DesktopLauncher
{
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "SnakeGDX";
        config.width = 640;
        config.height = 480;
        new LwjglApplication(new SnakeGDX(), config);
    }
}
