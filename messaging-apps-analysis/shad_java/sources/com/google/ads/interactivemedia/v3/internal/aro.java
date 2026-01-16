package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aro<K, V> extends art<K, V> {
    public final arp<K, V> a() {
        Set<Map.Entry<K, Collection<V>>> setEntrySet = this.a.entrySet();
        if (setEntrySet.isEmpty()) {
            return aqw.a;
        }
        arq arqVar = new arq(setEntrySet.size());
        int size = 0;
        for (Map.Entry<K, Collection<V>> entry : setEntrySet) {
            K key = entry.getKey();
            arn arnVarL = arn.l(entry.getValue());
            if (!arnVarL.isEmpty()) {
                arqVar.b(key, arnVarL);
                size += arnVarL.size();
            }
        }
        return new arp<>(arqVar.a(), size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.ads.interactivemedia.v3.internal.art
    public final /* bridge */ /* synthetic */ void b(Object obj, Iterable iterable) {
        super.b(obj, iterable);
    }

    public final void c(K k, V... vArr) {
        b(k, Arrays.asList(vArr));
    }
}
