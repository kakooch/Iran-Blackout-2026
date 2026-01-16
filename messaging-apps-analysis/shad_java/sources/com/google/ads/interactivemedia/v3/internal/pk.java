package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class pk implements pd {
    final /* synthetic */ pm a;
    private final aed b = new aed(new byte[4]);

    public pk(pm pmVar) {
        this.a = pmVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pd
    public final void a(aes aesVar, ka kaVar, pq pqVar) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pd
    public final void b(aee aeeVar) {
        if (aeeVar.n() == 0 && (aeeVar.n() & 128) != 0) {
            aeeVar.k(6);
            int iD = aeeVar.d() / 4;
            for (int i = 0; i < iD; i++) {
                aeeVar.l(this.b, 4);
                int i2 = this.b.i(16);
                this.b.g(3);
                if (i2 == 0) {
                    this.b.g(13);
                } else {
                    int i3 = this.b.i(13);
                    if (this.a.h.get(i3) == null) {
                        this.a.h.put(i3, new pe(new pl(this.a, i3)));
                        pm.r(this.a);
                    }
                }
            }
            if (this.a.b != 2) {
                this.a.h.remove(0);
            }
        }
    }
}
