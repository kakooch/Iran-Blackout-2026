package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;

/* renamed from: ir.nasim.cg0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11063cg0 implements HW5 {
    private final InterfaceC13106fg0 a = new C13697gg0();

    @Override // ir.nasim.HW5
    public /* bridge */ /* synthetic */ DW5 a(Object obj, int i, int i2, HL4 hl4) {
        return c(AbstractC9853ag0.a(obj), i, i2, hl4);
    }

    @Override // ir.nasim.HW5
    public /* bridge */ /* synthetic */ boolean b(Object obj, HL4 hl4) {
        return d(AbstractC9853ag0.a(obj), hl4);
    }

    public DW5 c(ImageDecoder.Source source, int i, int i2, HL4 hl4) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new EE1(i, i2, hl4));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i + "x" + i2 + "]");
        }
        return new C14288hg0(bitmapDecodeBitmap, this.a);
    }

    public boolean d(ImageDecoder.Source source, HL4 hl4) {
        return true;
    }
}
