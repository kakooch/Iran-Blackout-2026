package ir.nasim;

/* loaded from: classes.dex */
public final class F91 {
    public static final F91 a = new F91();
    private static InterfaceC15796kB2 b = AbstractC19242q11.c(996639038, false, a.e);

    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final a e = new a();

        a() {
            super(3);
        }

        public final void a(InterfaceC15845kG6 interfaceC15845kG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | ((i & 8) == 0 ? interfaceC22053ub1.V(interfaceC15845kG6) : interfaceC22053ub1.D(interfaceC15845kG6) ? 4 : 2);
            } else {
                i2 = i;
            }
            if (!interfaceC22053ub1.o((i2 & 19) != 18, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(996639038, i2, -1, "androidx.compose.material.ComposableSingletons$SnackbarHostKt.lambda-1.<anonymous> (SnackbarHost.kt:154)");
            }
            AbstractC21194tG6.d(interfaceC15845kG6, null, false, null, 0L, 0L, 0L, 0.0f, interfaceC22053ub1, i2 & 14, 254);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            AbstractC18350oW3.a(obj);
            a(null, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
