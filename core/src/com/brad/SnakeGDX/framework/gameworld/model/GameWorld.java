package com.brad.SnakeGDX.framework.gameworld.model;

import com.brad.SnakeGDX.framework.gameworld.ObjectNode;
import com.brad.SnakeGDX.framework.gameworld.ObjectNodePool;
import com.brad.SnakeGDX.framework.gameworld.SceneNode;

/**
 * Created by brad on 3/20/15.
 */
public class GameWorld
{
    private ObjectNodePool objectNodePool;
    private ObjectNode scene;

    public GameWorld(int xWidth, int yHeight) {
        objectNodePool = new ObjectNodePool();
        scene = objectNodePool.obtain();
    }

    public ObjectNode getScene() {
        return scene;
    }

    public ObjectNodePool getObjectNodePool() {
        return objectNodePool;
    }

    public void update() {
        scene.update();
    }
}
