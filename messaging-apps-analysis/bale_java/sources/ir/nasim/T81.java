package ir.nasim;

/* loaded from: classes7.dex */
public final class T81 {
    public static final T81 a = new T81();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(636019663, false, a.a);

    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "modifier");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(eVar) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(AbstractC22412vB5.simple_arrow_right, interfaceC22053ub1, 0), null, AbstractC18394ob1.d(eVar, false, 1, null), G10.a.a(interfaceC22053ub1, G10.b).I(), interfaceC22053ub1, 48, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
