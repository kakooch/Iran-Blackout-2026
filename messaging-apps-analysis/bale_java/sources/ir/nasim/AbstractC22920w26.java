package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.w26, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22920w26 {
    private static final C7479Rw7 a = new C7479Rw7(15, 0, T22.e(), 2, null);

    public static final JG1 c(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, VX0 vx0, SA2 sa2) {
        return A26.d(interfaceC23241wb3, z, f, vx0, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC5766Kt d(InterfaceC22645vb3 interfaceC22645vb3) {
        return interfaceC22645vb3 instanceof C12403eZ2 ? a : interfaceC22645vb3 instanceof C23400wr2 ? new C7479Rw7(45, 0, T22.e(), 2, null) : interfaceC22645vb3 instanceof GZ1 ? new C7479Rw7(45, 0, T22.e(), 2, null) : a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC5766Kt e(InterfaceC22645vb3 interfaceC22645vb3) {
        return interfaceC22645vb3 instanceof C12403eZ2 ? a : interfaceC22645vb3 instanceof C23400wr2 ? a : interfaceC22645vb3 instanceof GZ1 ? new C7479Rw7(150, 0, T22.e(), 2, null) : a;
    }

    public static final InterfaceC16339l63 f(boolean z, float f, long j, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        boolean z2 = true;
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            f = C17784nZ1.b.c();
        }
        if ((i2 & 4) != 0) {
            j = C24381yX0.b.i();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1635163520, i, -1, "androidx.compose.material.ripple.rememberRipple (Ripple.kt:144)");
        }
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(C24381yX0.k(j), interfaceC22053ub1, (i >> 6) & 14);
        boolean z3 = (((i & 14) ^ 6) > 4 && interfaceC22053ub1.a(z)) || (i & 6) == 4;
        if ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) <= 32 || !interfaceC22053ub1.c(f)) && (i & 48) != 32) {
            z2 = false;
        }
        boolean z4 = z3 | z2;
        Object objB = interfaceC22053ub1.B();
        if (z4 || objB == InterfaceC22053ub1.a.a()) {
            objB = new C19029pf5(z, f, interfaceC9664aL6Q, null);
            interfaceC22053ub1.s(objB);
        }
        C19029pf5 c19029pf5 = (C19029pf5) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c19029pf5;
    }
}
