package ir.nasim;

import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

/* renamed from: ir.nasim.xW0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23782xW0 extends MK4 {
    static final char[] d = "0123456789-$:/.+ABCD".toCharArray();
    static final int[] e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] f = {'A', 'B', 'C', 'D'};
    private final StringBuilder a = new StringBuilder(20);
    private int[] b = new int[80];
    private int c = 0;

    static boolean g(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private void h(int i) {
        int[] iArr = this.b;
        int i2 = this.c;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[i3 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.b = iArr2;
        }
    }

    private int i() throws NotFoundException {
        for (int i = 1; i < this.c; i += 2) {
            int iK = k(i);
            if (iK != -1 && g(f, d[iK])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.b[i3];
                }
                if (i == 1 || this.b[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw NotFoundException.a();
    }

    private void j(C3988Df0 c3988Df0) throws NotFoundException {
        int i = 0;
        this.c = 0;
        int iM = c3988Df0.m(0);
        int iN = c3988Df0.n();
        if (iM >= iN) {
            throw NotFoundException.a();
        }
        boolean z = true;
        while (iM < iN) {
            if (c3988Df0.i(iM) != z) {
                i++;
            } else {
                h(i);
                z = !z;
                i = 1;
            }
            iM++;
        }
        h(i);
    }

    private int k(int i) {
        int i2 = i + 7;
        if (i2 >= this.c) {
            return -1;
        }
        int[] iArr = this.b;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = e;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }

    private void l(int i) throws NotFoundException {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.a.length() - 1;
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = e[this.a.charAt(i3)];
            for (int i5 = 6; i5 >= 0; i5--) {
                int i6 = (i5 & 1) + ((i4 & 1) << 1);
                iArr[i6] = iArr[i6] + this.b[i2 + i5];
                iArr2[i6] = iArr2[i6] + 1;
                i4 >>= 1;
            }
            if (i3 >= length) {
                break;
            }
            i2 += 8;
            i3++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i7 = 0; i7 < 2; i7++) {
            fArr2[i7] = 0.0f;
            int i8 = i7 + 2;
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            float f2 = ((iArr[i7] / iArr2[i7]) + (i9 / i10)) / 2.0f;
            fArr2[i8] = f2;
            fArr[i7] = f2;
            fArr[i8] = ((i9 * 2.0f) + 1.5f) / i10;
        }
        int i11 = i;
        int i12 = 0;
        loop3: while (true) {
            int i13 = e[this.a.charAt(i12)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) << 1);
                float f3 = this.b[i11 + i14];
                if (f3 < fArr2[i15] || f3 > fArr[i15]) {
                    break loop3;
                }
                i13 >>= 1;
            }
            if (i12 >= length) {
                return;
            }
            i11 += 8;
            i12++;
        }
        throw NotFoundException.a();
    }

    @Override // ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) throws NotFoundException {
        int i2;
        Arrays.fill(this.b, 0);
        j(c3988Df0);
        int i3 = i();
        this.a.setLength(0);
        int i4 = i3;
        while (true) {
            int iK = k(i4);
            if (iK == -1) {
                throw NotFoundException.a();
            }
            this.a.append((char) iK);
            i2 = i4 + 8;
            if ((this.a.length() > 1 && g(f, d[iK])) || i2 >= this.c) {
                break;
            }
            i4 = i2;
        }
        int i5 = i4 + 7;
        int i6 = this.b[i5];
        int i7 = 0;
        for (int i8 = -8; i8 < -1; i8++) {
            i7 += this.b[i2 + i8];
        }
        if (i2 < this.c && i6 < i7 / 2) {
            throw NotFoundException.a();
        }
        l(i3);
        for (int i9 = 0; i9 < this.a.length(); i9++) {
            StringBuilder sb = this.a;
            sb.setCharAt(i9, d[sb.charAt(i9)]);
        }
        char cCharAt = this.a.charAt(0);
        char[] cArr = f;
        if (!g(cArr, cCharAt)) {
            throw NotFoundException.a();
        }
        StringBuilder sb2 = this.a;
        if (!g(cArr, sb2.charAt(sb2.length() - 1))) {
            throw NotFoundException.a();
        }
        if (this.a.length() <= 3) {
            throw NotFoundException.a();
        }
        if (map == null || !map.containsKey(EnumC19932rB1.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.a.deleteCharAt(0);
        }
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            i10 += this.b[i11];
        }
        float f2 = i10;
        while (i3 < i5) {
            i10 += this.b[i3];
            i3++;
        }
        float f3 = i;
        return new X06(this.a.toString(), null, new C12092e16[]{new C12092e16(f2, f3), new C12092e16(i10, f3)}, EnumC9549a90.CODABAR);
    }
}
