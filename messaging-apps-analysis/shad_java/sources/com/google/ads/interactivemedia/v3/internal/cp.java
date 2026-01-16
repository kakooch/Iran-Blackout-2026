package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class cp implements Comparable<cp> {
    public final ea a;
    public int b;
    public long c;
    public Object d;

    public cp(ea eaVar) {
        this.a = eaVar;
    }

    public final void a(int i, long j, Object obj) {
        this.b = i;
        this.c = j;
        this.d = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(cp cpVar) {
        cp cpVar2 = cpVar;
        Object obj = this.d;
        if ((obj == null) != (cpVar2.d == null)) {
            return obj == null ? 1 : -1;
        }
        if (obj == null) {
            return 0;
        }
        int i = this.b - cpVar2.b;
        return i != 0 ? i : aeu.K(this.c, cpVar2.c);
    }
}
