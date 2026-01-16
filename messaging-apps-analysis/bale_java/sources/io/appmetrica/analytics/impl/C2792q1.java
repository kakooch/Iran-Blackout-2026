package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* renamed from: io.appmetrica.analytics.impl.q1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2792q1 extends SafeRunnable {
    public final /* synthetic */ C3007z1 a;

    public C2792q1(C3007z1 c3007z1) {
        this.a = c3007z1;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        synchronized (this.a) {
            try {
                C3007z1 c3007z1 = this.a;
                if (c3007z1.c) {
                    c3007z1.b.onCreate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
