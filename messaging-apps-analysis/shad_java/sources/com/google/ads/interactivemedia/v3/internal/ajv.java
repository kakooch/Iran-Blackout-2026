package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajv extends agt<URI> {
    ajv() {
    }

    public static final URI a(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        try {
            String strG = albVar.g();
            if ("null".equals(strG)) {
                return null;
            }
            return new URI(strG);
        } catch (URISyntaxException e) {
            throw new agk(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ URI read(alb albVar) throws IOException {
        return a(albVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, URI uri) throws IOException {
        URI uri2 = uri;
        aldVar.k(uri2 == null ? null : uri2.toASCIIString());
    }
}
