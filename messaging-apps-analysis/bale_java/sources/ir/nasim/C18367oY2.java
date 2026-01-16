package ir.nasim;

import androidx.compose.ui.e;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/* renamed from: ir.nasim.oY2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18367oY2 implements List, InterfaceC17915nm3 {
    private C3587Bm4 a = new C3587Bm4(16);
    private C21576tm4 b = new C21576tm4(16);
    private int c = -1;

    /* renamed from: ir.nasim.oY2$b */
    private final class b implements List, InterfaceC17915nm3 {
        private final int a;
        private final int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void addFirst(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void addLast(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof e.c) {
                return f((e.c) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains((e.c) it.next())) {
                    return false;
                }
            }
            return true;
        }

        public boolean f(e.c cVar) {
            return indexOf(cVar) != -1;
        }

        @Override // java.util.List
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public e.c get(int i) {
            Object objD = C18367oY2.this.a.d(i + this.a);
            AbstractC13042fc3.g(objD, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (e.c) objD;
        }

        public int i() {
            return this.b - this.a;
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof e.c) {
                return j((e.c) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            C18367oY2 c18367oY2 = C18367oY2.this;
            int i = this.a;
            return c18367oY2.new a(i, i, this.b);
        }

        public int j(e.c cVar) {
            int i = this.a;
            int i2 = this.b;
            if (i > i2) {
                return -1;
            }
            while (!AbstractC13042fc3.d(C18367oY2.this.a.d(i), cVar)) {
                if (i == i2) {
                    return -1;
                }
                i++;
            }
            return i - this.a;
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof e.c) {
                return o((e.c) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            C18367oY2 c18367oY2 = C18367oY2.this;
            int i = this.a;
            return c18367oY2.new a(i, i, this.b);
        }

        public int o(e.c cVar) {
            int i = this.b;
            int i2 = this.a;
            if (i2 > i) {
                return -1;
            }
            while (!AbstractC13042fc3.d(C18367oY2.this.a.d(i), cVar)) {
                if (i == i2) {
                    return -1;
                }
                i--;
            }
            return i - this.a;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ Object removeFirst() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ Object removeLast() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return i();
        }

        @Override // java.util.List
        public void sort(Comparator comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            C18367oY2 c18367oY2 = C18367oY2.this;
            int i3 = this.a;
            return c18367oY2.new b(i + i3, i3 + i2);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return UW0.a(this);
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            C18367oY2 c18367oY2 = C18367oY2.this;
            int i2 = this.a;
            return c18367oY2.new a(i + i2, i2, this.b);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return UW0.b(this, objArr);
        }
    }

    private final void N(int i) {
        this.a.A(i);
        this.b.h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(int i, int i2) {
        if (i >= i2) {
            return;
        }
        this.a.B(i, i2);
        this.b.i(i, i2);
    }

    private final long x() {
        long jB = AbstractC18958pY2.b(Float.POSITIVE_INFINITY, false, false, 4, null);
        int i = this.c + 1;
        int iO = AbstractC10360bX0.o(this);
        if (i <= iO) {
            while (true) {
                long jB2 = UV1.b(this.b.a(i));
                if (UV1.a(jB2, jB) < 0) {
                    jB = jB2;
                }
                if (UV1.c(jB) < 0.0f && UV1.e(jB)) {
                    return jB;
                }
                if (i == iO) {
                    break;
                }
                i++;
            }
        }
        return jB;
    }

    @Override // java.util.List
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public e.c get(int i) {
        Object objD = this.a.d(i);
        AbstractC13042fc3.g(objD, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (e.c) objD;
    }

    public int B() {
        return this.a.e();
    }

    public final boolean C() {
        long jX = x();
        return UV1.c(jX) < 0.0f && UV1.e(jX) && !UV1.d(jX);
    }

    public final void E(e.c cVar, boolean z, SA2 sa2) {
        if (this.c == AbstractC10360bX0.o(this)) {
            int i = this.c;
            O(this.c + 1, size());
            this.c++;
            this.a.n(cVar);
            this.b.d(AbstractC18958pY2.a(0.0f, z, true));
            sa2.invoke();
            this.c = i;
            return;
        }
        long jX = x();
        int i2 = this.c;
        if (!UV1.d(jX)) {
            if (UV1.c(jX) > 0.0f) {
                int i3 = this.c;
                O(this.c + 1, size());
                this.c++;
                this.a.n(cVar);
                this.b.d(AbstractC18958pY2.a(0.0f, z, true));
                sa2.invoke();
                this.c = i3;
                return;
            }
            return;
        }
        this.c = AbstractC10360bX0.o(this);
        int i4 = this.c;
        O(this.c + 1, size());
        this.c++;
        this.a.n(cVar);
        this.b.d(AbstractC18958pY2.a(0.0f, z, true));
        sa2.invoke();
        this.c = i4;
        if (UV1.c(x()) < 0.0f) {
            O(i2 + 1, this.c + 1);
        }
        this.c = i2;
    }

    public int F(e.c cVar) {
        int iO = AbstractC10360bX0.o(this);
        if (iO < 0) {
            return -1;
        }
        int i = 0;
        while (!AbstractC13042fc3.d(this.a.d(i), cVar)) {
            if (i == iO) {
                return -1;
            }
            i++;
        }
        return i;
    }

    public final boolean I(float f, boolean z) {
        if (this.c == AbstractC10360bX0.o(this)) {
            return true;
        }
        return UV1.a(x(), AbstractC18958pY2.b(f, z, false, 4, null)) > 0;
    }

    public int L(e.c cVar) {
        for (int iO = AbstractC10360bX0.o(this); -1 < iO; iO--) {
            if (AbstractC13042fc3.d(this.a.d(iO), cVar)) {
                return iO;
            }
        }
        return -1;
    }

    public final void P(e.c cVar, float f, boolean z, SA2 sa2) {
        if (this.c == AbstractC10360bX0.o(this)) {
            int i = this.c;
            O(this.c + 1, size());
            this.c++;
            this.a.n(cVar);
            this.b.d(AbstractC18958pY2.a(f, z, false));
            sa2.invoke();
            this.c = i;
            if (this.c + 1 == AbstractC10360bX0.o(this) || UV1.d(x())) {
                N(this.c + 1);
                return;
            }
            return;
        }
        long jX = x();
        int i2 = this.c;
        this.c = AbstractC10360bX0.o(this);
        int i3 = this.c;
        O(this.c + 1, size());
        this.c++;
        this.a.n(cVar);
        this.b.d(AbstractC18958pY2.a(f, z, false));
        sa2.invoke();
        this.c = i3;
        long jX2 = x();
        if (this.c + 1 >= AbstractC10360bX0.o(this) || UV1.a(jX, jX2) <= 0) {
            O(this.c + 1, size());
        } else {
            O(i2 + 1, UV1.d(jX2) ? this.c + 2 : this.c + 1);
        }
        this.c = i2;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addFirst(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addLast(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.c = -1;
        this.a.t();
        this.b.f();
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof e.c) {
            return v((e.c) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains((e.c) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void f() {
        this.c = size() - 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof e.c) {
            return F((e.c) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.a.g();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new a(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof e.c) {
            return L((e.c) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new a(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return B();
    }

    @Override // java.util.List
    public void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new b(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return UW0.a(this);
    }

    public boolean v(e.c cVar) {
        return indexOf(cVar) != -1;
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new a(this, i, 0, 0, 6, null);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return UW0.b(this, objArr);
    }

    /* renamed from: ir.nasim.oY2$a */
    private final class a implements ListIterator, InterfaceC17915nm3 {
        private int a;
        private final int b;
        private final int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e.c next() {
            C3587Bm4 c3587Bm4 = C18367oY2.this.a;
            int i = this.a;
            this.a = i + 1;
            Object objD = c3587Bm4.d(i);
            AbstractC13042fc3.g(objD, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (e.c) objD;
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e.c previous() {
            C3587Bm4 c3587Bm4 = C18367oY2.this.a;
            int i = this.a - 1;
            this.a = i;
            Object objD = c3587Bm4.d(i);
            AbstractC13042fc3.g(objD, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (e.c) objD;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.a < this.c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a > this.b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a - this.b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.a - this.b) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* synthetic */ a(C18367oY2 c18367oY2, int i, int i2, int i3, int i4, ED1 ed1) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? c18367oY2.size() : i3);
        }
    }
}
