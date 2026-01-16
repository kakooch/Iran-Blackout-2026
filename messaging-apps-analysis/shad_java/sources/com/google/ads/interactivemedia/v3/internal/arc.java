package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class arc<K, V> extends arg<K, V, Map.Entry<V, K>> {
    arc(arh<K, V> arhVar) {
        super(arhVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.arg
    final /* bridge */ /* synthetic */ Object a(int i) {
        return new aqz(this.b, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iD = this.b.d(key);
            if (iD != -1 && apz.b(this.b.a[iD], value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        int iC = ary.c(key);
        int iE = this.b.e(key, iC);
        if (iE == -1 || !apz.b(this.b.a[iE], value)) {
            return false;
        }
        this.b.h(iE, iC);
        return true;
    }
}
