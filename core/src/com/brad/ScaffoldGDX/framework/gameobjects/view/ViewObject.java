package com.brad.ScaffoldGDX.framework.gameobjects.view;

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
    public ModelObject model;
    public TextureRegion region;
    public TextureAtlas atlas;

//    public ViewObject() {
//        this.model = null;
//        this.atlas = null;
//        this.region = null;
//    }
//
//    public ViewObject(TextureAtlas atlas) {
//        this.atlas = atlas;
//        this.model = null;
//        this.region = null;
//    }

    public ViewObject(TextureAtlas atlas) {
        super();
        this.atlas = atlas;
    }

    public ViewObject(ModelObject model, TextureAtlas atlas) {
        super();
        this.model = model;
        this.atlas = atlas;
        this.region = new TextureRegion();
    }

    public ViewObject(ModelObject model, TextureAtlas atlas, String filename) {
        super();
        this.model = model;
        this.atlas = atlas;
        this.region = atlas.findRegion(filename);
    }

    public void draw(SpriteBatch batch) {
        if (region != null) {
            batch.draw(region, model.getX(), model.getY());
        }
    }

    @Override
    public void update() {
        super.update();
    }
}
