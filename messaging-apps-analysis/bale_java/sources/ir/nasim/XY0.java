package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;

/* loaded from: classes.dex */
public abstract class XY0 {
    private static final InterfaceC10970cW3 a = new YY0(C24254yJ.a.h(), InterfaceC12529em.a.k());

    public static final InterfaceC10970cW3 a(C24254yJ.m mVar, InterfaceC12529em.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC10970cW3 interfaceC10970cW3;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1089876336, i, -1, "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:108)");
        }
        if (AbstractC13042fc3.d(mVar, C24254yJ.a.h()) && AbstractC13042fc3.d(bVar, InterfaceC12529em.a.k())) {
            interfaceC22053ub1.W(346089448);
            interfaceC22053ub1.Q();
            interfaceC10970cW3 = a;
        } else {
            interfaceC22053ub1.W(346143295);
            boolean z = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(mVar)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(bVar)) || (i & 48) == 32);
            Object objB = interfaceC22053ub1.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new YY0(mVar, bVar);
                interfaceC22053ub1.s(objB);
            }
            interfaceC10970cW3 = (YY0) objB;
            interfaceC22053ub1.Q();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC10970cW3;
    }

    public static final long b(boolean z, int i, int i2, int i3, int i4) {
        return !z ? AbstractC19606qe1.a(i2, i4, i, i3) : C17833ne1.b.a(i2, i4, i, i3);
    }
}
