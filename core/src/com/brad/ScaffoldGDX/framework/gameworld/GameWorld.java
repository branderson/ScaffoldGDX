package com.brad.ScaffoldGDX.framework.gameworld;

import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNodePool;

/**
 * Created by brad on 3/20/15.
 */
public class GameWorld
{
    public ObjectNode scene;
    public ObjectNode background;
    private ObjectNodePool objectNodePool;

    public GameWorld(int xWidth, int yHeight) {
        objectNodePool = new ObjectNodePool();
        scene = objectNodePool.obtain();  // Scene is drawn with blending
        background = objectNodePool.obtain(); // Background is drawn without blending
    }

    public ObjectNode getScene() {
        return scene;
    }

    public ObjectNode getBackground() {
        return background;
    }

    public void setBackground(ObjectNode background) {
        this.background = background;
    }

    public ObjectNodePool getObjectNodePool() {
        return objectNodePool;
    }

    public void update() {
        background.update();
        scene.update();
    }
}
