package ir.nasim;

import android.app.Dialog;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C13245fu;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.cB3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC10781cB3 {

    /* renamed from: ir.nasim.cB3$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C13245fu a;

        a(C13245fu c13245fu) {
            this.a = c13245fu;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1, 6).b();
            AbstractC9339Zm7.c(this.a, null, g10.a(interfaceC22053ub1, 6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, null, c9348Zn7B, interfaceC22053ub1, 0, 0, 130554);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cB3$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C13245fu a;

        b(C13245fu c13245fu) {
            this.a = c13245fu;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1, 6).b();
            AbstractC9339Zm7.c(this.a, null, g10.a(interfaceC22053ub1, 6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, null, c9348Zn7B, interfaceC22053ub1, 0, 0, 130554);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cB3$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ C13245fu a;

        c(C13245fu c13245fu) {
            this.a = c13245fu;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1, 6).b();
            AbstractC9339Zm7.c(this.a, null, g10.a(interfaceC22053ub1, 6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, null, c9348Zn7B, interfaceC22053ub1, 0, 0, 130554);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        z(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void C(final Dialog dialog, final String str, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "link");
        AbstractC13042fc3.i(sa2, "onOkClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(206321832);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(dialog) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-193930276);
            C13245fu.b bVar = new C13245fu.b(0, 1, null);
            bVar.h(UY6.c(UD5.link_status_unknown, interfaceC22053ub1J, 0) + Separators.RETURN);
            int iN = bVar.n(new C12863fI6(G10.a.b(interfaceC22053ub1J, 6).c(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, C24525yl7.b.d(), (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 61438, (ED1) null));
            try {
                bVar.h(str);
                C19938rB7 c19938rB7 = C19938rB7.a;
                bVar.l(iN);
                C13245fu c13245fuO = bVar.o();
                interfaceC22053ub1J.Q();
                InterfaceC14603iB2 interfaceC14603iB2B = C22359v61.a.b();
                AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(642329226, true, new c(c13245fuO), interfaceC22053ub1J, 54);
                AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                interfaceC22053ub1J.W(-193893881);
                int i3 = (interfaceC22053ub1J.D(dialog) ? 1 : 0) | ((i2 & 896) == 256 ? 1 : 0);
                Object objB = interfaceC22053ub1J.B();
                if (i3 != 0 || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.QA3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC10781cB3.F(dialog, sa2);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                SA2 sa22 = (SA2) objB;
                interfaceC22053ub1J.Q();
                int i4 = UD5.link_status_unknown_positive_button;
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                interfaceC22053ub1J.W(-193886426);
                boolean zD = interfaceC22053ub1J.D(dialog);
                Object objB2 = interfaceC22053ub1J.B();
                if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.RA3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC10781cB3.D(dialog);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                AbstractC19555qZ.E(interfaceC14603iB2B, cVar, interfaceC18060o11E, cVar2, aVar, sa22, i4, c1454b, (SA2) objB2, UD5.link_status_unknown_cancel_button, null, interfaceC22053ub1J, 12610998, 0, 1024);
            } catch (Throwable th) {
                bVar.l(iN);
                throw th;
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.SA3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10781cB3.E(dialog, str, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(Dialog dialog, String str, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$link");
        AbstractC13042fc3.i(sa2, "$onOkClicked");
        C(dialog, str, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(Dialog dialog, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onOkClicked");
        if (dialog != null) {
            dialog.dismiss();
        }
        sa2.invoke();
        return C19938rB7.a;
    }

    public static final void n(final Dialog dialog, final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "link");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(27924370);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(dialog) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-1620269284);
            C13245fu.b bVar = new C13245fu.b(0, 1, null);
            bVar.h(UY6.c(UD5.link_status_block, interfaceC22053ub1J, 0) + Separators.RETURN);
            int iN = bVar.n(new C12863fI6(G10.a.b(interfaceC22053ub1J, 6).c(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, C24525yl7.b.d(), (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 61438, (ED1) null));
            try {
                bVar.h(str);
                C19938rB7 c19938rB7 = C19938rB7.a;
                bVar.l(iN);
                C13245fu c13245fuO = bVar.o();
                interfaceC22053ub1J.Q();
                InterfaceC14603iB2 interfaceC14603iB2A = C22359v61.a.a();
                AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-560649183, true, new a(c13245fuO), interfaceC22053ub1J, 54);
                AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                interfaceC22053ub1J.W(-1620233624);
                boolean zD = interfaceC22053ub1J.D(dialog);
                Object objB = interfaceC22053ub1J.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.TA3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC10781cB3.o(dialog);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                AbstractC19555qZ.S(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, null, aVar, (SA2) objB, UD5.link_status_block_positive_button, interfaceC22053ub1J, 200118, 16);
            } catch (Throwable th) {
                bVar.l(iN);
                throw th;
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.UA3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10781cB3.p(dialog, str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(Dialog dialog, String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$link");
        n(dialog, str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void q(final Dialog dialog, final String str, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "link");
        AbstractC13042fc3.i(sa2, "onOkClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-300798422);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(dialog) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(541270744);
            C13245fu.b bVar = new C13245fu.b(0, 1, null);
            bVar.h(UY6.c(UD5.link_status_error, interfaceC22053ub1J, 0) + Separators.RETURN);
            int iN = bVar.n(new C12863fI6(G10.a.b(interfaceC22053ub1J, 6).c(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, C24525yl7.b.d(), (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 61438, (ED1) null));
            try {
                bVar.h(str);
                C19938rB7 c19938rB7 = C19938rB7.a;
                bVar.l(iN);
                C13245fu c13245fuO = bVar.o();
                interfaceC22053ub1J.Q();
                InterfaceC14603iB2 interfaceC14603iB2C = C22359v61.a.c();
                AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-184143732, true, new b(c13245fuO), interfaceC22053ub1J, 54);
                AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                interfaceC22053ub1J.W(541307013);
                int i3 = (interfaceC22053ub1J.D(dialog) ? 1 : 0) | ((i2 & 896) == 256 ? 1 : 0);
                Object objB = interfaceC22053ub1J.B();
                if (i3 != 0 || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.ZA3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC10781cB3.r(dialog, sa2);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                SA2 sa22 = (SA2) objB;
                interfaceC22053ub1J.Q();
                int i4 = UD5.link_status_unknown_positive_button;
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                interfaceC22053ub1J.W(541314468);
                boolean zD = interfaceC22053ub1J.D(dialog);
                Object objB2 = interfaceC22053ub1J.B();
                if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.aB3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC10781cB3.s(dialog);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                AbstractC19555qZ.E(interfaceC14603iB2C, cVar, interfaceC18060o11E, cVar2, aVar, sa22, i4, c1454b, (SA2) objB2, UD5.link_status_unknown_cancel_button, null, interfaceC22053ub1J, 12610998, 0, 1024);
            } catch (Throwable th) {
                bVar.l(iN);
                throw th;
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.bB3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10781cB3.t(dialog, str, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(Dialog dialog, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onOkClicked");
        if (dialog != null) {
            dialog.dismiss();
        }
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(Dialog dialog, String str, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$link");
        AbstractC13042fc3.i(sa2, "$onOkClicked");
        q(dialog, str, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void u(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1252474823);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            n(null, "www.google.com", interfaceC22053ub1J, 54);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.PA3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10781cB3.v(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        u(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void w(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(303180369);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-1347441789);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.XA3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10781cB3.x();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            q(null, "www.google.com", (SA2) objB, interfaceC22053ub1J, 438);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.YA3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10781cB3.y(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        w(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void z(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1663938715);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1457888135);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.VA3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10781cB3.A();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            C(null, "www.google.com", (SA2) objB, interfaceC22053ub1J, 438);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.WA3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10781cB3.B(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
