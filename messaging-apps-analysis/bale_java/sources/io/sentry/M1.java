package io.sentry;

import io.sentry.B1;
import io.sentry.protocol.C3171f;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class M1 implements Z {
    private final X a;
    private final X b;
    private final X c;
    private final M1 d;
    private final String e;
    private final InterfaceC3126i f;
    private final C3121h g;
    private final io.sentry.logger.a h;

    public M1(X x, X x2, X x3, String str) {
        this(x, x2, x3, null, str);
    }

    private Double O(W3 w3) {
        Double dI;
        C3101d c3101dB = w3.b();
        return (c3101dB == null || (dI = c3101dB.i()) == null) ? v().z().c() : dI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(InterfaceC3097c0 interfaceC3097c0) {
        interfaceC3097c0.b(e().getShutdownTimeoutMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(boolean z, X x) {
        x.B().i(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(boolean z, X x) {
        x.B().i(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(boolean z, X x) {
        x.B().i(z);
    }

    private void V(io.sentry.protocol.v vVar) {
        v().G(vVar);
    }

    private static void W(C3155n3 c3155n3) {
        io.sentry.util.u.c(c3155n3, "SentryOptions is required.");
        if (c3155n3.getDsn() == null || c3155n3.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Scopes requires a DSN to be instantiated. Considering using the NoOpScopes if no DSN is available.");
        }
    }

    private void o(L2 l2) {
        v().D(l2);
    }

    private X p(X x, D1 d1) {
        if (d1 != null) {
            try {
                X xM22clone = x.m22clone();
                d1.a(xM22clone);
                return xM22clone;
            } catch (Throwable th) {
                e().getLogger().b(Y2.ERROR, "Error in the 'ScopeCallback' callback.", th);
            }
        }
        return x;
    }

    private io.sentry.protocol.v q(L2 l2, I i, D1 d1) {
        io.sentry.protocol.v vVarG = io.sentry.protocol.v.b;
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return vVarG;
        }
        if (l2 == null) {
            e().getLogger().c(Y2.WARNING, "captureEvent called with null parameter.", new Object[0]);
            return vVarG;
        }
        try {
            o(l2);
            vVarG = u().g(l2, p(v(), d1), i);
            V(vVarG);
            return vVarG;
        } catch (Throwable th) {
            e().getLogger().b(Y2.ERROR, "Error while capturing event with id: " + l2.G(), th);
            return vVarG;
        }
    }

    private InterfaceC3127i0 s(W3 w3, Y3 y3) {
        InterfaceC3127i0 interfaceC3127i0A;
        io.sentry.util.u.c(w3, "transactionContext is required");
        w3.r(y3.a());
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            interfaceC3127i0A = C3098c1.e();
        } else if (io.sentry.util.A.b(e().getIgnoredSpanOrigins(), w3.f())) {
            e().getLogger().c(Y2.DEBUG, "Returning no-op for span origin %s as the SDK has been configured to ignore it", w3.f());
            interfaceC3127i0A = C3098c1.e();
        } else if (!e().getInstrumenter().equals(w3.d())) {
            e().getLogger().c(Y2.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", w3.d(), e().getInstrumenter());
            interfaceC3127i0A = C3098c1.e();
        } else if (e().isTracingEnabled()) {
            Double dO = O(w3);
            y3.j();
            V3 v3A = e().getInternalTracesSampler().a(new A1(w3, null, dO, null));
            w3.s(v3A);
            InterfaceC3122h0 interfaceC3122h0M = y3.m();
            if (interfaceC3122h0M == null) {
                interfaceC3122h0M = e().getSpanFactory();
            }
            interfaceC3127i0A = interfaceC3122h0M.a(w3, this, y3, this.f);
            if (v3A.e().booleanValue()) {
                if (v3A.b().booleanValue()) {
                    InterfaceC3132j0 transactionProfiler = e().getTransactionProfiler();
                    if (!transactionProfiler.isRunning()) {
                        transactionProfiler.start();
                        transactionProfiler.a(interfaceC3127i0A);
                    } else if (y3.o()) {
                        transactionProfiler.a(interfaceC3127i0A);
                    }
                }
                if (e().isContinuousProfilingEnabled()) {
                    EnumC3177q1 profileLifecycle = e().getProfileLifecycle();
                    EnumC3177q1 enumC3177q1 = EnumC3177q1.TRACE;
                    if (profileLifecycle == enumC3177q1) {
                        e().getContinuousProfiler().j(enumC3177q1, e().getInternalTracesSampler());
                    }
                }
            }
        } else {
            e().getLogger().c(Y2.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            interfaceC3127i0A = C3098c1.e();
        }
        if (y3.p()) {
            interfaceC3127i0A.makeCurrent();
        }
        return interfaceC3127i0A;
    }

    @Override // io.sentry.Z
    public void B(F1 f1, D1 d1) {
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            d1.a(this.g.i(f1));
        } catch (Throwable th) {
            e().getLogger().b(Y2.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v C(C3160o3 c3160o3, I i) {
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'captureReplay' call is a no-op.", new Object[0]);
            return vVar;
        }
        try {
            return u().a(c3160o3, v(), i);
        } catch (Throwable th) {
            e().getLogger().b(Y2.ERROR, "Error while capturing replay", th);
            return vVar;
        }
    }

    @Override // io.sentry.Z
    public X D() {
        return this.c;
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v E(C3171f c3171f, I i, D1 d1) {
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'captureFeedback' call is a no-op.", new Object[0]);
            return vVar;
        }
        if (c3171f.g().isEmpty()) {
            e().getLogger().c(Y2.WARNING, "captureFeedback called with empty message.", new Object[0]);
            return vVar;
        }
        try {
            return u().d(c3171f, i, p(v(), d1));
        } catch (Throwable th) {
            e().getLogger().b(Y2.ERROR, "Error while capturing feedback: " + c3171f.g(), th);
            return vVar;
        }
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v F(C3158o1 c3158o1) {
        io.sentry.util.u.c(c3158o1, "profilingContinuousData is required");
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return vVar;
        }
        try {
            return u().f(c3158o1, getScope());
        } catch (Throwable th) {
            e().getLogger().b(Y2.ERROR, "Error while capturing profile chunk with id: " + c3158o1.l(), th);
            return vVar;
        }
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v I(L2 l2, I i) {
        return q(l2, i, null);
    }

    @Override // io.sentry.Z
    public InterfaceC3127i0 K(W3 w3, Y3 y3) {
        return s(w3, y3);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v L(io.sentry.protocol.C c, T3 t3, I i, C3186s1 c3186s1) {
        io.sentry.util.u.c(c, "transaction is required");
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return vVar;
        }
        if (!c.r0()) {
            e().getLogger().c(Y2.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", c.G());
            return vVar;
        }
        if (Boolean.TRUE.equals(Boolean.valueOf(c.s0()))) {
            try {
                return u().b(c, t3, v(), i, c3186s1);
            } catch (Throwable th) {
                e().getLogger().b(Y2.ERROR, "Error while capturing transaction with id: " + c.G(), th);
                return vVar;
            }
        }
        e().getLogger().c(Y2.DEBUG, "Transaction %s was dropped due to sampling decision.", c.G());
        if (e().getBackpressureMonitor().a() > 0) {
            io.sentry.clientreport.h clientReportRecorder = e().getClientReportRecorder();
            io.sentry.clientreport.f fVar = io.sentry.clientreport.f.BACKPRESSURE;
            clientReportRecorder.a(fVar, EnumC3136k.Transaction);
            e().getClientReportRecorder().c(fVar, EnumC3136k.Span, c.p0().size() + 1);
            return vVar;
        }
        io.sentry.clientreport.h clientReportRecorder2 = e().getClientReportRecorder();
        io.sentry.clientreport.f fVar2 = io.sentry.clientreport.f.SAMPLE_RATE;
        clientReportRecorder2.a(fVar2, EnumC3136k.Transaction);
        e().getClientReportRecorder().c(fVar2, EnumC3136k.Span, c.p0().size() + 1);
        return vVar;
    }

    @Override // io.sentry.Z
    public Z M(String str) {
        return new M1(this.a.m22clone(), this.b.m22clone(), this.c, this, str);
    }

    @Override // io.sentry.Z
    public void a(C3106e c3106e) {
        b(c3106e, new I());
    }

    @Override // io.sentry.Z
    public void b(C3106e c3106e, I i) {
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (c3106e == null) {
            e().getLogger().c(Y2.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            v().b(c3106e, i);
        }
    }

    @Override // io.sentry.Z
    public void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str) {
        v().d(th, interfaceC3117g0, str);
    }

    @Override // io.sentry.Z
    public C3155n3 e() {
        return this.g.e();
    }

    @Override // io.sentry.Z
    public InterfaceC3127i0 f() {
        if (isEnabled()) {
            return v().f();
        }
        e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'getTransaction' call is a no-op.", new Object[0]);
        return null;
    }

    @Override // io.sentry.Z
    public void g() {
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        C3 c3G = v().g();
        if (c3G != null) {
            u().c(c3G, io.sentry.util.m.e(new io.sentry.hints.m()));
        }
    }

    @Override // io.sentry.Z
    public X getScope() {
        return this.a;
    }

    @Override // io.sentry.Z
    public void i(final boolean z) {
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (InterfaceC3157o0 interfaceC3157o0 : e().getIntegrations()) {
                if (interfaceC3157o0 instanceof Closeable) {
                    try {
                        ((Closeable) interfaceC3157o0).close();
                    } catch (Throwable th) {
                        e().getLogger().c(Y2.WARNING, "Failed to close the integration {}.", interfaceC3157o0, th);
                    }
                }
            }
            z(new D1() { // from class: io.sentry.G1
                @Override // io.sentry.D1
                public final void a(X x) {
                    x.clear();
                }
            });
            F1 f1 = F1.ISOLATION;
            B(f1, new D1() { // from class: io.sentry.H1
                @Override // io.sentry.D1
                public final void a(X x) {
                    x.clear();
                }
            });
            e().getBackpressureMonitor().close();
            e().getTransactionProfiler().close();
            e().getContinuousProfiler().i(true);
            e().getCompositePerformanceCollector().close();
            e().getConnectionStatusProvider().close();
            final InterfaceC3097c0 executorService = e().getExecutorService();
            if (z) {
                executorService.submit(new Runnable() { // from class: io.sentry.I1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.R(executorService);
                    }
                });
            } else {
                executorService.b(e().getShutdownTimeoutMillis());
            }
            B(F1.CURRENT, new D1() { // from class: io.sentry.J1
                @Override // io.sentry.D1
                public final void a(X x) {
                    M1.S(z, x);
                }
            });
            B(f1, new D1() { // from class: io.sentry.K1
                @Override // io.sentry.D1
                public final void a(X x) {
                    M1.T(z, x);
                }
            });
            B(F1.GLOBAL, new D1() { // from class: io.sentry.L1
                @Override // io.sentry.D1
                public final void a(X x) {
                    M1.U(z, x);
                }
            });
        } catch (Throwable th2) {
            e().getLogger().b(Y2.ERROR, "Error while closing the Scopes.", th2);
        }
    }

    @Override // io.sentry.Z
    public boolean isEnabled() {
        return u().isEnabled();
    }

    @Override // io.sentry.Z
    public void l() {
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        B1.d dVarL = v().l();
        if (dVarL == null) {
            e().getLogger().c(Y2.WARNING, "Session could not be started.", new Object[0]);
            return;
        }
        if (dVarL.b() != null) {
            u().c(dVarL.b(), io.sentry.util.m.e(new io.sentry.hints.m()));
        }
        u().c(dVarL.a(), io.sentry.util.m.e(new io.sentry.hints.o()));
    }

    @Override // io.sentry.Z
    public void r(long j) {
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            u().r(j);
        } catch (Throwable th) {
            e().getLogger().b(Y2.ERROR, "Error in the 'client.flush'.", th);
        }
    }

    @Override // io.sentry.Z
    public boolean t() {
        return u().t();
    }

    public InterfaceC3092b0 u() {
        return v().B();
    }

    public X v() {
        return this.g;
    }

    @Override // io.sentry.Z
    public io.sentry.transport.A w() {
        return u().w();
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v x(C3134j2 c3134j2, I i) {
        io.sentry.util.u.c(c3134j2, "SentryEnvelope is required.");
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            return vVar;
        }
        try {
            io.sentry.protocol.v vVarX = u().x(c3134j2, i);
            return vVarX != null ? vVarX : vVar;
        } catch (Throwable th) {
            e().getLogger().b(Y2.ERROR, "Error while capturing envelope.", th);
            return vVar;
        }
    }

    private M1(X x, X x2, X x3, M1 m1, String str) {
        this.g = new C3121h(x3, x2, x);
        this.a = x;
        this.b = x2;
        this.c = x3;
        this.d = m1;
        this.e = str;
        C3155n3 c3155n3E = e();
        W(c3155n3E);
        this.f = c3155n3E.getCompositePerformanceCollector();
        this.h = new io.sentry.logger.c(this);
    }

    @Override // io.sentry.Z
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public S m18clone() {
        if (!isEnabled()) {
            e().getLogger().c(Y2.WARNING, "Disabled Scopes cloned.", new Object[0]);
        }
        return new M(M("scopes clone"));
    }
}
