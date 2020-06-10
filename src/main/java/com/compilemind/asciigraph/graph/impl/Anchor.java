package com.compilemind.asciigraph.graph.impl;

import com.compilemind.asciigraph.graph.Element;

public class Anchor extends Element {

    private final Element src;

    private final Element dest;

    public Anchor(Element src, Element dest) {
        this.src = src;
        this.dest = dest;
    }

    public Element getSrc() {
        return src;
    }

    public Element getDest() {
        return dest;
    }
}
