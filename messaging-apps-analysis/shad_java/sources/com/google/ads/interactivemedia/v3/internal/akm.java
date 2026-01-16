package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akm extends agt<Boolean> {
    akm() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Boolean read(alb albVar) throws IOException {
        int iP = albVar.p();
        if (iP != 9) {
            return Boolean.valueOf(iP == 6 ? Boolean.parseBoolean(albVar.g()) : albVar.h());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Boolean bool) throws IOException {
        aldVar.i(bool);
    }
}
