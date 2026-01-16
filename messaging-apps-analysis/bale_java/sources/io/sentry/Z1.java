package io.sentry;

import io.sentry.protocol.C3171f;
import io.sentry.util.AbstractC3205d;
import io.sentry.util.AbstractC3209h;
import io.sentry.util.C3202a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class Z1 {
    private static volatile InterfaceC3032a0 a = T0.b();
    private static volatile Z b = R0.h();
    private static final X c = new B1(C3155n3.empty());
    private static volatile boolean d = false;
    private static final Charset e = Charset.forName("UTF-8");
    private static final long f = System.currentTimeMillis();
    private static final C3202a g = new C3202a();

    public interface a {
        void a(C3155n3 c3155n3);
    }

    private static void A(C3155n3 c3155n3) {
        if (c3155n3.isDebug() && (c3155n3.getLogger() instanceof L0)) {
            c3155n3.setLogger(new S3());
        }
    }

    private static void B(C3155n3 c3155n3) {
        t().close();
        if (EnumC3125h3.OFF == c3155n3.getOpenTelemetryMode()) {
            a = new C3161p();
        } else {
            a = O1.a(new io.sentry.util.r(), L0.e());
        }
    }

    public static boolean C() {
        return r().isEnabled();
    }

    public static boolean D() {
        return r().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(C3155n3 c3155n3) {
        String cacheDirPathWithoutDsn = c3155n3.getCacheDirPathWithoutDsn();
        if (cacheDirPathWithoutDsn != null) {
            File file = new File(cacheDirPathWithoutDsn, "app_start_profiling_config");
            try {
                AbstractC3209h.a(file);
                if (c3155n3.isEnableAppStartProfiling() || c3155n3.isStartProfilerOnAppStart()) {
                    if (!c3155n3.isStartProfilerOnAppStart() && !c3155n3.isTracingEnabled()) {
                        c3155n3.getLogger().c(Y2.INFO, "Tracing is disabled and app start profiling will not start.", new Object[0]);
                        return;
                    }
                    if (file.createNewFile()) {
                        C3034a2 c3034a2 = new C3034a2(c3155n3, c3155n3.isEnableAppStartProfiling() ? L(c3155n3) : new V3(Boolean.FALSE));
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, e));
                            try {
                                c3155n3.getSerializer().a(c3034a2, bufferedWriter);
                                bufferedWriter.close();
                                fileOutputStream.close();
                            } finally {
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                c3155n3.getLogger().b(Y2.ERROR, "Unable to create app start profiling config file. ", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.lastModified() < f - TimeUnit.MINUTES.toMillis(5L)) {
                AbstractC3209h.a(file2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(C3155n3 c3155n3) {
        for (T t : c3155n3.getOptionsObservers()) {
            t.g(c3155n3.getRelease());
            t.e(c3155n3.getProguardUuid());
            t.f(c3155n3.getSdkVersion());
            t.b(c3155n3.getDist());
            t.d(c3155n3.getEnvironment());
            t.a(c3155n3.getTags());
            t.c(c3155n3.getSessionReplay().g());
        }
        io.sentry.cache.q qVarFindPersistingScopeObserver = c3155n3.findPersistingScopeObserver();
        if (qVarFindPersistingScopeObserver != null) {
            qVarFindPersistingScopeObserver.A();
        }
    }

    private static void I(C3155n3 c3155n3) {
        try {
            c3155n3.getExecutorService().submit(new F0(c3155n3));
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.DEBUG, "Failed to move previous session.", th);
        }
    }

    private static void J(final C3155n3 c3155n3) {
        try {
            c3155n3.getExecutorService().submit(new Runnable() { // from class: io.sentry.Y1
                @Override // java.lang.Runnable
                public final void run() {
                    Z1.H(c3155n3);
                }
            });
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.DEBUG, "Failed to notify options observers.", th);
        }
    }

    private static boolean K(C3155n3 c3155n3) {
        if (c3155n3.isEnableExternalConfiguration()) {
            c3155n3.merge(F.g(io.sentry.config.g.a(), c3155n3.getLogger()));
        }
        String dsn = c3155n3.getDsn();
        if (!c3155n3.isEnabled() || (dsn != null && dsn.isEmpty())) {
            l();
            return false;
        }
        if (dsn == null) {
            throw new IllegalArgumentException("DSN is required. Use empty string or set enabled to false in SentryOptions to disable SDK.");
        }
        c3155n3.retrieveParsedDsn();
        return true;
    }

    private static V3 L(C3155n3 c3155n3) {
        W3 w3 = new W3("app.launch", "profile");
        w3.z(true);
        return c3155n3.getInternalTracesSampler().a(new A1(w3, null, Double.valueOf(io.sentry.util.z.a().d()), null));
    }

    public static void M() {
        r().l();
    }

    public static InterfaceC3127i0 N(W3 w3, Y3 y3) {
        return r().K(w3, y3);
    }

    public static void e(C3106e c3106e, I i) {
        r().b(c3106e, i);
    }

    private static void f(a aVar, C3155n3 c3155n3) {
        try {
            aVar.a(c3155n3);
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
    }

    public static io.sentry.protocol.v g(L2 l2) {
        return r().J(l2);
    }

    public static io.sentry.protocol.v h(L2 l2, I i) {
        return r().I(l2, i);
    }

    public static io.sentry.protocol.v i(C3171f c3171f) {
        return r().N(c3171f);
    }

    public static io.sentry.protocol.v j(C3171f c3171f, I i) {
        return r().H(c3171f, i);
    }

    public static io.sentry.protocol.v k(C3171f c3171f, I i, D1 d1) {
        return r().E(c3171f, i, d1);
    }

    public static void l() {
        InterfaceC3102d0 interfaceC3102d0A = g.a();
        try {
            Z zR = r();
            b = R0.h();
            t().close();
            zR.i(false);
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
    }

    public static void m(F1 f1, D1 d1) {
        r().B(f1, d1);
    }

    public static void n() {
        r().g();
    }

    private static void o(C3155n3 c3155n3, Z z) {
        try {
            c3155n3.getExecutorService().submit(new RunnableC3153n1(c3155n3, z));
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.DEBUG, "Failed to finalize previous session.", th);
        }
    }

    public static void p(long j) {
        r().r(j);
    }

    public static Z q(String str) {
        return r().M(str);
    }

    public static Z r() {
        if (d) {
            return b;
        }
        Z z = t().get();
        if (z != null && !z.A()) {
            return z;
        }
        Z zM = b.M("getCurrentScopes");
        t().a(zM);
        return zM;
    }

    public static X s() {
        return c;
    }

    private static InterfaceC3032a0 t() {
        return a;
    }

    private static void u(final C3155n3 c3155n3, InterfaceC3097c0 interfaceC3097c0) {
        try {
            interfaceC3097c0.submit(new Runnable() { // from class: io.sentry.W1
                @Override // java.lang.Runnable
                public final void run() {
                    Z1.E(c3155n3);
                }
            });
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Failed to call the executor. App start profiling config will not be changed. Did you call Sentry.close()?", th);
        }
    }

    public static void v(C3128i1 c3128i1, a aVar, boolean z) {
        C3155n3 c3155n3 = (C3155n3) c3128i1.b();
        f(aVar, c3155n3);
        w(c3155n3, z);
    }

    private static void w(final C3155n3 c3155n3, boolean z) {
        InterfaceC3102d0 interfaceC3102d0A = g.a();
        try {
            if (!c3155n3.getClass().getName().equals("io.sentry.android.core.SentryAndroidOptions") && io.sentry.util.w.a()) {
                throw new IllegalArgumentException("You are running Android. Please, use SentryAndroid.init. " + c3155n3.getClass().getName());
            }
            if (!K(c3155n3)) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            Boolean boolIsGlobalHubMode = c3155n3.isGlobalHubMode();
            if (boolIsGlobalHubMode != null) {
                z = boolIsGlobalHubMode.booleanValue();
            }
            c3155n3.getLogger().c(Y2.INFO, "GlobalHubMode: '%s'", String.valueOf(z));
            d = z;
            y(c3155n3);
            if (io.sentry.util.n.a(c.e(), c3155n3, C())) {
                if (C()) {
                    c3155n3.getLogger().c(Y2.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
                }
                try {
                    c3155n3.getExecutorService().submit(new Runnable() { // from class: io.sentry.V1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c3155n3.loadLazyFields();
                        }
                    });
                } catch (RejectedExecutionException e2) {
                    c3155n3.getLogger().b(Y2.DEBUG, "Failed to call the executor. Lazy fields will not be loaded. Did you call Sentry.close()?", e2);
                }
                r().i(true);
                X x = c;
                x.m(c3155n3);
                b = new M1(new B1(c3155n3), new B1(c3155n3), x, "Sentry.init");
                A(c3155n3);
                z(c3155n3);
                t().a(b);
                x(c3155n3);
                x.x(new C3114f2(c3155n3));
                if (c3155n3.getExecutorService().isClosed()) {
                    c3155n3.setExecutorService(new P2(c3155n3));
                    c3155n3.getExecutorService().a();
                }
                I(c3155n3);
                for (InterfaceC3157o0 interfaceC3157o0 : c3155n3.getIntegrations()) {
                    try {
                        interfaceC3157o0.c(N1.c(), c3155n3);
                    } catch (Throwable th) {
                        c3155n3.getLogger().b(Y2.WARNING, "Failed to register the integration " + interfaceC3157o0.getClass().getName(), th);
                    }
                }
                J(c3155n3);
                o(c3155n3, N1.c());
                u(c3155n3, c3155n3.getExecutorService());
                ILogger logger = c3155n3.getLogger();
                Y2 y2 = Y2.DEBUG;
                logger.c(y2, "Using openTelemetryMode %s", c3155n3.getOpenTelemetryMode());
                c3155n3.getLogger().c(y2, "Using span factory %s", c3155n3.getSpanFactory().getClass().getName());
                c3155n3.getLogger().c(y2, "Using scopes storage %s", a.getClass().getName());
            } else {
                c3155n3.getLogger().c(Y2.WARNING, "This init call has been ignored due to priority being too low.", new Object[0]);
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th2) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    private static void x(C3155n3 c3155n3) {
        ILogger logger = c3155n3.getLogger();
        Y2 y2 = Y2.INFO;
        logger.c(y2, "Initializing SDK with DSN: '%s'", c3155n3.getDsn());
        String outboxPath = c3155n3.getOutboxPath();
        if (outboxPath != null) {
            new File(outboxPath).mkdirs();
        } else {
            logger.c(y2, "No outbox dir path is defined in options.", new Object[0]);
        }
        String cacheDirPath = c3155n3.getCacheDirPath();
        if (cacheDirPath != null) {
            new File(cacheDirPath).mkdirs();
            if (c3155n3.getEnvelopeDiskCache() instanceof io.sentry.transport.s) {
                c3155n3.setEnvelopeDiskCache(io.sentry.cache.f.N(c3155n3));
            }
        }
        String profilingTracesDirPath = c3155n3.getProfilingTracesDirPath();
        if ((c3155n3.isProfilingEnabled() || c3155n3.isContinuousProfilingEnabled()) && profilingTracesDirPath != null) {
            final File file = new File(profilingTracesDirPath);
            file.mkdirs();
            try {
                c3155n3.getExecutorService().submit(new Runnable() { // from class: io.sentry.X1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Z1.G(file);
                    }
                });
            } catch (RejectedExecutionException e2) {
                c3155n3.getLogger().b(Y2.ERROR, "Failed to call the executor. Old profiles will not be deleted. Did you call Sentry.close()?", e2);
            }
        }
        io.sentry.internal.modules.b modulesLoader = c3155n3.getModulesLoader();
        if (!c3155n3.isSendModules()) {
            c3155n3.setModulesLoader(io.sentry.internal.modules.e.b());
        } else if (modulesLoader instanceof io.sentry.internal.modules.e) {
            c3155n3.setModulesLoader(new io.sentry.internal.modules.a(Arrays.asList(new io.sentry.internal.modules.c(c3155n3.getLogger()), new io.sentry.internal.modules.f(c3155n3.getLogger())), c3155n3.getLogger()));
        }
        if (c3155n3.getDebugMetaLoader() instanceof io.sentry.internal.debugmeta.b) {
            c3155n3.setDebugMetaLoader(new io.sentry.internal.debugmeta.c(c3155n3.getLogger()));
        }
        AbstractC3205d.a(c3155n3, c3155n3.getDebugMetaLoader().a());
        if (c3155n3.getThreadChecker() instanceof io.sentry.util.thread.b) {
            c3155n3.setThreadChecker(io.sentry.util.thread.c.d());
        }
        if (c3155n3.getPerformanceCollectors().isEmpty()) {
            c3155n3.addPerformanceCollector(new C3162p0());
        }
        if (c3155n3.isEnableBackpressureHandling() && io.sentry.util.w.c()) {
            if (c3155n3.getBackpressureMonitor() instanceof io.sentry.backpressure.c) {
                c3155n3.setBackpressureMonitor(new io.sentry.backpressure.a(c3155n3, N1.c()));
            }
            c3155n3.getBackpressureMonitor().start();
        }
    }

    private static void y(C3155n3 c3155n3) {
        if (c3155n3.getFatalLogger() instanceof L0) {
            c3155n3.setFatalLogger(new S3());
        }
    }

    private static void z(C3155n3 c3155n3) {
        io.sentry.opentelemetry.a.c(c3155n3, new io.sentry.util.r());
        if (EnumC3125h3.OFF == c3155n3.getOpenTelemetryMode()) {
            c3155n3.setSpanFactory(new C3175q());
        }
        B(c3155n3);
        io.sentry.opentelemetry.a.a(c3155n3);
    }
}
