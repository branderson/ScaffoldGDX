package com.brad.ScaffoldGDX.game.gameobjects.snakenode;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.gameobjects.view.ViewObject;

/**
 * Created by brad on 3/23/15.
 */
public class SnakeNodeView extends ViewObject
{
    public SnakeNodeView(SnakeNodeModel model, TextureAtlas atlas) {
        super(atlas);
        this.model = model;
        this.region = atlas.findRegion("snakeNode");
    }
}
