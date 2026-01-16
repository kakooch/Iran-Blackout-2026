package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.ch, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2471ch implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2471ch(C2951wh c2951wh, String str) {
        this.b = c2951wh;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).setUserProfileID(this.a);
    }
}
