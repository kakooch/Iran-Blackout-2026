package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class arz extends asp {
    boolean a;
    final /* synthetic */ Object b;

    arz(Object obj) {
        this.b = obj;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final boolean hasNext() {
        return !this.a;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final Object next() {
        if (this.a) {
            throw new NoSuchElementException();
        }
        this.a = true;
        return this.b;
    }
}
