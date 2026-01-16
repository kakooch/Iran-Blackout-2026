package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class wf extends vo {
    private final int m;
    private final cy n;
    private long o;
    private boolean p;

    public wf(abx abxVar, acb acbVar, cy cyVar, int i, Object obj, long j, long j2, long j3, int i2, cy cyVar2) {
        super(abxVar, acbVar, cyVar, i, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.m = i2;
        this.n = cyVar2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void b() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void c() throws IOException {
        vq vqVarE = e();
        vqVarE.b(0L);
        kr krVarC = vqVarE.c(this.m);
        krVarC.a(this.n);
        try {
            long jC = this.k.c(this.d.c(this.o));
            if (jC != -1) {
                jC += this.o;
            }
            jv jvVar = new jv(this.k, this.o, jC);
            for (int iC = 0; iC != -1; iC = krVarC.c(jvVar, ConnectionsManager.DEFAULT_DATACENTER_ID, true)) {
                this.o += iC;
            }
            krVarC.b(this.i, 1, (int) this.o, 0, null);
            aeu.q(this.k);
            this.p = true;
        } catch (Throwable th) {
            aeu.q(this.k);
            throw th;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wc
    public final boolean j() {
        return this.p;
    }
}
