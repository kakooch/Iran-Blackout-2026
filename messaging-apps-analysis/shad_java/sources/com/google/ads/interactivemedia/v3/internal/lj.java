package com.google.ads.interactivemedia.v3.internal;

import org.rbmain.messenger.MediaController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class lj extends li {
    private final aee b;
    private final aee c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;

    public lj(kr krVar) {
        super(krVar);
        this.b = new aee(aec.a);
        this.c = new aee(4);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.li
    protected final boolean a(aee aeeVar) throws lh {
        int iN = aeeVar.n();
        int i = iN >> 4;
        int i2 = iN & 15;
        if (i2 == 7) {
            this.g = i;
            return i != 5;
        }
        StringBuilder sb = new StringBuilder(39);
        sb.append("Video format not supported: ");
        sb.append(i2);
        throw new lh(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.li
    protected final boolean b(aee aeeVar, long j) throws dt {
        int iN = aeeVar.n();
        long jS = j + (aeeVar.s() * 1000);
        if (iN == 0) {
            if (!this.e) {
                aee aeeVar2 = new aee(new byte[aeeVar.d()]);
                aeeVar.m(aeeVar2.i(), 0, aeeVar.d());
                aev aevVarA = aev.a(aeeVar2);
                this.d = aevVarA.b;
                cx cxVar = new cx();
                cxVar.ae(MediaController.VIDEO_MIME_TYPE);
                cxVar.aj(aevVarA.c);
                cxVar.Q(aevVarA.d);
                cxVar.aa(aevVarA.e);
                cxVar.T(aevVarA.a);
                this.a.a(cxVar.a());
                this.e = true;
                return false;
            }
        } else if (iN == 1 && this.e) {
            int i = this.g == 1 ? 1 : 0;
            if (!this.f && i == 0) {
                return false;
            }
            byte[] bArrI = this.c.i();
            bArrI[0] = 0;
            bArrI[1] = 0;
            bArrI[2] = 0;
            int i2 = 4 - this.d;
            int i3 = 0;
            while (aeeVar.d() > 0) {
                aeeVar.m(this.c.i(), i2, this.d);
                this.c.h(0);
                int iB = this.c.B();
                this.b.h(0);
                this.a.d(this.b, 4);
                this.a.d(aeeVar, iB);
                i3 = i3 + 4 + iB;
            }
            this.a.b(jS, i, i3, 0, null);
            this.f = true;
            return true;
        }
        return false;
    }
}
