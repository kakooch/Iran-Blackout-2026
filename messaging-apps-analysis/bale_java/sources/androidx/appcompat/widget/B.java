package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class B extends v {
    private final WeakReference b;

    public B(Context context, Resources resources) {
        super(resources);
        this.b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawableA = a(i);
        Context context = (Context) this.b.get();
        if (drawableA != null && context != null) {
            u.g().w(context, i, drawableA);
        }
        return drawableA;
    }
}
