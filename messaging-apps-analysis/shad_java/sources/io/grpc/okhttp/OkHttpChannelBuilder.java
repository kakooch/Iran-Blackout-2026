package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.ManagedChannelBuilder;
import io.grpc.TlsChannelCredentials$Feature;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.AtomicBackoff;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.TlsVersion;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
public final class OkHttpChannelBuilder extends AbstractManagedChannelImplBuilder<OkHttpChannelBuilder> {
    static final ConnectionSpec INTERNAL_DEFAULT_CONNECTION_SPEC;
    private static final SharedResourceHolder.Resource<Executor> SHARED_EXECUTOR;
    private HostnameVerifier hostnameVerifier;
    private boolean keepAliveWithoutCalls;
    private final ManagedChannelImplBuilder managedChannelImplBuilder;
    private ScheduledExecutorService scheduledExecutorService;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private Executor transportExecutor;
    private TransportTracer.Factory transportTracerFactory = TransportTracer.getDefaultFactory();
    private ConnectionSpec connectionSpec = INTERNAL_DEFAULT_CONNECTION_SPEC;
    private NegotiationType negotiationType = NegotiationType.TLS;
    private long keepAliveTimeNanos = Long.MAX_VALUE;
    private long keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
    private int flowControlWindow = 65535;
    private int maxInboundMetadataSize = ConnectionsManager.DEFAULT_DATACENTER_ID;

    private enum NegotiationType {
        TLS,
        PLAINTEXT
    }

