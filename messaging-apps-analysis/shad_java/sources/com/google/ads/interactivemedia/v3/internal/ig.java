package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ig extends ht {
    private static final int d = Float.floatToIntBits(Float.NaN);

    ig() {
    }

    private static void o(int i, ByteBuffer byteBuffer) {
        double d2 = i;
        Double.isNaN(d2);
        int iFloatToIntBits = Float.floatToIntBits((float) (d2 * 4.656612875245797E-10d));
        if (iFloatToIntBits == d) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void c(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferI;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.b.d;
        if (i2 == 536870912) {
            byteBufferI = i((i / 3) * 4);
            while (iPosition < iLimit) {
                o(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferI);
                iPosition += 3;
            }
        } else {
            if (i2 != 805306368) {
                throw new IllegalStateException();
            }
            byteBufferI = i(i);
            while (iPosition < iLimit) {
                o((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferI);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferI.flip();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    public final gv k(gv gvVar) throws gw {
        int i = gvVar.d;
        if (aeu.Y(i)) {
            return i != 4 ? new gv(gvVar.b, gvVar.c, 4) : gv.a;
        }
        throw new gw(gvVar);
    }
}
