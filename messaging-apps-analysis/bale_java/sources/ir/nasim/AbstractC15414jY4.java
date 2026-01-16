package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.EX4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.WX4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.jY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC15414jY4 {
    private static final void h(final VX4 vx4, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(281955506);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(vx4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (vx4 != VX4.a) {
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1J.W(57818936);
            boolean z = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.hY4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15414jY4.i(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            WE.c((SA2) objB, interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.iY4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15414jY4.j(vx4, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        ua2.invoke(WX4.c.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(VX4 vx4, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(vx4, "$dialogState");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        h(vx4, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void k(final EnumC10399bY4 enumC10399bY4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2016592143);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(enumC10399bY4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (enumC10399bY4 == EnumC10399bY4.a) {
            interfaceC22053ub1J.W(1659465796);
            CG3.j(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.a(interfaceC22053ub1J, G10.b).r(), interfaceC22053ub1J, 6, 0);
            interfaceC22053ub1J.Q();
        } else if (enumC10399bY4 == EnumC10399bY4.b) {
            interfaceC22053ub1J.W(1659686268);
            CG3.g(null, null, null, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.Q();
        } else {
            interfaceC22053ub1J.W(1659719903);
            interfaceC22053ub1J.Q();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.gY4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15414jY4.l(enumC10399bY4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(EnumC10399bY4 enumC10399bY4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(enumC10399bY4, "$loadingState");
        k(enumC10399bY4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void m(final C17187mY4 c17187mY4, final C19391qG6 c19391qG6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c17187mY4, "state");
        AbstractC13042fc3.i(c19391qG6, "snackBarState");
        AbstractC13042fc3.i(ua2, "onViewModelEvent");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(375329511);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c17187mY4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c19391qG6) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C19777qv2 c19777qv2F = c17187mY4.f();
            interfaceC22053ub1J.W(699439969);
            int i3 = i2 & 896;
            boolean z = i3 == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new InterfaceC14603iB2() { // from class: ir.nasim.cY4
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC15414jY4.n(ua2, (BX4) obj, (EX4.a) obj2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(699444956);
            boolean z2 = i3 == 256;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new InterfaceC14603iB2() { // from class: ir.nasim.dY4
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC15414jY4.o(ua2, (BX4) obj, (EX4) obj2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            TX4.x(c19777qv2F, new C19186pv2(interfaceC14603iB2, (InterfaceC14603iB2) objB2), interfaceC22053ub1J, 0);
            int i4 = i2 >> 3;
            q(c19391qG6, interfaceC22053ub1J, i4 & 14);
            VX4 vx4E = c17187mY4.e();
            interfaceC22053ub1J.W(699451059);
            if (vx4E != null) {
                h(vx4E, ua2, interfaceC22053ub1J, i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            EnumC10399bY4 enumC10399bY4G = c17187mY4.g();
            if (enumC10399bY4G != null) {
                k(enumC10399bY4G, interfaceC22053ub1J, 0);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.eY4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15414jY4.p(c17187mY4, c19391qG6, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(UA2 ua2, BX4 bx4, EX4.a aVar) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        AbstractC13042fc3.i(bx4, "field");
        AbstractC13042fc3.i(aVar, "fieldType");
        ua2.invoke(new WX4.a(bx4, aVar));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(UA2 ua2, BX4 bx4, EX4 ex4) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        AbstractC13042fc3.i(bx4, "field");
        AbstractC13042fc3.i(ex4, "fieldType");
        ua2.invoke(new WX4.b(bx4, ex4));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C17187mY4 c17187mY4, C19391qG6 c19391qG6, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c17187mY4, "$state");
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        m(c17187mY4, c19391qG6, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void q(final C19391qG6 c19391qG6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2116685857);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c19391qG6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            AbstractC18209oG6.b(c19391qG6, androidx.compose.foundation.layout.h.a.h(aVar, aVar2.b()), C16347l71.a.a(), interfaceC22053ub1J, (i2 & 14) | 384, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fY4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15414jY4.r(c19391qG6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(C19391qG6 c19391qG6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        q(c19391qG6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
