package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqq extends AbstractCollection {
    final /* synthetic */ aqr a;

    aqq(aqr aqrVar) {
        this.a = aqrVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        aqr aqrVar = this.a;
        Map mapD = aqrVar.d();
        return mapD != null ? mapD.values().iterator() : new aql(aqrVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.size();
    }
}
