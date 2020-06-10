package com.compilemind.asciigraph.base.tuple;

public class Triple<E1, E2, E3> {
    private final E1 left;
    private final E2 middle;
    private final E3 right;

    public Triple(E1 left, E2 middle, E3 right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public E1 getLeft() {
        return left;
    }

    public E2 getMiddle() {
        return middle;
    }

    public E3 getRight() {
        return right;
    }
}
