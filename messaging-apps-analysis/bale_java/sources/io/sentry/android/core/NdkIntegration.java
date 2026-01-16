package io.sentry.android.core;

import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class NdkIntegration implements InterfaceC3157o0, Closeable {
    private final Class a;
    private SentryAndroidOptions b;

    public NdkIntegration(Class cls) {
        this.a = cls;
    }

    private void a(SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setEnableNdk(false);
        sentryAndroidOptions.setEnableScopeSync(false);
    }

    @Override // io.sentry.InterfaceC3157o0
    public final void c(io.sentry.Z z, C3155n3 c3155n3) {
        io.sentry.util.u.c(z, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.b = sentryAndroidOptions;
        boolean zIsEnableNdk = sentryAndroidOptions.isEnableNdk();
        ILogger logger = this.b.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "NdkIntegration enabled: %s", Boolean.valueOf(zIsEnableNdk));
        if (!zIsEnableNdk || this.a == null) {
            a(this.b);
            return;
        }
        if (this.b.getCacheDirPath() == null) {
            this.b.getLogger().c(Y2.ERROR, "No cache dir path is defined in options.", new Object[0]);
            a(this.b);
            return;
        }
        try {
            this.a.getMethod("init", SentryAndroidOptions.class).invoke(null, this.b);
            this.b.getLogger().c(y2, "NdkIntegration installed.", new Object[0]);
            io.sentry.util.o.a("Ndk");
        } catch (NoSuchMethodException e) {
            a(this.b);
            this.b.getLogger().b(Y2.ERROR, "Failed to invoke the SentryNdk.init method.", e);
        } catch (Throwable th) {
            a(this.b);
            this.b.getLogger().b(Y2.ERROR, "Failed to initialize SentryNdk.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SentryAndroidOptions sentryAndroidOptions = this.b;
        if (sentryAndroidOptions == null || !sentryAndroidOptions.isEnableNdk()) {
            return;
        }
        Class cls = this.a;
        try {
            if (cls != null) {
                try {
                    try {
                        cls.getMethod("close", null).invoke(null, null);
                        this.b.getLogger().c(Y2.DEBUG, "NdkIntegration removed.", new Object[0]);
                    } catch (NoSuchMethodException e) {
                        this.b.getLogger().b(Y2.ERROR, "Failed to invoke the SentryNdk.close method.", e);
                    }
                } finally {
                    a(this.b);
                }
                a(this.b);
            }
        } catch (Throwable th) {
            a(this.b);
        }
    }
}
