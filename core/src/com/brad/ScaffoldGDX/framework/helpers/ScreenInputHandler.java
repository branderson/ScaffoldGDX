package com.brad.ScaffoldGDX.framework.helpers;

import com.brad.ScaffoldGDX.framework.config.Controls;
import com.brad.ScaffoldGDX.framework.screen.AbstractScreen;

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
        if (keycode == controls.getControl("Quit")) {
            screen.escape();
            return true;
        }
        return false;
    }
}
