package ir.nasim;

import ir.nasim.C19701qn6;
import ir.nasim.InterfaceC23364wn6;

/* renamed from: ir.nasim.wn6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC23364wn6 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.wn6$a */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final InterfaceC23364wn6 b = new InterfaceC23364wn6() { // from class: ir.nasim.rn6
            @Override // ir.nasim.InterfaceC23364wn6
            public final C19701qn6 a(InterfaceC4066Dn6 interfaceC4066Dn6) {
                return InterfaceC23364wn6.a.h(interfaceC4066Dn6);
            }
        };
        private static final InterfaceC23364wn6 c = new InterfaceC23364wn6() { // from class: ir.nasim.sn6
            @Override // ir.nasim.InterfaceC23364wn6
            public final C19701qn6 a(InterfaceC4066Dn6 interfaceC4066Dn6) {
                return InterfaceC23364wn6.a.f(interfaceC4066Dn6);
            }
        };
        private static final InterfaceC23364wn6 d = new InterfaceC23364wn6() { // from class: ir.nasim.tn6
            @Override // ir.nasim.InterfaceC23364wn6
            public final C19701qn6 a(InterfaceC4066Dn6 interfaceC4066Dn6) {
                return InterfaceC23364wn6.a.j(interfaceC4066Dn6);
            }
        };
        private static final InterfaceC23364wn6 e = new InterfaceC23364wn6() { // from class: ir.nasim.un6
            @Override // ir.nasim.InterfaceC23364wn6
            public final C19701qn6 a(InterfaceC4066Dn6 interfaceC4066Dn6) {
                return InterfaceC23364wn6.a.i(interfaceC4066Dn6);
            }
        };
        private static final InterfaceC23364wn6 f = new InterfaceC23364wn6() { // from class: ir.nasim.vn6
            @Override // ir.nasim.InterfaceC23364wn6
            public final C19701qn6 a(InterfaceC4066Dn6 interfaceC4066Dn6) {
                return InterfaceC23364wn6.a.g(interfaceC4066Dn6);
            }
        };

        /* renamed from: ir.nasim.wn6$a$a, reason: collision with other inner class name */
        static final class C1767a implements InterfaceC25102zk0 {
            public static final C1767a a = new C1767a();

            C1767a() {
            }

            @Override // ir.nasim.InterfaceC25102zk0
            public final long a(C8329Vm6 c8329Vm6, int i) {
                return IY6.c(c8329Vm6.c(), i);
            }
        }

        /* renamed from: ir.nasim.wn6$a$b */
        static final class b implements InterfaceC25102zk0 {
            public static final b a = new b();

            b() {
            }

            @Override // ir.nasim.InterfaceC25102zk0
            public final long a(C8329Vm6 c8329Vm6, int i) {
                return c8329Vm6.k().C(i);
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19701qn6 f(InterfaceC4066Dn6 interfaceC4066Dn6) {
            return AbstractC23954xn6.h(b.a(interfaceC4066Dn6), interfaceC4066Dn6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19701qn6 g(InterfaceC4066Dn6 interfaceC4066Dn6) {
            C19701qn6.a aVarC;
            C19701qn6.a aVarL;
            C19701qn6.a aVarE;
            C19701qn6.a aVarC2;
            C19701qn6 c19701qn6I = interfaceC4066Dn6.i();
            if (c19701qn6I == null) {
                return d.a(interfaceC4066Dn6);
            }
            if (interfaceC4066Dn6.a()) {
                aVarC = c19701qn6I.e();
                aVarL = AbstractC23954xn6.l(interfaceC4066Dn6, interfaceC4066Dn6.k(), aVarC);
                aVarC2 = c19701qn6I.c();
                aVarE = aVarL;
            } else {
                aVarC = c19701qn6I.c();
                aVarL = AbstractC23954xn6.l(interfaceC4066Dn6, interfaceC4066Dn6.j(), aVarC);
                aVarE = c19701qn6I.e();
                aVarC2 = aVarL;
            }
            if (AbstractC13042fc3.d(aVarL, aVarC)) {
                return c19701qn6I;
            }
            return AbstractC23954xn6.h(new C19701qn6(aVarE, aVarC2, interfaceC4066Dn6.e() == EnumC5309Iu1.a || (interfaceC4066Dn6.e() == EnumC5309Iu1.c && aVarE.c() > aVarC2.c())), interfaceC4066Dn6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19701qn6 h(InterfaceC4066Dn6 interfaceC4066Dn6) {
            return new C19701qn6(interfaceC4066Dn6.k().a(interfaceC4066Dn6.k().g()), interfaceC4066Dn6.j().a(interfaceC4066Dn6.j().e()), interfaceC4066Dn6.e() == EnumC5309Iu1.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19701qn6 i(InterfaceC4066Dn6 interfaceC4066Dn6) {
            return AbstractC23954xn6.e(interfaceC4066Dn6, C1767a.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19701qn6 j(InterfaceC4066Dn6 interfaceC4066Dn6) {
            return AbstractC23954xn6.e(interfaceC4066Dn6, b.a);
        }

        public final InterfaceC23364wn6 k() {
            return f;
        }

        public final InterfaceC23364wn6 l() {
            return b;
        }

        public final InterfaceC23364wn6 m() {
            return e;
        }

        public final InterfaceC23364wn6 n() {
            return d;
        }
    }

    C19701qn6 a(InterfaceC4066Dn6 interfaceC4066Dn6);
}
