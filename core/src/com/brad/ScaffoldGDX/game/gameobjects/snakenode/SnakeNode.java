package com.brad.ScaffoldGDX.game.gameobjects.snakenode;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;

/**
 * Created by brad on 3/23/15.
 */
public class SnakeNode extends ObjectNode
{
    public SnakeNode(TextureAtlas atlas) {
        super();
        model = new SnakeNodeModel();
        view = new SnakeNodeView((SnakeNodeModel) model, atlas);
    }
}
