package ir.nasim;

import android.content.Context;
import io.sentry.C3155n3;
import io.sentry.Z1;
import io.sentry.android.core.SentryAndroidOptions;
import ir.nasim.monitoring.installer.config.SentryConfiguration;

/* renamed from: ir.nasim.ws5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23413ws5 implements InterfaceC12566ep6 {
    private static final a c = new a(null);
    private final InterfaceC7720Sx5 a;
    private final SentryConfiguration b;

    /* renamed from: ir.nasim.ws5$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C23413ws5(InterfaceC7720Sx5 interfaceC7720Sx5, SentryConfiguration sentryConfiguration) {
        AbstractC13042fc3.i(interfaceC7720Sx5, "userProvider");
        AbstractC13042fc3.i(sentryConfiguration, "configuration");
        this.a = interfaceC7720Sx5;
        this.b = sentryConfiguration;
    }

    private final C3155n3.l f() {
        return new C3155n3.l() { // from class: ir.nasim.vs5
            @Override // io.sentry.C3155n3.l
            public final Double a(io.sentry.A1 a1) {
                return C23413ws5.g(this.a, a1);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double g(C23413ws5 c23413ws5, io.sentry.A1 a1) {
        AbstractC13042fc3.i(c23413ws5, "this$0");
        AbstractC13042fc3.i(a1, "samplingContext");
        return Double.valueOf(c23413ws5.h(a1, c23413ws5.b.getTracesSampleRate()));
    }

    private final double h(io.sentry.A1 a1, double d) {
        io.sentry.W3 w3B = a1.b();
        AbstractC13042fc3.h(w3B, "getTransactionContext(...)");
        if (l(w3B)) {
            return 1.0d;
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final C23413ws5 c23413ws5, Context context, SentryAndroidOptions sentryAndroidOptions) {
        AbstractC13042fc3.i(c23413ws5, "this$0");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(sentryAndroidOptions, "options");
        sentryAndroidOptions.setRelease("9.126.26 (134311)");
        sentryAndroidOptions.setDsn("https://4c610cc86ad84102bb00db753e6e756a@sentry.bale.sh/46");
        sentryAndroidOptions.setEnvironment("Production");
        sentryAndroidOptions.setAttachThreads(true);
        sentryAndroidOptions.setEnableNdk(false);
        sentryAndroidOptions.setDebug(false);
        sentryAndroidOptions.setAttachStacktrace(true);
        sentryAndroidOptions.setEnableAutoSessionTracking(true);
        sentryAndroidOptions.setTracesSampleRate(Double.valueOf(c23413ws5.b.getTracesSampleRate()));
        sentryAndroidOptions.setTracesSampler(c23413ws5.f());
        sentryAndroidOptions.setEnableAppStartProfiling(false);
        sentryAndroidOptions.setProfilesSampleRate(null);
        sentryAndroidOptions.setProfileSessionSampleRate(null);
        sentryAndroidOptions.setProfilesSampler(null);
        sentryAndroidOptions.setStartProfilerOnAppStart(false);
        sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(false);
        sentryAndroidOptions.setBeforeSendTransaction(new C3155n3.e() { // from class: ir.nasim.ts5
            @Override // io.sentry.C3155n3.e
            public final io.sentry.protocol.C a(io.sentry.protocol.C c2, io.sentry.I i) {
                return C23413ws5.j(this.a, c2, i);
            }
        });
        sentryAndroidOptions.setBeforeSend(new C3155n3.c() { // from class: ir.nasim.us5
            @Override // io.sentry.C3155n3.c
            public final io.sentry.L2 a(io.sentry.L2 l2, io.sentry.I i) {
                return C23413ws5.k(this.a, l2, i);
            }
        });
        sentryAndroidOptions.setEnableFramesTracking(c23413ws5.b.getEnableFramesTracking());
        sentryAndroidOptions.setAnrEnabled(c23413ws5.b.getEnableAnr());
        sentryAndroidOptions.setReportHistoricalAnrs(c23413ws5.b.isReportHistoricalAnrs());
        sentryAndroidOptions.setCacheDirPath(context.getCacheDir().getAbsolutePath());
        sentryAndroidOptions.setMaxCacheItems(c23413ws5.b.getMaxCacheItems());
        sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(c23413ws5.b.getEnableAppLifecycleBreadcrumbs());
        sentryAndroidOptions.setEnableSystemEventBreadcrumbs(c23413ws5.b.getEnableSystemEventBreadcrumbs());
        sentryAndroidOptions.setEnableUserInteractionTracing(false);
        sentryAndroidOptions.setMaxBreadcrumbs(c23413ws5.b.getMaxBreadcrumbs());
        sentryAndroidOptions.setEnableRootCheck(c23413ws5.b.getEnableRootCheck());
        sentryAndroidOptions.setEnableUncaughtExceptionHandler(c23413ws5.b.getEnableUncaughtExceptionHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.sentry.protocol.C j(C23413ws5 c23413ws5, io.sentry.protocol.C c2, io.sentry.I i) {
        AbstractC13042fc3.i(c23413ws5, "this$0");
        AbstractC13042fc3.i(c2, "transaction");
        AbstractC13042fc3.i(i, "<unused var>");
        c2.g0((io.sentry.protocol.G) c23413ws5.a.get());
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.sentry.L2 k(C23413ws5 c23413ws5, io.sentry.L2 l2, io.sentry.I i) {
        AbstractC13042fc3.i(c23413ws5, "this$0");
        AbstractC13042fc3.i(l2, "event");
        AbstractC13042fc3.i(i, "<unused var>");
        l2.g0((io.sentry.protocol.G) c23413ws5.a.get());
        return l2;
    }

    private final boolean l(io.sentry.W3 w3) {
        String strE = w3.e();
        AbstractC13042fc3.h(strE, "getOperation(...)");
        return AbstractC20153rZ6.S(strE, "ui.load", false, 2, null) || AbstractC13042fc3.d(w3.w(), "app.launch");
    }

    @Override // ir.nasim.InterfaceC12566ep6
    public void a(final Context context) {
        AbstractC13042fc3.i(context, "context");
        io.sentry.android.core.O0.g(context, new Z1.a() { // from class: ir.nasim.ss5
            @Override // io.sentry.Z1.a
            public final void a(C3155n3 c3155n3) {
                C23413ws5.i(this.a, context, (SentryAndroidOptions) c3155n3);
            }
        });
    }
}
