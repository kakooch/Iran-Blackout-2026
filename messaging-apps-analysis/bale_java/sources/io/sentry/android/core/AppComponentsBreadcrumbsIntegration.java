package io.sentry.android.core;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.sentry.C3106e;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import io.sentry.protocol.C3170e;
import java.io.Closeable;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class AppComponentsBreadcrumbsIntegration implements InterfaceC3157o0, Closeable, ComponentCallbacks2 {
    private static final io.sentry.I e = new io.sentry.I();
    private final Context a;
    private io.sentry.Z b;
    private SentryAndroidOptions c;
    private final io.sentry.android.core.internal.util.m d = new io.sentry.android.core.internal.util.m(io.sentry.android.core.internal.util.g.b(), 60000, 0);

    public AppComponentsBreadcrumbsIntegration(Context context) {
        this.a = (Context) io.sentry.util.u.c(AbstractC3060k0.g(context), "Context is required");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void j(long j, Configuration configuration) {
        if (this.b != null) {
            C3170e.b bVarA = io.sentry.android.core.internal.util.n.a(this.a.getResources().getConfiguration().orientation);
            String lowerCase = bVarA != null ? bVarA.name().toLowerCase(Locale.ROOT) : StringUtils.UNDEFINED;
            C3106e c3106e = new C3106e(j);
            c3106e.C("navigation");
            c3106e.y("device.orientation");
            c3106e.z("position", lowerCase);
            c3106e.A(Y2.INFO);
            io.sentry.I i = new io.sentry.I();
            i.k("android:configuration", configuration);
            this.b.b(c3106e, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void k(long j, int i) {
        if (this.b != null) {
            C3106e c3106e = new C3106e(j);
            c3106e.C("system");
            c3106e.y("device.event");
            c3106e.B("Low memory");
            c3106e.z("action", "LOW_MEMORY");
            c3106e.z("level", Integer.valueOf(i));
            c3106e.A(Y2.WARNING);
            this.b.b(c3106e, e);
        }
    }

    private void g(Runnable runnable) {
        SentryAndroidOptions sentryAndroidOptions = this.c;
        if (sentryAndroidOptions != null) {
            try {
                sentryAndroidOptions.getExecutorService().submit(runnable);
            } catch (Throwable th) {
                this.c.getLogger().a(Y2.ERROR, th, "Failed to submit app components breadcrumb task", new Object[0]);
            }
        }
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        this.b = (io.sentry.Z) io.sentry.util.u.c(z, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.c = sentryAndroidOptions;
        ILogger logger = sentryAndroidOptions.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "AppComponentsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.c.isEnableAppComponentBreadcrumbs()));
        if (this.c.isEnableAppComponentBreadcrumbs()) {
            try {
                this.a.registerComponentCallbacks(this);
                c3155n3.getLogger().c(y2, "AppComponentsBreadcrumbsIntegration installed.", new Object[0]);
                io.sentry.util.o.a("AppComponentsBreadcrumbs");
            } catch (Throwable th) {
                this.c.setEnableAppComponentBreadcrumbs(false);
                c3155n3.getLogger().a(Y2.INFO, th, "ComponentCallbacks2 is not available.", new Object[0]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.a.unregisterComponentCallbacks(this);
        } catch (Throwable th) {
            SentryAndroidOptions sentryAndroidOptions = this.c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().a(Y2.DEBUG, th, "It was not possible to unregisterComponentCallbacks", new Object[0]);
            }
        }
        SentryAndroidOptions sentryAndroidOptions2 = this.c;
        if (sentryAndroidOptions2 != null) {
            sentryAndroidOptions2.getLogger().c(Y2.DEBUG, "AppComponentsBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(final Configuration configuration) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        g(new Runnable() { // from class: io.sentry.android.core.T
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(jCurrentTimeMillis, configuration);
            }
        });
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(final int i) {
        if (i >= 40 && !this.d.a()) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            g(new Runnable() { // from class: io.sentry.android.core.U
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(jCurrentTimeMillis, i);
                }
            });
        }
    }
}
