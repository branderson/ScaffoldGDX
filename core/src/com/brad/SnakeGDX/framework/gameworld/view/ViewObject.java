package com.brad.SnakeGDX.framework.gameworld.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.brad.SnakeGDX.framework.gameworld.SceneNode;
import com.brad.SnakeGDX.framework.gameworld.model.ModelObject;

/**
 * Created by brad on 3/22/15.
 */
public class ViewObject extends SceneNode
{
    private ModelObject modelObject;
    private TextureRegion region;
    private TextureAtlas atlas;

    public ViewObject(ModelObject object, TextureAtlas atlas) {
        this.modelObject = object;
        this.atlas = atlas;
        this.region = new TextureRegion();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(region, modelObject.getX(), modelObject.getY());
    }
}
