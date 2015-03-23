package com.brad.SnakeGDX.framework.gameworld;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.SnakeGDX.framework.gameworld.control.ControlObject;
import com.brad.SnakeGDX.framework.gameworld.model.ModelObject;
import com.brad.SnakeGDX.framework.gameworld.view.ViewObject;

import java.util.LinkedList;

/**
 * Created by brad on 3/22/15.
 */
public class ObjectNode extends SceneNode
{
    protected LinkedList<ObjectNode> childList;
    public ModelObject model;
    public ViewObject view;
    public ControlObject control;
    private ObjectNodeSort sort;

    public ObjectNode() {
        // TODO: Make child objects part of childList, implement their destroys
        super();
        model = null;
        view = null;
        control = null;
        sort = new ObjectNodeSort();
    }

    public ObjectNode(TextureAtlas atlas) {
        super();
    }

    public void setAtlas(TextureAtlas atlas) {
    }

    public LinkedList<ObjectNode> getAllObjectNodes() {
        return childList;
    }

    public LinkedList<ObjectNode> getOrderedObjectNodes() {
        sortNodes();
        return getAllObjectNodes();
    }

    public void sortNodes() {
        sort.sort(childList);
        for (ObjectNode node : childList) {
            node.sortNodes();
        }
    }

    public void destroy() {
        super.destroy();
    }
}