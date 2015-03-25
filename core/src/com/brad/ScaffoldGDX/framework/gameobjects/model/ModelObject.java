package com.brad.ScaffoldGDX.framework.gameobjects.model;

import com.brad.ScaffoldGDX.framework.gameobjects.SceneNode;
import com.brad.ScaffoldGDX.framework.helpers.Tuples;

/**
 * Created by brad on 3/22/15.
 */
public class ModelObject extends SceneNode
{

    private Position position;

    public ModelObject() {
        super();
        this.position = new Position();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position newPosition) {
        position = newPosition;
    }

    public float getX() {
        return position.getX();
    }

    public float getY() {
        return position.getY();
    }

    public float getZ() { return position.getZ(); }

    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }

    public void setPosition(float x, float y, float z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }

    public void increment(float x, float y) {
        position.x += x;
        position.y += y;
    }

    public void increment(float x, float y, float z) {
        position.x += x;
        position.y += y;
        position.z += z;
    }

    public void increment(Tuples.Tuple2<Float, Float> direction, float distance) {
        position.x += direction.getT1() * distance;
        position.y += direction.getT2() * distance;
    }

    @Override
    public void update() {
        super.update();
    }

    public class Position
    {
        private float x;
        private float y;
        private float z;

        public Position() {
            this.x = 0;
            this.y = 0;
            this.z = 0;
        }

        public Position(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public float getZ() {
            return z;
        }

        public void setZ(float z) {
            this.z = z;
        }
    }
}
