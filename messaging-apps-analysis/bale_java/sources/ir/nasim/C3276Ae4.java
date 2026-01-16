package ir.nasim;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: ir.nasim.Ae4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3276Ae4 extends AbstractC12507ej7 {
    public static C3276Ae4 h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new C3276Ae4());
    }

    public static C3276Ae4 i(ByteBuffer byteBuffer, C3276Ae4 c3276Ae4) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c3276Ae4.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public C3276Ae4 f(int i, ByteBuffer byteBuffer) {
        g(i, byteBuffer);
        return this;
    }

    public void g(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public C25046ze4 j(C25046ze4 c25046ze4, int i) {
        int iB = b(6);
        if (iB != 0) {
            return c25046ze4.f(a(d(iB) + (i * 4)), this.b);
        }
        return null;
    }

    public int k() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.b.getInt(iB + this.a);
        }
        return 0;
    }
}
