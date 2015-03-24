package com.brad.ScaffoldGDX.framework.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.gameobjects.model.ModelObject;
import com.brad.ScaffoldGDX.framework.gameobjects.view.ViewObject;

import java.util.LinkedList;

/**
 * Created by brad on 3/22/15.
 */
public class ObjectNode extends SceneNode
{
    protected ModelObject model;
    protected ViewObject view;

    public ObjectNode() {
        // TODO: Make child objects part of childList, implement their destroys
        super();
//        childList = new LinkedList();
        model = null;
        view = null;
    }

    public ObjectNode(TextureAtlas atlas) {
        super();
//        childList = new LinkedList();
        model = new ModelObject();
        view = new ViewObject(model, atlas);
    }

    public ObjectNode(TextureAtlas atlas, String filename) {
        super();
//        childList = new LinkedList();
        model = new ModelObject();
        view = new ViewObject(model, atlas, filename);
    }

    @Override
    public int compareTo(SceneNode o) {
        ObjectNode node = (ObjectNode) o;
        if (model.getZ() > node.getModel().getZ()) {
            return 1;
        } else if (model.getZ() == node.getModel().getZ()) {
            return 0;
        } else {
            return -1;
        }
    }

    public ModelObject getModel() {
        return model;
    }

    public ViewObject getView() {
        return view;
    }

    public void addChild(ObjectNode node) {
        childList.add(node);
    }

    public void setAtlas(TextureAtlas atlas) {
    }

    @Override
    public void update() {
        super.update();
//        for (ObjectNode node : childList) {
//            node.update();
//        }
        if (null != model) {
            model.update();
        }
        if (null != view) {
            view.update();
        }
    }

    public int getChildListLength() {
        return childList.size();
    }

    public LinkedList<? extends SceneNode> getAllObjectNodes() {
        return childList;
    }

    public LinkedList<? extends SceneNode> getOrderedObjectNodes() {
        sortNodes();
        return getAllObjectNodes();
    }

    public void destroy() {
        super.destroy();
        if (null != model) {
            model.destroy();
        }
        if (null != view) {
            view.destroy();
        }
    }
}
