package ir.nasim;

/* renamed from: ir.nasim.de6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC11844de6 {

    /* renamed from: ir.nasim.de6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9664aL6 interfaceC9664aL6) {
            super(1);
            this.e = interfaceC9664aL6;
        }

        public final Float a(float f) {
            return (Float) ((UA2) this.e.getValue()).invoke(Float.valueOf(f));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    public static final InterfaceC11049ce6 a(UA2 ua2) {
        return new VE1(ua2);
    }

    public static final InterfaceC11049ce6 b(UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-180460798, i, -1, "androidx.compose.foundation.gestures.rememberScrollableState (ScrollableState.kt:159)");
        }
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(ua2, interfaceC22053ub1, i & 14);
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = a(new a(interfaceC9664aL6Q));
            interfaceC22053ub1.s(objB);
        }
        InterfaceC11049ce6 interfaceC11049ce6 = (InterfaceC11049ce6) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC11049ce6;
    }
}
