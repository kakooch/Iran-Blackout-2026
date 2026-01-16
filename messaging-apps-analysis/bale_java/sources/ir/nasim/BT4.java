package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes.dex */
public abstract class BT4 {
    public static final InterfaceC6030Lw3 a(GT4 gt4, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-786344289, i, -1, "androidx.compose.foundation.pager.rememberPagerSemanticState (PagerSemantics.kt:26)");
        }
        boolean z2 = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(gt4)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.a(z)) || (i & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            objB = AbstractC6264Mw3.a(gt4, z);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC6030Lw3 interfaceC6030Lw3 = (InterfaceC6030Lw3) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC6030Lw3;
    }
}
