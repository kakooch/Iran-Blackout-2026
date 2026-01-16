package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class iq extends ht {
    private int d;
    private int e;
    private boolean f;
    private int g;
    private byte[] h = aeu.f;
    private int i;
    private long j;

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void c(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.g);
        this.j += iMin / this.b.e;
        this.g -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.g > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.i + i2) - this.h.length;
        ByteBuffer byteBufferI = i(length);
        int iH = aeu.H(length, 0, this.i);
        byteBufferI.put(this.h, 0, iH);
        int iH2 = aeu.H(length - iH, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iH2);
        byteBufferI.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iH2;
        int i4 = this.i - iH;
        this.i = i4;
        byte[] bArr = this.h;
        System.arraycopy(bArr, iH, bArr, 0, i4);
        byteBuffer.get(this.h, this.i, i3);
        this.i += i3;
        byteBufferI.flip();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht, com.google.ads.interactivemedia.v3.internal.gx
    public final ByteBuffer e() {
        int i;
        if (super.f() && (i = this.i) > 0) {
            i(i).put(this.h, 0, this.i).flip();
            this.i = 0;
        }
        return super.e();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht, com.google.ads.interactivemedia.v3.internal.gx
    public final boolean f() {
        return super.f() && this.i == 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    public final gv k(gv gvVar) throws gw {
        if (gvVar.d != 2) {
            throw new gw(gvVar);
        }
        this.f = true;
        return (this.d == 0 && this.e == 0) ? gv.a : gvVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    protected final void l() {
        if (this.f) {
            if (this.i > 0) {
                this.j += r0 / this.b.e;
            }
            this.i = 0;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    protected final void m() {
        if (this.f) {
            this.f = false;
            int i = this.e;
            int i2 = this.b.e;
            this.h = new byte[i * i2];
            this.g = this.d * i2;
        }
        this.i = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    protected final void n() {
        this.h = aeu.f;
    }

    public final void o(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public final void p() {
        this.j = 0L;
    }

    public final long q() {
        return this.j;
    }
}
