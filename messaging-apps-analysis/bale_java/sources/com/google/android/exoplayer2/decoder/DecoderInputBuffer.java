package com.google.android.exoplayer2.decoder;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC5461Jl0;
import ir.nasim.AbstractC9253Zd2;
import ir.nasim.C8171Uv1;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class DecoderInputBuffer extends AbstractC5461Jl0 {
    public final C8171Uv1 b;
    public ByteBuffer c;
    public boolean d;
    public long e;
    public ByteBuffer f;
    private final int g;
    private final int h;

    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int a;
        public final int b;

        public InsufficientCapacityException(int i, int i2) {
            super("Buffer too small (" + i + " < " + i2 + Separators.RPAREN);
            this.a = i;
            this.b = i2;
        }
    }

    static {
        AbstractC9253Zd2.a("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i) {
        this(i, 0);
    }

    public static DecoderInputBuffer C() {
        return new DecoderInputBuffer(0);
    }

    private ByteBuffer y(int i) {
        int i2 = this.g;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.c;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    public final void A() {
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean B() {
        return r(1073741824);
    }

    public void D(int i) {
        ByteBuffer byteBuffer = this.f;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.f = ByteBuffer.allocate(i);
        } else {
            this.f.clear();
        }
    }

    @Override // ir.nasim.AbstractC5461Jl0
    public void p() {
        super.p();
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.d = false;
    }

    public void z(int i) {
        int i2 = i + this.h;
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer == null) {
            this.c = y(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (iCapacity >= i3) {
            this.c = byteBuffer;
            return;
        }
        ByteBuffer byteBufferY = y(i3);
        byteBufferY.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferY.put(byteBuffer);
        }
        this.c = byteBufferY;
    }

    public DecoderInputBuffer(int i, int i2) {
        this.b = new C8171Uv1();
        this.g = i;
        this.h = i2;
    }
}
