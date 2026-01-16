package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class mi implements mg {
    private final int a;
    private final int b;
    private final aee c;

    public mi(md mdVar) {
        aee aeeVar = mdVar.a;
        this.c = aeeVar;
        aeeVar.h(12);
        int iB = aeeVar.B();
        this.a = iB == 0 ? -1 : iB;
        this.b = aeeVar.B();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.mg
    public final int a() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.mg
    public final int b() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.mg
    public final int c() {
        int i = this.a;
        return i == -1 ? this.c.B() : i;
    }
}
