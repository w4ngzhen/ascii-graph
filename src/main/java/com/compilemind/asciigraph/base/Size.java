package com.compilemind.asciigraph.base;

import java.util.Objects;

/**
 * 尺寸
 */
public final class Size {
    private int width;
    private int height;

    public static Size of(int width, int height) {
        return new Size(width, height);
    }

    public static Size of(Size size) {
        return of(size.width, size.height);
    }

    private Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
