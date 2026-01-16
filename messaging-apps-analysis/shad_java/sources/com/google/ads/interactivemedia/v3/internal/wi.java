package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class wi {
    public final int[] a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    private wi(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
        this.b = i;
        this.a = iArr;
        this.c = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.d = i6;
    }

    public static wi a(int i, int[] iArr, int i2, int i3, int i4) {
        return new wi(i, 0, iArr, i2, i3, i4, -1);
    }

    public static wi b(int[] iArr, int i) {
        return new wi(4, 1, iArr, i, -1, -1, -1);
    }

    public static wi c(int[] iArr, int i) {
        return new wi(3, 1, iArr, i, -1, -1, -1);
    }

    public static wi d(int i) {
        return new wi(4, 2, new int[0], -1, -1, -1, i);
    }
}
