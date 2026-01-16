package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class vr implements kr {
    public cy a;
    private final int b;
    private final int c;
    private final cy d;
    private final jx e = new jx();
    private kr f;
    private long g;

    public vr(int i, int i2, cy cyVar) {
        this.b = i;
        this.c = i2;
        this.d = cyVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void a(cy cyVar) {
        cy cyVar2 = this.d;
        if (cyVar2 != null) {
            cyVar = cyVar.b(cyVar2);
        }
        this.a = cyVar;
        kr krVar = this.f;
        int i = aeu.a;
        krVar.a(cyVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void b(long j, int i, int i2, int i3, kq kqVar) {
        long j2 = this.g;
        if (j2 != -9223372036854775807L && j >= j2) {
            this.f = this.e;
        }
        kr krVar = this.f;
        int i4 = aeu.a;
        krVar.b(j, i, i2, i3, kqVar);
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
        kr krVar = this.f;
        int i2 = aeu.a;
        return krVar.c(abuVar, i, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void f(aee aeeVar, int i) {
        kr krVar = this.f;
        int i2 = aeu.a;
        krVar.d(aeeVar, i);
    }

    public final void g(vq vqVar, long j) {
        if (vqVar == null) {
            this.f = this.e;
            return;
        }
        this.g = j;
        kr krVarC = vqVar.c(this.c);
        this.f = krVarC;
        cy cyVar = this.a;
        if (cyVar != null) {
            krVarC.a(cyVar);
        }
    }
}
