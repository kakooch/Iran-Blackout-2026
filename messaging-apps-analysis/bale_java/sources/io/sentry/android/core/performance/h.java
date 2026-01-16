package io.sentry.android.core.performance;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3132j0;
import io.sentry.L0;
import io.sentry.O;
import io.sentry.V3;
import io.sentry.android.core.AbstractC3060k0;
import io.sentry.android.core.C3062l0;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.Y;
import io.sentry.android.core.internal.util.q;
import io.sentry.util.C3202a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class h extends io.sentry.android.core.performance.a {
    private static volatile h p;
    private static long o = SystemClock.uptimeMillis();
    public static final C3202a q = new C3202a();
    private a a = a.UNKNOWN;
    private InterfaceC3132j0 h = null;
    private O i = null;
    private V3 j = null;
    private boolean k = false;
    private boolean l = true;
    private final AtomicInteger m = new AtomicInteger();
    private final AtomicBoolean n = new AtomicBoolean(false);
    private final i c = new i();
    private final i d = new i();
    private final i e = new i();
    private final Map f = new HashMap();
    private final List g = new ArrayList();
    private boolean b = AbstractC3060k0.s();

    public enum a {
        UNKNOWN,
        COLD,
        WARM
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void u() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.performance.g
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r();
            }
        });
    }

    public static h p() {
        if (p == null) {
            InterfaceC3102d0 interfaceC3102d0A = q.a();
            try {
                if (p == null) {
                    p = new h();
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
        return p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        if (this.m.get() == 0) {
            this.b = false;
            InterfaceC3132j0 interfaceC3132j0 = this.h;
            if (interfaceC3132j0 != null && interfaceC3132j0.isRunning()) {
                this.h.close();
                this.h = null;
            }
            O o2 = this.i;
            if (o2 == null || !o2.isRunning()) {
                return;
            }
            this.i.i(true);
            this.i = null;
        }
    }

    public void A(V3 v3) {
        this.j = v3;
    }

    public boolean B() {
        return this.l && this.b;
    }

    public void e(c cVar) {
        this.g.add(cVar);
    }

    public i g() {
        i iVar = new i();
        iVar.A("Process Initialization", this.c.r(), this.c.t(), o);
        return iVar;
    }

    public O h() {
        return this.i;
    }

    public InterfaceC3132j0 i() {
        return this.h;
    }

    public V3 j() {
        return this.j;
    }

    public i k() {
        return this.c;
    }

    public i l(SentryAndroidOptions sentryAndroidOptions) {
        if (this.a != a.UNKNOWN && this.b) {
            if (sentryAndroidOptions.isEnablePerformanceV2()) {
                i iVarK = k();
                if (iVarK.w() && iVarK.i() <= TimeUnit.MINUTES.toMillis(1L)) {
                    return iVarK;
                }
            }
            i iVarQ = q();
            if (iVarQ.w() && iVarQ.i() <= TimeUnit.MINUTES.toMillis(1L)) {
                return iVarQ;
            }
        }
        return new i();
    }

    public a m() {
        return this.a;
    }

    public i n() {
        return this.e;
    }

    public List o() {
        ArrayList arrayList = new ArrayList(this.f.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        C3062l0.c().d(activity);
        if (this.m.incrementAndGet() == 1 && !this.n.get()) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jT = jUptimeMillis - this.c.t();
            if (!this.b || jT > TimeUnit.MINUTES.toMillis(1L)) {
                this.a = a.WARM;
                this.l = true;
                this.c.y();
                this.c.B();
                this.c.z(jUptimeMillis);
                o = jUptimeMillis;
                this.f.clear();
                this.e.y();
            } else {
                this.a = bundle == null ? a.COLD : a.WARM;
            }
        }
        this.b = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        C3062l0.c().a(activity);
        if (this.m.decrementAndGet() != 0 || activity.isChangingConfigurations()) {
            return;
        }
        this.b = false;
        this.l = true;
        this.n.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        C3062l0.c().a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        C3062l0.c().d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        C3062l0.c().d(activity);
        if (this.n.get()) {
            return;
        }
        if (activity.getWindow() != null) {
            q.f(activity, new Runnable() { // from class: io.sentry.android.core.performance.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.s();
                }
            }, new Y(L0.e()));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.performance.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.t();
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        C3062l0.c().a(activity);
    }

    public i q() {
        return this.d;
    }

    public void v() {
        this.l = false;
        this.f.clear();
        this.g.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public synchronized void t() {
        if (!this.n.getAndSet(true)) {
            h hVarP = p();
            hVarP.q().C();
            hVarP.k().C();
        }
    }

    public void x(Application application) {
        if (this.k) {
            return;
        }
        boolean z = true;
        this.k = true;
        if (!this.b && !AbstractC3060k0.s()) {
            z = false;
        }
        this.b = z;
        application.registerActivityLifecycleCallbacks(p);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.performance.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.u();
            }
        });
    }

    public void y(O o2) {
        this.i = o2;
    }

    public void z(InterfaceC3132j0 interfaceC3132j0) {
        this.h = interfaceC3132j0;
    }
}
