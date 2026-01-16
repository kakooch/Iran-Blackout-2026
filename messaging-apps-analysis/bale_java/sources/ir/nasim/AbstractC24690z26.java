package ir.nasim;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* renamed from: ir.nasim.z26, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC24690z26 {
    public static final boolean a = true;
    private static final int[] b = {android.R.attr.state_pressed};
    private static final int[] c = {android.R.attr.state_hovered, android.R.attr.state_focused};
    private static final int[] d = {android.R.attr.state_focused};
    private static final int[] e = {android.R.attr.state_hovered};
    private static final int[] f = {android.R.attr.state_selected, android.R.attr.state_pressed};
    private static final int[] g = {android.R.attr.state_selected, android.R.attr.state_hovered, android.R.attr.state_focused};
    private static final int[] h = {android.R.attr.state_selected, android.R.attr.state_focused};
    private static final int[] i = {android.R.attr.state_selected, android.R.attr.state_hovered};
    private static final int[] j = {android.R.attr.state_selected};
    private static final int[] k = {android.R.attr.state_enabled, android.R.attr.state_pressed};
    static final String l = AbstractC24690z26.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{c(colorStateList, f), c(colorStateList, b)});
        }
        int[] iArr = f;
        int[] iArr2 = g;
        int[] iArr3 = h;
        int[] iArr4 = i;
        int[] iArr5 = b;
        int[] iArr6 = c;
        int[] iArr7 = d;
        int[] iArr8 = e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    private static int b(int i2) {
        return QY0.k(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return a ? b(colorForState) : colorForState;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(k, 0)) != 0) {
            Log.w(l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean e(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
