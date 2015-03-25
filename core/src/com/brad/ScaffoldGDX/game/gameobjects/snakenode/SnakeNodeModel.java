package com.brad.ScaffoldGDX.game.gameobjects.snakenode;

import com.brad.ScaffoldGDX.framework.gameobjects.model.ModelObject;
import com.brad.ScaffoldGDX.framework.helpers.Tuples;

/**
 * Created by brad on 3/23/15.
 */
public class SnakeNodeModel extends ModelObject
{
    public int frame;
    public Tuples.Tuple2<Float, Float> direction;
    public float speed;  // Movements per second

    public SnakeNodeModel() {
        frame = 0;
        direction = new Tuples.Tuple2<Float, Float>(1f, 0f);
        speed = 5f;
    }
}
