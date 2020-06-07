package com.compilemind.asciigraph.graph.impl;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.Size;
import com.compilemind.asciigraph.base.Symbol;
import com.compilemind.asciigraph.graph.AsciiGraphElement;
import com.compilemind.asciigraph.util.MathUtil;
import com.compilemind.asciigraph.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rectangle extends AsciiGraphElement {

    private Coordinate location;

    private Size size;

    /**
     * 0-4: left, top, right, bottom
     */
    private List<Line> lines;

    public Coordinate getLocation() {
        return Coordinate.of(this.location);
    }

    public Size getSize() {
        return Size.of(this.size);
    }

    public Line getLeft() {
        return this.lines.get(0);
    }

    public Line getTop() {
        return this.lines.get(1);
    }

    public Line getRight() {
        return this.lines.get(2);
    }

    public Line getBottom() {
        return this.lines.get(3);
    }

    public void setLocation(Coordinate location) {
        this.location = Coordinate.of(location);
        this.revise();
    }

    public void setSize(Size size) {
        this.size = Size.of(size);
        this.revise();
    }

    public Rectangle(Coordinate location, Size size) {
        this.location = Coordinate.of(location);
        this.size = Size.of(size);
        this.revise();
    }

    private void revise() {
        this.lines = MathUtil.getRectangleLines(
                location,
                Coordinate.of(location.getX() + size.getWidth() - 1, location.getY() + size.getHeight() - 1)
        );
    }

    @Override
    public List<Point> getPoints() {
        int width = size.getWidth();
        int height = size.getHeight();
        List<Point> points = new ArrayList<>(width * height);
        for (int rowIdx = 1; rowIdx < height - 1; rowIdx++) {
            for (int colIdx = 1; colIdx < width - 1; colIdx++) {
                Point fill = Point.of(
                        Coordinate.of(this.location.getX() + colIdx, this.location.getY() + rowIdx),
                        this.background
                );
                points.add(fill);
            }
        }
        List<Point> borderPoints = this.lines
                .stream()
                .flatMap(line -> line.getPoints().stream())
                .peek(point -> point.setContent(this.border == Symbol.NONE ? this.background : this.border))
                .collect(Collectors.toList());
        points.addAll(borderPoints);
        return points;
    }
}
