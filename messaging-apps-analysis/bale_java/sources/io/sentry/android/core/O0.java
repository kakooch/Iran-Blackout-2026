package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.C3;
import io.sentry.C3128i1;
import io.sentry.C3155n3;
import io.sentry.D1;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import io.sentry.Z1;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.util.C3202a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class O0 {
    private static final long a = SystemClock.uptimeMillis();
    protected static final C3202a b = new C3202a();

    private static void d(C3155n3 c3155n3, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (InterfaceC3157o0 interfaceC3157o0 : c3155n3.getIntegrations()) {
            if (z && (interfaceC3157o0 instanceof FragmentLifecycleIntegration)) {
                arrayList2.add(interfaceC3157o0);
            }
            if (z2 && (interfaceC3157o0 instanceof SentryTimberIntegration)) {
                arrayList.add(interfaceC3157o0);
            }
        }
        if (arrayList2.size() > 1) {
            for (int i = 0; i < arrayList2.size() - 1; i++) {
                c3155n3.getIntegrations().remove((InterfaceC3157o0) arrayList2.get(i));
            }
        }
        if (arrayList.size() > 1) {
            for (int i2 = 0; i2 < arrayList.size() - 1; i2++) {
                c3155n3.getIntegrations().remove((InterfaceC3157o0) arrayList.get(i2));
            }
        }
    }

    public static void e(Context context, ILogger iLogger) {
        f(context, iLogger, new Z1.a() { // from class: io.sentry.android.core.L0
            @Override // io.sentry.Z1.a
            public final void a(C3155n3 c3155n3) {
                O0.h((SentryAndroidOptions) c3155n3);
            }
        });
    }

    public static void f(final Context context, final ILogger iLogger, final Z1.a aVar) {
        try {
            InterfaceC3102d0 interfaceC3102d0A = b.a();
            try {
                Z1.v(C3128i1.a(SentryAndroidOptions.class), new Z1.a() { // from class: io.sentry.android.core.M0
                    @Override // io.sentry.Z1.a
                    public final void a(C3155n3 c3155n3) {
                        O0.i(iLogger, context, aVar, (SentryAndroidOptions) c3155n3);
                    }
                }, true);
                io.sentry.Z zR = Z1.r();
                if (AbstractC3060k0.s()) {
                    if (zR.e().isEnableAutoSessionTracking()) {
                        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        zR.z(new D1() { // from class: io.sentry.android.core.N0
                            @Override // io.sentry.D1
                            public final void a(io.sentry.X x) {
                                O0.j(atomicBoolean, x);
                            }
                        });
                        if (!atomicBoolean.get()) {
                            zR.l();
                        }
                    }
                    zR.e().getReplayController().start();
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } catch (Throwable th) {
                if (interfaceC3102d0A != null) {
                    try {
                        interfaceC3102d0A.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IllegalAccessException e) {
            iLogger.b(Y2.FATAL, "Fatal error during SentryAndroid.init(...)", e);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e);
        } catch (InstantiationException e2) {
            iLogger.b(Y2.FATAL, "Fatal error during SentryAndroid.init(...)", e2);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e2);
        } catch (NoSuchMethodException e3) {
            iLogger.b(Y2.FATAL, "Fatal error during SentryAndroid.init(...)", e3);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e3);
        } catch (InvocationTargetException e4) {
            iLogger.b(Y2.FATAL, "Fatal error during SentryAndroid.init(...)", e4);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e4);
        }
    }

    public static void g(Context context, Z1.a aVar) {
        f(context, new C3086y(), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(SentryAndroidOptions sentryAndroidOptions) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(ILogger iLogger, Context context, Z1.a aVar, SentryAndroidOptions sentryAndroidOptions) {
        io.sentry.util.r rVar = new io.sentry.util.r();
        boolean zB = rVar.b("timber.log.Timber", sentryAndroidOptions);
        boolean z = rVar.b("androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks", sentryAndroidOptions) && rVar.b("io.sentry.android.fragment.FragmentLifecycleIntegration", sentryAndroidOptions);
        boolean z2 = zB && rVar.b("io.sentry.android.timber.SentryTimberIntegration", sentryAndroidOptions);
        boolean zB2 = rVar.b("io.sentry.android.replay.ReplayIntegration", sentryAndroidOptions);
        Y y = new Y(iLogger);
        io.sentry.util.r rVar2 = new io.sentry.util.r();
        C3050h c3050h = new C3050h(rVar2, sentryAndroidOptions);
        D.k(sentryAndroidOptions, context, iLogger, y);
        D.g(context, sentryAndroidOptions, y, rVar2, c3050h, z, z2, zB2);
        try {
            aVar.a(sentryAndroidOptions);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(Y2.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
        io.sentry.android.core.performance.h hVarP = io.sentry.android.core.performance.h.p();
        if (sentryAndroidOptions.isEnablePerformanceV2() && y.d() >= 24) {
            io.sentry.android.core.performance.i iVarK = hVarP.k();
            if (iVarK.u()) {
                iVarK.z(Process.getStartUptimeMillis());
            }
        }
        if (context.getApplicationContext() instanceof Application) {
            hVarP.x((Application) context.getApplicationContext());
        }
        io.sentry.android.core.performance.i iVarQ = hVarP.q();
        if (iVarQ.u()) {
            iVarQ.z(a);
        }
        D.f(sentryAndroidOptions, context, y, rVar2, c3050h);
        d(sentryAndroidOptions, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(AtomicBoolean atomicBoolean, io.sentry.X x) {
        C3 c3Y = x.y();
        if (c3Y == null || c3Y.k() == null) {
            return;
        }
        atomicBoolean.set(true);
    }
}
