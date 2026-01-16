package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2210a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ C2330y0 c;

    RunnableC2210a(C2330y0 c2330y0, String str, long j) {
        this.c = c2330y0;
        this.a = str;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2330y0.i(this.c, this.a, this.b);
    }
}
