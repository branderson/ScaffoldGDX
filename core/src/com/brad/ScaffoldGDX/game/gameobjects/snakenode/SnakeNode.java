package com.brad.ScaffoldGDX.game.gameobjects.snakenode;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.config.ControlSettings;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;

/**
 * Created by brad on 3/23/15.
 */
public class SnakeNode extends ObjectNode
{
    static int index = 0;
    SnakeNodeModel model;
    SnakeNodeView view;
    SnakeNodeHandler handler;

    public SnakeNode(TextureAtlas atlas, ControlSettings controls) {
        model = new SnakeNodeModel();
        view = new SnakeNodeView(model, atlas);
        if (index == 0) {
            handler = new SnakeNodeHandler(controls, this);
        } else {
            handler = null;
        }
        index++;
    }

    public void setDirection(int direction) {
        switch (direction) {
            case 0:
                if ((model.direction.getT1() != -1 || model.direction.getT2() != 0) && model.canTurn) {
                    model.direction.setT1(1f);
                    model.direction.setT2(0f);
                    model.canTurn = false;
                }
                break;
            case 1:
                if ((model.direction.getT1() != 0 || model.direction.getT2() != -1) && model.canTurn) {
                    model.direction.setT1(0f);
                    model.direction.setT2(1f);
                    model.canTurn = false;
                }
                break;
            case 2:
                if ((model.direction.getT1() != 1 || model.direction.getT2() != 0) && model.canTurn) {
                    model.direction.setT1(-1f);
                    model.direction.setT2(0f);
                    model.canTurn = false;
                }
                break;
            case 3:
                if ((model.direction.getT1() != 0 || model.direction.getT2() != 1) && model.canTurn) {
                    model.direction.setT1(0f);
                    model.direction.setT2(-1f);
                    model.canTurn = false;
                }
                break;
            default:
                break;
        }
    }

    public SnakeNodeHandler getHandler() {
        return handler;
    }

    public SnakeNodeModel getModel() {
        return model;
    }

    public SnakeNodeView getView() {
        return view;
    }

    @Override
    public void update() {
        super.update();
        model.frame++;
        if (model.frame > 60 / model.speed) {
            model.frame = 0;
            model.increment(model.direction, 16);
            model.canTurn = true;
        }
    }
}
