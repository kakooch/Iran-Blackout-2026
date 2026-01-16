package ir.nasim;

import ir.nasim.XW0;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: ir.nasim.Cu6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3895Cu6 {

    /* renamed from: ir.nasim.Cu6$a */
    class a extends e {
        final /* synthetic */ Set a;
        final /* synthetic */ Set b;

        /* renamed from: ir.nasim.Cu6$a$a, reason: collision with other inner class name */
        class C0313a extends X0 {
            final Iterator c;

            C0313a() {
                this.c = a.this.a.iterator();
            }

            @Override // ir.nasim.X0
            protected Object a() {
                while (this.c.hasNext()) {
                    Object next = this.c.next();
                    if (a.this.b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.a = set;
            this.b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.contains(obj) && this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return this.a.containsAll(collection) && this.b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public DB7 iterator() {
            return new C0313a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.b, this.a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator it = this.a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.b.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* renamed from: ir.nasim.Cu6$b */
    private static class b extends XW0.a implements Set {
        b(Set set, InterfaceC11281ck5 interfaceC11281ck5) {
            super(set, interfaceC11281ck5);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return AbstractC3895Cu6.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return AbstractC3895Cu6.d(this);
        }
    }

    /* renamed from: ir.nasim.Cu6$c */
    private static class c extends b implements SortedSet {
        c(SortedSet sortedSet, InterfaceC11281ck5 interfaceC11281ck5) {
            super(sortedSet, interfaceC11281ck5);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return ((SortedSet) this.a).comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return AbstractC17855ng3.h(this.a.iterator(), this.b);
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return new c(((SortedSet) this.a).headSet(obj), this.b);
        }

        @Override // java.util.SortedSet
        public Object last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.a;
            while (true) {
                Object objLast = sortedSetHeadSet.last();
                if (this.b.apply(objLast)) {
                    return objLast;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return new c(((SortedSet) this.a).subSet(obj, obj2), this.b);
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return new c(((SortedSet) this.a).tailSet(obj), this.b);
        }
    }

    /* renamed from: ir.nasim.Cu6$d */
    static abstract class d extends AbstractSet {
        d() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return AbstractC3895Cu6.i(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return super.retainAll((Collection) AbstractC4029Dj5.j(collection));
        }
    }

    /* renamed from: ir.nasim.Cu6$e */
    public static abstract class e extends AbstractSet {
        /* synthetic */ e(AbstractC3661Bu6 abstractC3661Bu6) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        private e() {
        }
    }

    static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static Set b(Set set, InterfaceC11281ck5 interfaceC11281ck5) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, interfaceC11281ck5);
        }
        if (!(set instanceof b)) {
            return new b((Set) AbstractC4029Dj5.j(set), (InterfaceC11281ck5) AbstractC4029Dj5.j(interfaceC11281ck5));
        }
        b bVar = (b) set;
        return new b((Set) bVar.a, AbstractC11903dk5.b(bVar.b, interfaceC11281ck5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SortedSet c(SortedSet sortedSet, InterfaceC11281ck5 interfaceC11281ck5) {
        if (!(sortedSet instanceof b)) {
            return new c((SortedSet) AbstractC4029Dj5.j(sortedSet), (InterfaceC11281ck5) AbstractC4029Dj5.j(interfaceC11281ck5));
        }
        b bVar = (b) sortedSet;
        return new c((SortedSet) bVar.a, AbstractC11903dk5.b(bVar.b, interfaceC11281ck5));
    }

    static int d(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static e e(Set set, Set set2) {
        AbstractC4029Dj5.k(set, "set1");
        AbstractC4029Dj5.k(set2, "set2");
        return new a(set, set2);
    }

    public static HashSet f() {
        return new HashSet();
    }

    public static HashSet g(int i) {
        return new HashSet(AbstractC17096mO3.a(i));
    }

    public static Set h() {
        return Collections.newSetFromMap(AbstractC17096mO3.e());
    }

    static boolean i(Set set, Collection collection) {
        AbstractC4029Dj5.j(collection);
        if (collection instanceof InterfaceC8318Vl4) {
            collection = ((InterfaceC8318Vl4) collection).W0();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? j(set, collection.iterator()) : AbstractC17855ng3.n(set.iterator(), collection);
    }

    static boolean j(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
