package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public final class RA7 {
    public static final RA7 a = new RA7();

    private RA7() {
    }

    public static final Drawable a(Drawable drawable, float f, Resources resources) {
        AbstractC13042fc3.i(resources, "resources");
        if (drawable == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(AbstractC21455b.F(f), AbstractC21455b.F(f), Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return new BitmapDrawable(resources, bitmapCreateBitmap);
    }

    public static final Drawable b(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        return d(context, i, null, 4, null);
    }

    public static final Drawable c(Context context, int i, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "color");
        Drawable drawableF = AbstractC4043Dl1.f(context, i);
        if (drawableF == null) {
            return null;
        }
        drawableF.setTint(Color.parseColor(str));
        return drawableF;
    }

    public static /* synthetic */ Drawable d(Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "#ffFFFFFF";
        }
        return c(context, i, str);
    }
}
