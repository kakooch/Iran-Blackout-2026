package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aav implements Comparable<aav> {
    public final boolean a;
    private final aaq b;
    private final boolean c;
    private final boolean d;
    private final int e;
    private final int f;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public aav(com.google.ads.interactivemedia.v3.internal.cy r7, com.google.ads.interactivemedia.v3.internal.aaq r8, int r9, boolean r10) {
        /*
            r6 = this;
            r6.<init>()
            r6.b = r8
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1
            r2 = -1
            r3 = 0
            if (r10 == 0) goto L33
            int r4 = r7.q
            if (r4 == r2) goto L14
            int r5 = r8.b
            if (r4 > r5) goto L33
        L14:
            int r4 = r7.r
            if (r4 == r2) goto L1c
            int r5 = r8.c
            if (r4 > r5) goto L33
        L1c:
            float r4 = r7.s
            int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r5 == 0) goto L29
            int r5 = r8.d
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L33
        L29:
            int r4 = r7.h
            if (r4 == r2) goto L31
            int r5 = r8.e
            if (r4 > r5) goto L33
        L31:
            r4 = 1
            goto L34
        L33:
            r4 = 0
        L34:
            r6.a = r4
            if (r10 == 0) goto L5e
            int r10 = r7.q
            if (r10 == r2) goto L40
            int r4 = r8.f
            if (r10 < r4) goto L5e
        L40:
            int r10 = r7.r
            if (r10 == r2) goto L48
            int r4 = r8.g
            if (r10 < r4) goto L5e
        L48:
            float r10 = r7.s
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 == 0) goto L55
            int r0 = r8.h
            float r0 = (float) r0
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L5e
        L55:
            int r10 = r7.h
            if (r10 == r2) goto L5f
            int r8 = r8.i
            if (r10 < r8) goto L5e
            goto L5f
        L5e:
            r1 = 0
        L5f:
            r6.c = r1
            boolean r8 = com.google.ads.interactivemedia.v3.internal.aaw.b(r9, r3)
            r6.d = r8
            int r8 = r7.h
            r6.e = r8
            int r7 = r7.d()
            r6.f = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aav.<init>(com.google.ads.interactivemedia.v3.internal.cy, com.google.ads.interactivemedia.v3.internal.aaq, int, boolean):void");
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(aav aavVar) {
        asc ascVarA = (this.a && this.d) ? aaw.c : aaw.c.a();
        return aqv.g().d(this.d, aavVar.d).d(this.a, aavVar.a).d(this.c, aavVar.c).a(Integer.valueOf(this.e), Integer.valueOf(aavVar.e), this.b.v ? aaw.c.a() : aaw.d).a(Integer.valueOf(this.f), Integer.valueOf(aavVar.f), ascVarA).a(Integer.valueOf(this.e), Integer.valueOf(aavVar.e), ascVarA).e();
    }
}
