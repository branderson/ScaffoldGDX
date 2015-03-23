package com.brad.ScaffoldGDX.framework.gameworld.model;

import com.brad.ScaffoldGDX.framework.gameworld.ObjectNode;
import com.brad.ScaffoldGDX.framework.gameworld.ObjectNodePool;

/**
 * Created by brad on 3/20/15.
 */
public class GameWorld
{
    private ObjectNodePool objectNodePool;
    private ObjectNode scene;
    private ObjectNode background;

    public GameWorld(int xWidth, int yHeight) {
        objectNodePool = new ObjectNodePool();
        scene = objectNodePool.obtain();  // Scene is drawn with blending
        background = objectNodePool.obtain(); // Background is drawn without blending
    }

    public ObjectNode getScene() {
        return scene;
    }

    public ObjectNode getBackground() { return background; }

    public ObjectNodePool getObjectNodePool() {
        return objectNodePool;
    }

    public void update() {
        scene.update();
    }
}
