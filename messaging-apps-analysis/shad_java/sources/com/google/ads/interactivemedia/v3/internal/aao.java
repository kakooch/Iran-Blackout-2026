package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aao implements Comparable<aao> {
    private final boolean a;
    private final boolean b;

    public aao(cy cyVar, int i) {
        this.a = 1 == (cyVar.d & 1);
        this.b = aaw.b(i, false);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(aao aaoVar) {
        return aqv.g().d(this.b, aaoVar.b).d(this.a, aaoVar.a).e();
    }
}
