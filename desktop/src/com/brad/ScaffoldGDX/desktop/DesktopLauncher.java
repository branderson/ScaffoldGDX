package com.brad.ScaffoldGDX.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.brad.ScaffoldGDX.ScaffoldGDX;

public class DesktopLauncher
{
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "ScaffoldGDX";
        config.width = 640;
        config.height = 480;

        // TexturePacker
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.maxWidth = 512;
        settings.maxHeight = 512;
        TexturePacker.process(settings, "sprites/game", "sprites/packed/game", "game");
        TexturePacker.process(settings, "sprites/ui", "sprites/packed/ui", "ui");
        TexturePacker.process(settings, "sprites/env", "sprites/packed/env", "env");

        new LwjglApplication(new ScaffoldGDX(), config);
    }
}
