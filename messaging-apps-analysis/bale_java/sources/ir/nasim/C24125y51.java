package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.C24125y51;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.y51, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24125y51 {
    public static final C24125y51 a = new C24125y51();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-1517423683, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(225290741, false, b.a);

    /* renamed from: ir.nasim.y51$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$SwipeToDismissBox");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.y51$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 A() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 B() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 w() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 x() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z() {
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            o((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }

        public final void o(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C24254yJ c24254yJ = C24254yJ.a;
            float fQ = C17784nZ1.q(8);
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            C24254yJ.m mVarQ = c24254yJ.q(fQ, aVar.i());
            e.a aVar2 = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarQ, aVar.k(), interfaceC22053ub1, 6);
            int i2 = 0;
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar2);
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
            C20158ra2 c20158ra2C = AbstractC21387ta2.c(1);
            String strC = UY6.c(AbstractC12217eE5.event_bar_update_title_text, interfaceC22053ub1, 0);
            String strC2 = UY6.c(AbstractC12217eE5.event_bar_update_button_text, interfaceC22053ub1, 0);
            long j = 29000000;
            long jCurrentTimeMillis = System.currentTimeMillis() + j;
            interfaceC22053ub1.W(640214721);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
            if (objB == aVar4.a()) {
                objB = new SA2() { // from class: ir.nasim.z51
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24125y51.b.p();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(640215937);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar4.a()) {
                objB2 = new SA2() { // from class: ir.nasim.A51
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24125y51.b.A();
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa22 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(640217185);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar4.a()) {
                objB3 = new SA2() { // from class: ir.nasim.B51
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24125y51.b.B();
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC4179Ea2.f(strC, strC2, c20158ra2C, jCurrentTimeMillis, false, true, sa2, sa22, (SA2) objB3, interfaceC22053ub1, 115040256, 0);
            interfaceC22053ub1.W(640219225);
            while (i2 < 7) {
                i2++;
                C20158ra2 c20158ra2C2 = AbstractC21387ta2.c(i2);
                long jCurrentTimeMillis2 = System.currentTimeMillis() + j;
                interfaceC22053ub1.W(85473536);
                Object objB4 = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar5 = InterfaceC22053ub1.a;
                if (objB4 == aVar5.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.C51
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C24125y51.b.y();
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                SA2 sa23 = (SA2) objB4;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(85474880);
                Object objB5 = interfaceC22053ub1.B();
                if (objB5 == aVar5.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.D51
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C24125y51.b.z();
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                SA2 sa24 = (SA2) objB5;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(85476256);
                Object objB6 = interfaceC22053ub1.B();
                if (objB6 == aVar5.a()) {
                    objB6 = new SA2() { // from class: ir.nasim.E51
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C24125y51.b.t();
                        }
                    };
                    interfaceC22053ub1.s(objB6);
                }
                interfaceC22053ub1.Q();
                AbstractC4179Ea2.f("🕕 آخرین روزهای قرعه\u200cکشی مسابقه با جوایز ویژه! آخرین آخرین آخرین ", "عضویت", c20158ra2C2, jCurrentTimeMillis2, false, false, sa23, sa24, (SA2) objB6, interfaceC22053ub1, 114843702, 32);
                C20158ra2 c20158ra2C3 = AbstractC21387ta2.c(i2);
                long jCurrentTimeMillis3 = System.currentTimeMillis() + j;
                interfaceC22053ub1.W(85489632);
                Object objB7 = interfaceC22053ub1.B();
                if (objB7 == aVar5.a()) {
                    objB7 = new SA2() { // from class: ir.nasim.F51
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C24125y51.b.v();
                        }
                    };
                    interfaceC22053ub1.s(objB7);
                }
                SA2 sa25 = (SA2) objB7;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(85490976);
                Object objB8 = interfaceC22053ub1.B();
                if (objB8 == aVar5.a()) {
                    objB8 = new SA2() { // from class: ir.nasim.G51
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C24125y51.b.w();
                        }
                    };
                    interfaceC22053ub1.s(objB8);
                }
                SA2 sa26 = (SA2) objB8;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(85492352);
                Object objB9 = interfaceC22053ub1.B();
                if (objB9 == aVar5.a()) {
                    objB9 = new SA2() { // from class: ir.nasim.H51
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C24125y51.b.x();
                        }
                    };
                    interfaceC22053ub1.s(objB9);
                }
                interfaceC22053ub1.Q();
                AbstractC4179Ea2.f(" فرصت بردن جوایز میلیونی!", "بیشتر", c20158ra2C3, jCurrentTimeMillis3, true, false, sa25, sa26, (SA2) objB9, interfaceC22053ub1, 114843702, 32);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }
}
