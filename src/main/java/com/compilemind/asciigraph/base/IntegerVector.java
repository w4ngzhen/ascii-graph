package com.compilemind.asciigraph.base;

import java.util.Objects;

/***
 * 整型向量(int x, int y )
 */
public final class IntegerVector {

    private final Coordinate start;

    private final Coordinate end;

    /**
     * @return 向量x值
     */
    public int getX() {
        return this.end.getX() - this.start.getX();
    }

    /**
     * @return 向量y值
     */
    public int getY() {
        return this.end.getY() - this.start.getY();
    }

    /***
     * 根据向量确定象限
     * @return 象限I、II、III以及IV，如果向量在x、y轴，或者原点，则返回null
     */
    public Quadrant getQuadrant() {
        int x = getX();
        int y = getY();
        if (x * y == 0) {
            return null;
        } else if (x * y > 0) {
            return x > 0 ? Quadrant.I : Quadrant.III;
        } else {
            return x < 0 ? Quadrant.II : Quadrant.IV;
        }
    }

    public static IntegerVector of(Coordinate start, Coordinate end) {
        return new IntegerVector(start, end);
    }

    private IntegerVector(Coordinate start, Coordinate end) {
        this.start = Coordinate.of(start);
        this.end = Coordinate.of(end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerVector vector = (IntegerVector) o;
        return start.equals(vector.start) &&
                end.equals(vector.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", getX(), getY());
    }
}
