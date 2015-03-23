package com.brad.ScaffoldGDX.framework.gameworld.view;

import com.badlogic.gdx.utils.Pool;

import java.util.LinkedList;

/**
 * Created by brad on 3/22/15.
 */
public class ViewLayer extends LinkedList<ViewObject> implements Pool.Poolable
{

    @Override
    public void reset() {
        this.clear();
    }
}

