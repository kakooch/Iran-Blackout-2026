package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aev {
    public final List<byte[]> a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    private aev(List<byte[]> list, int i, int i2, int i3, float f) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    public static aev a(aee aeeVar) throws dt {
        int i;
        int i2;
        float f;
        try {
            aeeVar.k(4);
            int iN = (aeeVar.n() & 3) + 1;
            if (iN == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iN2 = aeeVar.n() & 31;
            for (int i3 = 0; i3 < iN2; i3++) {
                arrayList.add(b(aeeVar));
            }
            int iN3 = aeeVar.n();
            for (int i4 = 0; i4 < iN3; i4++) {
                arrayList.add(b(aeeVar));
            }
            if (iN2 > 0) {
                aeb aebVarB = aec.b((byte[]) arrayList.get(0), iN, ((byte[]) arrayList.get(0)).length);
                int i5 = aebVarB.e;
                int i6 = aebVarB.f;
                f = aebVarB.g;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new aev(arrayList, iN, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new dt("Error parsing AVC config", e);
        }
    }

    private static byte[] b(aee aeeVar) {
        int iO = aeeVar.o();
        int iG = aeeVar.g();
        aeeVar.k(iO);
        return adl.a(aeeVar.i(), iG, iO);
    }
}
