package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class wt {
    public final boolean a;
    public final long b;
    public final long c;

    private wt(boolean z, long j, long j2) {
        this.a = z;
        this.b = j;
        this.c = j2;
    }

    public static wt a(xo xoVar, long j, long j2) {
        boolean z;
        xo xoVar2 = xoVar;
        long j3 = j2;
        int size = xoVar2.c.size();
        for (int i = 0; i < size; i++) {
            int i2 = xoVar2.c.get(i).b;
            if (i2 == 1 || i2 == 2) {
                z = true;
                break;
            }
        }
        z = false;
        long jMin = Long.MAX_VALUE;
        boolean zJ = false;
        boolean z2 = false;
        int i3 = 0;
        long jMax = 0;
        while (i3 < size) {
            xi xiVar = xoVar2.c.get(i3);
            List<xt> list = xiVar.c;
            if ((!z || xiVar.b != 3) && !list.isEmpty()) {
                wx wxVarL = list.get(0).l();
                if (wxVarL == null) {
                    return new wt(true, 0L, j);
                }
                zJ |= wxVarL.j();
                int iH = wxVarL.h(j, j3);
                if (iH == 0) {
                    jMin = 0;
                    z2 = true;
                    jMax = 0;
                } else if (!z2) {
                    long jF = wxVarL.f(j, j3);
                    jMax = Math.max(jMax, wxVarL.b(jF));
                    long j4 = (jF + iH) - 1;
                    jMin = Math.min(jMin, wxVarL.b(j4) + wxVarL.c(j4, j));
                    z2 = z2;
                    zJ = zJ;
                }
            }
            i3++;
            xoVar2 = xoVar;
            j3 = j2;
        }
        return new wt(true == zJ, jMax, jMin);
    }
}
