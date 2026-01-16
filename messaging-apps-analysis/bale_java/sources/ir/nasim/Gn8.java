package ir.nasim;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class Gn8 extends AbstractList implements Hl8, RandomAccess {
    private final Hl8 a;

    public Gn8(Hl8 hl8) {
        this.a = hl8;
    }

    @Override // ir.nasim.Hl8
    public final List d1() {
        return this.a.d1();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.a.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new In8(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new Hn8(this, i);
    }

    @Override // ir.nasim.Hl8
    public final Object q(int i) {
        return this.a.q(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }

    @Override // ir.nasim.Hl8
    public final Hl8 O1() {
        return this;
    }
}
