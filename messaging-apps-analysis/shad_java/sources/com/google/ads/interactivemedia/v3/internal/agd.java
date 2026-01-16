package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class agd<T> extends agt<T> {
    private agt<T> a;

    agd() {
    }

    public final void a(agt<T> agtVar) {
        if (this.a != null) {
            throw new AssertionError();
        }
        this.a = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final T read(alb albVar) throws IOException {
        agt<T> agtVar = this.a;
        if (agtVar != null) {
            return agtVar.read(albVar);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, T t) throws IOException {
        agt<T> agtVar = this.a;
        if (agtVar == null) {
            throw new IllegalStateException();
        }
        agtVar.write(aldVar, t);
    }
}
