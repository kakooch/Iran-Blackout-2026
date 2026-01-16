package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.C3034a2;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3132j0;
import io.sentry.P2;
import io.sentry.U3;
import io.sentry.V3;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public final class SentryPerformanceProvider extends AbstractC3073r0 {
    private static final long f = SystemClock.uptimeMillis();
    private Application b;
    private final ILogger c;
    private final Y d;
    private final C3202a e = new C3202a();

    public SentryPerformanceProvider() {
        C3086y c3086y = new C3086y();
        this.c = c3086y;
        this.d = new Y(c3086y);
    }

    private void a(Context context, C3034a2 c3034a2, io.sentry.android.core.performance.h hVar) {
        if (!c3034a2.f()) {
            this.c.c(Y2.DEBUG, "App start profiling was not sampled. It will not start.", new Object[0]);
            return;
        }
        C3078u c3078u = new C3078u(this.d, new io.sentry.android.core.internal.util.C(context.getApplicationContext(), this.c, this.d), this.c, c3034a2.c(), c3034a2.d(), new P2());
        hVar.z(null);
        hVar.y(c3078u);
        this.c.c(Y2.DEBUG, "App start continuous profiling started.", new Object[0]);
        C3155n3 c3155n3Empty = C3155n3.empty();
        c3155n3Empty.setProfileSessionSampleRate(Double.valueOf(c3034a2.f() ? 1.0d : 0.0d));
        c3078u.j(c3034a2.a(), new U3(c3155n3Empty));
    }

    private void b(Context context, C3034a2 c3034a2, io.sentry.android.core.performance.h hVar) {
        V3 v3 = new V3(Boolean.valueOf(c3034a2.l()), c3034a2.e(), Boolean.valueOf(c3034a2.i()), c3034a2.b());
        hVar.A(v3);
        if (!v3.b().booleanValue() || !v3.e().booleanValue()) {
            this.c.c(Y2.DEBUG, "App start profiling was not sampled. It will not start.", new Object[0]);
            return;
        }
        I i = new I(context, this.d, new io.sentry.android.core.internal.util.C(context, this.c, this.d), this.c, c3034a2.c(), c3034a2.j(), c3034a2.d(), new P2());
        hVar.y(null);
        hVar.z(i);
        this.c.c(Y2.DEBUG, "App start profiling started.", new Object[0]);
        i.start();
    }

    private void c(io.sentry.android.core.performance.h hVar) {
        Context context = getContext();
        if (context == null) {
            this.c.c(Y2.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return;
        }
        File file = new File(D.d(context), "app_start_profiling_config");
        if (file.exists() && file.canRead()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    C3034a2 c3034a2 = (C3034a2) new io.sentry.B0(C3155n3.empty()).c(bufferedReader, C3034a2.class);
                    if (c3034a2 == null) {
                        this.c.c(Y2.WARNING, "Unable to deserialize the SentryAppStartProfilingOptions. App start profiling will not start.", new Object[0]);
                        bufferedReader.close();
                        return;
                    }
                    if (c3034a2.g() && c3034a2.k()) {
                        a(context, c3034a2, hVar);
                        bufferedReader.close();
                    } else if (!c3034a2.j()) {
                        this.c.c(Y2.INFO, "Profiling is not enabled. App start profiling will not start.", new Object[0]);
                        bufferedReader.close();
                    } else {
                        if (c3034a2.h()) {
                            b(context, c3034a2, hVar);
                        }
                        bufferedReader.close();
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                this.c.b(Y2.ERROR, "App start profiling config file not found. ", e);
            } catch (Throwable th3) {
                this.c.b(Y2.ERROR, "Error reading app start profiling config file. ", th3);
            }
        }
    }

    private void d(Context context, io.sentry.android.core.performance.h hVar) {
        hVar.q().z(f);
        if (this.d.d() >= 24) {
            hVar.k().z(Process.getStartUptimeMillis());
        }
        if (context instanceof Application) {
            this.b = (Application) context;
        }
        Application application = this.b;
        if (application == null) {
            return;
        }
        hVar.x(application);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (SentryPerformanceProvider.class.getName().equals(providerInfo.authority)) {
            throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        io.sentry.android.core.performance.h hVarP = io.sentry.android.core.performance.h.p();
        d(getContext(), hVarP);
        c(hVarP);
        return true;
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        InterfaceC3102d0 interfaceC3102d0A = io.sentry.android.core.performance.h.q.a();
        try {
            InterfaceC3132j0 interfaceC3132j0I = io.sentry.android.core.performance.h.p().i();
            if (interfaceC3132j0I != null) {
                interfaceC3132j0I.close();
            }
            io.sentry.O oH = io.sentry.android.core.performance.h.p().h();
            if (oH != null) {
                oH.i(true);
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
}
