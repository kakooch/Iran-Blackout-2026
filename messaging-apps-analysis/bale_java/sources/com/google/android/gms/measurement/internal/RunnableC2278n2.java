package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.n2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2278n2 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Object c;
    final /* synthetic */ long d;
    final /* synthetic */ G2 e;

    RunnableC2278n2(G2 g2, String str, String str2, Object obj, long j) {
        this.e = g2;
        this.a = str;
        this.b = str2;
        this.c = obj;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.M(this.a, this.b, this.c, this.d);
    }
}
