package ir.nasim;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class P46 extends AbstractC15488jg0 {
    private static final byte[] c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(InterfaceC14373ho3.a);
    private final int b;

    public P46(int i) {
        AbstractC3322Aj5.a(i > 0, "roundingRadius must be greater than 0.");
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        messageDigest.update(c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // ir.nasim.AbstractC15488jg0
    protected Bitmap c(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        return AbstractC16827lv7.o(interfaceC13106fg0, bitmap, this.b);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        return (obj instanceof P46) && this.b == ((P46) obj).b;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return YM7.p(-569625254, YM7.o(this.b));
    }
}
