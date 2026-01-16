package ir.nasim;

/* loaded from: classes.dex */
public final class M37 {
    public static final M37 a = new M37();

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ WH1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(WH1 wh1) {
            super(1);
            this.e = wh1;
        }

        public final Float a(float f) {
            return Float.valueOf(this.e.w1(C17784nZ1.q(56)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    private M37() {
    }

    public final UA2 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1545861529, i, -1, "androidx.compose.material3.SwipeToDismissBoxDefaults.<get-positionalThreshold> (SwipeToDismissBox.kt:261)");
        }
        interfaceC22053ub1.W(-1853326336);
        WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        boolean zV = interfaceC22053ub1.V(wh1);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new a(wh1);
            interfaceC22053ub1.s(objB);
        }
        UA2 ua2 = (UA2) objB;
        interfaceC22053ub1.Q();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return ua2;
    }
}
