package ir.nasim;

/* renamed from: ir.nasim.Da1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3944Da1 {
    public static final C3944Da1 a = new C3944Da1();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-700300092, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-253378040, false, b.a);

    /* renamed from: ir.nasim.Da1$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC9339Zm7.b(UY6.c(QD5.phone_menu_validate_number, interfaceC22053ub1, 0), null, 0L, 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1, G10.b).l(), interfaceC22053ub1, 0, 0, 65022);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Da1$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.h(C3944Da1.a.a(), null, null, null, null, null, null, interfaceC22053ub1, 6, 126);
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
