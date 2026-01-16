package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aib<K, V> implements Map.Entry<K, V> {
    aib<K, V> a;
    aib<K, V> b;
    aib<K, V> c;
    aib<K, V> d;
    aib<K, V> e;
    final K f;
    V g;
    int h;

    aib() {
        this.f = null;
        this.e = this;
        this.d = this;
    }

    aib(aib<K, V> aibVar, K k, aib<K, V> aibVar2, aib<K, V> aibVar3) {
        this.a = aibVar;
        this.f = k;
        this.h = 1;
        this.d = aibVar2;
        this.e = aibVar3;
        aibVar3.d = this;
        aibVar2.e = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f;
            if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                V v = this.g;
                if (v == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (v.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        K k = this.f;
        int iHashCode = k == null ? 0 : k.hashCode();
        V v = this.g;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        V v2 = this.g;
        this.g = v;
        return v2;
    }

    public final String toString() {
        return this.f + "=" + this.g;
    }
}
