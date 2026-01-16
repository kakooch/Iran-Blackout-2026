package ir.nasim;

/* loaded from: classes2.dex */
public final class V91 {
    public static final V91 a = new V91();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-1692951203, false, a.e);

    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final a e = new a();

        a() {
            super(3);
        }

        public final void a(RZ6 rz6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = i | (interfaceC22053ub1.V(rz6) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1692951203, i2, -1, "coil.compose.ComposableSingletons$SubcomposeAsyncImageKt.lambda-1.<anonymous> (SubcomposeAsyncImage.kt:391)");
            }
            coil.compose.f.c(rz6, null, null, null, null, null, 0.0f, null, false, interfaceC22053ub1, i2 & 14, 255);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((RZ6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
