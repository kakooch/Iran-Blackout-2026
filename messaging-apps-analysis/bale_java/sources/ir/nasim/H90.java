package ir.nasim;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class H90 {
    int a;
    int b;
    int c;

    public int a() {
        return this.b + 1 + this.c;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public final void d(int i, ByteBuffer byteBuffer) {
        this.a = i;
        int iM = AbstractC5635Ke3.m(byteBuffer);
        this.b = iM & 127;
        int i2 = 1;
        while ((iM >>> 7) == 1) {
            iM = AbstractC5635Ke3.m(byteBuffer);
            i2++;
            this.b = (this.b << 7) | (iM & 127);
        }
        this.c = i2;
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit(this.b);
        e(byteBufferSlice);
        byteBuffer.position(byteBuffer.position() + this.b);
    }

    public abstract void e(ByteBuffer byteBuffer);
}
