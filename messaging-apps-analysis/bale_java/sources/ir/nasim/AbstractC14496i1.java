package ir.nasim;

import ir.nasim.AbstractC17096mO3;
import ir.nasim.AbstractC18649p1;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: ir.nasim.i1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC14496i1 extends AbstractC18649p1 implements Serializable {
    private transient Map e;
    private transient int f;

    /* renamed from: ir.nasim.i1$b */
    class b extends d {
        b(AbstractC14496i1 abstractC14496i1) {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC14496i1.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(Object obj, Object obj2) {
            return AbstractC17096mO3.d(obj, obj2);
        }
    }

    /* renamed from: ir.nasim.i1$c */
    private class c extends AbstractC17096mO3.f {
        final transient Map c;

        /* renamed from: ir.nasim.i1$c$a */
        class a extends AbstractC17096mO3.c {
            a() {
            }

            @Override // ir.nasim.AbstractC17096mO3.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return XW0.c(c.this.c.entrySet(), obj);
            }

            @Override // ir.nasim.AbstractC17096mO3.c
            Map f() {
                return c.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return c.this.new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractC14496i1.this.F(entry.getKey());
                return true;
            }
        }

        /* renamed from: ir.nasim.i1$c$b */
        class b implements Iterator {
            final Iterator a;
            Collection b;

            b() {
                this.a = c.this.c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.a.next();
                this.b = (Collection) entry.getValue();
                return c.this.f(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                AbstractC4029Dj5.p(this.b != null, "no calls to next() since the last call to remove()");
                this.a.remove();
                AbstractC14496i1.u(AbstractC14496i1.this, this.b.size());
                this.b.clear();
                this.b = null;
            }
        }

        c(Map map) {
            this.c = map;
        }

        @Override // ir.nasim.AbstractC17096mO3.f
        protected Set b() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.c == AbstractC14496i1.this.e) {
                AbstractC14496i1.this.clear();
            } else {
                AbstractC17855ng3.c(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return AbstractC17096mO3.f(this.c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) AbstractC17096mO3.g(this.c, obj);
            if (collection == null) {
                return null;
            }
            return AbstractC14496i1.this.H(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.c.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionY = AbstractC14496i1.this.y();
            collectionY.addAll(collection);
            AbstractC14496i1.u(AbstractC14496i1.this, collection.size());
            collection.clear();
            return collectionY;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.c.equals(obj);
        }

        Map.Entry f(Map.Entry entry) {
            Object key = entry.getKey();
            return AbstractC17096mO3.d(key, AbstractC14496i1.this.H(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return AbstractC14496i1.this.l();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.c.toString();
        }
    }

    /* renamed from: ir.nasim.i1$d */
    private abstract class d implements Iterator {
        final Iterator a;
        Object b = null;
        Collection c = null;
        Iterator d = AbstractC17855ng3.f();

        d() {
            this.a = AbstractC14496i1.this.e.entrySet().iterator();
        }

        abstract Object a(Object obj, Object obj2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() || this.d.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.d.hasNext()) {
                Map.Entry entry = (Map.Entry) this.a.next();
                this.b = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.c = collection;
                this.d = collection.iterator();
            }
            return a(AbstractC22447vF4.a(this.b), this.d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.d.remove();
            Collection collection = this.c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.a.remove();
            }
            AbstractC14496i1.r(AbstractC14496i1.this);
        }
    }

    /* renamed from: ir.nasim.i1$e */
    private class e extends AbstractC17096mO3.d {

        /* renamed from: ir.nasim.i1$e$a */
        class a implements Iterator {
            Map.Entry a;
            final /* synthetic */ Iterator b;

            a(Iterator it) {
                this.b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.b.next();
                this.a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                AbstractC4029Dj5.p(this.a != null, "no calls to next() since the last call to remove()");
                Collection collection = (Collection) this.a.getValue();
                this.b.remove();
                AbstractC14496i1.u(AbstractC14496i1.this, collection.size());
                collection.clear();
                this.a = null;
            }
        }

        e(Map map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractC17855ng3.c(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return f().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || f().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return f().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(f().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) f().remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractC14496i1.u(AbstractC14496i1.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* renamed from: ir.nasim.i1$f */
    class f extends i implements NavigableMap {
        f(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryCeilingEntry = i().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return f(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return i().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return AbstractC14496i1.this.new f(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryFirstEntry = i().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return f(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryFloorEntry = i().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return f(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return i().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryHigherEntry = i().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return f(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return i().higherKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC14496i1.i
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableSet g() {
            return AbstractC14496i1.this.new g(i());
        }

        @Override // ir.nasim.AbstractC14496i1.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // ir.nasim.AbstractC14496i1.i, ir.nasim.AbstractC14496i1.c, java.util.AbstractMap, java.util.Map
        /* renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryLastEntry = i().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return f(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryLowerEntry = i().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return f(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return i().lowerKey(obj);
        }

        Map.Entry n(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection collectionY = AbstractC14496i1.this.y();
            collectionY.addAll((Collection) entry.getValue());
            it.remove();
            return AbstractC17096mO3.d(entry.getKey(), AbstractC14496i1.this.G(collectionY));
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return h();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC14496i1.i
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableMap i() {
            return (NavigableMap) super.i();
        }

        @Override // ir.nasim.AbstractC14496i1.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return n(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return n(descendingMap().entrySet().iterator());
        }

        @Override // ir.nasim.AbstractC14496i1.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return AbstractC14496i1.this.new f(i().headMap(obj, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return AbstractC14496i1.this.new f(i().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return AbstractC14496i1.this.new f(i().tailMap(obj, z));
        }
    }

    /* renamed from: ir.nasim.i1$g */
    class g extends j implements NavigableSet {
        g(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return h().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return AbstractC14496i1.this.new g(h().descendingMap());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return h().floorKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return h().higherKey(obj);
        }

        @Override // ir.nasim.AbstractC14496i1.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC14496i1.j
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap h() {
            return (NavigableMap) super.h();
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return h().lowerKey(obj);
        }

        @Override // ir.nasim.AbstractC14496i1.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return AbstractC17855ng3.m(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return AbstractC17855ng3.m(descendingIterator());
        }

        @Override // ir.nasim.AbstractC14496i1.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z) {
            return AbstractC14496i1.this.new g(h().headMap(obj, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return AbstractC14496i1.this.new g(h().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z) {
            return AbstractC14496i1.this.new g(h().tailMap(obj, z));
        }
    }

    /* renamed from: ir.nasim.i1$h */
    private class h extends l implements RandomAccess {
        h(AbstractC14496i1 abstractC14496i1, Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }
    }

    /* renamed from: ir.nasim.i1$i */
    private class i extends c implements SortedMap {
        SortedSet e;

        i(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return i().firstKey();
        }

        SortedSet g() {
            return AbstractC14496i1.this.new j(i());
        }

        @Override // ir.nasim.AbstractC14496i1.c, java.util.AbstractMap, java.util.Map
        /* renamed from: h */
        public SortedSet keySet() {
            SortedSet sortedSet = this.e;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetG = g();
            this.e = sortedSetG;
            return sortedSetG;
        }

        public SortedMap headMap(Object obj) {
            return AbstractC14496i1.this.new i(i().headMap(obj));
        }

        SortedMap i() {
            return (SortedMap) this.c;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return i().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return AbstractC14496i1.this.new i(i().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return AbstractC14496i1.this.new i(i().tailMap(obj));
        }
    }

    /* renamed from: ir.nasim.i1$j */
    private class j extends e implements SortedSet {
        j(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return h().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return h().firstKey();
        }

        SortedMap h() {
            return (SortedMap) super.f();
        }

        public SortedSet headSet(Object obj) {
            return AbstractC14496i1.this.new j(h().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return h().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return AbstractC14496i1.this.new j(h().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return AbstractC14496i1.this.new j(h().tailMap(obj));
        }
    }

    protected AbstractC14496i1(Map map) {
        AbstractC4029Dj5.d(map.isEmpty());
        this.e = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterator E(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Object obj) {
        Collection collection = (Collection) AbstractC17096mO3.h(this.e, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f -= size;
        }
    }

    static /* synthetic */ int q(AbstractC14496i1 abstractC14496i1) {
        int i2 = abstractC14496i1.f;
        abstractC14496i1.f = i2 + 1;
        return i2;
    }

    static /* synthetic */ int r(AbstractC14496i1 abstractC14496i1) {
        int i2 = abstractC14496i1.f;
        abstractC14496i1.f = i2 - 1;
        return i2;
    }

    static /* synthetic */ int s(AbstractC14496i1 abstractC14496i1, int i2) {
        int i3 = abstractC14496i1.f + i2;
        abstractC14496i1.f = i3;
        return i3;
    }

    static /* synthetic */ int u(AbstractC14496i1 abstractC14496i1, int i2) {
        int i3 = abstractC14496i1.f - i2;
        abstractC14496i1.f = i3;
        return i3;
    }

    final Map C() {
        Map map = this.e;
        return map instanceof NavigableMap ? new f((NavigableMap) this.e) : map instanceof SortedMap ? new i((SortedMap) this.e) : new c(this.e);
    }

    final Set D() {
        Map map = this.e;
        return map instanceof NavigableMap ? new g((NavigableMap) this.e) : map instanceof SortedMap ? new j((SortedMap) this.e) : new e(this.e);
    }

    abstract Collection G(Collection collection);

    abstract Collection H(Object obj, Collection collection);

    final List J(Object obj, List list, k kVar) {
        return list instanceof RandomAccess ? new h(this, obj, list, kVar) : new l(obj, list, kVar);
    }

    @Override // ir.nasim.AbstractC18649p1, ir.nasim.InterfaceC7143Ql4
    public Collection a() {
        return super.a();
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public void clear() {
        Iterator it = this.e.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.e.clear();
        this.f = 0;
    }

    @Override // ir.nasim.AbstractC18649p1
    Collection f() {
        return new AbstractC18649p1.a();
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public Collection get(Object obj) {
        Collection collectionZ = (Collection) this.e.get(obj);
        if (collectionZ == null) {
            collectionZ = z(obj);
        }
        return H(obj, collectionZ);
    }

    @Override // ir.nasim.AbstractC18649p1
    Collection j() {
        return new AbstractC18649p1.b();
    }

    @Override // ir.nasim.AbstractC18649p1
    Iterator k() {
        return new b(this);
    }

    @Override // ir.nasim.AbstractC18649p1
    Iterator m() {
        return new a(this);
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.e.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f++;
            return true;
        }
        Collection collectionZ = z(obj);
        if (!collectionZ.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f++;
        this.e.put(obj, collectionZ);
        return true;
    }

    @Override // ir.nasim.InterfaceC7143Ql4
    public int size() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC18649p1, ir.nasim.InterfaceC7143Ql4
    public Collection values() {
        return super.values();
    }

    abstract Collection y();

    Collection z(Object obj) {
        return y();
    }

    /* renamed from: ir.nasim.i1$k */
    class k extends AbstractCollection {
        final Object a;
        Collection b;
        final k c;
        final Collection d;

        k(Object obj, Collection collection, k kVar) {
            this.a = obj;
            this.b = collection;
            this.c = kVar;
            this.d = kVar == null ? null : kVar.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            o();
            boolean zIsEmpty = this.b.isEmpty();
            boolean zAdd = this.b.add(obj);
            if (zAdd) {
                AbstractC14496i1.q(AbstractC14496i1.this);
                if (zIsEmpty) {
                    f();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.b.addAll(collection);
            if (zAddAll) {
                AbstractC14496i1.s(AbstractC14496i1.this, this.b.size() - size);
                if (size == 0) {
                    f();
                }
            }
            return zAddAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.b.clear();
            AbstractC14496i1.u(AbstractC14496i1.this, size);
            r();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            o();
            return this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            o();
            return this.b.containsAll(collection);
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            o();
            return this.b.equals(obj);
        }

        void f() {
            k kVar = this.c;
            if (kVar != null) {
                kVar.f();
            } else {
                AbstractC14496i1.this.e.put(this.a, this.b);
            }
        }

        k h() {
            return this.c;
        }

        @Override // java.util.Collection
        public int hashCode() {
            o();
            return this.b.hashCode();
        }

        Collection i() {
            return this.b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            o();
            return new a();
        }

        Object j() {
            return this.a;
        }

        void o() {
            Collection collection;
            k kVar = this.c;
            if (kVar != null) {
                kVar.o();
                if (this.c.i() != this.d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.b.isEmpty() || (collection = (Collection) AbstractC14496i1.this.e.get(this.a)) == null) {
                    return;
                }
                this.b = collection;
            }
        }

        void r() {
            k kVar = this.c;
            if (kVar != null) {
                kVar.r();
            } else if (this.b.isEmpty()) {
                AbstractC14496i1.this.e.remove(this.a);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            o();
            boolean zRemove = this.b.remove(obj);
            if (zRemove) {
                AbstractC14496i1.r(AbstractC14496i1.this);
                r();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.b.removeAll(collection);
            if (zRemoveAll) {
                AbstractC14496i1.s(AbstractC14496i1.this, this.b.size() - size);
                r();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            AbstractC4029Dj5.j(collection);
            int size = size();
            boolean zRetainAll = this.b.retainAll(collection);
            if (zRetainAll) {
                AbstractC14496i1.s(AbstractC14496i1.this, this.b.size() - size);
                r();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            o();
            return this.b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            o();
            return this.b.toString();
        }

        /* renamed from: ir.nasim.i1$k$a */
        class a implements Iterator {
            final Iterator a;
            final Collection b;

            a() {
                Collection collection = k.this.b;
                this.b = collection;
                this.a = AbstractC14496i1.E(collection);
            }

            Iterator a() {
                b();
                return this.a;
            }

            void b() {
                k.this.o();
                if (k.this.b != this.b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                b();
                return this.a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
                AbstractC14496i1.r(AbstractC14496i1.this);
                k.this.r();
            }

            a(Iterator it) {
                this.b = k.this.b;
                this.a = it;
            }
        }
    }

    /* renamed from: ir.nasim.i1$l */
    class l extends k implements List {

        /* renamed from: ir.nasim.i1$l$a */
        private class a extends k.a implements ListIterator {
            a() {
                super();
            }

            private ListIterator c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                boolean zIsEmpty = l.this.isEmpty();
                c().add(obj);
                AbstractC14496i1.q(AbstractC14496i1.this);
                if (zIsEmpty) {
                    l.this.f();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c().set(obj);
            }

            public a(int i) {
                super(l.this.t().listIterator(i));
            }
        }

        l(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            o();
            boolean zIsEmpty = i().isEmpty();
            t().add(i, obj);
            AbstractC14496i1.q(AbstractC14496i1.this);
            if (zIsEmpty) {
                f();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = t().addAll(i, collection);
            if (zAddAll) {
                AbstractC14496i1.s(AbstractC14496i1.this, i().size() - size);
                if (size == 0) {
                    f();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public Object get(int i) {
            o();
            return t().get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            o();
            return t().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            o();
            return t().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            o();
            return new a();
        }

        @Override // java.util.List
        public Object remove(int i) {
            o();
            Object objRemove = t().remove(i);
            AbstractC14496i1.r(AbstractC14496i1.this);
            r();
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            o();
            return t().set(i, obj);
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            o();
            return AbstractC14496i1.this.J(j(), t().subList(i, i2), h() == null ? this : h());
        }

        List t() {
            return (List) i();
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            o();
            return new a(i);
        }
    }

    /* renamed from: ir.nasim.i1$a */
    class a extends d {
        a(AbstractC14496i1 abstractC14496i1) {
            super();
        }

        @Override // ir.nasim.AbstractC14496i1.d
        Object a(Object obj, Object obj2) {
            return obj2;
        }
    }
}
