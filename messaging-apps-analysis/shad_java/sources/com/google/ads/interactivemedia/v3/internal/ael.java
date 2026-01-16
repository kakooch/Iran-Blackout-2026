package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ConcurrentModificationException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ael implements act<acw> {
    private final aek a;

    public ael(aek aekVar) {
        this.a = aekVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final acu v(acw acwVar, long j, long j2, IOException iOException, int i) {
        this.a.b(iOException);
        return ada.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final void w(acw acwVar, long j, long j2, boolean z) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final void x(acw acwVar, long j, long j2) {
        if (aen.a()) {
            this.a.a();
        } else {
            this.a.b(new IOException(new ConcurrentModificationException()));
        }
    }
}
