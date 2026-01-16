package io.sentry;

import java.io.Closeable;

/* loaded from: classes3.dex */
public final class ShutdownHookIntegration implements InterfaceC3157o0, Closeable {
    private final Runtime a;
    private Thread b;

    public ShutdownHookIntegration(Runtime runtime) {
        this.a = (Runtime) io.sentry.util.u.c(runtime, "Runtime is required");
    }

    private void e(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalStateException e) {
            String message = e.getMessage();
            if (message == null || !(message.equals("Shutdown in progress") || message.equals("VM already shutting down"))) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.a.removeShutdownHook(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Z z, C3155n3 c3155n3) {
        z.r(c3155n3.getFlushTimeoutMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(C3155n3 c3155n3) {
        this.a.addShutdownHook(this.b);
        c3155n3.getLogger().c(Y2.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
        io.sentry.util.o.a("ShutdownHook");
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(final Z z, final C3155n3 c3155n3) {
        io.sentry.util.u.c(z, "Scopes are required");
        io.sentry.util.u.c(c3155n3, "SentryOptions is required");
        if (!c3155n3.isEnableShutdownHook()) {
            c3155n3.getLogger().c(Y2.INFO, "enableShutdownHook is disabled.", new Object[0]);
        } else {
            this.b = new Thread(new Runnable() { // from class: io.sentry.E3
                @Override // java.lang.Runnable
                public final void run() {
                    ShutdownHookIntegration.j(z, c3155n3);
                }
            }, "sentry-shutdownhook");
            e(new Runnable() { // from class: io.sentry.F3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(c3155n3);
                }
            });
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.b != null) {
            e(new Runnable() { // from class: io.sentry.D3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g();
                }
            });
        }
    }

    public ShutdownHookIntegration() {
        this(Runtime.getRuntime());
    }
}
