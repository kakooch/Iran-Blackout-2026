package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class afb {
    public final List<byte[]> a;
    public final int b;

    private afb(List<byte[]> list, int i) {
        this.a = list;
        this.b = i;
    }

    public static afb a(aee aeeVar) throws dt {
        try {
            aeeVar.k(21);
            int iN = aeeVar.n() & 3;
            int iN2 = aeeVar.n();
            int iG = aeeVar.g();
            int i = 0;
            for (int i2 = 0; i2 < iN2; i2++) {
                aeeVar.k(1);
                int iO = aeeVar.o();
                for (int i3 = 0; i3 < iO; i3++) {
                    int iO2 = aeeVar.o();
                    i += iO2 + 4;
                    aeeVar.k(iO2);
                }
            }
            aeeVar.h(iG);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < iN2; i5++) {
                aeeVar.k(1);
                int iO3 = aeeVar.o();
                for (int i6 = 0; i6 < iO3; i6++) {
                    int iO4 = aeeVar.o();
                    System.arraycopy(aec.a, 0, bArr, i4, 4);
                    int i7 = i4 + 4;
                    System.arraycopy(aeeVar.i(), aeeVar.g(), bArr, i7, iO4);
                    i4 = i7 + iO4;
                    aeeVar.k(iO4);
                }
            }
            return new afb(i == 0 ? null : Collections.singletonList(bArr), iN + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new dt("Error parsing HEVC config", e);
        }
    }
}
