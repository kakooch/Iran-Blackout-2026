package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C2112d0;
import com.google.android.gms.internal.measurement.C2120g;
import com.google.android.gms.internal.measurement.C2130l;
import ir.nasim.Us8;

/* loaded from: classes3.dex */
final class q4 extends p4 {
    private final C2130l g;
    final /* synthetic */ C2215b h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q4(C2215b c2215b, String str, int i, C2130l c2130l) {
        super(str, i);
        this.h = c2215b;
        this.g = c2130l;
    }

    @Override // com.google.android.gms.measurement.internal.p4
    final int a() {
        return this.g.A();
    }

    @Override // com.google.android.gms.measurement.internal.p4
    final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.p4
    final boolean c() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean k(Long l, Long l2, C2112d0 c2112d0, boolean z) {
        Us8.b();
        boolean zB = this.h.a.z().B(this.a, S0.W);
        boolean zG = this.g.G();
        boolean zH = this.g.H();
        boolean zI = this.g.I();
        Object[] objArr = zG || zH || zI;
        Boolean boolJ = null;
        boolJ = null;
        boolJ = null;
        boolJ = null;
        boolJ = null;
        if (z && objArr != true) {
            this.h.a.b().v().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.b), this.g.J() ? Integer.valueOf(this.g.A()) : null);
            return true;
        }
        C2120g c2120gB = this.g.B();
        boolean zG2 = c2120gB.G();
        if (c2112d0.Q()) {
            if (c2120gB.I()) {
                boolJ = p4.j(p4.h(c2112d0.B(), c2120gB.C()), zG2);
            } else {
                this.h.a.b().w().b("No number filter for long property. property", this.h.a.D().f(c2112d0.F()));
            }
        } else if (c2112d0.P()) {
            if (c2120gB.I()) {
                boolJ = p4.j(p4.g(c2112d0.A(), c2120gB.C()), zG2);
            } else {
                this.h.a.b().w().b("No number filter for double property. property", this.h.a.D().f(c2112d0.F()));
            }
        } else if (!c2112d0.T()) {
            this.h.a.b().w().b("User property has no value, property", this.h.a.D().f(c2112d0.F()));
        } else if (c2120gB.K()) {
            boolJ = p4.j(p4.f(c2112d0.G(), c2120gB.D(), this.h.a.b()), zG2);
        } else if (!c2120gB.I()) {
            this.h.a.b().w().b("No string or number filter defined. property", this.h.a.D().f(c2112d0.F()));
        } else if (a4.N(c2112d0.G())) {
            boolJ = p4.j(p4.i(c2112d0.G(), c2120gB.C()), zG2);
        } else {
            this.h.a.b().w().c("Invalid user property value for Numeric number filter. property, value", this.h.a.D().f(c2112d0.F()), c2112d0.G());
        }
        this.h.a.b().v().b("Property filter result", boolJ == null ? "null" : boolJ);
        if (boolJ == null) {
            return false;
        }
        this.c = Boolean.TRUE;
        if (zI && !boolJ.booleanValue()) {
            return true;
        }
        if (!z || this.g.G()) {
            this.d = boolJ;
        }
        if (boolJ.booleanValue() && objArr != false && c2112d0.R()) {
            long jC = c2112d0.C();
            if (l != null) {
                jC = l.longValue();
            }
            if (zB && this.g.G() && !this.g.H() && l2 != null) {
                jC = l2.longValue();
            }
            if (this.g.H()) {
                this.f = Long.valueOf(jC);
            } else {
                this.e = Long.valueOf(jC);
            }
        }
        return true;
    }
}
