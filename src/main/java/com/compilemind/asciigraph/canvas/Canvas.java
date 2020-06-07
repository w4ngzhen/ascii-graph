package com.compilemind.asciigraph.canvas;

import com.compilemind.asciigraph.base.Coordinate;
import com.compilemind.asciigraph.base.Size;
import com.compilemind.asciigraph.base.Symbol;
import com.compilemind.asciigraph.graph.AsciiGraphElement;
import com.compilemind.asciigraph.graph.impl.Point;
import com.compilemind.asciigraph.util.StringUtil;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class Canvas {

    protected Size size;

    protected Symbol border;

    protected Symbol background;

    protected PrintStream printStream;

    protected List<AsciiGraphElement> elements;

    protected char[][] canvas;

    protected Canvas() {
    }

    public void addElement(AsciiGraphElement element) {
        Objects.requireNonNull(element, "element should not be null");
        this.elements.add(element);
    }

    public void addElements(Collection<AsciiGraphElement> elements) {
        Objects.requireNonNull(elements, "elements should not be null");
        this.elements.addAll(elements);
    }

    public void refresh() {
        int width = this.size.getWidth();
        int height = this.size.getHeight();
        this.canvas = new char[height][width];
        for (int rowIdx = 0; rowIdx < height; rowIdx++) {
            for (int colIdx = 0; colIdx < width; colIdx++) {
                this.canvas[rowIdx][colIdx] = this.background.getSymbol();
            }
        }
    }

    public void render() {
        this.elements.forEach(element -> element.renderAt(this));
    }

    public void render(List<Point> points) {
        CanvasArea canvasArea = new CanvasArea(Coordinate.of(), Size.of(this.size));
        points.forEach(point -> {
            Coordinate pointLocation = point.getCoordinate();
            if (canvasArea.include(pointLocation)) {
                this.canvas[pointLocation.getY()][pointLocation.getX()] = point.getContent().getSymbol();
            }
        });
    }

    public void print() {
        String interval = "";
        List<String> contents = new ArrayList<>();
        for (char[] line : this.canvas) {
            String content = this.border
                    + StringUtil.insert(String.valueOf(line), interval)
                    + this.border;
            contents.add(content);
        }
        if (this.border != Symbol.NONE) {
            String borderLine = this.border
                    + StringUtil.insert(StringUtil.repeat(this.border.toString(), this.size.getWidth()), interval)
                    + this.border;
            contents.add(0, borderLine);
            contents.add(borderLine);
        }
        String result = contents.stream().reduce((str1, str2) -> str1 + '\n' + str2).orElse("");
        this.printStream.println(result);
    }

    public static final class CanvasBuilder {
        protected Size size;
        protected Symbol border;
        protected Symbol background;
        protected PrintStream printStream;
        protected List<AsciiGraphElement> elements;

        private CanvasBuilder() {
            this.size = Size.of(30 ,30);
            this.border = Symbol.NONE;
            this.background = Symbol.NONE;
            this.printStream = System.out;
            this.elements = new ArrayList<>();
        }

        public static CanvasBuilder aCanvas() {
            return new CanvasBuilder();
        }

        public CanvasBuilder size(Size size) {
            this.size = size;
            return this;
        }

        public CanvasBuilder border(Symbol border) {
            this.border = border;
            return this;
        }

        public CanvasBuilder background(Symbol background) {
            this.background = background;
            return this;
        }

        public CanvasBuilder printStream(PrintStream printStream) {
            this.printStream = printStream;
            return this;
        }

        public CanvasBuilder elements(List<AsciiGraphElement> elements) {
            this.elements = elements;
            return this;
        }

        public Canvas build() {
            Canvas canvas = new AsciiCanvas();
            canvas.size = Size.of(30 ,30);
            canvas.elements = this.elements;
            canvas.printStream = this.printStream;
            canvas.background = this.background;
            canvas.border = this.border;
            canvas.refresh();
            return canvas;
        }
    }
}
