package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes.dex */
final class OD1 implements G52 {
    public static final OD1 a = new OD1();

    private OD1() {
    }

    @Override // ir.nasim.G52
    public long a(long j, float f, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-1687113661);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1687113661, i, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:67)");
        }
        UY0 uy0A = C15977kV3.a.a(interfaceC22053ub1, 6);
        if (C17784nZ1.p(f, C17784nZ1.q(0)) <= 0 || uy0A.o()) {
            interfaceC22053ub1.W(1169156439);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(1169017931);
            j = DX0.h(H52.b(j, f, interfaceC22053ub1, (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 14)), j);
            interfaceC22053ub1.Q();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return j;
    }
}
