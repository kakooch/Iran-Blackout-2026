package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class yf {
    private static final kl b = new kl();
    final jy a;
    private final cy c;
    private final aes d;

    public yf(jy jyVar, cy cyVar, aes aesVar) {
        this.a = jyVar;
        this.c = cyVar;
        this.d = aesVar;
    }

    public final void a(ka kaVar) {
        this.a.d(kaVar);
    }

    public final boolean b() {
        jy jyVar = this.a;
        return (jyVar instanceof oc) || (jyVar instanceof nw) || (jyVar instanceof nz) || (jyVar instanceof ly);
    }

    public final boolean c() {
        jy jyVar = this.a;
        return (jyVar instanceof pm) || (jyVar instanceof ms);
    }

    public final boolean d(jv jvVar) throws IOException {
        return this.a.h(jvVar, b) == 0;
    }

    public final yf e() {
        jy lyVar;
        ary.q(!c());
        jy jyVar = this.a;
        if (jyVar instanceof zj) {
            lyVar = new zj(this.c.c, this.d);
        } else if (jyVar instanceof oc) {
            lyVar = new oc();
        } else if (jyVar instanceof nw) {
            lyVar = new nw();
        } else if (jyVar instanceof nz) {
            lyVar = new nz();
        } else {
            if (!(jyVar instanceof ly)) {
                String simpleName = jyVar.getClass().getSimpleName();
                throw new IllegalStateException(simpleName.length() != 0 ? "Unexpected extractor type for recreation: ".concat(simpleName) : new String("Unexpected extractor type for recreation: "));
            }
            lyVar = new ly();
        }
        return new yf(lyVar, this.c, this.d);
    }
}
