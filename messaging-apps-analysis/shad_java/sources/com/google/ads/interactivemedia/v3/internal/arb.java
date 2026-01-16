package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class arb<K, V> extends AbstractMap<V, K> implements Serializable, aqi {
    private final arh<K, V> a;
    private transient Set<Map.Entry<V, K>> b;

    arb(arh<K, V> arhVar) {
        this.a = arhVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        ((arh) this.a).p = this;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<V, K>> entrySet() {
        Set<Map.Entry<V, K>> set = this.b;
        if (set != null) {
            return set;
        }
        arc arcVar = new arc(this.a);
        this.b = arcVar;
        return arcVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final K get(Object obj) {
        arh<K, V> arhVar = this.a;
        int iD = arhVar.d(obj);
        if (iD == -1) {
            return null;
        }
        return arhVar.a[iD];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<V> keySet() {
        return this.a.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final K put(V v, K k) {
        return this.a.q(v, k);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final K remove(Object obj) {
        arh<K, V> arhVar = this.a;
        int iC = ary.c(obj);
        int iE = arhVar.e(obj, iC);
        if (iE == -1) {
            return null;
        }
        K k = arhVar.a[iE];
        arhVar.h(iE, iC);
        return k;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.a.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return this.a.keySet();
    }
}
