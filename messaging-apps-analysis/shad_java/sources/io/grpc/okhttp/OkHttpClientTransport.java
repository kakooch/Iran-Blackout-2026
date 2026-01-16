package io.grpc.okhttp;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.SettableFuture;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.http.StatusLine;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Grpc;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.OkHttpClientStream;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import io.perfmark.PerfMark;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import okio.Timeout;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
class OkHttpClientTransport implements ConnectionClientTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler {
    private final InetSocketAddress address;
    private Attributes attributes;
    private ClientFrameHandler clientFrameHandler;
    SettableFuture<Void> connectedFuture;
    Runnable connectingCallback;
    private final ConnectionSpec connectionSpec;
    private int connectionUnacknowledgedBytesRead;
    private final String defaultAuthority;
    private boolean enableKeepAlive;
    private final Executor executor;
    private ExceptionHandlingFrameWriter frameWriter;
    private boolean goAwaySent;
    private Status goAwayStatus;
    private boolean hasStream;
    private HostnameVerifier hostnameVerifier;
    private final int initialWindowSize;
    private KeepAliveManager keepAliveManager;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    private ManagedClientTransport.Listener listener;
    private final InternalLogId logId;
    private final int maxInboundMetadataSize;
    private final int maxMessageSize;
    private OutboundFlowController outboundFlow;
    private Http2Ping ping;
    final HttpConnectProxiedSocketAddress proxiedAddr;
    private ScheduledExecutorService scheduler;
    private InternalChannelz.Security securityInfo;
    private final SerializingExecutor serializingExecutor;
    private Socket socket;
    private final SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private boolean stopped;
    private final Supplier<Stopwatch> stopwatchFactory;
    private OkHttpFrameLogger testFrameLogger;
    private FrameReader testFrameReader;
    private FrameWriter testFrameWriter;
    private final Runnable tooManyPingsRunnable;
    private final TransportTracer transportTracer;
    private final boolean useGetForSafeMethods;
    private final String userAgent;
    private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = buildErrorCodeToStatusMap();
    private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    private static final OkHttpClientStream[] EMPTY_STREAM_ARRAY = new OkHttpClientStream[0];
    private final Random random = new Random();
    private final Object lock = new Object();
    private final Map<Integer, OkHttpClientStream> streams = new HashMap();
    private int maxConcurrentStreams = 0;
    private final Deque<OkHttpClientStream> pendingStreams = new LinkedList();
    private final InUseStateAggregator<OkHttpClientStream> inUseState = new InUseStateAggregator<OkHttpClientStream>() { // from class: io.grpc.okhttp.OkHttpClientTransport.1
        @Override // io.grpc.internal.InUseStateAggregator
        protected void handleInUse() {
            OkHttpClientTransport.this.listener.transportInUse(true);
        }

        @Override // io.grpc.internal.InUseStateAggregator
        protected void handleNotInUse() {
            OkHttpClientTransport.this.listener.transportInUse(false);
        }
    };
    private int nextStreamId = 3;

    static /* synthetic */ int access$2412(OkHttpClientTransport okHttpClientTransport, int i) {
        int i2 = okHttpClientTransport.connectionUnacknowledgedBytesRead + i;
        okHttpClientTransport.connectionUnacknowledgedBytesRead = i2;
        return i2;
    }

    @Override // io.grpc.internal.ClientTransport
    public /* bridge */ /* synthetic */ ClientStream newStream(MethodDescriptor methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        return newStream((MethodDescriptor<?, ?>) methodDescriptor, metadata, callOptions, clientStreamTracerArr);
    }

