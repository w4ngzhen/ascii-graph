package com.compilemind.asciigraph.graph.impl;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.Symbol;
import com.compilemind.asciigraph.graph.CanvasElement;

import java.util.Collections;
import java.util.List;

public class Point extends CanvasElement {

    private final Coordinate coordinate;

    private Symbol content;

    public Coordinate getCoordinate() {
        return Coordinate.of(this.coordinate);
    }

    public Symbol getContent() {
        return content;
    }

    public void setContent(Symbol content) {
        this.content = content;
    }

    public static Point of() {
        return of(Coordinate.of());
    }

    public static Point of(Coordinate coordinate) {
        return of(coordinate, Symbol.NONE);
    }

    public static Point of(Point point) {
        return of(point.coordinate, point.content);
    }

    public static Point of(Coordinate coordinate, Symbol content) {
        return new Point(coordinate, content);
    }

    private Point(Coordinate coordinate, Symbol content) {
        this.coordinate = Coordinate.of(coordinate);
        this.content = content;
    }

    @Override
    public List<Point> getPoints() {
        return Collections.singletonList(this);
    }

}
