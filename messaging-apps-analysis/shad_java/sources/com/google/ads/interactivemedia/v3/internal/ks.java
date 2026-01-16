package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ks {
    private final byte[] a;
    private final int b;
    private int c;
    private int d;

    public ks(byte[] bArr) {
        this.a = bArr;
        this.b = bArr.length;
    }

    public final boolean a() {
        byte b = this.a[this.c];
        int i = this.d;
        c(1);
        return 1 == (((b & 255) >> i) & 1);
    }

    public final int b(int i) {
        int i2 = this.c;
        int iMin = Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.a[i2] & 255) >> this.d) & (255 >> (8 - iMin));
        while (iMin < i) {
            i4 |= (this.a[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        c(i);
        return ((-1) >>> (32 - i)) & i4;
    }

    public final void c(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.c + i3;
        this.c = i4;
        int i5 = this.d + (i - (i3 * 8));
        this.d = i5;
        if (i5 > 7) {
            i4++;
            this.c = i4;
            i5 -= 8;
            this.d = i5;
        }
        boolean z = false;
        if (i4 >= 0 && (i4 < (i2 = this.b) || (i4 == i2 && i5 == 0))) {
            z = true;
        }
        ary.q(z);
    }

    public final int d() {
        return (this.c * 8) + this.d;
    }
}
