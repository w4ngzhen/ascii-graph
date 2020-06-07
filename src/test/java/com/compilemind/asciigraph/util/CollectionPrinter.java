package com.compilemind.asciigraph.util;

import java.io.PrintStream;
import java.util.Collection;

public class CollectionPrinter {
    public static void println(Collection<?> collection, PrintStream printStream) {
        String res = collection
                .stream()
                .map(Object::toString)
                .reduce((item1Str, item2Str) -> item1Str + ", " + item2Str)
                .orElse("");
        printStream.println("[" + res + "]");
    }
    public static void standardPrint(Collection<?> collection) {
        println(collection, System.out);
    }
}
