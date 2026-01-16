package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenTypes;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: classes3.dex */
public final class AJ1 {
    private static final int[] g = {3808, 476, TokenTypes.REASON, 1799};
    private final C4705Gf0 a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    static final class a {
        private final int a;
        private final int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }

        C12092e16 c() {
            return new C12092e16(a(), b());
        }

        public String toString() {
            return Separators.LESS_THAN + this.a + ' ' + this.b + '>';
        }
    }

    public AJ1(C4705Gf0 c4705Gf0) {
        this.a = c4705Gf0;
    }

    private static float b(a aVar, a aVar2) {
        return AbstractC23186wV3.b(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static float c(C12092e16 c12092e16, C12092e16 c12092e162) {
        return AbstractC23186wV3.a(c12092e16.c(), c12092e16.d(), c12092e162.c(), c12092e162.d());
    }

    private static C12092e16[] d(C12092e16[] c12092e16Arr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float fC = c12092e16Arr[0].c() - c12092e16Arr[2].c();
        float fD = c12092e16Arr[0].d() - c12092e16Arr[2].d();
        float fC2 = (c12092e16Arr[0].c() + c12092e16Arr[2].c()) / 2.0f;
        float fD2 = (c12092e16Arr[0].d() + c12092e16Arr[2].d()) / 2.0f;
        float f2 = fC * f;
        float f3 = fD * f;
        C12092e16 c12092e16 = new C12092e16(fC2 + f2, fD2 + f3);
        C12092e16 c12092e162 = new C12092e16(fC2 - f2, fD2 - f3);
        float fC3 = c12092e16Arr[1].c() - c12092e16Arr[3].c();
        float fD3 = c12092e16Arr[1].d() - c12092e16Arr[3].d();
        float fC4 = (c12092e16Arr[1].c() + c12092e16Arr[3].c()) / 2.0f;
        float fD4 = (c12092e16Arr[1].d() + c12092e16Arr[3].d()) / 2.0f;
        float f4 = fC3 * f;
        float f5 = f * fD3;
        return new C12092e16[]{c12092e16, new C12092e16(fC4 + f4, fD4 + f5), c12092e162, new C12092e16(fC4 - f4, fD4 - f5)};
    }

    private void e(C12092e16[] c12092e16Arr) throws NotFoundException {
        long j;
        long j2;
        if (!o(c12092e16Arr[0]) || !o(c12092e16Arr[1]) || !o(c12092e16Arr[2]) || !o(c12092e16Arr[3])) {
            throw NotFoundException.a();
        }
        int i = this.e * 2;
        int[] iArr = {r(c12092e16Arr[0], c12092e16Arr[1], i), r(c12092e16Arr[1], c12092e16Arr[2], i), r(c12092e16Arr[2], c12092e16Arr[3], i), r(c12092e16Arr[3], c12092e16Arr[0], i)};
        this.f = m(iArr, i);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.f + i2) % 4];
            if (this.b) {
                j = j3 << 7;
                j2 = (i3 >> 1) & 127;
            } else {
                j = j3 << 10;
                j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
            }
            j3 = j + j2;
        }
        int iH = h(j3, this.b);
        if (this.b) {
            this.c = (iH >> 6) + 1;
            this.d = (iH & 63) + 1;
        } else {
            this.c = (iH >> 11) + 1;
            this.d = (iH & 2047) + 1;
        }
    }

    private C12092e16[] f(a aVar) throws NotFoundException {
        this.e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        boolean z = true;
        while (this.e < 9) {
            a aVarJ = j(aVar, z, 1, -1);
            a aVarJ2 = j(aVar2, z, 1, 1);
            a aVarJ3 = j(aVar3, z, -1, 1);
            a aVarJ4 = j(aVar4, z, -1, -1);
            if (this.e > 2) {
                double dB = (b(aVarJ4, aVarJ) * this.e) / (b(aVar4, aVar) * (this.e + 2));
                if (dB < 0.75d || dB > 1.25d || !p(aVarJ, aVarJ2, aVarJ3, aVarJ4)) {
                    break;
                }
            }
            z = !z;
            this.e++;
            aVar4 = aVarJ4;
            aVar = aVarJ;
            aVar2 = aVarJ2;
            aVar3 = aVarJ3;
        }
        int i = this.e;
        if (i != 5 && i != 7) {
            throw NotFoundException.a();
        }
        this.b = i == 5;
        return d(new C12092e16[]{new C12092e16(aVar.a() + 0.5f, aVar.b() - 0.5f), new C12092e16(aVar2.a() + 0.5f, aVar2.b() + 0.5f), new C12092e16(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new C12092e16(aVar4.a() - 0.5f, aVar4.b() - 0.5f)}, (r0 * 2) - 3, this.e * 2);
    }

    private int g(a aVar, a aVar2) {
        float fB = b(aVar, aVar2);
        float fA = (aVar2.a() - aVar.a()) / fB;
        float fB2 = (aVar2.b() - aVar.b()) / fB;
        float fA2 = aVar.a();
        float fB3 = aVar.b();
        boolean zE = this.a.e(aVar.a(), aVar.b());
        int iCeil = (int) Math.ceil(fB);
        int i = 0;
        for (int i2 = 0; i2 < iCeil; i2++) {
            fA2 += fA;
            fB3 += fB2;
            if (this.a.e(AbstractC23186wV3.c(fA2), AbstractC23186wV3.c(fB3)) != zE) {
                i++;
            }
        }
        float f = i / fB;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == zE ? 1 : -1;
        }
        return 0;
    }

    private static int h(long j, boolean z) throws NotFoundException {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new YK5(UE2.k).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.a();
        }
    }

    private int i() {
        if (this.b) {
            return (this.c * 4) + 11;
        }
        int i = this.c;
        return i <= 4 ? (i * 4) + 15 : (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }

    private a j(a aVar, boolean z, int i, int i2) {
        int iA = aVar.a() + i;
        int iB = aVar.b();
        while (true) {
            iB += i2;
            if (!n(iA, iB) || this.a.e(iA, iB) != z) {
                break;
            }
            iA += i;
        }
        int i3 = iA - i;
        int i4 = iB - i2;
        while (n(i3, i4) && this.a.e(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (n(i5, i4) && this.a.e(i5, i4) == z) {
            i4 += i2;
        }
        return new a(i5, i4 - i2);
    }

    private a k() {
        C12092e16 c12092e16C;
        C12092e16 c12092e16;
        C12092e16 c12092e162;
        C12092e16 c12092e163;
        C12092e16 c12092e16C2;
        C12092e16 c12092e16C3;
        C12092e16 c12092e16C4;
        C12092e16 c12092e16C5;
        try {
            C12092e16[] c12092e16ArrC = new C11531d98(this.a).c();
            c12092e162 = c12092e16ArrC[0];
            c12092e163 = c12092e16ArrC[1];
            c12092e16 = c12092e16ArrC[2];
            c12092e16C = c12092e16ArrC[3];
        } catch (NotFoundException unused) {
            int iM = this.a.m() / 2;
            int i = this.a.i() / 2;
            int i2 = iM + 7;
            int i3 = i - 7;
            C12092e16 c12092e16C6 = j(new a(i2, i3), false, 1, -1).c();
            int i4 = i + 7;
            C12092e16 c12092e16C7 = j(new a(i2, i4), false, 1, 1).c();
            int i5 = iM - 7;
            C12092e16 c12092e16C8 = j(new a(i5, i4), false, -1, 1).c();
            c12092e16C = j(new a(i5, i3), false, -1, -1).c();
            c12092e16 = c12092e16C8;
            c12092e162 = c12092e16C6;
            c12092e163 = c12092e16C7;
        }
        int iC = AbstractC23186wV3.c((((c12092e162.c() + c12092e16C.c()) + c12092e163.c()) + c12092e16.c()) / 4.0f);
        int iC2 = AbstractC23186wV3.c((((c12092e162.d() + c12092e16C.d()) + c12092e163.d()) + c12092e16.d()) / 4.0f);
        try {
            C12092e16[] c12092e16ArrC2 = new C11531d98(this.a, 15, iC, iC2).c();
            c12092e16C2 = c12092e16ArrC2[0];
            c12092e16C3 = c12092e16ArrC2[1];
            c12092e16C4 = c12092e16ArrC2[2];
            c12092e16C5 = c12092e16ArrC2[3];
        } catch (NotFoundException unused2) {
            int i6 = iC + 7;
            int i7 = iC2 - 7;
            c12092e16C2 = j(new a(i6, i7), false, 1, -1).c();
            int i8 = iC2 + 7;
            c12092e16C3 = j(new a(i6, i8), false, 1, 1).c();
            int i9 = iC - 7;
            c12092e16C4 = j(new a(i9, i8), false, -1, 1).c();
            c12092e16C5 = j(new a(i9, i7), false, -1, -1).c();
        }
        return new a(AbstractC23186wV3.c((((c12092e16C2.c() + c12092e16C5.c()) + c12092e16C3.c()) + c12092e16C4.c()) / 4.0f), AbstractC23186wV3.c((((c12092e16C2.d() + c12092e16C5.d()) + c12092e16C3.d()) + c12092e16C4.d()) / 4.0f));
    }

    private C12092e16[] l(C12092e16[] c12092e16Arr) {
        return d(c12092e16Arr, this.e * 2, i());
    }

    private static int m(int[] iArr, int i) throws NotFoundException {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw NotFoundException.a();
    }

    private boolean n(int i, int i2) {
        return i >= 0 && i < this.a.m() && i2 > 0 && i2 < this.a.i();
    }

    private boolean o(C12092e16 c12092e16) {
        return n(AbstractC23186wV3.c(c12092e16.c()), AbstractC23186wV3.c(c12092e16.d()));
    }

    private boolean p(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int iG = g(aVar8, aVar5);
        return iG != 0 && g(aVar5, aVar6) == iG && g(aVar6, aVar7) == iG && g(aVar7, aVar8) == iG;
    }

    private C4705Gf0 q(C4705Gf0 c4705Gf0, C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, C12092e16 c12092e164) {
        AbstractC12277eL2 abstractC12277eL2B = AbstractC12277eL2.b();
        int i = i();
        float f = i / 2.0f;
        int i2 = this.e;
        float f2 = f - i2;
        float f3 = f + i2;
        return abstractC12277eL2B.c(c4705Gf0, i, i, f2, f2, f3, f2, f3, f3, f2, f3, c12092e16.c(), c12092e16.d(), c12092e162.c(), c12092e162.d(), c12092e163.c(), c12092e163.d(), c12092e164.c(), c12092e164.d());
    }

    private int r(C12092e16 c12092e16, C12092e16 c12092e162, int i) {
        float fC = c(c12092e16, c12092e162);
        float f = fC / i;
        float fC2 = c12092e16.c();
        float fD = c12092e16.d();
        float fC3 = ((c12092e162.c() - c12092e16.c()) * f) / fC;
        float fD2 = (f * (c12092e162.d() - c12092e16.d())) / fC;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.a.e(AbstractC23186wV3.c((f2 * fC3) + fC2), AbstractC23186wV3.c((f2 * fD2) + fD))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    public FV a(boolean z) throws NotFoundException {
        C12092e16[] c12092e16ArrF = f(k());
        if (z) {
            C12092e16 c12092e16 = c12092e16ArrF[0];
            c12092e16ArrF[0] = c12092e16ArrF[2];
            c12092e16ArrF[2] = c12092e16;
        }
        e(c12092e16ArrF);
        C4705Gf0 c4705Gf0 = this.a;
        int i = this.f;
        return new FV(q(c4705Gf0, c12092e16ArrF[i % 4], c12092e16ArrF[(i + 1) % 4], c12092e16ArrF[(i + 2) % 4], c12092e16ArrF[(i + 3) % 4]), l(c12092e16ArrF), this.b, this.d, this.c);
    }
}
