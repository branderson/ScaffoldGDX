package com.brad.ScaffoldGDX.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;

/**
 * Created by brad on 3/24/15.
 */
public class Target extends ObjectNode
{
    public Target(TextureAtlas atlas, String filename) {
        super(atlas, filename);
    }

    public void randomPosition() {
        getModel().setPosition((float) (16 * Math.floor(Math.random() * 40)), (float) (16 * Math.floor(Math.random() * 30)));
    }
}
