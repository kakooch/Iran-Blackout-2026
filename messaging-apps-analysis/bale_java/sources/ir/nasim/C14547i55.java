package ir.nasim;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: ir.nasim.i55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14547i55 extends AbstractC19240q1 implements Collection, InterfaceC18506om3 {
    private final AbstractC10724c55 a;

    public C14547i55(AbstractC10724c55 abstractC10724c55) {
        this.a = abstractC10724c55;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // ir.nasim.AbstractC19240q1
    public int f() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new C15149j55(this.a);
    }
}