    private static Map<ErrorCode, Status> buildErrorCodeToStatusMap() {
        EnumMap enumMap = new EnumMap(ErrorCode.class);
        ErrorCode errorCode = ErrorCode.NO_ERROR;
        Status status = Status.INTERNAL;
        enumMap.put((EnumMap) errorCode, (ErrorCode) status.withDescription("No error: A GRPC status of OK should have been sent"));
        enumMap.put((EnumMap) ErrorCode.PROTOCOL_ERROR, (ErrorCode) status.withDescription("Protocol error"));
        enumMap.put((EnumMap) ErrorCode.INTERNAL_ERROR, (ErrorCode) status.withDescription("Internal error"));
        enumMap.put((EnumMap) ErrorCode.FLOW_CONTROL_ERROR, (ErrorCode) status.withDescription("Flow control error"));
        enumMap.put((EnumMap) ErrorCode.STREAM_CLOSED, (ErrorCode) status.withDescription("Stream closed"));
        enumMap.put((EnumMap) ErrorCode.FRAME_TOO_LARGE, (ErrorCode) status.withDescription("Frame too large"));
        enumMap.put((EnumMap) ErrorCode.REFUSED_STREAM, (ErrorCode) Status.UNAVAILABLE.withDescription("Refused stream"));
        enumMap.put((EnumMap) ErrorCode.CANCEL, (ErrorCode) Status.CANCELLED.withDescription("Cancelled"));
        enumMap.put((EnumMap) ErrorCode.COMPRESSION_ERROR, (ErrorCode) status.withDescription("Compression error"));
        enumMap.put((EnumMap) ErrorCode.CONNECT_ERROR, (ErrorCode) status.withDescription("Connect error"));
        enumMap.put((EnumMap) ErrorCode.ENHANCE_YOUR_CALM, (ErrorCode) Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
        enumMap.put((EnumMap) ErrorCode.INADEQUATE_SECURITY, (ErrorCode) Status.PERMISSION_DENIED.withDescription("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    OkHttpClientTransport(InetSocketAddress inetSocketAddress, String str, String str2, Attributes attributes, Executor executor, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, ConnectionSpec connectionSpec, int i, int i2, HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress, Runnable runnable, int i3, TransportTracer transportTracer, boolean z) {
        this.address = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "address");
        this.defaultAuthority = str;
        this.maxMessageSize = i;
        this.initialWindowSize = i2;
        this.executor = (Executor) Preconditions.checkNotNull(executor, "executor");
        this.serializingExecutor = new SerializingExecutor(executor);
        this.socketFactory = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.connectionSpec = (ConnectionSpec) Preconditions.checkNotNull(connectionSpec, "connectionSpec");
        this.stopwatchFactory = GrpcUtil.STOPWATCH_SUPPLIER;
        this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", str2);
        this.proxiedAddr = httpConnectProxiedSocketAddress;
        this.tooManyPingsRunnable = (Runnable) Preconditions.checkNotNull(runnable, "tooManyPingsRunnable");
        this.maxInboundMetadataSize = i3;
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer);
        this.logId = InternalLogId.allocate((Class<?>) OkHttpClientTransport.class, inetSocketAddress.toString());
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, attributes).build();
        this.useGetForSafeMethods = z;
        initTransportTracer();
    }

    boolean isUsingPlaintext() {
        return this.sslSocketFactory == null;
    }

    private void initTransportTracer() {
        synchronized (this.lock) {
            this.transportTracer.setFlowControlWindowReader(new TransportTracer.FlowControlReader(this) { // from class: io.grpc.okhttp.OkHttpClientTransport.2
            });
        }
    }

    void enableKeepAlive(boolean z, long j, long j2, boolean z2) {
        this.enableKeepAlive = z;
        this.keepAliveTimeNanos = j;
        this.keepAliveTimeoutNanos = j2;
        this.keepAliveWithoutCalls = z2;
    }

    private boolean isForTest() {
        return this.address == null;
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        long jNextLong;
        synchronized (this.lock) {
            boolean z = true;
            Preconditions.checkState(this.frameWriter != null);
            if (this.stopped) {
                Http2Ping.notifyFailed(pingCallback, executor, getPingFailure());
                return;
            }
            Http2Ping http2Ping = this.ping;
            if (http2Ping != null) {
                jNextLong = 0;
                z = false;
            } else {
                jNextLong = this.random.nextLong();
                Stopwatch stopwatch = this.stopwatchFactory.get();
                stopwatch.start();
                Http2Ping http2Ping2 = new Http2Ping(jNextLong, stopwatch);
                this.ping = http2Ping2;
                this.transportTracer.reportKeepAliveSent();
                http2Ping = http2Ping2;
            }
            if (z) {
                this.frameWriter.ping(false, (int) (jNextLong >>> 32), (int) jNextLong);
            }
            http2Ping.addCallback(pingCallback, executor);
        }
    }

