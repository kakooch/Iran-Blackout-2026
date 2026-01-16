package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.sentry.C3106e;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3157o0;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class ActivityBreadcrumbsIntegration implements InterfaceC3157o0, Closeable, Application.ActivityLifecycleCallbacks {
    private final Application a;
    private io.sentry.Z b;
    private boolean c;
    private final C3202a d = new C3202a();

    public ActivityBreadcrumbsIntegration(Application application) {
        this.a = (Application) io.sentry.util.u.c(application, "Application is required");
    }

    private void a(Activity activity, String str) {
        if (this.b == null) {
            return;
        }
        C3106e c3106e = new C3106e();
        c3106e.C("navigation");
        c3106e.z("state", str);
        c3106e.z("screen", b(activity));
        c3106e.y("ui.lifecycle");
        c3106e.A(Y2.INFO);
        io.sentry.I i = new io.sentry.I();
        i.k("android:activity", activity);
        this.b.b(c3106e, i);
    }

    private String b(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.b = (io.sentry.Z) io.sentry.util.u.c(z, "Scopes are required");
        this.c = sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs();
        ILogger logger = c3155n3.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "ActivityBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.c));
        if (this.c) {
            this.a.registerActivityLifecycleCallbacks(this);
            c3155n3.getLogger().c(y2, "ActivityBreadcrumbIntegration installed.", new Object[0]);
            io.sentry.util.o.a("ActivityBreadcrumbs");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c) {
            this.a.unregisterActivityLifecycleCallbacks(this);
            io.sentry.Z z = this.b;
            if (z != null) {
                z.e().getLogger().c(Y2.DEBUG, "ActivityBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            a(activity, "created");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            a(activity, "destroyed");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            a(activity, "paused");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            a(activity, "resumed");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            a(activity, "saveInstanceState");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            a(activity, "started");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            a(activity, "stopped");
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
}
