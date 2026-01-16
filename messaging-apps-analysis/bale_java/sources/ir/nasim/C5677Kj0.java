package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.security.MessageDigest;

/* renamed from: ir.nasim.Kj0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5677Kj0 extends AbstractC15488jg0 {
    private final float b;
    private final boolean c;

    public C5677Kj0(float f, boolean z) {
        this.b = f;
        this.c = z;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        AbstractC13042fc3.i(messageDigest, "messageDigest");
        byte[] bytes = "BottomCropTransformation".getBytes(C12275eL0.b);
        AbstractC13042fc3.h(bytes, "getBytes(...)");
        messageDigest.update(bytes);
    }

    @Override // ir.nasim.AbstractC15488jg0
    protected Bitmap c(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        int width;
        AbstractC13042fc3.i(interfaceC13106fg0, "pool");
        AbstractC13042fc3.i(bitmap, "toTransform");
        if ((this.c && bitmap.getWidth() >= bitmap.getHeight()) || bitmap.getHeight() < (width = (int) (bitmap.getWidth() / this.b))) {
            return bitmap;
        }
        Bitmap bitmapD = interfaceC13106fg0.d(bitmap.getWidth(), width, Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapD, "get(...)");
        new Canvas(bitmapD).drawBitmap(bitmap, 0.0f, 0.0f, new Paint());
        return bitmapD;
    }
}
