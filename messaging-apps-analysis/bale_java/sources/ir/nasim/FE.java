package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.LX;

/* loaded from: classes.dex */
public abstract class FE {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;

        a(UA2 ua2, SA2 sa2, SA2 sa22) {
            this.a = ua2;
            this.b = sa2;
            this.c = sa22;
        }

        public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), 0.0f, C17784nZ1.q(8), 0.0f, 0.0f, 13, null);
            UA2 ua2 = this.a;
            SA2 sa2 = this.b;
            SA2 sa22 = this.c;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            FE.v(c9784aZ0, interfaceC22053ub1, 6);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(16)), interfaceC22053ub1, 6);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            FE.t(c9784aZ0, interfaceC22053ub1, 6);
            interfaceC22053ub1.W(-658406140);
            if (C8386Vt0.a.ya()) {
                FE.q(ua2, interfaceC22053ub1, 0);
            }
            interfaceC22053ub1.Q();
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            FE.m(sa2, sa22, interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void j(final UA2 ua2, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(ua2, "neverChackedClickChanged");
        AbstractC13042fc3.i(sa2, "onPositiveClick");
        AbstractC13042fc3.i(sa22, "onClose");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1468923434);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(ua2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            long jM = G10.a.a(interfaceC22053ub1J, G10.b).M();
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(false, null, interfaceC22053ub1J, 0, 3);
            interfaceC22053ub1J.W(1706482941);
            boolean z = (i2 & 896) == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.wE
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return FE.k(sa22);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC9273Zf4.a((SA2) objB, null, c19818qz6L, 0.0f, null, jM, 0L, 0.0f, 0L, N11.a.a(), null, null, AbstractC19242q11.e(274501677, true, new a(ua2, sa2, sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805306368, 384, 3546);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xE
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return FE.l(ua2, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onClose");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(UA2 ua2, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ua2, "$neverChackedClickChanged");
        AbstractC13042fc3.i(sa2, "$onPositiveClick");
        AbstractC13042fc3.i(sa22, "$onClose");
        j(ua2, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1295265386);
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
            e.a aVar = androidx.compose.ui.e.a;
            float f = 16;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, C17784nZ1.q(f)), 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
            InterfaceC19114po0.b.a aVar3 = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(AbstractC23616xD5.rating_positive_button, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1968274297);
            boolean z = (i3 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.AE
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return FE.n(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC17932no0.A((SA2) objB, aVar3, strC, eVarB, null, null, interfaceC22053ub1J, InterfaceC19114po0.b.a.b << 3, 48);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(f)), interfaceC22053ub1J, 6);
            androidx.compose.ui.e eVarB2 = L66.b(m66, aVar, 1.0f, false, 2, null);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(AbstractC23616xD5.rating_negitive_button, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1968284793);
            boolean z2 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.BE
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return FE.o(sa22);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC17932no0.A((SA2) objB2, c1454b, strC2, eVarB2, null, null, interfaceC22053ub1J, InterfaceC19114po0.b.C1454b.b << 3, 48);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.CE
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return FE.p(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onPositiveClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onNegativeClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onPositiveClick");
        AbstractC13042fc3.i(sa22, "$onNegativeClick");
        m(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1389310013);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(ua2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(16), C17784nZ1.q(12));
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            interfaceC22053ub1J.W(-1806098156);
            boolean z = (i2 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.DE
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return FE.r(ua2, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            KX.f(null, new LX.a(false, (UA2) objB, false, 4, null), interfaceC22053ub1J, LX.a.d << 3, 1);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(4)), interfaceC22053ub1J, 6);
            int iF = C6399Nk7.b.f();
            String strC = UY6.c(AbstractC23616xD5.rating_dont_show_again_button, interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1J, i3).D(), 0L, null, null, null, 0L, null, C6399Nk7.h(iF), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).b(), interfaceC22053ub1J, 0, 0, 65018);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.EE
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return FE.s(ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(UA2 ua2, boolean z) {
        AbstractC13042fc3.i(ua2, "$neverChackedClickChanged");
        ua2.invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ua2, "$neverChackedClickChanged");
        q(ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1807299883);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(zy0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(zy0.c(androidx.compose.ui.e.a, InterfaceC12529em.a.g()), C17784nZ1.q(16), C17784nZ1.q(12));
            int iF = C6399Nk7.b.f();
            String strC = UY6.c(AbstractC23616xD5.rating_description, interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(strC, eVarJ, g10.a(interfaceC22053ub1J, i3).D(), 0L, null, null, null, 0L, null, C6399Nk7.h(iF), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).b(), interfaceC22053ub1J, 0, 0, 65016);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.zE
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return FE.u(zy0, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(ZY0 zy0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(zy0, "$this_RatingDescription");
        t(zy0, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1475251215);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(zy0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarC = zy0.c(androidx.compose.ui.e.a, InterfaceC12529em.a.g());
            int iA = C6399Nk7.b.a();
            String strC = UY6.c(AbstractC23616xD5.rating_titel, interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9339Zm7.b(strC, eVarC, g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(iA), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).l(), interfaceC22053ub1J, 0, 0, 65016);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.yE
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return FE.w(zy0, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(ZY0 zy0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(zy0, "$this_RatingTitle");
        v(zy0, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
