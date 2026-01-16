package ir.nasim;

import ir.nasim.AbstractC7611Sl4;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.p1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC18649p1 implements InterfaceC7143Ql4 {
    private transient Collection a;
    private transient Set b;
    private transient Collection c;
    private transient Map d;

    /* renamed from: ir.nasim.p1$a */
    class a extends AbstractC7611Sl4.b {
        a() {
        }

        @Override // ir.nasim.AbstractC7611Sl4.b
        InterfaceC7143Ql4 f() {
            return AbstractC18649p1.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC18649p1.this.k();
        }
    }

    /* renamed from: ir.nasim.p1$b */
    class b extends AbstractCollection {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC18649p1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC18649p1.this.d(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC18649p1.this.m();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractC18649p1.this.size();
        }
    }

    AbstractC18649p1() {
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public Collection a() {
        Collection collection = this.a;
        if (collection != null) {
            return collection;
        }
        Collection collectionF = f();
        this.a = collectionF;
        return collectionF;
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public Map b() {
        Map map = this.d;
        if (map != null) {
            return map;
        }
        Map mapE = e();
        this.d = mapE;
        return mapE;
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public boolean c(Object obj, Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean d(Object obj) {
        Iterator it = b().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map e();

    public boolean equals(Object obj) {
        return AbstractC7611Sl4.a(this, obj);
    }

    abstract Collection f();

    abstract Set g();

    public int hashCode() {
        return b().hashCode();
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public boolean isEmpty() {
        return size() == 0;
    }

    abstract Collection j();

    abstract Iterator k();

    public Set l() {
        Set set = this.b;
        if (set != null) {
            return set;
        }
        Set setG = g();
        this.b = setG;
        return setG;
    }

    abstract Iterator m();

    @Override // ir.nasim.InterfaceC7143Ql4
    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) b().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return b().toString();
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public Collection values() {
        Collection collection = this.c;
        if (collection != null) {
            return collection;
        }
        Collection collectionJ = j();
        this.c = collectionJ;
        return collectionJ;
    }
}
