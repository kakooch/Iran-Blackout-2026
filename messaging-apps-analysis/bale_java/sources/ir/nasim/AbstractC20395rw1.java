package ir.nasim;

import java.io.IOException;
import java.util.HashSet;

/* renamed from: ir.nasim.rw1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20395rw1 extends AbstractC6360Ng4 {
    private C5403Je5 m;
    private HashSet n;
    private long o;
    private InterfaceC8344Vo3 p;

    /* renamed from: ir.nasim.rw1$a */
    private static class a {
        private C11458d25 a;
        private long b;

        public long a() {
            return this.b;
        }

        public C11458d25 b() {
            return this.a;
        }

        private a(C11458d25 c11458d25, long j) {
            this.a = c11458d25;
            this.b = j;
        }
    }

    public AbstractC20395rw1(long j, C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.n = new HashSet();
        this.o = j;
        this.p = c9057Yh4.T().C();
        b0("sequences_synced");
    }

    private void i0() {
        this.p.e(new C9863ah0(this.o, this.m.toByteArray()));
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        for (C5169Ie5 c5169Ie5 : this.m.r()) {
            if (c5169Ie5.y() < c5169Ie5.w()) {
                this.n.add(c5169Ie5.u());
                h0(c5169Ie5.u(), c5169Ie5.w());
            }
        }
    }

    protected final void d0(C11458d25 c11458d25, long j) {
        C5169Ie5 c5169Ie5S = this.m.s(c11458d25);
        if (j > c5169Ie5S.y() && j > c5169Ie5S.w()) {
            long jMax = Math.max(c5169Ie5S.w(), j);
            this.m.u(c5169Ie5S.q(jMax));
            i0();
            if (this.n.contains(c11458d25)) {
                return;
            }
            this.n.add(c11458d25);
            h0(c11458d25, jMax);
        }
    }

    protected void e0(C11458d25 c11458d25, long j) {
        r().d(new a(c11458d25, j));
    }

    protected void f0(C11458d25 c11458d25, long j) {
        this.n.remove(c11458d25);
        d0(c11458d25, j);
    }

    protected final void g0(C11458d25 c11458d25, long j) {
        this.n.remove(c11458d25);
        C5169Ie5 c5169Ie5S = this.m.s(c11458d25);
        C5169Ie5 c5169Ie5R = c5169Ie5S.r(Math.max(j, c5169Ie5S.y()));
        this.m.u(c5169Ie5R);
        i0();
        if (c5169Ie5R.y() < c5169Ie5R.w()) {
            this.n.add(c11458d25);
            h0(c11458d25, c5169Ie5R.w());
        }
    }

    protected abstract void h0(C11458d25 c11458d25, long j);

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) {
        if (!(obj instanceof a)) {
            super.m(obj);
        } else {
            a aVar = (a) obj;
            g0(aVar.b(), aVar.a());
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        this.m = new C5403Je5();
        C9863ah0 c9863ah0 = (C9863ah0) this.p.d(this.o);
        if (c9863ah0 != null) {
            try {
                this.m = C5403Je5.q(c9863ah0.q());
            } catch (IOException e) {
                C19406qI3.c("CursorActor", "preStart", e);
            }
        }
    }
}
