package com.compilemind;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.Size;
import com.compilemind.asciigraph.base.Symbol;
import com.compilemind.asciigraph.canvas.Canvas;
import com.compilemind.asciigraph.graph.impl.Line;
import com.compilemind.asciigraph.graph.impl.Point;
import com.compilemind.asciigraph.graph.impl.Rectangle;
import com.compilemind.asciigraph.graph.impl.Triangle;

/**
 * Portal
 */
public class App {
    public static void main(String[] args) {
        Canvas canvas = Canvas.CanvasBuilder
                .aCanvas()
                .build();
        Line line = Line.of(Coordinate.of(3, 3), Coordinate.of(7, 7));
        Rectangle rectangle = new Rectangle(Coordinate.of(1, 2), Size.of(4, 5));
        rectangle.setBackground(Symbol.ASTERISK);
        Triangle triangle = new Triangle(
                Point.of(Coordinate.of(1, 1)),
                Point.of(Coordinate.of(7, 1)),
                Point.of(Coordinate.of(4, 4))
        );
//        canvas.addElement(rectangle);
//        canvas.addElement(line);
        canvas.addElement(triangle);
        canvas.draw();
        canvas.print();
        System.out.println(line);
        System.out.println(rectangle);
    }
}
