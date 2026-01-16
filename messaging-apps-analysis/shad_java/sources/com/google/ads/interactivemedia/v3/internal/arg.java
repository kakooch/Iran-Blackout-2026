package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
abstract class arg<K, V, T> extends AbstractSet<T> {
    final arh<K, V> b;

    arg(arh<K, V> arhVar) {
        this.b = arhVar;
    }

    abstract T a(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<T> iterator() {
        return new arf(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.b.c;
    }
}
