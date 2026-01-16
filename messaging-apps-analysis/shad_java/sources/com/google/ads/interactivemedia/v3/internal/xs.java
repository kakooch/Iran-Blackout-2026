package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xs extends xt {
    private final xq a;
    private final yb f;

    public xs(cy cyVar, String str, xy xyVar, List<xm> list) {
        super(cyVar, str, xyVar, list);
        Uri.parse(str);
        long j = xyVar.b;
        xq xqVar = j <= 0 ? null : new xq(null, xyVar.a, j);
        this.a = xqVar;
        this.f = xqVar == null ? new yb(new xq(null, 0L, -1L)) : null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xt
    public final xq k() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xt
    public final wx l() {
        return this.f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.xt
    public final String m() {
        return null;
    }
}
