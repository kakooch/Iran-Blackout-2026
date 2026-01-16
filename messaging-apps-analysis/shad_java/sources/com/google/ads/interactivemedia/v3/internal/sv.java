package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class sv implements vb {
    public final vb a;
    final /* synthetic */ sw b;
    private boolean c;

    public sv(sw swVar, vb vbVar) {
        this.b = swVar;
        this.a = vbVar;
    }

    public final void a() {
        this.c = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final boolean b() {
        return !this.b.p() && this.a.b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final void c() throws IOException {
        this.a.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        if (r12.c == false) goto L33;
     */
    @Override // com.google.ads.interactivemedia.v3.internal.vb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.ads.interactivemedia.v3.internal.cz r11, com.google.ads.interactivemedia.v3.internal.iw r12, boolean r13) {
        /*
            r10 = this;
            com.google.ads.interactivemedia.v3.internal.sw r0 = r10.b
            boolean r0 = r0.p()
            r1 = -3
            if (r0 == 0) goto La
            return r1
        La:
            boolean r0 = r10.c
            r2 = 4
            r3 = -4
            if (r0 == 0) goto L14
            r12.f(r2)
            return r3
        L14:
            com.google.ads.interactivemedia.v3.internal.vb r0 = r10.a
            int r13 = r0.d(r11, r12, r13)
            r0 = -5
            r4 = -9223372036854775808
            if (r13 != r0) goto L49
            com.google.ads.interactivemedia.v3.internal.cy r12 = r11.a
            com.google.ads.interactivemedia.v3.internal.ary.t(r12)
            int r13 = r12.B
            if (r13 != 0) goto L2c
            int r1 = r12.C
            if (r1 == 0) goto L48
        L2c:
            com.google.ads.interactivemedia.v3.internal.sw r1 = r10.b
            long r1 = r1.b
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 == 0) goto L36
            r1 = 0
            goto L38
        L36:
            int r1 = r12.C
        L38:
            com.google.ads.interactivemedia.v3.internal.cx r12 = r12.a()
            r12.M(r13)
            r12.N(r1)
            com.google.ads.interactivemedia.v3.internal.cy r12 = r12.a()
            r11.a = r12
        L48:
            return r0
        L49:
            com.google.ads.interactivemedia.v3.internal.sw r11 = r10.b
            long r6 = r11.b
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L73
            if (r13 != r3) goto L5a
            long r8 = r12.d
            int r13 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r13 >= 0) goto L69
            r13 = -4
        L5a:
            if (r13 != r1) goto L73
            long r0 = r11.h()
            int r11 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r11 != 0) goto L73
            boolean r11 = r12.c
            if (r11 == 0) goto L69
            goto L73
        L69:
            r12.a()
            r12.f(r2)
            r11 = 1
            r10.c = r11
            return r3
        L73:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.sv.d(com.google.ads.interactivemedia.v3.internal.cz, com.google.ads.interactivemedia.v3.internal.iw, boolean):int");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int e(long j) {
        if (this.b.p()) {
            return -3;
        }
        return this.a.e(j);
    }
}
