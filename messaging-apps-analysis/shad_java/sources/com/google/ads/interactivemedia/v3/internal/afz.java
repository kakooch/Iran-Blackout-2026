package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class afz extends agt<Number> {
    afz() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Number read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return Float.valueOf((float) albVar.j());
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
            age.a(number2.floatValue());
            aldVar.j(number2);
        }
    }
}
