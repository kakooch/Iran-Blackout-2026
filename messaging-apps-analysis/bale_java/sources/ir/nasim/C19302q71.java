package ir.nasim;

/* renamed from: ir.nasim.q71, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C19302q71 {
    public static final C19302q71 a = new C19302q71();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(1527917200, false, a.a);

    /* renamed from: ir.nasim.q71$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "it");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(AbstractC21822uB5.simple_arrow_left, interfaceC22053ub1, 0), UY6.c(QD5.features_settings_back, interfaceC22053ub1, 0), null, 0L, interfaceC22053ub1, 0, 12);
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
