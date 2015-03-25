package com.brad.ScaffoldGDX.framework.helpers;

import com.brad.ScaffoldGDX.framework.config.ControlSettings;
import com.brad.ScaffoldGDX.framework.gameobjects.ObjectNode;

/**
 * Created by brad on 3/24/15.
 */
public class ObjectInputHandler extends AbstractInputHandler
{
    public ObjectNode node;
    public ControlSettings controls;

    public ObjectInputHandler() {
    }

    public ObjectInputHandler(ControlSettings controls, ObjectNode node) {
        this.controls = controls;
        this.node = node;
    }
}
