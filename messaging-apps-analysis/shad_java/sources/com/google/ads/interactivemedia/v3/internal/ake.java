package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.BitSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ake extends agt<BitSet> {
    ake() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    @Override // com.google.ads.interactivemedia.v3.internal.agt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* bridge */ /* synthetic */ java.util.BitSet read(com.google.ads.interactivemedia.v3.internal.alb r8) throws java.io.IOException {
        /*
            r7 = this;
            java.util.BitSet r0 = new java.util.BitSet
            r0.<init>()
            r8.a()
            int r1 = r8.p()
            r2 = 0
            r3 = 0
        Le:
            r4 = 2
            if (r1 == r4) goto L77
            int r4 = r1 + (-1)
            if (r1 == 0) goto L75
            r5 = 5
            r6 = 1
            if (r4 == r5) goto L48
            r5 = 6
            if (r4 == r5) goto L3f
            r5 = 7
            if (r4 != r5) goto L24
            boolean r6 = r8.h()
            goto L52
        L24:
            com.google.ads.interactivemedia.v3.internal.agq r8 = new com.google.ads.interactivemedia.v3.internal.agq
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Invalid bitset value type: "
            r0.append(r2)
            java.lang.String r1 = com.google.ads.interactivemedia.v3.internal.alc.a(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L3f:
            int r1 = r8.l()
            if (r1 == 0) goto L46
            goto L52
        L46:
            r6 = 0
            goto L52
        L48:
            java.lang.String r1 = r8.g()
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L5e
            if (r1 == 0) goto L46
        L52:
            if (r6 == 0) goto L57
            r0.set(r3)
        L57:
            int r3 = r3 + 1
            int r1 = r8.p()
            goto Le
        L5e:
            com.google.ads.interactivemedia.v3.internal.agq r8 = new com.google.ads.interactivemedia.v3.internal.agq
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L75:
            r8 = 0
            throw r8
        L77:
            r8.b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ake.read(com.google.ads.interactivemedia.v3.internal.alb):java.lang.Object");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, BitSet bitSet) throws IOException {
        BitSet bitSet2 = bitSet;
        aldVar.b();
        int length = bitSet2.length();
        for (int i = 0; i < length; i++) {
            aldVar.h(bitSet2.get(i) ? 1L : 0L);
        }
        aldVar.d();
    }
}
