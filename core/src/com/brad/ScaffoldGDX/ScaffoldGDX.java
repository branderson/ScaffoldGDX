package com.brad.ScaffoldGDX;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brad.ScaffoldGDX.framework.config.ControlSettings;
import com.brad.ScaffoldGDX.game.screens.LevelScreen;

public class ScaffoldGDX extends Game
{
    public static final String TITLE = "ScaffoldGDX";
    public static final int WIDTH = 640, HEIGHT = 480;
    public ControlSettings controls;
    public AssetManager manager;
    public InputMultiplexer input;
    public SpriteBatch batch;

    public void create() {
        controls = new ControlSettings();
        manager = new AssetManager();
        input = new InputMultiplexer();
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(input);
        setScreen(new LevelScreen(this, 60, 60, WIDTH, HEIGHT));
    }

    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
