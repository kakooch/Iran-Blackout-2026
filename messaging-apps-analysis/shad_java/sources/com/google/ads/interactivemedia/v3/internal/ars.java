package com.google.ads.interactivemedia.v3.internal;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ars<K, V> implements Map<K, V>, Serializable, j$.util.Map {
    private transient arx<Map.Entry<K, V>> a;
    private transient arx<K> b;
    private transient arj<V> c;

    ars() {
    }

    public static <K, V> ars<K, V> a() {
        return (ars<K, V>) asi.a;
    }

    public static <K, V> ars<K, V> b(K k, V v) {
        ary.l(k, v);
        return asi.k(1, new Object[]{k, v});
    }

    public static <K, V> arq<K, V> c() {
        return new arq<>();
    }

    public static <K, V> ars<K, V> d(Map<? extends K, ? extends V> map) {
        if ((map instanceof ars) && !(map instanceof SortedMap)) {
            ars<K, V> arsVar = (ars) map;
            if (!arsVar.j()) {
                return arsVar;
            }
        }
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        arq arqVar = new arq(setEntrySet instanceof Collection ? setEntrySet.size() : 4);
        arqVar.c(setEntrySet);
        return arqVar.a();
    }

    @Override // java.util.Map, j$.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

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

    @Override // java.util.Map, j$.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map, j$.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final arx<Map.Entry<K, V>> entrySet() {
        arx<Map.Entry<K, V>> arxVar = this.a;
        if (arxVar != null) {
            return arxVar;
        }
        arx<Map.Entry<K, V>> arxVarF = f();
        this.a = arxVarF;
        return arxVarF;
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof java.util.Map) {
            return entrySet().equals(((java.util.Map) obj).entrySet());
        }
        return false;
    }

    abstract arx<Map.Entry<K, V>> f();

    @Override // j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    abstract arx<K> g();

    @Override // java.util.Map, j$.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map, j$.util.Map
    public final V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map, j$.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final arj<V> values() {
        arj<V> arjVar = this.c;
        if (arjVar != null) {
            return arjVar;
        }
        arj<V> arjVarI = i();
        this.c = arjVarI;
        return arjVarI;
    }

    @Override // java.util.Map, j$.util.Map
    public final int hashCode() {
        return asn.a(entrySet());
    }

    abstract arj<V> i();

    @Override // java.util.Map, j$.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    abstract boolean j();

    @Override // java.util.Map, j$.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        arx<K> arxVar = this.b;
        if (arxVar != null) {
            return arxVar;
        }
        arx<K> arxVarG = g();
        this.b = arxVarG;
        return arxVarG;
    }

    @Override // j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    @Deprecated
    public final void putAll(java.util.Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
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

    public final String toString() {
        int size = size();
        ary.n(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    Object writeReplace() {
        return new arr(this);
    }
}
