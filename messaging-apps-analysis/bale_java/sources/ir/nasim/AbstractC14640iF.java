package ir.nasim;

import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.iF, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC14640iF {

    /* renamed from: ir.nasim.iF$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        /* renamed from: ir.nasim.iF$a$a, reason: collision with other inner class name */
        static final class C1289a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            C1289a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC21639ts7.i(UY6.c(QD5.settings_appearance_appbar_title, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-1446995945, true, new C1289a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.iF$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ C12829fF a;

        b(C12829fF c12829fF) {
            this.a = c12829fF;
        }

        public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC14640iF.e(AbstractC8014Ud6.g(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null), this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(final SA2 sa2, final C12829fF c12829fF, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onBackPress");
        AbstractC13042fc3.i(c12829fF, "appearanceNavigationCallbacks");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1667899621);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c12829fF) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(758506711, true, new a(sa2), interfaceC22053ub1J, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1657959188, true, new b(c12829fF), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805306422, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.gF
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC14640iF.d(sa2, c12829fF, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(SA2 sa2, C12829fF c12829fF, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(c12829fF, "$appearanceNavigationCallbacks");
        c(sa2, c12829fF, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void e(final androidx.compose.ui.e eVar, final C12829fF c12829fF, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(eVar, "modifier");
        AbstractC13042fc3.i(c12829fF, "appearanceNavigationCallbacks");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1565844609);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c12829fF) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1J.W(-1203756056);
            if (!C8386Vt0.u8()) {
                AbstractC16797ls7.i(UY6.c(QD5.settings_appearance_multi_tab, interfaceC22053ub1J, 0), AbstractC21822uB5.tab, null, null, null, null, null, c12829fF.c(), null, false, interfaceC22053ub1J, 0, 892);
                MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            }
            interfaceC22053ub1J.Q();
            AbstractC16797ls7.i(UY6.c(QD5.settings_appearance_font, interfaceC22053ub1J, 0), AbstractC21822uB5.text_font, null, null, null, null, null, c12829fF.b(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.settings_appearance_wallpaper, interfaceC22053ub1J, 0), AbstractC21822uB5.image, null, null, null, null, null, c12829fF.d(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC16797ls7.i(UY6.c(QD5.settings_appearance_appbar, interfaceC22053ub1J, 0), AbstractC21822uB5.pallete, null, null, null, null, null, c12829fF.a(), null, false, interfaceC22053ub1J, 0, 892);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.hF
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC14640iF.f(eVar, c12829fF, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(androidx.compose.ui.e eVar, C12829fF c12829fF, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(c12829fF, "$appearanceNavigationCallbacks");
        e(eVar, c12829fF, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