    static {
        Logger.getLogger(OkHttpChannelBuilder.class.getName());
        INTERNAL_DEFAULT_CONNECTION_SPEC = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).tlsVersions(TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
        TimeUnit.DAYS.toNanos(1000L);
        SHARED_EXECUTOR = new SharedResourceHolder.Resource<Executor>() { // from class: io.grpc.okhttp.OkHttpChannelBuilder.1
            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public Executor create() {
                return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-okhttp-%d", true));
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public void close(Executor executor) {
                ((ExecutorService) executor).shutdown();
            }
        };
        EnumSet.of(TlsChannelCredentials$Feature.MTLS, TlsChannelCredentials$Feature.CUSTOM_MANAGERS);
    }

    public static OkHttpChannelBuilder forTarget(String str) {
        return new OkHttpChannelBuilder(str);
    }

    private OkHttpChannelBuilder(String str) {
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(str, new OkHttpChannelTransportFactoryBuilder(), new OkHttpChannelDefaultPortProvider());
    }

    private final class OkHttpChannelTransportFactoryBuilder implements ManagedChannelImplBuilder.ClientTransportFactoryBuilder {
        private OkHttpChannelTransportFactoryBuilder() {
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ClientTransportFactoryBuilder
        public ClientTransportFactory buildClientTransportFactory() {
            return OkHttpChannelBuilder.this.buildTransportFactory();
        }
    }

    private final class OkHttpChannelDefaultPortProvider implements ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider {
        private OkHttpChannelDefaultPortProvider() {
        }

        @Override // io.grpc.internal.ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider
        public int getDefaultPort() {
            return OkHttpChannelBuilder.this.getDefaultPort();
        }
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    protected ManagedChannelBuilder<?> delegate() {
        return this.managedChannelImplBuilder;
    }

    ClientTransportFactory buildTransportFactory() {
        return new OkHttpTransportFactory(this.transportExecutor, this.scheduledExecutorService, this.socketFactory, createSslSocketFactory(), this.hostnameVerifier, this.connectionSpec, this.maxInboundMessageSize, this.keepAliveTimeNanos != Long.MAX_VALUE, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.flowControlWindow, this.keepAliveWithoutCalls, this.maxInboundMetadataSize, this.transportTracerFactory, false);
    }

    /* renamed from: io.grpc.okhttp.OkHttpChannelBuilder$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$okhttp$NegotiationType;
        static final /* synthetic */ int[] $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType;

        static {
            int[] iArr = new int[NegotiationType.values().length];
            $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType = iArr;
            try {
                iArr[NegotiationType.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[NegotiationType.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[io.grpc.okhttp.NegotiationType.values().length];
            $SwitchMap$io$grpc$okhttp$NegotiationType = iArr2;
            try {
                iArr2[io.grpc.okhttp.NegotiationType.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$grpc$okhttp$NegotiationType[io.grpc.okhttp.NegotiationType.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    int getDefaultPort() {
        int i = AnonymousClass2.$SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[this.negotiationType.ordinal()];
        if (i == 1) {
            return 80;
        }
        if (i == 2) {
            return 443;
        }
        throw new AssertionError(this.negotiationType + " not handled");
    }

    SSLSocketFactory createSslSocketFactory() {
        int i = AnonymousClass2.$SwitchMap$io$grpc$okhttp$OkHttpChannelBuilder$NegotiationType[this.negotiationType.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            try {
                if (this.sslSocketFactory == null) {
                    this.sslSocketFactory = SSLContext.getInstance("Default", Platform.get().getProvider()).getSocketFactory();
                }
                return this.sslSocketFactory;
            } catch (GeneralSecurityException e) {
                throw new RuntimeException("TLS Provider failure", e);
            }
        }
        throw new RuntimeException("Unknown negotiation type: " + this.negotiationType);
    }

    static final class OkHttpTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final ConnectionSpec connectionSpec;
        private final boolean enableKeepAlive;
        private final Executor executor;
        private final int flowControlWindow;
        private final HostnameVerifier hostnameVerifier;
        private final AtomicBackoff keepAliveBackoff;
        private final long keepAliveTimeoutNanos;
        private final boolean keepAliveWithoutCalls;
        private final int maxInboundMetadataSize;
        private final int maxMessageSize;
        private final SocketFactory socketFactory;
        private final SSLSocketFactory sslSocketFactory;
        private final ScheduledExecutorService timeoutService;
        private final TransportTracer.Factory transportTracerFactory;
        private final boolean useGetForSafeMethods;
        private final boolean usingSharedExecutor;
        private final boolean usingSharedScheduler;

        private OkHttpTransportFactory(Executor executor, ScheduledExecutorService scheduledExecutorService, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ConnectionSpec connectionSpec, int i, boolean z, long j, long j2, int i2, boolean z2, int i3, TransportTracer.Factory factory, boolean z3) {
            boolean z4 = scheduledExecutorService == null;
            this.usingSharedScheduler = z4;
            this.timeoutService = z4 ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : scheduledExecutorService;
            this.socketFactory = socketFactory;
            this.sslSocketFactory = sSLSocketFactory;
            this.hostnameVerifier = hostnameVerifier;
            this.connectionSpec = connectionSpec;
            this.maxMessageSize = i;
            this.enableKeepAlive = z;
            this.keepAliveBackoff = new AtomicBackoff("keepalive time nanos", j);
            this.keepAliveTimeoutNanos = j2;
            this.flowControlWindow = i2;
            this.keepAliveWithoutCalls = z2;
            this.maxInboundMetadataSize = i3;
            this.useGetForSafeMethods = z3;
            boolean z5 = executor == null;
            this.usingSharedExecutor = z5;
            this.transportTracerFactory = (TransportTracer.Factory) Preconditions.checkNotNull(factory, "transportTracerFactory");
            if (z5) {
                this.executor = (Executor) SharedResourceHolder.get(OkHttpChannelBuilder.SHARED_EXECUTOR);
            } else {
                this.executor = executor;
            }
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportFactory.ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger) {
            if (this.closed) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            final AtomicBackoff.State state = this.keepAliveBackoff.getState();
            OkHttpClientTransport okHttpClientTransport = new OkHttpClientTransport((InetSocketAddress) socketAddress, clientTransportOptions.getAuthority(), clientTransportOptions.getUserAgent(), clientTransportOptions.getEagAttributes(), this.executor, this.socketFactory, this.sslSocketFactory, this.hostnameVerifier, this.connectionSpec, this.maxMessageSize, this.flowControlWindow, clientTransportOptions.getHttpConnectProxiedSocketAddress(), new Runnable(this) { // from class: io.grpc.okhttp.OkHttpChannelBuilder.OkHttpTransportFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    state.backoff();
                }
            }, this.maxInboundMetadataSize, this.transportTracerFactory.create(), this.useGetForSafeMethods);
            if (this.enableKeepAlive) {
                okHttpClientTransport.enableKeepAlive(true, state.get(), this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
            }
            return okHttpClientTransport;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timeoutService;
        }

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.usingSharedScheduler) {
                SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timeoutService);
            }
            if (this.usingSharedExecutor) {
                SharedResourceHolder.release(OkHttpChannelBuilder.SHARED_EXECUTOR, this.executor);
            }
        }
    }
}
