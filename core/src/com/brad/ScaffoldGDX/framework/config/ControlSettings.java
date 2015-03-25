package com.brad.ScaffoldGDX.framework.config;

import com.badlogic.gdx.Input;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by brad on 3/22/15.
 */
public class ControlSettings
{
    private Controls controls;

    public ControlSettings() {

        controls = new Controls();

        setControl("Quit", Input.Keys.ESCAPE);
        setControl("Up", Input.Keys.W);
        setControl("Up", Input.Keys.UP);
        setControl("Down", Input.Keys.S);
        setControl("Down", Input.Keys.DOWN);
        setControl("Left", Input.Keys.A);
        setControl("Left", Input.Keys.LEFT);
        setControl("Right", Input.Keys.D);
        setControl("Right", Input.Keys.RIGHT);
    }

    public void setControl(String key, int newKey) {
        if (controls.containsKey(key)) {
            controls.get(key).add(newKey);
//            Gdx.app.log(key, Integer.toString(newKey));
        } else {
            controls.put(key, new Control());
            setControl(key, newKey);
        }
    }

    public Control getControl(String key) {
        return controls.get(key);
    }

    public class Control extends LinkedList<Integer> implements Comparable<Integer>
    {
        @Override
        public int compareTo(Integer keyCode) {
            for (Integer key : this) {
                if (keyCode.equals(key)) {
                    return 0;
                }
            }
            return -1;
        }
    }

    class Controls extends HashMap<String, Control>
    {
    }
}
