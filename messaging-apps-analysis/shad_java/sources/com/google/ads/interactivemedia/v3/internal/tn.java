package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class tn implements abx {
    private final abx a;
    private final int b;
    private final tm c;
    private final byte[] d;
    private int e;

    public tn(abx abxVar, int i, tm tmVar) {
        ary.o(i > 0);
        this.a = abxVar;
        this.b = i;
        this.c = tmVar;
        this.d = new byte[1];
        this.e = i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.e;
        if (i3 == 0) {
            int i4 = 0;
            if (this.a.a(this.d, 0, 1) != -1) {
                int i5 = (this.d[0] & 255) << 4;
                if (i5 != 0) {
                    byte[] bArr2 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int iA = this.a.a(bArr2, i4, i6);
                        if (iA != -1) {
                            i4 += iA;
                            i6 -= iA;
                        }
                    }
                    while (i5 > 0) {
                        int i7 = i5 - 1;
                        if (bArr2[i7] != 0) {
                            break;
                        }
                        i5 = i7;
                    }
                    if (i5 > 0) {
                        this.c.a(new aee(bArr2, i5));
                    }
                }
                i3 = this.b;
                this.e = i3;
            }
            return -1;
        }
        int iA2 = this.a.a(bArr, i, Math.min(i3, i2));
        if (iA2 != -1) {
            this.e -= iA2;
        }
        return iA2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void b(adh adhVar) {
        ary.t(adhVar);
        this.a.b(adhVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        return this.a.d();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Map<String, List<String>> e() {
        return this.a.e();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() {
        throw new UnsupportedOperationException();
    }
}
