package ir.nasim;

/* renamed from: ir.nasim.c61, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10730c61 {
    public static final C10730c61 a = new C10730c61();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-1103613792, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-1359056479, false, b.a);

    /* renamed from: ir.nasim.c61$a */
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

    /* renamed from: ir.nasim.c61$b */
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

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }
}
