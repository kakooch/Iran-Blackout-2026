package ir.nasim;

import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* renamed from: ir.nasim.gu3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC13840gu3 {
    public static FrameLayout.LayoutParams a(float f, float f2, int i) {
        return new FrameLayout.LayoutParams(r(f), r(f2), i);
    }

    public static FrameLayout.LayoutParams b(int i, float f) {
        return new FrameLayout.LayoutParams(r(i), r(f));
    }

    public static FrameLayout.LayoutParams c(int i, float f, int i2, float f2, float f3, float f4, float f5) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r(i), r(f), i2);
        layoutParams.setMargins(AbstractC21455b.F(f2), AbstractC21455b.F(f3), AbstractC21455b.F(f4), AbstractC21455b.F(f5));
        return layoutParams;
    }

    public static FrameLayout.LayoutParams d(int i, int i2, int i3) {
        return new FrameLayout.LayoutParams(r(i), r(i2), i3);
    }

    public static FrameLayout.LayoutParams e(float f, float f2, int i) {
        return new FrameLayout.LayoutParams(r(f), r(f2), p(i));
    }

    public static FrameLayout.LayoutParams f(float f, float f2, int i, float f3, float f4, float f5, float f6) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r(f), r(f2), p(i));
        layoutParams.leftMargin = AbstractC21455b.F(FH3.D ? f5 : f3);
        layoutParams.topMargin = AbstractC21455b.F(f4);
        if (!FH3.D) {
            f3 = f5;
        }
        layoutParams.rightMargin = AbstractC21455b.F(f3);
        layoutParams.bottomMargin = AbstractC21455b.F(f6);
        return layoutParams;
    }

    public static LinearLayout.LayoutParams g(int i, int i2) {
        return new LinearLayout.LayoutParams(r(i), r(i2));
    }

    public static LinearLayout.LayoutParams h(int i, int i2, float f) {
        return new LinearLayout.LayoutParams(r(i), r(i2), f);
    }

    public static LinearLayout.LayoutParams i(int i, int i2, float f, float f2, float f3, float f4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r(i), r(i2));
        layoutParams.setMargins(AbstractC21455b.F(f), AbstractC21455b.F(f2), AbstractC21455b.F(f3), AbstractC21455b.F(f4));
        return layoutParams;
    }

    public static LinearLayout.LayoutParams j(int i, int i2, float f, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r(i), r(i2), f);
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static LinearLayout.LayoutParams k(int i, int i2, float f, int i3, int i4, int i5, int i6) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r(i), r(i2), f);
        layoutParams.setMargins(AbstractC21455b.F(i3), AbstractC21455b.F(i4), AbstractC21455b.F(i5), AbstractC21455b.F(i6));
        return layoutParams;
    }

    public static LinearLayout.LayoutParams l(int i, int i2, float f, int i3, int i4, int i5, int i6, int i7) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r(i), r(i2), f);
        layoutParams.setMargins(AbstractC21455b.F(i4), AbstractC21455b.F(i5), AbstractC21455b.F(i6), AbstractC21455b.F(i7));
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static LinearLayout.LayoutParams m(int i, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r(i), r(i2));
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static LinearLayout.LayoutParams n(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r(i), r(i2));
        layoutParams.setMargins(AbstractC21455b.F(i4), AbstractC21455b.F(i5), AbstractC21455b.F(i6), AbstractC21455b.F(i7));
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static FrameLayout.LayoutParams o(int i, int i2, int i3) {
        return new FrameLayout.LayoutParams(r(i), r(i2), i3);
    }

    private static int p(int i) {
        return Gravity.getAbsoluteGravity(i, FH3.D ? 1 : 0);
    }

    public static int q() {
        return FH3.D ? 5 : 3;
    }

    private static int r(float f) {
        if (f >= 0.0f) {
            f = AbstractC21455b.F(f);
        }
        return (int) f;
    }
}
