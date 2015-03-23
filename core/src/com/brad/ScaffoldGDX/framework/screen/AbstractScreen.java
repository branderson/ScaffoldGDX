package com.brad.ScaffoldGDX.framework.screen;

import com.badlogic.gdx.Screen;
import com.brad.ScaffoldGDX.framework.config.Controls;
import com.brad.ScaffoldGDX.framework.helpers.ScreenInputHandler;

/**
 * Created by brad on 3/16/15.
 */
public abstract class AbstractScreen implements Screen
{
    protected SnakeGDX game;
    private ScreenInputHandler handler;
    private Controls controls;

    public AbstractScreen(SnakeGDX game) {
        this.game = game;
        this.controls = game.controls;
        handler = new ScreenInputHandler(this);
    }

    public Controls getControls() {
        return controls;
    }

    public void escape() {
    }

    public void render(float delta) {
    }

    public void resize(int x, int y) {
    }

    public void show() {
        game.input.addProcessor(handler);
    }

    public void hide() {
        game.input.removeProcessor(handler);
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
    }
}
