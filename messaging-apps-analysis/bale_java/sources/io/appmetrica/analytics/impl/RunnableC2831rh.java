package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.rh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2831rh implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C2951wh c;

    public RunnableC2831rh(C2951wh c2951wh, String str, String str2) {
        this.c = c2951wh;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.c;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).putAppEnvironmentValue(this.a, this.b);
    }
}
