package com.google.protobuf;

import com.google.protobuf.AbstractC2383g;
import ir.nasim.AbstractC6428No0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
final class X extends AbstractC2383g.i {
    private final ByteBuffer e;

    X(ByteBuffer byteBuffer) {
        B.b(byteBuffer, "buffer");
        this.e = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer l0(int i, int i2) {
        if (i < this.e.position() || i2 > this.e.limit() || i > i2) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        ByteBuffer byteBufferSlice = this.e.slice();
        byteBufferSlice.position(i - this.e.position());
        byteBufferSlice.limit(i2 - this.e.position());
        return byteBufferSlice;
    }

    @Override // com.google.protobuf.AbstractC2383g
    protected void O(byte[] bArr, int i, int i2, int i3) {
        ByteBuffer byteBufferSlice = this.e.slice();
        byteBufferSlice.position(i);
        byteBufferSlice.get(bArr, i2, i3);
    }

    @Override // com.google.protobuf.AbstractC2383g
    public byte P(int i) {
        return r(i);
    }

    @Override // com.google.protobuf.AbstractC2383g
    public boolean Q() {
        return p0.r(this.e);
    }

    @Override // com.google.protobuf.AbstractC2383g
    public AbstractC2384h V() {
        return AbstractC2384h.k(this.e, true);
    }

    @Override // com.google.protobuf.AbstractC2383g
    protected int W(int i, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + this.e.get(i4);
        }
        return i;
    }

    @Override // com.google.protobuf.AbstractC2383g
    public AbstractC2383g Z(int i, int i2) {
        try {
            return new X(l0(i, i2));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // com.google.protobuf.AbstractC2383g
    protected String d0(Charset charset) {
        byte[] bArrA0;
        int length;
        int iArrayOffset;
        if (this.e.hasArray()) {
            bArrA0 = this.e.array();
            iArrayOffset = this.e.arrayOffset() + this.e.position();
            length = this.e.remaining();
        } else {
            bArrA0 = a0();
            length = bArrA0.length;
            iArrayOffset = 0;
        }
        return new String(bArrA0, iArrayOffset, length, charset);
    }

    @Override // com.google.protobuf.AbstractC2383g
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2383g)) {
            return false;
        }
        AbstractC2383g abstractC2383g = (AbstractC2383g) obj;
        if (size() != abstractC2383g.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof X ? this.e.equals(((X) obj).e) : this.e.equals(abstractC2383g.j());
    }

    @Override // com.google.protobuf.AbstractC2383g
    public ByteBuffer j() {
        return this.e.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.AbstractC2383g
    void k0(AbstractC6428No0 abstractC6428No0) {
        abstractC6428No0.a(this.e.slice());
    }

    @Override // com.google.protobuf.AbstractC2383g
    public byte r(int i) {
        try {
            return this.e.get(i);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // com.google.protobuf.AbstractC2383g
    public int size() {
        return this.e.remaining();
    }
}
