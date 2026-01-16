package io.sentry;

import io.sentry.B1;
import io.sentry.protocol.C3168c;
import io.sentry.util.AbstractC3204c;
import io.sentry.util.C3202a;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.sentry.z3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3234z3 implements InterfaceC3127i0 {
    private final G3 b;
    private final Z d;
    private String e;
    private volatile TimerTask g;
    private volatile TimerTask h;
    private volatile Timer i;
    private io.sentry.protocol.F n;
    private final EnumC3152n0 o;
    private final C3168c p;
    private final InterfaceC3126i q;
    private final Y3 r;
    private final io.sentry.protocol.v a = new io.sentry.protocol.v();
    private final List c = new CopyOnWriteArrayList();
    private c f = c.c;
    private final C3202a j = new C3202a();
    private final C3202a k = new C3202a();
    private final AtomicBoolean l = new AtomicBoolean(false);
    private final AtomicBoolean m = new AtomicBoolean(false);

    /* renamed from: io.sentry.z3$a */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C3234z3.this.X();
        }
    }

    /* renamed from: io.sentry.z3$b */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C3234z3.this.W();
        }
    }

    /* renamed from: io.sentry.z3$c */
    private static final class c {
        static final c c = d();
        private final boolean a;
        private final O3 b;

        private c(boolean z, O3 o3) {
            this.a = z;
            this.b = o3;
        }

        static c c(O3 o3) {
            return new c(true, o3);
        }

        private static c d() {
            return new c(false, null);
        }
    }

    C3234z3(W3 w3, Z z, Y3 y3, InterfaceC3126i interfaceC3126i) {
        this.i = null;
        C3168c c3168c = new C3168c();
        this.p = c3168c;
        io.sentry.util.u.c(w3, "context is required");
        io.sentry.util.u.c(z, "scopes are required");
        G3 g3 = new G3(w3, this, z, y3);
        this.b = g3;
        this.e = w3.w();
        this.o = w3.d();
        this.d = z;
        this.q = interfaceC3126i;
        this.n = w3.y();
        this.r = y3;
        Z(g3);
        io.sentry.protocol.v vVarM = z.e().getContinuousProfiler().m();
        if (!vVarM.equals(io.sentry.protocol.v.b) && Boolean.TRUE.equals(l())) {
            c3168c.t(new C3163p1(vVarM));
        }
        if (interfaceC3126i != null) {
            interfaceC3126i.e(this);
        }
        if (y3.l() == null && y3.k() == null) {
            return;
        }
        this.i = new Timer(true);
        Y();
        d();
    }

    private void C() {
        InterfaceC3102d0 interfaceC3102d0A = this.j.a();
        try {
            if (this.h != null) {
                this.h.cancel();
                this.m.set(false);
                this.h = null;
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

    private void D() {
        InterfaceC3102d0 interfaceC3102d0A = this.j.a();
        try {
            if (this.g != null) {
                this.g.cancel();
                this.l.set(false);
                this.g = null;
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

    private InterfaceC3117g0 E(H3 h3, N3 n3) {
        if (this.b.k()) {
            return C3033a1.e();
        }
        if (!this.o.equals(h3.d())) {
            return C3033a1.e();
        }
        if (io.sentry.util.A.b(this.d.e().getIgnoredSpanOrigins(), n3.a())) {
            return C3033a1.e();
        }
        M3 m3G = h3.g();
        String strE = h3.e();
        String strC = h3.c();
        if (this.c.size() >= this.d.e().getMaxSpans()) {
            this.d.e().getLogger().c(Y2.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", strE, strC);
            return C3033a1.e();
        }
        io.sentry.util.u.c(m3G, "parentSpanId is required");
        io.sentry.util.u.c(strE, "operation is required");
        D();
        G3 g3 = new G3(this, this.d, h3, n3, new J3() { // from class: io.sentry.v3
            @Override // io.sentry.J3
            public final void a(G3 g32) {
                this.a.Q(g32);
            }
        });
        Z(g3);
        this.c.add(g3);
        InterfaceC3126i interfaceC3126i = this.q;
        if (interfaceC3126i != null) {
            interfaceC3126i.b(g3);
        }
        return g3;
    }

    private InterfaceC3117g0 F(String str, String str2, AbstractC3124h2 abstractC3124h2, EnumC3152n0 enumC3152n0, N3 n3) {
        if (this.b.k()) {
            return C3033a1.e();
        }
        if (!this.o.equals(enumC3152n0)) {
            return C3033a1.e();
        }
        if (this.c.size() < this.d.e().getMaxSpans()) {
            return this.b.u(str, str2, abstractC3124h2, enumC3152n0, n3);
        }
        this.d.e().getLogger().c(Y2.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return C3033a1.e();
    }

    private boolean O() {
        ListIterator listIterator = this.c.listIterator();
        while (listIterator.hasNext()) {
            G3 g3 = (G3) listIterator.next();
            if (!g3.k() && g3.w() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(G3 g3) {
        InterfaceC3126i interfaceC3126i = this.q;
        if (interfaceC3126i != null) {
            interfaceC3126i.a(g3);
        }
        c cVar = this.f;
        if (this.r.l() == null) {
            if (cVar.a) {
                r(cVar.b);
            }
        } else if (!this.r.q() || O()) {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(J3 j3, AtomicReference atomicReference, G3 g3) {
        if (j3 != null) {
            j3.a(g3);
        }
        X3 x3N = this.r.n();
        if (x3N != null) {
            x3N.a(this);
        }
        InterfaceC3126i interfaceC3126i = this.q;
        if (interfaceC3126i != null) {
            atomicReference.set(interfaceC3126i.l(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(X x, InterfaceC3127i0 interfaceC3127i0) {
        if (interfaceC3127i0 == this) {
            x.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(final X x) {
        x.F(new B1.c() { // from class: io.sentry.y3
            @Override // io.sentry.B1.c
            public final void a(InterfaceC3127i0 interfaceC3127i0) {
                this.a.S(x, interfaceC3127i0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(X x) {
        x.t(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(AtomicReference atomicReference, X x) {
        atomicReference.set(x.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        O3 o3J = j();
        if (o3J == null) {
            o3J = O3.DEADLINE_EXCEEDED;
        }
        a(o3J, this.r.l() != null, null);
        this.m.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        O3 o3J = j();
        if (o3J == null) {
            o3J = O3.OK;
        }
        r(o3J);
        this.l.set(false);
    }

    private void Y() {
        Long lK = this.r.k();
        if (lK != null) {
            InterfaceC3102d0 interfaceC3102d0A = this.j.a();
            try {
                if (this.i != null) {
                    C();
                    this.m.set(true);
                    this.h = new b();
                    try {
                        this.i.schedule(this.h, lK.longValue());
                    } catch (Throwable th) {
                        this.d.e().getLogger().b(Y2.WARNING, "Failed to schedule finish timer", th);
                        W();
                    }
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } catch (Throwable th2) {
                if (interfaceC3102d0A != null) {
                    try {
                        interfaceC3102d0A.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private void Z(InterfaceC3117g0 interfaceC3117g0) {
        io.sentry.util.thread.a threadChecker = this.d.e().getThreadChecker();
        io.sentry.protocol.v vVarM = this.d.e().getContinuousProfiler().m();
        if (!vVarM.equals(io.sentry.protocol.v.b) && Boolean.TRUE.equals(interfaceC3117g0.l())) {
            interfaceC3117g0.q("profiler_id", vVarM.toString());
        }
        interfaceC3117g0.q("thread.id", String.valueOf(threadChecker.c()));
        interfaceC3117g0.q("thread.name", threadChecker.b());
    }

    private void d0(C3101d c3101d) {
        InterfaceC3102d0 interfaceC3102d0A = this.k.a();
        try {
            if (c3101d.q()) {
                final AtomicReference atomicReference = new AtomicReference();
                this.d.z(new D1() { // from class: io.sentry.w3
                    @Override // io.sentry.D1
                    public final void a(X x) {
                        C3234z3.V(atomicReference, x);
                    }
                });
                c3101d.I(v().n(), (io.sentry.protocol.v) atomicReference.get(), this.d.e(), L(), getName(), N());
                c3101d.b();
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

    public void G(O3 o3, AbstractC3124h2 abstractC3124h2, boolean z, I i) {
        AbstractC3124h2 abstractC3124h2W = this.b.w();
        if (abstractC3124h2 == null) {
            abstractC3124h2 = abstractC3124h2W;
        }
        if (abstractC3124h2 == null) {
            abstractC3124h2 = this.d.e().getDateProvider().a();
        }
        for (G3 g3 : this.c) {
            if (g3.i().d()) {
                g3.x(o3 != null ? o3 : v().g, abstractC3124h2);
            }
        }
        this.f = c.c(o3);
        if (this.b.k()) {
            return;
        }
        if (!this.r.q() || O()) {
            final AtomicReference atomicReference = new AtomicReference();
            final J3 j3B = this.b.B();
            this.b.G(new J3() { // from class: io.sentry.t3
                @Override // io.sentry.J3
                public final void a(G3 g32) {
                    this.a.R(j3B, atomicReference, g32);
                }
            });
            this.b.x(this.f.b, abstractC3124h2);
            Boolean bool = Boolean.TRUE;
            C3186s1 c3186s1B = (bool.equals(l()) && bool.equals(P())) ? this.d.e().getTransactionProfiler().b(this, (List) atomicReference.get(), this.d.e()) : null;
            if (this.d.e().isContinuousProfilingEnabled()) {
                EnumC3177q1 profileLifecycle = this.d.e().getProfileLifecycle();
                EnumC3177q1 enumC3177q1 = EnumC3177q1.TRACE;
                if (profileLifecycle == enumC3177q1) {
                    this.d.e().getContinuousProfiler().l(enumC3177q1);
                }
            }
            if (atomicReference.get() != null) {
                ((List) atomicReference.get()).clear();
            }
            this.d.z(new D1() { // from class: io.sentry.u3
                @Override // io.sentry.D1
                public final void a(X x) {
                    this.a.T(x);
                }
            });
            io.sentry.protocol.C c2 = new io.sentry.protocol.C(this);
            if (this.i != null) {
                InterfaceC3102d0 interfaceC3102d0A = this.j.a();
                try {
                    if (this.i != null) {
                        D();
                        C();
                        this.i.cancel();
                        this.i = null;
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
            if (z && this.c.isEmpty() && this.r.l() != null) {
                this.d.e().getLogger().c(Y2.DEBUG, "Dropping idle transaction %s because it has no child spans", this.e);
            } else {
                c2.n0().putAll(this.b.g());
                this.d.L(c2, p(), i, c3186s1B);
            }
        }
    }

    public List H() {
        return this.c;
    }

    public C3168c I() {
        return this.p;
    }

    public Map J() {
        return this.b.e();
    }

    G3 K() {
        return this.b;
    }

    public V3 L() {
        return this.b.A();
    }

    public List M() {
        return this.c;
    }

    public io.sentry.protocol.F N() {
        return this.n;
    }

    public Boolean P() {
        return this.b.F();
    }

    @Override // io.sentry.InterfaceC3127i0
    public void a(O3 o3, boolean z, I i) {
        if (k()) {
            return;
        }
        AbstractC3124h2 abstractC3124h2A = this.d.e().getDateProvider().a();
        ListIterator listIteratorD = AbstractC3204c.d((CopyOnWriteArrayList) this.c);
        while (listIteratorD.hasPrevious()) {
            G3 g3 = (G3) listIteratorD.previous();
            g3.G(null);
            g3.x(o3, abstractC3124h2A);
        }
        G(o3, abstractC3124h2A, z, i);
    }

    public void a0(String str, Number number) {
        if (this.b.g().containsKey(str)) {
            return;
        }
        o(str, number);
    }

    @Override // io.sentry.InterfaceC3127i0
    public io.sentry.protocol.v b() {
        return this.a;
    }

    public void b0(String str, Number number, E0 e0) {
        if (this.b.g().containsKey(str)) {
            return;
        }
        t(str, number, e0);
    }

    @Override // io.sentry.InterfaceC3127i0
    public InterfaceC3117g0 c() {
        ListIterator listIteratorD = AbstractC3204c.d((CopyOnWriteArrayList) this.c);
        while (listIteratorD.hasPrevious()) {
            G3 g3 = (G3) listIteratorD.previous();
            if (!g3.k()) {
                return g3;
            }
        }
        return null;
    }

    InterfaceC3117g0 c0(M3 m3, String str, String str2, AbstractC3124h2 abstractC3124h2, EnumC3152n0 enumC3152n0, N3 n3) {
        H3 h3A = v().a(str, m3, null);
        h3A.p(str2);
        h3A.q(enumC3152n0);
        n3.h(abstractC3124h2);
        return E(h3A, n3);
    }

    @Override // io.sentry.InterfaceC3127i0
    public void d() {
        Long l;
        InterfaceC3102d0 interfaceC3102d0A = this.j.a();
        try {
            if (this.i != null && (l = this.r.l()) != null) {
                D();
                this.l.set(true);
                this.g = new a();
                try {
                    this.i.schedule(this.g, l.longValue());
                } catch (Throwable th) {
                    this.d.e().getLogger().b(Y2.WARNING, "Failed to schedule finish timer", th);
                    X();
                }
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th2) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // io.sentry.InterfaceC3117g0
    public String getDescription() {
        return this.b.getDescription();
    }

    @Override // io.sentry.InterfaceC3127i0
    public String getName() {
        return this.e;
    }

    @Override // io.sentry.InterfaceC3117g0
    public O3 j() {
        return this.b.j();
    }

    @Override // io.sentry.InterfaceC3117g0
    public boolean k() {
        return this.b.k();
    }

    @Override // io.sentry.InterfaceC3117g0
    public Boolean l() {
        return this.b.l();
    }

    @Override // io.sentry.InterfaceC3117g0
    public void m() {
        r(j());
    }

    @Override // io.sentry.InterfaceC3117g0
    public InterfaceC3102d0 makeCurrent() {
        this.d.z(new D1() { // from class: io.sentry.x3
            @Override // io.sentry.D1
            public final void a(X x) {
                this.a.U(x);
            }
        });
        return S0.a();
    }

    @Override // io.sentry.InterfaceC3117g0
    public void n(String str) {
        if (this.b.k()) {
            this.d.e().getLogger().c(Y2.DEBUG, "The transaction is already finished. Description %s cannot be set", str);
        } else {
            this.b.n(str);
        }
    }

    @Override // io.sentry.InterfaceC3117g0
    public void o(String str, Number number) {
        this.b.o(str, number);
    }

    @Override // io.sentry.InterfaceC3117g0
    public T3 p() {
        C3101d c3101dB;
        if (!this.d.e().isTraceSampling() || (c3101dB = v().b()) == null) {
            return null;
        }
        d0(c3101dB);
        return c3101dB.J();
    }

    @Override // io.sentry.InterfaceC3117g0
    public void q(String str, Object obj) {
        if (this.b.k()) {
            this.d.e().getLogger().c(Y2.DEBUG, "The transaction is already finished. Data %s cannot be set", str);
        } else {
            this.b.q(str, obj);
        }
    }

    @Override // io.sentry.InterfaceC3117g0
    public void r(O3 o3) {
        x(o3, null);
    }

    @Override // io.sentry.InterfaceC3117g0
    public InterfaceC3117g0 s(String str, String str2, AbstractC3124h2 abstractC3124h2, EnumC3152n0 enumC3152n0) {
        return u(str, str2, abstractC3124h2, enumC3152n0, new N3());
    }

    @Override // io.sentry.InterfaceC3117g0
    public void t(String str, Number number, E0 e0) {
        this.b.t(str, number, e0);
    }

    @Override // io.sentry.InterfaceC3117g0
    public InterfaceC3117g0 u(String str, String str2, AbstractC3124h2 abstractC3124h2, EnumC3152n0 enumC3152n0, N3 n3) {
        return F(str, str2, abstractC3124h2, enumC3152n0, n3);
    }

    @Override // io.sentry.InterfaceC3117g0
    public H3 v() {
        return this.b.v();
    }

    @Override // io.sentry.InterfaceC3117g0
    public AbstractC3124h2 w() {
        return this.b.w();
    }

    @Override // io.sentry.InterfaceC3117g0
    public void x(O3 o3, AbstractC3124h2 abstractC3124h2) {
        G(o3, abstractC3124h2, true, null);
    }

    @Override // io.sentry.InterfaceC3117g0
    public AbstractC3124h2 y() {
        return this.b.y();
    }
}
