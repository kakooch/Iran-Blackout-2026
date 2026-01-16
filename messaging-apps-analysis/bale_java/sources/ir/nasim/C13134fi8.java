package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.fi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C13134fi8 implements Iterator {
    final /* synthetic */ Iterator a;

    C13134fi8(Iterator it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new Ei8((String) this.a.next());
    }
}
