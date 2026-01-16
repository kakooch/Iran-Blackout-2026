package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.In0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5245In0 {
    public static final void d(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onRetryClicked");
        AbstractC13042fc3.i(sa22, "onDeclineClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(210781454);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            String strC = UY6.c(AbstractC12217eE5.voice_call_new_recall, interfaceC22053ub1J, 0);
            int i4 = KB5.ic_call_accept_new;
            G10 g10 = G10.a;
            int i5 = G10.b;
            long jL = g10.b(interfaceC22053ub1J, i5).l();
            long jI = g10.b(interfaceC22053ub1J, i5).i();
            interfaceC22053ub1J.W(725222571);
            boolean z = (i3 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Fn0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5245In0.e(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC10623bv0.i(strC, i4, jL, jI, null, null, 0.0f, null, false, (SA2) objB, interfaceC22053ub1J, 0, 496);
            String strC2 = UY6.c(AbstractC12217eE5.voice_call_new_cancel, interfaceC22053ub1J, 0);
            int i6 = KB5.ic_call_cancel_new;
            long jH = g10.b(interfaceC22053ub1J, i5).h();
            long jI2 = g10.b(interfaceC22053ub1J, i5).i();
            interfaceC22053ub1J.W(725229933);
            boolean z2 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Gn0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5245In0.f(sa22);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC10623bv0.i(strC2, i6, jH, jI2, null, null, 0.0f, null, false, (SA2) objB2, interfaceC22053ub1J, 0, 496);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Hn0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5245In0.g(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onRetryClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDeclineClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onRetryClicked");
        AbstractC13042fc3.i(sa22, "$onDeclineClicked");
        d(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
