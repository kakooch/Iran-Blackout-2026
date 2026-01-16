package com.google.ads.interactivemedia.v3.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
abstract class aqn<T> implements Iterator<T>, j$.util.Iterator {
    int b;
    int c;
    int d = -1;
    final /* synthetic */ aqr e;

    /* synthetic */ aqn(aqr aqrVar) {
        this.e = aqrVar;
        this.b = aqrVar.f;
        this.c = aqrVar.g();
    }

    private final void b() {
        if (this.e.f != this.b) {
            throw new ConcurrentModificationException();
        }
    }

    abstract T a(int i);

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        return this.c >= 0;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final T next() {
        b();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.c;
        this.d = i;
        T tA = a(i);
        this.c = this.e.h(this.c);
        return tA;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final void remove() {
        b();
        ary.m(this.d >= 0);
        this.b += 32;
        aqr aqrVar = this.e;
        aqrVar.remove(aqrVar.b[this.d]);
        this.c--;
        this.d = -1;
    }
}
