package ir.nasim;

import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.e55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12131e55 extends AbstractC15103j1 {
    private final AbstractC10724c55 a;

    public C12131e55(AbstractC10724c55 abstractC10724c55) {
        this.a = abstractC10724c55;
    }

    @Override // ir.nasim.AbstractC15103j1
    public boolean C(Map.Entry entry) {
        Object obj = this.a.get(entry.getKey());
        return obj != null ? AbstractC13042fc3.d(obj, entry.getValue()) : entry.getValue() == null && this.a.containsKey(entry.getKey());
    }

    @Override // ir.nasim.AbstractC15103j1
    public boolean F(Map.Entry entry) {
        return this.a.remove(entry.getKey(), entry.getValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry entry) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // ir.nasim.AbstractC21043t1
    public int f() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new C12722f55(this.a);
    }
}
