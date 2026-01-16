package io.sentry.android.core;

import io.sentry.C3155n3;
import io.sentry.EnumC3136k;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3157o0;
import io.sentry.N;
import io.sentry.P1;
import io.sentry.S1;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import java.io.Closeable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
final class SendCachedEnvelopeIntegration implements InterfaceC3157o0, N.b, Closeable {
    private final S1 a;
    private final io.sentry.util.q b;
    private io.sentry.N d;
    private io.sentry.Z e;
    private SentryAndroidOptions f;
    private P1 g;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final C3202a j = new C3202a();

    public SendCachedEnvelopeIntegration(S1 s1, io.sentry.util.q qVar) {
        this.a = (S1) io.sentry.util.u.c(s1, "SendFireAndForgetFactory is required");
        this.b = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(SentryAndroidOptions sentryAndroidOptions, io.sentry.Z z) {
        try {
            if (this.i.get()) {
                sentryAndroidOptions.getLogger().c(Y2.INFO, "SendCachedEnvelopeIntegration, not trying to send after closing.", new Object[0]);
                return;
            }
            if (!this.h.getAndSet(true)) {
                io.sentry.N connectionStatusProvider = sentryAndroidOptions.getConnectionStatusProvider();
                this.d = connectionStatusProvider;
                connectionStatusProvider.v1(this);
                this.g = this.a.d(z, sentryAndroidOptions);
            }
            io.sentry.N n = this.d;
            if (n != null && n.w0() == N.a.DISCONNECTED) {
                sentryAndroidOptions.getLogger().c(Y2.INFO, "SendCachedEnvelopeIntegration, no connection.", new Object[0]);
                return;
            }
            io.sentry.transport.A aW = z.w();
            if (aW != null && aW.l(EnumC3136k.All)) {
                sentryAndroidOptions.getLogger().c(Y2.INFO, "SendCachedEnvelopeIntegration, rate limiting active.", new Object[0]);
                return;
            }
            P1 p1 = this.g;
            if (p1 == null) {
                sentryAndroidOptions.getLogger().c(Y2.ERROR, "SendCachedEnvelopeIntegration factory is null.", new Object[0]);
            } else {
                p1.a();
            }
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(Y2.ERROR, "Failed trying to send cached events.", th);
        }
    }

    private void e(final io.sentry.Z z, final SentryAndroidOptions sentryAndroidOptions) {
        try {
            InterfaceC3102d0 interfaceC3102d0A = this.j.a();
            try {
                Future futureSubmit = sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.K0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d(sentryAndroidOptions, z);
                    }
                });
                if (((Boolean) this.b.a()).booleanValue() && this.c.compareAndSet(false, true)) {
                    sentryAndroidOptions.getLogger().c(Y2.DEBUG, "Startup Crash marker exists, blocking flush.", new Object[0]);
                    try {
                        futureSubmit.get(sentryAndroidOptions.getStartupCrashFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
                    } catch (TimeoutException unused) {
                        sentryAndroidOptions.getLogger().c(Y2.DEBUG, "Synchronous send timed out, continuing in the background.", new Object[0]);
                    }
                }
                sentryAndroidOptions.getLogger().c(Y2.DEBUG, "SendCachedEnvelopeIntegration installed.", new Object[0]);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } finally {
            }
        } catch (RejectedExecutionException e) {
            sentryAndroidOptions.getLogger().b(Y2.ERROR, "Failed to call the executor. Cached events will not be sent. Did you call Sentry.close()?", e);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(Y2.ERROR, "Failed to call the executor. Cached events will not be sent", th);
        }
    }

    @Override // io.sentry.N.b
    public void b(N.a aVar) {
        SentryAndroidOptions sentryAndroidOptions;
        io.sentry.Z z = this.e;
        if (z == null || (sentryAndroidOptions = this.f) == null || aVar == N.a.DISCONNECTED) {
            return;
        }
        e(z, sentryAndroidOptions);
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        this.e = (io.sentry.Z) io.sentry.util.u.c(z, "Scopes are required");
        this.f = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        if (!this.a.e(c3155n3.getCacheDirPath(), c3155n3.getLogger())) {
            c3155n3.getLogger().c(Y2.ERROR, "No cache dir path is defined in options.", new Object[0]);
        } else {
            io.sentry.util.o.a("SendCachedEnvelope");
            e(z, this.f);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.i.set(true);
        io.sentry.N n = this.d;
        if (n != null) {
            n.L1(this);
        }
    }
}
