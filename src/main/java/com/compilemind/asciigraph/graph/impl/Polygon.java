package com.compilemind.asciigraph.graph.impl;

import com.compilemind.asciigraph.graph.CanvasElement;

import java.util.List;
import java.util.stream.Collectors;

public class Polygon extends CanvasElement {

    private final List<Line> lines;

    public List<Line> getLines() {
        return lines;
    }

    public Polygon(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public List<Point> getPoints() {
        return this.getLines()
                .stream()
                .flatMap(line -> line.getPoints().stream())
                .collect(Collectors.toList());
    }
}
