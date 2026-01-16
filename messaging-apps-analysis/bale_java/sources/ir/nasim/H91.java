package ir.nasim;

import ir.nasim.AbstractC12407eZ6;

/* loaded from: classes.dex */
public final class H91 {
    public static final H91 a = new H91();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-505750804, false, a.e);

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-505750804, i, -1, "androidx.compose.material3.ComposableSingletons$SnackbarKt.lambda-1.<anonymous> (Snackbar.kt:231)");
            }
            C12700f33 c12700f33A = TV0.a(B03.a);
            AbstractC12407eZ6.a aVar = AbstractC12407eZ6.a;
            AbstractC24077y03.a(c12700f33A, AbstractC22629vZ6.a(AbstractC12407eZ6.a(ZD5.m3c_snackbar_dismiss), interfaceC22053ub1, 0), null, 0L, interfaceC22053ub1, 0, 12);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
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
