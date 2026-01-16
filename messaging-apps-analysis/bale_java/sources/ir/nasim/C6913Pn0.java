package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.Pn0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6913Pn0 {
    public static final C6913Pn0 a = new C6913Pn0();
    private static final float b;
    private static final float c;
    private static final TS4 d;
    private static final float e;
    private static final float f;
    private static final float g;
    private static final float h;
    private static final float i;
    private static final float j;
    private static final TS4 k;
    public static final int l = 0;

    static {
        float fQ = C17784nZ1.q(16);
        b = fQ;
        float f2 = 8;
        float fQ2 = C17784nZ1.q(f2);
        c = fQ2;
        TS4 ts4D = androidx.compose.foundation.layout.q.d(fQ, fQ2, fQ, fQ2);
        d = ts4D;
        e = C17784nZ1.q(64);
        f = C17784nZ1.q(36);
        g = C17784nZ1.q(18);
        h = C17784nZ1.q(f2);
        i = C17784nZ1.q(1);
        float fQ3 = C17784nZ1.q(f2);
        j = fQ3;
        k = androidx.compose.foundation.layout.q.d(fQ3, ts4D.c(), fQ3, ts4D.a());
    }

    private C6913Pn0() {
    }

    public final InterfaceC6180Mn0 a(long j2, long j3, long j4, long j5, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        long jH;
        long j6 = (i3 & 1) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).j() : j2;
        long jB = (i3 & 2) != 0 ? VY0.b(j6, interfaceC22053ub1, i2 & 14) : j3;
        if ((i3 & 4) != 0) {
            C15977kV3 c15977kV3 = C15977kV3.a;
            jH = DX0.h(C24381yX0.o(c15977kV3.a(interfaceC22053ub1, 6).i(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), c15977kV3.a(interfaceC22053ub1, 6).n());
        } else {
            jH = j4;
        }
        long jO = (i3 & 8) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1870371134, i2, -1, "androidx.compose.material.ButtonDefaults.buttonColors (Button.kt:415)");
        }
        C24796zD1 c24796zD1 = new C24796zD1(j6, jB, jH, jO, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c24796zD1;
    }

    public final InterfaceC7391Rn0 b(float f2, float f3, float f4, float f5, float f6, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        if ((i3 & 1) != 0) {
            f2 = C17784nZ1.q(2);
        }
        float f7 = f2;
        if ((i3 & 2) != 0) {
            f3 = C17784nZ1.q(8);
        }
        float f8 = f3;
        if ((i3 & 4) != 0) {
            f4 = C17784nZ1.q(0);
        }
        float f9 = f4;
        if ((i3 & 8) != 0) {
            f5 = C17784nZ1.q(4);
        }
        float f10 = f5;
        if ((i3 & 16) != 0) {
            f6 = C17784nZ1.q(4);
        }
        float f11 = f6;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-737170518, i2, -1, "androidx.compose.material.ButtonDefaults.elevation (Button.kt:377)");
        }
        boolean z = ((((i2 & 14) ^ 6) > 4 && interfaceC22053ub1.c(f7)) || (i2 & 6) == 4) | ((((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.c(f8)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && interfaceC22053ub1.c(f9)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) > 2048 && interfaceC22053ub1.c(f10)) || (i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 2048) | ((((57344 & i2) ^ 24576) > 16384 && interfaceC22053ub1.c(f11)) || (i2 & 24576) == 16384);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new AD1(f7, f8, f9, f10, f11, null);
            interfaceC22053ub1.s(objB);
        }
        AD1 ad1 = (AD1) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return ad1;
    }

    public final TS4 c() {
        return d;
    }

    public final float d() {
        return f;
    }

    public final float e() {
        return e;
    }

    public final C10493bi0 f(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-2091313033, i2, -1, "androidx.compose.material.ButtonDefaults.<get-outlinedBorder> (Button.kt:476)");
        }
        C10493bi0 c10493bi0A = AbstractC11256ci0.a(i, C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c10493bi0A;
    }

    public final TS4 g() {
        return k;
    }

    public final InterfaceC6180Mn0 h(long j2, long j3, long j4, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        long jN = (i3 & 1) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).n() : j2;
        long j5 = (i3 & 2) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).j() : j3;
        long jO = (i3 & 4) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-2124406093, i2, -1, "androidx.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:437)");
        }
        C24796zD1 c24796zD1 = new C24796zD1(jN, j5, jN, jO, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c24796zD1;
    }

    public final InterfaceC6180Mn0 i(long j2, long j3, long j4, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        long jH = (i3 & 1) != 0 ? C24381yX0.b.h() : j2;
        long j5 = (i3 & 2) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).j() : j3;
        long jO = (i3 & 4) != 0 ? C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1, 6).i(), C16120kk1.a.b(interfaceC22053ub1, 6), 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(182742216, i2, -1, "androidx.compose.material.ButtonDefaults.textButtonColors (Button.kt:459)");
        }
        C24796zD1 c24796zD1 = new C24796zD1(jH, j5, jH, jO, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c24796zD1;
    }
}
