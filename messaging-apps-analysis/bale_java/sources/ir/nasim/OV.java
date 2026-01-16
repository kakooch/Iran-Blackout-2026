package ir.nasim;

import ir.nasim.InterfaceC18557or4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class OV implements InterfaceC11463d30 {
    public static final a f = new a(null);
    private final InterfaceC7486Rx5 a;
    private final InterfaceC9336Zm4 b;
    private QV c;
    private XK6 d;
    private final C19148pr4 e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public OV(PV pv, InterfaceC7486Rx5 interfaceC7486Rx5) {
        AbstractC13042fc3.i(pv, "optimizerConfiguration");
        AbstractC13042fc3.i(interfaceC7486Rx5, "optimizerConfigurationProvider");
        this.a = interfaceC7486Rx5;
        this.b = AbstractC12281eL6.a(null);
        this.c = new QV(0L, pv.d(), 0.0d, 0.0d, 0.0d, pv, 29, null);
        this.d = new QK6(pv);
        this.e = new C19148pr4(pv.f(), 0, 2, null);
    }

    private final void c(InterfaceC18557or4 interfaceC18557or4) {
        QV qvA;
        if (interfaceC18557or4 instanceof InterfaceC18557or4.a) {
            qvA = this.c;
        } else {
            if (!(interfaceC18557or4 instanceof InterfaceC18557or4.b)) {
                throw new NoWhenBranchMatchedException();
            }
            QV qv = this.c;
            qvA = qv.a((35 & 1) != 0 ? qv.a : 0L, (35 & 2) != 0 ? qv.b : 0.0d, (35 & 4) != 0 ? qv.c : this.e.b(), (35 & 8) != 0 ? qv.d : this.e.e(), (35 & 16) != 0 ? qv.e : this.e.c(), (35 & 32) != 0 ? qv.f : null);
        }
        this.c = qvA;
    }

    private final void d(InterfaceC18557or4 interfaceC18557or4) {
        C17072mL6 c17072mL6A = this.d.a(interfaceC18557or4, this.c);
        XK6 xk6A = c17072mL6A.a();
        this.c = c17072mL6A.b();
        if (AbstractC13042fc3.d(xk6A, this.d)) {
            return;
        }
        QV qvC = this.d.c(this.c);
        this.c = qvC;
        this.c = xk6A.b(qvC);
        C19406qI3.a("BBR2BandwidthOptimizer", this.d + " --> " + xk6A, new Object[0]);
        this.d = xk6A;
    }

    private final void f() {
        b().setValue(new C9489a30(this.c.e(), this.c.c().a(), this.c.d(), "State: " + this.d));
    }

    @Override // ir.nasim.InterfaceC11463d30
    public void a(InterfaceC18557or4 interfaceC18557or4) {
        AbstractC13042fc3.i(interfaceC18557or4, "sample");
        synchronized (this) {
            try {
                QV qv = this.c;
                C17642nJ3 c17642nJ3 = new C17642nJ3(qv.e() - 2, qv.e());
                long jO = c17642nJ3.o();
                long jT = c17642nJ3.t();
                long jA = interfaceC18557or4.a().a();
                if (jO > jA || jA > jT) {
                    C19406qI3.j("BBR2BandwidthOptimizer", "Skipping the sample: " + interfaceC18557or4, new Object[0]);
                } else {
                    this.e.a(interfaceC18557or4);
                    if (this.e.f()) {
                        C19406qI3.a("BBR2BandwidthOptimizer", "onSample: " + interfaceC18557or4 + ", state: " + this.d + ", bandwidthProfile: " + this.c, new Object[0]);
                        QV qv2 = this.c;
                        c(interfaceC18557or4);
                        d(interfaceC18557or4);
                        if (!AbstractC13042fc3.d(qv2, this.c)) {
                            QV qv3 = this.c;
                            this.c = qv3.a((35 & 1) != 0 ? qv3.a : qv3.e() + 1, (35 & 2) != 0 ? qv3.b : 0.0d, (35 & 4) != 0 ? qv3.c : 0.0d, (35 & 8) != 0 ? qv3.d : 0.0d, (35 & 16) != 0 ? qv3.e : 0.0d, (35 & 32) != 0 ? qv3.f : null);
                        }
                        f();
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC11463d30
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public InterfaceC9336Zm4 b() {
        return this.b;
    }
}
