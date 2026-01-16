package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class in extends ht {
    private final long d;
    private final long e;
    private final short f;
    private int g;
    private boolean h;
    private byte[] i;
    private byte[] j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private long o;

    public in() {
        ary.o(true);
        this.d = 150000L;
        this.e = 20000L;
        this.f = (short) 1024;
        byte[] bArr = aeu.f;
        this.i = bArr;
        this.j = bArr;
    }

    private final void q(byte[] bArr, int i) {
        i(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.n = true;
        }
    }

    private final void r(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.m);
        int i2 = this.m - iMin;
        System.arraycopy(bArr, i - i2, this.j, 0, i2);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.j, i2, iMin);
    }

    private final int s(long j) {
        return (int) ((j * this.b.b) / 1000000);
    }

    private final int t(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > 1024) {
                int i = this.g;
                return i * (iPosition / i);
            }
        }
        return byteBuffer.limit();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht, com.google.ads.interactivemedia.v3.internal.gx
    public final boolean b() {
        return this.h;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void c(ByteBuffer byteBuffer) {
        int iPosition;
        while (byteBuffer.hasRemaining() && !j()) {
            int i = this.k;
            if (i == 0) {
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.i.length));
                int iLimit2 = byteBuffer.limit();
                while (true) {
                    iLimit2 -= 2;
                    if (iLimit2 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    } else if (Math.abs((int) byteBuffer.getShort(iLimit2)) > 1024) {
                        int i2 = this.g;
                        iPosition = ((iLimit2 / i2) * i2) + i2;
                        break;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.k = 1;
                } else {
                    byteBuffer.limit(iPosition);
                    int iRemaining = byteBuffer.remaining();
                    i(iRemaining).put(byteBuffer).flip();
                    if (iRemaining > 0) {
                        this.n = true;
                    }
                }
                byteBuffer.limit(iLimit);
            } else if (i != 1) {
                int iLimit3 = byteBuffer.limit();
                int iT = t(byteBuffer);
                byteBuffer.limit(iT);
                this.o += byteBuffer.remaining() / this.g;
                r(byteBuffer, this.j, this.m);
                if (iT < iLimit3) {
                    q(this.j, this.m);
                    this.k = 0;
                    byteBuffer.limit(iLimit3);
                }
            } else {
                int iLimit4 = byteBuffer.limit();
                int iT2 = t(byteBuffer);
                int iPosition2 = iT2 - byteBuffer.position();
                byte[] bArr = this.i;
                int length = bArr.length;
                int i3 = this.l;
                int i4 = length - i3;
                if (iT2 >= iLimit4 || iPosition2 >= i4) {
                    int iMin = Math.min(iPosition2, i4);
                    byteBuffer.limit(byteBuffer.position() + iMin);
                    byteBuffer.get(this.i, this.l, iMin);
                    int i5 = this.l + iMin;
                    this.l = i5;
                    byte[] bArr2 = this.i;
                    if (i5 == bArr2.length) {
                        if (this.n) {
                            q(bArr2, this.m);
                            long j = this.o;
                            int i6 = this.l;
                            int i7 = this.m;
                            this.o = j + ((i6 - (i7 + i7)) / this.g);
                            i5 = i6;
                        } else {
                            this.o += (i5 - this.m) / this.g;
                        }
                        r(byteBuffer, this.i, i5);
                        this.l = 0;
                        this.k = 2;
                    }
                    byteBuffer.limit(iLimit4);
                } else {
                    q(bArr, i3);
                    this.l = 0;
                    this.k = 0;
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    public final gv k(gv gvVar) throws gw {
        if (gvVar.d == 2) {
            return this.h ? gvVar : gv.a;
        }
        throw new gw(gvVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    protected final void l() {
        int i = this.l;
        if (i > 0) {
            q(this.i, i);
        }
        if (this.n) {
            return;
        }
        this.o += this.m / this.g;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    protected final void m() {
        if (this.h) {
            this.g = this.b.e;
            int iS = s(150000L) * this.g;
            if (this.i.length != iS) {
                this.i = new byte[iS];
            }
            int iS2 = s(20000L) * this.g;
            this.m = iS2;
            if (this.j.length != iS2) {
                this.j = new byte[iS2];
            }
        }
        this.k = 0;
        this.o = 0L;
        this.l = 0;
        this.n = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    protected final void n() {
        this.h = false;
        this.m = 0;
        byte[] bArr = aeu.f;
        this.i = bArr;
        this.j = bArr;
    }

    public final void o(boolean z) {
        this.h = z;
    }

    public final long p() {
        return this.o;
    }
}
