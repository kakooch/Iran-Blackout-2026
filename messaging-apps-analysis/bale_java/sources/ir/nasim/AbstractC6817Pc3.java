package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC6817Pc3;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.Pc3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC6817Pc3 {

    /* renamed from: ir.nasim.Pc3$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(QD5.two_f_a_setting, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Pc3$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ SA2 b;

        /* renamed from: ir.nasim.Pc3$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;
            final /* synthetic */ InterfaceC9102Ym4 b;

            a(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = sa2;
                this.b = interfaceC9102Ym4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(sa2, "$onDisablePassword");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
                sa2.invoke();
                AbstractC6817Pc3.h(interfaceC9102Ym4, false);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
                AbstractC6817Pc3.h(interfaceC9102Ym4, false);
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, G10.b).b().c(), 0.0f, 2, null);
                AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
                String strC = UY6.c(AbstractC12217eE5.disable, interfaceC22053ub1, 0);
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                String strC2 = UY6.c(AbstractC12217eE5.Cancel, interfaceC22053ub1, 0);
                C15155j61 c15155j61 = C15155j61.a;
                InterfaceC14603iB2 interfaceC14603iB2A = c15155j61.a();
                InterfaceC14603iB2 interfaceC14603iB2B = c15155j61.b();
                interfaceC22053ub1.W(-317602824);
                boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
                final SA2 sa2 = this.a;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Sc3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC6817Pc3.b.a.d(sa2, interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa22 = (SA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-317593012);
                boolean zV2 = interfaceC22053ub1.V(this.b);
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.b;
                Object objB2 = interfaceC22053ub1.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Tc3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC6817Pc3.b.a.f(interfaceC9102Ym42);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC19555qZ.F(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa22, strC, c1454b, (SA2) objB2, strC2, eVarK, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2) {
            this.a = interfaceC9102Ym4;
            this.b = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
            AbstractC6817Pc3.h(interfaceC9102Ym4, true);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
            AbstractC6817Pc3.h(interfaceC9102Ym4, false);
            return C19938rB7.a;
        }

        public final void c(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "it");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarM, g10.a(interfaceC22053ub1, i3).r(), null, 2, null);
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 6);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            interfaceC22053ub1.W(-317673473);
            boolean zV = interfaceC22053ub1.V(interfaceC9102Ym4);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Qc3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC6817Pc3.b.d(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null), g10.c(interfaceC22053ub1, i3).b().c(), g10.c(interfaceC22053ub1, i3).b().e());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar2.l(), interfaceC22053ub1, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
            SA2 sa2A2 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            androidx.compose.ui.e eVarB = L66.b(M66.a, aVar, 1.0f, false, 2, null);
            String strC = UY6.c(QD5.two_f_a_setting_remove, interfaceC22053ub1, 0);
            long jF = g10.a(interfaceC22053ub1, i3).F();
            C9348Zn7 c9348Zn7L = g10.d(interfaceC22053ub1, i3).l();
            AbstractC9339Zm7.b(strC, eVarB, jF, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7L.b((16744447 & 1) != 0 ? c9348Zn7L.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7L.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7L.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7L.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7L.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7L.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7L.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7L.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7L.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7L.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7L.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7L.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7L.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7L.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7L.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7L.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7L.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7L.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7L.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7L.c : null, (16744447 & 1048576) != 0 ? c9348Zn7L.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7L.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7L.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7L.b.k() : null), interfaceC22053ub1, 0, 0, 65528);
            AbstractC24077y03.b(FV4.c(AbstractC21822uB5.simple_arrow_left, interfaceC22053ub1, 0), UY6.c(QD5.two_f_a_setting_remove, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i3).b().j()), g10.a(interfaceC22053ub1, i3).B(), interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.u();
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i3).A(), interfaceC22053ub1, 6, 2);
            interfaceC22053ub1.u();
            if (AbstractC6817Pc3.g(this.a)) {
                interfaceC22053ub1.W(-1771409983);
                boolean zV2 = interfaceC22053ub1.V(this.a);
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Rc3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC6817Pc3.b.f(interfaceC9102Ym42);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC6687Oo.a((SA2) objB2, new C18876pP1(false, false, false, 3, (ED1) null), AbstractC19242q11.e(654498941, true, new a(this.b, this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 432, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        final SA2 sa23;
        int i3;
        SA2 sa24;
        AbstractC13042fc3.i(sa22, "onDisablePassword");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-165559302);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            sa23 = sa2;
        } else if ((i & 6) == 0) {
            sa23 = sa2;
            i3 = (interfaceC22053ub1J.D(sa23) ? 4 : 2) | i;
        } else {
            sa23 = sa2;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i4 != 0) {
                interfaceC22053ub1J.W(1232048718);
                Object objB = interfaceC22053ub1J.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Fc3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC6817Pc3.e();
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                sa24 = (SA2) objB;
            } else {
                sa24 = sa23;
            }
            Object[] objArr = new Object[0];
            interfaceC22053ub1J.W(1232051365);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Hc3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC6817Pc3.f();
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(-950468682, true, new a(sa24), interfaceC22053ub1J, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-2024553397, true, new b((InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB2, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6), sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805306422, 444);
            sa23 = sa24;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Jc3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC6817Pc3.i(sa23, sa22, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9102Ym4 f() {
        return AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(SA2 sa2, SA2 sa22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa22, "$onDisablePassword");
        d(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
