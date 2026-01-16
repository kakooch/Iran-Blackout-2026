package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class nt extends nr {
    private ns a;
    private int b;
    private boolean c;
    private kv d;
    private kt e;

    nt() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final void a(boolean z) {
        super.a(z);
        if (z) {
            this.a = null;
            this.d = null;
            this.e = null;
        }
        this.b = 0;
        this.c = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final long b(aee aeeVar) {
        if ((aeeVar.i()[0] & 1) == 1) {
            return -1L;
        }
        byte b = aeeVar.i()[0];
        ns nsVar = this.a;
        int i = !nsVar.c[(b >> 1) & (255 >>> (8 - nsVar.d))].a ? nsVar.a.e : nsVar.a.f;
        long j = this.c ? (this.b + i) / 4 : 0;
        if (aeeVar.j() < aeeVar.e() + 4) {
            aeeVar.b(Arrays.copyOf(aeeVar.i(), aeeVar.e() + 4));
        } else {
            aeeVar.f(aeeVar.e() + 4);
        }
        byte[] bArrI = aeeVar.i();
        bArrI[aeeVar.e() - 4] = (byte) (j & 255);
        bArrI[aeeVar.e() - 3] = (byte) ((j >>> 8) & 255);
        bArrI[aeeVar.e() - 2] = (byte) ((j >>> 16) & 255);
        bArrI[aeeVar.e() - 1] = (byte) ((j >>> 24) & 255);
        this.c = true;
        this.b = i;
        return j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final boolean c(aee aeeVar, long j, np npVar) throws IOException {
        if (this.a != null) {
            return false;
        }
        ns nsVar = null;
        if (this.d == null) {
            atv.o(1, aeeVar, false);
            aeeVar.C();
            int iN = aeeVar.n();
            int iC = aeeVar.C();
            int iW = aeeVar.w();
            int i = iW <= 0 ? -1 : iW;
            int iW2 = aeeVar.w();
            int i2 = iW2 <= 0 ? -1 : iW2;
            aeeVar.w();
            int iN2 = aeeVar.n();
            double dPow = Math.pow(2.0d, iN2 & 15);
            double dPow2 = Math.pow(2.0d, (iN2 & 240) >> 4);
            aeeVar.n();
            this.d = new kv(iN, iC, i, i2, (int) dPow, (int) dPow2, Arrays.copyOf(aeeVar.i(), aeeVar.e()));
        } else if (this.e == null) {
            this.e = atv.n(aeeVar, true, true);
        } else {
            byte[] bArr = new byte[aeeVar.e()];
            System.arraycopy(aeeVar.i(), 0, bArr, 0, aeeVar.e());
            nsVar = new ns(this.d, bArr, atv.p(aeeVar, this.d.a), atv.m(r1.length - 1));
        }
        this.a = nsVar;
        if (nsVar == null) {
            return true;
        }
        kv kvVar = nsVar.a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(kvVar.g);
        arrayList.add(this.a.b);
        cx cxVar = new cx();
        cxVar.ae("audio/vorbis");
        cxVar.G(kvVar.d);
        cxVar.Z(kvVar.c);
        cxVar.H(kvVar.a);
        cxVar.af(kvVar.b);
        cxVar.T(arrayList);
        npVar.a = cxVar.a();
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.nr
    protected final void i(long j) {
        super.i(j);
        this.c = j != 0;
        kv kvVar = this.d;
        this.b = kvVar != null ? kvVar.e : 0;
    }
}
