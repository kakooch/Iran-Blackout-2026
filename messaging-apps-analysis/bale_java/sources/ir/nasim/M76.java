package ir.nasim;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class M76 extends H90 {
    int d;

    @Override // ir.nasim.H90
    public void e(ByteBuffer byteBuffer) {
        this.d = AbstractC5635Ke3.m(byteBuffer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.d == ((M76) obj).d;
    }

    public ByteBuffer f() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        AbstractC5869Le3.j(byteBufferAllocate, 6);
        AbstractC5869Le3.j(byteBufferAllocate, 1);
        AbstractC5869Le3.j(byteBufferAllocate, this.d);
        return byteBufferAllocate;
    }

    public int g() {
        return 3;
    }

    public void h(int i) {
        this.d = i;
    }

    public int hashCode() {
        return this.d;
    }

    public String toString() {
        return "SLConfigDescriptor{predefined=" + this.d + '}';
    }
}
