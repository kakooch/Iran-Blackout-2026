package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;

/* loaded from: classes.dex */
public abstract class J66 {
    private static final InterfaceC10970cW3 a = new K66(C24254yJ.a.g(), InterfaceC12529em.a.l());

    public static final long a(boolean z, int i, int i2, int i3, int i4) {
        return !z ? AbstractC19606qe1.a(i, i3, i2, i4) : C17833ne1.b.b(i, i3, i2, i4);
    }

    public static final InterfaceC10970cW3 b(C24254yJ.e eVar, InterfaceC12529em.c cVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC10970cW3 interfaceC10970cW3;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-837807694, i, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:121)");
        }
        if (AbstractC13042fc3.d(eVar, C24254yJ.a.g()) && AbstractC13042fc3.d(cVar, InterfaceC12529em.a.l())) {
            interfaceC22053ub1.W(-848964613);
            interfaceC22053ub1.Q();
            interfaceC10970cW3 = a;
        } else {
            interfaceC22053ub1.W(-848913742);
            boolean z = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(eVar)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(cVar)) || (i & 48) == 32);
            Object objB = interfaceC22053ub1.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new K66(eVar, cVar);
                interfaceC22053ub1.s(objB);
            }
            interfaceC10970cW3 = (K66) objB;
            interfaceC22053ub1.Q();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC10970cW3;
    }
}
