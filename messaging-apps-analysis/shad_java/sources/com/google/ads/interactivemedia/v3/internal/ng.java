package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ng implements nn {
    private final nm a;
    private final long b;
    private final long c;
    private final nr d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    public ng(nr nrVar, long j, long j2, long j3, long j4, boolean z) {
        ary.o(j >= 0 && j2 > j);
        this.d = nrVar;
        this.b = j;
        this.c = j2;
        if (j3 == j2 - j || z) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new nm();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nn
    public final void a(long j) {
        this.h = aeu.I(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nn
    public final /* bridge */ /* synthetic */ ko b() {
        if (this.f != 0) {
            return new nf(this);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba  */
    @Override // com.google.ads.interactivemedia.v3.internal.nn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long g(com.google.ads.interactivemedia.v3.internal.jv r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ng.g(com.google.ads.interactivemedia.v3.internal.jv):long");
    }
}
