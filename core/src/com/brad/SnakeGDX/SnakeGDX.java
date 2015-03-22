package com.brad.SnakeGDX;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brad.SnakeGDX.screen.GameScreen;
import com.brad.SnakeGDX.screen.LoadingScreen;

import java.util.LinkedList;

public class SnakeGDX extends Game
{
    public static final String TITLE = "SnakeGDX";
    public static final int WIDTH = 640, HEIGHT = 480;
    public AssetManager manager;

    public void create() {
        manager = new AssetManager();
        setScreen(new GameScreen(this));
    }

    @Override
    public void dispose() {
        manager.dispose();
    }
}
