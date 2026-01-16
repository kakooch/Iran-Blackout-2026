package org.xbill.DNS;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import ir.nasim.OI3;
import ir.nasim.RI3;
import ir.nasim.SW1;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import lombok.Generated;
import org.xbill.DNS.AsyncSemaphore;
import org.xbill.DNS.utils.base64;

/* loaded from: classes8.dex */
public final class DohResolver implements Resolver {
    private static final String APPLICATION_DNS_MESSAGE = "application/dns-message";
    private static final boolean USE_HTTP_CLIENT;
    private static Method byteArrayBodyPublisherMethod;
    private static Object defaultHttpRequestBuilder;
    private static Method httpClientBuilderBuildMethod;
    private static Method httpClientBuilderExecutorMethod;
    private static Method httpClientBuilderTimeoutMethod;
    private static Method httpClientNewBuilderMethod;
    private static Method httpClientSendAsyncMethod;
    private static Method httpResponseBodyMethod;
    private static Method httpResponseStatusCodeMethod;
    private static Method publisherOfByteArrayMethod;
    private static Method requestBuilderBuildMethod;
    private static Method requestBuilderCopyMethod;
    private static Method requestBuilderPostMethod;
    private static Method requestBuilderTimeoutMethod;
    private static Method requestBuilderUriMethod;
    private Executor defaultExecutor;
    private final Duration idleConnectionTimeout;
    private final AsyncSemaphore initialRequestLock;
    private final AtomicLong lastRequest;
    private final AsyncSemaphore maxConcurrentRequests;
    private OPTRecord queryOPT;
    private final SSLSocketFactory sslSocketFactory;
    private Duration timeout;
    private TSIG tsig;
    private String uriTemplate;
    private boolean usePost;

    @Generated
    private static final OI3 log = RI3.i(DohResolver.class);
    private static final Map<Executor, Object> httpClients = Collections.synchronizedMap(new WeakHashMap());

    private static final class SendAndGetMessageBytesResponse {
        private final int rc;
        private final byte[] responseBytes;

        @Generated
        public SendAndGetMessageBytesResponse(int i, byte[] bArr) {
            this.rc = i;
            this.responseBytes = bArr;
        }

