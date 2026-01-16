package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* loaded from: classes.dex */
public abstract class QG0 {
    public static final void a(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, C10493bi0 c10493bi0, float f, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        androidx.compose.ui.e eVar2 = (i2 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
        InterfaceC10031ax6 interfaceC10031ax6D = (i2 & 2) != 0 ? C15977kV3.a.b(interfaceC22053ub1, 6).d() : interfaceC10031ax6;
        long jN = (i2 & 4) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).n() : j;
        long jB = (i2 & 8) != 0 ? VY0.b(jN, interfaceC22053ub1, (i >> 6) & 14) : j2;
        C10493bi0 c10493bi02 = (i2 & 16) != 0 ? null : c10493bi0;
        float fQ = (i2 & 32) != 0 ? C17784nZ1.q(1) : f;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1956755640, i, -1, "androidx.compose.material.Card (Card.kt:64)");
        }
        E27.a(eVar2, interfaceC10031ax6D, jN, jB, c10493bi02, fQ, interfaceC14603iB2, interfaceC22053ub1, (i & 14) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (i & 3670016), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void b(SA2 sa2, androidx.compose.ui.e eVar, boolean z, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, C10493bi0 c10493bi0, float f, InterfaceC18507om4 interfaceC18507om4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        androidx.compose.ui.e eVar2 = (i2 & 2) != 0 ? androidx.compose.ui.e.a : eVar;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        InterfaceC10031ax6 interfaceC10031ax6D = (i2 & 8) != 0 ? C15977kV3.a.b(interfaceC22053ub1, 6).d() : interfaceC10031ax6;
        long jN = (i2 & 16) != 0 ? C15977kV3.a.a(interfaceC22053ub1, 6).n() : j;
        long jB = (i2 & 32) != 0 ? VY0.b(jN, interfaceC22053ub1, (i >> 12) & 14) : j2;
        C10493bi0 c10493bi02 = (i2 & 64) != 0 ? null : c10493bi0;
        float fQ = (i2 & 128) != 0 ? C17784nZ1.q(1) : f;
        InterfaceC18507om4 interfaceC18507om42 = (i2 & 256) == 0 ? interfaceC18507om4 : null;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(778538979, i, -1, "androidx.compose.material.Card (Card.kt:116)");
        }
        E27.b(sa2, eVar2, z2, interfaceC10031ax6D, jN, jB, c10493bi02, fQ, interfaceC18507om42, interfaceC14603iB2, interfaceC22053ub1, (i & 14) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (3670016 & i) | (29360128 & i) | (234881024 & i) | (i & 1879048192), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }
}
