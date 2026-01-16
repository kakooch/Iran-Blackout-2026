package ir.nasim;

import ir.nasim.O51;

/* loaded from: classes5.dex */
public final class O51 {
    public static final O51 a = new O51();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(715295803, false, a.a);
    public static InterfaceC15796kB2 c = AbstractC19242q11.c(-1556485114, false, b.a);

    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC15254jG6 interfaceC15254jG6, boolean z) {
            AbstractC13042fc3.i(interfaceC15254jG6, "$snackBar");
            interfaceC15254jG6.dismiss();
            return C19938rB7.a;
        }

        public final void b(final InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strB = interfaceC15254jG6.a().b();
            interfaceC22053ub1.W(-427954770);
            boolean z = (i & 14) == 4;
            Object objB = interfaceC22053ub1.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.N51
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return O51.a.c(interfaceC15254jG6, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10984cY.c(strB, null, null, 0, (UA2) objB, interfaceC22053ub1, 0, 14);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC4584Ft2.w(UY6.c(FD5.default_folder, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 2);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }

    public final InterfaceC15796kB2 b() {
        return c;
    }
}
