package com.google.ads.interactivemedia.v3.internal;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class pq {
    private final String a;
    private final int b;
    private final int c;
    private int d;
    private String e;

    public pq(int i, int i2) {
        this(Integer.MIN_VALUE, i, i2);
    }

    private final void d() {
        if (this.d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public final void a() {
        int i = this.d;
        int i2 = i == Integer.MIN_VALUE ? this.b : i + this.c;
        this.d = i2;
        String str = this.a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
        sb.append(str);
        sb.append(i2);
        this.e = sb.toString();
    }

    public final int b() {
        d();
        return this.d;
    }

    public final String c() {
        d();
        return this.e;
    }

    public pq(int i, int i2, int i3) {
        String string;
        if (i != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder(12);
            sb.append(i);
            sb.append("/");
            string = sb.toString();
        } else {
            string = BuildConfig.FLAVOR;
        }
        this.a = string;
        this.b = i2;
        this.c = i3;
        this.d = Integer.MIN_VALUE;
        this.e = BuildConfig.FLAVOR;
    }
}
