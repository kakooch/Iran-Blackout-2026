package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xg implements kr {
    final /* synthetic */ xh a;
    private final va b;
    private final cz c = new cz();
    private final iw d = new iw();

    xg(xh xhVar, acc accVar) {
        this.a = xhVar;
        this.b = new va(accVar, xhVar.c.getLooper(), jh.a, new je());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void a(cy cyVar) {
        this.b.a(cyVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x000a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x000a A[SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.v3.internal.kr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r8, int r10, int r11, int r12, com.google.ads.interactivemedia.v3.internal.kq r13) {
        /*
            r7 = this;
            com.google.ads.interactivemedia.v3.internal.va r0 = r7.b
            r1 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r0.b(r1, r3, r4, r5, r6)
        La:
            com.google.ads.interactivemedia.v3.internal.va r8 = r7.b
            r9 = 0
            boolean r8 = r8.y(r9)
            if (r8 == 0) goto L9c
            com.google.ads.interactivemedia.v3.internal.iw r8 = r7.d
            r8.a()
            com.google.ads.interactivemedia.v3.internal.va r8 = r7.b
            com.google.ads.interactivemedia.v3.internal.cz r10 = r7.c
            com.google.ads.interactivemedia.v3.internal.iw r11 = r7.d
            int r8 = r8.z(r10, r11, r9, r9)
            r10 = -4
            if (r8 != r10) goto L2d
            com.google.ads.interactivemedia.v3.internal.iw r8 = r7.d
            r8.l()
            com.google.ads.interactivemedia.v3.internal.iw r8 = r7.d
            goto L2e
        L2d:
            r8 = 0
        L2e:
            if (r8 == 0) goto La
            long r10 = r8.d
            com.google.ads.interactivemedia.v3.internal.xh r12 = r7.a
            com.google.ads.interactivemedia.v3.internal.rd r12 = com.google.ads.interactivemedia.v3.internal.xh.h(r12)
            com.google.ads.interactivemedia.v3.internal.qz r8 = r12.a(r8)
            if (r8 == 0) goto La
            com.google.ads.interactivemedia.v3.internal.qy r8 = r8.b(r9)
            com.google.ads.interactivemedia.v3.internal.rc r8 = (com.google.ads.interactivemedia.v3.internal.rc) r8
            java.lang.String r12 = r8.a
            java.lang.String r13 = r8.b
            java.lang.String r0 = "urn:mpeg:dash:event:2012"
            boolean r12 = r0.equals(r12)
            r0 = 1
            if (r12 == 0) goto L6b
            java.lang.String r12 = "1"
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L6a
            java.lang.String r12 = "2"
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L6a
            java.lang.String r12 = "3"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L6b
            goto L6d
        L6a:
            r9 = 1
        L6b:
            if (r9 == 0) goto La
        L6d:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            byte[] r8 = r8.e     // Catch: com.google.ads.interactivemedia.v3.internal.dt -> L7d
            java.lang.String r8 = com.google.ads.interactivemedia.v3.internal.aeu.w(r8)     // Catch: com.google.ads.interactivemedia.v3.internal.dt -> L7d
            long r8 = com.google.ads.interactivemedia.v3.internal.aeu.M(r8)     // Catch: com.google.ads.interactivemedia.v3.internal.dt -> L7d
            goto L7e
        L7d:
            r8 = r12
        L7e:
            int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r1 == 0) goto La
            com.google.ads.interactivemedia.v3.internal.xe r12 = new com.google.ads.interactivemedia.v3.internal.xe
            r12.<init>(r10, r8)
            com.google.ads.interactivemedia.v3.internal.xh r8 = r7.a
            android.os.Handler r8 = com.google.ads.interactivemedia.v3.internal.xh.g(r8)
            com.google.ads.interactivemedia.v3.internal.xh r9 = r7.a
            android.os.Handler r9 = com.google.ads.interactivemedia.v3.internal.xh.g(r9)
            android.os.Message r9 = r9.obtainMessage(r0, r12)
            r8.sendMessage(r9)
            goto La
        L9c:
            com.google.ads.interactivemedia.v3.internal.va r8 = r7.b
            r8.F()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.xg.b(long, int, int, int, com.google.ads.interactivemedia.v3.internal.kq):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final int c(abu abuVar, int i, boolean z) throws IOException {
        return atv.q(this, abuVar, i, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void d(aee aeeVar, int i) {
        atv.r(this, aeeVar, i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final int e(abu abuVar, int i, boolean z) throws IOException {
        return atv.q(this.b, abuVar, i, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void f(aee aeeVar, int i) {
        atv.r(this.b, aeeVar, i);
    }

    public final void g() {
        this.b.g();
    }
}
