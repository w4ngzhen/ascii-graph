package com.compilemind.asciigraph.graph.impl;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.Symbol;
import com.compilemind.asciigraph.util.MathUtil;
import com.compilemind.asciigraph.graph.AsciiGraphElement;

import java.util.List;
import java.util.stream.Collectors;

public class Line extends AsciiGraphElement {

    private final Coordinate begin;

    private final Coordinate end;

    public static Line of(Coordinate begin, Coordinate end) {
        return new Line(Coordinate.of(begin), Coordinate.of(end));
    }

    private Line(Coordinate begin, Coordinate end) {
        this.begin = begin;
        this.end = end;
        this.border = Symbol.PLUS;
    }

    @Override
    public List<Point> getPoints() {
        return MathUtil.getCoordinatesBetween(begin, end)
                .stream()
                .map(coordinate -> Point.of(coordinate, this.border))
                .collect(Collectors.toList());
    }

}
