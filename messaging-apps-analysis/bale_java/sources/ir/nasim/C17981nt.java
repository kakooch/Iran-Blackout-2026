package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import java.util.Map;

/* renamed from: ir.nasim.nt, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17981nt {
    public static final C17981nt a = new C17981nt();
    private static final Map b = AbstractC20051rO3.n(AbstractC4616Fw7.a(1, Integer.valueOf(KB5.hello_animation_heart_fast_preve)), AbstractC4616Fw7.a(2, Integer.valueOf(KB5.hello_animation_smile_fast_preve)), AbstractC4616Fw7.a(3, Integer.valueOf(KB5.hello_animation_wink_fast_preve)));
    private static final C12056dy c;
    private static final C12056dy d;
    private static final C12056dy e;
    private static final C4626Fy f;
    private static final C4626Fy g;
    private static final C4626Fy h;
    private static final C14419ht i;
    private static final C14419ht j;
    private static final C14419ht k;
    public static final int l;

    static {
        C12056dy c12056dy = new C12056dy(2563121598612643584L, 1939153512L, 1);
        c = c12056dy;
        C12056dy c12056dy2 = new C12056dy(-4219870558027833598L, 1939153512L, 1);
        d = c12056dy2;
        C12056dy c12056dy3 = new C12056dy(-6624277384054759678L, 1939153512L, 1);
        e = c12056dy3;
        C4626Fy c4626Fy = new C4626Fy(c12056dy, 512, 512, 19060);
        f = c4626Fy;
        C4626Fy c4626Fy2 = new C4626Fy(c12056dy2, 512, 512, 15719);
        g = c4626Fy2;
        C4626Fy c4626Fy3 = new C4626Fy(c12056dy3, 512, 512, 15092);
        h = c4626Fy3;
        i = new C14419ht(1, c4626Fy, 1393482638, null);
        j = new C14419ht(2, c4626Fy2, 1393482638, null);
        k = new C14419ht(3, c4626Fy3, 1393482638, null);
        l = 8;
    }

    private C17981nt() {
    }

    public static final C14419ht a(int i2) {
        int iAbs = Math.abs(i2 % 3);
        return iAbs != 0 ? iAbs != 1 ? k : j : i;
    }

    public static final Map b() {
        return b;
    }

    public static final Bitmap c(Context context, int i2) {
        AbstractC13042fc3.i(context, "context");
        Drawable drawableF = AbstractC4043Dl1.f(context, i2);
        if (drawableF instanceof BitmapDrawable) {
            return BitmapFactory.decodeResource(context.getResources(), i2);
        }
        if (drawableF instanceof VectorDrawable) {
            return d((VectorDrawable) drawableF);
        }
        throw new IllegalArgumentException("unsupported drawable type");
    }

    public static final Bitmap d(VectorDrawable vectorDrawable) {
        AbstractC13042fc3.i(vectorDrawable, "vectorDrawable");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
