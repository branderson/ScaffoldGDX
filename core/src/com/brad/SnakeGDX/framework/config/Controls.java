package com.brad.SnakeGDX.framework.config;

import com.badlogic.gdx.Input;

import java.util.HashMap;

/**
 * Created by brad on 3/22/15.
 */
public class Controls
{
    public HashMap<Integer, Integer> controls;

    public Controls() {
        controls = new HashMap();
        controls.put(Input.Keys.ESCAPE, Input.Keys.ESCAPE);
    }

    public void setControl(int key, int newKey) {
        controls.put(key, newKey);
    }

    public int getControl(int key) {
        return controls.get(key);
    }
}
