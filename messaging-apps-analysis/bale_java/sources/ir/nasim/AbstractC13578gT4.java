package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.gT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC13578gT4 {
    public static final InterfaceC16242kw3 a(GT4 gt4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(373558254, i2, -1, "androidx.compose.foundation.pager.rememberPagerBeyondBoundsState (PagerBeyondBoundsModifier.kt:25)");
        }
        boolean z = ((((i2 & 14) ^ 6) > 4 && interfaceC22053ub1.V(gt4)) || (i2 & 6) == 4) | ((((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i)) || (i2 & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new C14169hT4(gt4, i);
            interfaceC22053ub1.s(objB);
        }
        C14169hT4 c14169hT4 = (C14169hT4) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c14169hT4;
    }
}
