package ir.nasim;

/* loaded from: classes4.dex */
public final class K81 {
    public static final K81 a = new K81();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(157667580, false, a.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(AbstractC15208jB5.close, interfaceC22053ub1, 0), UY6.c(DD5.persian_close, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), G10.a.a(interfaceC22053ub1, G10.b).B(), interfaceC22053ub1, 384, 0);
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
