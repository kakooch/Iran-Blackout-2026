package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akn extends agt<Boolean> {
    akn() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Boolean read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return Boolean.valueOf(albVar.g());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Boolean bool) throws IOException {
        Boolean bool2 = bool;
        aldVar.k(bool2 == null ? "null" : bool2.toString());
    }
}
