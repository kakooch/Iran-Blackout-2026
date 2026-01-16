package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class zo implements zx {
    private final zx a;
    private final List<sr> b;

    public zo(zx zxVar, List<sr> list) {
        this.a = zxVar;
        this.b = list;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zx
    public final adc<zu> a() {
        return new sp(this.a.a(), this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zx
    public final adc<zu> b(zr zrVar) {
        return new sp(this.a.b(zrVar), this.b);
    }
}
