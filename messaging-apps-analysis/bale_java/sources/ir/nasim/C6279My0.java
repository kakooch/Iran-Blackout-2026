package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.My0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6279My0 implements InterfaceC5812Ky0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(C6279My0 c6279My0, InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, SA2 sa2, Integer num, UA2 ua22, UA2 ua23, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22, SA2 sa23, UA2 ua24, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c6279My0, "$tmp0_rcvr");
        AbstractC13042fc3.i(interfaceC10258bL6, "$callState");
        AbstractC13042fc3.i(ua2, "$openSpeakerBottomSheet");
        AbstractC13042fc3.i(sa2, "$openInviteBottomSheet");
        AbstractC13042fc3.i(ua22, "$showCallErrorsSnackbar");
        AbstractC13042fc3.i(ua23, "$openUserChat");
        AbstractC13042fc3.i(interfaceC14603iB2, "$showKickUserDialog");
        AbstractC13042fc3.i(sa22, "$onCopyCallLink");
        AbstractC13042fc3.i(sa23, "$onShareCallLink");
        AbstractC13042fc3.i(ua24, "$copyToClipBoard");
        c6279My0.a(interfaceC10258bL6, ua2, sa2, num, ua22, ua23, interfaceC14603iB2, sa22, sa23, ua24, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2));
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC5812Ky0
    public void a(final InterfaceC10258bL6 interfaceC10258bL6, final UA2 ua2, final SA2 sa2, final Integer num, final UA2 ua22, final UA2 ua23, final InterfaceC14603iB2 interfaceC14603iB2, final SA2 sa22, final SA2 sa23, final UA2 ua24, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC10258bL6, "callState");
        AbstractC13042fc3.i(ua2, "openSpeakerBottomSheet");
        AbstractC13042fc3.i(sa2, "openInviteBottomSheet");
        AbstractC13042fc3.i(ua22, "showCallErrorsSnackbar");
        AbstractC13042fc3.i(ua23, "openUserChat");
        AbstractC13042fc3.i(interfaceC14603iB2, "showKickUserDialog");
        AbstractC13042fc3.i(sa22, "onCopyCallLink");
        AbstractC13042fc3.i(sa23, "onShareCallLink");
        AbstractC13042fc3.i(ua24, "copyToClipBoard");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-525881816);
        if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(num) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(ua22) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(ua23) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(sa23) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(ua24) ? 536870912 : 268435456;
        }
        if ((306783379 & i3) == 306783378 && (i2 & 1) == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC8431Vy0.i(interfaceC10258bL6, ua2, sa2, num, ua22, ua23, interfaceC14603iB2, sa22, sa23, ua24, null, interfaceC22053ub12, (i3 & 14) | (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (i3 & 1879048192), 0, 1024);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ly0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C6279My0.c(this.a, interfaceC10258bL6, ua2, sa2, num, ua22, ua23, interfaceC14603iB2, sa22, sa23, ua24, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
