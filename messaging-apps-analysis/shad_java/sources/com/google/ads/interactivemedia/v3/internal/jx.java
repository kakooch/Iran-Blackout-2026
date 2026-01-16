package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jx implements kr {
    private final byte[] a = new byte[4096];

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void a(cy cyVar) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void b(long j, int i, int i2, int i3, kq kqVar) {
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
        int iA = abuVar.a(this.a, 0, Math.min(4096, i));
        if (iA != -1) {
            return iA;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void f(aee aeeVar, int i) {
        aeeVar.k(i);
    }
}
