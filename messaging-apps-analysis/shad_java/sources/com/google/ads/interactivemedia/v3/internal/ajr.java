package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajr extends agt<StringBuilder> {
    ajr() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ StringBuilder read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return new StringBuilder(albVar.g());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, StringBuilder sb) throws IOException {
        StringBuilder sb2 = sb;
        aldVar.k(sb2 == null ? null : sb2.toString());
    }
}
