package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalChannelz;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverRegistry;
import io.grpc.ProxyDetector;
import io.grpc.internal.ExponentialBackoffPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class ManagedChannelImplBuilder extends ManagedChannelBuilder<ManagedChannelImplBuilder> {
    String authorityOverride;
    final CallCredentials callCredentials;
    private final ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider;
    InternalChannelz channelz;
    private final ClientTransportFactoryBuilder clientTransportFactoryBuilder;
    CompressorRegistry compressorRegistry;
    DecompressorRegistry decompressorRegistry;
    String defaultLbPolicy;
    Map<String, ?> defaultServiceConfig;
    ObjectPool<? extends Executor> executorPool;
    boolean fullStreamDecompression;
    long idleTimeoutMillis;
    private final List<ClientInterceptor> interceptors;
    boolean lookUpServiceConfig;
    int maxHedgedAttempts;
    int maxRetryAttempts;
    int maxTraceEvents;
    NameResolver.Factory nameResolverFactory;
    final NameResolverRegistry nameResolverRegistry;
    ObjectPool<? extends Executor> offloadExecutorPool;
    long perRpcBufferLimit;
    ProxyDetector proxyDetector;
    private boolean recordFinishedRpcs;
    private boolean recordRealTimeMetrics;
    private boolean recordRetryMetrics;
    private boolean recordStartedRpcs;
    long retryBufferSize;
    boolean retryEnabled;
    private boolean statsEnabled;
    final String target;
    private boolean tracingEnabled;
    String userAgent;
    private static final Logger log = Logger.getLogger(ManagedChannelImplBuilder.class.getName());
    static final long IDLE_MODE_DEFAULT_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(30);
    static final long IDLE_MODE_MIN_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(1);
    private static final ObjectPool<? extends Executor> DEFAULT_EXECUTOR_POOL = SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    private static final DecompressorRegistry DEFAULT_DECOMPRESSOR_REGISTRY = DecompressorRegistry.getDefaultInstance();
    private static final CompressorRegistry DEFAULT_COMPRESSOR_REGISTRY = CompressorRegistry.getDefaultInstance();

    public interface ChannelBuilderDefaultPortProvider {
        int getDefaultPort();
    }

    public interface ClientTransportFactoryBuilder {
        ClientTransportFactory buildClientTransportFactory();
    }

    private static final class ManagedChannelDefaultPortProvider implements ChannelBuilderDefaultPortProvider {
        @Override // io.grpc.internal.ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider
        public int getDefaultPort() {
            return 443;
        }

        private ManagedChannelDefaultPortProvider() {
        }
    }

    public ManagedChannelImplBuilder(String str, ClientTransportFactoryBuilder clientTransportFactoryBuilder, ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        this(str, null, null, clientTransportFactoryBuilder, channelBuilderDefaultPortProvider);
    }

    public ManagedChannelImplBuilder(String str, ChannelCredentials channelCredentials, CallCredentials callCredentials, ClientTransportFactoryBuilder clientTransportFactoryBuilder, ChannelBuilderDefaultPortProvider channelBuilderDefaultPortProvider) {
        ObjectPool<? extends Executor> objectPool = DEFAULT_EXECUTOR_POOL;
        this.executorPool = objectPool;
        this.offloadExecutorPool = objectPool;
        this.interceptors = new ArrayList();
        NameResolverRegistry defaultRegistry = NameResolverRegistry.getDefaultRegistry();
        this.nameResolverRegistry = defaultRegistry;
        this.nameResolverFactory = defaultRegistry.asFactory();
        this.defaultLbPolicy = "pick_first";
        this.decompressorRegistry = DEFAULT_DECOMPRESSOR_REGISTRY;
        this.compressorRegistry = DEFAULT_COMPRESSOR_REGISTRY;
        this.idleTimeoutMillis = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
        this.maxRetryAttempts = 5;
        this.maxHedgedAttempts = 5;
        this.retryBufferSize = 16777216L;
        this.perRpcBufferLimit = 1048576L;
        this.retryEnabled = true;
        this.channelz = InternalChannelz.instance();
        this.lookUpServiceConfig = true;
        this.statsEnabled = true;
        this.recordStartedRpcs = true;
        this.recordFinishedRpcs = true;
        this.recordRealTimeMetrics = false;
        this.recordRetryMetrics = true;
        this.tracingEnabled = true;
        this.target = (String) Preconditions.checkNotNull(str, "target");
        this.callCredentials = callCredentials;
        this.clientTransportFactoryBuilder = (ClientTransportFactoryBuilder) Preconditions.checkNotNull(clientTransportFactoryBuilder, "clientTransportFactoryBuilder");
        if (channelBuilderDefaultPortProvider != null) {
            this.channelBuilderDefaultPortProvider = channelBuilderDefaultPortProvider;
        } else {
            this.channelBuilderDefaultPortProvider = new ManagedChannelDefaultPortProvider();
        }
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return new ManagedChannelOrphanWrapper(new ManagedChannelImpl(this, this.clientTransportFactoryBuilder.buildClientTransportFactory(), new ExponentialBackoffPolicy.Provider(), SharedResourcePool.forResource(GrpcUtil.SHARED_CHANNEL_EXECUTOR), GrpcUtil.STOPWATCH_SUPPLIER, getEffectiveInterceptors(), TimeProvider.SYSTEM_TIME_PROVIDER));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.List<io.grpc.ClientInterceptor> getEffectiveInterceptors() throws java.lang.ClassNotFoundException {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<io.grpc.ClientInterceptor> r1 = r12.interceptors
            r0.<init>(r1)
            boolean r1 = r12.statsEnabled
            java.lang.String r2 = "getClientInterceptor"
            r3 = 0
            r4 = 0
            java.lang.String r5 = "Unable to apply census stats"
            if (r1 == 0) goto L7d
            java.lang.String r1 = "io.grpc.census.InternalCensusStatsAccessor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r6 = 4
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r7[r4] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r9 = 1
            r7[r9] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r10 = 2
            r7[r10] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r11 = 3
            r7[r11] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r7)     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            boolean r7 = r12.recordStartedRpcs     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r6[r4] = r7     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            boolean r7 = r12.recordFinishedRpcs     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r6[r9] = r7     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            boolean r7 = r12.recordRealTimeMetrics     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r6[r10] = r7     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            boolean r7 = r12.recordRetryMetrics     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            r6[r11] = r7     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            java.lang.Object r1 = r1.invoke(r3, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            io.grpc.ClientInterceptor r1 = (io.grpc.ClientInterceptor) r1     // Catch: java.lang.reflect.InvocationTargetException -> L54 java.lang.IllegalAccessException -> L5d java.lang.NoSuchMethodException -> L66 java.lang.ClassNotFoundException -> L6f
            goto L78
        L54:
            r1 = move-exception
            java.util.logging.Logger r6 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r5, r1)
            goto L77
        L5d:
            r1 = move-exception
            java.util.logging.Logger r6 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r5, r1)
            goto L77
        L66:
            r1 = move-exception
            java.util.logging.Logger r6 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r5, r1)
            goto L77
        L6f:
            r1 = move-exception
            java.util.logging.Logger r6 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r5, r1)
        L77:
            r1 = r3
        L78:
            if (r1 == 0) goto L7d
            r0.add(r4, r1)
        L7d:
            boolean r1 = r12.tracingEnabled
            if (r1 == 0) goto Lbf
            java.lang.String r1 = "io.grpc.census.InternalCensusTracingAccessor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> La0 java.lang.NoSuchMethodException -> La9 java.lang.ClassNotFoundException -> Lb2
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> La0 java.lang.NoSuchMethodException -> La9 java.lang.ClassNotFoundException -> Lb2
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> La0 java.lang.NoSuchMethodException -> La9 java.lang.ClassNotFoundException -> Lb2
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> La0 java.lang.NoSuchMethodException -> La9 java.lang.ClassNotFoundException -> Lb2
            java.lang.Object r1 = r1.invoke(r3, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> La0 java.lang.NoSuchMethodException -> La9 java.lang.ClassNotFoundException -> Lb2
            io.grpc.ClientInterceptor r1 = (io.grpc.ClientInterceptor) r1     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> La0 java.lang.NoSuchMethodException -> La9 java.lang.ClassNotFoundException -> Lb2
            r3 = r1
            goto Lba
        L97:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r2.log(r6, r5, r1)
            goto Lba
        La0:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r2.log(r6, r5, r1)
            goto Lba
        La9:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r2.log(r6, r5, r1)
            goto Lba
        Lb2:
            r1 = move-exception
            java.util.logging.Logger r2 = io.grpc.internal.ManagedChannelImplBuilder.log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            r2.log(r6, r5, r1)
        Lba:
            if (r3 == 0) goto Lbf
            r0.add(r4, r3)
        Lbf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ManagedChannelImplBuilder.getEffectiveInterceptors():java.util.List");
    }

    int getDefaultPort() {
        return this.channelBuilderDefaultPortProvider.getDefaultPort();
    }
}
