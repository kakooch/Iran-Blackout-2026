package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.oa3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18386oa3 implements Iterator, InterfaceC17915nm3 {
    public abstract int b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
