package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ala extends aht {
    ala() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aht
    public final void a(alb albVar) throws IOException {
        if (albVar instanceof ais) {
            ((ais) albVar).n();
            return;
        }
        int iS = albVar.a;
        if (iS == 0) {
            iS = albVar.s();
        }
        if (iS == 13) {
            albVar.a = 9;
            return;
        }
        if (iS == 12) {
            albVar.a = 8;
            return;
        }
        if (iS == 14) {
            albVar.a = 10;
            return;
        }
        throw new IllegalStateException("Expected a name but was " + ((Object) alc.a(albVar.p())) + albVar.t());
    }
}
