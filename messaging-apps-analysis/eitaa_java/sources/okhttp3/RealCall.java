package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

/* loaded from: classes.dex */
final class RealCall implements Call {
    final OkHttpClient client;

    @Nullable
    private EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final AsyncTimeout timeout;

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(okHttpClient, z);
        AsyncTimeout asyncTimeout = new AsyncTimeout() { // from class: okhttp3.RealCall.1
            @Override // okio.AsyncTimeout
            protected void timedOut() throws IOException {
                RealCall.this.cancel();
            }
        };
        this.timeout = asyncTimeout;
        asyncTimeout.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                if (responseWithInterceptorChain != null) {
                    return responseWithInterceptorChain;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                IOException iOExceptionTimeoutExit = timeoutExit(e);
                this.eventListener.callFailed(this, iOExceptionTimeoutExit);
                throw iOExceptionTimeoutExit;
            }
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    @Nullable
    IOException timeoutExit(@Nullable IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    public void cancel() throws IOException {
        this.retryAndFollowUpInterceptor.cancel();
    }

    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    /* loaded from: classes3.dex */
    final class AsyncCall extends NamedRunnable {
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        String host() {
            return this.this$0.originalRequest.url().host();
        }

        RealCall get() {
            return this.this$0;
        }

        void executeOn(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.this$0.eventListener.callFailed(this.this$0, interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.client.dispatcher().finished(this);
                }
            } catch (Throwable th) {
                this.this$0.client.dispatcher().finished(this);
                throw th;
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            IOException e;
            Response responseWithInterceptorChain;
            this.this$0.timeout.enter();
            boolean z = true;
            try {
                try {
                    responseWithInterceptorChain = this.this$0.getResponseWithInterceptorChain();
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (this.this$0.retryAndFollowUpInterceptor.isCanceled()) {
                        this.responseCallback.onFailure(this.this$0, new IOException("Canceled"));
                    } else {
                        this.responseCallback.onResponse(this.this$0, responseWithInterceptorChain);
                    }
                } catch (IOException e3) {
                    e = e3;
                    IOException iOExceptionTimeoutExit = this.this$0.timeoutExit(e);
                    if (!z) {
                        this.this$0.eventListener.callFailed(this.this$0, iOExceptionTimeoutExit);
                        this.responseCallback.onFailure(this.this$0, iOExceptionTimeoutExit);
                    } else {
                        Platform.get().log(4, "Callback failure for " + this.this$0.toLoggableString(), iOExceptionTimeoutExit);
                    }
                }
            } finally {
                this.this$0.client.dispatcher().finished(this);
            }
        }
    }

    String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.internalCache()));
        arrayList.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        return new RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
    }
}
