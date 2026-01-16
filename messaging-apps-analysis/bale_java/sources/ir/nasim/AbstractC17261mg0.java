package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* renamed from: ir.nasim.mg0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC17261mg0 {
    public static Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.ARGB_4444) {
            bitmapCreateBitmap.eraseColor(0);
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix, boolean z) {
        return Bitmap.createBitmap(bitmap, i, i2, i3, i4, matrix, z);
    }

    public static Bitmap c(Bitmap bitmap, int i, int i2, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, z);
    }
}
