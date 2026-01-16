package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class art<K, V> {
    final Map<K, Collection<V>> a = aqr.a();

    public void b(K k, Iterable<? extends V> iterable) {
        Collection<V> collection = this.a.get(k);
        if (collection != null) {
            for (V v : iterable) {
                ary.l(k, v);
                collection.add(v);
            }
            return;
        }
        Iterator<? extends V> it = iterable.iterator();
        if (it.hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                V next = it.next();
                ary.l(k, next);
                arrayList.add(next);
            }
            this.a.put(k, arrayList);
        }
    }
}
