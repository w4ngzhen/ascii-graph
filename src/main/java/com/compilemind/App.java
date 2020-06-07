package com.compilemind;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.Size;
import com.compilemind.asciigraph.base.Symbol;
import com.compilemind.asciigraph.canvas.Canvas;
import com.compilemind.asciigraph.graph.AsciiGraphElement;
import com.compilemind.asciigraph.graph.impl.Line;
import com.compilemind.asciigraph.graph.impl.Rectangle;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Canvas canvas = Canvas.CanvasBuilder
                .aCanvas()
                .build();
        Line line = Line.of(Coordinate.of(3, 3), Coordinate.of(7, 7));
        Rectangle rectangle = new Rectangle(Coordinate.of(1, 2), Size.of(4, 5));
        rectangle.setBackground(Symbol.ASTERISK);
        canvas.addElement(rectangle);
        canvas.addElement(line);
        canvas.render();
        canvas.print();
    }
}
