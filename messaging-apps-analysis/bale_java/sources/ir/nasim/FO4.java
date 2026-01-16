package ir.nasim;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class FO4 {
    private static final W92 a = new W92();

    private static C3326Ak0 a(C24850zJ1 c24850zJ1) {
        int[] iArrJ;
        if (c24850zJ1 == null || (iArrJ = c24850zJ1.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i = 0;
        int i2 = 0;
        for (int i3 : iArrJ) {
            i2 += iP - i3;
            if (i3 > 0) {
                break;
            }
        }
        IW0[] iw0ArrD = c24850zJ1.d();
        for (int i4 = 0; i2 > 0 && iw0ArrD[i4] == null; i4++) {
            i2--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i5 = iArrJ[length];
            i += iP - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = iw0ArrD.length - 1; i > 0 && iw0ArrD[length2] == null; length2--) {
            i--;
        }
        return c24850zJ1.a().a(i2, i, c24850zJ1.k());
    }

    private static void b(C23666xJ1 c23666xJ1, C10759c90[][] c10759c90Arr) throws NotFoundException {
        C10759c90 c10759c90 = c10759c90Arr[0][1];
        int[] iArrA = c10759c90.a();
        int iJ = (c23666xJ1.j() * c23666xJ1.l()) - r(c23666xJ1.k());
        if (iArrA.length != 0) {
            if (iArrA[0] != iJ) {
                c10759c90.b(iJ);
            }
        } else {
            if (iJ <= 0 || iJ > 928) {
                throw NotFoundException.a();
            }
            c10759c90.b(iJ);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int c(ir.nasim.C4705Gf0 r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.e(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FO4.c(ir.nasim.Gf0, int, int, boolean, int, int):int");
    }

    private static boolean d(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return a.a(iArr, i, iArr2);
        }
        throw ChecksumException.a();
    }

    private static C10759c90[][] f(C23666xJ1 c23666xJ1) {
        int iC;
        C10759c90[][] c10759c90Arr = (C10759c90[][]) Array.newInstance((Class<?>) C10759c90.class, c23666xJ1.l(), c23666xJ1.j() + 2);
        for (C10759c90[] c10759c90Arr2 : c10759c90Arr) {
            int i = 0;
            while (true) {
                if (i < c10759c90Arr2.length) {
                    c10759c90Arr2[i] = new C10759c90();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (C24256yJ1 c24256yJ1 : c23666xJ1.o()) {
            if (c24256yJ1 != null) {
                for (IW0 iw0 : c24256yJ1.d()) {
                    if (iw0 != null && (iC = iw0.c()) >= 0 && iC < c10759c90Arr.length) {
                        c10759c90Arr[iC][i2].b(iw0.e());
                    }
                }
            }
            i2++;
        }
        return c10759c90Arr;
    }

    private static LB1 g(C23666xJ1 c23666xJ1) throws NotFoundException {
        C10759c90[][] c10759c90ArrF = f(c23666xJ1);
        b(c23666xJ1, c10759c90ArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[c23666xJ1.l() * c23666xJ1.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < c23666xJ1.l(); i++) {
            int i2 = 0;
            while (i2 < c23666xJ1.j()) {
                int i3 = i2 + 1;
                int[] iArrA = c10759c90ArrF[i][i3].a();
                int iJ = (c23666xJ1.j() * i) + i2;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrA.length == 1) {
                    iArr[iJ] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrA);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return h(c23666xJ1.k(), iArr, BO4.b(arrayList), BO4.b(arrayList3), iArr2);
    }

    private static LB1 h(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw ChecksumException.a();
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return j(iArr, i, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.a();
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = iArr5[i5];
                    if (i6 < iArr4[i5].length - 1) {
                        iArr5[i5] = i6 + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == length - 1) {
                        throw ChecksumException.a();
                    }
                    i5++;
                }
                i2 = i3;
            }
        }
    }

    public static LB1 i(C4705Gf0 c4705Gf0, C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, C12092e16 c12092e164, int i, int i2) throws NotFoundException {
        int i3;
        int i4;
        int i5;
        int i6;
        C24850zJ1 c24850zJ1S = null;
        C24850zJ1 c24850zJ1S2 = null;
        C23666xJ1 c23666xJ1V = null;
        C3326Ak0 c3326Ak0 = new C3326Ak0(c4705Gf0, c12092e16, c12092e162, c12092e163, c12092e164);
        for (int i7 = 0; i7 < 2; i7++) {
            if (c12092e16 != null) {
                c24850zJ1S = s(c4705Gf0, c3326Ak0, c12092e16, true, i, i2);
            }
            if (c12092e163 != null) {
                c24850zJ1S2 = s(c4705Gf0, c3326Ak0, c12092e163, false, i, i2);
            }
            c23666xJ1V = v(c24850zJ1S, c24850zJ1S2);
            if (c23666xJ1V == null) {
                throw NotFoundException.a();
            }
            if (i7 != 0 || c23666xJ1V.m() == null || (c23666xJ1V.m().g() >= c3326Ak0.g() && c23666xJ1V.m().e() <= c3326Ak0.e())) {
                c23666xJ1V.p(c3326Ak0);
                break;
            }
            c3326Ak0 = c23666xJ1V.m();
        }
        int iJ = c23666xJ1V.j() + 1;
        c23666xJ1V.q(0, c24850zJ1S);
        c23666xJ1V.q(iJ, c24850zJ1S2);
        boolean z = c24850zJ1S != null;
        int iMin = i;
        int iMax = i2;
        for (int i8 = 1; i8 <= iJ; i8++) {
            int i9 = z ? i8 : iJ - i8;
            if (c23666xJ1V.n(i9) == null) {
                C24256yJ1 c24850zJ1 = (i9 == 0 || i9 == iJ) ? new C24850zJ1(c3326Ak0, i9 == 0) : new C24256yJ1(c3326Ak0);
                c23666xJ1V.q(i9, c24850zJ1);
                int i10 = -1;
                int iG = c3326Ak0.g();
                int i11 = -1;
                while (iG <= c3326Ak0.e()) {
                    int iT = t(c23666xJ1V, i9, iG, z);
                    if (iT >= 0 && iT <= c3326Ak0.d()) {
                        i6 = iT;
                    } else if (i11 != i10) {
                        i6 = i11;
                    } else {
                        i3 = i11;
                        i4 = iG;
                        i5 = i10;
                        i11 = i3;
                        iG = i4 + 1;
                        i10 = i5;
                    }
                    i3 = i11;
                    int i12 = iG;
                    i5 = i10;
                    IW0 iw0K = k(c4705Gf0, c3326Ak0.f(), c3326Ak0.d(), z, i6, i12, iMin, iMax);
                    i4 = i12;
                    if (iw0K != null) {
                        c24850zJ1.f(i4, iw0K);
                        iMin = Math.min(iMin, iw0K.f());
                        iMax = Math.max(iMax, iw0K.f());
                        i11 = i6;
                    } else {
                        i11 = i3;
                    }
                    iG = i4 + 1;
                    i10 = i5;
                }
            }
        }
        return g(c23666xJ1V);
    }

    private static LB1 j(int[] iArr, int i, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length == 0) {
            throw FormatException.a();
        }
        int i2 = 1 << (i + 1);
        int iE = e(iArr, iArr2, i2);
        w(iArr, i2);
        LB1 lb1B = AbstractC23004wB1.b(iArr, String.valueOf(i));
        lb1B.k(Integer.valueOf(iE));
        lb1B.j(Integer.valueOf(iArr2.length));
        return lb1B;
    }

    private static IW0 k(C4705Gf0 c4705Gf0, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iD;
        int iA;
        int iC = c(c4705Gf0, i, i2, z, i3, i4);
        int[] iArrQ = q(c4705Gf0, i, i2, z, iC, i4);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = AbstractC23186wV3.d(iArrQ);
        if (z) {
            i7 = iC + iD2;
        } else {
            for (int i8 = 0; i8 < iArrQ.length / 2; i8++) {
                int i9 = iArrQ[i8];
                iArrQ[i8] = iArrQ[(iArrQ.length - 1) - i8];
                iArrQ[(iArrQ.length - 1) - i8] = i9;
            }
            iC -= iD2;
            i7 = iC;
        }
        if (d(iD2, i5, i6) && (iA = BO4.a((iD = AO4.d(iArrQ)))) != -1) {
            return new IW0(iC, i7, n(iD), iA);
        }
        return null;
    }

    private static C10143b90 l(C24850zJ1 c24850zJ1, C24850zJ1 c24850zJ12) {
        C10143b90 c10143b90I;
        C10143b90 c10143b90I2;
        if (c24850zJ1 == null || (c10143b90I = c24850zJ1.i()) == null) {
            if (c24850zJ12 == null) {
                return null;
            }
            return c24850zJ12.i();
        }
        if (c24850zJ12 == null || (c10143b90I2 = c24850zJ12.i()) == null || c10143b90I.a() == c10143b90I2.a() || c10143b90I.b() == c10143b90I2.b() || c10143b90I.c() == c10143b90I2.c()) {
            return c10143b90I;
        }
        return null;
    }

    private static int[] m(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int n(int i) {
        return o(m(i));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[] q(ir.nasim.C4705Gf0 r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = r2
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.e(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FO4.q(ir.nasim.Gf0, int, int, boolean, int, int):int[]");
    }

    private static int r(int i) {
        return 2 << i;
    }

    private static C24850zJ1 s(C4705Gf0 c4705Gf0, C3326Ak0 c3326Ak0, C12092e16 c12092e16, boolean z, int i, int i2) {
        C24850zJ1 c24850zJ1 = new C24850zJ1(c3326Ak0, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int iC = (int) c12092e16.c();
            for (int iD = (int) c12092e16.d(); iD <= c3326Ak0.e() && iD >= c3326Ak0.g(); iD += i4) {
                IW0 iw0K = k(c4705Gf0, 0, c4705Gf0.m(), z, iC, iD, i, i2);
                if (iw0K != null) {
                    c24850zJ1.f(iD, iw0K);
                    iC = z ? iw0K.d() : iw0K.b();
                }
            }
            i3++;
        }
        return c24850zJ1;
    }

    private static int t(C23666xJ1 c23666xJ1, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        IW0 iw0B = u(c23666xJ1, i4) ? c23666xJ1.n(i4).b(i2) : null;
        if (iw0B != null) {
            return z ? iw0B.b() : iw0B.d();
        }
        IW0 iw0C = c23666xJ1.n(i).c(i2);
        if (iw0C != null) {
            return z ? iw0C.d() : iw0C.b();
        }
        if (u(c23666xJ1, i4)) {
            iw0C = c23666xJ1.n(i4).c(i2);
        }
        if (iw0C != null) {
            return z ? iw0C.b() : iw0C.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!u(c23666xJ1, i)) {
                C3326Ak0 c3326Ak0M = c23666xJ1.m();
                return z ? c3326Ak0M.f() : c3326Ak0M.d();
            }
            for (IW0 iw0 : c23666xJ1.n(i).d()) {
                if (iw0 != null) {
                    return (z ? iw0.b() : iw0.d()) + (i3 * i5 * (iw0.b() - iw0.d()));
                }
            }
            i5++;
        }
    }

    private static boolean u(C23666xJ1 c23666xJ1, int i) {
        return i >= 0 && i <= c23666xJ1.j() + 1;
    }

    private static C23666xJ1 v(C24850zJ1 c24850zJ1, C24850zJ1 c24850zJ12) {
        C10143b90 c10143b90L;
        if ((c24850zJ1 == null && c24850zJ12 == null) || (c10143b90L = l(c24850zJ1, c24850zJ12)) == null) {
            return null;
        }
        return new C23666xJ1(c10143b90L, C3326Ak0.j(a(c24850zJ1), a(c24850zJ12)));
    }

    private static void w(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.a();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.a();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw FormatException.a();
            }
            iArr[0] = iArr.length - i;
        }
    }
}
