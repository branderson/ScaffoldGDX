package com.brad.ScaffoldGDX.framework.gameworld;

import com.badlogic.gdx.utils.Pool;

/**
 * Created by brad on 3/23/15.
 */
public class ObjectNodePool extends Pool<ObjectNode>
{
    public ObjectNode newObject() {
        return new ObjectNode();
    }
}
