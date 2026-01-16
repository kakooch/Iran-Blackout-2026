package ir.nasim;

import android.graphics.ColorSpace;
import android.os.Build;
import java.util.function.DoubleUnaryOperator;

/* loaded from: classes2.dex */
final class BY0 {
    public static final BY0 a = new BY0();

    private BY0() {
    }

    public static final ColorSpace c(AbstractC9775aY0 abstractC9775aY0) {
        ColorSpace.Rgb.TransferParameters transferParametersA;
        ColorSpace.Rgb rgbA;
        ColorSpace colorSpaceA;
        LY0 ly0 = LY0.a;
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.G())) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.m())) {
            return ColorSpace.get(ColorSpace.Named.ACES);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.n())) {
            return ColorSpace.get(ColorSpace.Named.ACESCG);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.o())) {
            return ColorSpace.get(ColorSpace.Named.ADOBE_RGB);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.p())) {
            return ColorSpace.get(ColorSpace.Named.BT2020);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.s())) {
            return ColorSpace.get(ColorSpace.Named.BT709);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.t())) {
            return ColorSpace.get(ColorSpace.Named.CIE_LAB);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.u())) {
            return ColorSpace.get(ColorSpace.Named.CIE_XYZ);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.w())) {
            return ColorSpace.get(ColorSpace.Named.DCI_P3);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.x())) {
            return ColorSpace.get(ColorSpace.Named.DISPLAY_P3);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.y())) {
            return ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.z())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.A())) {
            return ColorSpace.get(ColorSpace.Named.LINEAR_SRGB);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.B())) {
            return ColorSpace.get(ColorSpace.Named.NTSC_1953);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.E())) {
            return ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB);
        }
        if (AbstractC13042fc3.d(abstractC9775aY0, ly0.F())) {
            return ColorSpace.get(ColorSpace.Named.SMPTE_C);
        }
        if (Build.VERSION.SDK_INT >= 34 && (colorSpaceA = EY0.a(abstractC9775aY0)) != null) {
            return colorSpaceA;
        }
        if (!(abstractC9775aY0 instanceof C13920h26)) {
            return ColorSpace.get(ColorSpace.Named.SRGB);
        }
        C13920h26 c13920h26 = (C13920h26) abstractC9775aY0;
        float[] fArrC = c13920h26.F().c();
        C3662Bu7 c3662Bu7D = c13920h26.D();
        if (c3662Bu7D != null) {
            AbstractC18956pY0.a();
            transferParametersA = AbstractC16592lY0.a(c3662Bu7D.a(), c3662Bu7D.b(), c3662Bu7D.c(), c3662Bu7D.d(), c3662Bu7D.e(), c3662Bu7D.f(), c3662Bu7D.g());
        } else {
            transferParametersA = null;
        }
        if (transferParametersA != null) {
            AbstractC19547qY0.a();
            rgbA = AbstractC17183mY0.a(abstractC9775aY0.f(), c13920h26.C(), fArrC, transferParametersA);
        } else {
            AbstractC19547qY0.a();
            String strF = abstractC9775aY0.f();
            float[] fArrC2 = c13920h26.C();
            final UA2 ua2Z = c13920h26.z();
            DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() { // from class: ir.nasim.zY0
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d) {
                    return BY0.d(ua2Z, d);
                }
            };
            final UA2 ua2V = c13920h26.v();
            rgbA = AbstractC18365oY0.a(strF, fArrC2, fArrC, doubleUnaryOperator, new DoubleUnaryOperator() { // from class: ir.nasim.AY0
                @Override // java.util.function.DoubleUnaryOperator
                public final double applyAsDouble(double d) {
                    return BY0.e(ua2V, d);
                }
            }, abstractC9775aY0.d(0), abstractC9775aY0.c(0));
        }
        return AbstractC14210hY0.a(rgbA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double d(UA2 ua2, double d) {
        return ((Number) ua2.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double e(UA2 ua2, double d) {
        return ((Number) ua2.invoke(Double.valueOf(d))).doubleValue();
    }
}
