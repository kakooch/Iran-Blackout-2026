package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes.dex */
public final class PF5 {
    public static final PF5 a = new PF5();
    public static final int b = 0;

    private PF5() {
    }

    public final NF5 a(long j, long j2, long j3, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        long jL = (i2 & 1) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).l() : j;
        long jO = (i2 & 2) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jO2 = (i2 & 4) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1370708026, i, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:162)");
        }
        boolean z = (((6 ^ (i & 14)) > 4 && interfaceC22053ub1.f(jL)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.f(jO)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && interfaceC22053ub1.f(jO2)) || (i & 384) == 256);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new LE1(jL, jO, jO2, null);
            interfaceC22053ub1.s(objB);
        }
        LE1 le1 = (LE1) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return le1;
    }
}
