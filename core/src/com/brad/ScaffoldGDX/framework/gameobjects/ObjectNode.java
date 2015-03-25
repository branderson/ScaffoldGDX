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
    }

    public ObjectNode(TextureAtlas atlas) {
        model = new ModelObject();
        view = new ViewObject(model, atlas);
    }

    public ObjectNode(TextureAtlas atlas, String filename) {
        model = new ModelObject();
        view = new ViewObject(model, atlas, filename);
    }

    @Override
    public int compareTo(SceneNode o) {
        if (o instanceof ObjectNode) {
            ObjectNode node = (ObjectNode) o;
            if (getModel().getZ() > node.getModel().getZ()) {
                return 1;
            } else if (getModel().getZ() == node.getModel().getZ()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public ModelObject getModel() {
        return model;
    }

    public void setModel(ModelObject model) {
        this.model = model;
    }

    public ViewObject getView() {
        return view;
    }

    public void setView(ViewObject view) {
        this.view = view;
    }

    public void addChild(ObjectNode node) {
        childList.add(node);
    }

    @Override
    public void update() {
        super.update();

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
