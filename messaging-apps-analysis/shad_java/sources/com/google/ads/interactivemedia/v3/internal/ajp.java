package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.math.BigDecimal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajp extends agt<BigDecimal> {
    ajp() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ BigDecimal read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        try {
            return new BigDecimal(albVar.g());
        } catch (NumberFormatException e) {
            throw new agq(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, BigDecimal bigDecimal) throws IOException {
        aldVar.j(bigDecimal);
    }
}
