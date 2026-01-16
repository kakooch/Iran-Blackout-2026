package ir.nasim;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import ir.nasim.Y03;

/* loaded from: classes2.dex */
public abstract class X23 {
    public static final Y03 a(Y03.a aVar, Resources resources, int i) throws Resources.NotFoundException {
        Drawable drawable = resources.getDrawable(i, null);
        AbstractC13042fc3.g(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        return AbstractC19123pp.c(((BitmapDrawable) drawable).getBitmap());
    }
}
