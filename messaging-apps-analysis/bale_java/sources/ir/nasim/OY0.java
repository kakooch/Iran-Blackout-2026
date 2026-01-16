package ir.nasim;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* loaded from: classes6.dex */
public abstract class OY0 {
    public static final int a(int i, int i2) {
        int iAlpha = Color.alpha(i);
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        int iAlpha2 = Color.alpha(i2);
        int i3 = (((255 - iAlpha) * iAlpha2) / 255) + iAlpha;
        int i4 = 255 - iAlpha2;
        return (((((iBlue * iAlpha) * i4) / 255) + (Color.blue(i2) * iAlpha2)) / i3) | (i3 << 24) | ((((((iRed * iAlpha) * i4) / 255) + (Color.red(i2) * iAlpha2)) / i3) << 16) | ((((((iGreen * iAlpha) * i4) / 255) + (Color.green(i2) * iAlpha2)) / i3) << 8);
    }

    public static final int b(Context context, int i) {
        AbstractC13042fc3.i(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return AbstractC4043Dl1.c(context, typedValue.resourceId);
    }

    public static final Drawable c(Context context, int i) {
        AbstractC13042fc3.i(context, "<this>");
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return AbstractC4043Dl1.f(context, typedValue.resourceId);
        }
        return null;
    }
}
