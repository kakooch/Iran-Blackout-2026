package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.qq2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19727qq2 {
    public static final C19727qq2 a = new C19727qq2();

    private C19727qq2() {
    }

    public final InterfaceC20336rq2 a(float f, float f2, float f3, float f4, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            f = C17784nZ1.q(6);
        }
        float f5 = f;
        if ((i2 & 2) != 0) {
            f2 = C17784nZ1.q(12);
        }
        float f6 = f2;
        if ((i2 & 4) != 0) {
            f3 = C17784nZ1.q(8);
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = C17784nZ1.q(8);
        }
        float f8 = f4;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(380403812, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:238)");
        }
        boolean z = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.c(f5)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.c(f6)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && interfaceC22053ub1.c(f7)) || (i & 384) == 256) | ((((i & 7168) ^ SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) > 2048 && interfaceC22053ub1.c(f8)) || (i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 2048);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new WD1(f5, f6, f7, f8, null);
            interfaceC22053ub1.s(objB);
        }
        WD1 wd1 = (WD1) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return wd1;
    }
}