        @Generated
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SendAndGetMessageBytesResponse)) {
                return false;
            }
            SendAndGetMessageBytesResponse sendAndGetMessageBytesResponse = (SendAndGetMessageBytesResponse) obj;
            return getRc() == sendAndGetMessageBytesResponse.getRc() && Arrays.equals(getResponseBytes(), sendAndGetMessageBytesResponse.getResponseBytes());
        }

        @Generated
        public int getRc() {
            return this.rc;
        }

        @Generated
        public byte[] getResponseBytes() {
            return this.responseBytes;
        }

        @Generated
        public int hashCode() {
            return ((getRc() + 59) * 59) + Arrays.hashCode(getResponseBytes());
        }

        @Generated
        public String toString() {
            return "DohResolver.SendAndGetMessageBytesResponse(rc=" + getRc() + ", responseBytes=" + Arrays.toString(getResponseBytes()) + Separators.RPAREN;
        }
    }

    static {
        boolean z;
        if (System.getProperty("java.version").startsWith("1.")) {
            z = false;
        } else {
            try {
                Class<?> cls = Class.forName("java.net.http.HttpClient$Builder");
                Class<?> cls2 = Class.forName("java.net.http.HttpClient");
                Class<?> cls3 = Class.forName("java.net.http.HttpClient$Version");
                Class<?> cls4 = Class.forName("java.net.http.HttpRequest$Builder");
                Class<?> cls5 = Class.forName("java.net.http.HttpRequest");
                Class<?> cls6 = Class.forName("java.net.http.HttpRequest$BodyPublishers");
                Class<?> cls7 = Class.forName("java.net.http.HttpRequest$BodyPublisher");
                Class<?> cls8 = Class.forName("java.net.http.HttpResponse");
                Class<?> cls9 = Class.forName("java.net.http.HttpResponse$BodyHandlers");
                Class<?> cls10 = Class.forName("java.net.http.HttpResponse$BodyHandler");
                httpClientBuilderTimeoutMethod = cls.getDeclaredMethod("connectTimeout", SW1.a());
                httpClientBuilderExecutorMethod = cls.getDeclaredMethod("executor", Executor.class);
                httpClientBuilderBuildMethod = cls.getDeclaredMethod("build", null);
                httpClientNewBuilderMethod = cls2.getDeclaredMethod("newBuilder", null);
                httpClientSendAsyncMethod = cls2.getDeclaredMethod("sendAsync", cls5, cls10);
                Method declaredMethod = cls4.getDeclaredMethod("header", String.class, String.class);
                Method declaredMethod2 = cls4.getDeclaredMethod(ParameterNames.VERSION, cls3);
                requestBuilderTimeoutMethod = cls4.getDeclaredMethod("timeout", SW1.a());
                requestBuilderUriMethod = cls4.getDeclaredMethod("uri", URI.class);
                requestBuilderCopyMethod = cls4.getDeclaredMethod("copy", null);
                requestBuilderBuildMethod = cls4.getDeclaredMethod("build", null);
                requestBuilderPostMethod = cls4.getDeclaredMethod("POST", cls7);
                Method declaredMethod3 = cls5.getDeclaredMethod("newBuilder", null);
                publisherOfByteArrayMethod = cls6.getDeclaredMethod("ofByteArray", byte[].class);
                byteArrayBodyPublisherMethod = cls9.getDeclaredMethod("ofByteArray", null);
                httpResponseBodyMethod = cls8.getDeclaredMethod("body", null);
                httpResponseStatusCodeMethod = cls8.getDeclaredMethod("statusCode", null);
                defaultHttpRequestBuilder = declaredMethod3.invoke(null, null);
                declaredMethod2.invoke(defaultHttpRequestBuilder, Enum.valueOf(cls3, "HTTP_2"));
                declaredMethod.invoke(defaultHttpRequestBuilder, SIPHeaderNames.CONTENT_TYPE, APPLICATION_DNS_MESSAGE);
                declaredMethod.invoke(defaultHttpRequestBuilder, SIPHeaderNames.ACCEPT, APPLICATION_DNS_MESSAGE);
                z = true;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                log.y("Java >= 11 detected, but HttpRequest not available");
            }
        }
        USE_HTTP_CLIENT = z;
    }

    public DohResolver(String str) {
        this(str, 100, Duration.ofMinutes(2L));
    }

    private void discardStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                try {
                    do {
                    } while (inputStream.read(new byte[4096]) > 0);
                    inputStream.close();
                } finally {
                }
            } catch (IOException unused) {
            }
        }
    }

    private <T> CompletableFuture<T> failedFuture(Throwable th) {
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        completableFuture.completeExceptionally(th);
        return completableFuture;
    }

    private Object getHttpClient(Executor executor) {
        return httpClients.computeIfAbsent(executor, new Function() { // from class: ir.nasim.XW1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.lambda$getHttpClient$0((Executor) obj);
            }
        });
    }

    private String getUrl(byte[] bArr) {
        String str = this.uriTemplate;
        if (this.usePost) {
            return str;
        }
        return str + "?dns=" + base64.toString(bArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getHttpClient$0(Executor executor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = httpClientNewBuilderMethod.invoke(null, null);
            httpClientBuilderTimeoutMethod.invoke(objInvoke, this.timeout);
            httpClientBuilderExecutorMethod.invoke(objInvoke, executor);
            return httpClientBuilderBuildMethod.invoke(objInvoke, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.g("Could not create a HttpClient with for Executor {}", executor, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$sendAsync11$2(Message message, Executor executor, long j, Object obj, AsyncSemaphore.Permit permit, Throwable th) {
        return th != null ? timeoutFailedFuture(message, th) : sendAsync11WithInitialRequestPermit(message, executor, j, obj, permit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendAsync11WithConcurrentRequestPermit$4(long j, AsyncSemaphore.Permit permit, boolean z, AsyncSemaphore.Permit permit2, Object obj, Throwable th) {
        if (th == null) {
            this.lastRequest.set(j);
        }
        permit.release();
        if (z) {
            permit2.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture lambda$sendAsync11WithConcurrentRequestPermit$5(Message message, Object obj, Throwable th) {
        Message message2;
        if (th != null) {
            return th.getCause().getClass().getSimpleName().equals("HttpTimeoutException") ? timeoutFailedFuture(message, th.getCause()) : failedFuture(th);
        }
        try {
            int iIntValue = ((Integer) httpResponseStatusCodeMethod.invoke(obj, null)).intValue();
            if (iIntValue < 200 || iIntValue >= 300) {
                message2 = new Message();
                message2.getHeader().setRcode(2);
            } else {
                byte[] bArr = (byte[]) httpResponseBodyMethod.invoke(obj, null);
                message2 = new Message(bArr);
                verifyTSIG(message, message2, bArr, this.tsig);
            }
            message2.setResolver(this);
            return CompletableFuture.completedFuture(message2);
        } catch (IOException e) {
            e = e;
            return failedFuture(e);
        } catch (IllegalAccessException e2) {
            e = e2;
            return failedFuture(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            return failedFuture(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletionStage lambda$sendAsync11WithInitialRequestPermit$3(boolean z, AsyncSemaphore.Permit permit, Message message, Executor executor, long j, Object obj, AsyncSemaphore.Permit permit2, Throwable th) {
        if (th == null) {
            return sendAsync11WithConcurrentRequestPermit(message, executor, j, obj, permit, z, permit2);
        }
        if (z) {
            permit.release();
        }
        return timeoutFailedFuture(message, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableFuture lambda$sendAsync8$1(Message message, String str, byte[] bArr, long j, AsyncSemaphore.Permit permit, Throwable th) {
        Message message2;
        try {
            if (th != null) {
                return timeoutFailedFuture(message, th);
            }
            try {
                SendAndGetMessageBytesResponse sendAndGetMessageBytesResponseSendAndGetMessageBytes = sendAndGetMessageBytes(str, bArr, j);
                if (sendAndGetMessageBytesResponseSendAndGetMessageBytes.rc == 0) {
                    message2 = new Message(sendAndGetMessageBytesResponseSendAndGetMessageBytes.responseBytes);
                    verifyTSIG(message, message2, sendAndGetMessageBytesResponseSendAndGetMessageBytes.responseBytes, this.tsig);
                } else {
                    message2 = new Message(0);
                    message2.getHeader().setRcode(sendAndGetMessageBytesResponseSendAndGetMessageBytes.rc);
                }
                message2.setResolver(this);
                CompletableFuture completableFutureCompletedFuture = CompletableFuture.completedFuture(message2);
                permit.release();
                return completableFutureCompletedFuture;
            } catch (SocketTimeoutException e) {
                CompletableFuture completableFutureTimeoutFailedFuture = timeoutFailedFuture(message, e);
                permit.release();
                return completableFutureTimeoutFailedFuture;
            } catch (IOException e2) {
                e = e2;
                CompletableFuture completableFutureFailedFuture = failedFuture(e);
                permit.release();
                return completableFutureFailedFuture;
            } catch (URISyntaxException e3) {
                e = e3;
                CompletableFuture completableFutureFailedFuture2 = failedFuture(e);
                permit.release();
                return completableFutureFailedFuture2;
            }
        } catch (Throwable th2) {
            permit.release();
            throw th2;
        }
    }

    private Message prepareQuery(Message message) {
        Message messageClone = message.clone();
        messageClone.getHeader().setID(0);
        if (this.queryOPT != null && messageClone.getOPT() == null) {
            messageClone.addRecord(this.queryOPT, 3);
        }
        TSIG tsig = this.tsig;
        if (tsig != null) {
            tsig.apply(messageClone, null);
        }
        return messageClone;
    }

    /* JADX WARN: Finally extract failed */
    private SendAndGetMessageBytesResponse sendAndGetMessageBytes(String str, byte[] bArr, long j) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URI(str).toURL().openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.sslSocketFactory);
        }
        Duration durationMinus = this.timeout.minus(getNanoTime() - j, ChronoUnit.NANOS);
        httpURLConnection.setConnectTimeout((int) durationMinus.toMillis());
        httpURLConnection.setReadTimeout((int) durationMinus.toMillis());
        httpURLConnection.setRequestMethod(this.usePost ? "POST" : "GET");
        httpURLConnection.setRequestProperty(SIPHeaderNames.CONTENT_TYPE, APPLICATION_DNS_MESSAGE);
        httpURLConnection.setRequestProperty(SIPHeaderNames.ACCEPT, APPLICATION_DNS_MESSAGE);
        if (this.usePost) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(bArr);
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 300) {
            discardStream(httpURLConnection.getInputStream());
            discardStream(httpURLConnection.getErrorStream());
            return new SendAndGetMessageBytesResponse(2, null);
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                if (httpURLConnection.getContentLength() > -1) {
                    int contentLength = httpURLConnection.getContentLength();
                    byte[] bArr2 = new byte[contentLength];
                    int i = 0;
                    do {
                        int i2 = inputStream.read(bArr2, i, contentLength - i);
                        if (i2 <= 0) {
                            if (i < contentLength) {
                                throw new EOFException("Could not read expected content length");
                            }
                            SendAndGetMessageBytesResponse sendAndGetMessageBytesResponse = new SendAndGetMessageBytesResponse(0, bArr2);
                            inputStream.close();
                            return sendAndGetMessageBytesResponse;
                        }
                        i += i2;
                    } while (!this.timeout.minus(getNanoTime() - j, ChronoUnit.NANOS).isNegative());
                    throw new SocketTimeoutException();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr3 = new byte[4096];
                    while (true) {
                        int i3 = inputStream.read(bArr3, 0, 4096);
                        if (i3 <= 0) {
                            SendAndGetMessageBytesResponse sendAndGetMessageBytesResponse2 = new SendAndGetMessageBytesResponse(0, byteArrayOutputStream.toByteArray());
                            byteArrayOutputStream.close();
                            inputStream.close();
                            return sendAndGetMessageBytesResponse2;
                        }
                        if (this.timeout.minus(getNanoTime() - j, ChronoUnit.NANOS).isNegative()) {
                            throw new SocketTimeoutException();
                        }
                        byteArrayOutputStream.write(bArr3, 0, i3);
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
            }
        } catch (IOException e) {
            discardStream(httpURLConnection.getErrorStream());
            throw e;
        }
    }

    private CompletionStage<Message> sendAsync11(final Message message, final Executor executor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        final long nanoTime = getNanoTime();
        byte[] wire = prepareQuery(message).toWire();
        String url = getUrl(wire);
        try {
            final Object objInvoke = requestBuilderCopyMethod.invoke(defaultHttpRequestBuilder, null);
            requestBuilderUriMethod.invoke(objInvoke, URI.create(url));
            if (this.usePost) {
                requestBuilderPostMethod.invoke(objInvoke, publisherOfByteArrayMethod.invoke(null, wire));
            }
            return this.initialRequestLock.acquire(this.timeout.minus(getNanoTime() - nanoTime, ChronoUnit.NANOS)).handle(new BiFunction() { // from class: org.xbill.DNS.c
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return this.a.lambda$sendAsync11$2(message, executor, nanoTime, objInvoke, (AsyncSemaphore.Permit) obj, (Throwable) obj2);
                }
            }).thenCompose(Function.identity());
        } catch (IllegalAccessException | InvocationTargetException e) {
            return failedFuture(e);
        }
    }

    private CompletionStage<Message> sendAsync11WithConcurrentRequestPermit(final Message message, Executor executor, final long j, Object obj, final AsyncSemaphore.Permit permit, final boolean z, final AsyncSemaphore.Permit permit2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Duration durationMinus = this.timeout.minus(getNanoTime() - j, ChronoUnit.NANOS);
        if (durationMinus.isNegative()) {
            if (z) {
                permit.release();
            }
            permit2.release();
            return timeoutFailedFuture(message, null);
        }
        try {
            Object httpClient = getHttpClient(executor);
            requestBuilderTimeoutMethod.invoke(obj, durationMinus);
            return TimeoutCompletableFuture.compatTimeout(((CompletableFuture) httpClientSendAsyncMethod.invoke(httpClient, requestBuilderBuildMethod.invoke(obj, null), byteArrayBodyPublisherMethod.invoke(null, null))).whenComplete(new BiConsumer() { // from class: org.xbill.DNS.d
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    this.a.lambda$sendAsync11WithConcurrentRequestPermit$4(j, permit2, z, permit, obj2, (Throwable) obj3);
                }
            }).handleAsync(new BiFunction() { // from class: ir.nasim.YW1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj2, Object obj3) {
                    return this.a.lambda$sendAsync11WithConcurrentRequestPermit$5(message, obj2, (Throwable) obj3);
                }
            }, executor).thenCompose(Function.identity()), durationMinus.toMillis(), TimeUnit.MILLISECONDS);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return failedFuture(e);
        }
    }

    private CompletionStage<Message> sendAsync11WithInitialRequestPermit(final Message message, final Executor executor, final long j, final Object obj, final AsyncSemaphore.Permit permit) {
        final boolean z = this.idleConnectionTimeout.toNanos() > getNanoTime() - this.lastRequest.get();
        if (!z) {
            permit.release();
        }
        Duration durationMinus = this.timeout.minus(getNanoTime() - j, ChronoUnit.NANOS);
        if (!durationMinus.isNegative()) {
            return this.maxConcurrentRequests.acquire(durationMinus).handle(new BiFunction() { // from class: org.xbill.DNS.e
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj2, Object obj3) {
                    return this.a.lambda$sendAsync11WithInitialRequestPermit$3(z, permit, message, executor, j, obj, (AsyncSemaphore.Permit) obj2, (Throwable) obj3);
                }
            }).thenCompose(Function.identity());
        }
        if (z) {
            permit.release();
        }
        return timeoutFailedFuture(message, null);
    }

    private CompletionStage<Message> sendAsync8(final Message message, Executor executor) {
        final byte[] wire = prepareQuery(message).toWire();
        final String url = getUrl(wire);
        final long nanoTime = getNanoTime();
        return this.maxConcurrentRequests.acquire(this.timeout).handleAsync(new BiFunction() { // from class: org.xbill.DNS.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.a.lambda$sendAsync8$1(message, url, wire, nanoTime, (AsyncSemaphore.Permit) obj, (Throwable) obj2);
            }
        }, executor).thenCompose(Function.identity());
    }

    private <T> CompletableFuture<T> timeoutFailedFuture(Message message, Throwable th) {
        return failedFuture(new IOException("Query " + message.getHeader().getID() + " for " + message.getQuestion().getName() + Separators.SLASH + Type.string(message.getQuestion().getType()) + " timed out", th));
    }

    private void verifyTSIG(Message message, Message message2, byte[] bArr, TSIG tsig) {
        if (tsig == null) {
            return;
        }
        log.l("TSIG verify for query {}, {}/{}: {}", Integer.valueOf(message.getHeader().getID()), message.getQuestion().getName(), Type.string(message.getQuestion().getType()), Rcode.TSIGstring(tsig.verify(message2, bArr, message.getGeneratedTSIG())));
    }

    @Deprecated
    public Executor getExecutor() {
        return this.defaultExecutor;
    }

    long getNanoTime() {
        return System.nanoTime();
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.timeout;
    }

    public String getUriTemplate() {
        return this.uriTemplate;
    }

    public boolean isUsePost() {
        return this.usePost;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, this.defaultExecutor);
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i, int i2, int i3, List<EDNSOption> list) {
        if (i == -1) {
            this.queryOPT = null;
        } else {
            if (i != 0) {
                throw new IllegalArgumentException("invalid EDNS version - must be 0 or -1 to disable");
            }
            this.queryOPT = new OPTRecord(0, 0, i, i3, list);
        }
    }

    @Deprecated
    public void setExecutor(Executor executor) {
        if (executor == null) {
            executor = ForkJoinPool.commonPool();
        }
        this.defaultExecutor = executor;
        httpClients.clear();
    }

    @Override // org.xbill.DNS.Resolver
    public void setIgnoreTruncation(boolean z) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        this.tsig = tsig;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.timeout = duration;
        httpClients.clear();
    }

    public void setUriTemplate(String str) {
        this.uriTemplate = str;
    }

    public void setUsePost(boolean z) {
        this.usePost = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DohResolver {");
        sb.append(this.usePost ? "POST " : "GET ");
        sb.append(this.uriTemplate);
        sb.append("}");
        return sb.toString();
    }

    public DohResolver(String str, int i, Duration duration) throws NumberFormatException {
        this.usePost = false;
        this.timeout = Duration.ofSeconds(5L);
        this.queryOPT = new OPTRecord(0, 0, 0);
        this.defaultExecutor = ForkJoinPool.commonPool();
        this.lastRequest = new AtomicLong(0L);
        this.initialRequestLock = new AsyncSemaphore(1);
        this.uriTemplate = str;
        this.idleConnectionTimeout = duration;
        if (i <= 0) {
            throw new IllegalArgumentException("maxConcurrentRequests must be > 0");
        }
        if (!USE_HTTP_CLIENT) {
            try {
                int i2 = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
                if (i > i2) {
                    i = i2;
                }
            } catch (NumberFormatException unused) {
            }
        }
        this.maxConcurrentRequests = new AsyncSemaphore(i);
        try {
            this.sslSocketFactory = SSLContext.getDefault().getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        return USE_HTTP_CLIENT ? sendAsync11(message, executor) : sendAsync8(message, executor);
    }
}
