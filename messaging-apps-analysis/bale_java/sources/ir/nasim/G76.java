package ir.nasim;

/* loaded from: classes5.dex */
public class G76 extends HE2 {
    static final int[] n = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l = new int[64];
    private int m;

    public G76() {
        e();
    }

    private int h(int i, int i2, int i3) {
        return AbstractC23750xS4.f(((~i) & i3) ^ (i2 & i));
    }

    private int i(int i, int i2, int i3) {
        return AbstractC23750xS4.f(((i & i3) ^ (i & i2)) ^ (i2 & i3));
    }

    private int j(int i) {
        return AbstractC23750xS4.f((AbstractC23750xS4.f(i << 10) | AbstractC23750xS4.f(i >>> 22)) ^ ((AbstractC23750xS4.f(i >>> 2) | AbstractC23750xS4.f(i << 30)) ^ (AbstractC23750xS4.f(i >>> 13) | AbstractC23750xS4.f(i << 19))));
    }

    private int k(int i) {
        return AbstractC23750xS4.f((AbstractC23750xS4.f(i << 7) | AbstractC23750xS4.f(i >>> 25)) ^ ((AbstractC23750xS4.f(i >>> 6) | AbstractC23750xS4.f(i << 26)) ^ (AbstractC23750xS4.f(i >>> 11) | AbstractC23750xS4.f(i << 21))));
    }

    private int l(int i) {
        return AbstractC23750xS4.f(AbstractC23750xS4.f(i >>> 3) ^ ((AbstractC23750xS4.f(i >>> 7) | AbstractC23750xS4.f(i << 25)) ^ (AbstractC23750xS4.f(i >>> 18) | AbstractC23750xS4.f(i << 14))));
    }

    private int m(int i) {
        return AbstractC23750xS4.f(AbstractC23750xS4.f(i >>> 10) ^ ((AbstractC23750xS4.f(i >>> 17) | AbstractC23750xS4.f(i << 15)) ^ (AbstractC23750xS4.f(i >>> 19) | AbstractC23750xS4.f(i << 13))));
    }

