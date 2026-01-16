package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.util.Base64;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class abv extends abr {
    private acb a;
    private byte[] b;
    private int c;
    private int d;

    public abv() {
        super(false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.c - this.d;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        System.arraycopy(aeu.f(this.b), this.d, bArr, i, iMin);
        this.d += iMin;
        i(iMin);
        return iMin;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) throws IOException {
        g(acbVar);
        this.a = acbVar;
        this.d = (int) acbVar.e;
        Uri uri = acbVar.a;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            String strValueOf = String.valueOf(scheme);
            throw new dt(strValueOf.length() != 0 ? "Unsupported scheme: ".concat(strValueOf) : new String("Unsupported scheme: "));
        }
        String[] strArrZ = aeu.z(uri.getSchemeSpecificPart(), ",");
        if (strArrZ.length != 2) {
            String strValueOf2 = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(strValueOf2.length() + 23);
            sb.append("Unexpected URI format: ");
            sb.append(strValueOf2);
            throw new dt(sb.toString());
        }
        String str = strArrZ[1];
        if (strArrZ[0].contains(";base64")) {
            try {
                this.b = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                String strValueOf3 = String.valueOf(str);
                throw new dt(strValueOf3.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(strValueOf3) : new String("Error while parsing Base64 encoded string: "), e);
            }
        } else {
            this.b = aeu.y(URLDecoder.decode(str, apv.a.name()));
        }
        long j = acbVar.f;
        int length = j != -1 ? ((int) j) + this.d : this.b.length;
        this.c = length;
        if (length > this.b.length || this.d > length) {
            this.b = null;
            throw new aby();
        }
        h(acbVar);
        return this.c - this.d;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        acb acbVar = this.a;
        if (acbVar != null) {
            return acbVar.a;
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() {
        if (this.b != null) {
            this.b = null;
            j();
        }
        this.a = null;
    }
}
