package com.brad.ScaffoldGDX.game.gameobjects.SnakeNode;

import com.brad.ScaffoldGDX.framework.gameworld.ObjectNode;

/**
 * Created by brad on 3/23/15.
 */
public class SnakeNode extends ObjectNode
{
    public SnakeNode() {
        super();
        model = new SnakeNodeModel();
        view = new SnakeNodeView(model);
        control = new SnakeNodeControl(model);
    }
}
