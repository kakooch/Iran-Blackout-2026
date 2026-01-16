package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;

/* renamed from: ir.nasim.ig0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC14898ig0 implements InterfaceC15645jv7 {
    @Override // ir.nasim.InterfaceC15645jv7
    public final DW5 a(Context context, DW5 dw5, int i, int i2) {
        if (!YM7.v(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        InterfaceC13106fg0 interfaceC13106fg0F = com.bumptech.glide.b.c(context).f();
        Bitmap bitmap = (Bitmap) dw5.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        int i3 = i;
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapD = d(context.getApplicationContext(), interfaceC13106fg0F, bitmap, i3, i2);
        return bitmap.equals(bitmapD) ? dw5 : C14288hg0.d(bitmapD, interfaceC13106fg0F);
    }

    void c(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
    }

    protected abstract Bitmap d(Context context, InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2);
}
