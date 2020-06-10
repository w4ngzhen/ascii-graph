package com.compilemind.asciigraph.graph.impl;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.Symbol;
import com.compilemind.asciigraph.base.tuple.Triple;
import com.compilemind.asciigraph.canvas.Render;
import com.compilemind.asciigraph.graph.CanvasElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Triangle extends CanvasElement {

    private final Triple<Point, Point, Point> pointTriple;

    private final Coordinate coordinate;

    public Triangle(Triple<Point, Point, Point> pointTriple) {
        Point point1 = Point.of(pointTriple.getLeft());
        Point point2 = Point.of(pointTriple.getMiddle());
        Point point3 = Point.of(pointTriple.getRight());
        this.pointTriple = new Triple<>(point1, point2, point3);
        int x = Math.min(Math.min(
                point1.getCoordinate().getX(),
                point2.getCoordinate().getX()),
                point3.getCoordinate().getX());
        int y = Math.min(Math.min(
                point1.getCoordinate().getY(),
                point2.getCoordinate().getY()),
                point3.getCoordinate().getY());
        this.coordinate = Coordinate.of(x, y);
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this(new Triple<>(point1, point2, point3));
    }

    public Triple<Point, Point, Point> getPointTriple() {
        return new Triple<>(pointTriple.getLeft(), pointTriple.getMiddle(), pointTriple.getRight());
    }

    public Coordinate getCoordinate() {
        return Coordinate.of(this.coordinate);
    }

    @Override
    public List<Point> getPoints() {
        Coordinate coordinate1 = pointTriple.getLeft().getCoordinate();
        Coordinate coordinate2 = pointTriple.getMiddle().getCoordinate();
        Coordinate coordinate3 = pointTriple.getRight().getCoordinate();
        List<Line> lines = Arrays.asList(
                Line.of(coordinate1, coordinate2),
                Line.of(coordinate2, coordinate3),
                Line.of(coordinate3, coordinate1)
        );
        List<Point> borderPoints = lines
                .stream()
                .flatMap(line -> line.getPoints().stream())
                .peek(point -> point.setContent(this.border == Symbol.NONE ? this.background : this.border))
                .collect(Collectors.toList());
        return borderPoints;
    }

    @Override
    public void draw(Render render) {
        this.getPoints().forEach(render::draw);
    }
}
