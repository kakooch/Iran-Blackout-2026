package ir.nasim;

/* loaded from: classes.dex */
public abstract class BD6 {
    private static final C18827pJ6 a = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);

    public static final InterfaceC9664aL6 a(long j, InterfaceC5766Kt interfaceC5766Kt, String str, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        InterfaceC5766Kt interfaceC5766Kt2 = (i2 & 2) != 0 ? a : interfaceC5766Kt;
        String str2 = (i2 & 4) != 0 ? "ColorAnimation" : str;
        UA2 ua22 = (i2 & 8) != 0 ? null : ua2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-451899108, i, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:60)");
        }
        boolean zV = interfaceC22053ub1.V(C24381yX0.t(j));
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = (InterfaceC5342Ix7) RY0.a(C24381yX0.b).invoke(C24381yX0.t(j));
            interfaceC22053ub1.s(objB);
        }
        int i3 = i << 6;
        InterfaceC9664aL6 interfaceC9664aL6G = AbstractC4572Fs.g(C24381yX0.k(j), (InterfaceC5342Ix7) objB, interfaceC5766Kt2, null, str2, ua22, interfaceC22053ub1, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6G;
    }
}
