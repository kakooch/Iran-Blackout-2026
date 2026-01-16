package com.google.ads.interactivemedia.v3.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class arf implements Iterator, j$.util.Iterator {
    final /* synthetic */ arg a;
    private int b;
    private int c = -1;
    private int d;
    private int e;

    arf(arg argVar) {
        this.a = argVar;
        this.b = ((arh) argVar.b).i;
        arh<K, V> arhVar = argVar.b;
        this.d = arhVar.d;
        this.e = arhVar.c;
    }

    private final void a() {
        if (this.a.b.d != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        a();
        return this.b != -2 && this.e > 0;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = this.a.a(this.b);
        this.c = this.b;
        this.b = ((arh) this.a.b).l[this.b];
        this.e--;
        return objA;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final void remove() {
        a();
        ary.m(this.c != -1);
        arh<K, V> arhVar = this.a.b;
        int i = this.c;
        arhVar.g(i, ary.c(arhVar.a[i]));
        int i2 = this.b;
        arh<K, V> arhVar2 = this.a.b;
        if (i2 == arhVar2.c) {
            this.b = this.c;
        }
        this.c = -1;
        this.d = arhVar2.d;
    }
}
