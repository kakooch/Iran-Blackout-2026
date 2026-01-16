package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ags extends agt {
    final /* synthetic */ agt a;

    ags(agt agtVar) {
        this.a = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final Object read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return this.a.read(albVar);
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, Object obj) throws IOException {
        if (obj == null) {
            aldVar.g();
        } else {
            this.a.write(aldVar, obj);
        }
    }
}
