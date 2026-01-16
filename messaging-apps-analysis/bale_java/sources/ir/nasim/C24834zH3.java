package ir.nasim;

/* renamed from: ir.nasim.zH3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24834zH3 {
    public static final C24834zH3 a = new C24834zH3();
    private static final AbstractC6535Nx5 b = AbstractC11024cc1.d(null, a.e, 1, null);
    public static final int c = 0;

    /* renamed from: ir.nasim.zH3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return null;
        }
    }

    private C24834zH3() {
    }

    public final InterfaceC15408jX7 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.A(-584162872);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-584162872, i, -1, "androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.<get-current> (LocalViewModelStoreOwner.kt:38)");
        }
        InterfaceC15408jX7 interfaceC15408jX7A = (InterfaceC15408jX7) interfaceC22053ub1.H(b);
        if (interfaceC15408jX7A == null) {
            interfaceC15408jX7A = AH3.a(interfaceC22053ub1, 0);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return interfaceC15408jX7A;
    }

    public final C7252Qx5 b(InterfaceC15408jX7 interfaceC15408jX7) {
        AbstractC13042fc3.i(interfaceC15408jX7, "viewModelStoreOwner");
        return b.d(interfaceC15408jX7);
    }
}
