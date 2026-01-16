package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.g;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC16176kp7;
import ir.nasim.AbstractC5214Ij5;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14710iL6;
import ir.nasim.RG4;
import ir.nasim.SA2;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public abstract class g {
    public static final a e = new a(null);
    public static final int f = 8;
    private i a;
    private long b;
    private boolean c;
    private int d;

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(InterfaceC14603iB2 interfaceC14603iB2) {
            synchronized (j.J()) {
                j.i = AbstractC15401jX0.O0(j.i, interfaceC14603iB2);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(UA2 ua2) {
            synchronized (j.J()) {
                j.j = AbstractC15401jX0.O0(j.j, ua2);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            j.C();
        }

        public final g c() {
            return j.I();
        }

        public final g d() {
            return (g) j.c.a();
        }

        public final g e(g gVar) {
            if (gVar instanceof l) {
                l lVar = (l) gVar;
                if (lVar.V() == AbstractC16176kp7.a()) {
                    lVar.Y(null);
                    return gVar;
                }
            }
            if (gVar instanceof m) {
                m mVar = (m) gVar;
                if (mVar.C() == AbstractC16176kp7.a()) {
                    mVar.F(null);
                    return gVar;
                }
            }
            g gVarF = j.F(gVar, null, false, 6, null);
            gVarF.l();
            return gVarF;
        }

        public final void f() {
            j.I().o();
        }

        public final Object g(UA2 ua2, UA2 ua22, SA2 sa2) {
            g lVar;
            if (ua2 == null && ua22 == null) {
                return sa2.invoke();
            }
            g gVar = (g) j.c.a();
            if (gVar instanceof l) {
                l lVar2 = (l) gVar;
                if (lVar2.V() == AbstractC16176kp7.a()) {
                    UA2 ua2G = lVar2.g();
                    UA2 ua2K = lVar2.k();
                    try {
                        ((l) gVar).Y(j.L(ua2, ua2G, false, 4, null));
                        ((l) gVar).Z(j.M(ua22, ua2K));
                        return sa2.invoke();
                    } finally {
                        lVar2.Y(ua2G);
                        lVar2.Z(ua2K);
                    }
                }
            }
            if (gVar == null || (gVar instanceof b)) {
                lVar = new l(gVar instanceof b ? (b) gVar : null, ua2, ua22, true, false);
            } else {
                if (ua2 == null) {
                    return sa2.invoke();
                }
                lVar = gVar.x(ua2);
            }
            try {
                g gVarL = lVar.l();
                try {
                    return sa2.invoke();
                } finally {
                    lVar.s(gVarL);
                }
            } finally {
                lVar.d();
            }
        }

        public final RG4 h(final InterfaceC14603iB2 interfaceC14603iB2) {
            j.B(j.a);
            synchronized (j.J()) {
                j.i = AbstractC15401jX0.S0(j.i, interfaceC14603iB2);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            return new RG4() { // from class: ir.nasim.OG6
                @Override // ir.nasim.RG4
                public final void dispose() {
                    g.a.i(interfaceC14603iB2);
                }
            };
        }

        public final RG4 j(final UA2 ua2) {
            synchronized (j.J()) {
                j.j = AbstractC15401jX0.S0(j.j, ua2);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            j.C();
            return new RG4() { // from class: ir.nasim.PG6
                @Override // ir.nasim.RG4
                public final void dispose() {
                    g.a.k(ua2);
                }
            };
        }

        public final void l(g gVar, g gVar2, UA2 ua2) {
            if (gVar != gVar2) {
                gVar2.s(gVar);
                gVar2.d();
            } else if (gVar instanceof l) {
                ((l) gVar).Y(ua2);
            } else {
                if (gVar instanceof m) {
                    ((m) gVar).F(ua2);
                    return;
                }
                throw new IllegalStateException(("Non-transparent snapshot was reused: " + gVar).toString());
            }
        }

        public final void m() {
            boolean zI;
            synchronized (j.J()) {
                zI = j.k.I();
            }
            if (zI) {
                j.C();
            }
        }

        public final b n(UA2 ua2, UA2 ua22) {
            b bVarR;
            g gVarI = j.I();
            b bVar = gVarI instanceof b ? (b) gVarI : null;
            if (bVar == null || (bVarR = bVar.R(ua2, ua22)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
            }
            return bVarR;
        }

        public final g o(UA2 ua2) {
            return j.I().x(ua2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ g(long j, i iVar, ED1 ed1) {
        this(j, iVar);
    }

    public final void b() {
        synchronized (j.J()) {
            c();
            r();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public void c() {
        j.e = j.e.v(i());
    }

    public void d() {
        this.c = true;
        synchronized (j.J()) {
            q();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final boolean e() {
        return this.c;
    }

    public i f() {
        return this.a;
    }

    public abstract UA2 g();

    public abstract boolean h();

    public long i() {
        return this.b;
    }

    public int j() {
        return 0;
    }

    public abstract UA2 k();

    public g l() {
        g gVar = (g) j.c.a();
        j.c.b(this);
        return gVar;
    }

    public abstract void m(g gVar);

    public abstract void n(g gVar);

    public abstract void o();

    public abstract void p(InterfaceC14710iL6 interfaceC14710iL6);

    public final void q() {
        int i = this.d;
        if (i >= 0) {
            j.Y(i);
            this.d = -1;
        }
    }

    public void r() {
        q();
    }

    public void s(g gVar) {
        j.c.b(gVar);
    }

    public final void t(boolean z) {
        this.c = z;
    }

    public void u(i iVar) {
        this.a = iVar;
    }

    public void v(long j) {
        this.b = j;
    }

    public void w(int i) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot".toString());
    }

    public abstract g x(UA2 ua2);

    public final int y() {
        int i = this.d;
        this.d = -1;
        return i;
    }

    public final void z() {
        if (!this.c) {
            return;
        }
        AbstractC5214Ij5.a("Cannot use a disposed snapshot");
    }

    private g(long j, i iVar) {
        this.a = iVar;
        this.b = j;
        this.d = j != j.b ? j.c0(j, f()) : -1;
    }
}
