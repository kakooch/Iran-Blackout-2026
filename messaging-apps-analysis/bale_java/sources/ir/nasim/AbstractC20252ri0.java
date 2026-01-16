package ir.nasim;

import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20252ri0;
import ir.nasim.C13245fu;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import java.util.Iterator;

/* renamed from: ir.nasim.ri0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC20252ri0 {

    /* renamed from: ir.nasim.ri0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;

        /* renamed from: ir.nasim.ri0$a$a, reason: collision with other inner class name */
        static final class C1504a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            C1504a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC20252ri0.f(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, SA2 sa22, SA2 sa23) {
            this.a = sa2;
            this.b = sa22;
            this.c = sa23;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onApproved");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onDeny");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC14603iB2 interfaceC14603iB2A = O21.a.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-199702260, true, new C1504a(this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-1895996907);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.pi0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC20252ri0.a.d(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.Done;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1895990991);
            boolean zV2 = interfaceC22053ub1.V(this.b);
            final SA2 sa23 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.qi0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC20252ri0.a.f(sa23);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, aVar, sa22, i2, c1454b, (SA2) objB2, AbstractC12217eE5.Cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ri0$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ C13245fu b;
        final /* synthetic */ SA2 c;

        b(InterfaceC9102Ym4 interfaceC9102Ym4, C13245fu c13245fu, SA2 sa2) {
            this.a = interfaceC9102Ym4;
            this.b = c13245fu;
            this.c = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(InterfaceC9102Ym4 interfaceC9102Ym4, C13245fu c13245fu, SA2 sa2, ZG4 zg4) {
            Object next;
            AbstractC13042fc3.i(interfaceC9102Ym4, "$layoutResult");
            AbstractC13042fc3.i(c13245fu, "$annotationString");
            AbstractC13042fc3.i(sa2, "$openTermOfUseLink");
            C13774gn7 c13774gn7 = (C13774gn7) interfaceC9102Ym4.getValue();
            if (c13774gn7 != null) {
                Iterator it = c13245fu.i(c13774gn7.x(zg4.t()), c13774gn7.x(zg4.t())).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (AbstractC13042fc3.d(((C13245fu.d) next).i(), "TERMS")) {
                        break;
                    }
                }
                if (((C13245fu.d) next) != null) {
                    sa2.invoke();
                }
            }
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
            final C13245fu c13245fu = this.b;
            final SA2 sa2 = this.c;
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.si0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC20252ri0.b.b(interfaceC9102Ym4, c13245fu, sa2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    public static final void d(final SA2 sa2, final SA2 sa22, final SA2 sa23, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onApproved");
        AbstractC13042fc3.i(sa22, "onDeny");
        AbstractC13042fc3.i(sa23, "openTermOfUseLink");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1923329943);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC6687Oo.a(sa22, new C18876pP1(true, true, false, 4, (ED1) null), AbstractC19242q11.e(1336759342, true, new a(sa2, sa22, sa23), interfaceC22053ub1J, 54), interfaceC22053ub1J, ((i2 >> 3) & 14) | 432, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.mi0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC20252ri0.e(sa2, sa22, sa23, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(SA2 sa2, SA2 sa22, SA2 sa23, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onApproved");
        AbstractC13042fc3.i(sa22, "$onDeny");
        AbstractC13042fc3.i(sa23, "$openTermOfUseLink");
        d(sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1359679571);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-220012160);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(null, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-220009039);
            C13245fu.b bVar = new C13245fu.b(0, 1, null);
            bVar.h(UY6.c(DD5.bot_agreement_dialog_body1, interfaceC22053ub1J, 0));
            bVar.m("TERMS", "terms_of_service");
            interfaceC22053ub1J.W(-220001365);
            G10 g10 = G10.a;
            int i3 = G10.b;
            int iN = bVar.n(new C12863fI6(g10.a(interfaceC22053ub1J, i3).v(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null));
            try {
                bVar.h(UY6.c(DD5.bot_agreement_dialog_body2, interfaceC22053ub1J, 0));
                C19938rB7 c19938rB7 = C19938rB7.a;
                bVar.l(iN);
                interfaceC22053ub1J.Q();
                bVar.k();
                bVar.h(UY6.c(DD5.bot_agreement_dialog_body3, interfaceC22053ub1J, 0));
                C13245fu c13245fuO = bVar.o();
                interfaceC22053ub1J.Q();
                C23546x62 c23546x62B = AbstractC8970Ya1.b(c13245fuO, 0L, 1, null);
                long jF = g10.a(interfaceC22053ub1J, i3).F();
                e.a aVar2 = androidx.compose.ui.e.a;
                C19938rB7 c19938rB72 = C19938rB7.a;
                interfaceC22053ub1J.W(-219985261);
                boolean zV = interfaceC22053ub1J.V(c13245fuO) | ((i2 & 14) == 4);
                Object objB2 = interfaceC22053ub1J.B();
                if (zV || objB2 == aVar.a()) {
                    objB2 = new b(interfaceC9102Ym4, c13245fuO, sa2);
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                androidx.compose.ui.e eVarC = AbstractC21071t37.c(aVar2, c19938rB72, (PointerInputEventHandler) objB2);
                C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1J, i3).b();
                C6399Nk7 c6399Nk7H = C6399Nk7.h(C6399Nk7.b.a());
                interfaceC22053ub1J.W(-219966213);
                Object objB3 = interfaceC22053ub1J.B();
                if (objB3 == aVar.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.ni0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC20252ri0.g(interfaceC9102Ym4, (C13774gn7) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB3);
                }
                interfaceC22053ub1J.Q();
                C62.d(c23546x62B, eVarC, jF, 0L, null, null, null, 0L, null, c6399Nk7H, 0L, 0, false, 0, 0, (UA2) objB3, c9348Zn7B, 0, null, interfaceC22053ub1J, 0, 196608, 425464);
            } catch (Throwable th) {
                bVar.l(iN);
                throw th;
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.oi0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC20252ri0.h(sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(InterfaceC9102Ym4 interfaceC9102Ym4, C13774gn7 c13774gn7) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$layoutResult");
        AbstractC13042fc3.i(c13774gn7, "it");
        interfaceC9102Ym4.setValue(c13774gn7);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$openTermOfUseLink");
        f(sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
