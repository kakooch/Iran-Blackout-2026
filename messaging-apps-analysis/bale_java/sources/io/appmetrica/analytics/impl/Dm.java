package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public abstract class Dm {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static io.appmetrica.analytics.impl.Cm a(java.lang.Throwable r9, int r10, int r11) {
        /*
            java.lang.Class r0 = r9.getClass()
            java.lang.String r2 = r0.getName()
            java.lang.String r3 = r9.getMessage()
            r0 = 0
            java.lang.StackTraceElement[] r1 = r9.getStackTrace()     // Catch: java.lang.Throwable -> L12
            goto L14
        L12:
            java.lang.StackTraceElement[] r1 = new java.lang.StackTraceElement[r0]
        L14:
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r1.length
            r4.<init>(r5)
            int r5 = r1.length
            r6 = r0
        L1c:
            if (r6 >= r5) goto L2b
            r7 = r1[r6]
            io.appmetrica.analytics.impl.Ck r8 = new io.appmetrica.analytics.impl.Ck
            r8.<init>(r7)
            r4.add(r8)
            int r6 = r6 + 1
            goto L1c
        L2b:
            java.lang.Throwable r1 = r9.getCause()
            r5 = 0
            if (r1 == 0) goto L42
            if (r11 >= r10) goto L35
            goto L36
        L35:
            r1 = r5
        L36:
            if (r1 == 0) goto L42
            int r6 = r11 + 1
            r7 = 30
            io.appmetrica.analytics.impl.Cm r1 = a(r1, r7, r6)
            r6 = r1
            goto L43
        L42:
            r6 = r5
        L43:
            if (r11 >= r10) goto L5f
            java.lang.Throwable[] r9 = r9.getSuppressed()
            java.util.ArrayList r10 = new java.util.ArrayList
            int r1 = r9.length
            r10.<init>(r1)
            int r1 = r9.length
        L50:
            if (r0 >= r1) goto L60
            r5 = r9[r0]
            r7 = 1
            io.appmetrica.analytics.impl.Cm r5 = a(r5, r7, r11)
            r10.add(r5)
            int r0 = r0 + 1
            goto L50
        L5f:
            r10 = r5
        L60:
            io.appmetrica.analytics.impl.Cm r9 = new io.appmetrica.analytics.impl.Cm
            r1 = r9
            r5 = r6
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Dm.a(java.lang.Throwable, int, int):io.appmetrica.analytics.impl.Cm");
    }
}
