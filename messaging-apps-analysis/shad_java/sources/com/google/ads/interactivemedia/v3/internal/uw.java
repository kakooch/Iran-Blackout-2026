package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class uw {
    public final long a;
    public final long b;
    public boolean c;
    public abj d;
    public uw e;

    public uw(long j, int i) {
        this.a = j;
        this.b = j + i;
    }

    public final int a(long j) {
        long j2 = this.a;
        int i = this.d.b;
        return (int) (j - j2);
    }

    public final uw b() {
        this.d = null;
        uw uwVar = this.e;
        this.e = null;
        return uwVar;
    }
}
