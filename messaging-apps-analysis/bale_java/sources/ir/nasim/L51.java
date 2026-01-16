package ir.nasim;

/* loaded from: classes5.dex */
public final class L51 {
    public static final L51 a = new L51();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(2113727713, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(91527358, false, b.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(FD5.edit_folder, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).c(), interfaceC22053ub1, 0, 0, 65530);
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
                AbstractC24077y03.b(FV4.c(AbstractC16390lB5.edit, interfaceC22053ub1, 0), null, null, G10.a.a(interfaceC22053ub1, G10.b).F(), interfaceC22053ub1, 48, 4);
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
