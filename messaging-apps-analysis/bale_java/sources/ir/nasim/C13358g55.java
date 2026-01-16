package ir.nasim;

import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.g55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13358g55 extends AbstractC21043t1 implements Set, InterfaceC24531ym3 {
    private final AbstractC10724c55 a;

    public C13358g55(AbstractC10724c55 abstractC10724c55) {
        this.a = abstractC10724c55;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // ir.nasim.AbstractC21043t1
    public int f() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new C13949h55(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (!this.a.containsKey(obj)) {
            return false;
        }
        this.a.remove(obj);
        return true;
    }
}
