package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;

/* renamed from: ir.nasim.jg0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15488jg0 implements InterfaceC15645jv7 {
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
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(interfaceC13106fg0F, bitmap, i, i2);
        return bitmap.equals(bitmapC) ? dw5 : C14288hg0.d(bitmapC, interfaceC13106fg0F);
    }

    protected abstract Bitmap c(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2);
}
