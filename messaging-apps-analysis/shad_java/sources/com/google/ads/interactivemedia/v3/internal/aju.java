package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.URL;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aju extends agt<URL> {
    aju() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ URL read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        String strG = albVar.g();
        if ("null".equals(strG)) {
            return null;
        }
        return new URL(strG);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, URL url) throws IOException {
        URL url2 = url;
        aldVar.k(url2 == null ? null : url2.toExternalForm());
    }
}
