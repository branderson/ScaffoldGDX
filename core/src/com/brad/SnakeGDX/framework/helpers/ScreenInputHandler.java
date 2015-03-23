package com.brad.SnakeGDX.framework.helpers;

import com.badlogic.gdx.Input;
import com.brad.SnakeGDX.framework.config.Controls;
import com.brad.SnakeGDX.framework.screen.AbstractScreen;

/**
 * Created by brad on 3/22/15.
 */
public class ScreenInputHandler extends AbstractInputHandler
{
    private AbstractScreen screen;
    private Controls controls;

    public ScreenInputHandler(AbstractScreen screen) {
        this.screen = screen;
        this.controls = screen.getControls();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == controls.getControl(Input.Keys.ESCAPE)) {
            screen.escape();
            return true;
        }
        return false;
    }
}
