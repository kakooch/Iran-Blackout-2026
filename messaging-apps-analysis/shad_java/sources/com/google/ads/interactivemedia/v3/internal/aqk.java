package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqk extends aqn<Map.Entry> {
    final /* synthetic */ aqr a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aqk(aqr aqrVar) {
        super(aqrVar);
        this.a = aqrVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqn
    final /* bridge */ /* synthetic */ Map.Entry a(int i) {
        return new aqp(this.a, i);
    }
}
