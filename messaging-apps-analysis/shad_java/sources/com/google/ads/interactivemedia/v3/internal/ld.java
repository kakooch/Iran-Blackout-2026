package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import org.rbmain.messenger.MediaController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ld extends li {
    private static final int[] b = {5512, 11025, 22050, 44100};
    private boolean c;
    private boolean d;
    private int e;

    public ld(kr krVar) {
        super(krVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.li
    protected final boolean a(aee aeeVar) throws lh {
        if (this.c) {
            aeeVar.k(1);
        } else {
            int iN = aeeVar.n();
            int i = iN >> 4;
            this.e = i;
            if (i == 2) {
                int i2 = b[(iN >> 2) & 3];
                cx cxVar = new cx();
                cxVar.ae("audio/mpeg");
                cxVar.H(1);
                cxVar.af(i2);
                this.a.a(cxVar.a());
                this.d = true;
            } else if (i == 7 || i == 8) {
                String str = i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                cx cxVar2 = new cx();
                cxVar2.ae(str);
                cxVar2.H(1);
                cxVar2.af(8000);
                this.a.a(cxVar2.a());
                this.d = true;
            } else if (i != 10) {
                StringBuilder sb = new StringBuilder(39);
                sb.append("Audio format not supported: ");
                sb.append(i);
                throw new lh(sb.toString());
            }
            this.c = true;
        }
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.li
    protected final boolean b(aee aeeVar, long j) throws dt {
        if (this.e == 2) {
            int iD = aeeVar.d();
            this.a.d(aeeVar, iD);
            this.a.b(j, 1, iD, 0, null);
            return true;
        }
        int iN = aeeVar.n();
        if (iN != 0 || this.d) {
            if (this.e == 10 && iN != 1) {
                return false;
            }
            int iD2 = aeeVar.d();
            this.a.d(aeeVar, iD2);
            this.a.b(j, 1, iD2, 0, null);
            return true;
        }
        int iD3 = aeeVar.d();
        byte[] bArr = new byte[iD3];
        aeeVar.m(bArr, 0, iD3);
        gm gmVarA = gn.a(bArr);
        cx cxVar = new cx();
        cxVar.ae(MediaController.AUIDO_MIME_TYPE);
        cxVar.I(gmVarA.c);
        cxVar.H(gmVarA.b);
        cxVar.af(gmVarA.a);
        cxVar.T(Collections.singletonList(bArr));
        this.a.a(cxVar.a());
        this.d = true;
        return false;
    }
}
