package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ni extends nr {
    private kh a;
    private nh b;

    ni() {
    }

    private static boolean d(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final void a(boolean z) {
        super.a(z);
        if (z) {
            this.a = null;
            this.b = null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final long b(aee aeeVar) {
        if (!d(aeeVar.i())) {
            return -1L;
        }
        int i = (aeeVar.i()[2] & 255) >> 4;
        if (i == 6) {
            aeeVar.k(4);
            aeeVar.J();
        } else if (i == 7) {
            i = 7;
            aeeVar.k(4);
            aeeVar.J();
        }
        int iJ = asn.j(aeeVar, i);
        aeeVar.h(0);
        return iJ;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final boolean c(aee aeeVar, long j, np npVar) {
        byte[] bArrI = aeeVar.i();
        kh khVar = this.a;
        if (khVar == null) {
            kh khVar2 = new kh(bArrI, 17);
            this.a = khVar2;
            npVar.a = khVar2.c(Arrays.copyOfRange(bArrI, 9, aeeVar.e()), null);
            return true;
        }
        if ((bArrI[0] & 127) == 3) {
            kg kgVarS = atv.s(aeeVar);
            kh khVarE = khVar.e(kgVarS);
            this.a = khVarE;
            this.b = new nh(khVarE, kgVarS);
            return true;
        }
        if (!d(bArrI)) {
            return true;
        }
        nh nhVar = this.b;
        if (nhVar != null) {
            nhVar.c(j);
            npVar.b = this.b;
        }
        return false;
    }
}
