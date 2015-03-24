package com.brad.ScaffoldGDX.game.gameobjects.background;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.gameobjects.view.ViewObject;

/**
 * Created by brad on 3/23/15.
 */
public class BackgroundNodeView extends ViewObject
{
    // TODO: Why can't this take a BackgroundNodeModel
    public BackgroundNodeView(BackgroundNodeModel model, TextureAtlas atlas) {
        super(atlas);
        this.model = model;
        this.region = atlas.findRegion("grid");
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }
}
