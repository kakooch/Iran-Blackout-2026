package io.sentry.android.core;

import android.app.Activity;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.protocol.C3174i;
import io.sentry.util.C3202a;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.android.core.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3050h {
    private FrameMetricsAggregator a;
    private final SentryAndroidOptions b;
    private final Map c;
    private final Map d;
    private final C3089z0 e;
    protected C3202a f;

    /* renamed from: io.sentry.android.core.h$b */
    private static final class b {
        private final int a;
        private final int b;
        private final int c;

        private b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public C3050h(io.sentry.util.r rVar, SentryAndroidOptions sentryAndroidOptions, C3089z0 c3089z0) {
        this.a = null;
        this.c = new ConcurrentHashMap();
        this.d = new WeakHashMap();
        this.f = new C3202a();
        if (rVar.a("androidx.core.app.FrameMetricsAggregator", sentryAndroidOptions.getLogger())) {
            this.a = new FrameMetricsAggregator();
        }
        this.b = sentryAndroidOptions;
        this.e = c3089z0;
    }

    private b f() {
        FrameMetricsAggregator frameMetricsAggregator;
        int i;
        int i2;
        SparseIntArray sparseIntArray;
        if (!h() || (frameMetricsAggregator = this.a) == null) {
            return null;
        }
        SparseIntArray[] sparseIntArrayArrB = frameMetricsAggregator.b();
        int i3 = 0;
        if (sparseIntArrayArrB == null || sparseIntArrayArrB.length <= 0 || (sparseIntArray = sparseIntArrayArrB[0]) == null) {
            i = 0;
            i2 = 0;
        } else {
            int i4 = 0;
            i = 0;
            i2 = 0;
            while (i3 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i3);
                int iValueAt = sparseIntArray.valueAt(i3);
                i4 += iValueAt;
                if (iKeyAt > 700) {
                    i2 += iValueAt;
                } else if (iKeyAt > 16) {
                    i += iValueAt;
                }
                i3++;
            }
            i3 = i4;
        }
        return new b(i3, i, i2);
    }

    private b g(Activity activity) {
        b bVarF;
        b bVar = (b) this.d.remove(activity);
        if (bVar == null || (bVarF = f()) == null) {
            return null;
        }
        return new b(bVarF.a - bVar.a, bVarF.b - bVar.b, bVarF.c - bVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Activity activity) {
        this.a.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Throwable unused) {
            if (str != null) {
                this.b.getLogger().c(Y2.WARNING, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Activity activity) {
        this.a.c(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.a.e();
    }

    private void m(final Runnable runnable, final String str) {
        try {
            if (io.sentry.android.core.internal.util.i.e().a()) {
                runnable.run();
            } else {
                this.e.b(new Runnable() { // from class: io.sentry.android.core.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j(runnable, str);
                    }
                });
            }
        } catch (Throwable unused) {
            if (str != null) {
                this.b.getLogger().c(Y2.WARNING, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    private void o(Activity activity) {
        b bVarF = f();
        if (bVarF != null) {
            this.d.put(activity, bVarF);
        }
    }

    public void e(final Activity activity) {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        try {
            if (!h()) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } else {
                m(new Runnable() { // from class: io.sentry.android.core.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.i(activity);
                    }
                }, "FrameMetricsAggregator.add");
                o(activity);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
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

    public boolean h() {
        return (this.a == null || !this.b.isEnableFramesTracking() || this.b.isEnablePerformanceV2()) ? false : true;
    }

    public void n(final Activity activity, io.sentry.protocol.v vVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        try {
            if (!h()) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            m(new Runnable() { // from class: io.sentry.android.core.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(activity);
                }
            }, null);
            b bVarG = g(activity);
            if (bVarG != null && (bVarG.a != 0 || bVarG.b != 0 || bVarG.c != 0)) {
                C3174i c3174i = new C3174i(Integer.valueOf(bVarG.a), "none");
                C3174i c3174i2 = new C3174i(Integer.valueOf(bVarG.b), "none");
                C3174i c3174i3 = new C3174i(Integer.valueOf(bVarG.c), "none");
                HashMap map = new HashMap();
                map.put("frames_total", c3174i);
                map.put("frames_slow", c3174i2);
                map.put("frames_frozen", c3174i3);
                this.c.put(vVar, map);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
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

    public void p() {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        try {
            if (h()) {
                m(new Runnable() { // from class: io.sentry.android.core.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.l();
                    }
                }, "FrameMetricsAggregator.stop");
                this.a.d();
            }
            this.c.clear();
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

    public Map q(io.sentry.protocol.v vVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.f.a();
        try {
            if (!h()) {
                if (interfaceC3102d0A == null) {
                    return null;
                }
                interfaceC3102d0A.close();
                return null;
            }
            Map map = (Map) this.c.get(vVar);
            this.c.remove(vVar);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return map;
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

    public C3050h(io.sentry.util.r rVar, SentryAndroidOptions sentryAndroidOptions) {
        this(rVar, sentryAndroidOptions, new C3089z0());
    }
}
