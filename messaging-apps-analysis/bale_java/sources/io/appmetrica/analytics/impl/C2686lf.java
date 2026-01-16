package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.lf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2686lf implements InterfaceC2638jf {
    public final /* synthetic */ C2829rf a;

    public C2686lf(C2829rf c2829rf) {
        this.a = c2829rf;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2638jf
    public final void a() {
        C2829rf c2829rf = this.a;
        C2872ta c2872ta = c2829rf.b;
        C2662kf c2662kf = new C2662kf(c2829rf);
        c2872ta.getClass();
        try {
            FutureTask futureTask = new FutureTask(new CallableC2848sa(c2872ta));
            C2586ha.C.d.a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Zc.a.incrementAndGet()).start();
            Cf cf = (Cf) futureTask.get(5L, TimeUnit.SECONDS);
            hn.a(c2872ta.b);
            C2829rf.a(c2829rf, cf, C2829rf.a(c2829rf));
        } catch (Throwable th) {
            try {
                c2662kf.a(th);
            } finally {
                hn.a(c2872ta.b);
            }
        }
    }
}
