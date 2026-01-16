package ir.nasim;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: ir.nasim.Mo4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6193Mo4 {
    public static final byte[] a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object c = new Object();
    private static int[] d = new int[10];

    /* renamed from: ir.nasim.Mo4$a */
    public static final class a {
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int[] e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final float j;

        public a(int i, boolean z, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, float f) {
            this.a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = iArr;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = i7;
            this.j = f;
        }
    }

    /* renamed from: ir.nasim.Mo4$b */
    public static final class b {
        public final int a;
        public final int b;
        public final boolean c;

        public b(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    /* renamed from: ir.nasim.Mo4$c */
    public static final class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final float h;
        public final boolean i;
        public final boolean j;
        public final int k;
        public final int l;
        public final int m;
        public final boolean n;

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, boolean z, boolean z2, int i8, int i9, int i10, boolean z3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = f;
            this.i = z;
            this.j = z2;
            this.k = i8;
            this.l = i9;
            this.m = i10;
            this.n = z3;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i4 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i4 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i4 == 0) {
                i2++;
            }
            if (i4 != 0) {
                i2 = 0;
            }
            i = i3;
        }
    }

    public static int c(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        AbstractC20011rK.g(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            a(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            a(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            a(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b2 = bArr[i5];
            if ((b2 & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b2 == 1) {
                    a(zArr);
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    private static int d(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int e(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static boolean g(String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i, int i2) {
        return i(bArr, i + 2, i2);
    }

    public static a i(byte[] bArr, int i, int i2) {
        FW4 fw4 = new FW4(bArr, i, i2);
        fw4.l(4);
        int iE = fw4.e(3);
        fw4.k();
        int iE2 = fw4.e(2);
        boolean zD = fw4.d();
        int iE3 = fw4.e(5);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            if (fw4.d()) {
                i3 |= 1 << i4;
            }
            i4++;
        }
        int[] iArr = new int[6];
        for (int i5 = 0; i5 < 6; i5++) {
            iArr[i5] = fw4.e(8);
        }
        int iE4 = fw4.e(8);
        int i6 = 0;
        for (int i7 = 0; i7 < iE; i7++) {
            if (fw4.d()) {
                i6 += 89;
            }
            if (fw4.d()) {
                i6 += 8;
            }
        }
        fw4.l(i6);
        if (iE > 0) {
            fw4.l((8 - iE) * 2);
        }
        int iH = fw4.h();
        int iH2 = fw4.h();
        if (iH2 == 3) {
            fw4.k();
        }
        int iH3 = fw4.h();
        int iH4 = fw4.h();
        if (fw4.d()) {
            int iH5 = fw4.h();
            int iH6 = fw4.h();
            int iH7 = fw4.h();
            int iH8 = fw4.h();
            iH3 -= ((iH2 == 1 || iH2 == 2) ? 2 : 1) * (iH5 + iH6);
            iH4 -= (iH2 == 1 ? 2 : 1) * (iH7 + iH8);
        }
        int i8 = iH3;
        fw4.h();
        fw4.h();
        int iH9 = fw4.h();
        for (int i9 = fw4.d() ? 0 : iE; i9 <= iE; i9++) {
            fw4.h();
            fw4.h();
            fw4.h();
        }
        fw4.h();
        fw4.h();
        fw4.h();
        fw4.h();
        fw4.h();
        fw4.h();
        if (fw4.d() && fw4.d()) {
            n(fw4);
        }
        fw4.l(2);
        if (fw4.d()) {
            fw4.l(8);
            fw4.h();
            fw4.h();
            fw4.k();
        }
        p(fw4);
        if (fw4.d()) {
            for (int i10 = 0; i10 < fw4.h(); i10++) {
                fw4.l(iH9 + 5);
            }
        }
        fw4.l(2);
        float f = 1.0f;
        if (fw4.d()) {
            if (fw4.d()) {
                int iE5 = fw4.e(8);
                if (iE5 == 255) {
                    int iE6 = fw4.e(16);
                    int iE7 = fw4.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f = iE6 / iE7;
                    }
                } else {
                    float[] fArr = b;
                    if (iE5 < fArr.length) {
                        f = fArr[iE5];
                    } else {
                        AbstractC18815pI3.k("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (fw4.d()) {
                fw4.k();
            }
            if (fw4.d()) {
                fw4.l(4);
                if (fw4.d()) {
                    fw4.l(24);
                }
            }
            if (fw4.d()) {
                fw4.h();
                fw4.h();
            }
            fw4.k();
            if (fw4.d()) {
                iH4 *= 2;
            }
        }
        return new a(iE2, zD, iE3, i3, iArr, iE4, iH, i8, iH4, f);
    }

    public static b j(byte[] bArr, int i, int i2) {
        return k(bArr, i + 1, i2);
    }

    public static b k(byte[] bArr, int i, int i2) {
        FW4 fw4 = new FW4(bArr, i, i2);
        int iH = fw4.h();
        int iH2 = fw4.h();
        fw4.k();
        return new b(iH, iH2, fw4.d());
    }

    public static c l(byte[] bArr, int i, int i2) {
        return m(bArr, i + 1, i2);
    }

    public static c m(byte[] bArr, int i, int i2) {
        int iH;
        boolean zD;
        int i3;
        boolean z;
        boolean z2;
        int iH2;
        float f;
        int i4;
        FW4 fw4 = new FW4(bArr, i, i2);
        int iE = fw4.e(8);
        int iE2 = fw4.e(8);
        int iE3 = fw4.e(8);
        int iH3 = fw4.h();
        if (iE == 100 || iE == 110 || iE == 122 || iE == 244 || iE == 44 || iE == 83 || iE == 86 || iE == 118 || iE == 128 || iE == 138) {
            iH = fw4.h();
            zD = iH == 3 ? fw4.d() : false;
            fw4.h();
            fw4.h();
            fw4.k();
            if (fw4.d()) {
                int i5 = iH != 3 ? 8 : 12;
                int i6 = 0;
                while (i6 < i5) {
                    if (fw4.d()) {
                        o(fw4, i6 < 6 ? 16 : 64);
                    }
                    i6++;
                }
            }
        } else {
            iH = 1;
            zD = false;
        }
        int iH4 = fw4.h() + 4;
        int iH5 = fw4.h();
        if (iH5 == 0) {
            i3 = iH;
            z = zD;
            iH2 = fw4.h() + 4;
            z2 = false;
        } else {
            if (iH5 == 1) {
                boolean zD2 = fw4.d();
                fw4.g();
                fw4.g();
                z = zD;
                long jH = fw4.h();
                i3 = iH;
                for (int i7 = 0; i7 < jH; i7++) {
                    fw4.h();
                }
                z2 = zD2;
            } else {
                i3 = iH;
                z = zD;
                z2 = false;
            }
            iH2 = 0;
        }
        int iH6 = fw4.h();
        fw4.k();
        int iH7 = fw4.h() + 1;
        int iH8 = fw4.h() + 1;
        boolean zD3 = fw4.d();
        int i8 = (2 - (zD3 ? 1 : 0)) * iH8;
        if (!zD3) {
            fw4.k();
        }
        fw4.k();
        int i9 = iH7 * 16;
        int i10 = i8 * 16;
        if (fw4.d()) {
            int iH9 = fw4.h();
            int iH10 = fw4.h();
            int iH11 = fw4.h();
            int iH12 = fw4.h();
            if (i3 == 0) {
                i4 = 2 - (zD3 ? 1 : 0);
            } else {
                int i11 = i3;
                i = i11 == 3 ? 1 : 2;
                i4 = (2 - (zD3 ? 1 : 0)) * (i11 == 1 ? 2 : 1);
            }
            i9 -= (iH9 + iH10) * i;
            i10 -= (iH11 + iH12) * i4;
        }
        int i12 = i9;
        int i13 = i10;
        float f2 = 1.0f;
        if (fw4.d() && fw4.d()) {
            int iE4 = fw4.e(8);
            if (iE4 == 255) {
                int iE5 = fw4.e(16);
                int iE6 = fw4.e(16);
                if (iE5 != 0 && iE6 != 0) {
                    f2 = iE5 / iE6;
                }
            } else {
                float[] fArr = b;
                if (iE4 < fArr.length) {
                    f = fArr[iE4];
                } else {
                    AbstractC18815pI3.k("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE4);
                }
            }
            f = f2;
        } else {
            f = f2;
        }
        return new c(iE, iE2, iE3, iH3, iH6, i12, i13, f, z, zD3, iH4, iH5, iH2, z2);
    }

    private static void n(FW4 fw4) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (fw4.d()) {
                    int iMin = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        fw4.g();
                    }
                    for (int i4 = 0; i4 < iMin; i4++) {
                        fw4.g();
                    }
                } else {
                    fw4.h();
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private static void o(FW4 fw4, int i) {
        int iG = 8;
        int i2 = 8;
        for (int i3 = 0; i3 < i; i3++) {
            if (iG != 0) {
                iG = ((fw4.g() + i2) + 256) % 256;
            }
            if (iG != 0) {
                i2 = iG;
            }
        }
    }

    private static void p(FW4 fw4) {
        int iH = fw4.h();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < iH; i3++) {
            if (i3 == 0 || !fw4.d()) {
                int iH2 = fw4.h();
                int iH3 = fw4.h();
                int[] iArr2 = new int[iH2];
                for (int i4 = 0; i4 < iH2; i4++) {
                    iArr2[i4] = fw4.h() + 1;
                    fw4.k();
                }
                int[] iArr3 = new int[iH3];
                for (int i5 = 0; i5 < iH3; i5++) {
                    iArr3[i5] = fw4.h() + 1;
                    fw4.k();
                }
                i = iH2;
                iArr = iArr2;
                i2 = iH3;
                iArrCopyOf = iArr3;
            } else {
                int i6 = i + i2;
                int iH4 = (1 - ((fw4.d() ? 1 : 0) * 2)) * (fw4.h() + 1);
                int i7 = i6 + 1;
                boolean[] zArr = new boolean[i7];
                for (int i8 = 0; i8 <= i6; i8++) {
                    if (fw4.d()) {
                        zArr[i8] = true;
                    } else {
                        zArr[i8] = fw4.d();
                    }
                }
                int[] iArr4 = new int[i7];
                int[] iArr5 = new int[i7];
                int i9 = 0;
                for (int i10 = i2 - 1; i10 >= 0; i10--) {
                    int i11 = iArrCopyOf[i10] + iH4;
                    if (i11 < 0 && zArr[i + i10]) {
                        iArr4[i9] = i11;
                        i9++;
                    }
                }
                if (iH4 < 0 && zArr[i6]) {
                    iArr4[i9] = iH4;
                    i9++;
                }
                for (int i12 = 0; i12 < i; i12++) {
                    int i13 = iArr[i12] + iH4;
                    if (i13 < 0 && zArr[i12]) {
                        iArr4[i9] = i13;
                        i9++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i9);
                int i14 = 0;
                for (int i15 = i - 1; i15 >= 0; i15--) {
                    int i16 = iArr[i15] + iH4;
                    if (i16 > 0 && zArr[i15]) {
                        iArr5[i14] = i16;
                        i14++;
                    }
                }
                if (iH4 > 0 && zArr[i6]) {
                    iArr5[i14] = iH4;
                    i14++;
                }
                for (int i17 = 0; i17 < i2; i17++) {
                    int i18 = iArrCopyOf[i17] + iH4;
                    if (i18 > 0 && zArr[i + i17]) {
                        iArr5[i14] = i18;
                        i14++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr5, i14);
                iArr = iArrCopyOf2;
                i = i9;
                i2 = i14;
            }
        }
    }

    public static int q(byte[] bArr, int i) {
        int i2;
        synchronized (c) {
            int iD = 0;
            int i3 = 0;
            while (iD < i) {
                try {
                    iD = d(bArr, iD, i);
                    if (iD < i) {
                        int[] iArr = d;
                        if (iArr.length <= i3) {
                            d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        d[i3] = iD;
                        iD += 3;
                        i3++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i2 = i - i3;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = d[i6] - i5;
                System.arraycopy(bArr, i5, bArr, i4, i7);
                int i8 = i4 + i7;
                int i9 = i8 + 1;
                bArr[i8] = 0;
                i4 = i8 + 2;
                bArr[i9] = 0;
                i5 += i7 + 3;
            }
            System.arraycopy(bArr, i5, bArr, i4, i2 - i4);
        }
        return i2;
    }
}
