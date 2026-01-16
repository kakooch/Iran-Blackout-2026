package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.fJ3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC12869fJ3 implements Iterator, InterfaceC17915nm3 {
    public abstract long b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
