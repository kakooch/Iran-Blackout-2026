package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.gY, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC13618gY {
    public static final void d(final C22023uY c22023uY, final SA2 sa2, final UA2 ua2, final UA2 ua22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c22023uY, "contact");
        AbstractC13042fc3.i(sa2, "onDismiss");
        AbstractC13042fc3.i(ua2, "onEditName");
        AbstractC13042fc3.i(ua22, "onRemoveFromContacts");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1319623072);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c22023uY) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua22) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            String strC = UY6.c(ED5.contacts_menu_edit, interfaceC22053ub1J, 0);
            int i3 = AbstractC15799kB5.edit;
            interfaceC22053ub1J.W(590680226);
            int i4 = i2 & 14;
            boolean z = ((i2 & 896) == 256) | (i4 == 4);
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.dY
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13618gY.e(ua2, c22023uY);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            C7847Tl1 c7847Tl1 = new C7847Tl1(strC, i3, 0, (SA2) objB, 4, null);
            String strO = AbstractC20153rZ6.O(UY6.c(ED5.contacts_menu_remove, interfaceC22053ub1J, 0), "{0}", c22023uY.e(), false, 4, null);
            int i5 = AbstractC15799kB5.remove;
            interfaceC22053ub1J.W(590686144);
            boolean z2 = ((i2 & 7168) == 2048) | (i4 == 4);
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.eY
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13618gY.f(ua22, c22023uY);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9090Yl1.b(0L, AbstractC10360bX0.p(c7847Tl1, new C7847Tl1(strO, i5, 0, (SA2) objB2, 4, null)), true, sa2, 0L, 0L, 0L, interfaceC22053ub12, (C7847Tl1.e << 3) | 384 | ((i2 << 6) & 7168), 113);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fY
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13618gY.g(c22023uY, sa2, ua2, ua22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(UA2 ua2, C22023uY c22023uY) {
        AbstractC13042fc3.i(ua2, "$onEditName");
        AbstractC13042fc3.i(c22023uY, "$contact");
        ua2.invoke(c22023uY);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(UA2 ua2, C22023uY c22023uY) {
        AbstractC13042fc3.i(ua2, "$onRemoveFromContacts");
        AbstractC13042fc3.i(c22023uY, "$contact");
        ua2.invoke(c22023uY);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(C22023uY c22023uY, SA2 sa2, UA2 ua2, UA2 ua22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c22023uY, "$contact");
        AbstractC13042fc3.i(sa2, "$onDismiss");
        AbstractC13042fc3.i(ua2, "$onEditName");
        AbstractC13042fc3.i(ua22, "$onRemoveFromContacts");
        d(c22023uY, sa2, ua2, ua22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
