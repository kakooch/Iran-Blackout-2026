package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.mh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2712mh implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ C2951wh c;

    public RunnableC2712mh(C2951wh c2951wh, String str, byte[] bArr) {
        this.c = c2951wh;
        this.a = str;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.c;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).setSessionExtra(this.a, this.b);
    }
}
