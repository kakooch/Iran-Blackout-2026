package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class asf<K, V> extends arx<Map.Entry<K, V>> {
    private final transient ars<K, V> a;
    private final transient Object[] b;
    private final transient int c = 0;
    private final transient int d;

    asf(ars<K, V> arsVar, Object[] objArr, int i) {
        this.a = arsVar;
        this.b = objArr;
        this.d = i;
    }

    static /* synthetic */ int p(asf asfVar) {
        int i = asfVar.c;
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx, com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public final asp<Map.Entry<K, V>> listIterator() {
        return e().iterator();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.a.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final boolean f() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arj
    final int g(Object[] objArr) {
        return e().g(objArr);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arx
    final arn<Map.Entry<K, V>> m() {
        return new ase(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.d;
    }
}
