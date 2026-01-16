package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C24254yJ;
import ir.nasim.C4081Dp3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Vg1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8270Vg1 {
    public static final void d(final EnumC4715Gg1 enumC4715Gg1, final boolean z, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(enumC4715Gg1, "sortType");
        AbstractC13042fc3.i(sa2, "onRefreshClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2128535261);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(enumC4715Gg1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i4 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1J, i4).y(), null, 2, null), g10.c(interfaceC22053ub1J, i4).b().c(), g10.c(interfaceC22053ub1J, i4).b().u());
            C24254yJ.e eVarG = C24254yJ.a.g();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar2.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.ui.e eVarB = L66.b(M66.a, aVar, 1.0f, false, 2, null);
            String strC = UY6.c(enumC4715Gg1.p(), interfaceC22053ub1J, 0);
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1J, i4).a();
            AbstractC9339Zm7.b(strC, eVarB, g10.a(interfaceC22053ub1J, i4).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1J, 0, 0, 65528);
            if (z) {
                interfaceC22053ub1J.W(-1116712202);
                C21097t63 c21097t63C = AbstractC22957w63.c("Loading", interfaceC22053ub1J, 6, 0);
                interfaceC22053ub1J.W(-1837128646);
                Object objB = interfaceC22053ub1J.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Sg1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC8270Vg1.e((C4081Dp3.b) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                AbstractC11456d23.b(FV4.c(AbstractC24188yB5.loading, interfaceC22053ub1J, 0), null, androidx.compose.ui.platform.t.a(G46.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().f()), f(AbstractC22957w63.a(c21097t63C, 360.0f, 0.0f, AbstractC5999Lt.e(AbstractC5999Lt.f((UA2) objB), null, 0L, 6, null), "Loading", interfaceC22053ub1J, C21097t63.f | 25008 | (C20494s63.d << 9), 0))), "SearchBar LoadingIcon"), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-1115899599);
                androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().f()), N46.g());
                interfaceC22053ub1J.W(-1837108554);
                boolean z2 = (i3 & 896) == 256;
                Object objB2 = interfaceC22053ub1J.B();
                if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Tg1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC8270Vg1.g(sa2);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarA, false, null, null, (SA2) objB2, 7, null);
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
                SA2 sa2A2 = aVar3.a();
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                AbstractC24077y03.b(FV4.c(AbstractC15799kB5.restore, interfaceC22053ub1J, 0), null, androidx.compose.foundation.layout.h.a.e(aVar), g10.a(interfaceC22053ub1J, i4).I(), interfaceC22053ub1J, 48, 0);
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
            }
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ug1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC8270Vg1.h(enumC4715Gg1, z, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(C4081Dp3.b bVar) {
        AbstractC13042fc3.i(bVar, "$this$keyframes");
        bVar.d(1500);
        return C19938rB7.a;
    }

    private static final float f(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onRefreshClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(EnumC4715Gg1 enumC4715Gg1, boolean z, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(enumC4715Gg1, "$sortType");
        AbstractC13042fc3.i(sa2, "$onRefreshClicked");
        d(enumC4715Gg1, z, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
