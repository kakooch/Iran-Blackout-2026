package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class im extends ht {
    im() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.gx
    public final void c(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.b.d;
        if (i2 == 3) {
            i += i;
        } else if (i2 == 4) {
            i /= 2;
        } else if (i2 != 268435456) {
            if (i2 != 536870912) {
                if (i2 != 805306368) {
                    throw new IllegalStateException();
                }
                i /= 2;
            } else {
                i /= 3;
                i += i;
            }
        }
        ByteBuffer byteBufferI = i(i);
        int i3 = this.b.d;
        if (i3 == 3) {
            while (iPosition < iLimit) {
                byteBufferI.put((byte) 0);
                byteBufferI.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i3 == 4) {
            while (iPosition < iLimit) {
                short sJ = (short) (aeu.J(byteBuffer.getFloat(iPosition), -1.0f, 1.0f) * 32767.0f);
                byteBufferI.put((byte) (sJ & 255));
                byteBufferI.put((byte) ((sJ >> 8) & 255));
                iPosition += 4;
            }
        } else if (i3 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferI.put(byteBuffer.get(iPosition + 1));
                byteBufferI.put(byteBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i3 == 536870912) {
            while (iPosition < iLimit) {
                byteBufferI.put(byteBuffer.get(iPosition + 1));
                byteBufferI.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else {
            if (i3 != 805306368) {
                throw new IllegalStateException();
            }
            while (iPosition < iLimit) {
                byteBufferI.put(byteBuffer.get(iPosition + 2));
                byteBufferI.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferI.flip();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ht
    public final gv k(gv gvVar) throws gw {
        int i = gvVar.d;
        if (i != 3) {
            if (i == 2) {
                return gv.a;
            }
            if (i != 268435456 && i != 536870912 && i != 805306368 && i != 4) {
                throw new gw(gvVar);
            }
        }
        return new gv(gvVar.b, gvVar.c, 2);
    }
}
