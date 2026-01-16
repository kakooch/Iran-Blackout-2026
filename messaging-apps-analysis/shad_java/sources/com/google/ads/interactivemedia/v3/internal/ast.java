package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ast {
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
    
        if (r10 != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a(long r10, java.math.RoundingMode r12) {
        /*
            com.google.ads.interactivemedia.v3.internal.aqd.j(r12)
            r0 = 1000(0x3e8, double:4.94E-321)
            long r2 = r10 / r0
            long r4 = r2 * r0
            long r4 = r10 - r4
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L12
            return r2
        L12:
            long r10 = r10 ^ r0
            r8 = 63
            long r10 = r10 >> r8
            int r11 = (int) r10
            r10 = 1
            r11 = r11 | r10
            int[] r8 = com.google.ads.interactivemedia.v3.internal.ass.a
            int r9 = r12.ordinal()
            r8 = r8[r9]
            r9 = 0
            switch(r8) {
                case 1: goto L64;
                case 2: goto L68;
                case 3: goto L5b;
                case 4: goto L61;
                case 5: goto L58;
                case 6: goto L2b;
                case 7: goto L2b;
                case 8: goto L2b;
                default: goto L25;
            }
        L25:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L2b:
            long r4 = java.lang.Math.abs(r4)
            long r0 = java.lang.Math.abs(r0)
            long r0 = r0 - r4
            long r4 = r4 - r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L53
            java.math.RoundingMode r0 = java.math.RoundingMode.HALF_UP
            if (r12 != r0) goto L3f
            r0 = 1
            goto L40
        L3f:
            r0 = 0
        L40:
            java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r1) goto L46
            r12 = 1
            goto L47
        L46:
            r12 = 0
        L47:
            r4 = 1
            long r4 = r4 & r2
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L4f
            goto L50
        L4f:
            r10 = 0
        L50:
            r10 = r10 & r12
            r10 = r10 | r0
            goto L5f
        L53:
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 <= 0) goto L5e
            goto L5f
        L58:
            if (r11 <= 0) goto L5e
            goto L5f
        L5b:
            if (r11 >= 0) goto L5e
            goto L5f
        L5e:
            r10 = 0
        L5f:
            if (r10 == 0) goto L68
        L61:
            long r10 = (long) r11
            long r2 = r2 + r10
            return r2
        L64:
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 != 0) goto L69
        L68:
            return r2
        L69:
            java.lang.ArithmeticException r10 = new java.lang.ArithmeticException
            java.lang.String r11 = "mode was UNNECESSARY, but rounding was necessary"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ast.a(long, java.math.RoundingMode):long");
    }
}
