package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class vo extends wc {
    public final long a;
    public final long b;
    private vq m;
    private int[] n;

    public vo(abx abxVar, acb acbVar, cy cyVar, int i, Object obj, long j, long j2, long j3, long j4, long j5) {
        super(abxVar, acbVar, cyVar, i, obj, j, j2, j5);
        this.a = j3;
        this.b = j4;
    }

    public final void a(vq vqVar) {
        this.m = vqVar;
        this.n = vqVar.a();
    }

    public final int d(int i) {
        return ((int[]) ary.s(this.n))[i];
    }

    protected final vq e() {
        vq vqVar = this.m;
        ary.s(vqVar);
        return vqVar;
    }
}
