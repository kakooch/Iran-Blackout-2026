package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akr extends agt<AtomicInteger> {
    akr() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ AtomicInteger read(alb albVar) throws IOException {
        try {
            return new AtomicInteger(albVar.l());
        } catch (NumberFormatException e) {
            throw new agq(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, AtomicInteger atomicInteger) throws IOException {
        aldVar.h(atomicInteger.get());
    }
}
