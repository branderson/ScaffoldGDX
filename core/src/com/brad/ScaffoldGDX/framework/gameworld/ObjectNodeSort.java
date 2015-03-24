package com.brad.ScaffoldGDX.framework.gameworld;

import com.badlogic.gdx.utils.Pool;

import java.util.LinkedList;

/**
 * Created by brad on 3/23/15.
 */
public class ObjectNodeSort {
    private final Pool<LinkedList<ObjectNode>> listPool = new Pool<LinkedList<ObjectNode>>() {
        @Override
        protected LinkedList<ObjectNode> newObject() {
            return new LinkedList<ObjectNode>();
        }
    };

    public LinkedList<ObjectNode> sort(LinkedList<ObjectNode> list) {
        // If no children, nothing to sort
        if (null == list) {
            return null;
        }

        // Base case
        if (list.size() <= 1) {
            return list;
        }

        // Recursive case. Divide list in half
        LinkedList<ObjectNode> left = listPool.obtain();
        LinkedList<ObjectNode> right = listPool.obtain();

        for (int i = 0; i < list.size()/2; i++) {
            left.add(list.get(i));
        }
        for (int i = list.size()/2; i < list.size(); i++) {
            right.add(list.get(i));
        }

        // Recursively sort sublists
        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private LinkedList<ObjectNode> merge(LinkedList<ObjectNode> left, LinkedList<ObjectNode> right) {
        LinkedList<ObjectNode> result = listPool.obtain();

        while (left.size() > 0 && right.size() > 0) {
            if (left.getFirst().model.getZ() <= right.getFirst().model.getZ()) {
                result.add(left.getFirst());
                left.removeFirst();
            } else {
                result.add(right.getFirst());
                right.removeFirst();
            }
        }

        while (left.size() > 0) {
            result.add(left.getFirst());
            left.removeFirst();
        }
        while (right.size() > 0) {
            result.add(right.getFirst());
            right.removeFirst();
        }
        return result;
    }
}
