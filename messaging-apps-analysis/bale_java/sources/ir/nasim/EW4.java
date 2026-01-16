package ir.nasim;

import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* loaded from: classes2.dex */
public final class EW4 {
    private static final char[] d = {'\r', '\n'};
    private static final char[] e = {'\n'};
    private static final AbstractC14535i43 f = AbstractC14535i43.b0(AbstractC12884fL0.a, AbstractC12884fL0.c, AbstractC12884fL0.f, AbstractC12884fL0.d, AbstractC12884fL0.e);
    private byte[] a;
    private int b;
    private int c;

    public EW4() {
        this.a = AbstractC9683aN7.f;
    }

    private void U(Charset charset) {
        if (k(charset, d) == '\r') {
            k(charset, e);
        }
    }

    private int d(Charset charset) {
        int i;
        if (charset.equals(AbstractC12884fL0.c) || charset.equals(AbstractC12884fL0.a)) {
            i = 1;
        } else {
            if (!charset.equals(AbstractC12884fL0.f) && !charset.equals(AbstractC12884fL0.e) && !charset.equals(AbstractC12884fL0.d)) {
                throw new IllegalArgumentException("Unsupported charset: " + charset);
            }
            i = 2;
        }
        int i2 = this.b;
        while (true) {
            int i3 = this.c;
            if (i2 >= i3 - (i - 1)) {
                return i3;
            }
            if ((charset.equals(AbstractC12884fL0.c) || charset.equals(AbstractC12884fL0.a)) && AbstractC9683aN7.v0(this.a[i2])) {
                return i2;
            }
            if (charset.equals(AbstractC12884fL0.f) || charset.equals(AbstractC12884fL0.d)) {
                byte[] bArr = this.a;
                if (bArr[i2] == 0 && AbstractC9683aN7.v0(bArr[i2 + 1])) {
                    return i2;
                }
            }
            if (charset.equals(AbstractC12884fL0.e)) {
                byte[] bArr2 = this.a;
                if (bArr2[i2 + 1] == 0 && AbstractC9683aN7.v0(bArr2[i2])) {
                    return i2;
                }
            }
            i2 += i;
        }
    }

    private char k(Charset charset, char[] cArr) {
        char cA;
        int i = 1;
        if ((charset.equals(AbstractC12884fL0.c) || charset.equals(AbstractC12884fL0.a)) && a() >= 1) {
            cA = AbstractC9658aL0.a(XB7.a(this.a[this.b]));
        } else {
            if ((!charset.equals(AbstractC12884fL0.f) && !charset.equals(AbstractC12884fL0.d)) || a() < 2) {
                if (charset.equals(AbstractC12884fL0.e) && a() >= 2) {
                    byte[] bArr = this.a;
                    int i2 = this.b;
                    cA = AbstractC9658aL0.c(bArr[i2 + 1], bArr[i2]);
                }
                return (char) 0;
            }
            byte[] bArr2 = this.a;
            int i3 = this.b;
            cA = AbstractC9658aL0.c(bArr2[i3], bArr2[i3 + 1]);
            i = 2;
        }
        if (AbstractC9658aL0.b(cArr, cA)) {
            this.b += i;
            return AbstractC9658aL0.a(cA);
        }
        return (char) 0;
    }

    public String A(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String strC = AbstractC9683aN7.C(this.a, i2, (i3 >= this.c || this.a[i3] != 0) ? i : i - 1);
        this.b += i;
        return strC;
    }

    public short B() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public String C(int i) {
        return D(i, AbstractC12884fL0.c);
    }

    public String D(int i, Charset charset) {
        String str = new String(this.a, this.b, i, charset);
        this.b += i;
        return str;
    }

    public int E() {
        return (F() << 21) | (F() << 14) | (F() << 7) | F();
    }

