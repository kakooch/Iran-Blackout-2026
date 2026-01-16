package ir.nasim;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class CJ1 {
    private static final int[] a = {0, 4, 1, 5};
    private static final int[] b = {6, 2, 7, 3};
    private static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static void a(C12092e16[] c12092e16Arr, C12092e16[] c12092e16Arr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            c12092e16Arr[iArr[i]] = c12092e16Arr2[i];
        }
    }

    public static CO4 b(C6338Ne0 c6338Ne0, Map map, boolean z) {
        C4705Gf0 c4705Gf0A = c6338Ne0.a();
        List listC = c(z, c4705Gf0A);
        if (listC.isEmpty()) {
            c4705Gf0A = c4705Gf0A.clone();
            c4705Gf0A.n();
            listC = c(z, c4705Gf0A);
        }
        return new CO4(c4705Gf0A, listC);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r3.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r4 = (ir.nasim.C12092e16[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List c(boolean r8, ir.nasim.C4705Gf0 r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
            r3 = r2
        L8:
            r4 = r3
        L9:
            int r5 = r9.i()
            if (r2 >= r5) goto L77
            ir.nasim.e16[] r3 = f(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L4f
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L4f
            if (r4 == 0) goto L77
            java.util.Iterator r3 = r0.iterator()
        L23:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L4b
            java.lang.Object r4 = r3.next()
            ir.nasim.e16[] r4 = (ir.nasim.C12092e16[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L3d
            float r2 = (float) r2
            float r7 = r7.d()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L3d:
            r4 = r4[r5]
            if (r4 == 0) goto L23
            float r4 = r4.d()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L23
        L4b:
            int r2 = r2 + 5
            r3 = r1
            goto L8
        L4f:
            r0.add(r3)
            if (r8 == 0) goto L77
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L68
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
        L64:
            int r2 = (int) r2
            r3 = r4
            r4 = r6
            goto L9
        L68:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
            goto L64
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CJ1.c(boolean, ir.nasim.Gf0):java.util.List");
    }

    private static int[] d(C4705Gf0 c4705Gf0, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (c4705Gf0.e(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (c4705Gf0.e(i, i2) != z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else {
                    if (g(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i8 = i6 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i6] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || g(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    private static C12092e16[] e(C4705Gf0 c4705Gf0, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int i6;
        C12092e16[] c12092e16Arr = new C12092e16[4];
        int[] iArr2 = new int[iArr.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i) {
                z = false;
                break;
            }
            int[] iArrD = d(c4705Gf0, i4, i7, i2, false, iArr, iArr2);
            if (iArrD != null) {
                int i8 = i7;
                int[] iArr3 = iArrD;
                while (i8 > 0) {
                    int i9 = i8 - 1;
                    int[] iArrD2 = d(c4705Gf0, i4, i9, i2, false, iArr, iArr2);
                    if (iArrD2 == null) {
                        break;
                    }
                    iArr3 = iArrD2;
                    i8 = i9;
                }
                float f = i8;
                c12092e16Arr[0] = new C12092e16(iArr3[0], f);
                c12092e16Arr[1] = new C12092e16(iArr3[1], f);
                z = true;
                i7 = i8;
            } else {
                i7 += 5;
            }
        }
        int i10 = i7 + 1;
        if (z) {
            int[] iArr4 = {(int) c12092e16Arr[0].c(), (int) c12092e16Arr[1].c()};
            int i11 = i10;
            int i12 = 0;
            while (true) {
                if (i11 >= i) {
                    i5 = i12;
                    i6 = i11;
                    break;
                }
                i5 = i12;
                i6 = i11;
                int[] iArrD3 = d(c4705Gf0, iArr4[0], i11, i2, false, iArr, iArr2);
                if (iArrD3 != null && Math.abs(iArr4[0] - iArrD3[0]) < 5 && Math.abs(iArr4[1] - iArrD3[1]) < 5) {
                    iArr4 = iArrD3;
                    i12 = 0;
                } else {
                    if (i5 > 25) {
                        break;
                    }
                    i12 = i5 + 1;
                }
                i11 = i6 + 1;
            }
            i10 = i6 - (i5 + 1);
            float f2 = i10;
            c12092e16Arr[2] = new C12092e16(iArr4[0], f2);
            c12092e16Arr[3] = new C12092e16(iArr4[1], f2);
        }
        if (i10 - i7 < 10) {
            Arrays.fill(c12092e16Arr, (Object) null);
        }
        return c12092e16Arr;
    }

    private static C12092e16[] f(C4705Gf0 c4705Gf0, int i, int i2) {
        int i3 = c4705Gf0.i();
        int iM = c4705Gf0.m();
        C12092e16[] c12092e16Arr = new C12092e16[8];
        a(c12092e16Arr, e(c4705Gf0, i3, iM, i, i2, c), a);
        C12092e16 c12092e16 = c12092e16Arr[4];
        if (c12092e16 != null) {
            i2 = (int) c12092e16.c();
            i = (int) c12092e16Arr[4].d();
        }
        a(c12092e16Arr, e(c4705Gf0, i3, iM, i, i2, d), b);
        return c12092e16Arr;
    }

    private static float g(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
