package ir.nasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.uh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C22120uh8 implements Iterator {
    final /* synthetic */ Iterator a;
    final /* synthetic */ Iterator b;

    C22120uh8(Ch8 ch8, Iterator it, Iterator it2) {
        this.a = it;
        this.b = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a.hasNext()) {
            return true;
        }
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (this.a.hasNext()) {
            return new Ei8(((Integer) this.a.next()).toString());
        }
        if (this.b.hasNext()) {
            return new Ei8((String) this.b.next());
        }
        throw new NoSuchElementException();
    }
}
