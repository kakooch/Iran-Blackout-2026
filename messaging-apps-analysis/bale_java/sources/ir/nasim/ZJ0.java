package ir.nasim;

import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class ZJ0 implements Iterator, InterfaceC17915nm3 {
    public abstract char b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Character.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
