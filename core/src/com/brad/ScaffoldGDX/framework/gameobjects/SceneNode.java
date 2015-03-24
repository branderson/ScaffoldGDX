package com.brad.ScaffoldGDX.framework.gameobjects;

import com.badlogic.gdx.utils.Pool;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by brad on 3/22/15.
 */
public class SceneNode implements Pool.Poolable, Comparable<SceneNode>
{
    // TODO: Figure out way to use inheritance with childList
    public LinkedList<SceneNode> childList;
    protected NodeSort sort;
    private boolean live;

    public SceneNode() {
        childList = new LinkedList();
        live = true;
    }

    public void update() {
        for (SceneNode node : childList) {
            node.update();
        }
    }

    public void addChild(SceneNode node) {
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

    public void sortNodes() {
//        sort.sort(childList);
        Collections.sort(childList);
        for (SceneNode node : childList) {
//            node.sortNodes();
            Collections.sort(node.childList);
        }
    }

    @Override
    public void reset() {
        this.destroy();
    }

    @Override
    public int compareTo(SceneNode o) {
        return 0;
    }
}
