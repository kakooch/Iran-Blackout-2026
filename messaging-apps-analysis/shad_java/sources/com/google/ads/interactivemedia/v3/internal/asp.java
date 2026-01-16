package com.google.ads.interactivemedia.v3.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class asp<E> implements Iterator<E>, j$.util.Iterator {
    protected asp() {
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator, j$.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
