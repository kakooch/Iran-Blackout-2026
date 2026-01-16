package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class mj implements mg {
    private final aee a;
    private final int b;
    private final int c;
    private int d;
    private int e;

    public mj(md mdVar) {
        aee aeeVar = mdVar.a;
        this.a = aeeVar;
        aeeVar.h(12);
        this.c = aeeVar.B() & 255;
        this.b = aeeVar.B();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.mg
    public final int a() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.mg
    public final int b() {
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.mg
    public final int c() {
        int i = this.c;
        if (i == 8) {
            return this.a.n();
        }
        if (i == 16) {
            return this.a.o();
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 % 2 != 0) {
            return this.e & 15;
        }
        int iN = this.a.n();
        this.e = iN;
        return (iN & 240) >> 4;
    }
}
