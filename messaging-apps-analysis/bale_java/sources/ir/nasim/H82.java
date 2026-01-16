package ir.nasim;

import ir.nasim.AbstractC10289bP1;
import ir.nasim.H82;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;

/* loaded from: classes4.dex */
public abstract class H82 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;

        a(SA2 sa2, SA2 sa22) {
            this.a = sa2;
            this.b = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onEndRecordClicked");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C22945w51 c22945w51 = C22945w51.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c22945w51.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c22945w51.b();
            AbstractC10289bP1.a.b bVar = AbstractC10289bP1.a.b.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(435572283);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.F82
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return H82.a.d(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC = UY6.c(BD5.cancel, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(435578909);
            boolean zV2 = interfaceC22053ub1.V(this.b);
            final SA2 sa23 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.G82
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return H82.a.f(sa23);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2A, c0905b, interfaceC14603iB2B, bVar, c1454b, sa22, strC, aVar, (SA2) objB2, UY6.c(BD5.end_record_accept_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.b.b << 9) | (InterfaceC19114po0.b.C1454b.b << 12) | (InterfaceC19114po0.b.a.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void f(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(sa22, "onEndRecordClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1388787758);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-300181312);
            boolean z = (i2 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.D82
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return H82.g(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC6687Oo.a((SA2) objB, null, AbstractC19242q11.e(369253765, true, new a(sa2, sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, 384, 2);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.E82
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return H82.h(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(sa22, "$onEndRecordClicked");
        f(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void i(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(528573458);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1121594848);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.A82
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return H82.j();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1121594976);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.B82
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return H82.k();
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            f(sa2, (SA2) objB2, interfaceC22053ub1J, 54);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.C82
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return H82.l(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        i(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
