package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class pz {
    public final int a;
    public final long b;

    private pz(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public static pz a(jv jvVar, aee aeeVar) throws IOException {
        jvVar.g(aeeVar.i(), 0, 8);
        aeeVar.h(0);
        return new pz(aeeVar.v(), aeeVar.u());
    }
}
