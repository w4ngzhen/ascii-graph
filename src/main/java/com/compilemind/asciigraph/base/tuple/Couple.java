package com.compilemind.asciigraph.base.tuple;

public class Couple<L, R> {

    private final L left;

    private final R right;

    public Couple(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

}
