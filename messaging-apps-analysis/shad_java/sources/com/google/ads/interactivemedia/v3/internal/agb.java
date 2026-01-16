package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class agb extends agt<AtomicLong> {
    final /* synthetic */ agt a;

    agb(agt agtVar) {
        this.a = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ AtomicLong read(alb albVar) throws IOException {
        return new AtomicLong(((Number) this.a.read(albVar)).longValue());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, AtomicLong atomicLong) throws IOException {
        this.a.write(aldVar, Long.valueOf(atomicLong.get()));
    }
}
