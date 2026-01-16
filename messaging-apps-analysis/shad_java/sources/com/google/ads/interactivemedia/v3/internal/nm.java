package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class nm {
    public int a;
    public int b;
    public long c;
    public int d;
    public int e;
    public int f;
    public final int[] g = new int[255];
    private final aee h = new aee(255);

    nm() {
    }

    private static boolean e(jv jvVar, byte[] bArr, int i, boolean z) throws IOException {
        try {
            return jvVar.f(bArr, 0, i, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public final void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public final boolean b(jv jvVar) throws IOException {
        return c(jvVar, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r10 == (-1)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (r9.l() >= r10) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        if (r9.n() != (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(com.google.ads.interactivemedia.v3.internal.jv r9, long r10) throws java.io.IOException {
        /*
            r8 = this;
            long r0 = r9.l()
            long r2 = r9.k()
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            com.google.ads.interactivemedia.v3.internal.ary.o(r0)
        L14:
            r0 = -1
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 == 0) goto L26
            long r2 = r9.l()
            r6 = 4
            long r2 = r2 + r6
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 < 0) goto L26
            goto L4d
        L26:
            com.google.ads.interactivemedia.v3.internal.aee r2 = r8.h
            byte[] r2 = r2.i()
            r3 = 4
            boolean r2 = e(r9, r2, r3, r5)
            if (r2 == 0) goto L4d
            com.google.ads.interactivemedia.v3.internal.aee r0 = r8.h
            r0.a(r3)
            com.google.ads.interactivemedia.v3.internal.aee r0 = r8.h
            long r0 = r0.t()
            r2 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L49
            r9.j()
            return r5
        L49:
            r9.d(r5)
            goto L14
        L4d:
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 == 0) goto L59
            long r2 = r9.l()
            int r5 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r5 >= 0) goto L60
        L59:
            int r2 = r9.n()
            r3 = -1
            if (r2 != r3) goto L4d
        L60:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.nm.c(com.google.ads.interactivemedia.v3.internal.jv, long):boolean");
    }

    public final boolean d(jv jvVar, boolean z) throws IOException {
        a();
        this.h.a(27);
        if (!e(jvVar, this.h.i(), 27, z) || this.h.t() != 1332176723) {
            return false;
        }
        int iN = this.h.n();
        this.a = iN;
        if (iN != 0) {
            if (z) {
                return false;
            }
            throw new dt("unsupported bit stream revision");
        }
        this.b = this.h.n();
        this.c = this.h.y();
        this.h.u();
        this.h.u();
        this.h.u();
        int iN2 = this.h.n();
        this.d = iN2;
        this.e = iN2 + 27;
        this.h.a(iN2);
        jvVar.g(this.h.i(), 0, this.d);
        for (int i = 0; i < this.d; i++) {
            this.g[i] = this.h.n();
            this.f += this.g[i];
        }
        return true;
    }
}
