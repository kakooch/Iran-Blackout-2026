package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.gov.nist.core.Separators;
import io.sentry.C3103d1;
import io.sentry.C3113f1;
import io.sentry.C3146m;
import io.sentry.C3156o;
import io.sentry.EnumC3125h3;
import io.sentry.F1;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3132j0;
import io.sentry.Q1;
import io.sentry.T1;
import io.sentry.U1;
import io.sentry.Y2;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.replay.C3090a;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.compose.gestures.ComposeGestureTargetLocator;
import io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter;
import io.sentry.util.q;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes3.dex */
abstract class D {
    static File d(Context context) {
        return new File(context.getCacheDir(), "sentry");
    }

    private static String e(PackageInfo packageInfo, String str) {
        return packageInfo.packageName + Separators.AT + packageInfo.versionName + "+" + str;
    }

    static void f(SentryAndroidOptions sentryAndroidOptions, Context context, Y y, io.sentry.util.r rVar, C3050h c3050h) {
        if (sentryAndroidOptions.getCacheDirPath() != null && (sentryAndroidOptions.getEnvelopeDiskCache() instanceof io.sentry.transport.s)) {
            sentryAndroidOptions.setEnvelopeDiskCache(new io.sentry.android.core.cache.b(sentryAndroidOptions));
        }
        if (sentryAndroidOptions.getConnectionStatusProvider() instanceof io.sentry.H0) {
            sentryAndroidOptions.setConnectionStatusProvider(new io.sentry.android.core.internal.util.f(context, sentryAndroidOptions, y, io.sentry.android.core.internal.util.g.b()));
        }
        if (sentryAndroidOptions.getCacheDirPath() != null) {
            sentryAndroidOptions.addScopeObserver(new io.sentry.cache.q(sentryAndroidOptions));
            sentryAndroidOptions.addOptionsObserver(new io.sentry.cache.h(sentryAndroidOptions));
        }
        sentryAndroidOptions.addEventProcessor(new C3146m(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new C3068o0(context, y, sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new E0(sentryAndroidOptions, c3050h));
        sentryAndroidOptions.addEventProcessor(new ScreenshotEventProcessor(sentryAndroidOptions, y));
        sentryAndroidOptions.addEventProcessor(new ViewHierarchyEventProcessor(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new N(context, sentryAndroidOptions, y));
        if (sentryAndroidOptions.getTransportGate() instanceof io.sentry.transport.u) {
            sentryAndroidOptions.setTransportGate(new J(sentryAndroidOptions));
        }
        io.sentry.android.core.performance.h hVarP = io.sentry.android.core.performance.h.p();
        InterfaceC3102d0 interfaceC3102d0A = io.sentry.android.core.performance.h.q.a();
        try {
            InterfaceC3132j0 interfaceC3132j0I = hVarP.i();
            io.sentry.O oH = hVarP.h();
            hVarP.z(null);
            hVarP.y(null);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            m(sentryAndroidOptions, context, y, interfaceC3132j0I, oH);
            if (sentryAndroidOptions.getModulesLoader() instanceof io.sentry.internal.modules.e) {
                sentryAndroidOptions.setModulesLoader(new io.sentry.android.core.internal.modules.b(context, sentryAndroidOptions.getLogger()));
            }
            if (sentryAndroidOptions.getDebugMetaLoader() instanceof io.sentry.internal.debugmeta.b) {
                sentryAndroidOptions.setDebugMetaLoader(new io.sentry.android.core.internal.debugmeta.a(context, sentryAndroidOptions.getLogger()));
            }
            if (sentryAndroidOptions.getVersionDetector() instanceof C3113f1) {
                sentryAndroidOptions.setVersionDetector(new io.sentry.r(sentryAndroidOptions));
            }
            boolean zB = rVar.b("androidx.core.view.ScrollingView", sentryAndroidOptions);
            boolean zB2 = rVar.b("androidx.compose.ui.node.Owner", sentryAndroidOptions);
            if (sentryAndroidOptions.getGestureTargetLocators().isEmpty()) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new io.sentry.android.core.internal.gestures.a(zB));
                if (zB2 && rVar.b("io.sentry.compose.gestures.ComposeGestureTargetLocator", sentryAndroidOptions)) {
                    arrayList.add(new ComposeGestureTargetLocator(sentryAndroidOptions.getLogger()));
                }
                sentryAndroidOptions.setGestureTargetLocators(arrayList);
            }
            if (sentryAndroidOptions.getViewHierarchyExporters().isEmpty() && zB2 && rVar.b("io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter", sentryAndroidOptions)) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(new ComposeViewHierarchyExporter(sentryAndroidOptions.getLogger()));
                sentryAndroidOptions.setViewHierarchyExporters(arrayList2);
            }
            if (sentryAndroidOptions.getThreadChecker() instanceof io.sentry.util.thread.b) {
                sentryAndroidOptions.setThreadChecker(io.sentry.android.core.internal.util.i.e());
            }
            if (sentryAndroidOptions.getSocketTagger() instanceof io.sentry.Z0) {
                sentryAndroidOptions.setSocketTagger(G.c());
            }
            if (sentryAndroidOptions.getPerformanceCollectors().isEmpty()) {
                sentryAndroidOptions.addPerformanceCollector(new C3088z());
                sentryAndroidOptions.addPerformanceCollector(new C3080v(sentryAndroidOptions.getLogger()));
                if (sentryAndroidOptions.isEnablePerformanceV2()) {
                    sentryAndroidOptions.addPerformanceCollector(new X0(sentryAndroidOptions, (io.sentry.android.core.internal.util.C) io.sentry.util.u.c(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required")));
                }
            }
            if (sentryAndroidOptions.getCompositePerformanceCollector() instanceof io.sentry.G0) {
                sentryAndroidOptions.setCompositePerformanceCollector(new C3156o(sentryAndroidOptions));
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
    }

    static void g(Context context, final SentryAndroidOptions sentryAndroidOptions, Y y, io.sentry.util.r rVar, C3050h c3050h, boolean z, boolean z2, boolean z3) {
        io.sentry.util.q qVar = new io.sentry.util.q(new q.a() { // from class: io.sentry.android.core.A
            @Override // io.sentry.util.q.a
            public final Object a() {
                return D.h(sentryAndroidOptions);
            }
        });
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new T1(new Q1() { // from class: io.sentry.android.core.B
            @Override // io.sentry.Q1
            public final String a() {
                return sentryAndroidOptions.getCacheDirPath();
            }
        }), qVar));
        sentryAndroidOptions.addIntegration(new NdkIntegration(rVar.c("io.sentry.android.ndk.SentryNdk", sentryAndroidOptions.getLogger())));
        sentryAndroidOptions.addIntegration(EnvelopeFileObserverIntegration.b());
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new U1(new Q1() { // from class: io.sentry.android.core.C
            @Override // io.sentry.Q1
            public final String a() {
                return sentryAndroidOptions.getOutboxPath();
            }
        }), qVar));
        sentryAndroidOptions.addIntegration(new AppLifecycleIntegration());
        sentryAndroidOptions.addIntegration(M.a(context, y));
        if (context instanceof Application) {
            Application application = (Application) context;
            sentryAndroidOptions.addIntegration(new ActivityLifecycleIntegration(application, y, c3050h));
            sentryAndroidOptions.addIntegration(new ActivityBreadcrumbsIntegration(application));
            sentryAndroidOptions.addIntegration(new UserInteractionIntegration(application, rVar));
            if (z) {
                sentryAndroidOptions.addIntegration(new FragmentLifecycleIntegration(application, true, true));
            }
        } else {
            sentryAndroidOptions.getLogger().c(Y2.WARNING, "ActivityLifecycle, FragmentLifecycle and UserInteraction Integrations need an Application class to be installed.", new Object[0]);
        }
        if (z2) {
            sentryAndroidOptions.addIntegration(new SentryTimberIntegration());
        }
        sentryAndroidOptions.addIntegration(new AppComponentsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new SystemEventsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new NetworkBreadcrumbsIntegration(context, y));
        if (z3) {
            ReplayIntegration replayIntegration = new ReplayIntegration(context, io.sentry.transport.n.b());
            replayIntegration.Z(new C3090a());
            sentryAndroidOptions.addIntegration(replayIntegration);
            sentryAndroidOptions.setReplayController(replayIntegration);
        }
        sentryAndroidOptions.getFeedbackOptions().v(new SentryAndroidOptions.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean h(SentryAndroidOptions sentryAndroidOptions) {
        return Boolean.valueOf(io.sentry.android.core.cache.b.g0(sentryAndroidOptions));
    }

    static void k(SentryAndroidOptions sentryAndroidOptions, Context context, ILogger iLogger, Y y) {
        io.sentry.util.u.c(context, "The context is required.");
        Context contextG = AbstractC3060k0.g(context);
        io.sentry.util.u.c(sentryAndroidOptions, "The options object is required.");
        io.sentry.util.u.c(iLogger, "The ILogger object is required.");
        sentryAndroidOptions.setLogger(iLogger);
        sentryAndroidOptions.setFatalLogger(new C3084x());
        sentryAndroidOptions.setDefaultScopeType(F1.CURRENT);
        sentryAndroidOptions.setOpenTelemetryMode(EnumC3125h3.OFF);
        sentryAndroidOptions.setDateProvider(new P0());
        sentryAndroidOptions.setFlushTimeoutMillis(4000L);
        sentryAndroidOptions.setFrameMetricsCollector(new io.sentry.android.core.internal.util.C(contextG, iLogger, y));
        A0.a(contextG, sentryAndroidOptions, y);
        sentryAndroidOptions.setCacheDirPath(d(contextG).getAbsolutePath());
        l(sentryAndroidOptions, contextG, y);
        X.j().n(sentryAndroidOptions);
    }

    private static void l(SentryAndroidOptions sentryAndroidOptions, Context context, Y y) {
        PackageInfo packageInfoP = AbstractC3060k0.p(context, y);
        if (packageInfoP != null) {
            if (sentryAndroidOptions.getRelease() == null) {
                sentryAndroidOptions.setRelease(e(packageInfoP, AbstractC3060k0.q(packageInfoP, y)));
            }
            String str = packageInfoP.packageName;
            if (str != null && !str.startsWith("android.")) {
                sentryAndroidOptions.addInAppInclude(str);
            }
        }
        if (sentryAndroidOptions.getDistinctId() == null) {
            try {
                sentryAndroidOptions.setDistinctId(AbstractC3081v0.a(context));
            } catch (RuntimeException e) {
                sentryAndroidOptions.getLogger().b(Y2.ERROR, "Could not generate distinct Id.", e);
            }
        }
    }

    private static void m(SentryAndroidOptions sentryAndroidOptions, Context context, Y y, InterfaceC3132j0 interfaceC3132j0, io.sentry.O o) {
        if (sentryAndroidOptions.isProfilingEnabled() || sentryAndroidOptions.getProfilesSampleRate() != null) {
            sentryAndroidOptions.setContinuousProfiler(io.sentry.I0.a());
            if (o != null) {
                o.i(true);
            }
            if (interfaceC3132j0 != null) {
                sentryAndroidOptions.setTransactionProfiler(interfaceC3132j0);
                return;
            } else {
                sentryAndroidOptions.setTransactionProfiler(new I(context, sentryAndroidOptions, y, (io.sentry.android.core.internal.util.C) io.sentry.util.u.c(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required")));
                return;
            }
        }
        sentryAndroidOptions.setTransactionProfiler(C3103d1.c());
        if (interfaceC3132j0 != null) {
            interfaceC3132j0.close();
        }
        if (o != null) {
            sentryAndroidOptions.setContinuousProfiler(o);
        } else {
            sentryAndroidOptions.setContinuousProfiler(new C3078u(y, (io.sentry.android.core.internal.util.C) io.sentry.util.u.c(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required"), sentryAndroidOptions.getLogger(), sentryAndroidOptions.getProfilingTracesDirPath(), sentryAndroidOptions.getProfilingTracesHz(), sentryAndroidOptions.getExecutorService()));
        }
    }
}
