package ir.nasim;

/* loaded from: classes7.dex */
public final class J11 {
    public static final J11 a = new J11();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(601930928, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-1410497329, false, b.a);
    public static InterfaceC14603iB2 d = AbstractC19242q11.c(-1336512113, false, c.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC9339Zm7.b(UY6.c(QD5.phone_menu_change_number, interfaceC22053ub1, 0), null, 0L, 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1, G10.b).l(), interfaceC22053ub1, 0, 0, 65022);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(AbstractC21822uB5.arrow_left, interfaceC22053ub1, 0), UY6.c(QD5.submit_return, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1, G10.b).b().j()), 0L, interfaceC22053ub1, 0, 8);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.B0(UY6.c(AbstractC12217eE5.wallet_amount_not_empty_change_number, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
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

    public final InterfaceC14603iB2 c() {
        return d;
    }
}
