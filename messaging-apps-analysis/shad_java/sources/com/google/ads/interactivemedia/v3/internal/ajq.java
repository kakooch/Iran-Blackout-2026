package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.math.BigInteger;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajq extends agt<BigInteger> {
    ajq() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ BigInteger read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        try {
            return new BigInteger(albVar.g());
        } catch (NumberFormatException e) {
            throw new agq(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, BigInteger bigInteger) throws IOException {
        aldVar.j(bigInteger);
    }
}
