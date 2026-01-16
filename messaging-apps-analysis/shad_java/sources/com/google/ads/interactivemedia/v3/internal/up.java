package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class up implements vb {
    final /* synthetic */ us a;
    private final int b;

    public up(us usVar, int i) {
        this.a = usVar;
        this.b = i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final boolean b() {
        return this.a.p(this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final void c() throws IOException {
        this.a.q(this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int d(cz czVar, iw iwVar, boolean z) {
        return this.a.s(this.b, czVar, iwVar, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int e(long j) {
        return this.a.t(this.b, j);
    }
}
