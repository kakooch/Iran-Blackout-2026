package ir.nasim;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class In8 implements Iterator {
    private Iterator a;
    private final /* synthetic */ Gn8 b;

    In8(Gn8 gn8) {
        this.b = gn8;
        this.a = gn8.a.iterator();
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
