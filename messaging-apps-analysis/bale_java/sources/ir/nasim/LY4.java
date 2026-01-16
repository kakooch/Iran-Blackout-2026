package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.EX4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22028uY4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public abstract class LY4 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC21371tY4.values().length];
            try {
                iArr[EnumC21371tY4.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC21371tY4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC21371tY4.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    private static final void k(final EnumC21371tY4 enumC21371tY4, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        boolean z;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(307918863);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(enumC21371tY4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int i3 = a.a[enumC21371tY4.ordinal()];
            if (i3 == 1) {
                interfaceC22053ub1J.W(-1501241516);
                interfaceC22053ub1J.W(-1501239620);
                int i4 = i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
                boolean z2 = i4 == 32;
                Object objB = interfaceC22053ub1J.B();
                if (z2 || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.DY4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return LY4.p(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(-1501235203);
                z = i4 == 32;
                Object objB2 = interfaceC22053ub1J.B();
                if (z || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.EY4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return LY4.l(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                AbstractC25183zs1.c(sa2, (SA2) objB2, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.Q();
            } else if (i3 == 2) {
                interfaceC22053ub1J.W(-1501229963);
                interfaceC22053ub1J.W(-1501228083);
                z = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
                Object objB3 = interfaceC22053ub1J.B();
                if (z || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.FY4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return LY4.m(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB3);
                }
                interfaceC22053ub1J.Q();
                WE.c((SA2) objB3, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.Q();
            } else {
                if (i3 != 3) {
                    interfaceC22053ub1J.W(-1501243126);
                    interfaceC22053ub1J.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1J.W(-1501223261);
                interfaceC22053ub1J.W(-1501221443);
                z = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
                Object objB4 = interfaceC22053ub1J.B();
                if (z || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.GY4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return LY4.n(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB4);
                }
                interfaceC22053ub1J.Q();
                AX4.c((SA2) objB4, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.HY4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LY4.o(enumC21371tY4, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        ua2.invoke(new InterfaceC22028uY4.f(false));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        ua2.invoke(InterfaceC22028uY4.g.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        ua2.invoke(InterfaceC22028uY4.e.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(EnumC21371tY4 enumC21371tY4, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(enumC21371tY4, "$dialogState");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        k(enumC21371tY4, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        ua2.invoke(new InterfaceC22028uY4.f(true));
        return C19938rB7.a;
    }

    private static final void q(final AY4 ay4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-872244988);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(ay4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else if (ay4 == AY4.a) {
            interfaceC22053ub1J.W(-1963270095);
            CG3.j(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.a(interfaceC22053ub1J, G10.b).r(), interfaceC22053ub1J, 6, 0);
            interfaceC22053ub1J.Q();
        } else if (ay4 == AY4.b) {
            interfaceC22053ub1J.W(-1963049623);
            CG3.g(null, null, null, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.Q();
        } else {
            interfaceC22053ub1J.W(-1963015988);
            interfaceC22053ub1J.Q();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.BY4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LY4.r(ay4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(AY4 ay4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ay4, "$loadingState");
        q(ay4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void s(final OY4 oy4, final C19391qG6 c19391qG6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(oy4, "state");
        AbstractC13042fc3.i(c19391qG6, "snackBarState");
        AbstractC13042fc3.i(ua2, "onViewModelEvent");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2062315919);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(oy4) ? 4 : 2) | i;
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
            C19777qv2 c19777qv2F = oy4.f();
            interfaceC22053ub1J.W(1353629951);
            int i3 = i2 & 896;
            boolean z = i3 == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new InterfaceC14603iB2() { // from class: ir.nasim.IY4
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return LY4.t(ua2, (BX4) obj, (EX4.a) obj2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1353634938);
            boolean z2 = i3 == 256;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new InterfaceC14603iB2() { // from class: ir.nasim.JY4
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return LY4.u(ua2, (BX4) obj, (EX4) obj2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            TX4.x(c19777qv2F, new C19186pv2(interfaceC14603iB2, (InterfaceC14603iB2) objB2), interfaceC22053ub1J, 0);
            int i4 = i2 >> 3;
            w(c19391qG6, interfaceC22053ub1J, i4 & 14);
            EnumC21371tY4 enumC21371tY4E = oy4.e();
            interfaceC22053ub1J.W(1353641041);
            if (enumC21371tY4E != null) {
                k(enumC21371tY4E, ua2, interfaceC22053ub1J, i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            AY4 ay4G = oy4.g();
            if (ay4G != null) {
                q(ay4G, interfaceC22053ub1J, 0);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.KY4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LY4.v(oy4, c19391qG6, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(UA2 ua2, BX4 bx4, EX4.a aVar) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        AbstractC13042fc3.i(bx4, "field");
        AbstractC13042fc3.i(aVar, "fieldType");
        ua2.invoke(new InterfaceC22028uY4.a(bx4, aVar));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(UA2 ua2, BX4 bx4, EX4 ex4) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        AbstractC13042fc3.i(bx4, "field");
        AbstractC13042fc3.i(ex4, "fieldType");
        ua2.invoke(new InterfaceC22028uY4.d(bx4, ex4));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(OY4 oy4, C19391qG6 c19391qG6, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(oy4, "$state");
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        s(oy4, c19391qG6, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void w(final C19391qG6 c19391qG6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(100567527);
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
            AbstractC18209oG6.b(c19391qG6, androidx.compose.foundation.layout.h.a.h(aVar, aVar2.b()), C17529n71.a.a(), interfaceC22053ub1J, (i2 & 14) | 384, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.CY4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LY4.x(c19391qG6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(C19391qG6 c19391qG6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        w(c19391qG6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
