package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aga extends agt<Number> {
    aga() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Number read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return Long.valueOf(albVar.k());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Number number) throws IOException {
        Number number2 = number;
        if (number2 == null) {
            aldVar.g();
        } else {
            aldVar.k(number2.toString());
        }
    }
}
