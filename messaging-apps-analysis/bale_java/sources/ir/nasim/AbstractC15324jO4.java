package ir.nasim;

/* renamed from: ir.nasim.jO4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15324jO4 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.e(a.e);

    /* renamed from: ir.nasim.jO4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC14735iO4 invoke(InterfaceC9234Zb1 interfaceC9234Zb1) {
            return AbstractC14389hq.b(interfaceC9234Zb1);
        }
    }

    public static final AbstractC6535Nx5 a() {
        return a;
    }

    public static final InterfaceC14124hO4 b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(282942128);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(282942128, i, -1, "androidx.compose.foundation.rememberOverscrollEffect (Overscroll.kt:344)");
        }
        InterfaceC14735iO4 interfaceC14735iO4 = (InterfaceC14735iO4) interfaceC22053ub1.H(a);
        if (interfaceC14735iO4 == null) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return null;
        }
        boolean zV = interfaceC22053ub1.V(interfaceC14735iO4);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = interfaceC14735iO4.a();
            interfaceC22053ub1.s(objB);
        }
        InterfaceC14124hO4 interfaceC14124hO4 = (InterfaceC14124hO4) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return interfaceC14124hO4;
    }
}
