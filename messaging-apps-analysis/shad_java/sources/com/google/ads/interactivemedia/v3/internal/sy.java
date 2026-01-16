package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class sy implements uh, jf {
    final /* synthetic */ ta a;
    private final Object b;
    private ug c;
    private je d;

    public sy(ta taVar, Object obj) {
        this.a = taVar;
        this.c = taVar.f(null);
        this.d = taVar.h(null);
        this.b = obj;
    }

    private final boolean g(int i, tw twVar) {
        tw twVarA;
        if (twVar != null) {
            twVarA = this.a.A(this.b, twVar);
            if (twVarA == null) {
                return false;
            }
        } else {
            twVarA = null;
        }
        int iZ = this.a.z(this.b, i);
        ug ugVar = this.c;
        if (ugVar.a != iZ || !aeu.c(ugVar.b, twVarA)) {
            this.c = this.a.t(iZ, twVarA);
        }
        je jeVar = this.d;
        if (jeVar.a == iZ && aeu.c(jeVar.b, twVarA)) {
            return true;
        }
        this.d = this.a.i(iZ, twVarA);
        return true;
    }

    private static final tt h(tt ttVar) {
        long j = ttVar.f;
        return ttVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void U(int i, tw twVar, to toVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.f(toVar, h(ttVar));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void V(int i, tw twVar, to toVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.i(toVar, h(ttVar));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void W(int i, tw twVar, to toVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.l(toVar, h(ttVar));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void X(int i, tw twVar, to toVar, tt ttVar, IOException iOException, boolean z) {
        if (g(i, twVar)) {
            this.c.o(toVar, h(ttVar), iOException, z);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void Y(int i, tw twVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.q(h(ttVar));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void Z(int i, tw twVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.s(h(ttVar));
        }
    }
}
