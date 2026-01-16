package ir.nasim;

/* renamed from: ir.nasim.bd0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10443bd0 {
    public static final a h = new a(null);
    public static final int i = 8;
    private final C13245fu a;
    private final long b;
    private final C13774gn7 c;
    private final InterfaceC11600dH4 d;
    private final C4067Dn7 e;
    private long f;
    private C13245fu g;

    /* renamed from: ir.nasim.bd0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ AbstractC10443bd0(C13245fu c13245fu, long j, C13774gn7 c13774gn7, InterfaceC11600dH4 interfaceC11600dH4, C4067Dn7 c4067Dn7, ED1 ed1) {
        this(c13245fu, j, c13774gn7, interfaceC11600dH4, c4067Dn7);
    }

    private final AbstractC10443bd0 C() {
        int iL;
        v().b();
        if (w().length() > 0 && (iL = l()) != -1) {
            T(iL);
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final AbstractC10443bd0 E() {
        Integer numM;
        v().b();
        if (w().length() > 0 && (numM = m()) != null) {
            T(numM.intValue());
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final AbstractC10443bd0 F() {
        int iQ;
        v().b();
        if (w().length() > 0 && (iQ = q()) != -1) {
            T(iQ);
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final AbstractC10443bd0 H() {
        Integer numT;
        v().b();
        if (w().length() > 0 && (numT = t()) != null) {
            T(numT.intValue());
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final int V() {
        return this.d.b(C4301En7.i(this.f));
    }

    private final int W() {
        return this.d.b(C4301En7.k(this.f));
    }

    private final int X() {
        return this.d.b(C4301En7.l(this.f));
    }

    private final int a(int i2) {
        return AbstractC23053wG5.i(i2, w().length() - 1);
    }

    private final int g(C13774gn7 c13774gn7, int i2) {
        return this.d.a(c13774gn7.o(c13774gn7.q(i2), true));
    }

    static /* synthetic */ int h(AbstractC10443bd0 abstractC10443bd0, C13774gn7 c13774gn7, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
        }
        if ((i3 & 1) != 0) {
            i2 = abstractC10443bd0.W();
        }
        return abstractC10443bd0.g(c13774gn7, i2);
    }

    private final int j(C13774gn7 c13774gn7, int i2) {
        return this.d.a(c13774gn7.u(c13774gn7.q(i2)));
    }

    static /* synthetic */ int k(AbstractC10443bd0 abstractC10443bd0, C13774gn7 c13774gn7, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
        }
        if ((i3 & 1) != 0) {
            i2 = abstractC10443bd0.X();
        }
        return abstractC10443bd0.j(c13774gn7, i2);
    }

    private final int n(C13774gn7 c13774gn7, int i2) {
        while (i2 < this.a.length()) {
            long jC = c13774gn7.C(a(i2));
            if (C4301En7.i(jC) > i2) {
                return this.d.a(C4301En7.i(jC));
            }
            i2++;
        }
        return this.a.length();
    }

    static /* synthetic */ int o(AbstractC10443bd0 abstractC10443bd0, C13774gn7 c13774gn7, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
        }
        if ((i3 & 1) != 0) {
            i2 = abstractC10443bd0.V();
        }
        return abstractC10443bd0.n(c13774gn7, i2);
    }

    private final int r(C13774gn7 c13774gn7, int i2) {
        while (i2 > 0) {
            long jC = c13774gn7.C(a(i2));
            if (C4301En7.n(jC) < i2) {
                return this.d.a(C4301En7.n(jC));
            }
            i2--;
        }
        return 0;
    }

    static /* synthetic */ int s(AbstractC10443bd0 abstractC10443bd0, C13774gn7 c13774gn7, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
        }
        if ((i3 & 1) != 0) {
            i2 = abstractC10443bd0.V();
        }
        return abstractC10443bd0.r(c13774gn7, i2);
    }

    private final boolean x() {
        C13774gn7 c13774gn7 = this.c;
        return (c13774gn7 != null ? c13774gn7.y(V()) : null) != AW5.b;
    }

    private final int y(C13774gn7 c13774gn7, int i2) {
        int iV = V();
        if (this.e.a() == null) {
            this.e.c(Float.valueOf(c13774gn7.e(iV).i()));
        }
        int iQ = c13774gn7.q(iV) + i2;
        if (iQ < 0) {
            return 0;
        }
        if (iQ >= c13774gn7.n()) {
            return w().length();
        }
        float fM = c13774gn7.m(iQ) - 1;
        Float fA = this.e.a();
        AbstractC13042fc3.f(fA);
        float fFloatValue = fA.floatValue();
        if ((x() && fFloatValue >= c13774gn7.t(iQ)) || (!x() && fFloatValue <= c13774gn7.s(iQ))) {
            return c13774gn7.o(iQ, true);
        }
        return this.d.a(c13774gn7.x(ZG4.e((Float.floatToRawIntBits(fA.floatValue()) << 32) | (Float.floatToRawIntBits(fM) & 4294967295L))));
    }

    public final AbstractC10443bd0 A() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                F();
            } else {
                C();
            }
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 B() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                H();
            } else {
                E();
            }
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 D() {
        v().b();
        if (w().length() > 0) {
            int iA = IY6.a(w(), C4301En7.k(this.f));
            if (iA == C4301En7.k(this.f) && iA != w().length()) {
                iA = IY6.a(w(), iA + 1);
            }
            T(iA);
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 G() {
        v().b();
        if (w().length() > 0) {
            int iB = IY6.b(w(), C4301En7.l(this.f));
            if (iB == C4301En7.l(this.f) && iB != 0) {
                iB = IY6.b(w(), iB - 1);
            }
            T(iB);
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 I() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                C();
            } else {
                F();
            }
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 J() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                E();
            } else {
                H();
            }
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 K() {
        v().b();
        if (w().length() > 0) {
            T(w().length());
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 L() {
        v().b();
        if (w().length() > 0) {
            T(0);
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 M() {
        Integer numF;
        v().b();
        if (w().length() > 0 && (numF = f()) != null) {
            T(numF.intValue());
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 N() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                P();
            } else {
                M();
            }
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 O() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                M();
            } else {
                P();
            }
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 P() {
        Integer numI;
        v().b();
        if (w().length() > 0 && (numI = i()) != null) {
            T(numI.intValue());
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 Q() {
        C13774gn7 c13774gn7;
        if (w().length() > 0 && (c13774gn7 = this.c) != null) {
            T(y(c13774gn7, -1));
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 R() {
        v().b();
        if (w().length() > 0) {
            U(0, w().length());
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 S() {
        if (w().length() > 0) {
            this.f = AbstractC4535Fn7.b(C4301En7.n(this.b), C4301En7.i(this.f));
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    protected final void T(int i2) {
        U(i2, i2);
    }

    protected final void U(int i2, int i3) {
        this.f = AbstractC4535Fn7.b(i2, i3);
    }

    public final AbstractC10443bd0 b(UA2 ua2) {
        v().b();
        if (w().length() > 0) {
            if (C4301En7.h(this.f)) {
                AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
                ua2.invoke(this);
            } else if (x()) {
                T(C4301En7.l(this.f));
            } else {
                T(C4301En7.k(this.f));
            }
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 c(UA2 ua2) {
        v().b();
        if (w().length() > 0) {
            if (C4301En7.h(this.f)) {
                AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
                ua2.invoke(this);
            } else if (x()) {
                T(C4301En7.k(this.f));
            } else {
                T(C4301En7.l(this.f));
            }
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AbstractC10443bd0 d() {
        v().b();
        if (w().length() > 0) {
            T(C4301En7.i(this.f));
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final C13245fu e() {
        return this.g;
    }

    public final Integer f() {
        C13774gn7 c13774gn7 = this.c;
        if (c13774gn7 != null) {
            return Integer.valueOf(h(this, c13774gn7, 0, 1, null));
        }
        return null;
    }

    public final Integer i() {
        C13774gn7 c13774gn7 = this.c;
        if (c13774gn7 != null) {
            return Integer.valueOf(k(this, c13774gn7, 0, 1, null));
        }
        return null;
    }

    public final int l() {
        return JY6.a(this.g.k(), C4301En7.i(this.f));
    }

    public final Integer m() {
        C13774gn7 c13774gn7 = this.c;
        if (c13774gn7 != null) {
            return Integer.valueOf(o(this, c13774gn7, 0, 1, null));
        }
        return null;
    }

    public final InterfaceC11600dH4 p() {
        return this.d;
    }

    public final int q() {
        return JY6.b(this.g.k(), C4301En7.i(this.f));
    }

    public final Integer t() {
        C13774gn7 c13774gn7 = this.c;
        if (c13774gn7 != null) {
            return Integer.valueOf(s(this, c13774gn7, 0, 1, null));
        }
        return null;
    }

    public final long u() {
        return this.f;
    }

    public final C4067Dn7 v() {
        return this.e;
    }

    public final String w() {
        return this.g.k();
    }

    public final AbstractC10443bd0 z() {
        C13774gn7 c13774gn7;
        if (w().length() > 0 && (c13774gn7 = this.c) != null) {
            T(y(c13774gn7, 1));
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private AbstractC10443bd0(C13245fu c13245fu, long j, C13774gn7 c13774gn7, InterfaceC11600dH4 interfaceC11600dH4, C4067Dn7 c4067Dn7) {
        this.a = c13245fu;
        this.b = j;
        this.c = c13774gn7;
        this.d = interfaceC11600dH4;
        this.e = c4067Dn7;
        this.f = j;
        this.g = c13245fu;
    }
}
