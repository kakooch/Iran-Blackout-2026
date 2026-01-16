package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class lt {
    private static final long[] a = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];
    private int c;
    private int d;

    public static int c(int i) {
        int i2 = 0;
        while (i2 < 8) {
            long j = a[i2] & i;
            i2++;
            if (j != 0) {
                return i2;
            }
        }
        return -1;
    }

    public static long d(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= a[i - 1] ^ (-1);
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    public final void a() {
        this.c = 0;
        this.d = 0;
    }

    public final int b() {
        return this.d;
    }

    public final long e(jv jvVar, boolean z, boolean z2, int i) throws IOException {
        if (this.c == 0) {
            if (!jvVar.b(this.b, 0, 1, z)) {
                return -1L;
            }
            int iC = c(this.b[0] & 255);
            this.d = iC;
            if (iC == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        int i2 = this.d;
        if (i2 > i) {
            this.c = 0;
            return -2L;
        }
        if (i2 != 1) {
            jvVar.c(this.b, 1, i2 - 1);
        }
        this.c = 0;
        return d(this.b, this.d, z2);
    }
}
