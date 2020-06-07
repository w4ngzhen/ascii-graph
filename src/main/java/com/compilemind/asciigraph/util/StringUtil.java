package com.compilemind.asciigraph.util;

public class StringUtil {
    public static String repeat(String str, int count) {
        if (count <= 0 || str == null || "".equals(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String insert(String string, String intervalString) {
        if (string == null) {
            return "";
        }
        return string.chars()
                .mapToObj(cInt -> String.valueOf((char) cInt))
                .reduce((c1, c2) -> c1 + intervalString + c2).orElse("");
    }
}
