package ir.nasim;

import ir.nasim.C18975pa1;

/* renamed from: ir.nasim.pa1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18975pa1 {
    public static final C18975pa1 a = new C18975pa1();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-2118714814, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-637671678, false, b.a);

    /* renamed from: ir.nasim.pa1$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c() {
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(UD5.preview_title, interfaceC22053ub1, 0);
            int i2 = AbstractC24188yB5.profile;
            interfaceC22053ub1.W(-851999319);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.oa1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C18975pa1.a.c();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16797ls7.i(strC, i2, null, null, null, null, null, (SA2) objB, null, false, interfaceC22053ub1, 12582912, 892);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pa1$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), C18975pa1.a.a(), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }
}
