package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajm extends agt<Number> {
    ajm() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Number read(alb albVar) throws IOException {
        int iP = albVar.p();
        int i = iP - 1;
        if (iP == 0) {
            throw null;
        }
        if (i == 5 || i == 6) {
            return new ahu(albVar.g());
        }
        if (i == 8) {
            albVar.i();
            return null;
        }
        throw new agq("Expecting number, got: " + ((Object) alc.a(iP)));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Number number) throws IOException {
        aldVar.j(number);
    }
}
