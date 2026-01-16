package ir.nasim;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* renamed from: ir.nasim.aV3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9751aV3 {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListA = AbstractC9594aE.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListA;
    }

    public static ColorStateList b(Context context, androidx.appcompat.widget.C c, int i) {
        int iN;
        ColorStateList colorStateListA;
        return (!c.s(i) || (iN = c.n(i, 0)) == 0 || (colorStateListA = AbstractC9594aE.a(context, iN)) == null) ? c.c(i) : colorStateListA;
    }

    private static int c(TypedValue typedValue) {
        return typedValue.getComplexUnit();
    }

    public static int d(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable e(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableB = AbstractC9594aE.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableB;
    }

    static int f(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    public static C7605Sk7 g(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new C7605Sk7(context, resourceId);
    }

    public static int h(Context context, int i, int i2) throws Resources.NotFoundException {
        if (i == 0) {
            return i2;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, GE5.TextAppearance);
        TypedValue typedValue = new TypedValue();
        boolean value = typedArrayObtainStyledAttributes.getValue(GE5.TextAppearance_android_textSize, typedValue);
        typedArrayObtainStyledAttributes.recycle();
        return !value ? i2 : c(typedValue) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    public static boolean i(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean j(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
