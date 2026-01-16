package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class F0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ C2601i1 b;

    public F0(C2601i1 c2601i1, String str) {
        this.b = c2601i1;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).b(this.a);
    }
}
