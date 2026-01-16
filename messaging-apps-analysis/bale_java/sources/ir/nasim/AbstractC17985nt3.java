package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC16030kb1;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.nt3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC17985nt3 {

    /* renamed from: ir.nasim.nt3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19758qt3 c;
        final /* synthetic */ SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C19758qt3 c19758qt3, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19758qt3;
            this.d = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c.f()) {
                this.d.invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.nt3$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        /* renamed from: ir.nasim.nt3$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC21639ts7.i(UY6.c(QD5.settings_lang, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-429108946, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.nt3$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ C19758qt3 a;
        final /* synthetic */ UA2 b;

        c(C19758qt3 c19758qt3, UA2 ua2) {
            this.a = c19758qt3;
            this.b = ua2;
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
                AbstractC17985nt3.i(AbstractC8014Ud6.g(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null), this.a, this.b, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void g(final C19758qt3 c19758qt3, final SA2 sa2, final SA2 sa22, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c19758qt3, "state");
        AbstractC13042fc3.i(sa2, "onBackPress");
        AbstractC13042fc3.i(sa22, "updateLanguage");
        AbstractC13042fc3.i(ua2, "onLanguageChanged");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1108681678);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c19758qt3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Boolean boolValueOf = Boolean.valueOf(c19758qt3.f());
            interfaceC22053ub1J.W(-1514262282);
            boolean z = ((i2 & 896) == 256) | ((i2 & 14) == 4);
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c19758qt3, sa22, null);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(-1514260250);
            if (c19758qt3.e()) {
                CG3.g(null, null, null, interfaceC22053ub1J, 0, 7);
            }
            interfaceC22053ub1J.Q();
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(-816161298, true, new b(sa2), interfaceC22053ub1J, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1953371389, true, new c(c19758qt3, ua2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805306422, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ht3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17985nt3.h(c19758qt3, sa2, sa22, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(C19758qt3 c19758qt3, SA2 sa2, SA2 sa22, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c19758qt3, "$state");
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(sa22, "$updateLanguage");
        AbstractC13042fc3.i(ua2, "$onLanguageChanged");
        g(c19758qt3, sa2, sa22, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final androidx.compose.ui.e eVar, final C19758qt3 c19758qt3, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-503307436);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c19758qt3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
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
            String strC = UY6.c(QD5.lang_farsi, interfaceC22053ub1J, 0);
            boolean z = c19758qt3.d() == EnumC18576ot3.b;
            interfaceC22053ub1J.W(-917114518);
            int i3 = i2 & 896;
            boolean z2 = i3 == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.it3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC17985nt3.j(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC16867m00.e(strC, z, null, null, (SA2) objB, false, null, interfaceC22053ub1J, 0, Type.EUI48);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            String strC2 = UY6.c(QD5.lang_english, interfaceC22053ub1J, 0);
            boolean z3 = c19758qt3.d() == EnumC18576ot3.c;
            interfaceC22053ub1J.W(-917105076);
            boolean z4 = i3 == 256;
            Object objB2 = interfaceC22053ub1J.B();
            if (z4 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.jt3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC17985nt3.k(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC16867m00.e(strC2, z3, null, null, (SA2) objB2, false, null, interfaceC22053ub1J, 0, Type.EUI48);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            String strC3 = UY6.c(QD5.lang_arabic, interfaceC22053ub1J, 0);
            boolean z5 = c19758qt3.d() == EnumC18576ot3.d;
            interfaceC22053ub1J.W(-917095637);
            boolean z6 = i3 == 256;
            Object objB3 = interfaceC22053ub1J.B();
            if (z6 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.kt3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC17985nt3.l(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC16867m00.e(strC3, z5, null, null, (SA2) objB3, false, null, interfaceC22053ub1J, 0, Type.EUI48);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            String strC4 = UY6.c(QD5.lang_torki, interfaceC22053ub1J, 0);
            boolean z7 = c19758qt3.d() == EnumC18576ot3.e;
            interfaceC22053ub1J.W(-917086294);
            boolean z8 = i3 == 256;
            Object objB4 = interfaceC22053ub1J.B();
            if (z8 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.lt3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC17985nt3.m(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            AbstractC16867m00.e(strC4, z7, null, null, (SA2) objB4, false, null, interfaceC22053ub1J, 0, Type.EUI48);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.mt3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17985nt3.n(eVar, c19758qt3, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onLanguageChanged");
        ua2.invoke(EnumC18576ot3.b);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onLanguageChanged");
        ua2.invoke(EnumC18576ot3.c);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onLanguageChanged");
        ua2.invoke(EnumC18576ot3.d);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onLanguageChanged");
        ua2.invoke(EnumC18576ot3.e);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(androidx.compose.ui.e eVar, C19758qt3 c19758qt3, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(c19758qt3, "$state");
        AbstractC13042fc3.i(ua2, "$onLanguageChanged");
        i(eVar, c19758qt3, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
