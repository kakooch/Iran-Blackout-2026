package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import androidx.lifecycle.j;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import ir.nasim.InterfaceC18633oz3;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class UserInteractionIntegration implements InterfaceC3157o0, Closeable, Application.ActivityLifecycleCallbacks {
    private final Application a;
    private io.sentry.Z b;
    private SentryAndroidOptions c;
    private final boolean d;
    private final boolean e;

    public UserInteractionIntegration(Application application, io.sentry.util.r rVar) {
        this.a = (Application) io.sentry.util.u.c(application, "Application is required");
        this.d = rVar.b("androidx.core.view.GestureDetectorCompat", this.c);
        this.e = rVar.b("androidx.lifecycle.Lifecycle", this.c);
    }

    private void a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(Y2.INFO, "Window was null in startTracking", new Object[0]);
                return;
            }
            return;
        }
        if (this.b == null || this.c == null) {
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback == null) {
            callback = new io.sentry.android.core.internal.gestures.b();
        }
        if (callback instanceof io.sentry.android.core.internal.gestures.h) {
            return;
        }
        window.setCallback(new io.sentry.android.core.internal.gestures.h(callback, activity, new io.sentry.android.core.internal.gestures.g(activity, this.b, this.c), this.c));
    }

    private void b(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.c;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(Y2.INFO, "Window was null in stopTracking", new Object[0]);
                return;
            }
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof io.sentry.android.core.internal.gestures.h) {
            io.sentry.android.core.internal.gestures.h hVar = (io.sentry.android.core.internal.gestures.h) callback;
            hVar.c();
            if (hVar.a() instanceof io.sentry.android.core.internal.gestures.b) {
                window.setCallback(null);
            } else {
                window.setCallback(hVar.a());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        this.c = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.b = (io.sentry.Z) io.sentry.util.u.c(z, "Scopes are required");
        boolean z2 = this.c.isEnableUserInteractionBreadcrumbs() || this.c.isEnableUserInteractionTracing();
        ILogger logger = this.c.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "UserInteractionIntegration enabled: %s", Boolean.valueOf(z2));
        if (z2) {
            if (!this.d) {
                c3155n3.getLogger().c(Y2.INFO, "androidx.core is not available, UserInteractionIntegration won't be installed", new Object[0]);
                return;
            }
            this.a.registerActivityLifecycleCallbacks(this);
            this.c.getLogger().c(y2, "UserInteractionIntegration installed.", new Object[0]);
            io.sentry.util.o.a("UserInteraction");
            if (this.e) {
                Activity activityB = C3062l0.c().b();
                if ((activityB instanceof InterfaceC18633oz3) && ((InterfaceC18633oz3) activityB).getLifecycle().b() == j.b.RESUMED) {
                    a(activityB);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.c;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(Y2.DEBUG, "UserInteractionIntegration removed.", new Object[0]);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
