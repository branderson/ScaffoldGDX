package com.brad.ScaffoldGDX.game.gameobjects.snakenode;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.gameobjects.view.ViewObject;

/**
 * Created by brad on 3/23/15.
 */
public class SnakeNodeView extends ViewObject
{
    private SnakeNodeModel model;

    public SnakeNodeView(SnakeNodeModel model, TextureAtlas atlas) {
        super(model, atlas);
        this.model = model;
        this.region = atlas.findRegion("snakeNode");
    }

    public SnakeNodeModel getModel() {
        return model;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(region, model.getX(), model.getY());
    }
}
