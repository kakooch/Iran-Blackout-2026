package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.Au6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC3422Au6 implements Set, InterfaceC17915nm3 {
    private final AbstractC22658vc6 a;

    public AbstractC3422Au6(AbstractC22658vc6 abstractC22658vc6) {
        AbstractC13042fc3.i(abstractC22658vc6, "parent");
        this.a = abstractC22658vc6;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.a(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        AbstractC13042fc3.i(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.a.a(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return AbstractC13042fc3.d(this.a, ((AbstractC3422Au6) obj).a);
    }

    public int f() {
        return this.a.d;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.a.d();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return UW0.a(this);
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "array");
        return UW0.b(this, objArr);
    }
}
