package ir.nasim;

import android.gov.nist.core.Separators;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public class KJ extends C24792zC6 implements Map {
    a d;
    c e;
    e f;

    final class a extends AbstractSet {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return KJ.this.new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return KJ.this.size();
        }
    }

    final class b extends AbstractC12139e63 {
        b() {
            super(KJ.this.size());
        }

        @Override // ir.nasim.AbstractC12139e63
        protected Object b(int i) {
            return KJ.this.g(i);
        }

        @Override // ir.nasim.AbstractC12139e63
        protected void c(int i) {
            KJ.this.i(i);
        }
    }

    final class d implements Iterator, Map.Entry {
        int a;
        int b = -1;
        boolean c;

        d() {
            this.a = KJ.this.size() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.b++;
            this.c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC13738gk1.c(entry.getKey(), KJ.this.g(this.b)) && AbstractC13738gk1.c(entry.getValue(), KJ.this.k(this.b));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.c) {
                return KJ.this.g(this.b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.c) {
                return KJ.this.k(this.b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objG = KJ.this.g(this.b);
            Object objK = KJ.this.k(this.b);
            return (objG == null ? 0 : objG.hashCode()) ^ (objK != null ? objK.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.c) {
                throw new IllegalStateException();
            }
            KJ.this.i(this.b);
            this.b--;
            this.a--;
            this.c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.c) {
                return KJ.this.j(this.b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + Separators.EQUALS + getValue();
        }
    }

    final class f extends AbstractC12139e63 {
        f() {
            super(KJ.this.size());
        }

        @Override // ir.nasim.AbstractC12139e63
        protected Object b(int i) {
            return KJ.this.k(i);
        }

        @Override // ir.nasim.AbstractC12139e63
        protected void c(int i) {
            KJ.this.i(i);
        }
    }

    public KJ() {
    }

    static boolean n(Set set, Object obj) {
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

    @Override // ir.nasim.C24792zC6, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // ir.nasim.C24792zC6, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.d = aVar2;
        return aVar2;
    }

    @Override // ir.nasim.C24792zC6, java.util.Map
    public Object get(Object obj) {
        return super.get(obj);
    }

    @Override // java.util.Map
    public Set keySet() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.e = cVar2;
        return cVar2;
    }

    public boolean l(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean o(Collection collection) {
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return size != size();
    }

    public boolean p(Collection collection) {
        int size = size();
        for (int size2 = size() - 1; size2 >= 0; size2--) {
            if (!collection.contains(g(size2))) {
                i(size2);
            }
        }
        return size != size();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c(size() + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // ir.nasim.C24792zC6, java.util.Map
    public Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // java.util.Map
    public Collection values() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        this.f = eVar2;
        return eVar2;
    }

    public KJ(int i) {
        super(i);
    }

    final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            KJ.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return KJ.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return KJ.this.l(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return KJ.n(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int size = KJ.this.size() - 1; size >= 0; size--) {
                Object objG = KJ.this.g(size);
                iHashCode += objG == null ? 0 : objG.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return KJ.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return KJ.this.new b();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iE = KJ.this.e(obj);
            if (iE < 0) {
                return false;
            }
            KJ.this.i(iE);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return KJ.this.o(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return KJ.this.p(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return KJ.this.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int size = KJ.this.size();
            Object[] objArr = new Object[size];
            for (int i = 0; i < size; i++) {
                objArr[i] = KJ.this.g(i);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i = 0; i < size; i++) {
                objArr[i] = KJ.this.g(i);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    final class e implements Collection {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            KJ.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return KJ.this.b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return KJ.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return KJ.this.new f();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iB = KJ.this.b(obj);
            if (iB < 0) {
                return false;
            }
            KJ.this.i(iB);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int size = KJ.this.size();
            int i = 0;
            boolean z = false;
            while (i < size) {
                if (collection.contains(KJ.this.k(i))) {
                    KJ.this.i(i);
                    i--;
                    size--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int size = KJ.this.size();
            int i = 0;
            boolean z = false;
            while (i < size) {
                if (!collection.contains(KJ.this.k(i))) {
                    KJ.this.i(i);
                    i--;
                    size--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return KJ.this.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int size = KJ.this.size();
            Object[] objArr = new Object[size];
            for (int i = 0; i < size; i++) {
                objArr[i] = KJ.this.k(i);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i = 0; i < size; i++) {
                objArr[i] = KJ.this.k(i);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    public KJ(C24792zC6 c24792zC6) {
        super(c24792zC6);
    }
}
