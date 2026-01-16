package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.e0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2504e0 implements Runnable {
    public final /* synthetic */ C2552g0 a;

    public RunnableC2504e0(C2552g0 c2552g0) {
        this.a = c2552g0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2552g0 c2552g0 = this.a;
        synchronized (c2552g0) {
            if (c2552g0.a != null && c2552g0.a()) {
                try {
                    c2552g0.d = null;
                    c2552g0.a.unbindService(c2552g0.i);
                } catch (Throwable unused) {
                }
            }
            c2552g0.d = null;
        }
    }
}
