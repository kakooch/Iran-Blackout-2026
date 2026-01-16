package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;

/* loaded from: classes3.dex */
public class DrawableHelper {
    public static Drawable getDrawableWithColor(int i, Context context, int i2) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(i);
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(i2);
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i2);
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(i2);
        }
        return drawable;
    }

    public static Drawable getDrawableStroke(int i, Context context, int i2) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(i);
        drawable.mutate();
        ((GradientDrawable) drawable).setStroke(2, i2);
        return drawable;
    }

    public static Drawable getDrawableVector(int i, Context context, int i2) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(i);
        drawable.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_ATOP));
        return drawable;
    }
}
