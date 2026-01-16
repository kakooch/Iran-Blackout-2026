package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqo extends AbstractSet {
    final /* synthetic */ aqr a;

    aqo(aqr aqrVar) {
        this.a = aqrVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        aqr aqrVar = this.a;
        Map mapD = aqrVar.d();
        return mapD != null ? mapD.keySet().iterator() : new aqj(aqrVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapD = this.a.d();
        return mapD != null ? mapD.keySet().remove(obj) : this.a.u(obj) != aqr.d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }
}
