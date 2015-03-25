package com.brad.ScaffoldGDX.game.gameobjects.snakenode;

import com.brad.ScaffoldGDX.framework.config.ControlSettings;
import com.brad.ScaffoldGDX.framework.helpers.ObjectInputHandler;

/**
 * Created by brad on 3/24/15.
 */
public class SnakeNodeHandler extends ObjectInputHandler
{
    SnakeNode node;

    public SnakeNodeHandler(ControlSettings controls, SnakeNode node) {
        this.controls = controls;
        this.node = node;
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (controls.getControl("Right").compareTo(keyCode) == 0) {
            node.setDirection(0);
        } else if (controls.getControl("Up").compareTo(keyCode) == 0) {
            node.setDirection(1);
        } else if (controls.getControl("Left").compareTo(keyCode) == 0) {
            node.setDirection(2);
        } else if (controls.getControl("Down").compareTo(keyCode) == 0) {
            node.setDirection(3);
        } else {
            return false;
        }
        return true;
    }
}
