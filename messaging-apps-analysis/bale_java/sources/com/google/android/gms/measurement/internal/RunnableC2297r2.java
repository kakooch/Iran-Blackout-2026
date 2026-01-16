package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.r2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2297r2 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ G2 d;

    RunnableC2297r2(G2 g2, AtomicReference atomicReference, String str, String str2, String str3) {
        this.d = g2;
        this.a = atomicReference;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a.L().U(this.a, null, this.b, this.c);
    }
}
