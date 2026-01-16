package ir.nasim;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.fu6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13252fu6 extends AbstractC21043t1 implements Set, Serializable, InterfaceC24531ym3 {
    private static final a b = new a(null);
    private static final C13252fu6 c = new C13252fu6(JN3.n.e());
    private final JN3 a;

    /* renamed from: ir.nasim.fu6$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C13252fu6(JN3 jn3) {
        AbstractC13042fc3.i(jn3, "backing");
        this.a = jn3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.a.l(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        this.a.q();
        return super.addAll(collection);
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.a.R();
    }

    public final Set j() {
        this.a.p();
        return size() > 0 ? this : c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.a.a0(obj);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        this.a.q();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        this.a.q();
        return super.retainAll(collection);
    }

    public C13252fu6() {
        this(new JN3());
    }
}
