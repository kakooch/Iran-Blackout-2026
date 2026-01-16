package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Color;
import ir.nasim.tgwidgets.editor.messenger.Utilities;

/* renamed from: ir.nasim.eX1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC12384eX1 {
    private static float[] a;

    private static int a(int i, boolean z) {
        if (a == null) {
            a = new float[3];
        }
        Color.colorToHSV(i, a);
        float[] fArr = a;
        fArr[2] = Utilities.c(fArr[2] + (z ? -0.05f : 0.07f), 0.85f, 0.15f);
        float[] fArr2 = a;
        float f = fArr2[1];
        if (f > 0.1f && f <= 0.95f) {
            if (f <= 0.5f) {
                fArr2[1] = Utilities.c(f + 0.2f, 1.0f, 0.0f);
            } else if (f > 0.8f) {
                fArr2[1] = Utilities.c(f - 0.4f, 1.0f, 0.0f);
            }
        }
        return Color.HSVToColor(a);
    }

    public static void b(boolean z, Bitmap bitmap, boolean z2, Utilities.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bitmap == null) {
            bVar.a(new int[]{0, 0});
        } else {
            bVar.a(c(false, bitmap, z2));
        }
    }

    public static int[] c(boolean z, Bitmap bitmap, boolean z2) {
        return new int[]{a(bitmap.getPixel(bitmap.getWidth() / 2, (int) (bitmap.getHeight() * 0.1f)), z2), a(bitmap.getPixel(bitmap.getWidth() / 2, (int) (bitmap.getHeight() * 0.9f)), z2)};
    }
}
