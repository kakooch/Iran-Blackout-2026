package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ow implements pd {
    private cy a;
    private aes b;
    private kr c;

    public ow(String str) {
        cx cxVar = new cx();
        cxVar.ae(str);
        this.a = cxVar.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pd
    public final void a(aes aesVar, ka kaVar, pq pqVar) {
        this.b = aesVar;
        pqVar.a();
        kr krVarAk = kaVar.ak(pqVar.b(), 4);
        this.c = krVarAk;
        krVarAk.a(this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pd
    public final void b(aee aeeVar) {
        ary.s(this.b);
        int i = aeu.a;
        long jD = this.b.d();
        if (jD == -9223372036854775807L) {
            return;
        }
        cy cyVar = this.a;
        if (jD != cyVar.p) {
            cx cxVarA = cyVar.a();
            cxVarA.ai(jD);
            cy cyVarA = cxVarA.a();
            this.a = cyVarA;
            this.c.a(cyVarA);
        }
        int iD = aeeVar.d();
        this.c.d(aeeVar, iD);
        this.c.b(this.b.c(), 1, iD, 0, null);
    }
}
