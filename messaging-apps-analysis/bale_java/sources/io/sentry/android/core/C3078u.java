package io.sentry.android.core;

import io.sentry.AbstractC3124h2;
import io.sentry.C3115f3;
import io.sentry.C3155n3;
import io.sentry.C3158o1;
import io.sentry.EnumC3136k;
import io.sentry.EnumC3177q1;
import io.sentry.ILogger;
import io.sentry.InterfaceC3097c0;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3126i;
import io.sentry.N;
import io.sentry.U3;
import io.sentry.Y2;
import io.sentry.Z1;
import io.sentry.android.core.F;
import io.sentry.transport.A;
import io.sentry.util.C3202a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.sentry.android.core.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3078u implements io.sentry.O, A.b {
    private final ILogger a;
    private final String b;
    private final int c;
    private final InterfaceC3097c0 d;
    private final Y e;
    private final io.sentry.android.core.internal.util.C g;
    private io.sentry.Z j;
    private Future k;
    private InterfaceC3126i l;
    private io.sentry.protocol.v n;
    private io.sentry.protocol.v o;
    private final AtomicBoolean p;
    private AbstractC3124h2 q;
    private volatile boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private final C3202a v;
    private final C3202a w;
    private boolean f = false;
    private F h = null;
    private boolean i = false;
    private final List m = new ArrayList();

    /* renamed from: io.sentry.android.core.u$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC3177q1.values().length];
            a = iArr;
            try {
                iArr[EnumC3177q1.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC3177q1.MANUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C3078u(Y y, io.sentry.android.core.internal.util.C c, ILogger iLogger, String str, int i, InterfaceC3097c0 interfaceC3097c0) {
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        this.n = vVar;
        this.o = vVar;
        this.p = new AtomicBoolean(false);
        this.q = new C3115f3();
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = new C3202a();
        this.w = new C3202a();
        this.a = iLogger;
        this.g = c;
        this.e = y;
        this.b = str;
        this.c = i;
        this.d = interfaceC3097c0;
    }

    private void c() {
        if (this.f) {
            return;
        }
        this.f = true;
        String str = this.b;
        if (str == null) {
            this.a.c(Y2.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            return;
        }
        int i = this.c;
        if (i <= 0) {
            this.a.c(Y2.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(i));
        } else {
            this.h = new F(str, ((int) TimeUnit.SECONDS.toMicros(1L)) / this.c, this.g, null, this.a);
        }
    }

    private void d() {
        io.sentry.Z z = this.j;
        if ((z == null || z == io.sentry.R0.h()) && Z1.r() != io.sentry.R0.h()) {
            this.j = Z1.r();
            this.l = Z1.r().e().getCompositePerformanceCollector();
            io.sentry.transport.A aW = this.j.w();
            if (aW != null) {
                aW.e(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(C3155n3 c3155n3, io.sentry.Z z) {
        if (this.p.get()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.m.size());
        InterfaceC3102d0 interfaceC3102d0A = this.w.a();
        try {
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3158o1.a) it.next()).a(c3155n3));
            }
            this.m.clear();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                z.F((C3158o1) it2.next());
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
    public /* synthetic */ void f() {
        o(true);
    }

    private void h(final io.sentry.Z z, final C3155n3 c3155n3) {
        try {
            c3155n3.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(c3155n3, z);
                }
            });
        } catch (Throwable th) {
            c3155n3.getLogger().b(Y2.DEBUG, "Failed to send profile chunks.", th);
        }
    }

    private void n() {
        d();
        if (this.e.d() < 22) {
            return;
        }
        c();
        if (this.h == null) {
            return;
        }
        io.sentry.Z z = this.j;
        if (z != null) {
            io.sentry.transport.A aW = z.w();
            if (aW != null && (aW.l(EnumC3136k.All) || aW.l(EnumC3136k.ProfileChunkUi))) {
                this.a.c(Y2.WARNING, "SDK is rate limited. Stopping profiler.", new Object[0]);
                o(false);
                return;
            } else {
                if (this.j.e().getConnectionStatusProvider().w0() == N.a.DISCONNECTED) {
                    this.a.c(Y2.WARNING, "Device is offline. Stopping profiler.", new Object[0]);
                    o(false);
                    return;
                }
                this.q = this.j.e().getDateProvider().a();
            }
        } else {
            this.q = new C3115f3();
        }
        if (this.h.j() == null) {
            return;
        }
        this.i = true;
        io.sentry.protocol.v vVar = this.n;
        io.sentry.protocol.v vVar2 = io.sentry.protocol.v.b;
        if (vVar == vVar2) {
            this.n = new io.sentry.protocol.v();
        }
        if (this.o == vVar2) {
            this.o = new io.sentry.protocol.v();
        }
        InterfaceC3126i interfaceC3126i = this.l;
        if (interfaceC3126i != null) {
            interfaceC3126i.f(this.o.toString());
        }
        try {
            this.k = this.d.c(new Runnable() { // from class: io.sentry.android.core.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            }, 60000L);
        } catch (RejectedExecutionException e) {
            this.a.b(Y2.ERROR, "Failed to schedule profiling chunk finish. Did you call Sentry.close()?", e);
            this.s = true;
        }
    }

    private void o(boolean z) {
        d();
        InterfaceC3102d0 interfaceC3102d0A = this.v.a();
        try {
            Future future = this.k;
            if (future != null) {
                future.cancel(true);
            }
            if (this.h != null && this.i) {
                if (this.e.d() < 22) {
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                        return;
                    }
                    return;
                }
                InterfaceC3126i interfaceC3126i = this.l;
                F.b bVarG = this.h.g(false, interfaceC3126i != null ? interfaceC3126i.c(this.o.toString()) : null);
                if (bVarG == null) {
                    this.a.c(Y2.ERROR, "An error occurred while collecting a profile chunk, and it won't be sent.", new Object[0]);
                } else {
                    InterfaceC3102d0 interfaceC3102d0A2 = this.w.a();
                    try {
                        this.m.add(new C3158o1.a(this.n, this.o, bVarG.d, bVarG.c, this.q));
                        if (interfaceC3102d0A2 != null) {
                            interfaceC3102d0A2.close();
                        }
                    } finally {
                    }
                }
                this.i = false;
                io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
                this.o = vVar;
                io.sentry.Z z2 = this.j;
                if (z2 != null) {
                    h(z2, z2.e());
                }
                if (!z || this.s) {
                    this.n = vVar;
                    this.a.c(Y2.DEBUG, "Profile chunk finished.", new Object[0]);
                } else {
                    this.a.c(Y2.DEBUG, "Profile chunk finished. Starting a new one.", new Object[0]);
                    n();
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            io.sentry.protocol.v vVar2 = io.sentry.protocol.v.b;
            this.n = vVar2;
            this.o = vVar2;
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

    @Override // io.sentry.transport.A.b
    public void g(io.sentry.transport.A a2) {
        if (a2.l(EnumC3136k.All) || a2.l(EnumC3136k.ProfileChunkUi)) {
            this.a.c(Y2.WARNING, "SDK is rate limited. Stopping profiler.", new Object[0]);
            o(false);
        }
    }

    @Override // io.sentry.O
    public void i(boolean z) {
        InterfaceC3102d0 interfaceC3102d0A = this.v.a();
        try {
            this.u = 0;
            this.s = true;
            if (z) {
                o(false);
                this.p.set(true);
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

    @Override // io.sentry.O
    public boolean isRunning() {
        return this.i;
    }

    @Override // io.sentry.O
    public void j(EnumC3177q1 enumC3177q1, U3 u3) {
        InterfaceC3102d0 interfaceC3102d0A = this.v.a();
        try {
            if (this.r) {
                this.t = u3.c(io.sentry.util.z.a().d());
                this.r = false;
            }
            if (!this.t) {
                this.a.c(Y2.DEBUG, "Profiler was not started due to sampling decision.", new Object[0]);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            int i = a.a[enumC3177q1.ordinal()];
            if (i == 1) {
                if (this.u < 0) {
                    this.u = 0;
                }
                this.u++;
            } else if (i == 2 && isRunning()) {
                this.a.c(Y2.DEBUG, "Profiler is already running.", new Object[0]);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            if (!isRunning()) {
                this.a.c(Y2.DEBUG, "Started Profiler.", new Object[0]);
                n();
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

    @Override // io.sentry.O
    public void k() {
        this.r = true;
    }

    @Override // io.sentry.O
    public void l(EnumC3177q1 enumC3177q1) {
        InterfaceC3102d0 interfaceC3102d0A = this.v.a();
        try {
            int i = a.a[enumC3177q1.ordinal()];
            if (i == 1) {
                int i2 = this.u - 1;
                this.u = i2;
                if (i2 > 0) {
                    if (interfaceC3102d0A != null) {
                        interfaceC3102d0A.close();
                        return;
                    }
                    return;
                } else {
                    if (i2 < 0) {
                        this.u = 0;
                    }
                    this.s = true;
                }
            } else if (i == 2) {
                this.s = true;
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

    @Override // io.sentry.O
    public io.sentry.protocol.v m() {
        return this.n;
    }
}
