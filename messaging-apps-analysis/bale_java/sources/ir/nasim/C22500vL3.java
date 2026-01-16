package ir.nasim;

/* renamed from: ir.nasim.vL3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22500vL3 extends HE2 {
    private int d;
    private int e;
    private int f;
    private int g;
    private int[] h = new int[16];
    private int i;

    public C22500vL3() {
        e();
    }

    private int h(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    private int i(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    private int j(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int k(int i, int i2, int i3) {
        return (i | (~i3)) ^ i2;
    }

    private int m(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    private void n(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    @Override // ir.nasim.HE2
    protected void b() {
        int i = this.d;
        int i2 = this.e;
        int i3 = this.f;
        int i4 = this.g;
        int iM = m(((i + h(i2, i3, i4)) + this.h[0]) - 680876936, 7) + i2;
        int iM2 = m(((i4 + h(iM, i2, i3)) + this.h[1]) - 389564586, 12) + iM;
        int iM3 = m(i3 + h(iM2, iM, i2) + this.h[2] + 606105819, 17) + iM2;
        int iM4 = m(((i2 + h(iM3, iM2, iM)) + this.h[3]) - 1044525330, 22) + iM3;
        int iM5 = m(((iM + h(iM4, iM3, iM2)) + this.h[4]) - 176418897, 7) + iM4;
        int iM6 = m(iM2 + h(iM5, iM4, iM3) + this.h[5] + 1200080426, 12) + iM5;
        int iM7 = m(((iM3 + h(iM6, iM5, iM4)) + this.h[6]) - 1473231341, 17) + iM6;
        int iM8 = m(((iM4 + h(iM7, iM6, iM5)) + this.h[7]) - 45705983, 22) + iM7;
        int iM9 = m(iM5 + h(iM8, iM7, iM6) + this.h[8] + 1770035416, 7) + iM8;
        int iM10 = m(((iM6 + h(iM9, iM8, iM7)) + this.h[9]) - 1958414417, 12) + iM9;
        int iM11 = m(((iM7 + h(iM10, iM9, iM8)) + this.h[10]) - 42063, 17) + iM10;
        int iM12 = m(((iM8 + h(iM11, iM10, iM9)) + this.h[11]) - 1990404162, 22) + iM11;
        int iM13 = m(iM9 + h(iM12, iM11, iM10) + this.h[12] + 1804603682, 7) + iM12;
        int iM14 = m(((iM10 + h(iM13, iM12, iM11)) + this.h[13]) - 40341101, 12) + iM13;
        int iM15 = m(((iM11 + h(iM14, iM13, iM12)) + this.h[14]) - 1502002290, 17) + iM14;
        int iM16 = m(iM12 + h(iM15, iM14, iM13) + this.h[15] + 1236535329, 22) + iM15;
        int iM17 = m(((iM13 + i(iM16, iM15, iM14)) + this.h[1]) - 165796510, 5) + iM16;
        int iM18 = m(((iM14 + i(iM17, iM16, iM15)) + this.h[6]) - 1069501632, 9) + iM17;
        int iM19 = m(iM15 + i(iM18, iM17, iM16) + this.h[11] + 643717713, 14) + iM18;
        int iM20 = m(((iM16 + i(iM19, iM18, iM17)) + this.h[0]) - 373897302, 20) + iM19;
        int iM21 = m(((iM17 + i(iM20, iM19, iM18)) + this.h[5]) - 701558691, 5) + iM20;
        int iM22 = m(iM18 + i(iM21, iM20, iM19) + this.h[10] + 38016083, 9) + iM21;
        int iM23 = m(((iM19 + i(iM22, iM21, iM20)) + this.h[15]) - 660478335, 14) + iM22;
        int iM24 = m(((iM20 + i(iM23, iM22, iM21)) + this.h[4]) - 405537848, 20) + iM23;
        int iM25 = m(iM21 + i(iM24, iM23, iM22) + this.h[9] + 568446438, 5) + iM24;
        int iM26 = m(((iM22 + i(iM25, iM24, iM23)) + this.h[14]) - 1019803690, 9) + iM25;
        int iM27 = m(((iM23 + i(iM26, iM25, iM24)) + this.h[3]) - 187363961, 14) + iM26;
        int iM28 = m(iM24 + i(iM27, iM26, iM25) + this.h[8] + 1163531501, 20) + iM27;
        int iM29 = m(((iM25 + i(iM28, iM27, iM26)) + this.h[13]) - 1444681467, 5) + iM28;
        int iM30 = m(((iM26 + i(iM29, iM28, iM27)) + this.h[2]) - 51403784, 9) + iM29;
        int iM31 = m(iM27 + i(iM30, iM29, iM28) + this.h[7] + 1735328473, 14) + iM30;
        int iM32 = m(((iM28 + i(iM31, iM30, iM29)) + this.h[12]) - 1926607734, 20) + iM31;
        int iM33 = m(((iM29 + j(iM32, iM31, iM30)) + this.h[5]) - 378558, 4) + iM32;
        int iM34 = m(((iM30 + j(iM33, iM32, iM31)) + this.h[8]) - 2022574463, 11) + iM33;
        int iM35 = m(iM31 + j(iM34, iM33, iM32) + this.h[11] + 1839030562, 16) + iM34;
        int iM36 = m(((iM32 + j(iM35, iM34, iM33)) + this.h[14]) - 35309556, 23) + iM35;
        int iM37 = m(((iM33 + j(iM36, iM35, iM34)) + this.h[1]) - 1530992060, 4) + iM36;
        int iM38 = m(iM34 + j(iM37, iM36, iM35) + this.h[4] + 1272893353, 11) + iM37;
        int iM39 = m(((iM35 + j(iM38, iM37, iM36)) + this.h[7]) - 155497632, 16) + iM38;
        int iM40 = m(((iM36 + j(iM39, iM38, iM37)) + this.h[10]) - 1094730640, 23) + iM39;
        int iM41 = m(iM37 + j(iM40, iM39, iM38) + this.h[13] + 681279174, 4) + iM40;
        int iM42 = m(((iM38 + j(iM41, iM40, iM39)) + this.h[0]) - 358537222, 11) + iM41;
        int iM43 = m(((iM39 + j(iM42, iM41, iM40)) + this.h[3]) - 722521979, 16) + iM42;
        int iM44 = m(iM40 + j(iM43, iM42, iM41) + this.h[6] + 76029189, 23) + iM43;
        int iM45 = m(((iM41 + j(iM44, iM43, iM42)) + this.h[9]) - 640364487, 4) + iM44;
        int iM46 = m(((iM42 + j(iM45, iM44, iM43)) + this.h[12]) - 421815835, 11) + iM45;
        int iM47 = m(iM43 + j(iM46, iM45, iM44) + this.h[15] + 530742520, 16) + iM46;
        int iM48 = m(((iM44 + j(iM47, iM46, iM45)) + this.h[2]) - 995338651, 23) + iM47;
        int iM49 = m(((iM45 + k(iM48, iM47, iM46)) + this.h[0]) - 198630844, 6) + iM48;
        int iM50 = m(iM46 + k(iM49, iM48, iM47) + this.h[7] + 1126891415, 10) + iM49;
        int iM51 = m(((iM47 + k(iM50, iM49, iM48)) + this.h[14]) - 1416354905, 15) + iM50;
        int iM52 = m(((iM48 + k(iM51, iM50, iM49)) + this.h[5]) - 57434055, 21) + iM51;
        int iM53 = m(iM49 + k(iM52, iM51, iM50) + this.h[12] + 1700485571, 6) + iM52;
        int iM54 = m(((iM50 + k(iM53, iM52, iM51)) + this.h[3]) - 1894986606, 10) + iM53;
        int iM55 = m(((iM51 + k(iM54, iM53, iM52)) + this.h[10]) - 1051523, 15) + iM54;
        int iM56 = m(((iM52 + k(iM55, iM54, iM53)) + this.h[1]) - 2054922799, 21) + iM55;
        int iM57 = m(iM53 + k(iM56, iM55, iM54) + this.h[8] + 1873313359, 6) + iM56;
        int iM58 = m(((iM54 + k(iM57, iM56, iM55)) + this.h[15]) - 30611744, 10) + iM57;
        int iM59 = m(((iM55 + k(iM58, iM57, iM56)) + this.h[6]) - 1560198380, 15) + iM58;
        int iM60 = m(iM56 + k(iM59, iM58, iM57) + this.h[13] + 1309151649, 21) + iM59;
        int iM61 = m(((iM57 + k(iM60, iM59, iM58)) + this.h[4]) - 145523070, 6) + iM60;
        int iM62 = m(((iM58 + k(iM61, iM60, iM59)) + this.h[11]) - 1120210379, 10) + iM61;
        int iM63 = m(iM59 + k(iM62, iM61, iM60) + this.h[2] + 718787259, 15) + iM62;
        int iM64 = m(((iM60 + k(iM63, iM62, iM61)) + this.h[9]) - 343485551, 21) + iM63;
        this.d += iM61;
        this.e += iM64;
        this.f += iM63;
        this.g += iM62;
        this.i = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.h;
            if (i5 == iArr.length) {
                return;
            }
            iArr[i5] = 0;
            i5++;
        }
    }

    @Override // ir.nasim.HE2
    protected void c(long j) {
        if (this.i > 14) {
            b();
        }
        int[] iArr = this.h;
        iArr[14] = (int) j;
        iArr[15] = (int) (j >>> 32);
    }

    @Override // ir.nasim.HE2
    protected void d(byte[] bArr, int i) {
        int[] iArr = this.h;
        int i2 = this.i;
        int i3 = i2 + 1;
        this.i = i3;
        iArr[i2] = ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        if (i3 == 16) {
            b();
        }
    }

    @Override // ir.nasim.HE2
    public void e() {
        super.e();
        this.d = 1732584193;
        this.e = -271733879;
        this.f = -1732584194;
        this.g = 271733878;
        this.i = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.h;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public int l(byte[] bArr, int i) {
        a();
        n(this.d, bArr, i);
        n(this.e, bArr, i + 4);
        n(this.f, bArr, i + 8);
        n(this.g, bArr, i + 12);
        e();
        return 16;
    }
}
