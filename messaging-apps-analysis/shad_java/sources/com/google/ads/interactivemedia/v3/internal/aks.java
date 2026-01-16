package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aks extends agt<AtomicBoolean> {
    aks() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ AtomicBoolean read(alb albVar) throws IOException {
        return new AtomicBoolean(albVar.h());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, AtomicBoolean atomicBoolean) throws IOException {
        aldVar.l(atomicBoolean.get());
    }
}
