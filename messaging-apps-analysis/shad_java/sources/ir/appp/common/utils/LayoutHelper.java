package ir.appp.common.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public class LayoutHelper {
    private static int getSize(float f) {
        if (f >= 0.0f) {
            f = AndroidUtilities.dp(f);
        }
        return (int) f;
    }

    public static FrameLayout.LayoutParams createFrame(int i, float f, int i2, float f2, float f3, float f4, float f5) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getSize(i), getSize(f), i2);
        layoutParams.setMargins(AndroidUtilities.dp(f2), AndroidUtilities.dp(f3), AndroidUtilities.dp(f4), AndroidUtilities.dp(f5));
        return layoutParams;
    }

    public static FrameLayout.LayoutParams createFrame(int i, int i2, int i3, float f, float f2, float f3, float f4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getSize(i), getSize(i2), i3);
        layoutParams.setMargins(AndroidUtilities.dp(f), AndroidUtilities.dp(f2), AndroidUtilities.dp(f3), AndroidUtilities.dp(f4));
        return layoutParams;
    }

    public static FrameLayout.LayoutParams createFrame(int i, int i2, int i3) {
        return new FrameLayout.LayoutParams(getSize(i), getSize(i2), i3);
    }

    public static FrameLayout.LayoutParams createFrame(int i, int i2) {
        return new FrameLayout.LayoutParams(getSize(i), getSize(i2));
    }

    public static LinearLayout.LayoutParams createLinear(int i, int i2, float f, int i3, int i4, int i5, int i6, int i7) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getSize(i), getSize(i2), f);
        layoutParams.setMargins(AndroidUtilities.dp(i4), AndroidUtilities.dp(i5), AndroidUtilities.dp(i6), AndroidUtilities.dp(i7));
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static LinearLayout.LayoutParams createLinear(int i, int i2, float f, int i3, int i4, int i5, int i6) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getSize(i), getSize(i2), f);
        layoutParams.setMargins(AndroidUtilities.dp(i3), AndroidUtilities.dp(i4), AndroidUtilities.dp(i5), AndroidUtilities.dp(i6));
        return layoutParams;
    }

    public static LinearLayout.LayoutParams createLinear(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getSize(i), getSize(i2));
        layoutParams.setMargins(AndroidUtilities.dp(i4), AndroidUtilities.dp(i5), AndroidUtilities.dp(i6), AndroidUtilities.dp(i7));
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static LinearLayout.LayoutParams createLinear(int i, int i2, float f, float f2, float f3, float f4) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getSize(i), getSize(i2));
        layoutParams.setMargins(AndroidUtilities.dp(f), AndroidUtilities.dp(f2), AndroidUtilities.dp(f3), AndroidUtilities.dp(f4));
        return layoutParams;
    }

    public static LinearLayout.LayoutParams createLinear(int i, int i2, float f, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getSize(i), getSize(i2), f);
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static LinearLayout.LayoutParams createLinear(int i, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getSize(i), getSize(i2));
        layoutParams.gravity = i3;
        return layoutParams;
    }

    public static LinearLayout.LayoutParams createLinear(int i, int i2) {
        return new LinearLayout.LayoutParams(getSize(i), getSize(i2));
    }

    public static void setMargins(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }
}
