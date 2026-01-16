package io.sentry;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.sentry.Q2;
import io.sentry.util.C3202a;
import io.sentry.util.q;
import java.io.File;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: io.sentry.n3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3155n3 {
    static final Y2 DEFAULT_DIAGNOSTIC_LEVEL = Y2.DEBUG;
    private static final String DEFAULT_ENVIRONMENT = "production";
    public static final String DEFAULT_PROPAGATION_TARGETS = ".*";
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;
    private io.sentry.backpressure.b backpressureMonitor;
    private a beforeBreadcrumb;
    private b beforeEnvelopeCallback;
    private c beforeSend;
    private c beforeSendFeedback;
    private d beforeSendReplay;
    private e beforeSendTransaction;
    private final Set<String> bundleIds;
    private String cacheDirPath;
    private boolean captureOpenTelemetryEvents;
    io.sentry.clientreport.h clientReportRecorder;
    private InterfaceC3126i compositePerformanceCollector;
    private N connectionStatusProvider;
    private int connectionTimeoutMillis;
    private final List<String> contextTags;
    private O continuousProfiler;
    private f cron;
    private final io.sentry.util.q dateProvider;
    private long deadlineTimeout;
    private boolean debug;
    private io.sentry.internal.debugmeta.a debugMetaLoader;
    private F1 defaultScopeType;
    private final List<String> defaultTracePropagationTargets;
    private Y2 diagnosticLevel;
    private String dist;
    private String distinctId;
    private String dsn;
    private String dsnHash;
    private boolean enableAppStartProfiling;
    private boolean enableAutoSessionTracking;
    private boolean enableBackpressureHandling;
    private boolean enableDeduplication;
    private boolean enableExternalConfiguration;
    private boolean enablePrettySerializationOutput;
    private boolean enableScopePersistence;
    private boolean enableScreenTracking;
    private boolean enableShutdownHook;
    private boolean enableSpotlight;
    private boolean enableTimeToFullDisplayTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private boolean enabled;
    private io.sentry.cache.g envelopeDiskCache;
    private final io.sentry.util.q envelopeReader;
    private String environment;
    private final List<D> eventProcessors;
    private InterfaceC3097c0 executorService;
    private final E experimental;
    private ILogger fatalLogger;
    private Q2 feedbackOptions;
    private long flushTimeoutMillis;
    private boolean forceInit;
    private H fullyDisplayedReporter;
    private final List<io.sentry.internal.gestures.a> gestureTargetLocators;
    private Boolean globalHubMode;
    private Long idleTimeout;
    private List<G> ignoredCheckIns;
    private List<G> ignoredErrors;
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType;
    private List<G> ignoredSpanOrigins;
    private List<G> ignoredTransactions;
    private final List<String> inAppExcludes;
    private final List<String> inAppIncludes;
    private EnumC3147m0 initPriority;
    private EnumC3152n0 instrumenter;
    private final List<InterfaceC3157o0> integrations;
    private volatile U3 internalTracesSampler;
    protected final C3202a lock;
    private ILogger logger;
    private g logs;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxQueueSize;
    private k maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;
    private io.sentry.internal.modules.b modulesLoader;
    private final List<Y> observers;
    private h onDiscard;
    private EnumC3125h3 openTelemetryMode;
    private final List<T> optionsObservers;
    private final io.sentry.util.q parsedDsn;
    private final List<U> performanceCollectors;
    private boolean printUncaughtStackTrace;
    private EnumC3177q1 profileLifecycle;
    private Double profileSessionSampleRate;
    private Double profilesSampleRate;
    private i profilesSampler;
    private int profilingTracesHz;
    private String proguardUuid;
    private j proxy;
    private int readTimeoutMillis;
    private String release;
    private InterfaceC3217w1 replayController;
    private Double sampleRate;
    private io.sentry.protocol.p sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private boolean sendModules;
    private String sentryClientName;
    private final io.sentry.util.q serializer;
    private String serverName;
    private long sessionFlushTimeoutMillis;
    private C3165p3 sessionReplay;
    private long sessionTrackingIntervalMillis;
    private long shutdownTimeoutMillis;
    private InterfaceC3112f0 socketTagger;
    private InterfaceC3122h0 spanFactory;
    private String spotlightConnectionUrl;
    private SSLSocketFactory sslSocketFactory;
    private boolean startProfilerOnAppStart;
    private final Map<String, String> tags;
    private io.sentry.util.thread.a threadChecker;
    private boolean traceOptionsRequests;
    private List<String> tracePropagationTargets;
    private boolean traceSampling;
    private Double tracesSampleRate;
    private l tracesSampler;
    private InterfaceC3132j0 transactionProfiler;
    private InterfaceC3137k0 transportFactory;
    private io.sentry.transport.r transportGate;
    private InterfaceC3142l0 versionDetector;
    private final List<Object> viewHierarchyExporters;

    /* renamed from: io.sentry.n3$a */
    public interface a {
    }

    /* renamed from: io.sentry.n3$b */
    public interface b {
        void a(C3134j2 c3134j2, I i);
    }

    /* renamed from: io.sentry.n3$c */
    public interface c {
        L2 a(L2 l2, I i);
    }

    /* renamed from: io.sentry.n3$d */
    public interface d {
    }

    /* renamed from: io.sentry.n3$e */
    public interface e {
        io.sentry.protocol.C a(io.sentry.protocol.C c, I i);
    }

    /* renamed from: io.sentry.n3$f */
    public static final class f {
        private Long a;
        private Long b;
        private String c;
        private Long d;
        private Long e;

        public Long a() {
            return this.a;
        }

        public Long b() {
            return this.d;
        }

        public Long c() {
            return this.b;
        }

        public Long d() {
            return this.e;
        }

        public String e() {
            return this.c;
        }

        public void f(Long l) {
            this.a = l;
        }

        public void g(Long l) {
            this.d = l;
        }

        public void h(Long l) {
            this.b = l;
        }

        public void i(Long l) {
            this.e = l;
        }

        public void j(String str) {
            this.c = str;
        }
    }

    /* renamed from: io.sentry.n3$g */
    public static final class g {
        private boolean a = false;

        public boolean a() {
            return this.a;
        }

        public void b(boolean z) {
            this.a = z;
        }
    }

    /* renamed from: io.sentry.n3$h */
    public interface h {
    }

    /* renamed from: io.sentry.n3$i */
    public interface i {
    }

    /* renamed from: io.sentry.n3$j */
    public static final class j {
        private String a;
        private String b;
        private String c;
        private String d;
        private Proxy.Type e;

        public j(String str, String str2, String str3, String str4) {
            this(str, str2, null, str3, str4);
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.d;
        }

        public String c() {
            return this.b;
        }

        public Proxy.Type d() {
            return this.e;
        }

        public String e() {
            return this.c;
        }

        public j(String str, String str2, Proxy.Type type, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.e = type;
            this.c = str3;
            this.d = str4;
        }
    }

    /* renamed from: io.sentry.n3$k */
    public enum k {
        NONE,
        SMALL,
        MEDIUM,
        ALWAYS
    }

    /* renamed from: io.sentry.n3$l */
    public interface l {
        Double a(A1 a1);
    }

    public C3155n3() {
        this(false);
    }

    private io.sentry.protocol.p createSdkVersion() {
        io.sentry.protocol.p pVar = new io.sentry.protocol.p("sentry.java", "8.20.0");
        pVar.j("8.20.0");
        return pVar;
    }

    private void e() {
        W2.d().b("maven:io.sentry:sentry", "8.20.0");
    }

    public static C3155n3 empty() {
        return new C3155n3(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C3215w f() {
        return new C3215w(this.dsn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceC3107e0 g() {
        return new B0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ P h() {
        return new C3225y((InterfaceC3107e0) this.serializer.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC3129i2 i() {
        return new C3094b2();
    }

    public void addBundleId(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.bundleIds.add(strTrim);
        }
    }

    public void addContextTag(String str) {
        this.contextTags.add(str);
    }

    public void addEventProcessor(D d2) {
        this.eventProcessors.add(d2);
    }

    public void addIgnoredCheckIn(String str) {
        if (this.ignoredCheckIns == null) {
            this.ignoredCheckIns = new ArrayList();
        }
        this.ignoredCheckIns.add(new G(str));
    }

    public void addIgnoredError(String str) {
        if (this.ignoredErrors == null) {
            this.ignoredErrors = new ArrayList();
        }
        this.ignoredErrors.add(new G(str));
    }

    public void addIgnoredExceptionForType(Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    public void addIgnoredSpanOrigin(String str) {
        if (this.ignoredSpanOrigins == null) {
            this.ignoredSpanOrigins = new ArrayList();
        }
        this.ignoredSpanOrigins.add(new G(str));
    }

    public void addIgnoredTransaction(String str) {
        if (this.ignoredTransactions == null) {
            this.ignoredTransactions = new ArrayList();
        }
        this.ignoredTransactions.add(new G(str));
    }

    public void addInAppExclude(String str) {
        this.inAppExcludes.add(str);
    }

    public void addInAppInclude(String str) {
        this.inAppIncludes.add(str);
    }

    public void addIntegration(InterfaceC3157o0 interfaceC3157o0) {
        this.integrations.add(interfaceC3157o0);
    }

    public void addOptionsObserver(T t) {
        this.optionsObservers.add(t);
    }

    public void addPerformanceCollector(U u) {
        this.performanceCollectors.add(u);
    }

    public void addScopeObserver(Y y) {
        this.observers.add(y);
    }

    boolean containsIgnoredExceptionForType(Throwable th) {
        return this.ignoredExceptionsForType.contains(th.getClass());
    }

    public io.sentry.cache.q findPersistingScopeObserver() {
        for (Y y : this.observers) {
            if (y instanceof io.sentry.cache.q) {
                return (io.sentry.cache.q) y;
            }
        }
        return null;
    }

    public io.sentry.backpressure.b getBackpressureMonitor() {
        return this.backpressureMonitor;
    }

    public a getBeforeBreadcrumb() {
        return null;
    }

    public b getBeforeEnvelopeCallback() {
        return this.beforeEnvelopeCallback;
    }

    public c getBeforeSend() {
        return this.beforeSend;
    }

    public c getBeforeSendFeedback() {
        return this.beforeSendFeedback;
    }

    public d getBeforeSendReplay() {
        return null;
    }

    public e getBeforeSendTransaction() {
        return this.beforeSendTransaction;
    }

    public Set<String> getBundleIds() {
        return this.bundleIds;
    }

    public String getCacheDirPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.dsnHash != null ? new File(this.cacheDirPath, this.dsnHash).getAbsolutePath() : this.cacheDirPath;
    }

    String getCacheDirPathWithoutDsn() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.cacheDirPath;
    }

    public io.sentry.clientreport.h getClientReportRecorder() {
        return this.clientReportRecorder;
    }

    public InterfaceC3126i getCompositePerformanceCollector() {
        return this.compositePerformanceCollector;
    }

    public N getConnectionStatusProvider() {
        return this.connectionStatusProvider;
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    public List<String> getContextTags() {
        return this.contextTags;
    }

    public O getContinuousProfiler() {
        return this.continuousProfiler;
    }

    public f getCron() {
        return this.cron;
    }

    public InterfaceC3129i2 getDateProvider() {
        return (InterfaceC3129i2) this.dateProvider.a();
    }

    public long getDeadlineTimeout() {
        return this.deadlineTimeout;
    }

    public io.sentry.internal.debugmeta.a getDebugMetaLoader() {
        return this.debugMetaLoader;
    }

    public F1 getDefaultScopeType() {
        return this.defaultScopeType;
    }

    public Y2 getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    public String getDist() {
        return this.dist;
    }

    public String getDistinctId() {
        return this.distinctId;
    }

    public String getDsn() {
        return this.dsn;
    }

    public io.sentry.cache.g getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    public P getEnvelopeReader() {
        return (P) this.envelopeReader.a();
    }

    public String getEnvironment() {
        String str = this.environment;
        return str != null ? str : DEFAULT_ENVIRONMENT;
    }

    public List<D> getEventProcessors() {
        return this.eventProcessors;
    }

    public InterfaceC3097c0 getExecutorService() {
        return this.executorService;
    }

    public E getExperimental() {
        return this.experimental;
    }

    public ILogger getFatalLogger() {
        return this.fatalLogger;
    }

    public Q2 getFeedbackOptions() {
        return this.feedbackOptions;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    public H getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }

    public List<io.sentry.internal.gestures.a> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }

    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    public List<G> getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    public List<G> getIgnoredErrors() {
        return this.ignoredErrors;
    }

    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    public List<G> getIgnoredSpanOrigins() {
        return this.ignoredSpanOrigins;
    }

    public List<G> getIgnoredTransactions() {
        return this.ignoredTransactions;
    }

    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    public EnumC3147m0 getInitPriority() {
        return this.initPriority;
    }

    public EnumC3152n0 getInstrumenter() {
        return this.instrumenter;
    }

    public List<InterfaceC3157o0> getIntegrations() {
        return this.integrations;
    }

    public U3 getInternalTracesSampler() {
        if (this.internalTracesSampler == null) {
            InterfaceC3102d0 interfaceC3102d0A = this.lock.a();
            try {
                if (this.internalTracesSampler == null) {
                    this.internalTracesSampler = new U3(this);
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
        }
        return this.internalTracesSampler;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public g getLogs() {
        return this.logs;
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public k getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    public int getMaxSpans() {
        return this.maxSpans;
    }

    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }

    public io.sentry.internal.modules.b getModulesLoader() {
        return this.modulesLoader;
    }

    public h getOnDiscard() {
        return null;
    }

    public EnumC3125h3 getOpenTelemetryMode() {
        return this.openTelemetryMode;
    }

    public List<T> getOptionsObservers() {
        return this.optionsObservers;
    }

    public String getOutboxPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "outbox").getAbsolutePath();
    }

    public List<U> getPerformanceCollectors() {
        return this.performanceCollectors;
    }

    public EnumC3177q1 getProfileLifecycle() {
        return this.profileLifecycle;
    }

    public Double getProfileSessionSampleRate() {
        return this.profileSessionSampleRate;
    }

    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    public i getProfilesSampler() {
        return null;
    }

    public String getProfilingTracesDirPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "profiling_traces").getAbsolutePath();
    }

    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    public String getProguardUuid() {
        return this.proguardUuid;
    }

    public j getProxy() {
        return this.proxy;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public String getRelease() {
        return this.release;
    }

    public InterfaceC3217w1 getReplayController() {
        return this.replayController;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public List<Y> getScopeObservers() {
        return this.observers;
    }

    public io.sentry.protocol.p getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSentryClientName() {
        return this.sentryClientName;
    }

    public InterfaceC3107e0 getSerializer() {
        return (InterfaceC3107e0) this.serializer.a();
    }

    public String getServerName() {
        return this.serverName;
    }

    public long getSessionFlushTimeoutMillis() {
        return this.sessionFlushTimeoutMillis;
    }

    public C3165p3 getSessionReplay() {
        return this.sessionReplay;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    public InterfaceC3112f0 getSocketTagger() {
        return this.socketTagger;
    }

    public InterfaceC3122h0 getSpanFactory() {
        return this.spanFactory;
    }

    public String getSpotlightConnectionUrl() {
        return this.spotlightConnectionUrl;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public io.sentry.util.thread.a getThreadChecker() {
        return this.threadChecker;
    }

    public List<String> getTracePropagationTargets() {
        List<String> list = this.tracePropagationTargets;
        return list == null ? this.defaultTracePropagationTargets : list;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public l getTracesSampler() {
        return this.tracesSampler;
    }

    public InterfaceC3132j0 getTransactionProfiler() {
        return this.transactionProfiler;
    }

    public InterfaceC3137k0 getTransportFactory() {
        return this.transportFactory;
    }

    public io.sentry.transport.r getTransportGate() {
        return this.transportGate;
    }

    public InterfaceC3142l0 getVersionDetector() {
        return this.versionDetector;
    }

    public final List<Object> getViewHierarchyExporters() {
        return this.viewHierarchyExporters;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    public boolean isCaptureOpenTelemetryEvents() {
        return this.captureOpenTelemetryEvents;
    }

    public boolean isContinuousProfilingEnabled() {
        Double d2;
        return this.profilesSampleRate == null && (d2 = this.profileSessionSampleRate) != null && d2.doubleValue() > 0.0d;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isEnableAppStartProfiling() {
        return (isProfilingEnabled() || isContinuousProfilingEnabled()) && this.enableAppStartProfiling;
    }

    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }

    public boolean isEnableBackpressureHandling() {
        return this.enableBackpressureHandling;
    }

    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    public boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public boolean isEnableScopePersistence() {
        return this.enableScopePersistence;
    }

    public boolean isEnableScreenTracking() {
        return this.enableScreenTracking;
    }

    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }

    public boolean isEnableSpotlight() {
        return this.enableSpotlight;
    }

    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }

    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isForceInit() {
        return this.forceInit;
    }

    public Boolean isGlobalHubMode() {
        return this.globalHubMode;
    }

    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public boolean isProfilingEnabled() {
        Double d2 = this.profilesSampleRate;
        return d2 != null && d2.doubleValue() > 0.0d;
    }

    public boolean isSendClientReports() {
        return this.sendClientReports;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public boolean isSendModules() {
        return this.sendModules;
    }

    public boolean isStartProfilerOnAppStart() {
        return this.startProfilerOnAppStart;
    }

    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }

    public boolean isTraceSampling() {
        return this.traceSampling;
    }

    public boolean isTracingEnabled() {
        return (getTracesSampleRate() == null && getTracesSampler() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadLazyFields() {
        getSerializer();
        retrieveParsedDsn();
        getEnvelopeReader();
        getDateProvider();
    }

    public void merge(F f2) {
        if (f2.m() != null) {
            setDsn(f2.m());
        }
        if (f2.p() != null) {
            setEnvironment(f2.p());
        }
        if (f2.C() != null) {
            setRelease(f2.C());
        }
        if (f2.l() != null) {
            setDist(f2.l());
        }
        if (f2.E() != null) {
            setServerName(f2.E());
        }
        if (f2.B() != null) {
            setProxy(f2.B());
        }
        if (f2.o() != null) {
            setEnableUncaughtExceptionHandler(f2.o().booleanValue());
        }
        if (f2.y() != null) {
            setPrintUncaughtStackTrace(f2.y().booleanValue());
        }
        if (f2.I() != null) {
            setTracesSampleRate(f2.I());
        }
        if (f2.z() != null) {
            setProfilesSampleRate(f2.z());
        }
        if (f2.k() != null) {
            setDebug(f2.k().booleanValue());
        }
        if (f2.n() != null) {
            setEnableDeduplication(f2.n().booleanValue());
        }
        if (f2.D() != null) {
            setSendClientReports(f2.D().booleanValue());
        }
        if (f2.P() != null) {
            setForceInit(f2.P().booleanValue());
        }
        for (Map.Entry entry : new HashMap(f2.G()).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
        Iterator it = new ArrayList(f2.w()).iterator();
        while (it.hasNext()) {
            addInAppInclude((String) it.next());
        }
        Iterator it2 = new ArrayList(f2.v()).iterator();
        while (it2.hasNext()) {
            addInAppExclude((String) it2.next());
        }
        Iterator it3 = new HashSet(f2.t()).iterator();
        while (it3.hasNext()) {
            addIgnoredExceptionForType((Class) it3.next());
        }
        if (f2.H() != null) {
            setTracePropagationTargets(new ArrayList(f2.H()));
        }
        Iterator it4 = new ArrayList(f2.i()).iterator();
        while (it4.hasNext()) {
            addContextTag((String) it4.next());
        }
        if (f2.A() != null) {
            setProguardUuid(f2.A());
        }
        if (f2.q() != null) {
            setIdleTimeout(f2.q());
        }
        Iterator it5 = f2.h().iterator();
        while (it5.hasNext()) {
            addBundleId((String) it5.next());
        }
        if (f2.O() != null) {
            setEnabled(f2.O().booleanValue());
        }
        if (f2.M() != null) {
            setEnablePrettySerializationOutput(f2.M().booleanValue());
        }
        if (f2.S() != null) {
            setSendModules(f2.S().booleanValue());
        }
        if (f2.r() != null) {
            setIgnoredCheckIns(new ArrayList(f2.r()));
        }
        if (f2.u() != null) {
            setIgnoredTransactions(new ArrayList(f2.u()));
        }
        if (f2.s() != null) {
            setIgnoredErrors(new ArrayList(f2.s()));
        }
        if (f2.K() != null) {
            setEnableBackpressureHandling(f2.K().booleanValue());
        }
        if (f2.x() != null) {
            setMaxRequestBodySize(f2.x());
        }
        if (f2.R() != null) {
            setSendDefaultPii(f2.R().booleanValue());
        }
        if (f2.J() != null) {
            setCaptureOpenTelemetryEvents(f2.J().booleanValue());
        }
        if (f2.N() != null) {
            setEnableSpotlight(f2.N().booleanValue());
        }
        if (f2.F() != null) {
            setSpotlightConnectionUrl(f2.F());
        }
        if (f2.Q() != null) {
            setGlobalHubMode(f2.Q());
        }
        if (f2.j() != null) {
            if (getCron() == null) {
                setCron(f2.j());
            } else {
                if (f2.j().a() != null) {
                    getCron().f(f2.j().a());
                }
                if (f2.j().c() != null) {
                    getCron().h(f2.j().c());
                }
                if (f2.j().e() != null) {
                    getCron().j(f2.j().e());
                }
                if (f2.j().b() != null) {
                    getCron().g(f2.j().b());
                }
                if (f2.j().d() != null) {
                    getCron().i(f2.j().d());
                }
            }
        }
        if (f2.L() != null) {
            getLogs().b(f2.L().booleanValue());
        }
    }

    C3215w retrieveParsedDsn() {
        return (C3215w) this.parsedDsn.a();
    }

    public void setAttachServerName(boolean z) {
        this.attachServerName = z;
    }

    public void setAttachStacktrace(boolean z) {
        this.attachStacktrace = z;
    }

    public void setAttachThreads(boolean z) {
        this.attachThreads = z;
    }

    public void setBackpressureMonitor(io.sentry.backpressure.b bVar) {
        this.backpressureMonitor = bVar;
    }

    public void setBeforeBreadcrumb(a aVar) {
    }

    public void setBeforeEnvelopeCallback(b bVar) {
        this.beforeEnvelopeCallback = bVar;
    }

    public void setBeforeSend(c cVar) {
        this.beforeSend = cVar;
    }

    public void setBeforeSendFeedback(c cVar) {
        this.beforeSendFeedback = cVar;
    }

    public void setBeforeSendReplay(d dVar) {
    }

    public void setBeforeSendTransaction(e eVar) {
        this.beforeSendTransaction = eVar;
    }

    public void setCacheDirPath(String str) {
        this.cacheDirPath = str;
    }

    public void setCaptureOpenTelemetryEvents(boolean z) {
        this.captureOpenTelemetryEvents = z;
    }

    public void setCompositePerformanceCollector(InterfaceC3126i interfaceC3126i) {
        this.compositePerformanceCollector = interfaceC3126i;
    }

    public void setConnectionStatusProvider(N n) {
        this.connectionStatusProvider = n;
    }

    public void setConnectionTimeoutMillis(int i2) {
        this.connectionTimeoutMillis = i2;
    }

    public void setContinuousProfiler(O o) {
        if (this.continuousProfiler != I0.a() || o == null) {
            return;
        }
        this.continuousProfiler = o;
    }

    public void setCron(f fVar) {
        this.cron = fVar;
    }

    public void setDateProvider(InterfaceC3129i2 interfaceC3129i2) {
        this.dateProvider.c(interfaceC3129i2);
    }

    public void setDeadlineTimeout(long j2) {
        this.deadlineTimeout = j2;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setDebugMetaLoader(io.sentry.internal.debugmeta.a aVar) {
        if (aVar == null) {
            aVar = io.sentry.internal.debugmeta.b.b();
        }
        this.debugMetaLoader = aVar;
    }

    public void setDefaultScopeType(F1 f1) {
        this.defaultScopeType = f1;
    }

    public void setDiagnosticLevel(Y2 y2) {
        if (y2 == null) {
            y2 = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = y2;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public void setDistinctId(String str) {
        this.distinctId = str;
    }

    public void setDsn(String str) {
        this.dsn = str;
        this.parsedDsn.b();
        this.dsnHash = io.sentry.util.B.a(this.dsn, this.logger);
    }

    public void setEnableAppStartProfiling(boolean z) {
        this.enableAppStartProfiling = z;
    }

    public void setEnableAutoSessionTracking(boolean z) {
        this.enableAutoSessionTracking = z;
    }

    public void setEnableBackpressureHandling(boolean z) {
        this.enableBackpressureHandling = z;
    }

    public void setEnableDeduplication(boolean z) {
        this.enableDeduplication = z;
    }

    public void setEnableExternalConfiguration(boolean z) {
        this.enableExternalConfiguration = z;
    }

    public void setEnablePrettySerializationOutput(boolean z) {
        this.enablePrettySerializationOutput = z;
    }

    public void setEnableScopePersistence(boolean z) {
        this.enableScopePersistence = z;
    }

    public void setEnableScreenTracking(boolean z) {
        this.enableScreenTracking = z;
    }

    public void setEnableShutdownHook(boolean z) {
        this.enableShutdownHook = z;
    }

    public void setEnableSpotlight(boolean z) {
        this.enableSpotlight = z;
    }

    public void setEnableTimeToFullDisplayTracing(boolean z) {
        this.enableTimeToFullDisplayTracing = z;
    }

    public void setEnableUncaughtExceptionHandler(boolean z) {
        this.enableUncaughtExceptionHandler = z;
    }

    public void setEnableUserInteractionBreadcrumbs(boolean z) {
        this.enableUserInteractionBreadcrumbs = z;
    }

    public void setEnableUserInteractionTracing(boolean z) {
        this.enableUserInteractionTracing = z;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setEnvelopeDiskCache(io.sentry.cache.g gVar) {
        if (gVar == null) {
            gVar = io.sentry.transport.s.f();
        }
        this.envelopeDiskCache = gVar;
    }

    public void setEnvelopeReader(P p) {
        io.sentry.util.q qVar = this.envelopeReader;
        if (p == null) {
            p = J0.b();
        }
        qVar.c(p);
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public void setExecutorService(InterfaceC3097c0 interfaceC3097c0) {
        if (interfaceC3097c0 != null) {
            this.executorService = interfaceC3097c0;
        }
    }

    public void setFatalLogger(ILogger iLogger) {
        if (iLogger == null) {
            iLogger = L0.e();
        }
        this.fatalLogger = iLogger;
    }

    public void setFeedbackOptions(Q2 q2) {
        this.feedbackOptions = q2;
    }

    public void setFlushTimeoutMillis(long j2) {
        this.flushTimeoutMillis = j2;
    }

    public void setForceInit(boolean z) {
        this.forceInit = z;
    }

    public void setFullyDisplayedReporter(H h2) {
        this.fullyDisplayedReporter = h2;
    }

    public void setGestureTargetLocators(List<io.sentry.internal.gestures.a> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll(list);
    }

    public void setGlobalHubMode(Boolean bool) {
        this.globalHubMode = bool;
    }

    public void setIdleTimeout(Long l2) {
        this.idleTimeout = l2;
    }

    public void setIgnoredCheckIns(List<String> list) {
        if (list == null) {
            this.ignoredCheckIns = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(new G(str));
            }
        }
        this.ignoredCheckIns = arrayList;
    }

    public void setIgnoredErrors(List<String> list) {
        if (list == null) {
            this.ignoredErrors = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new G(str));
            }
        }
        this.ignoredErrors = arrayList;
    }

    public void setIgnoredSpanOrigins(List<String> list) {
        if (list == null) {
            this.ignoredSpanOrigins = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new G(str));
            }
        }
        this.ignoredSpanOrigins = arrayList;
    }

    public void setIgnoredTransactions(List<String> list) {
        if (list == null) {
            this.ignoredTransactions = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new G(str));
            }
        }
        this.ignoredTransactions = arrayList;
    }

    public void setInitPriority(EnumC3147m0 enumC3147m0) {
        this.initPriority = enumC3147m0;
    }

    @Deprecated
    public void setInstrumenter(EnumC3152n0 enumC3152n0) {
        this.instrumenter = enumC3152n0;
    }

    public void setLogger(ILogger iLogger) {
        this.logger = iLogger == null ? L0.e() : new C3184s(this, iLogger);
    }

    public void setLogs(g gVar) {
        this.logs = gVar;
    }

    public void setMaxAttachmentSize(long j2) {
        this.maxAttachmentSize = j2;
    }

    public void setMaxBreadcrumbs(int i2) {
        this.maxBreadcrumbs = i2;
    }

    public void setMaxCacheItems(int i2) {
        this.maxCacheItems = i2;
    }

    public void setMaxDepth(int i2) {
        this.maxDepth = i2;
    }

    public void setMaxQueueSize(int i2) {
        if (i2 > 0) {
            this.maxQueueSize = i2;
        }
    }

    public void setMaxRequestBodySize(k kVar) {
        this.maxRequestBodySize = kVar;
    }

    public void setMaxSpans(int i2) {
        this.maxSpans = i2;
    }

    public void setMaxTraceFileSize(long j2) {
        this.maxTraceFileSize = j2;
    }

    public void setModulesLoader(io.sentry.internal.modules.b bVar) {
        if (bVar == null) {
            bVar = io.sentry.internal.modules.e.b();
        }
        this.modulesLoader = bVar;
    }

    public void setOnDiscard(h hVar) {
    }

    public void setOpenTelemetryMode(EnumC3125h3 enumC3125h3) {
        this.openTelemetryMode = enumC3125h3;
    }

    public void setPrintUncaughtStackTrace(boolean z) {
        this.printUncaughtStackTrace = z;
    }

    public void setProfileLifecycle(EnumC3177q1 enumC3177q1) {
        this.profileLifecycle = enumC3177q1;
        if (enumC3177q1 != EnumC3177q1.TRACE || isTracingEnabled()) {
            return;
        }
        this.logger.c(Y2.WARNING, "Profiling lifecycle is set to TRACE but tracing is disabled. Profiling will not be started automatically.", new Object[0]);
    }

    public void setProfileSessionSampleRate(Double d2) {
        if (io.sentry.util.y.c(d2)) {
            this.profileSessionSampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use values between 0.0 and 1.0.");
    }

    public void setProfilesSampleRate(Double d2) {
        if (io.sentry.util.y.d(d2)) {
            this.profilesSampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setProfilesSampler(i iVar) {
    }

    public void setProfilingTracesHz(int i2) {
        this.profilingTracesHz = i2;
    }

    public void setProguardUuid(String str) {
        this.proguardUuid = str;
    }

    public void setProxy(j jVar) {
        this.proxy = jVar;
    }

    public void setReadTimeoutMillis(int i2) {
        this.readTimeoutMillis = i2;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public void setReplayController(InterfaceC3217w1 interfaceC3217w1) {
        if (interfaceC3217w1 == null) {
            interfaceC3217w1 = N0.a();
        }
        this.replayController = interfaceC3217w1;
    }

    public void setSampleRate(Double d2) {
        if (io.sentry.util.y.f(d2)) {
            this.sampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    public void setSdkVersion(io.sentry.protocol.p pVar) {
        io.sentry.protocol.p pVarI = getSessionReplay().i();
        io.sentry.protocol.p pVar2 = this.sdkVersion;
        if (pVar2 != null && pVarI != null && pVar2.equals(pVarI)) {
            getSessionReplay().w(pVar);
        }
        this.sdkVersion = pVar;
    }

    public void setSendClientReports(boolean z) {
        this.sendClientReports = z;
        if (z) {
            this.clientReportRecorder = new io.sentry.clientreport.e(this);
        } else {
            this.clientReportRecorder = new io.sentry.clientreport.j();
        }
    }

    public void setSendDefaultPii(boolean z) {
        this.sendDefaultPii = z;
    }

    public void setSendModules(boolean z) {
        this.sendModules = z;
    }

    public void setSentryClientName(String str) {
        this.sentryClientName = str;
    }

    public void setSerializer(InterfaceC3107e0 interfaceC3107e0) {
        io.sentry.util.q qVar = this.serializer;
        if (interfaceC3107e0 == null) {
            interfaceC3107e0 = Y0.g();
        }
        qVar.c(interfaceC3107e0);
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public void setSessionFlushTimeoutMillis(long j2) {
        this.sessionFlushTimeoutMillis = j2;
    }

    public void setSessionReplay(C3165p3 c3165p3) {
        this.sessionReplay = c3165p3;
    }

    public void setSessionTrackingIntervalMillis(long j2) {
        this.sessionTrackingIntervalMillis = j2;
    }

    public void setShutdownTimeoutMillis(long j2) {
        this.shutdownTimeoutMillis = j2;
    }

    public void setSocketTagger(InterfaceC3112f0 interfaceC3112f0) {
        if (interfaceC3112f0 == null) {
            interfaceC3112f0 = Z0.c();
        }
        this.socketTagger = interfaceC3112f0;
    }

    public void setSpanFactory(InterfaceC3122h0 interfaceC3122h0) {
        this.spanFactory = interfaceC3122h0;
    }

    public void setSpotlightConnectionUrl(String str) {
        this.spotlightConnectionUrl = str;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setStartProfilerOnAppStart(boolean z) {
        this.startProfilerOnAppStart = z;
    }

    public void setTag(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            this.tags.remove(str);
        } else {
            this.tags.put(str, str2);
        }
    }

    public void setThreadChecker(io.sentry.util.thread.a aVar) {
        this.threadChecker = aVar;
    }

    public void setTraceOptionsRequests(boolean z) {
        this.traceOptionsRequests = z;
    }

    public void setTracePropagationTargets(List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        this.tracePropagationTargets = arrayList;
    }

    @Deprecated
    public void setTraceSampling(boolean z) {
        this.traceSampling = z;
    }

    public void setTracesSampleRate(Double d2) {
        if (io.sentry.util.y.g(d2)) {
            this.tracesSampleRate = d2;
            return;
        }
        throw new IllegalArgumentException("The value " + d2 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setTracesSampler(l lVar) {
        this.tracesSampler = lVar;
    }

    public void setTransactionProfiler(InterfaceC3132j0 interfaceC3132j0) {
        if (this.transactionProfiler != C3103d1.c() || interfaceC3132j0 == null) {
            return;
        }
        this.transactionProfiler = interfaceC3132j0;
    }

    public void setTransportFactory(InterfaceC3137k0 interfaceC3137k0) {
        if (interfaceC3137k0 == null) {
            interfaceC3137k0 = C3108e1.b();
        }
        this.transportFactory = interfaceC3137k0;
    }

    public void setTransportGate(io.sentry.transport.r rVar) {
        if (rVar == null) {
            rVar = io.sentry.transport.u.b();
        }
        this.transportGate = rVar;
    }

    public void setVersionDetector(InterfaceC3142l0 interfaceC3142l0) {
        this.versionDetector = interfaceC3142l0;
    }

    public void setViewHierarchyExporters(List<Object> list) {
        this.viewHierarchyExporters.clear();
        this.viewHierarchyExporters.addAll(list);
    }

    private C3155n3(boolean z) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.eventProcessors = copyOnWriteArrayList;
        this.ignoredExceptionsForType = new CopyOnWriteArraySet();
        this.ignoredErrors = null;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.integrations = copyOnWriteArrayList2;
        this.bundleIds = new CopyOnWriteArraySet();
        this.parsedDsn = new io.sentry.util.q(new q.a() { // from class: io.sentry.i3
            @Override // io.sentry.util.q.a
            public final Object a() {
                return this.a.f();
            }
        });
        this.shutdownTimeoutMillis = 2000L;
        this.flushTimeoutMillis = 15000L;
        this.sessionFlushTimeoutMillis = 15000L;
        this.logger = L0.e();
        this.fatalLogger = L0.e();
        this.diagnosticLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        this.serializer = new io.sentry.util.q(new q.a() { // from class: io.sentry.j3
            @Override // io.sentry.util.q.a
            public final Object a() {
                return this.a.g();
            }
        });
        this.envelopeReader = new io.sentry.util.q(new q.a() { // from class: io.sentry.k3
            @Override // io.sentry.util.q.a
            public final Object a() {
                return this.a.h();
            }
        });
        this.maxDepth = 100;
        this.maxCacheItems = 30;
        this.maxQueueSize = 30;
        this.maxBreadcrumbs = 100;
        this.inAppExcludes = new CopyOnWriteArrayList();
        this.inAppIncludes = new CopyOnWriteArrayList();
        this.transportFactory = C3108e1.b();
        this.transportGate = io.sentry.transport.u.b();
        this.attachStacktrace = true;
        this.enableAutoSessionTracking = true;
        this.sessionTrackingIntervalMillis = 30000L;
        this.attachServerName = true;
        this.enableUncaughtExceptionHandler = true;
        this.printUncaughtStackTrace = false;
        this.executorService = X0.f();
        this.connectionTimeoutMillis = 30000;
        this.readTimeoutMillis = 30000;
        this.envelopeDiskCache = io.sentry.transport.s.f();
        this.sendDefaultPii = false;
        this.observers = new CopyOnWriteArrayList();
        this.optionsObservers = new CopyOnWriteArrayList();
        this.tags = new ConcurrentHashMap();
        this.maxAttachmentSize = 20971520L;
        this.enableDeduplication = true;
        this.maxSpans = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        this.enableShutdownHook = true;
        this.maxRequestBodySize = k.NONE;
        this.traceSampling = true;
        this.maxTraceFileSize = 5242880L;
        this.transactionProfiler = C3103d1.c();
        this.continuousProfiler = I0.a();
        this.tracePropagationTargets = null;
        this.defaultTracePropagationTargets = Collections.singletonList(DEFAULT_PROPAGATION_TARGETS);
        this.idleTimeout = 3000L;
        this.contextTags = new CopyOnWriteArrayList();
        this.sendClientReports = true;
        this.clientReportRecorder = new io.sentry.clientreport.e(this);
        this.modulesLoader = io.sentry.internal.modules.e.b();
        this.debugMetaLoader = io.sentry.internal.debugmeta.b.b();
        this.enableUserInteractionTracing = false;
        this.enableUserInteractionBreadcrumbs = true;
        this.instrumenter = EnumC3152n0.SENTRY;
        this.gestureTargetLocators = new ArrayList();
        this.viewHierarchyExporters = new ArrayList();
        this.threadChecker = io.sentry.util.thread.b.d();
        this.traceOptionsRequests = true;
        this.dateProvider = new io.sentry.util.q(new q.a() { // from class: io.sentry.l3
            @Override // io.sentry.util.q.a
            public final Object a() {
                return C3155n3.i();
            }
        });
        this.performanceCollectors = new ArrayList();
        this.compositePerformanceCollector = G0.g();
        this.enableTimeToFullDisplayTracing = false;
        this.fullyDisplayedReporter = H.a();
        this.connectionStatusProvider = new H0();
        this.enabled = true;
        this.enablePrettySerializationOutput = true;
        this.sendModules = true;
        this.enableSpotlight = false;
        this.enableScopePersistence = true;
        this.ignoredCheckIns = null;
        this.ignoredSpanOrigins = null;
        this.ignoredTransactions = null;
        this.backpressureMonitor = io.sentry.backpressure.c.b();
        this.enableBackpressureHandling = true;
        this.enableAppStartProfiling = false;
        this.spanFactory = C3093b1.b();
        this.profilingTracesHz = 101;
        this.cron = null;
        this.replayController = N0.a();
        this.enableScreenTracking = true;
        this.defaultScopeType = F1.ISOLATION;
        this.initPriority = EnumC3147m0.MEDIUM;
        this.forceInit = false;
        this.globalHubMode = null;
        this.lock = new C3202a();
        this.openTelemetryMode = EnumC3125h3.AUTO;
        this.captureOpenTelemetryEvents = false;
        this.versionDetector = C3113f1.b();
        this.profileLifecycle = EnumC3177q1.MANUAL;
        this.startProfilerOnAppStart = false;
        this.deadlineTimeout = 30000L;
        this.logs = new g();
        this.socketTagger = Z0.c();
        io.sentry.protocol.p pVarCreateSdkVersion = createSdkVersion();
        this.experimental = new E(z, pVarCreateSdkVersion);
        this.sessionReplay = new C3165p3(z, pVarCreateSdkVersion);
        this.feedbackOptions = new Q2(new Q2.a() { // from class: io.sentry.m3
        });
        if (z) {
            return;
        }
        setSpanFactory(I3.a(new io.sentry.util.r(), L0.e()));
        P2 p2 = new P2(this);
        this.executorService = p2;
        p2.a();
        copyOnWriteArrayList2.add(new UncaughtExceptionHandlerIntegration());
        copyOnWriteArrayList2.add(new ShutdownHookIntegration());
        copyOnWriteArrayList2.add(new SpotlightIntegration());
        copyOnWriteArrayList.add(new C0(this));
        copyOnWriteArrayList.add(new C3220x(this));
        if (io.sentry.util.w.c()) {
            copyOnWriteArrayList.add(new C3179q3());
        }
        setSentryClientName("sentry.java/8.20.0");
        setSdkVersion(pVarCreateSdkVersion);
        e();
    }
}
