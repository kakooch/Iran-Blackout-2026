package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.h;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC9628aH6;
import ir.nasim.C19938rB7;
import ir.nasim.C7620Sm4;
import ir.nasim.UA2;
import java.util.Map;

/* loaded from: classes.dex */
public final class c extends b {
    private final b s;
    private boolean t;

    public c(long j, i iVar, UA2 ua2, UA2 ua22, b bVar) {
        super(j, iVar, ua2, ua22);
        this.s = bVar;
        bVar.m(this);
    }

    private final void U() {
        if (this.t) {
            return;
        }
        this.t = true;
        this.s.n(this);
    }

    @Override // androidx.compose.runtime.snapshots.b
    public h C() {
        if (this.s.D() || this.s.e()) {
            return new h.a(this);
        }
        C7620Sm4 c7620Sm4E = E();
        long jI = i();
        Map mapR = c7620Sm4E != null ? j.R(this.s.i(), this, this.s.f()) : null;
        synchronized (j.J()) {
            try {
                j.g0(this);
                if (c7620Sm4E == null || c7620Sm4E.c() == 0) {
                    b();
                } else {
                    h hVarJ = J(this.s.i(), c7620Sm4E, mapR, this.s.f());
                    if (!AbstractC13042fc3.d(hVarJ, h.b.a)) {
                        return hVarJ;
                    }
                    C7620Sm4 c7620Sm4E2 = this.s.E();
                    if (c7620Sm4E2 != null) {
                        c7620Sm4E2.i(c7620Sm4E);
                    } else {
                        this.s.Q(c7620Sm4E);
                        Q(null);
                    }
                }
                if (this.s.i() < jI) {
                    this.s.B();
                }
                b bVar = this.s;
                bVar.u(bVar.f().v(jI).t(F()));
                this.s.K(jI);
                this.s.M(y());
                this.s.L(F());
                this.s.N(G());
                C19938rB7 c19938rB7 = C19938rB7.a;
                P(true);
                U();
                AbstractC9628aH6.c(this, c7620Sm4E);
                return h.b.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public void d() {
        if (e()) {
            return;
        }
        super.d();
        U();
    }
}
