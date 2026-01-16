package ir.nasim;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.DisplayMetrics;
import ir.nasim.Z03;

/* renamed from: ir.nasim.pp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19123pp {
    public static final Y03 a(int i, int i2, int i3, boolean z, AbstractC9775aY0 abstractC9775aY0) {
        Bitmap bitmapCreateBitmap;
        Bitmap.Config configD = d(i3);
        if (Build.VERSION.SDK_INT >= 26) {
            bitmapCreateBitmap = C17410mv.a(i, i2, i3, z, abstractC9775aY0);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap((DisplayMetrics) null, i, i2, configD);
            bitmapCreateBitmap.setHasAlpha(z);
        }
        return new C17350mp(bitmapCreateBitmap);
    }

    public static final Bitmap b(Y03 y03) {
        if (y03 instanceof C17350mp) {
            return ((C17350mp) y03).c();
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final Y03 c(Bitmap bitmap) {
        return new C17350mp(bitmap);
    }

    public static final Bitmap.Config d(int i) {
        Z03.a aVar = Z03.b;
        if (Z03.i(i, aVar.b())) {
            return Bitmap.Config.ARGB_8888;
        }
        if (Z03.i(i, aVar.a())) {
            return Bitmap.Config.ALPHA_8;
        }
        if (Z03.i(i, aVar.e())) {
            return Bitmap.Config.RGB_565;
        }
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || !Z03.i(i, aVar.c())) ? (i2 < 26 || !Z03.i(i, aVar.d())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.HARDWARE : Bitmap.Config.RGBA_F16;
    }

    public static final int e(Bitmap.Config config) {
        if (config == Bitmap.Config.ALPHA_8) {
            return Z03.b.a();
        }
        if (config == Bitmap.Config.RGB_565) {
            return Z03.b.e();
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return Z03.b.b();
        }
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || config != Bitmap.Config.RGBA_F16) ? (i < 26 || config != Bitmap.Config.HARDWARE) ? Z03.b.b() : Z03.b.d() : Z03.b.c();
    }
}
