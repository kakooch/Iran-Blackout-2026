package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.uf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2901uf implements Runnable {
    public final /* synthetic */ Cf a;
    public final /* synthetic */ C2925vf b;

    public RunnableC2901uf(C2925vf c2925vf, Cf cf) {
        this.b = c2925vf;
        this.a = cf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.a(this.a);
    }
}
