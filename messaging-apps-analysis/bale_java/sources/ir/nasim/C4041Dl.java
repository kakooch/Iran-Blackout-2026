package ir.nasim;

import androidx.recyclerview.widget.GridLayoutManager;

/* renamed from: ir.nasim.Dl, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4041Dl extends GridLayoutManager.b {
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final Integer[] j;
    private final Integer[] k;
    private final XV4[] l;
    private final int m;
    private final int n;
    private final int o;

    public C4041Dl(int i, int i2, int i3, int i4, int i5) {
        int iT;
        int iJ;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
        boolean z = i == 0;
        Integer[] numArr = new Integer[i2];
        for (int i6 = 0; i6 < i2; i6++) {
            numArr[i6] = 0;
        }
        this.k = numArr;
        switch (this.f) {
            case 1:
                this.n = 1;
                this.o = 1;
                numArr[0] = 1;
                break;
            case 2:
                if (z) {
                    this.n = 1;
                    this.o = 2;
                } else {
                    this.n = 2;
                    this.o = 1;
                }
                numArr[0] = 1;
                numArr[1] = 1;
                break;
            case 3:
                this.n = 2;
                this.o = 2;
                numArr[0] = 2;
                numArr[1] = 1;
                numArr[2] = 1;
                break;
            case 4:
                this.n = 2;
                this.o = 2;
                numArr[0] = 1;
                numArr[1] = 1;
                numArr[2] = 1;
                numArr[3] = 1;
                break;
            case 5:
                if (z) {
                    this.n = 2;
                    this.o = 3;
                } else {
                    this.n = 3;
                    this.o = 2;
                }
                numArr[0] = 2;
                numArr[1] = 1;
                numArr[2] = 1;
                numArr[3] = 1;
                numArr[4] = 1;
                break;
            case 6:
                if (z) {
                    this.n = 2;
                    this.o = 3;
                } else {
                    this.n = 3;
                    this.o = 2;
                }
                numArr[0] = 1;
                numArr[1] = 1;
                numArr[2] = 1;
                numArr[3] = 1;
                numArr[4] = 1;
                numArr[5] = 1;
                break;
            case 7:
                if (z) {
                    this.n = 4;
                    this.o = 3;
                    numArr[0] = 2;
                    numArr[1] = 2;
                    numArr[2] = 2;
                    numArr[3] = 2;
                    numArr[4] = 2;
                    numArr[5] = 1;
                    numArr[6] = 1;
                    break;
                } else {
                    this.n = 3;
                    this.o = 6;
                    numArr[0] = 3;
                    numArr[1] = 3;
                    numArr[2] = 3;
                    numArr[3] = 3;
                    numArr[4] = 2;
                    numArr[5] = 2;
                    numArr[6] = 2;
                    break;
                }
            case 8:
                if (z) {
                    this.n = 4;
                    this.o = 3;
                    numArr[0] = 2;
                    numArr[1] = 2;
                    numArr[2] = 2;
                    numArr[3] = 2;
                    numArr[4] = 1;
                    numArr[5] = 1;
                    numArr[6] = 1;
                    numArr[7] = 1;
                    break;
                } else {
                    this.n = 3;
                    this.o = 6;
                    numArr[0] = 3;
                    numArr[1] = 3;
                    numArr[2] = 2;
                    numArr[3] = 2;
                    numArr[4] = 2;
                    numArr[5] = 2;
                    numArr[6] = 2;
                    numArr[7] = 2;
                    break;
                }
            case 9:
                if (z) {
                    this.n = 4;
                    this.o = 3;
                    numArr[0] = 2;
                    numArr[1] = 2;
                    numArr[2] = 2;
                    numArr[3] = 1;
                    numArr[4] = 1;
                    numArr[5] = 1;
                    numArr[6] = 1;
                    numArr[7] = 1;
                    numArr[8] = 1;
                    break;
                } else {
                    this.n = 3;
                    this.o = 3;
                    numArr[0] = 1;
                    numArr[1] = 1;
                    numArr[2] = 1;
                    numArr[3] = 1;
                    numArr[4] = 1;
                    numArr[5] = 1;
                    numArr[6] = 1;
                    numArr[7] = 1;
                    numArr[8] = 1;
                    break;
                }
            case 10:
                if (z) {
                    this.n = 4;
                    this.o = 3;
                    numArr[0] = 2;
                    numArr[1] = 2;
                    numArr[2] = 1;
                    numArr[3] = 1;
                    numArr[4] = 1;
                    numArr[5] = 1;
                    numArr[6] = 1;
                    numArr[7] = 1;
                    numArr[8] = 1;
                    numArr[9] = 1;
                    break;
                } else {
                    this.n = 4;
                    this.o = 3;
                    numArr[0] = 3;
                    numArr[1] = 1;
                    numArr[2] = 1;
                    numArr[3] = 1;
                    numArr[4] = 1;
                    numArr[5] = 1;
                    numArr[6] = 1;
                    numArr[7] = 1;
                    numArr[8] = 1;
                    numArr[9] = 1;
                    break;
                }
            default:
                throw new IllegalArgumentException("The number of documents must be 10 or less. Current number is " + this.f);
        }
        this.m = z ? this.n : this.o;
        if (z) {
            iT = i();
            iJ = s();
        } else {
            iT = t();
            iJ = j();
        }
        this.j = m(iT, iJ);
        this.l = n(this.g, this.h, this.f);
    }

    private final int i() {
        int i = 0;
        int iIntValue = 0;
        for (Object obj : AbstractC10242bK.L0(this.k)) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            iIntValue += ((Number) obj).intValue();
            if (iIntValue == this.n) {
                return AbstractC10242bK.l0(this.k) - i;
            }
            i = i2;
        }
        throw new IllegalStateException();
    }

    private final int j() {
        int i = 0;
        int iIntValue = 0;
        for (Object obj : AbstractC10242bK.L0(this.k)) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            iIntValue += ((Number) obj).intValue();
            if (iIntValue == this.o) {
                return AbstractC10242bK.l0(this.k) - i;
            }
            i = i2;
        }
        throw new IllegalStateException();
    }

    private final Integer[] m(int i, int i2) {
        boolean zG = JF5.g();
        int i3 = this.f;
        Integer[] numArr = new Integer[i3];
        int i4 = 0;
        while (i4 < i3) {
            numArr[i4] = Integer.valueOf(C13746gl.a.c(zG, i4 == 0, i4 == i, i4 == i2, i4 == this.f - 1));
            i4++;
        }
        return numArr;
    }

    private final XV4[] n(int i, int i2, int i3) {
        XV4[] xv4Arr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = this.o;
        int i11 = this.i;
        int i12 = i - (i10 * i11);
        int i13 = i2 - (this.n * i11);
        int iC = AbstractC20723sV3.c(i12 / i10);
        int iC2 = AbstractC20723sV3.c(i13 / this.n);
        if (this.e == 0) {
            xv4Arr = new XV4[i3];
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i14 < i3) {
                int iF = f(i14);
                int i17 = i15 + iF;
                if (i17 == this.n) {
                    i8 = i13 - i16;
                    i7 = 0;
                    i9 = 0;
                } else {
                    int i18 = iC2 * iF;
                    int i19 = i16 + i18;
                    i7 = i17;
                    i8 = i18;
                    i9 = i19;
                }
                int i20 = i8 + ((iF - 1) * this.i);
                int i21 = i14 + 1;
                int i22 = this.o;
                xv4Arr[i14] = AbstractC4616Fw7.a(Integer.valueOf(i21 % i22 == 0 ? i12 - ((i22 - 1) * iC) : iC), Integer.valueOf(i20));
                i15 = i7;
                i14 = i21;
                i16 = i9;
            }
        } else {
            xv4Arr = new XV4[i3];
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i23 < i3) {
                int iF2 = f(i23);
                int i26 = i24 + iF2;
                if (i26 == this.o) {
                    i5 = i12 - i25;
                    i4 = 0;
                    i6 = 0;
                } else {
                    int i27 = iC * iF2;
                    int i28 = i25 + i27;
                    i4 = i26;
                    i5 = i27;
                    i6 = i28;
                }
                int i29 = i5 + ((iF2 - 1) * this.i);
                int i30 = i23 + 1;
                int i31 = this.n;
                xv4Arr[i23] = AbstractC4616Fw7.a(Integer.valueOf(i29), Integer.valueOf(i30 % i31 == 0 ? i13 - ((i31 - 1) * iC2) : iC2));
                i24 = i4;
                i23 = i30;
                i25 = i6;
            }
        }
        return xv4Arr;
    }

    private final int s() {
        Integer[] numArr = this.k;
        int length = numArr.length;
        int i = 0;
        int i2 = 0;
        int iIntValue = 0;
        while (i < length) {
            int i3 = i2 + 1;
            iIntValue += numArr[i].intValue();
            if (iIntValue == this.n) {
                return i2;
            }
            i++;
            i2 = i3;
        }
        throw new IllegalStateException();
    }

    private final int t() {
        Integer[] numArr = this.k;
        int length = numArr.length;
        int i = 0;
        int i2 = 0;
        int iIntValue = 0;
        while (i < length) {
            int i3 = i2 + 1;
            iIntValue += numArr[i].intValue();
            if (iIntValue == this.o) {
                return i2;
            }
            i++;
            i2 = i3;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.b
    public int f(int i) {
        return this.k[i].intValue();
    }

    public final int k(int i) {
        return this.j[i].intValue();
    }

    public final XV4 l(int i) {
        return this.l[i];
    }

    public final int o() {
        return this.h;
    }

    public final int p() {
        return this.g;
    }

    public final int q() {
        return this.e;
    }

    public final int r() {
        return this.m;
    }
}
