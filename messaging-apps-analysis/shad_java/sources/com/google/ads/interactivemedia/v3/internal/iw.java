package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class iw extends ir {
    public final it a;
    public ByteBuffer b;
    public boolean c;
    public long d;
    public ByteBuffer e;
    private final int f;

    public iw(int i) {
        this.a = new it();
        this.f = i;
    }

    private final ByteBuffer m(int i) {
        int i2 = this.f;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.b;
        int iCapacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(iCapacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ir
    public void a() {
        super.a();
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.e;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.c = false;
    }

    public final void i(int i) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer == null) {
            this.b = m(i);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (iCapacity >= i2) {
            this.b = byteBuffer;
            return;
        }
        ByteBuffer byteBufferM = m(i2);
        byteBufferM.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferM.put(byteBuffer);
        }
        this.b = byteBufferM;
    }

    public final boolean j() {
        return this.b == null && this.f == 0;
    }

    public final boolean k() {
        return h(1073741824);
    }

    public final void l() {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.e;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public iw() {
        this(1);
    }
}
