package com.brad.ScaffoldGDX.game.gameobjects.background;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;
import com.brad.ScaffoldGDX.framework.gameobjects.model.ModelObject;
import com.brad.ScaffoldGDX.framework.gameobjects.view.ViewObject;

/**
 * Created by brad on 3/23/15.
 */
public class BackgroundNode extends ObjectNode
{
    public BackgroundNode(TextureAtlas atlas) {
        model = new ModelObject()
        {
            @Override
            public void update() {
                super.update();
            }
        };
        view = new ViewObject(model, atlas, "grid");
    }
}
