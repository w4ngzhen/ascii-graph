package com.compilemind.asciigraph.util;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.IntegerVector;
import com.compilemind.asciigraph.graph.impl.Line;

import java.util.*;

public final class MathUtil {

    public static Set<Coordinate> getCoordinatesBetween(Coordinate begin, Coordinate end) {
        IntegerVector vector = IntegerVector.of(begin, end);
        int maxCount = Math.max(Math.abs(vector.getX()), Math.abs(vector.getY())) + 1; // +1是因为起始点自身也是一个
        Set<Coordinate> coordinates = new HashSet<>(maxCount);
        getCoordinatesBetween(coordinates, begin, end);
        return coordinates;
    }

    private static void getCoordinatesBetween(Set<Coordinate> coordinates, Coordinate begin, Coordinate end) {
        IntegerVector vector = IntegerVector.of(begin, end);
        int x = vector.getX();
        int y = vector.getY();
        if (Math.abs(x) <= 1 && Math.abs(y) <= 1) {
            coordinates.add(Coordinate.of(begin));
            coordinates.add(Coordinate.of(end));
            return;
        }
        Coordinate mid = Coordinate.of((begin.getX() + end.getX())/ 2, (begin.getY() + end.getY()) / 2);
        getCoordinatesBetween(coordinates, begin, mid);
        getCoordinatesBetween(coordinates, mid, end);
    }

    public static List<Line> getRectangleLines(Coordinate begin, Coordinate opposite) {
        int beginX = begin.getX();
        int beginY = begin.getY();
        int oppositeX = opposite.getX();
        int oppositeY = opposite.getY();
        Line left;
        Line top;
        Line right;
        Line bottom;

        if (beginX < oppositeX) {
            left = Line.of(begin, Coordinate.of(beginX, oppositeY));
            right = Line.of(opposite, Coordinate.of(oppositeX, beginY));
        } else {
            left = Line.of(opposite, Coordinate.of(oppositeX, beginY));
            right = Line.of(begin, Coordinate.of(beginX, oppositeY));
        }

        if (beginY < oppositeY) {
            top = Line.of(begin, Coordinate.of(oppositeX, beginY));
            bottom = Line.of(opposite, Coordinate.of(beginX, oppositeY));
        } else {
            top = Line.of(opposite, Coordinate.of(beginX, oppositeY));
            bottom = Line.of(begin, Coordinate.of(oppositeX, beginY));
        }

        List<Line> lines = new ArrayList<>(4);
        lines.add(left);
        lines.add(top);
        lines.add(right);
        lines.add(bottom);
        return lines;
    }
}