package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class kx implements jy {
    public static final /* synthetic */ int a = 0;
    private static final int[] b;
    private static final int[] c;
    private static final byte[] d;
    private static final byte[] e;
    private static final int f;
    private final byte[] g;
    private boolean h;
    private long i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private long o;
    private ka p;
    private kr q;
    private ko r;
    private boolean s;

    static {
        int i = kw.b;
        b = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        c = iArr;
        d = aeu.y("#!AMR\n");
        e = aeu.y("#!AMR-WB\n");
        f = iArr[8];
    }

    public kx() {
        this(null);
    }

    public kx(byte[] bArr) {
        this.g = new byte[1];
        this.m = -1;
    }

    private final boolean a(jv jvVar) throws IOException {
        byte[] bArr = d;
        if (b(jvVar, bArr)) {
            this.h = false;
            jvVar.d(bArr.length);
            return true;
        }
        byte[] bArr2 = e;
        if (!b(jvVar, bArr2)) {
            return false;
        }
        this.h = true;
        jvVar.d(bArr2.length);
        return true;
    }

    private static boolean b(jv jvVar, byte[] bArr) throws IOException {
        jvVar.j();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        jvVar.g(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035 A[Catch: EOFException -> 0x0096, TryCatch #0 {EOFException -> 0x0096, blocks: (B:4:0x0007, B:6:0x0017, B:20:0x0035, B:22:0x003e, B:21:0x003a, B:28:0x0051, B:31:0x005a, B:32:0x007c, B:33:0x007d, B:34:0x0095), top: B:44:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[Catch: EOFException -> 0x0096, TryCatch #0 {EOFException -> 0x0096, blocks: (B:4:0x0007, B:6:0x0017, B:20:0x0035, B:22:0x003e, B:21:0x003a, B:28:0x0051, B:31:0x005a, B:32:0x007c, B:33:0x007d, B:34:0x0095), top: B:44:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int c(com.google.ads.interactivemedia.v3.internal.jv r10) throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.k
            r1 = 0
            r2 = -1
            r3 = 1
            if (r0 != 0) goto L97
            r10.j()     // Catch: java.io.EOFException -> L96
            byte[] r0 = r9.g     // Catch: java.io.EOFException -> L96
            r10.g(r0, r1, r3)     // Catch: java.io.EOFException -> L96
            byte[] r0 = r9.g     // Catch: java.io.EOFException -> L96
            r0 = r0[r1]     // Catch: java.io.EOFException -> L96
            r4 = r0 & 131(0x83, float:1.84E-43)
            if (r4 > 0) goto L7d
            int r0 = r0 >> 3
            r0 = r0 & 15
            boolean r4 = r9.h     // Catch: java.io.EOFException -> L96
            if (r4 == 0) goto L28
            r5 = 10
            if (r0 < r5) goto L33
            r5 = 13
            if (r0 <= r5) goto L28
            goto L33
        L28:
            if (r4 != 0) goto L51
            r5 = 12
            if (r0 < r5) goto L33
            r5 = 14
            if (r0 > r5) goto L33
            goto L51
        L33:
            if (r4 == 0) goto L3a
            int[] r4 = com.google.ads.interactivemedia.v3.internal.kx.c     // Catch: java.io.EOFException -> L96
            r0 = r4[r0]     // Catch: java.io.EOFException -> L96
            goto L3e
        L3a:
            int[] r4 = com.google.ads.interactivemedia.v3.internal.kx.b     // Catch: java.io.EOFException -> L96
            r0 = r4[r0]     // Catch: java.io.EOFException -> L96
        L3e:
            r9.j = r0     // Catch: java.io.EOFException -> L96
            r9.k = r0
            int r4 = r9.m
            if (r4 != r2) goto L49
            r9.m = r0
            r4 = r0
        L49:
            if (r4 != r0) goto L97
            int r4 = r9.n
            int r4 = r4 + r3
            r9.n = r4
            goto L97
        L51:
            com.google.ads.interactivemedia.v3.internal.dt r10 = new com.google.ads.interactivemedia.v3.internal.dt     // Catch: java.io.EOFException -> L96
            java.lang.String r1 = "WB"
            java.lang.String r5 = "NB"
            if (r3 == r4) goto L5a
            r1 = r5
        L5a:
            int r3 = r1.length()     // Catch: java.io.EOFException -> L96
            int r3 = r3 + 35
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> L96
            r4.<init>(r3)     // Catch: java.io.EOFException -> L96
            java.lang.String r3 = "Illegal AMR "
            r4.append(r3)     // Catch: java.io.EOFException -> L96
            r4.append(r1)     // Catch: java.io.EOFException -> L96
            java.lang.String r1 = " frame type "
            r4.append(r1)     // Catch: java.io.EOFException -> L96
            r4.append(r0)     // Catch: java.io.EOFException -> L96
            java.lang.String r0 = r4.toString()     // Catch: java.io.EOFException -> L96
            r10.<init>(r0)     // Catch: java.io.EOFException -> L96
            throw r10     // Catch: java.io.EOFException -> L96
        L7d:
            com.google.ads.interactivemedia.v3.internal.dt r10 = new com.google.ads.interactivemedia.v3.internal.dt     // Catch: java.io.EOFException -> L96
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> L96
            r3 = 42
            r1.<init>(r3)     // Catch: java.io.EOFException -> L96
            java.lang.String r3 = "Invalid padding bits for frame header "
            r1.append(r3)     // Catch: java.io.EOFException -> L96
            r1.append(r0)     // Catch: java.io.EOFException -> L96
            java.lang.String r0 = r1.toString()     // Catch: java.io.EOFException -> L96
            r10.<init>(r0)     // Catch: java.io.EOFException -> L96
            throw r10     // Catch: java.io.EOFException -> L96
        L96:
            return r2
        L97:
            com.google.ads.interactivemedia.v3.internal.kr r4 = r9.q
            int r10 = r4.c(r10, r0, r3)
            if (r10 != r2) goto La0
            return r2
        La0:
            int r0 = r9.k
            int r0 = r0 - r10
            r9.k = r0
            if (r0 <= 0) goto La8
            return r1
        La8:
            com.google.ads.interactivemedia.v3.internal.kr r2 = r9.q
            long r3 = r9.o
            long r5 = r9.i
            long r3 = r3 + r5
            r5 = 1
            int r6 = r9.j
            r7 = 0
            r8 = 0
            r2.b(r3, r5, r6, r7, r8)
            long r2 = r9.i
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r2 = r2 + r4
            r9.i = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.kx.c(com.google.ads.interactivemedia.v3.internal.jv):int");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.p = kaVar;
        this.q = kaVar.ak(0, 1);
        kaVar.al();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        this.i = 0L;
        this.j = 0;
        this.k = 0;
        this.o = 0L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        return a(jvVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        ary.s(this.q);
        int i = aeu.a;
        if (jvVar.l() == 0 && !a(jvVar)) {
            throw new dt("Could not find AMR header.");
        }
        if (!this.s) {
            this.s = true;
            boolean z = this.h;
            String str = true != z ? "audio/3gpp" : "audio/amr-wb";
            int i2 = true != z ? 8000 : 16000;
            kr krVar = this.q;
            cx cxVar = new cx();
            cxVar.ae(str);
            cxVar.W(f);
            cxVar.H(1);
            cxVar.af(i2);
            krVar.a(cxVar.a());
        }
        int iC = c(jvVar);
        if (!this.l) {
            kn knVar = new kn(-9223372036854775807L);
            this.r = knVar;
            this.p.am(knVar);
            this.l = true;
        }
        return iC;
    }
}
