package com.compilemind.asciigraph.canvas;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.graph.impl.Point;

public class Render {

    private final Canvas canvas;

    public Render(Canvas canvas) {
        this.canvas = canvas;
    }

    public void draw(Point point) {
        canvas.render(point);
    }

    public void draw(Coordinate coordinate, char content) {
        canvas.render(coordinate, content);
    }
}
