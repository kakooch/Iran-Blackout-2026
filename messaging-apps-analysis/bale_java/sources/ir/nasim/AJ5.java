package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;

/* loaded from: classes7.dex */
public final class AJ5 extends RecyclerView.C {
    public static final int w = ComposeView.k;
    private final ComposeView u;
    private final UA2 v;

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C16462lJ5 b;

        /* renamed from: ir.nasim.AJ5$a$a, reason: collision with other inner class name */
        static final class C0260a implements InterfaceC14603iB2 {
            final /* synthetic */ AJ5 a;
            final /* synthetic */ C16462lJ5 b;

            C0260a(AJ5 aj5, C16462lJ5 c16462lJ5) {
                this.a = aj5;
                this.b = c16462lJ5;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AJ5 aj5 = this.a;
                    aj5.E0(null, this.b, aj5.v, interfaceC22053ub1, ComposeView.k << 9, 1);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(C16462lJ5 c16462lJ5) {
            this.b = c16462lJ5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1512449715, true, new C0260a(AJ5.this, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AJ5(ComposeView composeView, UA2 ua2) {
        super(composeView);
        AbstractC13042fc3.i(composeView, "composeView");
        AbstractC13042fc3.i(ua2, "onItemClick");
        this.u = composeView;
        this.v = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F0(UA2 ua2, C16462lJ5 c16462lJ5) {
        AbstractC13042fc3.i(ua2, "$onClick");
        AbstractC13042fc3.i(c16462lJ5, "$recommendedPeer");
        ua2.invoke(c16462lJ5);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H0(AJ5 aj5, androidx.compose.ui.e eVar, C16462lJ5 c16462lJ5, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(aj5, "$tmp0_rcvr");
        AbstractC13042fc3.i(c16462lJ5, "$recommendedPeer");
        AbstractC13042fc3.i(ua2, "$onClick");
        aj5.E0(eVar, c16462lJ5, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public final void E0(androidx.compose.ui.e eVar, final C16462lJ5 c16462lJ5, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(c16462lJ5, "recommendedPeer");
        AbstractC13042fc3.i(ua2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1854062894);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(c16462lJ5) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            androidx.compose.ui.e eVar4 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            e.a aVar = androidx.compose.ui.e.a;
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            G10 g10 = G10.a;
            int i5 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVar4, g10.a(interfaceC22053ub1J, i5).r(), null, 2, null);
            interfaceC22053ub1J.W(-1381705592);
            boolean z = ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | ((i3 & 896) == 256);
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.yJ5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AJ5.F0(ua2, c16462lJ5);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.e.f(eVarD, false, null, null, (SA2) objB, 7, null), g10.c(interfaceC22053ub1J, i5).b().e(), g10.c(interfaceC22053ub1J, i5).b().d());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1J, 54);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            M66 m66 = M66.a;
            TU.m(AvatarAsyncImagePainterKt.h(c16462lJ5.a(), null, false, 0, interfaceC22053ub1J, 0, 14), new UU(false, null, null, null, c16462lJ5.e(), c16462lJ5.d(), false, 79, null), null, 0.0f, 0.0f, 0.0f, null, interfaceC22053ub1J, 0, 124);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, g10.c(interfaceC22053ub1J, i5).b().e()), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.b(), aVar2.k(), interfaceC22053ub1J, 6);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
            SA2 sa2A3 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1J, 48);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            SA2 sa2A4 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3B2, aVar3.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar3.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar3.f());
            androidx.compose.ui.e eVarA = m66.a(aVar, 1.0f, false);
            String strE = c16462lJ5.e();
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1J, i5).a();
            AbstractC9339Zm7.b(strE, eVarA, g10.a(interfaceC22053ub1J, i5).F(), 0L, null, null, null, 0L, null, null, 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : C4049Dl7.b.b(), (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1J, 0, 3120, 55288);
            interfaceC22053ub1J.W(1743371743);
            if (c16462lJ5.c()) {
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i5).b().n()), interfaceC22053ub1J, 0);
                AbstractC11456d23.b(FV4.c(AbstractC22412vB5.blue_tick, interfaceC22053ub1J, 0), UY6.c(UD5.core_ui_verified_channel_badge, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.t.m(aVar, C17784nZ1.q(18)), null, null, 0.0f, null, interfaceC22053ub1J, 384, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.W(1537900310);
            String strB = c16462lJ5.b();
            if (strB != null && !AbstractC20762sZ6.n0(strB)) {
                ZH6.a(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1J, i5).b().n()), interfaceC22053ub1J, 0);
                AbstractC9339Zm7.b(UY6.d(RD5.bot_monthly_users, new Object[]{XY6.v(c16462lJ5.b())}, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i5).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i5).c(), interfaceC22053ub1J, 0, 0, 65530);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.u();
            eVar3 = eVar4;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.zJ5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AJ5.H0(this.a, eVar3, c16462lJ5, ua2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void L0(C16462lJ5 c16462lJ5) {
        if (c16462lJ5 != null) {
            this.u.setContent(AbstractC19242q11.c(-1072067694, true, new a(c16462lJ5)));
        }
    }

    public final void a() {
        this.u.h();
    }
}
