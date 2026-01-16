package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.z2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2337z2 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ G2 b;

    RunnableC2337z2(G2 g2, AtomicReference atomicReference) {
        this.b = g2;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            try {
                try {
                    this.a.set(Double.valueOf(this.b.a.z().k(this.b.a.B().s(), S0.P)));
                } finally {
                    this.a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
