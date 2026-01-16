package ir.nasim;

/* renamed from: ir.nasim.d71, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11504d71 {
    public static final C11504d71 a = new C11504d71();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(1157367890, false, a.a);
    public static InterfaceC15796kB2 c = AbstractC19242q11.c(1005248229, false, b.a);

    /* renamed from: ir.nasim.d71$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC14603iB2, "openDialog");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC10280bO1.o(interfaceC14603iB2, null, interfaceC22053ub1, i & 14, 2);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.d71$b */
    static final class b implements InterfaceC15796kB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC14603iB2, "openDialog");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC7809Th1.n(interfaceC14603iB2, null, interfaceC22053ub1, i & 14, 2);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
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
