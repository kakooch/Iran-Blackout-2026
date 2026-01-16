package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalLogId;
import io.grpc.InternalMetadata;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.StreamListener;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class GrpcUtil {
    public static final CallOptions.Key<Boolean> CALL_OPTIONS_RPC_OWNED_BY_BALANCER;
    public static final Metadata.Key<byte[]> CONTENT_ACCEPT_ENCODING_KEY;
    public static final Metadata.Key<String> CONTENT_ENCODING_KEY;
    static final Metadata.Key<String> CONTENT_LENGTH_KEY;
    public static final Metadata.Key<String> CONTENT_TYPE_KEY;
    public static final long DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
    public static final ProxyDetector DEFAULT_PROXY_DETECTOR;
    public static final Metadata.Key<byte[]> MESSAGE_ACCEPT_ENCODING_KEY;
    public static final Metadata.Key<String> MESSAGE_ENCODING_KEY;
    private static final ClientStreamTracer NOOP_TRACER;
    public static final SharedResourceHolder.Resource<Executor> SHARED_CHANNEL_EXECUTOR;
    public static final Supplier<Stopwatch> STOPWATCH_SUPPLIER;
    public static final Metadata.Key<String> TE_HEADER;
    public static final Metadata.Key<Long> TIMEOUT_KEY;
    public static final SharedResourceHolder.Resource<ScheduledExecutorService> TIMER_SERVICE;
    public static final Metadata.Key<String> USER_AGENT_KEY;
    private static final Logger log = Logger.getLogger(GrpcUtil.class.getName());

    static {
        Charset charset = StandardCharsets.US_ASCII;
        TIMEOUT_KEY = Metadata.Key.of("grpc-timeout", new TimeoutMarshaller());
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        MESSAGE_ENCODING_KEY = Metadata.Key.of("grpc-encoding", asciiMarshaller);
        MESSAGE_ACCEPT_ENCODING_KEY = InternalMetadata.keyOf("grpc-accept-encoding", new AcceptEncodingMarshaller());
        CONTENT_ENCODING_KEY = Metadata.Key.of("content-encoding", asciiMarshaller);
        CONTENT_ACCEPT_ENCODING_KEY = InternalMetadata.keyOf("accept-encoding", new AcceptEncodingMarshaller());
        CONTENT_LENGTH_KEY = Metadata.Key.of("content-length", asciiMarshaller);
        CONTENT_TYPE_KEY = Metadata.Key.of("content-type", asciiMarshaller);
        TE_HEADER = Metadata.Key.of("te", asciiMarshaller);
        USER_AGENT_KEY = Metadata.Key.of("user-agent", asciiMarshaller);
        Splitter.on(',').trimResults();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        DEFAULT_KEEPALIVE_TIMEOUT_NANOS = timeUnit.toNanos(20L);
        TimeUnit.HOURS.toNanos(2L);
        timeUnit.toNanos(20L);
        DEFAULT_PROXY_DETECTOR = new ProxyDetectorImpl();
        new ProxyDetector() { // from class: io.grpc.internal.GrpcUtil.1
            @Override // io.grpc.ProxyDetector
            public ProxiedSocketAddress proxyFor(SocketAddress socketAddress) {
                return null;
            }
        };
        CALL_OPTIONS_RPC_OWNED_BY_BALANCER = CallOptions.Key.create("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        NOOP_TRACER = new ClientStreamTracer() { // from class: io.grpc.internal.GrpcUtil.2
        };
        SHARED_CHANNEL_EXECUTOR = new SharedResourceHolder.Resource<Executor>() { // from class: io.grpc.internal.GrpcUtil.3
            public String toString() {
                return "grpc-default-executor";
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public Executor create() {
                return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-default-executor-%d", true));
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public void close(Executor executor) {
                ((ExecutorService) executor).shutdown();
            }
        };
        TIMER_SERVICE = new SharedResourceHolder.Resource<ScheduledExecutorService>() { // from class: io.grpc.internal.GrpcUtil.4
            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public ScheduledExecutorService create() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, GrpcUtil.getThreadFactory("grpc-timer-%d", true));
                try {
                    scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
                } catch (NoSuchMethodException unused) {
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
                return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
            }

            @Override // io.grpc.internal.SharedResourceHolder.Resource
            public void close(ScheduledExecutorService scheduledExecutorService) {
                scheduledExecutorService.shutdown();
            }
        };
        STOPWATCH_SUPPLIER = new Supplier<Stopwatch>() { // from class: io.grpc.internal.GrpcUtil.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.common.base.Supplier
            public Stopwatch get() {
                return Stopwatch.createUnstarted();
            }
        };
    }

    private static final class AcceptEncodingMarshaller implements InternalMetadata.TrustedAsciiMarshaller<byte[]> {
        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] parseAsciiString(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(byte[] bArr) {
            return bArr;
        }

        private AcceptEncodingMarshaller() {
        }
    }

    public static boolean shouldBeCountedForInUse(CallOptions callOptions) {
        return !Boolean.TRUE.equals(callOptions.getOption(CALL_OPTIONS_RPC_OWNED_BY_BALANCER));
    }

    public static Status httpStatusToGrpcStatus(int i) {
        return httpStatusToGrpcCode(i).toStatus().withDescription("HTTP status code " + i);
    }

    private static Status.Code httpStatusToGrpcCode(int i) {
        if (i >= 100 && i < 200) {
            return Status.Code.INTERNAL;
        }
        if (i != 400) {
            if (i == 401) {
                return Status.Code.UNAUTHENTICATED;
            }
            if (i == 403) {
                return Status.Code.PERMISSION_DENIED;
            }
            if (i == 404) {
                return Status.Code.UNIMPLEMENTED;
            }
            if (i != 429) {
                if (i != 431) {
                    switch (i) {
                        case 502:
                        case 503:
                        case 504:
                            break;
                        default:
                            return Status.Code.UNKNOWN;
                    }
                }
            }
            return Status.Code.UNAVAILABLE;
        }
        return Status.Code.INTERNAL;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NO_ERROR' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class Http2Error {
        private static final /* synthetic */ Http2Error[] $VALUES;
        public static final Http2Error CANCEL;
        public static final Http2Error COMPRESSION_ERROR;
        public static final Http2Error CONNECT_ERROR;
        public static final Http2Error ENHANCE_YOUR_CALM;
        public static final Http2Error FLOW_CONTROL_ERROR;
        public static final Http2Error FRAME_SIZE_ERROR;
        public static final Http2Error HTTP_1_1_REQUIRED;
        public static final Http2Error INADEQUATE_SECURITY;
        public static final Http2Error INTERNAL_ERROR;
        public static final Http2Error NO_ERROR;
        public static final Http2Error PROTOCOL_ERROR;
        public static final Http2Error REFUSED_STREAM;
        public static final Http2Error SETTINGS_TIMEOUT;
        public static final Http2Error STREAM_CLOSED;
        private static final Http2Error[] codeMap;
        private final int code;
        private final Status status;

        public static Http2Error valueOf(String str) {
            return (Http2Error) Enum.valueOf(Http2Error.class, str);
        }

        public static Http2Error[] values() {
            return (Http2Error[]) $VALUES.clone();
        }

        static {
            Status status = Status.UNAVAILABLE;
            Http2Error http2Error = new Http2Error("NO_ERROR", 0, 0, status);
            NO_ERROR = http2Error;
            Status status2 = Status.INTERNAL;
            Http2Error http2Error2 = new Http2Error("PROTOCOL_ERROR", 1, 1, status2);
            PROTOCOL_ERROR = http2Error2;
            Http2Error http2Error3 = new Http2Error("INTERNAL_ERROR", 2, 2, status2);
            INTERNAL_ERROR = http2Error3;
            Http2Error http2Error4 = new Http2Error("FLOW_CONTROL_ERROR", 3, 3, status2);
            FLOW_CONTROL_ERROR = http2Error4;
            Http2Error http2Error5 = new Http2Error("SETTINGS_TIMEOUT", 4, 4, status2);
            SETTINGS_TIMEOUT = http2Error5;
            Http2Error http2Error6 = new Http2Error("STREAM_CLOSED", 5, 5, status2);
            STREAM_CLOSED = http2Error6;
            Http2Error http2Error7 = new Http2Error("FRAME_SIZE_ERROR", 6, 6, status2);
            FRAME_SIZE_ERROR = http2Error7;
            Http2Error http2Error8 = new Http2Error("REFUSED_STREAM", 7, 7, status);
            REFUSED_STREAM = http2Error8;
            Http2Error http2Error9 = new Http2Error("CANCEL", 8, 8, Status.CANCELLED);
            CANCEL = http2Error9;
            Http2Error http2Error10 = new Http2Error("COMPRESSION_ERROR", 9, 9, status2);
            COMPRESSION_ERROR = http2Error10;
            Http2Error http2Error11 = new Http2Error("CONNECT_ERROR", 10, 10, status2);
            CONNECT_ERROR = http2Error11;
            Http2Error http2Error12 = new Http2Error("ENHANCE_YOUR_CALM", 11, 11, Status.RESOURCE_EXHAUSTED.withDescription("Bandwidth exhausted"));
            ENHANCE_YOUR_CALM = http2Error12;
            Http2Error http2Error13 = new Http2Error("INADEQUATE_SECURITY", 12, 12, Status.PERMISSION_DENIED.withDescription("Permission denied as protocol is not secure enough to call"));
            INADEQUATE_SECURITY = http2Error13;
            Http2Error http2Error14 = new Http2Error("HTTP_1_1_REQUIRED", 13, 13, Status.UNKNOWN);
            HTTP_1_1_REQUIRED = http2Error14;
            $VALUES = new Http2Error[]{http2Error, http2Error2, http2Error3, http2Error4, http2Error5, http2Error6, http2Error7, http2Error8, http2Error9, http2Error10, http2Error11, http2Error12, http2Error13, http2Error14};
            codeMap = buildHttp2CodeMap();
        }

        private static Http2Error[] buildHttp2CodeMap() {
            Http2Error[] http2ErrorArrValues = values();
            Http2Error[] http2ErrorArr = new Http2Error[((int) http2ErrorArrValues[http2ErrorArrValues.length - 1].code()) + 1];
            for (Http2Error http2Error : http2ErrorArrValues) {
                http2ErrorArr[(int) http2Error.code()] = http2Error;
            }
            return http2ErrorArr;
        }

        private Http2Error(String str, int i, int i2, Status status) {
            this.code = i2;
            String str2 = "HTTP/2 error code: " + name();
            if (status.getDescription() != null) {
                str2 = str2 + " (" + status.getDescription() + ")";
            }
            this.status = status.withDescription(str2);
        }

        public long code() {
            return this.code;
        }

        public Status status() {
            return this.status;
        }

        public static Http2Error forCode(long j) {
            Http2Error[] http2ErrorArr = codeMap;
            if (j >= http2ErrorArr.length || j < 0) {
                return null;
            }
            return http2ErrorArr[(int) j];
        }

        public static Status statusForCode(long j) {
            Http2Error http2ErrorForCode = forCode(j);
            if (http2ErrorForCode == null) {
                return Status.fromCodeValue(INTERNAL_ERROR.status().getCode().value()).withDescription("Unrecognized HTTP/2 error code: " + j);
            }
            return http2ErrorForCode.status();
        }
    }

    public static boolean isGrpcContentType(String str) {
        char cCharAt;
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("application/grpc")) {
            return lowerCase.length() == 16 || (cCharAt = lowerCase.charAt(16)) == '+' || cCharAt == ';';
        }
        return false;
    }

    public static String getGrpcUserAgent(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-");
        sb.append(str);
        sb.append('/');
        sb.append("1.44.1");
        return sb.toString();
    }

    public static URI authorityToUri(String str) {
        Preconditions.checkNotNull(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid authority: " + str, e);
        }
    }

    public static String checkAuthority(String str) {
        URI uriAuthorityToUri = authorityToUri(str);
        Preconditions.checkArgument(uriAuthorityToUri.getHost() != null, "No host in authority '%s'", str);
        Preconditions.checkArgument(uriAuthorityToUri.getUserInfo() == null, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static ThreadFactory getThreadFactory(String str, boolean z) {
        return new ThreadFactoryBuilder().setDaemon(z).setNameFormat(str).build();
    }

    public static String getHost(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    static class TimeoutMarshaller implements Metadata.AsciiMarshaller<Long> {
        TimeoutMarshaller() {
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(Long l) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l.longValue() < 100000000) {
                return l + "n";
            }
            if (l.longValue() < 100000000000L) {
                return timeUnit.toMicros(l.longValue()) + "u";
            }
            if (l.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l.longValue()) + "m";
            }
            if (l.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l.longValue()) + "S";
            }
            if (l.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l.longValue()) + "M";
            }
            return timeUnit.toHours(l.longValue()) + "H";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.AsciiMarshaller
        public Long parseAsciiString(String str) throws NumberFormatException {
            Preconditions.checkArgument(str.length() > 0, "empty timeout");
            Preconditions.checkArgument(str.length() <= 9, "bad timeout format");
            long j = Long.parseLong(str.substring(0, str.length() - 1));
            char cCharAt = str.charAt(str.length() - 1);
            if (cCharAt == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(j));
            }
            if (cCharAt == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(j));
            }
            if (cCharAt == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(j));
            }
            if (cCharAt == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j));
            }
            if (cCharAt == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j));
            }
            if (cCharAt == 'n') {
                return Long.valueOf(j);
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
        }
    }

    static ClientTransport getTransportFromPickResult(LoadBalancer.PickResult pickResult, boolean z) {
        LoadBalancer.Subchannel subchannel = pickResult.getSubchannel();
        final ClientTransport clientTransportObtainActiveTransport = subchannel != null ? ((TransportProvider) subchannel.getInternalSubchannel()).obtainActiveTransport() : null;
        if (clientTransportObtainActiveTransport != null) {
            final ClientStreamTracer.Factory streamTracerFactory = pickResult.getStreamTracerFactory();
            return streamTracerFactory == null ? clientTransportObtainActiveTransport : new ClientTransport() { // from class: io.grpc.internal.GrpcUtil.6
                @Override // io.grpc.internal.ClientTransport
                public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
                    ClientStreamTracer clientStreamTracerNewClientStreamTracer = streamTracerFactory.newClientStreamTracer(ClientStreamTracer.StreamInfo.newBuilder().setCallOptions(callOptions).build(), metadata);
                    Preconditions.checkState(clientStreamTracerArr[clientStreamTracerArr.length - 1] == GrpcUtil.NOOP_TRACER, "lb tracer already assigned");
                    clientStreamTracerArr[clientStreamTracerArr.length - 1] = clientStreamTracerNewClientStreamTracer;
                    return clientTransportObtainActiveTransport.newStream(methodDescriptor, metadata, callOptions, clientStreamTracerArr);
                }

                @Override // io.grpc.InternalWithLogId
                public InternalLogId getLogId() {
                    return clientTransportObtainActiveTransport.getLogId();
                }
            };
        }
        if (!pickResult.getStatus().isOk()) {
            if (pickResult.isDrop()) {
                return new FailingClientTransport(pickResult.getStatus(), ClientStreamListener.RpcProgress.DROPPED);
            }
            if (!z) {
                return new FailingClientTransport(pickResult.getStatus(), ClientStreamListener.RpcProgress.PROCESSED);
            }
        }
        return null;
    }

    public static ClientStreamTracer[] getClientStreamTracers(CallOptions callOptions, Metadata metadata, int i, boolean z) {
        List<ClientStreamTracer.Factory> streamTracerFactories = callOptions.getStreamTracerFactories();
        int size = streamTracerFactories.size() + 1;
        ClientStreamTracer[] clientStreamTracerArr = new ClientStreamTracer[size];
        ClientStreamTracer.StreamInfo streamInfoBuild = ClientStreamTracer.StreamInfo.newBuilder().setCallOptions(callOptions).setPreviousAttempts(i).setIsTransparentRetry(z).build();
        for (int i2 = 0; i2 < streamTracerFactories.size(); i2++) {
            clientStreamTracerArr[i2] = streamTracerFactories.get(i2).newClientStreamTracer(streamInfoBuild, metadata);
        }
        clientStreamTracerArr[size - 1] = NOOP_TRACER;
        return clientStreamTracerArr;
    }

    static void closeQuietly(StreamListener.MessageProducer messageProducer) throws IOException {
        while (true) {
            InputStream next = messageProducer.next();
            if (next == null) {
                return;
            } else {
                closeQuietly(next);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            log.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e);
        }
    }

    private GrpcUtil() {
    }
}
