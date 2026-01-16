package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.sentry.AbstractC3124h2;
import io.sentry.B1;
import io.sentry.C3098c1;
import io.sentry.C3115f3;
import io.sentry.C3155n3;
import io.sentry.D1;
import io.sentry.E0;
import io.sentry.EnumC3152n0;
import io.sentry.H;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3117g0;
import io.sentry.InterfaceC3127i0;
import io.sentry.InterfaceC3157o0;
import io.sentry.N3;
import io.sentry.O3;
import io.sentry.V3;
import io.sentry.W3;
import io.sentry.X3;
import io.sentry.Y2;
import io.sentry.Y3;
import io.sentry.android.core.performance.h;
import io.sentry.util.C3202a;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ActivityLifecycleIntegration implements InterfaceC3157o0, Closeable, Application.ActivityLifecycleCallbacks {
    private final Application a;
    private final Y b;
    private io.sentry.Z c;
    private SentryAndroidOptions d;
    private boolean g;
    private InterfaceC3117g0 j;
    private final C3050h q;
    private boolean e = false;
    private boolean f = false;
    private boolean h = false;
    private io.sentry.H i = null;
    private final WeakHashMap k = new WeakHashMap();
    private final WeakHashMap l = new WeakHashMap();
    private final WeakHashMap m = new WeakHashMap();
    private AbstractC3124h2 n = new C3115f3(new Date(0), 0);
    private Future o = null;
    private final WeakHashMap p = new WeakHashMap();
    private final C3202a r = new C3202a();
    private boolean s = false;
    private final C3202a t = new C3202a();

    public ActivityLifecycleIntegration(Application application, Y y, C3050h c3050h) {
        this.a = (Application) io.sentry.util.u.c(application, "Application is required");
        this.b = (Y) io.sentry.util.u.c(y, "BuildInfoProvider is required");
        this.q = (C3050h) io.sentry.util.u.c(c3050h, "ActivityFramesTracker is required");
        if (y.d() >= 29) {
            this.g = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void x0(InterfaceC3117g0 interfaceC3117g0, InterfaceC3117g0 interfaceC3117g02) {
        io.sentry.android.core.performance.h hVarP = io.sentry.android.core.performance.h.p();
        io.sentry.android.core.performance.i iVarK = hVarP.k();
        io.sentry.android.core.performance.i iVarQ = hVarP.q();
        if (iVarK.w() && iVarK.v()) {
            iVarK.C();
        }
        if (iVarQ.w() && iVarQ.v()) {
            iVarQ.C();
        }
        u();
        InterfaceC3102d0 interfaceC3102d0A = this.t.a();
        try {
            SentryAndroidOptions sentryAndroidOptions = this.d;
            if (sentryAndroidOptions == null || interfaceC3117g02 == null) {
                z(interfaceC3117g02);
                if (this.s) {
                    z(interfaceC3117g0);
                }
            } else {
                AbstractC3124h2 abstractC3124h2A = sentryAndroidOptions.getDateProvider().a();
                long millis = TimeUnit.NANOSECONDS.toMillis(abstractC3124h2A.h(interfaceC3117g02.y()));
                Long lValueOf = Long.valueOf(millis);
                E0.a aVar = E0.a.MILLISECOND;
                interfaceC3117g02.t("time_to_initial_display", lValueOf, aVar);
                if (interfaceC3117g0 != null && this.s) {
                    this.s = false;
                    interfaceC3117g02.t("time_to_full_display", Long.valueOf(millis), aVar);
                    interfaceC3117g0.t("time_to_full_display", Long.valueOf(millis), aVar);
                    G(interfaceC3117g0, abstractC3124h2A);
                }
                G(interfaceC3117g02, abstractC3124h2A);
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

    private void D0(N3 n3) {
        n3.g("auto.ui.activity");
    }

    private void F0(Activity activity) {
        Boolean boolValueOf;
        AbstractC3124h2 abstractC3124h2;
        AbstractC3124h2 abstractC3124h22;
        final WeakReference weakReference = new WeakReference(activity);
        if (this.c == null || d0(activity)) {
            return;
        }
        if (!this.e) {
            this.p.put(activity, C3098c1.e());
            if (this.d.isEnableAutoTraceIdGeneration()) {
                io.sentry.util.F.k(this.c);
                return;
            }
            return;
        }
        I0();
        final String strM = M(activity);
        io.sentry.android.core.performance.i iVarL = io.sentry.android.core.performance.h.p().l(this.d);
        V3 v3 = null;
        if (AbstractC3060k0.s() && iVarL.w()) {
            AbstractC3124h2 abstractC3124h2Q = iVarL.q();
            boolValueOf = Boolean.valueOf(io.sentry.android.core.performance.h.p().m() == h.a.COLD);
            abstractC3124h2 = abstractC3124h2Q;
        } else {
            boolValueOf = null;
            abstractC3124h2 = null;
        }
        Y3 y3 = new Y3();
        long deadlineTimeout = this.d.getDeadlineTimeout();
        y3.s(deadlineTimeout <= 0 ? null : Long.valueOf(deadlineTimeout));
        if (this.d.isEnableActivityLifecycleTracingAutoFinish()) {
            y3.t(this.d.getIdleTimeout());
            y3.i(true);
        }
        y3.v(true);
        y3.u(new X3() { // from class: io.sentry.android.core.o
            @Override // io.sentry.X3
            public final void a(InterfaceC3127i0 interfaceC3127i0) {
                this.a.z0(weakReference, strM, interfaceC3127i0);
            }
        });
        if (this.h || abstractC3124h2 == null || boolValueOf == null) {
            abstractC3124h22 = this.n;
        } else {
            V3 v3J = io.sentry.android.core.performance.h.p().j();
            io.sentry.android.core.performance.h.p().A(null);
            v3 = v3J;
            abstractC3124h22 = abstractC3124h2;
        }
        y3.h(abstractC3124h22);
        y3.r(v3 != null);
        D0(y3);
        final InterfaceC3127i0 interfaceC3127i0K = this.c.K(new W3(strM, io.sentry.protocol.F.COMPONENT, "ui.load", v3), y3);
        N3 n3 = new N3();
        D0(n3);
        if (!this.h && abstractC3124h2 != null && boolValueOf != null) {
            this.j = interfaceC3127i0K.u(S(boolValueOf.booleanValue()), P(boolValueOf.booleanValue()), abstractC3124h2, EnumC3152n0.SENTRY, n3);
            u();
        }
        String strX = X(strM);
        EnumC3152n0 enumC3152n0 = EnumC3152n0.SENTRY;
        final InterfaceC3117g0 interfaceC3117g0U = interfaceC3127i0K.u("ui.load.initial_display", strX, abstractC3124h22, enumC3152n0, n3);
        this.k.put(activity, interfaceC3117g0U);
        if (this.f && this.i != null && this.d != null) {
            final InterfaceC3117g0 interfaceC3117g0U2 = interfaceC3127i0K.u("ui.load.full_display", U(strM), abstractC3124h22, enumC3152n0, n3);
            try {
                this.l.put(activity, interfaceC3117g0U2);
                this.o = this.d.getExecutorService().c(new Runnable() { // from class: io.sentry.android.core.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.A0(interfaceC3117g0U2, interfaceC3117g0U);
                    }
                }, 25000L);
            } catch (RejectedExecutionException e) {
                this.d.getLogger().b(Y2.ERROR, "Failed to call the executor. Time to full display span will not be finished automatically. Did you call Sentry.close()?", e);
            }
        }
        this.c.z(new D1() { // from class: io.sentry.android.core.q
            @Override // io.sentry.D1
            public final void a(io.sentry.X x) {
                this.a.B0(interfaceC3127i0K, x);
            }
        });
        this.p.put(activity, interfaceC3127i0K);
    }

    private void G(InterfaceC3117g0 interfaceC3117g0, AbstractC3124h2 abstractC3124h2) {
        H(interfaceC3117g0, abstractC3124h2, null);
    }

    private void H(InterfaceC3117g0 interfaceC3117g0, AbstractC3124h2 abstractC3124h2, O3 o3) {
        if (interfaceC3117g0 == null || interfaceC3117g0.k()) {
            return;
        }
        if (o3 == null) {
            o3 = interfaceC3117g0.j() != null ? interfaceC3117g0.j() : O3.OK;
        }
        interfaceC3117g0.x(o3, abstractC3124h2);
    }

    private void I0() {
        for (Map.Entry entry : this.p.entrySet()) {
            K((InterfaceC3127i0) entry.getValue(), (InterfaceC3117g0) this.k.get(entry.getKey()), (InterfaceC3117g0) this.l.get(entry.getKey()));
        }
    }

    private void J(InterfaceC3117g0 interfaceC3117g0, O3 o3) {
        if (interfaceC3117g0 == null || interfaceC3117g0.k()) {
            return;
        }
        interfaceC3117g0.r(o3);
    }

    private void J0(Activity activity, boolean z) {
        if (this.e && z) {
            K((InterfaceC3127i0) this.p.get(activity), null, null);
        }
    }

    private void K(final InterfaceC3127i0 interfaceC3127i0, InterfaceC3117g0 interfaceC3117g0, InterfaceC3117g0 interfaceC3117g02) {
        if (interfaceC3127i0 == null || interfaceC3127i0.k()) {
            return;
        }
        J(interfaceC3117g0, O3.DEADLINE_EXCEEDED);
        A0(interfaceC3117g02, interfaceC3117g0);
        p();
        O3 o3J = interfaceC3127i0.j();
        if (o3J == null) {
            o3J = O3.OK;
        }
        interfaceC3127i0.r(o3J);
        io.sentry.Z z = this.c;
        if (z != null) {
            z.z(new D1() { // from class: io.sentry.android.core.m
                @Override // io.sentry.D1
                public final void a(io.sentry.X x) {
                    this.a.k0(interfaceC3127i0, x);
                }
            });
        }
    }

    private String M(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private String P(boolean z) {
        return z ? "Cold Start" : "Warm Start";
    }

    private String S(boolean z) {
        return z ? "app.start.cold" : "app.start.warm";
    }

    private String T(InterfaceC3117g0 interfaceC3117g0) {
        String description = interfaceC3117g0.getDescription();
        if (description != null && description.endsWith(" - Deadline Exceeded")) {
            return description;
        }
        return interfaceC3117g0.getDescription() + " - Deadline Exceeded";
    }

    private String U(String str) {
        return str + " full display";
    }

    private String X(String str) {
        return str + " initial display";
    }

    private boolean Z(SentryAndroidOptions sentryAndroidOptions) {
        return sentryAndroidOptions.isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
    }

    private boolean d0(Activity activity) {
        return this.p.containsKey(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(io.sentry.X x, InterfaceC3127i0 interfaceC3127i0, InterfaceC3127i0 interfaceC3127i02) {
        if (interfaceC3127i02 == null) {
            x.t(interfaceC3127i0);
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(Y2.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", interfaceC3127i0.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(InterfaceC3127i0 interfaceC3127i0, io.sentry.X x, InterfaceC3127i0 interfaceC3127i02) {
        if (interfaceC3127i02 == interfaceC3127i0) {
            x.w();
        }
    }

    private void p() {
        Future future = this.o;
        if (future != null) {
            future.cancel(false);
            this.o = null;
        }
    }

    private void q() {
        this.h = false;
        this.n = new C3115f3(new Date(0L), 0L);
        this.m.clear();
    }

    private void u() {
        AbstractC3124h2 abstractC3124h2J = io.sentry.android.core.performance.h.p().l(this.d).j();
        if (!this.e || abstractC3124h2J == null) {
            return;
        }
        G(this.j, abstractC3124h2J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void A0(InterfaceC3117g0 interfaceC3117g0, InterfaceC3117g0 interfaceC3117g02) {
        if (interfaceC3117g0 == null || interfaceC3117g0.k()) {
            return;
        }
        interfaceC3117g0.n(T(interfaceC3117g0));
        AbstractC3124h2 abstractC3124h2W = interfaceC3117g02 != null ? interfaceC3117g02.w() : null;
        if (abstractC3124h2W == null) {
            abstractC3124h2W = interfaceC3117g0.y();
        }
        H(interfaceC3117g0, abstractC3124h2W, O3.DEADLINE_EXCEEDED);
    }

    private void z(InterfaceC3117g0 interfaceC3117g0) {
        if (interfaceC3117g0 == null || interfaceC3117g0.k()) {
            return;
        }
        interfaceC3117g0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(WeakReference weakReference, String str, InterfaceC3127i0 interfaceC3127i0) {
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            this.q.n(activity, interfaceC3127i0.b());
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(Y2.WARNING, "Unable to track activity frames as the Activity %s has been destroyed.", str);
        }
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(io.sentry.Z z, C3155n3 c3155n3) {
        this.d = (SentryAndroidOptions) io.sentry.util.u.c(c3155n3 instanceof SentryAndroidOptions ? (SentryAndroidOptions) c3155n3 : null, "SentryAndroidOptions is required");
        this.c = (io.sentry.Z) io.sentry.util.u.c(z, "Scopes are required");
        this.e = Z(this.d);
        this.i = this.d.getFullyDisplayedReporter();
        this.f = this.d.isEnableTimeToFullDisplayTracing();
        this.a.registerActivityLifecycleCallbacks(this);
        this.d.getLogger().c(Y2.DEBUG, "ActivityLifecycleIntegration installed.", new Object[0]);
        io.sentry.util.o.a("ActivityLifecycle");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(Y2.DEBUG, "ActivityLifecycleIntegration removed.", new Object[0]);
        }
        this.q.p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void B0(final io.sentry.X x, final InterfaceC3127i0 interfaceC3127i0) {
        x.F(new B1.c() { // from class: io.sentry.android.core.r
            @Override // io.sentry.B1.c
            public final void a(InterfaceC3127i0 interfaceC3127i02) {
                this.a.e0(x, interfaceC3127i0, interfaceC3127i02);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        io.sentry.H h;
        SentryAndroidOptions sentryAndroidOptions;
        if (!this.g) {
            onActivityPreCreated(activity, bundle);
        }
        InterfaceC3102d0 interfaceC3102d0A = this.r.a();
        try {
            if (this.c != null && (sentryAndroidOptions = this.d) != null && sentryAndroidOptions.isEnableScreenTracking()) {
                final String strA = io.sentry.android.core.internal.util.j.a(activity);
                this.c.z(new D1() { // from class: io.sentry.android.core.i
                    @Override // io.sentry.D1
                    public final void a(io.sentry.X x) {
                        x.A(strA);
                    }
                });
            }
            F0(activity);
            final InterfaceC3117g0 interfaceC3117g0 = (InterfaceC3117g0) this.k.get(activity);
            final InterfaceC3117g0 interfaceC3117g02 = (InterfaceC3117g0) this.l.get(activity);
            this.h = true;
            if (this.e && interfaceC3117g0 != null && interfaceC3117g02 != null && (h = this.i) != null) {
                h.b(new H.a() { // from class: io.sentry.android.core.j
                });
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.r.a();
        try {
            io.sentry.android.core.performance.b bVar = (io.sentry.android.core.performance.b) this.m.remove(activity);
            if (bVar != null) {
                bVar.a();
            }
            if (this.e) {
                J(this.j, O3.CANCELLED);
                InterfaceC3117g0 interfaceC3117g0 = (InterfaceC3117g0) this.k.get(activity);
                InterfaceC3117g0 interfaceC3117g02 = (InterfaceC3117g0) this.l.get(activity);
                J(interfaceC3117g0, O3.DEADLINE_EXCEEDED);
                A0(interfaceC3117g02, interfaceC3117g0);
                p();
                J0(activity, true);
                this.j = null;
                this.k.remove(activity);
                this.l.remove(activity);
            }
            this.p.remove(activity);
            if (this.p.isEmpty() && !activity.isChangingConfigurations()) {
                q();
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.r.a();
        try {
            if (!this.g) {
                onActivityPrePaused(activity);
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        io.sentry.android.core.performance.b bVar = (io.sentry.android.core.performance.b) this.m.get(activity);
        if (bVar != null) {
            InterfaceC3117g0 interfaceC3117g0 = this.j;
            if (interfaceC3117g0 == null) {
                interfaceC3117g0 = (InterfaceC3117g0) this.p.get(activity);
            }
            bVar.b(interfaceC3117g0);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        io.sentry.android.core.performance.b bVar = (io.sentry.android.core.performance.b) this.m.get(activity);
        if (bVar != null) {
            InterfaceC3117g0 interfaceC3117g0 = this.j;
            if (interfaceC3117g0 == null) {
                interfaceC3117g0 = (InterfaceC3117g0) this.p.get(activity);
            }
            bVar.c(interfaceC3117g0);
            bVar.e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        io.sentry.android.core.performance.b bVar = new io.sentry.android.core.performance.b(activity.getClass().getName());
        this.m.put(activity, bVar);
        if (this.h) {
            return;
        }
        io.sentry.Z z = this.c;
        AbstractC3124h2 abstractC3124h2A = z != null ? z.e().getDateProvider().a() : AbstractC3082w.a();
        this.n = abstractC3124h2A;
        bVar.g(abstractC3124h2A);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        this.h = true;
        io.sentry.Z z = this.c;
        this.n = z != null ? z.e().getDateProvider().a() : AbstractC3082w.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(Activity activity) {
        io.sentry.android.core.performance.b bVar = (io.sentry.android.core.performance.b) this.m.get(activity);
        if (bVar != null) {
            SentryAndroidOptions sentryAndroidOptions = this.d;
            bVar.h(sentryAndroidOptions != null ? sentryAndroidOptions.getDateProvider().a() : AbstractC3082w.a());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.r.a();
        try {
            if (!this.g) {
                onActivityPostStarted(activity);
            }
            if (this.e) {
                final InterfaceC3117g0 interfaceC3117g0 = (InterfaceC3117g0) this.k.get(activity);
                final InterfaceC3117g0 interfaceC3117g02 = (InterfaceC3117g0) this.l.get(activity);
                if (activity.getWindow() != null) {
                    io.sentry.android.core.internal.util.q.f(activity, new Runnable() { // from class: io.sentry.android.core.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.s0(interfaceC3117g02, interfaceC3117g0);
                        }
                    }, this.b);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.x0(interfaceC3117g02, interfaceC3117g0);
                        }
                    });
                }
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.r.a();
        try {
            if (!this.g) {
                onActivityPostCreated(activity, null);
                onActivityPreStarted(activity);
            }
            if (this.e) {
                this.q.e(activity);
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void k0(final io.sentry.X x, final InterfaceC3127i0 interfaceC3127i0) {
        x.F(new B1.c() { // from class: io.sentry.android.core.n
            @Override // io.sentry.B1.c
            public final void a(InterfaceC3127i0 interfaceC3127i02) {
                ActivityLifecycleIntegration.f0(interfaceC3127i0, x, interfaceC3127i02);
            }
        });
    }
}
