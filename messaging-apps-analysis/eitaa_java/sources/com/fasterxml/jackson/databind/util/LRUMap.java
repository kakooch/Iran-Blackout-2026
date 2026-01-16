package com.fasterxml.jackson.databind.util;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;

/* loaded from: classes.dex */
public class LRUMap<K, V> implements LookupCache<K, V>, Serializable {
    protected final transient ConcurrentHashMap<K, V> _map;
    protected final transient int _maxEntries;

    public LRUMap(int i, int i2) {
        this._map = new ConcurrentHashMap<>(i, 0.8f, 4);
        this._maxEntries = i2;
    }

    public V put(K k, V v) {
        if (this._map.size() >= this._maxEntries) {
            synchronized (this) {
                if (this._map.size() >= this._maxEntries) {
                    clear();
                }
            }
        }
        return (V) this._map.put(k, v);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public V putIfAbsent(K k, V v) {
        if (this._map.size() >= this._maxEntries) {
            synchronized (this) {
                if (this._map.size() >= this._maxEntries) {
                    clear();
                }
            }
        }
        return (V) this._map.putIfAbsent(k, v);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public V get(Object obj) {
        return (V) this._map.get(obj);
    }

    public void clear() {
        this._map.clear();
    }
}
