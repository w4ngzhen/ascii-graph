package com.compilemind.asciigraph.canvas;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.Size;

public final class CanvasArea {

    private final Coordinate location;

    private final Size size;

    public Coordinate getOppositeLocation() {
        return Coordinate.of(this.location.getX() + this.size.getWidth(), this.location.getY() + this.size.getHeight());
    }

    public CanvasArea(Coordinate location, Size size) {
        this.location = Coordinate.of(location);
        this.size = Size.of(size);
    }

    public boolean include(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        return (location.getX() <= x && x <= location.getX() + size.getWidth())
                && (location.getY() <= y && y <= location.getY() + size.getHeight());
    }

    public CanvasArea intersection(CanvasArea that) {

        Coordinate thisLocation = this.location;
        Coordinate thisOppositeLocation = this.getOppositeLocation();

        Coordinate thatLocation = that.location;
        Coordinate thatOppositeLocation = this.getOppositeLocation();

        Coordinate intersectionLocation = Coordinate.of(
                Math.max(thisLocation.getX(), thatLocation.getX()),
                Math.max(thisLocation.getY(), thatLocation.getY()));

        Coordinate intersectionOppositeLocation = Coordinate.of(
                Math.min(thisOppositeLocation.getX(),thatOppositeLocation.getX()),
                Math.min(thisOppositeLocation.getY(),thatOppositeLocation.getY()));

        if (intersectionLocation.getX() > intersectionOppositeLocation.getX()
                || intersectionLocation.getY() > intersectionOppositeLocation.getY()) {
            return null; // 无交集
        }

        return new CanvasArea(
                intersectionLocation,
                Size.of(intersectionOppositeLocation.getX() - intersectionLocation.getX(),
                        intersectionOppositeLocation.getY() - intersectionLocation.getY())
        );
    }
}
