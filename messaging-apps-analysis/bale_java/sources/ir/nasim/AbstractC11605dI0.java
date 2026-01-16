package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.dI0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11605dI0 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[PHI: r8 r16
      0x0033: PHI (r8v39 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0033: PHI (r16v6 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[PHI: r8 r16
      0x0035: PHI (r8v3 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r16v3 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x03a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x016a  */
    /* JADX WARN: Type inference failed for: r1v40, types: [ir.nasim.le1] */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [ir.nasim.le1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a(ir.nasim.C17242me1 r37, ir.nasim.C8963Xz3 r38, int r39, int r40, ir.nasim.C12248eI0 r41) {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11605dI0.a(ir.nasim.me1, ir.nasim.Xz3, int, int, ir.nasim.eI0):void");
    }

    public static void b(C17242me1 c17242me1, C8963Xz3 c8963Xz3, ArrayList arrayList, int i) {
        int i2;
        C12248eI0[] c12248eI0Arr;
        int i3;
        if (i == 0) {
            i2 = c17242me1.g1;
            c12248eI0Arr = c17242me1.j1;
            i3 = 0;
        } else {
            i2 = c17242me1.h1;
            c12248eI0Arr = c17242me1.i1;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            C12248eI0 c12248eI0 = c12248eI0Arr[i4];
            c12248eI0.a();
            if (arrayList == null || arrayList.contains(c12248eI0.a)) {
                a(c17242me1, c8963Xz3, i, i3, c12248eI0);
            }
        }
    }
}
