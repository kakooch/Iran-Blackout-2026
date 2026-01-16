package ir.nasim;

/* loaded from: classes.dex */
public final class Q31 {
    public static final Q31 a = new Q31();
    private static InterfaceC15796kB2 b = AbstractC19242q11.c(-813639903, false, a.e);

    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final a e = new a();

        a() {
            super(3);
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2;
            }
            if (!interfaceC22053ub1.o((i & 19) != 18, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-813639903, i, -1, "androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.lambda-1.<anonymous> (CoreTextField.kt:202)");
            }
            interfaceC14603iB2.invoke(interfaceC22053ub1, Integer.valueOf(i & 14));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
