package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import androidx.compose.ui.e;
import ir.nasim.AbstractC21790u82;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.u82, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC21790u82 {

    /* renamed from: ir.nasim.u82$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ SA2 b;

        /* renamed from: ir.nasim.u82$a$a, reason: collision with other inner class name */
        static final class C1625a implements InterfaceC15796kB2 {
            final /* synthetic */ UA2 a;
            final /* synthetic */ SA2 b;

            C1625a(UA2 ua2, SA2 sa2) {
                this.a = ua2;
                this.b = sa2;
            }

            private static final boolean h(InterfaceC9102Ym4 interfaceC9102Ym4) {
                return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(ua2, "$endGroupCall");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$isChecked$delegate");
                ua2.invoke(Boolean.valueOf(h(interfaceC9102Ym4)));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(SA2 sa2) {
                AbstractC13042fc3.i(sa2, "$onClosePressed");
                sa2.invoke();
                return C19938rB7.a;
            }

            private static final void n(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
                interfaceC9102Ym4.setValue(Boolean.valueOf(z));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$isChecked$delegate");
                n(interfaceC9102Ym4, !h(interfaceC9102Ym4));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$isChecked$delegate");
                n(interfaceC9102Ym4, !h(interfaceC9102Ym4));
                return C19938rB7.a;
            }

            public final void f(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                final InterfaceC9102Ym4 interfaceC9102Ym4;
                AbstractC13042fc3.i(zy0, "$this$Card");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(213030600);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB;
                interfaceC22053ub1.Q();
                e.a aVar2 = androidx.compose.ui.e.a;
                float f = 24;
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), WX0.a(IA5.color4, interfaceC22053ub1, 0), null, 2, null), C17784nZ1.q(f));
                InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
                InterfaceC12529em.b bVarG = aVar3.g();
                C24254yJ c24254yJ = C24254yJ.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), bVarG, interfaceC22053ub1, 48);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
                InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar4.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar4.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                AbstractC9105Ym7.b(UY6.c(BD5.end_groupcall_title, interfaceC22053ub1, 0), c9784aZ0.c(aVar2, aVar3.g()), WX0.a(IA5.color9, interfaceC22053ub1, 0), AbstractC13784go7.g(18), null, null, M10.p(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122800);
                float f2 = 12;
                AbstractC9105Ym7.b(UY6.c(BD5.end_groupcall_description, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.m(aVar2, 0.0f, C17784nZ1.q(f2), 0.0f, 0.0f, 13, null), WX0.a(IA5.color9, interfaceC22053ub1, 0), AbstractC13784go7.g(14), null, null, M10.q(), 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 3120, 0, 130992);
                androidx.compose.ui.e eVarC = c9784aZ0.c(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.E(aVar2, null, false, 3, null), 0.0f, C17784nZ1.q(f2), 0.0f, 0.0f, 13, null), aVar3.k());
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar3.i(), interfaceC22053ub1, 48);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
                SA2 sa2A2 = aVar4.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A2);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar4.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
                M66 m66 = M66.a;
                androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(f));
                interfaceC22053ub1.W(-1668422653);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    interfaceC9102Ym4 = interfaceC9102Ym42;
                    objB2 = new SA2() { // from class: ir.nasim.q82
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC21790u82.a.C1625a.o(interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                } else {
                    interfaceC9102Ym4 = interfaceC9102Ym42;
                }
                interfaceC22053ub1.Q();
                AbstractC24667z03.b(FV4.c(h(interfaceC9102Ym4) ? KB5.ic_checkbox_checked : KB5.ic_checkbox_unchecked, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.q.i(androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB2, 7, null), C17784nZ1.q(2)), C24381yX0.b.i(), interfaceC22053ub1, 3120, 0);
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar2, C17784nZ1.q(f2), 0.0f, 0.0f, 0.0f, 14, null);
                interfaceC22053ub1.W(-1668404837);
                Object objB3 = interfaceC22053ub1.B();
                if (objB3 == aVar.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.r82
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC21790u82.a.C1625a.p(interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                final InterfaceC9102Ym4 interfaceC9102Ym43 = interfaceC9102Ym4;
                AbstractC9105Ym7.b(UY6.c(BD5.end_groupcall_check, interfaceC22053ub1, 0), androidx.compose.foundation.e.f(eVarM, false, null, null, (SA2) objB3, 7, null), WX0.a(IA5.color9, interfaceC22053ub1, 0), AbstractC13784go7.g(15), null, null, M10.q(), 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0, 130992);
                interfaceC22053ub1.u();
                interfaceC22053ub1.u();
                float f3 = 1;
                androidx.compose.ui.e eVarF = AbstractC19576qb1.f(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), WX0.a(IA5.color6_2, interfaceC22053ub1, 0), null, 2, null), C17784nZ1.q(f3), WX0.a(IA5.color1, interfaceC22053ub1, 0));
                C24254yJ.f fVarD = c24254yJ.d();
                final UA2 ua2 = this.a;
                final SA2 sa2 = this.b;
                InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(fVarD, aVar3.l(), interfaceC22053ub1, 6);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
                SA2 sa2A3 = aVar4.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A3);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar4.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar4.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar4.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar4.f());
                androidx.compose.ui.e eVarB = L66.b(m66, aVar2, 1.0f, false, 2, null);
                InterfaceC10031ax6 interfaceC10031ax6A = MK5.a();
                interfaceC22053ub1.W(1793467216);
                boolean zV = interfaceC22053ub1.V(ua2);
                Object objB4 = interfaceC22053ub1.B();
                if (zV || objB4 == aVar.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.s82
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC21790u82.a.C1625a.i(ua2, interfaceC9102Ym43);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                C22349v51 c22349v51 = C22349v51.a;
                AbstractC16159ko0.b((SA2) objB4, eVarB, false, interfaceC10031ax6A, null, null, null, null, null, c22349v51.a(), interfaceC22053ub1, 805309440, SIPTransactionStack.BASE_TIMER_INTERVAL);
                androidx.compose.ui.e eVarD = AbstractC19576qb1.d(L66.b(m66, aVar2, 1.0f, false, 2, null), C17784nZ1.q(f3), WX0.a(IA5.color1, interfaceC22053ub1, 0));
                interfaceC22053ub1.W(1793491913);
                boolean zV2 = interfaceC22053ub1.V(sa2);
                Object objB5 = interfaceC22053ub1.B();
                if (zV2 || objB5 == aVar.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.t82
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC21790u82.a.C1625a.k(sa2);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                interfaceC22053ub1.Q();
                AbstractC16159ko0.b((SA2) objB5, eVarD, false, null, null, null, null, null, null, c22349v51.b(), interfaceC22053ub1, 805306368, 508);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                f((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(UA2 ua2, SA2 sa2) {
            this.a = ua2;
            this.b = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                PG0.a(null, N46.d(C17784nZ1.q(20)), null, null, null, AbstractC19242q11.e(1075940043, true, new C1625a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 196608, 29);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void e(final SA2 sa2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onClosePressed");
        AbstractC13042fc3.i(ua2, "endGroupCall");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1351021292);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            F27.a(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), C17784nZ1.q(16), 0.0f, 2, null), null, C24381yX0.b.h(), 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(-932998439, true, new a(ua2, sa2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 12583302, 122);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.p82
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC21790u82.f(sa2, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(SA2 sa2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onClosePressed");
        AbstractC13042fc3.i(ua2, "$endGroupCall");
        e(sa2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void g(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1829907609);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1387259890);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.m82
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21790u82.h();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1387260018);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.n82
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC21790u82.i(((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            e(sa2, (UA2) objB2, interfaceC22053ub1J, 54);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.o82
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC21790u82.j(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(boolean z) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        g(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
