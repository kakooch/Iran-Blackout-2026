package ir.nasim;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.y02, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC24076y02 {
    public static final /* synthetic */ int a(Drawable drawable) {
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 0;
    }

    public static final /* synthetic */ int b(Drawable[] drawableArr) {
        AbstractC13042fc3.i(drawableArr, "<this>");
        return AbstractC23053wG5.e(a(drawableArr[0]), a(drawableArr[2]));
    }

    public static final /* synthetic */ int c(Drawable[] drawableArr) {
        AbstractC13042fc3.i(drawableArr, "<this>");
        return d(drawableArr[0]) + d(drawableArr[2]);
    }

    public static final /* synthetic */ int d(Drawable drawable) {
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 0;
    }

    public static final /* synthetic */ boolean e(Drawable[] drawableArr) {
        AbstractC13042fc3.i(drawableArr, "<this>");
        return (drawableArr[0] == null && drawableArr[2] == null) ? false : true;
    }

    public static final /* synthetic */ Drawable f(Drawable drawable, Context context, Integer num, Integer num2) {
        AbstractC13042fc3.i(drawable, "<this>");
        AbstractC13042fc3.i(context, "context");
        if (num == null || num2 == null) {
            return drawable;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(num.intValue(), num2.intValue(), Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, num.intValue(), num2.intValue());
        drawable.draw(canvas);
        return new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
    }

    public static final /* synthetic */ Drawable g(Drawable drawable, Integer num) {
        AbstractC13042fc3.i(drawable, "<this>");
        if (num != null) {
            AbstractC21710u02.i(AbstractC21710u02.l(drawable), ColorStateList.valueOf(num.intValue()));
        }
        return drawable;
    }
}
