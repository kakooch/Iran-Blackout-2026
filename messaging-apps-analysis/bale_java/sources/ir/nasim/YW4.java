package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC15996kX4;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.YW4;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class YW4 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ float a;
        final /* synthetic */ boolean b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;

        /* renamed from: ir.nasim.YW4$a$a, reason: collision with other inner class name */
        static final class C0793a implements InterfaceC15796kB2 {
            final /* synthetic */ List a;
            final /* synthetic */ UA2 b;

            /* renamed from: ir.nasim.YW4$a$a$a, reason: collision with other inner class name */
            static final class C0794a implements InterfaceC15796kB2 {
                final /* synthetic */ AbstractC15996kX4 a;

                C0794a(AbstractC15996kX4 abstractC15996kX4) {
                    this.a = abstractC15996kX4;
                }

                public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    int i2;
                    AbstractC13042fc3.i(l66, "$this$DropdownMenuItem");
                    if ((i & 6) == 0) {
                        i2 = i | (interfaceC22053ub1.V(l66) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    e.a aVar = androidx.compose.ui.e.a;
                    ZH6.a(L66.b(l66, aVar, 1.0f, false, 2, null), interfaceC22053ub1, 0);
                    AbstractC9105Ym7.b(UY6.c(this.a.b(), interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, C17784nZ1.q(12), 0.0f, 11, null), AbstractC24067xz3.X(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1, G10.b).b(), interfaceC22053ub1, 48, 0, 65528);
                    AbstractC24667z03.b(FV4.c(this.a.a(), interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(24)), AbstractC24067xz3.T(), interfaceC22053ub1, 432, 0);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            C0793a(List list, UA2 ua2) {
                this.a = list;
                this.b = ua2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(UA2 ua2, AbstractC15996kX4 abstractC15996kX4) {
                AbstractC13042fc3.i(ua2, "$onItemClicked");
                AbstractC13042fc3.i(abstractC15996kX4, "$it");
                ua2.invoke(abstractC15996kX4);
                return C19938rB7.a;
            }

            public final void b(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(zy0, "$this$DropdownMenu");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                List<AbstractC15996kX4> list = this.a;
                final UA2 ua2 = this.b;
                for (final AbstractC15996kX4 abstractC15996kX4 : list) {
                    interfaceC22053ub1.W(-112517769);
                    boolean zV = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.D(abstractC15996kX4);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.XW4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return YW4.a.C0793a.c(ua2, abstractC15996kX4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC6447Np.b((SA2) objB, null, false, androidx.compose.foundation.layout.q.c(C17784nZ1.q(16), 0.0f, 2, null), null, AbstractC19242q11.e(1221812683, true, new C0794a(abstractC15996kX4), interfaceC22053ub1, 54), interfaceC22053ub1, 199680, 22);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(float f, boolean z, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, List list, UA2 ua2) {
            this.a = f;
            this.b = z;
            this.c = sa2;
            this.d = interfaceC9102Ym4;
            this.e = list;
            this.f = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC11379cu3 interfaceC11379cu3) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$dropDownHeight$delegate");
            AbstractC13042fc3.i(interfaceC11379cu3, "layoutCoordinates");
            YW4.h(interfaceC9102Ym4, ((int) (interfaceC11379cu3.a() & 4294967295L)) + 55);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(273011276);
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.WW4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return YW4.a.c(interfaceC9102Ym4, (InterfaceC11379cu3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(androidx.compose.ui.layout.c.a(aVar, (UA2) objB), C17784nZ1.q(SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER));
            float fQ = C17784nZ1.q(20);
            float fQ2 = C17784nZ1.q(-this.a);
            AbstractC6447Np.a(this.b, this.c, eVarY, C19557qZ1.b((Float.floatToRawIntBits(fQ) << 32) | (Float.floatToRawIntBits(fQ2) & 4294967295L)), null, null, AbstractC19242q11.e(1799457066, true, new C0793a(this.e, this.f), interfaceC22053ub1, 54), interfaceC22053ub1, 1573248, 48);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void f(final boolean z, final List list, final SA2 sa2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(list, "dropDownItems");
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(ua2, "onItemClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1710646731);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(list) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(770787703);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC13472gH6.d(0, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            float fD = ((WH1) interfaceC22053ub1J.H(AbstractC13040fc1.g())).D(g(interfaceC9102Ym4));
            C15977kV3 c15977kV3 = C15977kV3.a;
            int i3 = C15977kV3.b;
            UY0 uy0A = c15977kV3.a(interfaceC22053ub1J, i3);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC16568lV3.a(uy0A.a((8159 & 1) != 0 ? uy0A.j() : 0L, (8159 & 2) != 0 ? uy0A.k() : 0L, (8159 & 4) != 0 ? uy0A.l() : 0L, (8159 & 8) != 0 ? uy0A.m() : 0L, (8159 & 16) != 0 ? uy0A.c() : 0L, (8159 & 32) != 0 ? uy0A.n() : AbstractC24067xz3.h0(), (8159 & 64) != 0 ? uy0A.d() : 0L, (8159 & 128) != 0 ? uy0A.g() : 0L, (8159 & 256) != 0 ? uy0A.h() : 0L, (8159 & 512) != 0 ? uy0A.e() : 0L, (8159 & 1024) != 0 ? uy0A.i() : 0L, (8159 & 2048) != 0 ? uy0A.f() : 0L, (8159 & 4096) != 0 ? uy0A.o() : false), null, C5341Ix6.b(c15977kV3.b(interfaceC22053ub1J, i3), null, N46.b(15), null, 5, null), AbstractC19242q11.e(1883634295, true, new a(fD, z, sa2, interfaceC9102Ym4, list, ua2), interfaceC22053ub1J, 54), interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.VW4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return YW4.i(z, list, sa2, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, int i) {
        interfaceC9102Ym4.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(boolean z, List list, SA2 sa2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(list, "$dropDownItems");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(ua2, "$onItemClicked");
        f(z, list, sa2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void k(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1288990325);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-1700563296);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), C24381yX0.b.j(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
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
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            boolean zP = p(interfaceC9102Ym4);
            List listE = AbstractC9766aX0.e(AbstractC15996kX4.c.c);
            interfaceC22053ub1J.W(2107121805);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.RW4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return YW4.n(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            SA2 sa2 = (SA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(2107123789);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new UA2() { // from class: ir.nasim.SW4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return YW4.l(interfaceC9102Ym4, (AbstractC15996kX4) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            f(zP, listE, sa2, (UA2) objB3, interfaceC22053ub1J, (AbstractC15996kX4.c.d << 3) | 3456);
            interfaceC22053ub1J.W(2107128022);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.TW4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return YW4.m(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            AbstractC9105Ym7.b("test", androidx.compose.foundation.e.f(aVar2, false, null, null, (SA2) objB4, 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1J, 6, 0, 131068);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.UW4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return YW4.o(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(InterfaceC9102Ym4 interfaceC9102Ym4, AbstractC15996kX4 abstractC15996kX4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$expanded$delegate");
        AbstractC13042fc3.i(abstractC15996kX4, "it");
        q(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$expanded$delegate");
        q(interfaceC9102Ym4, !p(interfaceC9102Ym4));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$expanded$delegate");
        q(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        k(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final boolean p(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void q(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }
}
