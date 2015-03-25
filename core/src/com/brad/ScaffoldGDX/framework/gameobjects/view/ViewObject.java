package com.brad.ScaffoldGDX.framework.gameobjects.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.brad.ScaffoldGDX.framework.gameobjects.SceneNode;
import com.brad.ScaffoldGDX.framework.gameobjects.model.ModelObject;

/**
 * Created by brad on 3/22/15.
 */
public class ViewObject extends SceneNode
{
    public TextureRegion region;
    public TextureAtlas atlas;
    boolean drawable;
    private ModelObject model;

    public ViewObject(ModelObject model) {
        super();
        this.model = model;
        this.atlas = null;
        this.drawable = false;
    }

    public ViewObject(ModelObject model, TextureAtlas atlas) {
        super();
        this.model = model;
        this.atlas = atlas;
        this.region = new TextureRegion();
        this.drawable = true;
    }

    public ViewObject(ModelObject model, TextureAtlas atlas, String filename) {
        super();
        this.model = model;
        this.atlas = atlas;
        this.region = atlas.findRegion(filename);
        this.drawable = true;
    }

    public ModelObject getModel() {
        return model;
    }

    public void setModel(ModelObject model) {
        this.model = model;
    }

    public void draw(SpriteBatch batch) {
        // TODO: Use drawable here
        if (region != null && model != null) {
            batch.draw(region, getModel().getX(), getModel().getY());
        } else if (null == model) {
            Gdx.app.log("ViewObject", "Check here");
        }
    }

    @Override
    public void update() {
        super.update();
    }
}
