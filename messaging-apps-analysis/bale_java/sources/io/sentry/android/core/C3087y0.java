package io.sentry.android.core;

import io.appmetrica.analytics.impl.C2439ba;
import io.appmetrica.analytics.impl.G2;
import io.sentry.C3;
import io.sentry.C3106e;
import io.sentry.D1;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.android.core.X;
import io.sentry.util.C3202a;
import io.sentry.util.q;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.sentry.android.core.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3087y0 implements X.a {
    private final AtomicLong a;
    private final long b;
    private TimerTask c;
    private final io.sentry.util.q d;
    private final C3202a e;
    private final io.sentry.Z f;
    private final boolean g;
    private final boolean h;
    private final io.sentry.transport.p i;

    /* renamed from: io.sentry.android.core.y0$a */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (C3087y0.this.g) {
                C3087y0.this.f.g();
            }
            C3087y0.this.f.e().getReplayController().stop();
            C3087y0.this.f.e().getContinuousProfiler().i(false);
        }
    }

    C3087y0(io.sentry.Z z, long j, boolean z2, boolean z3) {
        this(z, j, z2, z3, io.sentry.transport.n.b());
    }

    private void g(String str) {
        if (this.h) {
            C3106e c3106e = new C3106e();
            c3106e.C("navigation");
            c3106e.z("state", str);
            c3106e.y("app.lifecycle");
            c3106e.A(Y2.INFO);
            this.f.a(c3106e);
        }
    }

    private void h() {
        InterfaceC3102d0 interfaceC3102d0A = this.e.a();
        try {
            TimerTask timerTask = this.c;
            if (timerTask != null) {
                timerTask.cancel();
                this.c = null;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Timer i() {
        return new Timer(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(io.sentry.X x) {
        C3 c3Y;
        if (this.a.get() != 0 || (c3Y = x.y()) == null || c3Y.k() == null) {
            return;
        }
        this.a.set(c3Y.k().getTime());
    }

    private void k() {
        InterfaceC3102d0 interfaceC3102d0A = this.e.a();
        try {
            h();
            this.c = new a();
            ((Timer) this.d.a()).schedule(this.c, this.b);
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

    private void l() {
        h();
        long jA = this.i.a();
        this.f.z(new D1() { // from class: io.sentry.android.core.x0
            @Override // io.sentry.D1
            public final void a(io.sentry.X x) {
                this.a.j(x);
            }
        });
        long j = this.a.get();
        if (j == 0 || j + this.b <= jA) {
            if (this.g) {
                this.f.l();
            }
            this.f.e().getReplayController().start();
        }
        this.f.e().getReplayController().v();
        this.a.set(jA);
    }

    @Override // io.sentry.android.core.X.a
    public void a() {
        l();
        g(C2439ba.g);
    }

    @Override // io.sentry.android.core.X.a
    public void b() {
        this.a.set(this.i.a());
        this.f.e().getReplayController().h();
        k();
        g(G2.g);
    }

    C3087y0(io.sentry.Z z, long j, boolean z2, boolean z3, io.sentry.transport.p pVar) {
        this.a = new AtomicLong(0L);
        this.d = new io.sentry.util.q(new q.a() { // from class: io.sentry.android.core.w0
            @Override // io.sentry.util.q.a
            public final Object a() {
                return C3087y0.i();
            }
        });
        this.e = new C3202a();
        this.b = j;
        this.g = z2;
        this.h = z3;
        this.f = z;
        this.i = pVar;
    }
}
