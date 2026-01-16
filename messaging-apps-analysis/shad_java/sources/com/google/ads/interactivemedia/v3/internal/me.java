package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
class me {
    public final int d;

    public me(int i) {
        this.d = i;
    }

    public static int e(int i) {
        return (i >> 24) & 255;
    }

    public static int f(int i) {
        return i & 16777215;
    }

    public static String g(int i) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return g(this.d);
    }
}