    public int F() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public int G() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
        this.b = i + 4;
        return i2;
    }

    public long H() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 3;
        long j = ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        this.b = i + 4;
        return (bArr[i2] & 255) | j;
    }

    public int I() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 2;
        int i3 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
        this.b = i + 3;
        return (bArr[i2] & 255) | i3;
    }

    public int J() {
        int iO = o();
        if (iO >= 0) {
            return iO;
        }
        throw new IllegalStateException("Top bit not zero: " + iO);
    }

    public long K() {
        long jY = y();
        if (jY >= 0) {
            return jY;
        }
        throw new IllegalStateException("Top bit not zero: " + jY);
    }

    public int L() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (bArr[i2] & 255) | i3;
    }

    public long M() {
        int i;
        int i2;
        long j = this.a[this.b];
        int i3 = 7;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= r6 - 1;
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        for (i = 1; i < i2; i++) {
            if ((this.a[this.b + i] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | (r3 & Utf8.REPLACEMENT_BYTE);
        }
        this.b += i2;
        return j;
    }

    public Charset N() {
        if (a() >= 3) {
            byte[] bArr = this.a;
            int i = this.b;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.b = i + 3;
                return AbstractC12884fL0.c;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.a;
        int i2 = this.b;
        byte b = bArr2[i2];
        if (b == -2 && bArr2[i2 + 1] == -1) {
            this.b = i2 + 2;
            return AbstractC12884fL0.d;
        }
        if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        }
        this.b = i2 + 2;
        return AbstractC12884fL0.e;
    }

    public void O(int i) {
        Q(b() < i ? new byte[i] : this.a, i);
    }

    public void P(byte[] bArr) {
        Q(bArr, bArr.length);
    }

    public void Q(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    public void R(int i) {
        AbstractC20011rK.a(i >= 0 && i <= this.a.length);
        this.c = i;
    }

    public void S(int i) {
        AbstractC20011rK.a(i >= 0 && i <= this.c);
        this.b = i;
    }

    public void T(int i) {
        S(this.b + i);
    }

    public int a() {
        return this.c - this.b;
    }

    public int b() {
        return this.a.length;
    }

    public void c(int i) {
        if (i > b()) {
            this.a = Arrays.copyOf(this.a, i);
        }
    }

    public byte[] e() {
        return this.a;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.a[this.b] & 255;
    }

    public void i(DW4 dw4, int i) {
        j(dw4.a, 0, i);
        dw4.p(0);
    }

    public void j(byte[] bArr, int i, int i2) {
        System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public String l(char c) {
        if (a() == 0) {
            return null;
        }
        int i = this.b;
        while (i < this.c && this.a[i] != c) {
            i++;
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        String strC = AbstractC9683aN7.C(bArr, i2, i - i2);
        this.b = i;
        if (i < this.c) {
            this.b = i + 1;
        }
        return strC;
    }

    public double m() {
        return Double.longBitsToDouble(y());
    }

    public float n() {
        return Float.intBitsToFloat(o());
    }

    public int o() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 8);
        this.b = i + 4;
        return (bArr[i3] & 255) | i4;
    }

    public int p() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 2;
        int i3 = ((bArr[i + 1] & 255) << 8) | (((bArr[i] & 255) << 24) >> 8);
        this.b = i + 3;
        return (bArr[i2] & 255) | i3;
    }

    public String q() {
        return r(AbstractC12884fL0.c);
    }

    public String r(Charset charset) {
        AbstractC20011rK.b(f.contains(charset), "Unsupported charset: " + charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(AbstractC12884fL0.a)) {
            N();
        }
        String strD = D(d(charset) - this.b, charset);
        if (this.b == this.c) {
            return strD;
        }
        U(charset);
        return strD;
    }

    public int s() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 16);
        this.b = i + 4;
        return ((bArr[i3] & 255) << 24) | i4;
    }

    public long t() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 7;
        long j = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        this.b = i + 8;
        return ((bArr[i2] & 255) << 56) | j;
    }

    public short u() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public long v() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 3;
        long j = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        this.b = i + 4;
        return ((bArr[i2] & 255) << 24) | j;
    }

    public int w() {
        int iS = s();
        if (iS >= 0) {
            return iS;
        }
        throw new IllegalStateException("Top bit not zero: " + iS);
    }

    public int x() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public long y() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 7;
        long j = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        this.b = i + 8;
        return (bArr[i2] & 255) | j;
    }

    public String z() {
        return l((char) 0);
    }

    public EW4(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public EW4(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public EW4(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
    }
}
