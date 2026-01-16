package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.Pw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6997Pw3 {
    public static final InterfaceC16242kw3 a(C19206px3 c19206px3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1877443446, i2, -1, "androidx.compose.foundation.lazy.rememberLazyListBeyondBoundsState (LazyListBeyondBoundsModifier.kt:27)");
        }
        boolean z = ((((i2 & 14) ^ 6) > 4 && interfaceC22053ub1.V(c19206px3)) || (i2 & 6) == 4) | ((((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i)) || (i2 & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new C7241Qw3(c19206px3, i);
            interfaceC22053ub1.s(objB);
        }
        C7241Qw3 c7241Qw3 = (C7241Qw3) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c7241Qw3;
    }
}
