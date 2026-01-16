package ir.nasim;

/* loaded from: classes4.dex */
public final class I51 {
    public static final I51 a = new I51();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1762225495, false, a.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24667z03.b(FV4.c(KB5.minimize_screen, interfaceC22053ub1, 0), "", null, C24381yX0.b.i(), interfaceC22053ub1, 3120, 4);
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
}
