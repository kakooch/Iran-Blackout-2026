package ir.nasim;

/* renamed from: ir.nasim.ta8, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC21393ta8 {
    public static final A98 a(int i, int i2, int i3, int i4) {
        return new C17353mp2(i, i2, i3, i4);
    }

    public static final A98 b(float f, float f2, float f3, float f4) {
        return new C16171kp2(f, f2, f3, f4, null);
    }

    public static /* synthetic */ A98 c(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C17784nZ1.q(0);
        }
        if ((i & 2) != 0) {
            f2 = C17784nZ1.q(0);
        }
        if ((i & 4) != 0) {
            f3 = C17784nZ1.q(0);
        }
        if ((i & 8) != 0) {
            f4 = C17784nZ1.q(0);
        }
        return b(f, f2, f3, f4);
    }

    public static final TS4 d(A98 a98, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1485016250, i, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:220)");
        }
        O93 o93 = new O93(a98, (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g()));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return o93;
    }

    public static final TS4 e(A98 a98, WH1 wh1) {
        return new O93(a98, wh1);
    }

    public static final A98 f(A98 a98, A98 a982) {
        return new C7765Tc2(a98, a982);
    }

    public static final A98 g(A98 a98, int i) {
        return new C24657yz3(a98, i, null);
    }

    public static final A98 h(A98 a98, A98 a982) {
        return new C19347qB7(a98, a982);
    }
}
