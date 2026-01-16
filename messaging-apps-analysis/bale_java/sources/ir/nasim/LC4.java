package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.NC4;
import ir.nasim.OC4;
import ir.nasim.PC4;
import ir.nasim.QC4;
import ir.nasim.RC4;
import ir.nasim.SC4;

/* loaded from: classes4.dex */
public abstract class LC4 {
    public static final void i(final QC4.b bVar, final SC4 sc4, final RC4 rc4, final OC4 oc4, final PC4 pc4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(bVar, "noticeIconData");
        AbstractC13042fc3.i(sc4, "noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "noticeButtonData");
        AbstractC13042fc3.i(pc4, "noticeCloseIconData");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1299347661);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(bVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(sc4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(rc4) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(oc4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(pc4) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            k(NC4.a.a, new CC4(bVar, sc4, rc4, oc4, pc4), interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.IC4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LC4.j(bVar, sc4, rc4, oc4, pc4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(QC4.b bVar, SC4 sc4, RC4 rc4, OC4 oc4, PC4 pc4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(bVar, "$noticeIconData");
        AbstractC13042fc3.i(sc4, "$noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "$noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "$noticeButtonData");
        AbstractC13042fc3.i(pc4, "$noticeCloseIconData");
        i(bVar, sc4, rc4, oc4, pc4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void k(final NC4 nc4, final CC4 cc4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        int i3;
        G10 g10;
        float f;
        e.a aVar;
        int i4;
        G10 g102;
        int i5;
        e.a aVar2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1622123661);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(nc4) : interfaceC22053ub1J.D(nc4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(cc4) : interfaceC22053ub1J.D(cc4) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar3 = androidx.compose.ui.e.a;
            float f2 = 12;
            int i6 = i2 & 14;
            float f3 = 8;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), C17784nZ1.q(f2)), nc4.f(interfaceC22053ub1J, i6), N46.d(C17784nZ1.q(f3)));
            InterfaceC12529em.a aVar4 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar4.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            InterfaceC16030kb1.a aVar5 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar5.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar5.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar5.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar5.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarC2 = androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), nc4.a(interfaceC22053ub1J, i6), N46.d(C17784nZ1.q(f3)));
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar4.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC2);
            SA2 sa2A2 = aVar5.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar5.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar5.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar5.f());
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), C17784nZ1.q(f2));
            C24254yJ c24254yJ = C24254yJ.a;
            G10 g103 = G10.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.p(g103.c(interfaceC22053ub1J, 6).b().u(), aVar4.g()), aVar4.i(), interfaceC22053ub1J, 48);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            SA2 sa2A3 = aVar5.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A3);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B, aVar5.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar5.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar5.f());
            M66 m66 = M66.a;
            interfaceC22053ub1J.W(1213687361);
            if (cc4.c() instanceof QC4.a) {
                i3 = i6;
                g10 = g103;
                f = 0.0f;
                AbstractC24077y03.b(FV4.c(((QC4.a) cc4.c()).a(), interfaceC22053ub1J, 0), null, androidx.compose.foundation.layout.t.m(aVar3, C17784nZ1.q(24)), nc4.e(interfaceC22053ub1J, i6), interfaceC22053ub1J, 432, 0);
            } else {
                i3 = i6;
                g10 = g103;
                f = 0.0f;
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarB = L66.b(m66, aVar3, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar4.k(), interfaceC22053ub1J, 0);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
            SA2 sa2A4 = aVar5.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A4);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3A, aVar5.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar5.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar5.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1J.W(34037007);
            if (cc4.e() instanceof SC4.a) {
                G10 g104 = g10;
                int i7 = i3;
                i4 = i7;
                g102 = g104;
                aVar = aVar3;
                AbstractC9339Zm7.b(((SC4.a) cc4.e()).a(), c9784aZ0.c(androidx.compose.foundation.layout.t.h(aVar3, f, 1, null), aVar4.k()), nc4.b(interfaceC22053ub1J, i7), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g104.d(interfaceC22053ub1J, 6).m(), interfaceC22053ub1J, 0, 0, 65016);
            } else {
                aVar = aVar3;
                i4 = i3;
                g102 = g10;
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(34056304);
            if (cc4.d() instanceof RC4.a) {
                e.a aVar6 = aVar;
                androidx.compose.ui.e eVarC3 = c9784aZ0.c(androidx.compose.foundation.layout.t.h(aVar6, f, 1, null), aVar4.k());
                String strA = ((RC4.a) cc4.d()).a();
                C9348Zn7 c9348Zn7E = g102.d(interfaceC22053ub1J, 6).e();
                int iF = C6399Nk7.b.f();
                i5 = i4;
                long jD = nc4.d(interfaceC22053ub1J, i5);
                C6399Nk7 c6399Nk7H = C6399Nk7.h(iF);
                aVar2 = aVar6;
                AbstractC9339Zm7.b(strA, eVarC3, jD, 0L, null, null, null, 0L, null, c6399Nk7H, 0L, 0, false, 0, 0, null, c9348Zn7E, interfaceC22053ub1J, 0, 0, 65016);
            } else {
                i5 = i4;
                aVar2 = aVar;
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.W(1213741953);
            if (cc4.a() instanceof OC4.a) {
                AbstractC17932no0.Q(((OC4.a) cc4.a()).b(), InterfaceC19114po0.b.C1454b.a, ((OC4.a) cc4.a()).a(), null, null, interfaceC22053ub1J, 24624, 8);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1213755620);
            if (cc4.b() instanceof PC4.a) {
                float f4 = 24;
                AbstractC13303g00.c(androidx.compose.foundation.layout.t.m(aVar2, C17784nZ1.q(f4)), FV4.c(((PC4.a) cc4.b()).a(), interfaceC22053ub1J, 0), C17784nZ1.q(f4), nc4.c(interfaceC22053ub1J, i5), null, null, ((PC4.a) cc4.b()).b(), interfaceC22053ub1J, 390, 48);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.KC4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LC4.l(nc4, cc4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(NC4 nc4, CC4 cc4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(nc4, "$noticeBarStatus");
        AbstractC13042fc3.i(cc4, "$noticeBarData");
        k(nc4, cc4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void m(final QC4.d dVar, final SC4 sc4, final RC4 rc4, final OC4 oc4, final PC4 pc4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(dVar, "noticeIconData");
        AbstractC13042fc3.i(sc4, "noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "noticeButtonData");
        AbstractC13042fc3.i(pc4, "noticeCloseIconData");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(81295795);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(dVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(sc4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(rc4) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(oc4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(pc4) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            k(NC4.b.a, new CC4(dVar, sc4, rc4, oc4, pc4), interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.FC4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LC4.n(dVar, sc4, rc4, oc4, pc4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(QC4.d dVar, SC4 sc4, RC4 rc4, OC4 oc4, PC4 pc4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(dVar, "$noticeIconData");
        AbstractC13042fc3.i(sc4, "$noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "$noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "$noticeButtonData");
        AbstractC13042fc3.i(pc4, "$noticeCloseIconData");
        m(dVar, sc4, rc4, oc4, pc4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void o(final QC4.c cVar, final SC4 sc4, final RC4 rc4, final OC4 oc4, final PC4 pc4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(cVar, "noticeIconData");
        AbstractC13042fc3.i(sc4, "noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "noticeButtonData");
        AbstractC13042fc3.i(pc4, "noticeCloseIconData");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(533013961);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(cVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(sc4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(rc4) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(oc4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(pc4) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            k(NC4.c.a, new CC4(cVar, sc4, rc4, oc4, pc4), interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.JC4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LC4.p(cVar, sc4, rc4, oc4, pc4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(QC4.c cVar, SC4 sc4, RC4 rc4, OC4 oc4, PC4 pc4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(cVar, "$noticeIconData");
        AbstractC13042fc3.i(sc4, "$noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "$noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "$noticeButtonData");
        AbstractC13042fc3.i(pc4, "$noticeCloseIconData");
        o(cVar, sc4, rc4, oc4, pc4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void q(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1518711808);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, X61.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.DC4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LC4.r(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        q(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void s(final QC4.c cVar, final SC4 sc4, final RC4 rc4, final OC4 oc4, final PC4 pc4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(cVar, "noticeIconData");
        AbstractC13042fc3.i(sc4, "noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "noticeButtonData");
        AbstractC13042fc3.i(pc4, "noticeCloseIconData");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-167970551);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(cVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(sc4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(rc4) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(oc4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(pc4) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            k(NC4.d.a, new CC4(cVar, sc4, rc4, oc4, pc4), interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.GC4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LC4.t(cVar, sc4, rc4, oc4, pc4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(QC4.c cVar, SC4 sc4, RC4 rc4, OC4 oc4, PC4 pc4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(cVar, "$noticeIconData");
        AbstractC13042fc3.i(sc4, "$noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "$noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "$noticeButtonData");
        AbstractC13042fc3.i(pc4, "$noticeCloseIconData");
        s(cVar, sc4, rc4, oc4, pc4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void u(final QC4.c cVar, final SC4 sc4, final RC4 rc4, final OC4 oc4, final PC4 pc4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(cVar, "noticeIconData");
        AbstractC13042fc3.i(sc4, "noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "noticeButtonData");
        AbstractC13042fc3.i(pc4, "noticeCloseIconData");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(102777433);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(cVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(sc4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(rc4) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(oc4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(pc4) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            k(NC4.e.a, new CC4(cVar, sc4, rc4, oc4, pc4), interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.EC4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LC4.v(cVar, sc4, rc4, oc4, pc4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(QC4.c cVar, SC4 sc4, RC4 rc4, OC4 oc4, PC4 pc4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(cVar, "$noticeIconData");
        AbstractC13042fc3.i(sc4, "$noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "$noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "$noticeButtonData");
        AbstractC13042fc3.i(pc4, "$noticeCloseIconData");
        u(cVar, sc4, rc4, oc4, pc4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void w(final QC4.e eVar, final SC4 sc4, final RC4 rc4, final OC4 oc4, final PC4 pc4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(eVar, "noticeIconData");
        AbstractC13042fc3.i(sc4, "noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "noticeButtonData");
        AbstractC13042fc3.i(pc4, "noticeCloseIconData");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1711608147);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(sc4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(rc4) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(oc4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(pc4) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            k(NC4.f.a, new CC4(eVar, sc4, rc4, oc4, pc4), interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.HC4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LC4.x(eVar, sc4, rc4, oc4, pc4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(QC4.e eVar, SC4 sc4, RC4 rc4, OC4 oc4, PC4 pc4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$noticeIconData");
        AbstractC13042fc3.i(sc4, "$noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "$noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "$noticeButtonData");
        AbstractC13042fc3.i(pc4, "$noticeCloseIconData");
        w(eVar, sc4, rc4, oc4, pc4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
