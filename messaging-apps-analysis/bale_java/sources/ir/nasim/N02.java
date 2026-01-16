package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public final class N02 {
    public static final N02 a = new N02();

    private N02() {
    }

    private final boolean b(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == AbstractC10667c.e(config);
    }

    private final boolean c(boolean z, Bitmap bitmap, PD6 pd6, EnumC14254hc6 enumC14254hc6) {
        if (z) {
            return true;
        }
        return C21144tB1.c(bitmap.getWidth(), bitmap.getHeight(), AbstractC17456n.b(pd6) ? bitmap.getWidth() : AbstractC18638p.A(pd6.d(), enumC14254hc6), AbstractC17456n.b(pd6) ? bitmap.getHeight() : AbstractC18638p.A(pd6.c(), enumC14254hc6), enumC14254hc6) == 1.0d;
    }

    public final Bitmap a(Drawable drawable, Bitmap.Config config, PD6 pd6, EnumC14254hc6 enumC14254hc6, boolean z) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (b(bitmap, config) && c(z, bitmap, pd6, enumC14254hc6)) {
                return bitmap;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        int iP = AbstractC18638p.p(drawableMutate);
        if (iP <= 0) {
            iP = 512;
        }
        int iJ = AbstractC18638p.j(drawableMutate);
        int i = iJ > 0 ? iJ : 512;
        double dC = C21144tB1.c(iP, i, AbstractC17456n.b(pd6) ? iP : AbstractC18638p.A(pd6.d(), enumC14254hc6), AbstractC17456n.b(pd6) ? i : AbstractC18638p.A(pd6.c(), enumC14254hc6), enumC14254hc6);
        int iC = AbstractC20723sV3.c(iP * dC);
        int iC2 = AbstractC20723sV3.c(dC * i);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iC, iC2, AbstractC10667c.e(config));
        Rect bounds = drawableMutate.getBounds();
        int i2 = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iC, iC2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i2, i3, i4, i5);
        return bitmapCreateBitmap;
    }
}
