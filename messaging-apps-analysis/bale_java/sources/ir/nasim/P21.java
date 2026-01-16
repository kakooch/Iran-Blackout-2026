package ir.nasim;

/* loaded from: classes6.dex */
public final class P21 {
    public static final P21 a = new P21();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-1921170034, false, a.a);

    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$OutlinedButton");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(AbstractC12217eE5.view, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).I(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).o(), interfaceC22053ub1, 0, 0, 65018);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
