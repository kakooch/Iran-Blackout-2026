package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.ic, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2612ic {
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.appmetrica.analytics.impl.C2895u9 a(io.appmetrica.analytics.impl.C2612ic r5, io.appmetrica.analytics.impl.D9 r6, java.util.Map r7) {
        /*
            r5.getClass()
            io.appmetrica.analytics.impl.u9 r5 = new io.appmetrica.analytics.impl.u9
            r5.<init>()
            int r6 = r6.ordinal()
            switch(r6) {
                case 0: goto L21;
                case 1: goto L1f;
                case 2: goto L1d;
                case 3: goto L1b;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                default: goto Lf;
            }
        Lf:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L15:
            r6 = 6
            goto L22
        L17:
            r6 = 5
            goto L22
        L19:
            r6 = 4
            goto L22
        L1b:
            r6 = 3
            goto L22
        L1d:
            r6 = 2
            goto L22
        L1f:
            r6 = 1
            goto L22
        L21:
            r6 = 0
        L22:
            r5.a = r6
            io.appmetrica.analytics.impl.ic r6 = io.appmetrica.analytics.impl.C2635jc.b
            r6.getClass()
            java.util.Set r6 = r7.entrySet()
            r7 = 10
            int r7 = ir.nasim.ZW0.x(r6, r7)
            int r7 = ir.nasim.AbstractC18278oO3.f(r7)
            r0 = 16
            int r7 = ir.nasim.AbstractC21867uG5.e(r7, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>(r7)
            java.util.Iterator r6 = r6.iterator()
        L46:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L95
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r1 = r7.getKey()
            java.lang.Object r2 = r7.getValue()
            boolean r2 = r2 instanceof java.lang.Number
            if (r2 == 0) goto L81
            java.lang.Object r2 = r7.getValue()
            if (r2 == 0) goto L79
            java.lang.Number r2 = (java.lang.Number) r2
            double r2 = r2.doubleValue()
            boolean r4 = java.lang.Double.isInfinite(r2)
            if (r4 != 0) goto L77
            boolean r2 = java.lang.Double.isNaN(r2)
            if (r2 != 0) goto L77
            goto L81
        L77:
            r7 = 0
            goto L85
        L79:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Number"
            r5.<init>(r6)
            throw r5
        L81:
            java.lang.Object r7 = r7.getValue()
        L85:
            ir.nasim.XV4 r7 = ir.nasim.AbstractC4616Fw7.a(r1, r7)
            java.lang.Object r1 = r7.e()
            java.lang.Object r7 = r7.f()
            r0.put(r1, r7)
            goto L46
        L95:
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>(r0)
            java.lang.String r6 = r6.toString()
            if (r6 == 0) goto La8
            java.nio.charset.Charset r7 = ir.nasim.C12275eL0.b
            byte[] r6 = r6.getBytes(r7)
            r5.b = r6
        La8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.C2612ic.a(io.appmetrica.analytics.impl.ic, io.appmetrica.analytics.impl.D9, java.util.Map):io.appmetrica.analytics.impl.u9");
    }
}
