package org.acra.collections;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.acra.collections.ImmutableSet;

/* loaded from: classes.dex */
public final class ImmutableMap<K, V> implements Map<K, V>, Serializable, j$.util.Map {
    private final Map<K, V> mMap;

    @Override // j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map, j$.util.Map, java.util.HashMap
    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public ImmutableMap(java.util.Map<K, V> map) {
        this.mMap = new HashMap(map);
    }

    @Override // java.util.Map, j$.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public boolean containsKey(Object obj) {
        return this.mMap.containsKey(obj);
    }

    @Override // java.util.Map, j$.util.Map
    public boolean containsValue(Object obj) {
        return this.mMap.containsValue(obj);
    }

    @Override // java.util.Map, j$.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> setEntrySet = this.mMap.entrySet();
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        Iterator<Map.Entry<K, V>> it = setEntrySet.iterator();
        while (it.hasNext()) {
            builder.add(new ImmutableEntryWrapper(it.next()));
        }
        return builder.build();
    }

    @Override // java.util.Map, j$.util.Map
    public V get(Object obj) {
        return this.mMap.get(obj);
    }

    @Override // java.util.Map, j$.util.Map
    public boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    @Override // java.util.Map, j$.util.Map
    public Set<K> keySet() {
        return new ImmutableSet(this.mMap.keySet());
    }

    @Override // java.util.Map, j$.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public int size() {
        return this.mMap.size();
    }

    @Override // java.util.Map, j$.util.Map
    public Collection<V> values() {
        return new ImmutableList(this.mMap.values());
    }

    private static class ImmutableEntryWrapper<K, V> implements Map.Entry<K, V>, Map.Entry {
        private final Map.Entry<K, V> mEntry;

        ImmutableEntryWrapper(Map.Entry<K, V> entry) {
            this.mEntry = entry;
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public K getKey() {
            return this.mEntry.getKey();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V getValue() {
            return this.mEntry.getValue();
        }

        @Override // java.util.Map.Entry, j$.util.Map.Entry
        public V setValue(Object obj) {
            throw new UnsupportedOperationException();
        }
    }
}
