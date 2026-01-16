package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC22569vT0;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;

/* renamed from: ir.nasim.vT0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC22569vT0 {

    /* renamed from: ir.nasim.vT0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C8588Wp4 a;

        /* renamed from: ir.nasim.vT0$a$a, reason: collision with other inner class name */
        static final class C1664a implements InterfaceC14603iB2 {
            final /* synthetic */ C8588Wp4 a;

            /* renamed from: ir.nasim.vT0$a$a$a, reason: collision with other inner class name */
            static final class C1665a implements InterfaceC14603iB2 {
                final /* synthetic */ C8588Wp4 a;

                C1665a(C8588Wp4 c8588Wp4) {
                    this.a = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C8588Wp4 c8588Wp4) {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c8588Wp4.V();
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    interfaceC22053ub1.W(-390088555);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C8588Wp4 c8588Wp4 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.uT0
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC22569vT0.a.C1664a.C1665a.c(c8588Wp4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC20434s03.a((SA2) objB, null, false, null, null, C18080o31.a.b(), interfaceC22053ub1, 196608, 30);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            C1664a(C8588Wp4 c8588Wp4) {
                this.a = c8588Wp4;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C17388ms7 c17388ms7A = C17979ns7.a.a(interfaceC22053ub1, C17979ns7.g);
                ED.a(C18080o31.a.a(), null, AbstractC19242q11.e(1247829430, true, new C1665a(this.a), interfaceC22053ub1, 54), null, 0.0f, null, c17388ms7A.b((30 & 1) != 0 ? c17388ms7A.a : G10.a.a(interfaceC22053ub1, G10.b).r(), (30 & 2) != 0 ? c17388ms7A.b : 0L, (30 & 4) != 0 ? c17388ms7A.c : 0L, (30 & 8) != 0 ? c17388ms7A.d : 0L, (30 & 16) != 0 ? c17388ms7A.e : 0L), null, interfaceC22053ub1, 390, 186);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(C8588Wp4 c8588Wp4) {
            this.a = c8588Wp4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(1957624911, true, new C1664a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vT0$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ String d;

        b(List list, UA2 ua2, UA2 ua22, String str) {
            this.a = list;
            this.b = ua2;
            this.c = ua22;
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(UA2 ua2, String str, UA2 ua22, List list) {
            AbstractC13042fc3.i(ua2, "$onOptionSelected");
            AbstractC13042fc3.i(str, "$it");
            AbstractC13042fc3.i(list, "$radioOptions");
            ua2.invoke(str);
            ua22.invoke(AbstractC13042fc3.d(str, list.get(0)) ? EnumC9389Zs3.a : EnumC9389Zs3.b);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(String str, String str2, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(str, "$it");
            AbstractC13042fc3.i(str2, "$selectedOption");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.F0(interfaceC11943do6, -1.0f);
            AbstractC9939ao6.p0(interfaceC11943do6, B26.b.f());
            AbstractC9939ao6.q0(interfaceC11943do6, AbstractC13042fc3.d(str, str2));
            return C19938rB7.a;
        }

        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r9v7 */
        public final void c(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            InterfaceC22053ub1 interfaceC22053ub12 = interfaceC22053ub1;
            AbstractC13042fc3.i(ts4, "it");
            if ((((i & 6) == 0 ? i | (interfaceC22053ub12.V(ts4) ? 4 : 2) : i) & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            final List<String> list = this.a;
            final UA2 ua2 = this.b;
            final UA2 ua22 = this.c;
            final String str = this.d;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub12, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub12, eVarM);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub12.g(sa2A);
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
            float f = 0.0f;
            ?? r9 = 1;
            float f2 = 1;
            Object obj = null;
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f2)), 0.0f, G10.a.a(interfaceC22053ub12, G10.b).A(), interfaceC22053ub1, 6, 2);
            interfaceC22053ub12.W(1091822889);
            for (final String str2 : list) {
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar3, f, r9, obj);
                interfaceC22053ub12.W(-390053712);
                boolean zV = interfaceC22053ub12.V(ua2) | interfaceC22053ub12.V(str2) | interfaceC22053ub12.V(ua22) | interfaceC22053ub12.V(list);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.wT0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC22569vT0.b.d(ua2, str2, ua22, list);
                        }
                    };
                    interfaceC22053ub12.s(objB);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null);
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarF, g10.c(interfaceC22053ub12, i2).b().c(), g10.c(interfaceC22053ub12, i2).b().e());
                interfaceC22053ub12.W(-390038575);
                boolean zV2 = interfaceC22053ub12.V(str2) | interfaceC22053ub12.V(str);
                Object objB2 = interfaceC22053ub1.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.xT0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return AbstractC22569vT0.b.f(str2, str, (InterfaceC11943do6) obj2);
                        }
                    };
                    interfaceC22053ub12.s(objB2);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarC = AbstractC6919Pn6.c(eVarJ, r9, (UA2) objB2);
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub12, 54);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub12, eVarC);
                InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
                SA2 sa2A2 = aVar4.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub12.g(sa2A2);
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
                QF5.a(AbstractC13042fc3.d(str2, str), null, AbstractC3248Ab3.b(androidx.compose.foundation.layout.t.t(aVar3, g10.c(interfaceC22053ub12, i2).b().h())), false, OF5.a.b(g10.a(interfaceC22053ub12, i2).I(), g10.a(interfaceC22053ub12, i2).B(), 0L, 0L, interfaceC22053ub1, OF5.b << 12, 12), null, interfaceC22053ub1, 48, 40);
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar3, g10.c(interfaceC22053ub12, i2).b().c()), interfaceC22053ub12, 0);
                AbstractC9339Zm7.b(str2, null, g10.a(interfaceC22053ub12, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub12, i2).a(), interfaceC22053ub1, 0, 0, 65018);
                interfaceC22053ub1.u();
                f = 0.0f;
                r9 = 1;
                obj = null;
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), C17784nZ1.q(f2)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
                interfaceC22053ub12 = interfaceC22053ub1;
                list = list;
                ua2 = ua2;
                str = str;
                ua22 = ua22;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final ir.nasim.EnumC9389Zs3 r22, final ir.nasim.C8588Wp4 r23, ir.nasim.UA2 r24, ir.nasim.InterfaceC22053ub1 r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22569vT0.c(ir.nasim.Zs3, ir.nasim.Wp4, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(EnumC9389Zs3 enumC9389Zs3) {
        AbstractC13042fc3.i(enumC9389Zs3, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(EnumC9389Zs3 enumC9389Zs3, C8588Wp4 c8588Wp4, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(enumC9389Zs3, "$currentLanguage");
        AbstractC13042fc3.i(c8588Wp4, "$navController");
        c(enumC9389Zs3, c8588Wp4, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
