package ir.nasim;

/* renamed from: ir.nasim.gv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC13850gv3 {
    public static final InterfaceC16242kw3 a(C6021Lv3 c6021Lv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(2004349821, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridBeyondBoundsState (LazyGridBeyondBoundsModifier.kt:24)");
        }
        boolean z = (((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(c6021Lv3)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new C14443hv3(c6021Lv3);
            interfaceC22053ub1.s(objB);
        }
        C14443hv3 c14443hv3 = (C14443hv3) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c14443hv3;
    }
}
