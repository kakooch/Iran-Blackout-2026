package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.hs8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C14418hs8 implements Iterator {
    private Iterator a;
    private final /* synthetic */ Tr8 b;

    C14418hs8(Tr8 tr8) {
        this.b = tr8;
        this.a = tr8.a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return (String) this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