    @Override // io.grpc.internal.ClientTransport
    public OkHttpClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) throws Throwable {
        Preconditions.checkNotNull(methodDescriptor, "method");
        Preconditions.checkNotNull(metadata, "headers");
        StatsTraceContext statsTraceContextNewClientContext = StatsTraceContext.newClientContext(clientStreamTracerArr, getAttributes(), metadata);
        synchronized (this.lock) {
            try {
                try {
                    return new OkHttpClientStream(methodDescriptor, metadata, this.frameWriter, this, this.outboundFlow, this.lock, this.maxMessageSize, this.initialWindowSize, this.defaultAuthority, this.userAgent, statsTraceContextNewClientContext, this.transportTracer, callOptions, this.useGetForSafeMethods);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    void streamReadyToStart(OkHttpClientStream okHttpClientStream) {
        if (this.goAwayStatus != null) {
            okHttpClientStream.transportState().transportReportStatus(this.goAwayStatus, ClientStreamListener.RpcProgress.REFUSED, true, new Metadata());
        } else if (this.streams.size() >= this.maxConcurrentStreams) {
            this.pendingStreams.add(okHttpClientStream);
            setInUse(okHttpClientStream);
        } else {
            startStream(okHttpClientStream);
        }
    }

    private void startStream(OkHttpClientStream okHttpClientStream) {
        Preconditions.checkState(okHttpClientStream.id() == -1, "StreamId already assigned");
        this.streams.put(Integer.valueOf(this.nextStreamId), okHttpClientStream);
        setInUse(okHttpClientStream);
        okHttpClientStream.transportState().start(this.nextStreamId);
        if ((okHttpClientStream.getType() != MethodDescriptor.MethodType.UNARY && okHttpClientStream.getType() != MethodDescriptor.MethodType.SERVER_STREAMING) || okHttpClientStream.useGet()) {
            this.frameWriter.flush();
        }
        int i = this.nextStreamId;
        if (i >= 2147483645) {
            this.nextStreamId = ConnectionsManager.DEFAULT_DATACENTER_ID;
            startGoAway(ConnectionsManager.DEFAULT_DATACENTER_ID, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
        } else {
            this.nextStreamId = i + 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startPendingStreams() {
        boolean z = false;
        while (!this.pendingStreams.isEmpty() && this.streams.size() < this.maxConcurrentStreams) {
            startStream(this.pendingStreams.poll());
            z = true;
        }
        return z;
    }

    void removePendingStream(OkHttpClientStream okHttpClientStream) {
        this.pendingStreams.remove(okHttpClientStream);
        maybeClearInUse(okHttpClientStream);
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public Runnable start(ManagedClientTransport.Listener listener) {
        this.listener = (ManagedClientTransport.Listener) Preconditions.checkNotNull(listener, "listener");
        if (this.enableKeepAlive) {
            this.scheduler = (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE);
            KeepAliveManager keepAliveManager = new KeepAliveManager(new KeepAliveManager.ClientKeepAlivePinger(this), this.scheduler, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
            this.keepAliveManager = keepAliveManager;
            keepAliveManager.onTransportStarted();
        }
        if (isForTest()) {
            synchronized (this.lock) {
                ExceptionHandlingFrameWriter exceptionHandlingFrameWriter = new ExceptionHandlingFrameWriter(this, this.testFrameWriter, this.testFrameLogger);
                this.frameWriter = exceptionHandlingFrameWriter;
                this.outboundFlow = new OutboundFlowController(this, exceptionHandlingFrameWriter);
            }
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.3
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable = OkHttpClientTransport.this.connectingCallback;
                    if (runnable != null) {
                        runnable.run();
                    }
                    OkHttpClientTransport okHttpClientTransport = OkHttpClientTransport.this;
                    okHttpClientTransport.clientFrameHandler = okHttpClientTransport.new ClientFrameHandler(okHttpClientTransport.testFrameReader, OkHttpClientTransport.this.testFrameLogger);
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        OkHttpClientTransport.this.maxConcurrentStreams = ConnectionsManager.DEFAULT_DATACENTER_ID;
                        OkHttpClientTransport.this.startPendingStreams();
                    }
                    SettableFuture<Void> settableFuture = OkHttpClientTransport.this.connectedFuture;
                    throw null;
                }
            });
            return null;
        }
        final AsyncSink asyncSinkSink = AsyncSink.sink(this.serializingExecutor, this);
        final Http2 http2 = new Http2();
        FrameWriter frameWriterNewWriter = http2.newWriter(Okio.buffer(asyncSinkSink), true);
        synchronized (this.lock) {
            ExceptionHandlingFrameWriter exceptionHandlingFrameWriter2 = new ExceptionHandlingFrameWriter(this, frameWriterNewWriter);
            this.frameWriter = exceptionHandlingFrameWriter2;
            this.outboundFlow = new OutboundFlowController(this, exceptionHandlingFrameWriter2);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.4
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                OkHttpClientTransport okHttpClientTransport;
                ClientFrameHandler clientFrameHandler;
                Socket socketCreateHttpProxySocket;
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                BufferedSource bufferedSourceBuffer = Okio.buffer(new Source(this) { // from class: io.grpc.okhttp.OkHttpClientTransport.4.1
                    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                    }

                    @Override // okio.Source
                    public long read(Buffer buffer, long j) {
                        return -1L;
                    }

                    @Override // okio.Source
                    public Timeout timeout() {
                        return Timeout.NONE;
                    }
                });
                SSLSession session = null;
                try {
                    try {
                        OkHttpClientTransport okHttpClientTransport2 = OkHttpClientTransport.this;
                        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress = okHttpClientTransport2.proxiedAddr;
                        if (httpConnectProxiedSocketAddress == null) {
                            socketCreateHttpProxySocket = okHttpClientTransport2.socketFactory.createSocket(OkHttpClientTransport.this.address.getAddress(), OkHttpClientTransport.this.address.getPort());
                        } else if (httpConnectProxiedSocketAddress.getProxyAddress() instanceof InetSocketAddress) {
                            OkHttpClientTransport okHttpClientTransport3 = OkHttpClientTransport.this;
                            socketCreateHttpProxySocket = okHttpClientTransport3.createHttpProxySocket(okHttpClientTransport3.proxiedAddr.getTargetAddress(), (InetSocketAddress) OkHttpClientTransport.this.proxiedAddr.getProxyAddress(), OkHttpClientTransport.this.proxiedAddr.getUsername(), OkHttpClientTransport.this.proxiedAddr.getPassword());
                        } else {
                            throw Status.INTERNAL.withDescription("Unsupported SocketAddress implementation " + OkHttpClientTransport.this.proxiedAddr.getProxyAddress().getClass()).asException();
                        }
                        Socket socket = socketCreateHttpProxySocket;
                        Socket socket2 = socket;
                        if (OkHttpClientTransport.this.sslSocketFactory != null) {
                            SSLSocket sSLSocketUpgrade = OkHttpTlsUpgrader.upgrade(OkHttpClientTransport.this.sslSocketFactory, OkHttpClientTransport.this.hostnameVerifier, socket, OkHttpClientTransport.this.getOverridenHost(), OkHttpClientTransport.this.getOverridenPort(), OkHttpClientTransport.this.connectionSpec);
                            session = sSLSocketUpgrade.getSession();
                            socket2 = sSLSocketUpgrade;
                        }
                        socket2.setTcpNoDelay(true);
                        BufferedSource bufferedSourceBuffer2 = Okio.buffer(Okio.source(socket2));
                        asyncSinkSink.becomeConnected(Okio.sink(socket2), socket2);
                        OkHttpClientTransport okHttpClientTransport4 = OkHttpClientTransport.this;
                        okHttpClientTransport4.attributes = okHttpClientTransport4.attributes.toBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, socket2.getRemoteSocketAddress()).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, socket2.getLocalSocketAddress()).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, session).set(GrpcAttributes.ATTR_SECURITY_LEVEL, session == null ? SecurityLevel.NONE : SecurityLevel.PRIVACY_AND_INTEGRITY).build();
                        OkHttpClientTransport okHttpClientTransport5 = OkHttpClientTransport.this;
                        okHttpClientTransport5.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport5, http2.newReader(bufferedSourceBuffer2, true));
                        synchronized (OkHttpClientTransport.this.lock) {
                            OkHttpClientTransport.this.socket = (Socket) Preconditions.checkNotNull(socket2, "socket");
                            if (session != null) {
                                OkHttpClientTransport.this.securityInfo = new InternalChannelz.Security(new InternalChannelz.Tls(session));
                            }
                        }
                    } catch (StatusException e) {
                        OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, e.getStatus());
                        okHttpClientTransport = OkHttpClientTransport.this;
                        clientFrameHandler = new ClientFrameHandler(okHttpClientTransport, http2.newReader(bufferedSourceBuffer, true));
                        okHttpClientTransport.clientFrameHandler = clientFrameHandler;
                    } catch (Exception e2) {
                        OkHttpClientTransport.this.onException(e2);
                        okHttpClientTransport = OkHttpClientTransport.this;
                        clientFrameHandler = new ClientFrameHandler(okHttpClientTransport, http2.newReader(bufferedSourceBuffer, true));
                        okHttpClientTransport.clientFrameHandler = clientFrameHandler;
                    }
                } catch (Throwable th) {
                    OkHttpClientTransport okHttpClientTransport6 = OkHttpClientTransport.this;
                    okHttpClientTransport6.clientFrameHandler = new ClientFrameHandler(okHttpClientTransport6, http2.newReader(bufferedSourceBuffer, true));
                    throw th;
                }
            }
        });
        try {
            sendConnectionPrefaceAndSettings();
            countDownLatch.countDown();
            this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.5
                @Override // java.lang.Runnable
                public void run() {
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        OkHttpClientTransport.this.maxConcurrentStreams = ConnectionsManager.DEFAULT_DATACENTER_ID;
                        OkHttpClientTransport.this.startPendingStreams();
                    }
                }
            });
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    void sendConnectionPrefaceAndSettings() {
        synchronized (this.lock) {
            this.frameWriter.connectionPreface();
            Settings settings = new Settings();
            OkHttpSettingsUtil.set(settings, 7, this.initialWindowSize);
            this.frameWriter.settings(settings);
            if (this.initialWindowSize > 65535) {
                this.frameWriter.windowUpdate(0, r1 - 65535);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Socket createHttpProxySocket(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws StatusException, IOException, NumberFormatException {
        Socket socketCreateSocket;
        try {
            if (inetSocketAddress2.getAddress() != null) {
                socketCreateSocket = this.socketFactory.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort());
            } else {
                socketCreateSocket = this.socketFactory.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            }
            socketCreateSocket.setTcpNoDelay(true);
            Source source = Okio.source(socketCreateSocket);
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(socketCreateSocket));
            Request requestCreateHttpProxyRequest = createHttpProxyRequest(inetSocketAddress, str, str2);
            HttpUrl httpUrl = requestCreateHttpProxyRequest.httpUrl();
            bufferedSinkBuffer.writeUtf8(String.format("CONNECT %s:%d HTTP/1.1", httpUrl.host(), Integer.valueOf(httpUrl.port()))).writeUtf8("\r\n");
            int size = requestCreateHttpProxyRequest.headers().size();
            for (int i = 0; i < size; i++) {
                bufferedSinkBuffer.writeUtf8(requestCreateHttpProxyRequest.headers().name(i)).writeUtf8(": ").writeUtf8(requestCreateHttpProxyRequest.headers().value(i)).writeUtf8("\r\n");
            }
            bufferedSinkBuffer.writeUtf8("\r\n");
            bufferedSinkBuffer.flush();
            StatusLine statusLine = StatusLine.parse(readUtf8LineStrictUnbuffered(source));
            while (!readUtf8LineStrictUnbuffered(source).equals(BuildConfig.FLAVOR)) {
            }
            int i2 = statusLine.code;
            if (i2 >= 200 && i2 < 300) {
                return socketCreateSocket;
            }
            Buffer buffer = new Buffer();
            try {
                socketCreateSocket.shutdownOutput();
                source.read(buffer, 1024L);
            } catch (IOException e) {
                buffer.writeUtf8("Unable to read body: " + e.toString());
            }
            try {
                socketCreateSocket.close();
            } catch (IOException unused) {
            }
            throw Status.UNAVAILABLE.withDescription(String.format("Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(statusLine.code), statusLine.message, buffer.readUtf8())).asException();
        } catch (IOException e2) {
            throw Status.UNAVAILABLE.withDescription("Failed trying to connect with proxy").withCause(e2).asException();
        }
    }

    private Request createHttpProxyRequest(InetSocketAddress inetSocketAddress, String str, String str2) {
        HttpUrl httpUrlBuild = new HttpUrl.Builder().scheme("https").host(inetSocketAddress.getHostName()).port(inetSocketAddress.getPort()).build();
        Request.Builder builderHeader = new Request.Builder().url(httpUrlBuild).header("Host", httpUrlBuild.host() + ":" + httpUrlBuild.port()).header("User-Agent", this.userAgent);
        if (str != null && str2 != null) {
            builderHeader.header("Proxy-Authorization", Credentials.basic(str, str2));
        }
        return builderHeader.build();
    }

    private static String readUtf8LineStrictUnbuffered(Source source) throws IOException {
        Buffer buffer = new Buffer();
        while (source.read(buffer, 1L) != -1) {
            if (buffer.getByte(buffer.size() - 1) == 10) {
                return buffer.readUtf8LineStrict();
            }
        }
        throw new EOFException("\\n not found: " + buffer.readByteString().hex());
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("address", this.address).toString();
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    String getOverridenHost() {
        URI uriAuthorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        if (uriAuthorityToUri.getHost() != null) {
            return uriAuthorityToUri.getHost();
        }
        return this.defaultAuthority;
    }

    int getOverridenPort() {
        URI uriAuthorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        if (uriAuthorityToUri.getPort() != -1) {
            return uriAuthorityToUri.getPort();
        }
        return this.address.getPort();
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdown(Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                return;
            }
            this.goAwayStatus = status;
            this.listener.transportShutdown(status);
            stopIfNecessary();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void shutdownNow(Status status) {
        shutdown(status);
        synchronized (this.lock) {
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> next = it.next();
                it.remove();
                next.getValue().transportState().transportReportStatus(status, false, new Metadata());
                maybeClearInUse(next.getValue());
            }
            for (OkHttpClientStream okHttpClientStream : this.pendingStreams) {
                okHttpClientStream.transportState().transportReportStatus(status, true, new Metadata());
                maybeClearInUse(okHttpClientStream);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    OkHttpClientStream[] getActiveStreams() {
        OkHttpClientStream[] okHttpClientStreamArr;
        synchronized (this.lock) {
            okHttpClientStreamArr = (OkHttpClientStream[]) this.streams.values().toArray(EMPTY_STREAM_ARRAY);
        }
        return okHttpClientStreamArr;
    }

    @Override // io.grpc.okhttp.ExceptionHandlingFrameWriter.TransportExceptionHandler
    public void onException(Throwable th) {
        Preconditions.checkNotNull(th, "failureCause");
        startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withCause(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ErrorCode errorCode, String str) {
        startGoAway(0, errorCode, toGrpcStatus(errorCode).augmentDescription(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGoAway(int i, ErrorCode errorCode, Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus == null) {
                this.goAwayStatus = status;
                this.listener.transportShutdown(status);
            }
            if (errorCode != null && !this.goAwaySent) {
                this.goAwaySent = true;
                this.frameWriter.goAway(0, errorCode, new byte[0]);
            }
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> next = it.next();
                if (next.getKey().intValue() > i) {
                    it.remove();
                    next.getValue().transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, false, new Metadata());
                    maybeClearInUse(next.getValue());
                }
            }
            for (OkHttpClientStream okHttpClientStream : this.pendingStreams) {
                okHttpClientStream.transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, true, new Metadata());
                maybeClearInUse(okHttpClientStream);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    void finishStream(int i, Status status, ClientStreamListener.RpcProgress rpcProgress, boolean z, ErrorCode errorCode, Metadata metadata) {
        synchronized (this.lock) {
            OkHttpClientStream okHttpClientStreamRemove = this.streams.remove(Integer.valueOf(i));
            if (okHttpClientStreamRemove != null) {
                if (errorCode != null) {
                    this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                }
                if (status != null) {
                    OkHttpClientStream.TransportState transportState = okHttpClientStreamRemove.transportState();
                    if (metadata == null) {
                        metadata = new Metadata();
                    }
                    transportState.transportReportStatus(status, rpcProgress, z, metadata);
                }
                if (!startPendingStreams()) {
                    stopIfNecessary();
                    maybeClearInUse(okHttpClientStreamRemove);
                }
            }
        }
    }

    private void stopIfNecessary() {
        if (this.goAwayStatus == null || !this.streams.isEmpty() || !this.pendingStreams.isEmpty() || this.stopped) {
            return;
        }
        this.stopped = true;
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onTransportTermination();
            this.scheduler = (ScheduledExecutorService) SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.scheduler);
        }
        Http2Ping http2Ping = this.ping;
        if (http2Ping != null) {
            http2Ping.failed(getPingFailure());
            this.ping = null;
        }
        if (!this.goAwaySent) {
            this.goAwaySent = true;
            this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
        }
        this.frameWriter.close();
    }

    private void maybeClearInUse(OkHttpClientStream okHttpClientStream) {
        if (this.hasStream && this.pendingStreams.isEmpty() && this.streams.isEmpty()) {
            this.hasStream = false;
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportIdle();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, false);
        }
    }

    private void setInUse(OkHttpClientStream okHttpClientStream) {
        if (!this.hasStream) {
            this.hasStream = true;
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportActive();
            }
        }
        if (okHttpClientStream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(okHttpClientStream, true);
        }
    }

    private Throwable getPingFailure() {
        synchronized (this.lock) {
            Status status = this.goAwayStatus;
            if (status != null) {
                return status.asException();
            }
            return Status.UNAVAILABLE.withDescription("Connection closed").asException();
        }
    }

    boolean mayHaveCreatedStream(int i) {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (i >= this.nextStreamId || (i & 1) != 1) {
                z = false;
            }
        }
        return z;
    }

    OkHttpClientStream getStream(int i) {
        OkHttpClientStream okHttpClientStream;
        synchronized (this.lock) {
            okHttpClientStream = this.streams.get(Integer.valueOf(i));
        }
        return okHttpClientStream;
    }

    static Status toGrpcStatus(ErrorCode errorCode) {
        Status status = ERROR_CODE_TO_STATUS.get(errorCode);
        if (status != null) {
            return status;
        }
        return Status.UNKNOWN.withDescription("Unknown http2 error code: " + errorCode.httpCode);
    }

    class ClientFrameHandler implements FrameReader.Handler, Runnable {
        boolean firstSettings;
        FrameReader frameReader;
        private final OkHttpFrameLogger logger;

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        ClientFrameHandler(OkHttpClientTransport okHttpClientTransport, FrameReader frameReader) {
            this(frameReader, new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpClientTransport.class));
        }

        ClientFrameHandler(FrameReader frameReader, OkHttpFrameLogger okHttpFrameLogger) {
            this.firstSettings = true;
            this.frameReader = frameReader;
            this.logger = okHttpFrameLogger;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            Status statusWithDescription;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.frameReader.nextFrame(this)) {
                try {
                    if (OkHttpClientTransport.this.keepAliveManager != null) {
                        OkHttpClientTransport.this.keepAliveManager.onDataReceived();
                    }
                } catch (Throwable th) {
                    try {
                        OkHttpClientTransport.this.startGoAway(0, ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("error in frame handler").withCause(th));
                        try {
                            this.frameReader.close();
                        } catch (IOException e) {
                            e = e;
                            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                            OkHttpClientTransport.this.listener.transportTerminated();
                            Thread.currentThread().setName(name);
                        }
                    } catch (Throwable th2) {
                        try {
                            this.frameReader.close();
                        } catch (IOException e2) {
                            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e2);
                        }
                        OkHttpClientTransport.this.listener.transportTerminated();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            }
            synchronized (OkHttpClientTransport.this.lock) {
                statusWithDescription = OkHttpClientTransport.this.goAwayStatus;
            }
            if (statusWithDescription == null) {
                statusWithDescription = Status.UNAVAILABLE.withDescription("End of stream or IOException");
            }
            OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, statusWithDescription);
            try {
                this.frameReader.close();
            } catch (IOException e3) {
                e = e3;
                OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                OkHttpClientTransport.this.listener.transportTerminated();
                Thread.currentThread().setName(name);
            }
            OkHttpClientTransport.this.listener.transportTerminated();
            Thread.currentThread().setName(name);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            this.logger.logData(OkHttpFrameLogger.Direction.INBOUND, i, bufferedSource.getBuffer(), i2, z);
            OkHttpClientStream stream = OkHttpClientTransport.this.getStream(i);
            if (stream == null) {
                if (OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                    synchronized (OkHttpClientTransport.this.lock) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.INVALID_STREAM);
                    }
                    bufferedSource.skip(i2);
                } else {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received data for unknown stream: " + i);
                    return;
                }
            } else {
                long j = i2;
                bufferedSource.require(j);
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.getBuffer(), j);
                PerfMark.event("OkHttpClientTransport$ClientFrameHandler.data", stream.transportState().tag());
                synchronized (OkHttpClientTransport.this.lock) {
                    stream.transportState().transportDataReceived(buffer, z);
                }
            }
            OkHttpClientTransport.access$2412(OkHttpClientTransport.this, i2);
            if (OkHttpClientTransport.this.connectionUnacknowledgedBytesRead >= OkHttpClientTransport.this.initialWindowSize * 0.5f) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.windowUpdate(0, OkHttpClientTransport.this.connectionUnacknowledgedBytesRead);
                }
                OkHttpClientTransport.this.connectionUnacknowledgedBytesRead = 0;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            Status statusWithDescription;
            int iHeaderBlockSize;
            this.logger.logHeaders(OkHttpFrameLogger.Direction.INBOUND, i, list, z2);
            boolean z3 = true;
            if (OkHttpClientTransport.this.maxInboundMetadataSize == Integer.MAX_VALUE || (iHeaderBlockSize = headerBlockSize(list)) <= OkHttpClientTransport.this.maxInboundMetadataSize) {
                statusWithDescription = null;
            } else {
                Status status = Status.RESOURCE_EXHAUSTED;
                Object[] objArr = new Object[3];
                objArr[0] = z2 ? "trailer" : "header";
                objArr[1] = Integer.valueOf(OkHttpClientTransport.this.maxInboundMetadataSize);
                objArr[2] = Integer.valueOf(iHeaderBlockSize);
                statusWithDescription = status.withDescription(String.format("Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                if (okHttpClientStream == null) {
                    if (OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.INVALID_STREAM);
                    }
                } else if (statusWithDescription == null) {
                    PerfMark.event("OkHttpClientTransport$ClientFrameHandler.headers", okHttpClientStream.transportState().tag());
                    okHttpClientStream.transportState().transportHeadersReceived(list, z2);
                } else {
                    if (!z2) {
                        OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                    }
                    okHttpClientStream.transportState().transportReportStatus(statusWithDescription, false, new Metadata());
                }
                z3 = false;
            }
            if (z3) {
                OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received header for unknown stream: " + i);
            }
        }

        private int headerBlockSize(List<Header> list) {
            long size = 0;
            for (int i = 0; i < list.size(); i++) {
                Header header = list.get(i);
                size += header.name.size() + 32 + header.value.size();
            }
            return (int) Math.min(size, 2147483647L);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            this.logger.logRstStream(OkHttpFrameLogger.Direction.INBOUND, i, errorCode);
            Status statusAugmentDescription = OkHttpClientTransport.toGrpcStatus(errorCode).augmentDescription("Rst Stream");
            boolean z = statusAugmentDescription.getCode() == Status.Code.CANCELLED || statusAugmentDescription.getCode() == Status.Code.DEADLINE_EXCEEDED;
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                if (okHttpClientStream != null) {
                    PerfMark.event("OkHttpClientTransport$ClientFrameHandler.rstStream", okHttpClientStream.transportState().tag());
                    OkHttpClientTransport.this.finishStream(i, statusAugmentDescription, errorCode == ErrorCode.REFUSED_STREAM ? ClientStreamListener.RpcProgress.REFUSED : ClientStreamListener.RpcProgress.PROCESSED, z, null, null);
                }
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            boolean zInitialOutboundWindowSize;
            this.logger.logSettings(OkHttpFrameLogger.Direction.INBOUND, settings);
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpSettingsUtil.isSet(settings, 4)) {
                    OkHttpClientTransport.this.maxConcurrentStreams = OkHttpSettingsUtil.get(settings, 4);
                }
                if (OkHttpSettingsUtil.isSet(settings, 7)) {
                    zInitialOutboundWindowSize = OkHttpClientTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                } else {
                    zInitialOutboundWindowSize = false;
                }
                if (this.firstSettings) {
                    OkHttpClientTransport.this.listener.transportReady();
                    this.firstSettings = false;
                }
                OkHttpClientTransport.this.frameWriter.ackSettings(settings);
                if (zInitialOutboundWindowSize) {
                    OkHttpClientTransport.this.outboundFlow.writeStreams();
                }
                OkHttpClientTransport.this.startPendingStreams();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            Http2Ping http2Ping;
            long j = (i << 32) | (i2 & 4294967295L);
            this.logger.logPing(OkHttpFrameLogger.Direction.INBOUND, j);
            if (!z) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.ping(true, i, i2);
                }
                return;
            }
            synchronized (OkHttpClientTransport.this.lock) {
                http2Ping = null;
                if (OkHttpClientTransport.this.ping == null) {
                    OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
                } else if (OkHttpClientTransport.this.ping.payload() == j) {
                    Http2Ping http2Ping2 = OkHttpClientTransport.this.ping;
                    OkHttpClientTransport.this.ping = null;
                    http2Ping = http2Ping2;
                } else {
                    OkHttpClientTransport.log.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(OkHttpClientTransport.this.ping.payload()), Long.valueOf(j)));
                }
            }
            if (http2Ping != null) {
                http2Ping.complete();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            this.logger.logGoAway(OkHttpFrameLogger.Direction.INBOUND, i, errorCode, byteString);
            if (errorCode == ErrorCode.ENHANCE_YOUR_CALM) {
                String strUtf8 = byteString.utf8();
                OkHttpClientTransport.log.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, strUtf8));
                if ("too_many_pings".equals(strUtf8)) {
                    OkHttpClientTransport.this.tooManyPingsRunnable.run();
                }
            }
            Status statusAugmentDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).augmentDescription("Received Goaway");
            if (byteString.size() > 0) {
                statusAugmentDescription = statusAugmentDescription.augmentDescription(byteString.utf8());
            }
            OkHttpClientTransport.this.startGoAway(i, null, statusAugmentDescription);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i, int i2, List<Header> list) throws IOException {
            this.logger.logPushPromise(OkHttpFrameLogger.Direction.INBOUND, i, i2, list);
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.PROTOCOL_ERROR);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i, long j) {
            this.logger.logWindowsUpdate(OkHttpFrameLogger.Direction.INBOUND, i, j);
            if (j == 0) {
                if (i == 0) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                    return;
                } else {
                    OkHttpClientTransport.this.finishStream(i, Status.INTERNAL.withDescription("Received 0 flow control window increment."), ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.PROTOCOL_ERROR, null);
                    return;
                }
            }
            boolean z = false;
            synchronized (OkHttpClientTransport.this.lock) {
                if (i == 0) {
                    OkHttpClientTransport.this.outboundFlow.windowUpdate(null, (int) j);
                    return;
                }
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                if (okHttpClientStream != null) {
                    OkHttpClientTransport.this.outboundFlow.windowUpdate(okHttpClientStream, (int) j);
                } else if (!OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                    z = true;
                }
                if (z) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i);
                }
            }
        }
    }
}
