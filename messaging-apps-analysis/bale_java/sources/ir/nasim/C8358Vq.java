package ir.nasim;

import android.content.Context;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: ir.nasim.Vq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8358Vq implements InterfaceC14373ho3 {
    private final int b;
    private final InterfaceC14373ho3 c;

    private C8358Vq(int i, InterfaceC14373ho3 interfaceC14373ho3) {
        this.b = i;
        this.c = interfaceC14373ho3;
    }

    public static InterfaceC14373ho3 c(Context context) {
        return new C8358Vq(context.getResources().getConfiguration().uiMode & 48, AbstractC14649iG.c(context));
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (!(obj instanceof C8358Vq)) {
            return false;
        }
        C8358Vq c8358Vq = (C8358Vq) obj;
        return this.b == c8358Vq.b && this.c.equals(c8358Vq.c);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return YM7.q(this.c, this.b);
    }
}
