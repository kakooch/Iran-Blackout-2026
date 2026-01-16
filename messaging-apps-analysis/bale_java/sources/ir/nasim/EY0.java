package ir.nasim;

import android.graphics.ColorSpace;

/* loaded from: classes2.dex */
final class EY0 {
    public static final EY0 a = new EY0();

    private EY0() {
    }

    public static final ColorSpace a(AbstractC9775aY0 abstractC9775aY0) {
        LY0 ly0 = LY0.a;
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.q())) {
            return ColorSpace.get(ColorSpace.Named.BT2020_HLG);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.r())) {
            return ColorSpace.get(ColorSpace.Named.BT2020_PQ);
        }
        return null;
    }
}
