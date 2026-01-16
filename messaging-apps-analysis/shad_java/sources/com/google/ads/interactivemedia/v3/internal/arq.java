package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class arq<K, V> {
    Object[] a;
    int b;

    public arq() {
        this(4);
    }

    private final void d(int i) {
        int i2 = i + i;
        Object[] objArr = this.a;
        int length = objArr.length;
        if (i2 > length) {
            this.a = Arrays.copyOf(objArr, ari.a(length, i2));
        }
    }

    public final ars<K, V> a() {
        return asi.k(this.b, this.a);
    }

    public final void b(K k, V v) {
        d(this.b + 1);
        ary.l(k, v);
        Object[] objArr = this.a;
        int i = this.b;
        int i2 = i + i;
        objArr[i2] = k;
        objArr[i2 + 1] = v;
        this.b = i + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            d(this.b + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            b(entry.getKey(), entry.getValue());
        }
    }

    arq(int i) {
        this.a = new Object[i + i];
        this.b = 0;
    }
}
