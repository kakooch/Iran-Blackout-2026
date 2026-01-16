package com.google.ads.interactivemedia.v3.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
abstract class aia<T> implements Iterator<T>, j$.util.Iterator {
    aib a;
    aib b = null;
    int c;
    final /* synthetic */ aic d;

    aia(aic aicVar) {
        this.d = aicVar;
        this.a = aicVar.e.d;
        this.c = aicVar.d;
    }

    final aib a() {
        aib aibVar = this.a;
        aic aicVar = this.d;
        if (aibVar == aicVar.e) {
            throw new NoSuchElementException();
        }
        if (aicVar.d != this.c) {
            throw new ConcurrentModificationException();
        }
        this.a = aibVar.d;
        this.b = aibVar;
        return aibVar;
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        return this.a != this.d.e;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final void remove() {
        aib aibVar = this.b;
        if (aibVar == null) {
            throw new IllegalStateException();
        }
        this.d.d(aibVar, true);
        this.b = null;
        this.c = this.d.d;
    }
}
