package ir.nasim;

/* renamed from: ir.nasim.e41, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12117e41 {
    public static final C12117e41 a = new C12117e41();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-884507790, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-531851276, false, b.a);

    /* renamed from: ir.nasim.e41$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.B0(UY6.c(AbstractC12217eE5.crowdfunding_stop_the_crowdfunding_title, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.e41$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.e0(UY6.c(AbstractC12217eE5.crowdfunding_stop_the_crowdfunding_description, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
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
