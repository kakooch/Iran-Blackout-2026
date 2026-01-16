package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;

/* renamed from: ir.nasim.ha0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC14228ha0 {
    public static final ColorDrawable a(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "<this>");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outHeight = 1;
        options.outWidth = 1;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (bitmapDecodeByteArray == null) {
            return null;
        }
        int pixel = bitmapDecodeByteArray.getPixel(0, 0);
        bitmapDecodeByteArray.recycle();
        return new ColorDrawable(pixel);
    }

    public static final void b(C8610Ws c8610Ws) {
        AbstractC13042fc3.i(c8610Ws, "<this>");
        c8610Ws.stop();
        c8610Ws.S(null);
    }
}
