package ir.nasim;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* renamed from: ir.nasim.gp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13789gp2 extends AbstractC15488jg0 {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(InterfaceC14373ho3.a);

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // ir.nasim.AbstractC15488jg0
    protected Bitmap c(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        return AbstractC16827lv7.f(interfaceC13106fg0, bitmap, i, i2);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        return obj instanceof C13789gp2;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return 1572326941;
    }
}
