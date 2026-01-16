package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aah {
    private final int a;
    private final int b;
    private final int c;
    private final float d;
    private final float e;
    private final adk f;

    public aah() {
        adk adkVar = adk.a;
        this.a = 10000;
        this.b = 25000;
        this.c = 25000;
        this.d = 0.7f;
        this.e = 0.75f;
        this.f = adkVar;
    }

    protected final aai a(vh vhVar, abq abqVar, int[] iArr, int i) {
        return new aai(vhVar, iArr, new aag(abqVar, 0.7f, i), 10000L, 25000L, 25000L, 0.75f, this.f);
    }
}
