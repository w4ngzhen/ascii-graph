package com.compilemind.asciigraph.graph;

import com.compilemind.asciigraph.base.Symbol;
import com.compilemind.asciigraph.canvas.Canvas;
import com.compilemind.asciigraph.graph.impl.Point;

import java.util.List;

public abstract class AsciiGraphElement {

    protected Symbol border = Symbol.PLUS;

    protected Symbol background = Symbol.BLANK;

    public Symbol getBorder() {
        return border;
    }

    public void setBorder(Symbol border) {
        this.border = border;
    }

    public Symbol getBackground() {
        return background;
    }

    public void setBackground(Symbol background) {
        this.background = background;
    }

    public abstract List<Point> getPoints();

    public void renderAt(Canvas canvas) {
        canvas.render(this.getPoints());
    }
}
