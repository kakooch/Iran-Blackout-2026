package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreutils.internal.executors.BlockingExecutor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* renamed from: io.appmetrica.analytics.impl.n0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2719n0 implements Na {
    public static volatile C2719n0 e = null;
    public static volatile boolean f = false;
    public final Context a;
    public final C2600i0 b;
    public final FutureTask c;
    public final InterfaceC2920va d;

    public C2719n0(Context context) {
        this.a = context;
        C2600i0 c2600i0 = new C2600i0();
        this.b = c2600i0;
        this.d = c2600i0.a(context, C2747o4.g().d());
        this.c = new FutureTask(new Callable() { // from class: ir.nasim.oe8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.o();
            }
        });
    }

    public static C2719n0 a(Context context, boolean z) {
        C2719n0 c2719n0 = e;
        if (c2719n0 == null) {
            synchronized (C2719n0.class) {
                try {
                    c2719n0 = e;
                    if (c2719n0 == null) {
                        c2719n0 = new C2719n0(context);
                        c2719n0.b(z);
                        C2747o4.g().c.a().execute(new RunnableC2695m0(c2719n0));
                        e = c2719n0;
                    }
                } finally {
                }
            }
        }
        return c2719n0;
    }

    public static void clearAppEnvironment() {
        f().clearAppEnvironment();
    }

    public static InterfaceC2803qc f() {
        return l() ? e.j() : C2747o4.g().b;
    }

    public static synchronized boolean k() {
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized boolean l() {
        /*
            java.lang.Class<io.appmetrica.analytics.impl.n0> r0 = io.appmetrica.analytics.impl.C2719n0.class
            monitor-enter(r0)
            io.appmetrica.analytics.impl.n0 r1 = io.appmetrica.analytics.impl.C2719n0.e     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L1d
            java.util.concurrent.FutureTask r2 = r1.c     // Catch: java.lang.Throwable -> L1b
            boolean r2 = r2.isDone()     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto L1d
            io.appmetrica.analytics.impl.wa r1 = r1.j()     // Catch: java.lang.Throwable -> L1b
            io.appmetrica.analytics.impl.Wb r1 = r1.i()     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L1d
            r1 = 1
            goto L1e
        L1b:
            r1 = move-exception
            goto L20
        L1d:
            r1 = 0
        L1e:
            monitor-exit(r0)
            return r1
        L20:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2719n0.l():boolean");
    }

    public static void m() {
        e = null;
        f = false;
    }

    public static synchronized void p() {
        f = true;
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        f().putAppEnvironmentValue(str, str2);
    }

    public static C2719n0 q() {
        return e;
    }

    public static void setDataSendingEnabled(boolean z) {
        f().setDataSendingEnabled(z);
    }

    public static void setUserProfileID(String str) {
        f().setUserProfileID(str);
    }

    public final void b(boolean z) {
        Executor executorA = z ? C2747o4.g().c.a() : new BlockingExecutor();
        executorA.execute(new Runnable() { // from class: ir.nasim.pe8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n();
            }
        });
        executorA.execute(this.c);
    }

    public final void c(AppMetricaConfig appMetricaConfig) {
        this.d.a(appMetricaConfig, this);
    }

    public final void d(AppMetricaConfig appMetricaConfig) {
        j().a(appMetricaConfig);
    }

    public final String e() {
        return j().e();
    }

    public final Map<String, String> g() {
        return j().g();
    }

    public final R9 getFeatures() {
        return j().getFeatures();
    }

    public final AdvIdentifiersResult h() {
        return j().h();
    }

    public final Wb i() {
        return j().i();
    }

    public final InterfaceC2944wa j() {
        try {
            return (InterfaceC2944wa) this.c.get();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public final /* synthetic */ void n() {
        new C2651k4(this.a).a(this.a);
        C2747o4.g().a(this.a).a();
    }

    public final InterfaceC2944wa o() {
        InterfaceC2944wa interfaceC2944wa;
        C2600i0 c2600i0 = this.b;
        Context context = this.a;
        InterfaceC2920va interfaceC2920va = this.d;
        synchronized (c2600i0) {
            try {
                if (c2600i0.d == null) {
                    if (c2600i0.a(context)) {
                        c2600i0.d = new C2862t0();
                    } else {
                        c2600i0.d = new C2814r0(context, interfaceC2920va);
                    }
                }
                interfaceC2944wa = c2600i0.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC2944wa;
    }

    public final La c(ReporterConfig reporterConfig) {
        return j().c(reporterConfig);
    }

    public final C2771p4 c() {
        return this.d.a();
    }

    public final void b() {
        j().d();
    }

    public static void a(Location location) {
        f().a(location);
    }

    public static void a(boolean z) {
        f().a(z);
    }

    public static void a(String str, String str2) {
        f().a(str, str2);
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        j().a(deferredDeeplinkParametersListener);
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        j().a(deferredDeeplinkListener);
    }

    public final void a(ReporterConfig reporterConfig) {
        j().a(reporterConfig);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        j().a(startupParamsCallback, list);
    }

    public static void a(C2719n0 c2719n0) {
        e = c2719n0;
    }

    @Override // io.appmetrica.analytics.impl.Na
    public final Ma a() {
        return j().a();
    }
}
