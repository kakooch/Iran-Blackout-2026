package ir.nasim;

/* renamed from: ir.nasim.k21, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15706k21 {
    public static final C15706k21 a = new C15706k21();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-309937896, false, a.a);

    /* renamed from: ir.nasim.k21$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9459a00.c(null, UY6.c(UD5.core_ui_title, interfaceC22053ub1, 0), null, interfaceC22053ub1, 0, 5);
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
