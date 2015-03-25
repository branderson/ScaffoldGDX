package com.brad.ScaffoldGDX.framework.config;

import com.badlogic.gdx.Input;

import java.util.HashMap;

/**
 * Created by brad on 3/22/15.
 */
public class Controls
{
    public HashMap<String, Integer> controls;

    public Controls() {
        controls = new HashMap();
        controls.put("Quit", Input.Keys.ESCAPE);
        controls.put("W", Input.Keys.W);
        controls.put("S", Input.Keys.S);
        controls.put("A", Input.Keys.A);
        controls.put("D", Input.Keys.D);
    }

    public void setControl(String key, int newKey) {
        controls.put(key, newKey);
    }

    public int getControl(String key) {
        return controls.get(key);
    }
}
