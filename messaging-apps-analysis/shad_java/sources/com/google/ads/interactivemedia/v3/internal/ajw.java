package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.InetAddress;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajw extends agt<InetAddress> {
    ajw() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ InetAddress read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return InetAddress.getByName(albVar.g());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, InetAddress inetAddress) throws IOException {
        InetAddress inetAddress2 = inetAddress;
        aldVar.k(inetAddress2 == null ? null : inetAddress2.getHostAddress());
    }
}
