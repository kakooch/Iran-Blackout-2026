package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.clearcut.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2083g implements Iterator {
    private int a = 0;
    private final int b;
    private final /* synthetic */ AbstractC2081f c;

    C2083g(AbstractC2081f abstractC2081f) {
        this.c = abstractC2081f;
        this.b = abstractC2081f.size();
    }

    private final byte j() {
        try {
            AbstractC2081f abstractC2081f = this.c;
            int i = this.a;
            this.a = i + 1;
            return abstractC2081f.N(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(j());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
