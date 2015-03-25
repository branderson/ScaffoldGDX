package com.brad.ScaffoldGDX.framework.screen;

import com.badlogic.gdx.Screen;
import com.brad.ScaffoldGDX.ScaffoldGDX;
import com.brad.ScaffoldGDX.framework.config.ControlSettings;
import com.brad.ScaffoldGDX.framework.helpers.ScreenInputHandler;

/**
 * Created by brad on 3/16/15.
 */
public abstract class AbstractScreen implements Screen
{
    protected ScaffoldGDX game;
    private ScreenInputHandler handler;
    private ControlSettings controls;

    public AbstractScreen(ScaffoldGDX game) {
        this.game = game;
        this.controls = game.controls;
        handler = new ScreenInputHandler(this);
    }

    public ControlSettings getControls() {
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
