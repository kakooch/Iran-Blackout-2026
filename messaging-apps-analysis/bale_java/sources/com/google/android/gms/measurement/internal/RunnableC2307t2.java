package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.t2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2307t2 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ boolean d;
    final /* synthetic */ G2 e;

    RunnableC2307t2(G2 g2, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.e = g2;
        this.a = atomicReference;
        this.b = str2;
        this.c = str3;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.a.L().W(this.a, null, this.b, this.c, this.d);
    }
}
