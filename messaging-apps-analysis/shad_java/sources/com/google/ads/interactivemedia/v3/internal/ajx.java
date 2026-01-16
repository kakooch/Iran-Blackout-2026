package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.UUID;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajx extends agt<UUID> {
    ajx() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ UUID read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return UUID.fromString(albVar.g());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, UUID uuid) throws IOException {
        UUID uuid2 = uuid;
        aldVar.k(uuid2 == null ? null : uuid2.toString());
    }
}
