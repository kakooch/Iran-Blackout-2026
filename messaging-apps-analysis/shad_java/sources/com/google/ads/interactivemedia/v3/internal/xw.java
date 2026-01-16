package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xw extends xu {
    final yc e;
    final yc f;
    final long g;

    public xw(xq xqVar, long j, long j2, long j3, long j4, long j5, List<xx> list, long j6, yc ycVar, yc ycVar2, long j7, long j8) {
        super(xqVar, j, j2, j3, j5, list, j6, j7, j8);
        this.e = ycVar;
        this.f = ycVar2;
        this.g = j4;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xu
    public final xq d(xt xtVar, long j) {
        List<xx> list = this.c;
        long j2 = list != null ? list.get((int) (j - this.a)).a : (j - this.a) * this.b;
        yc ycVar = this.f;
        cy cyVar = xtVar.b;
        return new xq(ycVar.b(cyVar.a, j, cyVar.h, j2), 0L, -1L);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xu
    public final int h(long j) {
        List<xx> list = this.c;
        if (list != null) {
            return list.size();
        }
        long j2 = this.g;
        if (j2 != -1) {
            return (int) ((j2 - this.a) + 1);
        }
        if (j != -9223372036854775807L) {
            return (int) aeu.G(j, (this.b * 1000000) / this.i);
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xz
    public final xq i(xt xtVar) {
        yc ycVar = this.e;
        if (ycVar == null) {
            return this.h;
        }
        cy cyVar = xtVar.b;
        return new xq(ycVar.b(cyVar.a, 0L, cyVar.h, 0L), 0L, -1L);
    }
}
