package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajo extends agt<String> {
    ajo() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ String read(alb albVar) throws IOException {
        int iP = albVar.p();
        if (iP != 9) {
            return iP == 8 ? Boolean.toString(albVar.h()) : albVar.g();
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, String str) throws IOException {
        aldVar.k(str);
    }
}
