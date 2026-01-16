package com.google.common.base;

/* loaded from: classes3.dex */
public final class Ascii {
    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static char toUpperCase(char c) {
        return isLowerCase(c) ? (char) (c ^ ' ') : c;
    }
}
