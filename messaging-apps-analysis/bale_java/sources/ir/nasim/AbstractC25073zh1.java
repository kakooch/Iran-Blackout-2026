package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.JK4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.zh1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC25073zh1 {

    /* renamed from: ir.nasim.zh1$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ JK4 a;
        final /* synthetic */ C25038zd6 b;

        /* renamed from: ir.nasim.zh1$a$a, reason: collision with other inner class name */
        static final class C1820a implements InterfaceC14603iB2 {
            public static final C1820a a = new C1820a();

            C1820a() {
            }

            public final String a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(-2129843711);
                interfaceC22053ub1.Q();
                return "";
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            }
        }

        a(JK4 jk4, C25038zd6 c25038zd6) {
            this.a = jk4;
            this.b = c25038zd6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C25038zd6 c25038zd6, C20836sh1 c20836sh1) {
            AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
            AbstractC13042fc3.i(c20836sh1, "$item");
            c25038zd6.f().invoke(c20836sh1.c());
            return C19938rB7.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(ir.nasim.InterfaceC6988Pv3 r19, int r20, ir.nasim.InterfaceC22053ub1 r21, int r22) {
            /*
                Method dump skipped, instructions count: 325
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25073zh1.a.b(ir.nasim.Pv3, int, ir.nasim.ub1, int):void");
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zh1$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C25038zd6 a;

        b(C25038zd6 c25038zd6) {
            this.a = c25038zd6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC20434s03.a(this.a.e(), null, false, null, null, E31.a.b(), interfaceC22053ub1, 196608, 30);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void f(androidx.compose.ui.e eVar, final JK4 jk4, final C25038zd6 c25038zd6, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(jk4, "uiState");
        AbstractC13042fc3.i(c25038zd6, "screenDelegate");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1883401250);
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
            i3 |= interfaceC22053ub1J.D(jk4) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(c25038zd6) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            interfaceC22053ub1J.W(-311026874);
            boolean zD = interfaceC22053ub1J.D(jk4) | ((i3 & 896) == 256);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.wh1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC25073zh1.g(jk4, c25038zd6, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(eVar3, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1J, i3 & 14, 510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25073zh1.h(eVar3, jk4, c25038zd6, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(JK4 jk4, C25038zd6 c25038zd6, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        JK4.a aVarC = jk4.c();
        if (aVarC instanceof JK4.a.b) {
            for (int i = 0; i < 10; i++) {
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, E31.a.c(), 3, null);
            }
        } else {
            if (!(aVarC instanceof JK4.a.C0443a)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC15069ix3.g(interfaceC15069ix3, ((JK4.b.a) jk4.e()).e().size(), null, null, AbstractC19242q11.c(207115199, true, new a(jk4, c25038zd6)), 6, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(androidx.compose.ui.e eVar, JK4 jk4, C25038zd6 c25038zd6, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        f(eVar, jk4, c25038zd6, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void i(final JK4 jk4, final C25038zd6 c25038zd6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(jk4, "uiState");
        AbstractC13042fc3.i(c25038zd6, "screenDelegate");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-981169587);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(jk4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c25038zd6) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar, G10.a.a(interfaceC22053ub1J, G10.b).r(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC21639ts7.h(E31.a.a(), null, AbstractC19242q11.e(-363148347, true, new b(c25038zd6), interfaceC22053ub1J, 54), null, null, null, null, interfaceC22053ub1J, 390, 122);
            int i3 = i2 << 3;
            interfaceC22053ub12 = interfaceC22053ub1J;
            f(ZY0.b(c9784aZ0, aVar, 1.0f, false, 2, null), jk4, c25038zd6, interfaceC22053ub1J, (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 896), 0);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.vh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25073zh1.j(jk4, c25038zd6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(JK4 jk4, C25038zd6 c25038zd6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        i(jk4, c25038zd6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void k(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(50144617);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, E31.a.g(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.th1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25073zh1.l(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        k(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void m(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(101007174);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, E31.a.e(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.uh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25073zh1.n(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        m(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
