package com.google.ads.interactivemedia.v3.internal;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.nio.charset.Charset;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aee {
    private byte[] a;
    private int b;
    private int c;

    public aee() {
        this.a = aeu.f;
    }

    public aee(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
    }

    public final int A() {
        return (n() << 21) | (n() << 14) | (n() << 7) | n();
    }

    public final int B() {
        int iV = v();
        if (iV >= 0) {
            return iV;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(iV);
        throw new IllegalStateException(sb.toString());
    }

    public final int C() {
        int iW = w();
        if (iW >= 0) {
            return iW;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(iW);
        throw new IllegalStateException(sb.toString());
    }

    public final long D() {
        long jX = x();
        if (jX >= 0) {
            return jX;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(jX);
        throw new IllegalStateException(sb.toString());
    }

    public final String E(int i) {
        return F(i, apv.b);
    }

    public final String F(int i, Charset charset) {
        String str = new String(this.a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public final String G(int i) {
        if (i == 0) {
            return BuildConfig.FLAVOR;
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String strX = aeu.x(this.a, i2, (i3 >= this.c || this.a[i3] != 0) ? i : i - 1);
        this.b += i;
        return strX;
    }

    public final String H() {
        if (d() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.a[i] != 0) {
            i++;
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        String strX = aeu.x(bArr, i2, i - i2);
        this.b = i;
        if (i < this.c) {
            this.b = i + 1;
        }
        return strX;
    }

    public final String I() {
        if (d() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && !aeu.B(this.a[i])) {
            i++;
        }
        int i2 = this.b;
        if (i - i2 >= 3) {
            byte[] bArr = this.a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                i2 += 3;
                this.b = i2;
            }
        }
        String strX = aeu.x(this.a, i2, i - i2);
        this.b = i;
        int i3 = this.c;
        if (i == i3) {
            return strX;
        }
        byte[] bArr2 = this.a;
        if (bArr2[i] == 13) {
            i++;
            this.b = i;
            if (i == i3) {
                return strX;
            }
        }
        if (bArr2[i] == 10) {
            this.b = i + 1;
        }
        return strX;
    }

    public final long J() {
        int i;
        int i2;
        long j = this.a[this.b];
        int i3 = 7;
        while (true) {
            i = 0;
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= r7 - 1;
                i = 7 - i3;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder(55);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j);
            throw new NumberFormatException(sb.toString());
        }
        for (i2 = 1; i2 < i; i2++) {
            if ((this.a[this.b + i2] & 192) != 128) {
                StringBuilder sb2 = new StringBuilder(62);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j);
                throw new NumberFormatException(sb2.toString());
            }
            j = (j << 6) | (r2 & 63);
        }
        this.b += i;
        return j;
    }

    public final void a(int i) {
        c(j() < i ? new byte[i] : this.a, i);
    }

    public final void b(byte[] bArr) {
        c(bArr, bArr.length);
    }

    public final void c(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    public final int d() {
        return this.c - this.b;
    }

    public final int e() {
        return this.c;
    }

    public final void f(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.a.length) {
            z = true;
        }
        ary.o(z);
        this.c = i;
    }

    public final int g() {
        return this.b;
    }

    public final void h(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.c) {
            z = true;
        }
        ary.o(z);
        this.b = i;
    }

    public final byte[] i() {
        return this.a;
    }

    public final int j() {
        return this.a.length;
    }

    public final void k(int i) {
        h(this.b + i);
    }

    public final void l(aed aedVar, int i) {
        m(aedVar.a, 0, i);
        aedVar.e(0);
    }

    public final void m(byte[] bArr, int i, int i2) {
        System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final int n() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final int o() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return (bArr[i2] & 255) | ((b & 255) << 8);
    }

    public final int p() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (b & 255);
    }

    public final short q() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        this.b = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((b & 255) << 8));
    }

    public final int r() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        this.b = i3 + 1;
        return (bArr[i3] & 255) | ((b & 255) << 16) | ((b2 & 255) << 8);
    }

    public final int s() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        this.b = i3 + 1;
        return (bArr[i3] & 255) | (((b & 255) << 24) >> 8) | ((b2 & 255) << 8);
    }

    public final long t() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        this.b = i4 + 1;
        return ((b2 & 255) << 16) | ((b & 255) << 24) | ((b3 & 255) << 8) | (bArr[i4] & 255);
    }

    public final long u() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        this.b = i4 + 1;
        return ((b2 & 255) << 8) | (b & 255) | ((b3 & 255) << 16) | ((bArr[i4] & 255) << 24);
    }

    public final int v() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        this.b = i4 + 1;
        return (bArr[i4] & 255) | ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8);
    }

    public final int w() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        this.b = i4 + 1;
        return ((bArr[i4] & 255) << 24) | (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16);
    }

    public final long x() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        int i5 = i4 + 1;
        this.b = i5;
        byte b4 = bArr[i4];
        int i6 = i5 + 1;
        this.b = i6;
        byte b5 = bArr[i5];
        int i7 = i6 + 1;
        this.b = i7;
        byte b6 = bArr[i6];
        int i8 = i7 + 1;
        this.b = i8;
        byte b7 = bArr[i7];
        this.b = i8 + 1;
        return ((b2 & 255) << 48) | ((b & 255) << 56) | ((b3 & 255) << 40) | ((b4 & 255) << 32) | ((b5 & 255) << 24) | ((b6 & 255) << 16) | ((b7 & 255) << 8) | (bArr[i8] & 255);
    }

    public final long y() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.b = i4;
        byte b3 = bArr[i3];
        int i5 = i4 + 1;
        this.b = i5;
        byte b4 = bArr[i4];
        int i6 = i5 + 1;
        this.b = i6;
        byte b5 = bArr[i5];
        int i7 = i6 + 1;
        this.b = i7;
        byte b6 = bArr[i6];
        int i8 = i7 + 1;
        this.b = i8;
        byte b7 = bArr[i7];
        this.b = i8 + 1;
        return ((b2 & 255) << 8) | (b & 255) | ((b3 & 255) << 16) | ((b4 & 255) << 24) | ((b5 & 255) << 32) | ((b6 & 255) << 40) | ((b7 & 255) << 48) | ((bArr[i8] & 255) << 56);
    }

    public final int z() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.b = i3;
        byte b2 = bArr[i2];
        this.b = i3 + 2;
        return (b2 & 255) | ((b & 255) << 8);
    }

    public aee(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public aee(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }
}
