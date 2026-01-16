package io.sentry.android.core;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.AbstractC3141l;
import io.sentry.C3155n3;
import io.sentry.C3186s1;
import io.sentry.C3191t1;
import io.sentry.ILogger;
import io.sentry.InterfaceC3097c0;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3127i0;
import io.sentry.InterfaceC3132j0;
import io.sentry.N1;
import io.sentry.Y2;
import io.sentry.android.core.F;
import io.sentry.util.C3202a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class I implements InterfaceC3132j0 {
    private final Context a;
    private final ILogger b;
    private final String c;
    private final boolean d;
    private final int e;
    private final InterfaceC3097c0 f;
    private final Y g;
    private boolean h;
    private int i;
    private final io.sentry.android.core.internal.util.C j;
    private C3191t1 k;
    private F l;
    private long m;
    private long n;
    private Date o;
    private final C3202a p;

    public I(Context context, SentryAndroidOptions sentryAndroidOptions, Y y, io.sentry.android.core.internal.util.C c) {
        this(context, y, c, sentryAndroidOptions.getLogger(), sentryAndroidOptions.getProfilingTracesDirPath(), sentryAndroidOptions.isProfilingEnabled(), sentryAndroidOptions.getProfilingTracesHz(), sentryAndroidOptions.getExecutorService());
    }

    private void d() {
        if (this.h) {
            return;
        }
        this.h = true;
        if (!this.d) {
            this.b.c(Y2.INFO, "Profiling is disabled in options.", new Object[0]);
            return;
        }
        String str = this.c;
        if (str == null) {
            this.b.c(Y2.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            return;
        }
        int i = this.e;
        if (i <= 0) {
            this.b.c(Y2.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(i));
        } else {
            this.l = new F(str, ((int) TimeUnit.SECONDS.toMicros(1L)) / this.e, this.j, this.f, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List e() {
        return io.sentry.android.core.internal.util.l.a().c();
    }

    private boolean f() {
        F.c cVarJ;
        F f = this.l;
        if (f == null || (cVarJ = f.j()) == null) {
            return false;
        }
        this.m = cVarJ.a;
        this.n = cVarJ.b;
        this.o = cVarJ.c;
        return true;
    }

    private C3186s1 g(String str, String str2, String str3, boolean z, List list, C3155n3 c3155n3) {
        InterfaceC3102d0 interfaceC3102d0A = this.p.a();
        try {
            if (this.l == null) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return null;
            }
            if (this.g.d() < 22) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return null;
            }
            C3191t1 c3191t1 = this.k;
            if (c3191t1 != null && c3191t1.h().equals(str2)) {
                int i = this.i;
                if (i > 0) {
                    this.i = i - 1;
                }
                this.b.c(Y2.DEBUG, "Transaction %s (%s) finished.", str, str3);
                if (this.i != 0) {
                    C3191t1 c3191t12 = this.k;
                    if (c3191t12 != null) {
                        c3191t12.k(Long.valueOf(SystemClock.elapsedRealtimeNanos()), Long.valueOf(this.m), Long.valueOf(Process.getElapsedCpuTime()), Long.valueOf(this.n));
                    }
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                    }
                    return null;
                }
                F.b bVarG = this.l.g(false, list);
                if (bVarG == null) {
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                    }
                    return null;
                }
                long j = bVarG.a - this.m;
                ArrayList arrayList = new ArrayList(1);
                C3191t1 c3191t13 = this.k;
                if (c3191t13 != null) {
                    arrayList.add(c3191t13);
                }
                this.k = null;
                this.i = 0;
                Long lQ = c3155n3 instanceof SentryAndroidOptions ? C3072q0.i(this.a, (SentryAndroidOptions) c3155n3).q() : null;
                String string = lQ != null ? Long.toString(lQ.longValue()) : "0";
                String[] strArr = Build.SUPPORTED_ABIS;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C3191t1) it.next()).k(Long.valueOf(bVarG.a), Long.valueOf(this.m), Long.valueOf(bVarG.b), Long.valueOf(this.n));
                }
                C3186s1 c3186s1 = new C3186s1(bVarG.c, this.o, arrayList, str, str2, str3, Long.toString(j), this.g.d(), (strArr == null || strArr.length <= 0) ? "" : strArr[0], new Callable() { // from class: io.sentry.android.core.H
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return I.e();
                    }
                }, this.g.b(), this.g.c(), this.g.e(), this.g.f(), string, c3155n3.getProguardUuid(), c3155n3.getRelease(), c3155n3.getEnvironment(), (bVarG.e || z) ? "timeout" : "normal", bVarG.d);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return c3186s1;
            }
            this.b.c(Y2.INFO, "Transaction %s (%s) finished, but was not currently being profiled. Skipping", str, str3);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return null;
        } catch (Throwable th) {
            if (interfaceC3102d0A == null) {
                throw th;
            }
            try {
                interfaceC3102d0A.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // io.sentry.InterfaceC3132j0
    public void a(InterfaceC3127i0 interfaceC3127i0) {
        InterfaceC3102d0 interfaceC3102d0A = this.p.a();
        try {
            if (this.i > 0 && this.k == null) {
                this.k = new C3191t1(interfaceC3127i0, Long.valueOf(this.m), Long.valueOf(this.n));
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

    @Override // io.sentry.InterfaceC3132j0
    public C3186s1 b(InterfaceC3127i0 interfaceC3127i0, List list, C3155n3 c3155n3) {
        InterfaceC3102d0 interfaceC3102d0A = this.p.a();
        try {
            C3186s1 c3186s1G = g(interfaceC3127i0.getName(), interfaceC3127i0.b().toString(), interfaceC3127i0.v().n().toString(), false, list, c3155n3);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return c3186s1G;
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

    @Override // io.sentry.InterfaceC3132j0
    public void close() {
        C3191t1 c3191t1 = this.k;
        if (c3191t1 != null) {
            g(c3191t1.i(), this.k.h(), this.k.j(), true, null, N1.c().e());
        } else {
            int i = this.i;
            if (i != 0) {
                this.i = i - 1;
            }
        }
        F f = this.l;
        if (f != null) {
            f.f();
        }
    }

    @Override // io.sentry.InterfaceC3132j0
    public boolean isRunning() {
        return this.i != 0;
    }

    @Override // io.sentry.InterfaceC3132j0
    public void start() {
        InterfaceC3102d0 interfaceC3102d0A = this.p.a();
        try {
            if (this.g.d() < 22) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            d();
            int i = this.i + 1;
            this.i = i;
            if (i == 1 && f()) {
                this.b.c(Y2.DEBUG, "Profiler started.", new Object[0]);
            } else {
                this.i--;
                this.b.c(Y2.WARNING, "A profile is already running. This profile will be ignored.", new Object[0]);
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

    public I(Context context, Y y, io.sentry.android.core.internal.util.C c, ILogger iLogger, String str, boolean z, int i, InterfaceC3097c0 interfaceC3097c0) {
        this.h = false;
        this.i = 0;
        this.l = null;
        this.p = new C3202a();
        this.a = (Context) io.sentry.util.u.c(AbstractC3060k0.g(context), "The application context is required");
        this.b = (ILogger) io.sentry.util.u.c(iLogger, "ILogger is required");
        this.j = (io.sentry.android.core.internal.util.C) io.sentry.util.u.c(c, "SentryFrameMetricsCollector is required");
        this.g = (Y) io.sentry.util.u.c(y, "The BuildInfoProvider is required.");
        this.c = str;
        this.d = z;
        this.e = i;
        this.f = (InterfaceC3097c0) io.sentry.util.u.c(interfaceC3097c0, "The ISentryExecutorService is required.");
        this.o = AbstractC3141l.d();
    }
}
