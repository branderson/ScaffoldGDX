package com.brad.ScaffoldGDX.framework.helpers;

import com.brad.ScaffoldGDX.framework.config.ControlSettings;
import com.brad.ScaffoldGDX.framework.screen.AbstractScreen;

/**
 * Created by brad on 3/22/15.
 */
public class ScreenInputHandler extends AbstractInputHandler
{
    private AbstractScreen screen;
    private ControlSettings controls;

    public ScreenInputHandler(AbstractScreen screen) {
        this.screen = screen;
        this.controls = screen.getControls();
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (controls.getControl("Quit").compareTo(keyCode) == 0) {
            screen.escape();
            return true;
        }
        return false;
    }
}
