package io.sentry.android.core;

import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class AppLifecycleIntegration implements InterfaceC3157o0, Closeable {
    private final C3202a a = new C3202a();
    volatile C3087y0 b;
    private SentryAndroidOptions c;

    private void a() {
        InterfaceC3102d0 interfaceC3102d0A = this.a.a();
        try {
            C3087y0 c3087y0 = this.b;
            this.b = null;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            if (c3087y0 != null) {
                X.j().p(c3087y0);
                SentryAndroidOptions sentryAndroidOptions = this.c;
                if (sentryAndroidOptions != null) {
                    sentryAndroidOptions.getLogger().c(Y2.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
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

    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        io.sentry.util.u.c(z, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.c = sentryAndroidOptions;
        ILogger logger = sentryAndroidOptions.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "enableSessionTracking enabled: %s", Boolean.valueOf(this.c.isEnableAutoSessionTracking()));
        this.c.getLogger().c(y2, "enableAppLifecycleBreadcrumbs enabled: %s", Boolean.valueOf(this.c.isEnableAppLifecycleBreadcrumbs()));
        if (this.c.isEnableAutoSessionTracking() || this.c.isEnableAppLifecycleBreadcrumbs()) {
            InterfaceC3102d0 interfaceC3102d0A = this.a.a();
            try {
                if (this.b != null) {
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                    }
                } else {
                    this.b = new C3087y0(z, this.c.getSessionTrackingIntervalMillis(), this.c.isEnableAutoSessionTracking(), this.c.isEnableAppLifecycleBreadcrumbs());
                    X.j().d(this.b);
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                    }
                    c3155n3.getLogger().c(y2, "AppLifecycleIntegration installed.", new Object[0]);
                    io.sentry.util.o.a("AppLifecycle");
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
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
        X.j().u();
    }
}
