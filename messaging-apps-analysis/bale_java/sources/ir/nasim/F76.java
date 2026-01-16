package ir.nasim;

/* loaded from: classes8.dex */
public class F76 extends GE2 {
    static final int[] n = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private int m;

    public F76() {
        this.l = new int[64];
        reset();
    }

    private int n(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    private int o(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    private int p(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    private int q(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    private int r(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    private int s(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    private void t(F76 f76) {
        super.h(f76);
        this.d = f76.d;
        this.e = f76.e;
        this.f = f76.f;
        this.g = f76.g;
        this.h = f76.h;
        this.i = f76.i;
        this.j = f76.j;
        this.k = f76.k;
        int[] iArr = f76.l;
        System.arraycopy(iArr, 0, this.l, 0, iArr.length);
        this.m = f76.m;
    }

    @Override // ir.nasim.BT1
    public int a(byte[] bArr, int i) {
        i();
        AbstractC23160wS4.a(this.d, bArr, i);
        AbstractC23160wS4.a(this.e, bArr, i + 4);
        AbstractC23160wS4.a(this.f, bArr, i + 8);
        AbstractC23160wS4.a(this.g, bArr, i + 12);
        AbstractC23160wS4.a(this.h, bArr, i + 16);
        AbstractC23160wS4.a(this.i, bArr, i + 20);
        AbstractC23160wS4.a(this.j, bArr, i + 24);
        AbstractC23160wS4.a(this.k, bArr, i + 28);
        reset();
        return 32;
    }

    @Override // ir.nasim.BT1
    public int b() {
        return 32;
    }

    @Override // ir.nasim.H34
    public H34 d() {
        return new F76(this);
    }

    @Override // ir.nasim.BT1
    public String e() {
        return "SHA-256";
    }

    @Override // ir.nasim.H34
    public void f(H34 h34) {
        t((F76) h34);
    }

    @Override // ir.nasim.GE2
    protected void j() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.l;
            int iS = s(iArr[i - 2]);
            int[] iArr2 = this.l;
            iArr[i] = iS + iArr2[i - 7] + r(iArr2[i - 15]) + this.l[i - 16];
        }
        int iP = this.d;
        int iP2 = this.e;
        int iP3 = this.f;
        int iP4 = this.g;
        int i2 = this.h;
        int i3 = this.i;
        int i4 = this.j;
        int i5 = this.k;
        int i6 = 0;
        for (int i7 = 0; i7 < 8; i7++) {
            int iQ = q(i2) + n(i2, i3, i4);
            int[] iArr3 = n;
            int i8 = i5 + iQ + iArr3[i6] + this.l[i6];
            int i9 = iP4 + i8;
            int iP5 = i8 + p(iP) + o(iP, iP2, iP3);
            int i10 = i6 + 1;
            int iQ2 = i4 + q(i9) + n(i9, i2, i3) + iArr3[i10] + this.l[i10];
            int i11 = iP3 + iQ2;
            int iP6 = iQ2 + p(iP5) + o(iP5, iP, iP2);
            int i12 = i6 + 2;
            int iQ3 = i3 + q(i11) + n(i11, i9, i2) + iArr3[i12] + this.l[i12];
            int i13 = iP2 + iQ3;
            int iP7 = iQ3 + p(iP6) + o(iP6, iP5, iP);
            int i14 = i6 + 3;
            int iQ4 = i2 + q(i13) + n(i13, i11, i9) + iArr3[i14] + this.l[i14];
            int i15 = iP + iQ4;
            int iP8 = iQ4 + p(iP7) + o(iP7, iP6, iP5);
            int i16 = i6 + 4;
            int iQ5 = i9 + q(i15) + n(i15, i13, i11) + iArr3[i16] + this.l[i16];
            i5 = iP5 + iQ5;
            iP4 = iQ5 + p(iP8) + o(iP8, iP7, iP6);
            int i17 = i6 + 5;
            int iQ6 = i11 + q(i5) + n(i5, i15, i13) + iArr3[i17] + this.l[i17];
            i4 = iP6 + iQ6;
            iP3 = iQ6 + p(iP4) + o(iP4, iP8, iP7);
            int i18 = i6 + 6;
            int iQ7 = i13 + q(i4) + n(i4, i5, i15) + iArr3[i18] + this.l[i18];
            i3 = iP7 + iQ7;
            iP2 = iQ7 + p(iP3) + o(iP3, iP4, iP8);
            int i19 = i6 + 7;
            int iQ8 = i15 + q(i3) + n(i3, i4, i5) + iArr3[i19] + this.l[i19];
            i2 = iP8 + iQ8;
            iP = iQ8 + p(iP2) + o(iP2, iP3, iP4);
            i6 += 8;
        }
        this.d += iP;
        this.e += iP2;
        this.f += iP3;
        this.g += iP4;
        this.h += i2;
        this.i += i3;
        this.j += i4;
        this.k += i5;
        this.m = 0;
        for (int i20 = 0; i20 < 16; i20++) {
            this.l[i20] = 0;
        }
    }

    @Override // ir.nasim.GE2
    protected void k(long j) {
        if (this.m > 14) {
            j();
        }
        int[] iArr = this.l;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // ir.nasim.GE2
    protected void l(byte[] bArr, int i) {
        int i2 = (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        int[] iArr = this.l;
        int i3 = this.m;
        iArr[i3] = i2;
        int i4 = i3 + 1;
        this.m = i4;
        if (i4 == 16) {
            j();
        }
    }

    @Override // ir.nasim.GE2, ir.nasim.BT1
    public void reset() {
        super.reset();
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

    public F76(F76 f76) {
        super(f76);
        this.l = new int[64];
        t(f76);
    }
}
