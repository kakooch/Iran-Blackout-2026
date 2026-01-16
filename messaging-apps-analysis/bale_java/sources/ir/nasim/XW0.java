package ir.nasim;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class XW0 {

    static class a extends AbstractCollection {
        final Collection a;
        final InterfaceC11281ck5 b;

        a(Collection collection, InterfaceC11281ck5 interfaceC11281ck5) {
            this.a = collection;
            this.b = interfaceC11281ck5;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            AbstractC4029Dj5.d(this.b.apply(obj));
            return this.a.add(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                AbstractC4029Dj5.d(this.b.apply(it.next()));
            }
            return this.a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC17264mg3.f(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (XW0.c(this.a, obj)) {
                return this.b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            return XW0.a(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !AbstractC17264mg3.a(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC17855ng3.g(this.a.iterator(), this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            Iterator it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (this.b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Iterator it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (this.b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator it = this.a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.b.apply(it.next())) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return AbstractC18170oC3.h(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return AbstractC18170oC3.h(iterator()).toArray(objArr);
        }
    }

    static boolean a(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    static StringBuilder b(int i) {
        MW0.b(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    static boolean c(Collection collection, Object obj) {
        AbstractC4029Dj5.j(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
