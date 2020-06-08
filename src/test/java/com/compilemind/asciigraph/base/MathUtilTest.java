package com.compilemind.asciigraph.base;

import com.compilemind.asciigraph.util.MathUtil;
import org.junit.Test;

import java.util.List;

public class MathUtilTest {

    @Test
    public void test1() {
        List<Coordinate> coordinates = MathUtil.getCoordinatesBetween(Coordinate.of(-3, 5), Coordinate.of(3, 3));
        System.out.println(coordinates);
    }
}