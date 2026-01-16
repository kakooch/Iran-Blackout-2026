package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* renamed from: ir.nasim.Gf0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4705Gf0 implements Cloneable {
    private final int a;
    private final int b;
    private final int c;
    private final int[] d;

    public C4705Gf0(int i) {
        this(i, i);
    }

    private String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.b * (this.a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.a; i2++) {
                sb.append(e(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C4705Gf0 clone() {
        return new C4705Gf0(this.a, this.b, this.c, (int[]) this.d.clone());
    }

    public void d(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public boolean e(int i, int i2) {
        return ((this.d[(i2 * this.c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4705Gf0)) {
            return false;
        }
        C4705Gf0 c4705Gf0 = (C4705Gf0) obj;
        return this.a == c4705Gf0.a && this.b == c4705Gf0.b && this.c == c4705Gf0.c && Arrays.equals(this.d, c4705Gf0.d);
    }

    public int[] f() {
        int length = this.d.length - 1;
        while (length >= 0 && this.d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.c;
        int i2 = length / i;
        int i3 = (length % i) << 5;
        int i4 = 31;
        while ((this.d[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int[] h() {
        int i = this.a;
        int i2 = this.b;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.b; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.c;
                if (i6 < i7) {
                    int i8 = this.d[(i7 * i5) + i6];
                    if (i8 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i4) {
                            i4 = i5;
                        }
                        int i9 = i6 << 5;
                        if (i9 < i) {
                            int i10 = 0;
                            while ((i8 << (31 - i10)) == 0) {
                                i10++;
                            }
                            int i11 = i10 + i9;
                            if (i11 < i) {
                                i = i11;
                            }
                        }
                        if (i9 + 31 > i3) {
                            int i12 = 31;
                            while ((i8 >>> i12) == 0) {
                                i12--;
                            }
                            int i13 = i9 + i12;
                            if (i13 > i3) {
                                i3 = i13;
                            }
                        }
                    }
                    i6++;
                }
            }
        }
        if (i3 < i || i4 < i2) {
            return null;
        }
        return new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
    }

    public int hashCode() {
        int i = this.a;
        return (((((((i * 31) + i) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public int i() {
        return this.b;
    }

    public C3988Df0 k(int i, C3988Df0 c3988Df0) {
        if (c3988Df0 == null || c3988Df0.n() < this.a) {
            c3988Df0 = new C3988Df0(this.a);
        } else {
            c3988Df0.e();
        }
        int i2 = i * this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            c3988Df0.t(i3 << 5, this.d[i2 + i3]);
        }
        return c3988Df0;
    }

    public int[] l() {
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            iArr = this.d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        while ((iArr[i2] << (31 - i)) == 0) {
            i++;
        }
        return new int[]{i5 + i, i4};
    }

    public int m() {
        return this.a;
    }

    public void n() {
        int iM = m();
        int i = i();
        C3988Df0 c3988Df0 = new C3988Df0(iM);
        C3988Df0 c3988Df02 = new C3988Df0(iM);
        for (int i2 = 0; i2 < (i + 1) / 2; i2++) {
            c3988Df0 = k(i2, c3988Df0);
            int i3 = (i - 1) - i2;
            c3988Df02 = k(i3, c3988Df02);
            c3988Df0.r();
            c3988Df02.r();
            q(i2, c3988Df02);
            q(i3, c3988Df0);
        }
    }

    public void o(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void p(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.b || i5 > this.a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.c * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.d;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public void q(int i, C3988Df0 c3988Df0) {
        int[] iArrK = c3988Df0.k();
        int[] iArr = this.d;
        int i2 = this.c;
        System.arraycopy(iArrK, 0, iArr, i * i2, i2);
    }

    public String r(String str, String str2) {
        return b(str, str2, Separators.RETURN);
    }

    public String toString() {
        return r("X ", "  ");
    }

    public C4705Gf0(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.a = i;
        this.b = i2;
        int i3 = (i + 31) / 32;
        this.c = i3;
        this.d = new int[i3 * i2];
    }

    private C4705Gf0(int i, int i2, int i3, int[] iArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
    }
}
