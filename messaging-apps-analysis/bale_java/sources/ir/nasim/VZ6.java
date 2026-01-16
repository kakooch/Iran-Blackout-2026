package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public interface VZ6 {

    public static final class a implements Collection, InterfaceC17915nm3 {
        private final C3821Cm4 a;

        public a(C3821Cm4 c3821Cm4) {
            this.a = c3821Cm4;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final void clear() {
            this.a.k();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return this.a.a(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!this.a.a(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final boolean add(Object obj) {
            return this.a.g(obj);
        }

        public int h() {
            return this.a.c();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.a.d();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return this.a.j().iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            return this.a.x(obj);
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            return this.a.x(collection);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            return this.a.B(collection);
        }

        @Override // java.util.Collection
        public final /* bridge */ int size() {
            return h();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return UW0.a(this);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return UW0.b(this, objArr);
        }

        public /* synthetic */ a(C3821Cm4 c3821Cm4, int i, ED1 ed1) {
            this((i & 1) != 0 ? SL4.a() : c3821Cm4);
        }
    }

    boolean a(Object obj, Object obj2);

    void b(a aVar);
}
