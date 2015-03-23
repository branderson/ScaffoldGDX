package com.brad.ScaffoldGDX.framework.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by brad on 3/21/15.
 */
public abstract class AbstractGameObject
{
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private int width;
    private int height;
    private Texture texture;
    private TextureRegion region;

    public AbstractGameObject() {
    }

    public void draw(SpriteBatch batch) {
        batch.draw(region, position.x, position.y);
    }
}
