package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class no extends nr {
    private static final byte[] a = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean b;

    no() {
    }

    public static boolean d(aee aeeVar) {
        if (aeeVar.d() < 8) {
            return false;
        }
        byte[] bArr = new byte[8];
        aeeVar.m(bArr, 0, 8);
        return Arrays.equals(bArr, a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final void a(boolean z) {
        super.a(z);
        if (z) {
            this.b = false;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final long b(aee aeeVar) {
        byte[] bArrI = aeeVar.i();
        int i = bArrI[0] & 255;
        int i2 = i & 3;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (i2 != 1 && i2 != 2) {
            i3 = bArrI[1] & 63;
        }
        int i4 = i >> 3;
        return h(i3 * (i4 >= 16 ? 2500 << r1 : i4 >= 12 ? 10000 << (r1 & 1) : (i4 & 3) == 3 ? 60000 : 10000 << r1));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final boolean c(aee aeeVar, long j, np npVar) {
        if (this.b) {
            boolean z = aeeVar.v() == 1332770163;
            aeeVar.h(0);
            return z;
        }
        byte[] bArrCopyOf = Arrays.copyOf(aeeVar.i(), aeeVar.e());
        byte b = bArrCopyOf[9];
        List<byte[]> listH = mz.h(bArrCopyOf);
        cx cxVar = new cx();
        cxVar.ae("audio/opus");
        cxVar.H(b & 255);
        cxVar.af(48000);
        cxVar.T(listH);
        npVar.a = cxVar.a();
        this.b = true;
        return true;
    }
}
