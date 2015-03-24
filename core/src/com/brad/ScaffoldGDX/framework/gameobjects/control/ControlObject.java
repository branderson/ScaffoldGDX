package com.brad.ScaffoldGDX.framework.gameobjects.control;

import com.brad.ScaffoldGDX.framework.gameobjects.SceneNode;
import com.brad.ScaffoldGDX.framework.gameobjects.model.ModelObject;
import com.brad.ScaffoldGDX.framework.gameobjects.view.ViewObject;

/**
 * Created by brad on 3/22/15.
 */
public class ControlObject extends SceneNode
{
    public ModelObject model;
    public ViewObject view;

    public ControlObject() {
        model = null;
    }

    public ControlObject(ModelObject model) {
        this.model = model;
    }

    public ControlObject(ModelObject model, ViewObject view) {
        this.model = model;
        this.view = view;
    }
}
