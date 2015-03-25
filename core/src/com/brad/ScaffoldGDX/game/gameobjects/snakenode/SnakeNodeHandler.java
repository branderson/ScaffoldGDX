package com.brad.ScaffoldGDX.game.gameobjects.snakenode;

import com.brad.ScaffoldGDX.framework.config.Controls;
import com.brad.ScaffoldGDX.framework.helpers.ObjectInputHandler;

/**
 * Created by brad on 3/24/15.
 */
public class SnakeNodeHandler extends ObjectInputHandler
{
    SnakeNode node;

    public SnakeNodeHandler(Controls controls, SnakeNode node) {
        this.controls = controls;
        this.node = node;
    }

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == controls.getControl("D")) {
            node.setDirection(0);
        } else if (keyCode == controls.getControl("W")) {
            node.setDirection(1);
        } else if (keyCode == controls.getControl("A")) {
            node.setDirection(2);
        } else if (keyCode == controls.getControl("S")) {
            node.setDirection(3);
        } else {
            return false;
        }
        return true;
    }
}
