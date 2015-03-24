package com.brad.ScaffoldGDX.framework.gameobjects;

import com.badlogic.gdx.utils.Pool;

import java.util.LinkedList;

/**
 * Created by brad on 3/23/15.
 */
public class NodeSort
{
    private final Pool<LinkedList<? extends SceneNode>> listPool = new Pool<LinkedList<? extends SceneNode>>()
    {
        @Override
        protected LinkedList<? extends SceneNode> newObject() {
            return new LinkedList();
        }
    };

    public LinkedList<? extends SceneNode> sort(LinkedList<? extends SceneNode> list) {
        // If no children, nothing to sort
        if (null == list) {
            return null;
        }

        // Base case
        if (list.size() <= 1) {
            return list;
        }

        // Recursive case. Divide list in half
        LinkedList left = listPool.obtain();
        LinkedList right = listPool.obtain();

        for (int i = 0; i < list.size() / 2; i++) {
            left.add(list.get(i));
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            right.add(list.get(i));
        }

        // Recursively sort sublists
        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private LinkedList<? extends SceneNode> merge(LinkedList<? extends SceneNode> left, LinkedList<? extends SceneNode> right) {
        LinkedList result = listPool.obtain();

//        while (left.size() > 0 && right.size() > 0) {
//            if (left.getFirst() <= right.getFirst()) {
//                result.add(left.getFirst());
//                left.removeFirst();
//            } else {
//                result.add(right.getFirst());
//                right.removeFirst();
//            }
//        }

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
