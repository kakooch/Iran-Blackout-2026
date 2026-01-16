package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class wc extends vt {
    public final long l;

    public wc(abx abxVar, acb acbVar, cy cyVar, int i, Object obj, long j, long j2, long j3) {
        super(abxVar, acbVar, 1, cyVar, i, obj, j, j2);
        ary.t(cyVar);
        this.l = j3;
    }

    public long i() {
        long j = this.l;
        if (j != -1) {
            return j + 1;
        }
        return -1L;
    }

    public abstract boolean j();
}
