package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajz extends agt<Timestamp> {
    final /* synthetic */ agt a;

    ajz(agt agtVar) {
        this.a = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Timestamp read(alb albVar) throws IOException {
        Date date = (Date) this.a.read(albVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Timestamp timestamp) throws IOException {
        this.a.write(aldVar, timestamp);
    }
}
