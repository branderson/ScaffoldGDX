package com.brad.ScaffoldGDX.game.gameobjects.background;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;
import com.brad.ScaffoldGDX.framework.gameobjects.model.ModelObject;

/**
 * Created by brad on 3/23/15.
 */
public class BackgroundNode extends ObjectNode
{
    public BackgroundNode(TextureAtlas atlas) {
        super();
        model = new BackgroundNodeModel();
        view = new BackgroundNodeView((BackgroundNodeModel) model, atlas);
    }

    public ModelObject getModel() {
        return model;
    }
}
