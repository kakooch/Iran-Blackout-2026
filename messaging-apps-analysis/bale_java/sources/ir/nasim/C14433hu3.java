package ir.nasim;

import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* renamed from: ir.nasim.hu3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14433hu3 {
    public static final C14433hu3 a = new C14433hu3();

    private C14433hu3() {
    }

    public static final FrameLayout.LayoutParams a(int i, float f) {
        C14433hu3 c14433hu3 = a;
        return new FrameLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(f));
    }

    public static final FrameLayout.LayoutParams b(int i, float f, int i2, float f2, float f3, float f4, float f5) {
        C14433hu3 c14433hu3 = a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(f), i2);
        layoutParams.setMargins(C22078ud6.a(f2), C22078ud6.a(f3), C22078ud6.a(f4), C22078ud6.a(f5));
        return layoutParams;
    }

    public static final FrameLayout.LayoutParams c(int i, int i2, int i3) {
        C14433hu3 c14433hu3 = a;
        return new FrameLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(i2), i3);
    }

    public static final LinearLayout.LayoutParams d(int i, int i2) {
        C14433hu3 c14433hu3 = a;
        return new LinearLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(i2));
    }

    public static final LinearLayout.LayoutParams e(int i, int i2, float f) {
        C14433hu3 c14433hu3 = a;
        return new LinearLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(i2), f);
    }

    public static final LinearLayout.LayoutParams f(int i, int i2, float f, float f2, float f3, float f4) {
        C14433hu3 c14433hu3 = a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(i2));
        layoutParams.setMargins(C22078ud6.a(f), C22078ud6.a(f2), C22078ud6.a(f3), C22078ud6.a(f4));
        return layoutParams;
    }

    public static final LinearLayout.LayoutParams g(int i, int i2, float f, int i3, int i4, int i5, int i6) {
        C14433hu3 c14433hu3 = a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(i2), f);
        layoutParams.setMargins(C22078ud6.a(i3), C22078ud6.a(i4), C22078ud6.a(i5), C22078ud6.a(i6));
        return layoutParams;
    }

    public static final LinearLayout.LayoutParams h(int i, int i2, int i3) {
        C14433hu3 c14433hu3 = a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(i2));
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static final LinearLayout.LayoutParams i(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        C14433hu3 c14433hu3 = a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c14433hu3.j(i), c14433hu3.j(i2));
        layoutParams.setMargins(C22078ud6.a(i4), C22078ud6.a(i5), C22078ud6.a(i6), C22078ud6.a(i7));
        layoutParams.gravity = i3;
        return layoutParams;
    }

    private final int j(float f) {
        return (f < 0.0f ? Float.valueOf(f) : Integer.valueOf(C22078ud6.a(f))).intValue();
    }
}
