package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.do, reason: invalid class name */
/* loaded from: classes.dex */
final class Cdo implements uh, jf {
    final /* synthetic */ ds a;
    private final dq b;
    private ug c;
    private je d;

    public Cdo(ds dsVar, dq dqVar) {
        this.a = dsVar;
        this.c = dsVar.e;
        this.d = dsVar.f;
        this.b = dqVar;
    }

    private final boolean g(int i, tw twVar) {
        tw twVarA = null;
        if (twVar != null) {
            dq dqVar = this.b;
            int i2 = 0;
            while (true) {
                if (i2 >= dqVar.c.size()) {
                    break;
                }
                if (dqVar.c.get(i2).d == twVar.d) {
                    twVarA = twVar.a(Pair.create(dqVar.b, twVar.a));
                    break;
                }
                i2++;
            }
            if (twVarA == null) {
                return false;
            }
        }
        int i3 = i + this.b.d;
        ug ugVar = this.c;
        if (ugVar.a != i3 || !aeu.c(ugVar.b, twVarA)) {
            this.c = this.a.e.a(i3, twVarA, 0L);
        }
        je jeVar = this.d;
        if (jeVar.a == i3 && aeu.c(jeVar.b, twVarA)) {
            return true;
        }
        this.d = this.a.f.a(i3, twVarA);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void U(int i, tw twVar, to toVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.f(toVar, ttVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void V(int i, tw twVar, to toVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.i(toVar, ttVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void W(int i, tw twVar, to toVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.l(toVar, ttVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void X(int i, tw twVar, to toVar, tt ttVar, IOException iOException, boolean z) {
        if (g(i, twVar)) {
            this.c.o(toVar, ttVar, iOException, z);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void Y(int i, tw twVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.q(ttVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uh
    public final void Z(int i, tw twVar, tt ttVar) {
        if (g(i, twVar)) {
            this.c.s(ttVar);
        }
    }
}
