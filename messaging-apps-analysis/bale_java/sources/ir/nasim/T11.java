package ir.nasim;

/* loaded from: classes5.dex */
public final class T11 {
    public static final T11 a = new T11();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(132307108, false, a.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC24077y03.a(FN1.d(EnumC23487x03.D, interfaceC22053ub1, 6), UY6.c(FD5.more, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), G10.a.a(interfaceC22053ub1, G10.b).G(), interfaceC22053ub1, 384, 0);
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
