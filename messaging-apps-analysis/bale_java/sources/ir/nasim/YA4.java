package ir.nasim;

import androidx.compose.ui.e;

/* loaded from: classes2.dex */
public abstract class YA4 {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(ir.nasim.C3348Am4 r14, java.util.Map r15) {
        /*
            r0 = 0
            if (r14 != 0) goto L4
            return r0
        L4:
            int r1 = r14.f()
            int r2 = r15.size()
            if (r1 == r2) goto Lf
            return r0
        Lf:
            java.lang.Object[] r1 = r14.b
            int[] r2 = r14.c
            long[] r14 = r14.a
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L64
            r4 = r0
        L1b:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L5f
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r0
        L35:
            if (r9 >= r7) goto L5d
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L59
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r1[r10]
            r10 = r2[r10]
            ir.nasim.fm r11 = (ir.nasim.AbstractC13165fm) r11
            java.lang.Object r11 = r15.get(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L52
            goto L58
        L52:
            int r11 = r11.intValue()
            if (r11 == r10) goto L59
        L58:
            return r0
        L59:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L35
        L5d:
            if (r7 != r8) goto L64
        L5f:
            if (r4 == r3) goto L64
            int r4 = r4 + 1
            goto L1b
        L64:
            r14 = 1
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YA4.c(ir.nasim.Am4, java.util.Map):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e.c d(JG1 jg1, int i, int i2) {
        e.c cVarS1 = jg1.h().S1();
        if (cVarS1 == null || (cVarS1.R1() & i) == 0) {
            return null;
        }
        while (cVarS1 != null) {
            int iW1 = cVarS1.W1();
            if ((iW1 & i2) != 0) {
                return null;
            }
            if ((iW1 & i) != 0) {
                return cVarS1;
            }
            cVarS1 = cVarS1.S1();
        }
        return null;
    }
}
