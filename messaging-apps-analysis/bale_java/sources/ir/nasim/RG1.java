package ir.nasim;

import androidx.compose.ui.e;

/* loaded from: classes2.dex */
public abstract class RG1 extends e.c {
    private final int o = AbstractC10166bB4.g(this);
    private e.c p;

    private final void A2(int i, e.c cVar) {
        int iW1 = W1();
        if ((i & AbstractC9572aB4.a(2)) == 0 || (AbstractC9572aB4.a(2) & iW1) == 0 || (this instanceof InterfaceC21655tu3)) {
            return;
        }
        M73.b("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + cVar);
    }

    private final void z2(int i, boolean z) {
        e.c cVarS1;
        int iW1 = W1();
        p2(i);
        if (iW1 != i) {
            if (KG1.g(this)) {
                k2(i);
            }
            if (b2()) {
                e.c cVarH = h();
                e.c cVarY1 = this;
                while (cVarY1 != null) {
                    i |= cVarY1.W1();
                    cVarY1.p2(i);
                    if (cVarY1 == cVarH) {
                        break;
                    } else {
                        cVarY1 = cVarY1.Y1();
                    }
                }
                if (z && cVarY1 == cVarH) {
                    i = AbstractC10166bB4.h(cVarH);
                    cVarH.p2(i);
                }
                int iR1 = i | ((cVarY1 == null || (cVarS1 = cVarY1.S1()) == null) ? 0 : cVarS1.R1());
                while (cVarY1 != null) {
                    iR1 |= cVarY1.W1();
                    cVarY1.k2(iR1);
                    cVarY1 = cVarY1.Y1();
                }
            }
        }
    }

    @Override // androidx.compose.ui.e.c
    public void c2() {
        super.c2();
        for (e.c cVarW2 = w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            cVarW2.u2(T1());
            if (!cVarW2.b2()) {
                cVarW2.c2();
            }
        }
    }

    @Override // androidx.compose.ui.e.c
    public void d2() {
        for (e.c cVarW2 = w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            cVarW2.d2();
        }
        super.d2();
    }

    @Override // androidx.compose.ui.e.c
    public void h2() {
        super.h2();
        for (e.c cVarW2 = w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            cVarW2.h2();
        }
    }

    @Override // androidx.compose.ui.e.c
    public void i2() {
        for (e.c cVarW2 = w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            cVarW2.i2();
        }
        super.i2();
    }

    @Override // androidx.compose.ui.e.c
    public void j2() {
        super.j2();
        for (e.c cVarW2 = w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            cVarW2.j2();
        }
    }

    @Override // androidx.compose.ui.e.c
    public void l2(e.c cVar) {
        super.l2(cVar);
        for (e.c cVarW2 = w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            cVarW2.l2(cVar);
        }
    }

    @Override // androidx.compose.ui.e.c
    public void u2(XA4 xa4) {
        super.u2(xa4);
        for (e.c cVarW2 = w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            cVarW2.u2(xa4);
        }
    }

    protected final JG1 v2(JG1 jg1) {
        e.c cVarH = jg1.h();
        if (cVarH != jg1) {
            e.c cVar = jg1 instanceof e.c ? (e.c) jg1 : null;
            e.c cVarY1 = cVar != null ? cVar.Y1() : null;
            if (cVarH == h() && AbstractC13042fc3.d(cVarY1, this)) {
                return jg1;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        }
        if (!(!cVarH.b2())) {
            M73.b("Cannot delegate to an already attached node");
        }
        cVarH.l2(h());
        int iW1 = W1();
        int iH = AbstractC10166bB4.h(cVarH);
        cVarH.p2(iH);
        A2(iH, cVarH);
        cVarH.m2(this.p);
        this.p = cVarH;
        cVarH.r2(this);
        z2(W1() | iH, false);
        if (b2()) {
            if ((iH & AbstractC9572aB4.a(2)) == 0 || (iW1 & AbstractC9572aB4.a(2)) != 0) {
                u2(T1());
            } else {
                VA4 va4T0 = KG1.o(this).t0();
                h().u2(null);
                va4T0.D();
            }
            cVarH.c2();
            cVarH.i2();
            AbstractC10166bB4.a(cVarH);
        }
        return jg1;
    }

    public final e.c w2() {
        return this.p;
    }

    public final int x2() {
        return this.o;
    }

    protected final void y2(JG1 jg1) {
        e.c cVar = null;
        for (e.c cVarS1 = this.p; cVarS1 != null; cVarS1 = cVarS1.S1()) {
            if (cVarS1 == jg1) {
                if (cVarS1.b2()) {
                    AbstractC10166bB4.d(cVarS1);
                    cVarS1.j2();
                    cVarS1.d2();
                }
                cVarS1.l2(cVarS1);
                cVarS1.k2(0);
                if (cVar == null) {
                    this.p = cVarS1.S1();
                } else {
                    cVar.m2(cVarS1.S1());
                }
                cVarS1.m2(null);
                cVarS1.r2(null);
                int iW1 = W1();
                int iH = AbstractC10166bB4.h(this);
                z2(iH, true);
                if (b2() && (iW1 & AbstractC9572aB4.a(2)) != 0 && (AbstractC9572aB4.a(2) & iH) == 0) {
                    VA4 va4T0 = KG1.o(this).t0();
                    h().u2(null);
                    va4T0.D();
                    return;
                }
                return;
            }
            cVar = cVarS1;
        }
        throw new IllegalStateException(("Could not find delegate: " + jg1).toString());
    }
}
