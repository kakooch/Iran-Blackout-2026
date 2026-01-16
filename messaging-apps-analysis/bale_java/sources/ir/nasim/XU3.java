package ir.nasim;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/* loaded from: classes3.dex */
public abstract class XU3 {
    public static Rect a(Context context, int i, int i2) {
        TypedArray typedArrayH = AbstractC5729Ko7.h(context, null, GE5.MaterialAlertDialog, i, i2, new int[0]);
        int dimensionPixelSize = typedArrayH.getDimensionPixelSize(GE5.MaterialAlertDialog_backgroundInsetStart, context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayH.getDimensionPixelSize(GE5.MaterialAlertDialog_backgroundInsetTop, context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayH.getDimensionPixelSize(GE5.MaterialAlertDialog_backgroundInsetEnd, context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayH.getDimensionPixelSize(GE5.MaterialAlertDialog_backgroundInsetBottom, context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_alert_dialog_background_inset_bottom));
        typedArrayH.recycle();
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }

    public static InsetDrawable b(Drawable drawable, Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
