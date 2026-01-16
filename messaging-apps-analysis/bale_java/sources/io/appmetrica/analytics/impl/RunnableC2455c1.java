package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.c1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2455c1 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ C2601i1 b;

    public RunnableC2455c1(C2601i1 c2601i1, String str) {
        this.b = c2601i1;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).reportEvent(this.a);
    }
}
