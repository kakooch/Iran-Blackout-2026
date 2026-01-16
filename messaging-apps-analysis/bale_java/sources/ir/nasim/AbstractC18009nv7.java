package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.nv7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC18009nv7 implements Iterator {
    final Iterator a;

    AbstractC18009nv7(Iterator it) {
        this.a = (Iterator) AbstractC4029Dj5.j(it);
    }

    abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
