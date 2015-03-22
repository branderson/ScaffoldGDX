package com.brad.SnakeGDX.screen;

import com.badlogic.gdx.Screen;
import com.brad.SnakeGDX.SnakeGDX;

/**
 * Created by brad on 3/16/15.
 */
public abstract class AbstractScreen implements Screen
{
    protected SnakeGDX game;

    public AbstractScreen(SnakeGDX game) {
        this.game = game;
    }

    public void render(float delta) {}

    public void resize(int x, int y) {}

    public void show() {}

    public void hide() {}

    public void pause() {}

    public void resume() {}

    public void dispose() {}
}