    @Override // ir.nasim.HE2
    protected void b() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.l;
            iArr[i] = AbstractC23750xS4.f(m(iArr[i - 2]) + this.l[i - 7]);
            int[] iArr2 = this.l;
            iArr2[i] = AbstractC23750xS4.f(iArr2[i] + l(iArr2[i - 15]));
            int[] iArr3 = this.l;
            iArr3[i] = AbstractC23750xS4.f(iArr3[i] + iArr3[i - 16]);
        }
        int iF = this.d;
        int iF2 = this.e;
        int iF3 = this.f;
        int iF4 = this.g;
        int iF5 = this.h;
        int iF6 = this.i;
        int iF7 = this.j;
        int iF8 = this.k;
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            int iF9 = AbstractC23750xS4.f(AbstractC23750xS4.f(iF8 + k(iF5)) + h(iF5, iF6, iF7));
            int[] iArr4 = n;
            int iF10 = AbstractC23750xS4.f(AbstractC23750xS4.f(iF9 + iArr4[i2]) + this.l[i2]);
            int iF11 = AbstractC23750xS4.f(iF4 + iF10);
            int iF12 = AbstractC23750xS4.f(AbstractC23750xS4.f(iF10 + j(iF)) + i(iF, iF2, iF3));
            int i4 = i2 + 1;
            int iF13 = AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(iF7 + k(iF11)) + h(iF11, iF5, iF6)) + iArr4[i4]) + this.l[i4]);
            int iF14 = AbstractC23750xS4.f(iF3 + iF13);
            int iF15 = AbstractC23750xS4.f(AbstractC23750xS4.f(iF13 + j(iF12)) + i(iF12, iF, iF2));
            int i5 = i2 + 2;
            int iF16 = AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(iF6 + k(iF14)) + h(iF14, iF11, iF5)) + iArr4[i5]) + this.l[i5]);
            int iF17 = AbstractC23750xS4.f(iF2 + iF16);
            int iF18 = AbstractC23750xS4.f(AbstractC23750xS4.f(iF16 + j(iF15)) + i(iF15, iF12, iF));
            int i6 = i2 + 3;
            int iF19 = AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(iF5 + k(iF17)) + h(iF17, iF14, iF11)) + iArr4[i6]) + this.l[i6]);
            int iF20 = AbstractC23750xS4.f(iF + iF19);
            int iF21 = AbstractC23750xS4.f(iF19 + j(iF18) + i(iF18, iF15, iF12));
            int i7 = i2 + 4;
            int iF22 = AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(iF11 + k(iF20)) + h(iF20, iF17, iF14)) + iArr4[i7]) + this.l[i7]);
            iF8 = AbstractC23750xS4.f(iF12 + iF22);
            iF4 = AbstractC23750xS4.f(AbstractC23750xS4.f(iF22 + j(iF21)) + i(iF21, iF18, iF15));
            int i8 = i2 + 5;
            int iF23 = AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(iF14 + k(iF8)) + h(iF8, iF20, iF17)) + iArr4[i8]) + this.l[i8]);
            iF7 = AbstractC23750xS4.f(iF15 + iF23);
            iF3 = AbstractC23750xS4.f(AbstractC23750xS4.f(iF23 + j(iF4)) + i(iF4, iF21, iF18));
            int i9 = i2 + 6;
            int iF24 = AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(iF17 + k(iF7)) + h(iF7, iF8, iF20)) + iArr4[i9]) + this.l[i9]);
            iF6 = AbstractC23750xS4.f(iF18 + iF24);
            iF2 = AbstractC23750xS4.f(AbstractC23750xS4.f(iF24 + j(iF3)) + i(iF3, iF4, iF21));
            int i10 = i2 + 7;
            int iF25 = AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(AbstractC23750xS4.f(iF20 + k(iF6)) + h(iF6, iF7, iF8)) + iArr4[i10]) + this.l[i10]);
            iF5 = AbstractC23750xS4.f(iF21 + iF25);
            iF = AbstractC23750xS4.f(AbstractC23750xS4.f(iF25 + j(iF2)) + i(iF2, iF3, iF4));
            i2 += 8;
        }
        this.d = AbstractC23750xS4.f(this.d + iF);
        this.e = AbstractC23750xS4.f(this.e + iF2);
        this.f = AbstractC23750xS4.f(this.f + iF3);
        this.g = AbstractC23750xS4.f(this.g + iF4);
        this.h = AbstractC23750xS4.f(this.h + iF5);
        this.i = AbstractC23750xS4.f(this.i + iF6);
        this.j = AbstractC23750xS4.f(this.j + iF7);
        this.k = AbstractC23750xS4.f(this.k + iF8);
        this.m = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            this.l[i11] = 0;
        }
    }

    @Override // ir.nasim.HE2
    protected void c(long j) {
        if (this.m > 14) {
            b();
        }
        int[] iArr = this.l;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // ir.nasim.HE2
    protected void d(byte[] bArr, int i) {
        int iF = AbstractC23750xS4.f(bArr[i + 3] & 255) | AbstractC23750xS4.f(bArr[i] << 24) | AbstractC23750xS4.f((bArr[i + 1] & 255) << 16) | AbstractC23750xS4.f((bArr[i + 2] & 255) << 8);
        int[] iArr = this.l;
        int i2 = this.m;
        iArr[i2] = iF;
        int i3 = i2 + 1;
        this.m = i3;
        if (i3 == 16) {
            b();
        }
    }

    @Override // ir.nasim.HE2
    public void e() {
        super.e();
        this.d = 1779033703;
        this.e = -1150833019;
        this.f = 1013904242;
        this.g = -1521486534;
        this.h = 1359893119;
        this.i = -1694144372;
        this.j = 528734635;
        this.k = 1541459225;
        this.m = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.l;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public int n(byte[] bArr, int i) {
        a();
        AbstractC23750xS4.c(this.d, bArr, i);
        AbstractC23750xS4.c(this.e, bArr, i + 4);
        AbstractC23750xS4.c(this.f, bArr, i + 8);
        AbstractC23750xS4.c(this.g, bArr, i + 12);
        AbstractC23750xS4.c(this.h, bArr, i + 16);
        AbstractC23750xS4.c(this.i, bArr, i + 20);
        AbstractC23750xS4.c(this.j, bArr, i + 24);
        AbstractC23750xS4.c(this.k, bArr, i + 28);
        e();
        return 32;
    }

    public int o() {
        return 32;
    }
}
