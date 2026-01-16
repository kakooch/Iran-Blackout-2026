package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajl extends agt<Number> {
    ajl() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Number read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        try {
            return Long.valueOf(albVar.k());
        } catch (NumberFormatException e) {
            throw new agq(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Number number) throws IOException {
        aldVar.j(number);
    }
}
