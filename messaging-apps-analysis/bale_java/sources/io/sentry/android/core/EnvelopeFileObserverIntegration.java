package io.sentry.android.core;

import io.sentry.C3143l1;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import java.io.Closeable;

/* loaded from: classes3.dex */
public abstract class EnvelopeFileObserverIntegration implements InterfaceC3157o0, Closeable {
    private FileObserverC3075s0 a;
    private ILogger b;
    private boolean c = false;
    protected final C3202a d = new C3202a();

    private static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration {
        private OutboxEnvelopeFileObserverIntegration() {
        }

        @Override // io.sentry.android.core.EnvelopeFileObserverIntegration
        protected String d(C3155n3 c3155n3) {
            return c3155n3.getOutboxPath();
        }
    }

    public static EnvelopeFileObserverIntegration b() {
        return new OutboxEnvelopeFileObserverIntegration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(io.sentry.Z z, C3155n3 c3155n3, String str) {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            if (!this.c) {
                g(z, c3155n3, str);
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

    private void g(io.sentry.Z z, C3155n3 c3155n3, String str) {
        FileObserverC3075s0 fileObserverC3075s0 = new FileObserverC3075s0(str, new C3143l1(z, c3155n3.getEnvelopeReader(), c3155n3.getSerializer(), c3155n3.getLogger(), c3155n3.getFlushTimeoutMillis(), c3155n3.getMaxQueueSize()), c3155n3.getLogger(), c3155n3.getFlushTimeoutMillis());
        this.a = fileObserverC3075s0;
        try {
            fileObserverC3075s0.startWatching();
            c3155n3.getLogger().c(Y2.DEBUG, "EnvelopeFileObserverIntegration installed.", new Object[0]);
            io.sentry.util.o.a("EnvelopeFileObserver");
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.ERROR, "Failed to initialize EnvelopeFileObserverIntegration.", th);
        }
    }

    @Override // io.sentry.InterfaceC3157o0
    public final void c(final io.sentry.Z z, final C3155n3 c3155n3) {
        io.sentry.util.u.c(z, "Scopes are required");
        io.sentry.util.u.c(c3155n3, "SentryOptions is required");
        this.b = c3155n3.getLogger();
        final String strD = d(c3155n3);
        if (strD == null) {
            this.b.c(Y2.WARNING, "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
            return;
        }
        this.b.c(Y2.DEBUG, "Registering EnvelopeFileObserverIntegration for path: %s", strD);
        try {
            c3155n3.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.t0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(z, c3155n3, strD);
                }
            });
        } catch (Throwable th) {
            this.b.b(Y2.DEBUG, "Failed to start EnvelopeFileObserverIntegration on executor thread.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            this.c = true;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            FileObserverC3075s0 fileObserverC3075s0 = this.a;
            if (fileObserverC3075s0 != null) {
                fileObserverC3075s0.stopWatching();
                ILogger iLogger = this.b;
                if (iLogger != null) {
                    iLogger.c(Y2.DEBUG, "EnvelopeFileObserverIntegration removed.", new Object[0]);
                }
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

    abstract String d(C3155n3 c3155n3);
}
