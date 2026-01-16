package ir.nasim;

import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public abstract class LI6 {
    private static final float a = ViewConfiguration.getScrollFriction();

    public static final float a() {
        return a;
    }

    public static final InterfaceC10163bB1 b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(904445851, i, -1, "androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)");
        }
        WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        boolean zC = interfaceC22053ub1.c(wh1.getDensity());
        Object objB = interfaceC22053ub1.B();
        if (zC || objB == InterfaceC22053ub1.a.a()) {
            objB = AbstractC11543dB1.b(new KI6(wh1));
            interfaceC22053ub1.s(objB);
        }
        InterfaceC10163bB1 interfaceC10163bB1 = (InterfaceC10163bB1) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC10163bB1;
    }
}
