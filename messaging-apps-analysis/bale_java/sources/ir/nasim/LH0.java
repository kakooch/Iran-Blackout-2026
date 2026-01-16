package ir.nasim;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class LH0 extends AbstractC15488jg0 {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(InterfaceC14373ho3.a);

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // ir.nasim.AbstractC15488jg0
    protected Bitmap c(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        return AbstractC16827lv7.b(interfaceC13106fg0, bitmap, i, i2);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        return obj instanceof LH0;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return -599754482;
    }
}
