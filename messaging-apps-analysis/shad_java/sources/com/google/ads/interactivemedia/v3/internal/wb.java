package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class wb extends vt {
    private long a;
    private volatile boolean b;
    private final vs l;
    private vq m;

    public wb(abx abxVar, acb acbVar, cy cyVar, int i, Object obj, vs vsVar) {
        super(abxVar, acbVar, 2, cyVar, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.l = vsVar;
    }

    public final void a(vq vqVar) {
        this.m = vqVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void b() {
        this.b = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void c() throws IOException {
        if (this.a == 0) {
            this.l.g(this.m, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            acb acbVarC = this.d.c(this.a);
            adg adgVar = this.k;
            jv jvVar = new jv(adgVar, acbVarC.e, adgVar.c(acbVarC));
            while (!this.b && this.l.h(jvVar)) {
                try {
                } finally {
                    this.a = jvVar.l() - this.d.e;
                }
            }
        } finally {
            aeu.q(this.k);
        }
    }
}
