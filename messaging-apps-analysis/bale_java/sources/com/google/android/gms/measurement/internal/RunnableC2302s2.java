package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.s2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2302s2 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ G2 b;

    RunnableC2302s2(G2 g2, AtomicReference atomicReference) {
        this.b = g2;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            try {
                try {
                    this.a.set(Boolean.valueOf(this.b.a.z().B(this.b.a.B().s(), S0.L)));
                } finally {
                    this.a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
