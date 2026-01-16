package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class pu implements pv {
    private static final int[] a = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] b = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final ka c;
    private final kr d;
    private final py e;
    private final int f;
    private final byte[] g;
    private final aee h;
    private final int i;
    private final cy j;
    private int k;
    private long l;
    private int m;
    private long n;

    public pu(ka kaVar, kr krVar, py pyVar) throws dt {
        this.c = kaVar;
        this.d = krVar;
        this.e = pyVar;
        int iMax = Math.max(1, pyVar.c / 10);
        this.i = iMax;
        aee aeeVar = new aee(pyVar.f);
        aeeVar.p();
        int iP = aeeVar.p();
        this.f = iP;
        int i = pyVar.b;
        int i2 = (((pyVar.d - (i * 4)) * 8) / (pyVar.e * i)) + 1;
        if (iP != i2) {
            StringBuilder sb = new StringBuilder(56);
            sb.append("Expected frames per block: ");
            sb.append(i2);
            sb.append("; got: ");
            sb.append(iP);
            throw new dt(sb.toString());
        }
        int iF = aeu.F(iMax, iP);
        this.g = new byte[pyVar.d * iF];
        this.h = new aee(iF * g(iP, i));
        int i3 = ((pyVar.c * pyVar.d) * 8) / iP;
        cx cxVar = new cx();
        cxVar.ae("audio/raw");
        cxVar.G(i3);
        cxVar.Z(i3);
        cxVar.W(g(iMax, i));
        cxVar.H(pyVar.b);
        cxVar.af(pyVar.c);
        cxVar.Y(2);
        this.j = cxVar.a();
    }

    private final void d(int i) {
        long j = this.l;
        long jN = aeu.N(this.n, 1000000L, this.e.c);
        int iF = f(i);
        this.d.b(j + jN, 1, iF, this.m - iF, null);
        this.n += i;
        this.m -= iF;
    }

    private final int e(int i) {
        int i2 = this.e.b;
        return i / (i2 + i2);
    }

    private final int f(int i) {
        return g(i, this.e.b);
    }

    private static int g(int i, int i2) {
        return (i + i) * i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pv
    public final void a(long j) {
        this.k = 0;
        this.l = j;
        this.m = 0;
        this.n = 0L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pv
    public final void b(int i, long j) {
        this.c.am(new qb(this.e, this.f, i, j));
        this.d.a(this.j);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003b -> B:4:0x001f). Please report as a decompilation issue!!! */
    @Override // com.google.ads.interactivemedia.v3.internal.pv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(com.google.ads.interactivemedia.v3.internal.jv r20, long r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pu.c(com.google.ads.interactivemedia.v3.internal.jv, long):boolean");
    }
}
