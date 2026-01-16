package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
    @Override // com.google.common.collect.Multimap
    public abstract Map<K, Collection<V>> asMap();

    AbstractMultimap() {
    }

    public boolean equals(Object obj) {
        return Multimaps.equalsImpl(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }
}
