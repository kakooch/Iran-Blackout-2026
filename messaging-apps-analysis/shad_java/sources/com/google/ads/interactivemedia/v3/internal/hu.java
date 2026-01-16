package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class hu extends ht {
    private int[] d;
    private int[] e;

    hu() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void c(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) ary.t(this.e);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferI = i(((iLimit - iPosition) / this.b.e) * this.c.e);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                byteBufferI.putShort(byteBuffer.getShort(i + i + iPosition));
            }
            iPosition += this.b.e;
        }
        byteBuffer.position(iLimit);
        byteBufferI.flip();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    public final gv k(gv gvVar) throws gw {
        int[] iArr = this.d;
        if (iArr == null) {
            return gv.a;
        }
        if (gvVar.d != 2) {
            throw new gw(gvVar);
        }
        boolean z = gvVar.c != iArr.length;
        int i = 0;
        while (true) {
            int length = iArr.length;
            if (i >= length) {
                return z ? new gv(gvVar.b, length, 2) : gv.a;
            }
            int i2 = iArr[i];
            if (i2 >= gvVar.c) {
                throw new gw(gvVar);
            }
            z |= i2 != i;
            i++;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    protected final void m() {
        this.e = this.d;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    protected final void n() {
        this.e = null;
        this.d = null;
    }

    public final void o(int[] iArr) {
        this.d = iArr;
    }
}
