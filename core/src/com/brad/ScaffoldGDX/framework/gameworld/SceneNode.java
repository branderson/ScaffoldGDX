package com.brad.ScaffoldGDX.framework.gameworld;

import com.badlogic.gdx.utils.Pool;

import java.util.LinkedList;

/**
 * Created by brad on 3/22/15.
 */
public class SceneNode implements Pool.Poolable
{
    protected LinkedList<SceneNode> childList;
    private boolean live;

    public SceneNode() {
        childList = new LinkedList<SceneNode>();
        live = true;
    }

    public void update() {
        for (SceneNode childNode : childList) {
            childNode.update();
        }
    }

    void addChild(SceneNode node) {
        childList.add(node);
    }

    public void release() {
        live = false;
    }

    public void destroy() {
        for (SceneNode childNode : childList) {
            childNode.destroy();
        }
        childList.clear();
        this.release();
    }

    public LinkedList<SceneNode> getAllNodes() {
        return childList;
    }

    @Override
    public void reset() {
        this.destroy();
    }
}
