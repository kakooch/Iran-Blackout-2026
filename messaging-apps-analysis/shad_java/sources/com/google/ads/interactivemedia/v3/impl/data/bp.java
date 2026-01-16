package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.agt;
import com.google.ads.interactivemedia.v3.internal.alb;
import com.google.ads.interactivemedia.v3.internal.ald;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class bp extends agt<bq> {
    bp() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public bq read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return new bq(albVar.g());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public void write(ald aldVar, bq bqVar) throws IOException {
        if (bqVar == null) {
            aldVar.g();
        } else {
            aldVar.k(bqVar.getName());
        }
    }
}
