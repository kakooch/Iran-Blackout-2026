package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC3760Cf6;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Cf6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC3760Cf6 {

    /* renamed from: ir.nasim.Cf6$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ String a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ SA2 c;

        /* renamed from: ir.nasim.Cf6$a$a, reason: collision with other inner class name */
        static final class C0310a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;
            final /* synthetic */ UA2 b;
            final /* synthetic */ SA2 c;

            /* renamed from: ir.nasim.Cf6$a$a$a, reason: collision with other inner class name */
            static final class C0311a implements InterfaceC14603iB2 {
                final /* synthetic */ String a;
                final /* synthetic */ UA2 b;

                /* renamed from: ir.nasim.Cf6$a$a$a$a, reason: collision with other inner class name */
                static final class C0312a implements InterfaceC14603iB2 {
                    final /* synthetic */ String a;
                    final /* synthetic */ UA2 b;

                    C0312a(String str, UA2 ua2) {
                        this.a = str;
                        this.b = ua2;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else {
                            AbstractC16075kf6.j(UY6.c(AbstractC12217eE5.search_hint_chat, interfaceC22053ub1, 0), this.a, this.b, true, null, null, true, null, null, null, null, interfaceC22053ub1, 1575936, 0, 1968);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C0311a(String str, UA2 ua2) {
                    this.a = str;
                    this.b = ua2;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().u(), 0.0f, 2, null);
                    InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
                    String str = this.a;
                    UA2 ua2 = this.b;
                    InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
                    InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar.a();
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
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                    androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                    AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(-2065712961, true, new C0312a(str, ua2), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Cf6$a$a$b */
            static final class b implements InterfaceC14603iB2 {
                final /* synthetic */ SA2 a;

                b(SA2 sa2) {
                    this.a = sa2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(SA2 sa2) {
                    AbstractC13042fc3.i(sa2, "$onBackPressed");
                    sa2.invoke();
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    e.a aVar = androidx.compose.ui.e.a;
                    androidx.compose.ui.e eVarD = androidx.compose.foundation.layout.t.d(aVar, 0.0f, 1, null);
                    G10 g10 = G10.a;
                    int i2 = G10.b;
                    androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(eVarD, g10.c(interfaceC22053ub1, i2).b().c(), 0.0f, 0.0f, 0.0f, 14, null);
                    InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
                    final SA2 sa2 = this.a;
                    InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
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
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                    androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                    androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j());
                    interfaceC22053ub1.W(1788877818);
                    boolean zV = interfaceC22053ub1.V(sa2);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Df6
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC3760Cf6.a.C0310a.b.c(sa2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC24077y03.b(C02.e(new SV(false), interfaceC22053ub1, 0), UY6.c(AbstractC12217eE5.submit_return, interfaceC22053ub1, 0), androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), g10.a(interfaceC22053ub1, i2).G(), interfaceC22053ub1, 0, 0);
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            C0310a(String str, UA2 ua2, SA2 sa2) {
                this.a = str;
                this.b = ua2;
                this.c = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                A98 a98A = AbstractC21393ta8.a(0, 0, 0, 0);
                androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.t.b(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(56), 1, null);
                C17388ms7 c17388ms7A = C17979ns7.a.a(interfaceC22053ub1, C17979ns7.g);
                ED.a(AbstractC19242q11.e(-19954491, true, new C0311a(this.a, this.b), interfaceC22053ub1, 54), eVarB, AbstractC19242q11.e(-292009085, true, new b(this.c), interfaceC22053ub1, 54), null, 0.0f, a98A, c17388ms7A.b((30 & 1) != 0 ? c17388ms7A.a : G10.a.a(interfaceC22053ub1, G10.b).q(), (30 & 2) != 0 ? c17388ms7A.b : 0L, (30 & 4) != 0 ? c17388ms7A.c : 0L, (30 & 8) != 0 ? c17388ms7A.d : 0L, (30 & 16) != 0 ? c17388ms7A.e : 0L), null, interfaceC22053ub1, 438, 152);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(String str, UA2 ua2, SA2 sa2) {
            this.a = str;
            this.b = ua2;
            this.c = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(911140938, true, new C0310a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final String str, final UA2 ua2, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(ua2, "onQueryChange");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(204187877);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(734090506, true, new a(str, ua2, sa2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Bf6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC3760Cf6.c(str, ua2, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(String str, UA2 ua2, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$query");
        AbstractC13042fc3.i(ua2, "$onQueryChange");
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        b(str, ua2, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
