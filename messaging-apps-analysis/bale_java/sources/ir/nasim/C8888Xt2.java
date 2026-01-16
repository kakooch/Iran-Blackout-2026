package ir.nasim;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Xt2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C8888Xt2 {
    private final AssetManager d;
    private final C4289Em4 a = new C4289Em4();
    private final Map b = new HashMap();
    private final Map c = new HashMap();
    private String e = ".ttf";

    public C8888Xt2(Drawable.Callback callback, AbstractC8622Wt2 abstractC8622Wt2) {
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
        } else {
            JI3.c("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }

    private Typeface a(C8388Vt2 c8388Vt2) {
        String strA = c8388Vt2.a();
        Typeface typeface = (Typeface) this.c.get(strA);
        if (typeface != null) {
            return typeface;
        }
        c8388Vt2.c();
        c8388Vt2.b();
        if (c8388Vt2.d() != null) {
            return c8388Vt2.d();
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.d, "fonts/" + strA + this.e);
        this.c.put(strA, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface e(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    public Typeface b(C8388Vt2 c8388Vt2) {
        this.a.b(c8388Vt2.a(), c8388Vt2.c());
        Typeface typeface = (Typeface) this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceE = e(a(c8388Vt2), c8388Vt2.c());
        this.b.put(this.a, typefaceE);
        return typefaceE;
    }

    public void c(String str) {
        this.e = str;
    }

    public void d(AbstractC8622Wt2 abstractC8622Wt2) {
    }
}
