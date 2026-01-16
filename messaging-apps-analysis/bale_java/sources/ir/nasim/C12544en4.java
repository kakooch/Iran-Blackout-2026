package ir.nasim;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.en4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12544en4 implements RandomAccess {
    public static final int d = 8;
    public Object[] a;
    private List b;
    private int c;

    /* renamed from: ir.nasim.en4$a */
    private static final class a implements List, InterfaceC19688qm3 {
        private final C12544en4 a;

        public a(C12544en4 c12544en4) {
            this.a = c12544en4;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            return this.a.d(obj);
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            return this.a.g(i, collection);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.a.k();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.a.l(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            return this.a.m(collection);
        }

        public int f() {
            return this.a.o();
        }

        @Override // java.util.List
        public Object get(int i) {
            AbstractC13180fn4.a(this, i);
            return this.a.a[i];
        }

        public Object h(int i) {
            AbstractC13180fn4.a(this, i);
            return this.a.w(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.a.p(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.a.o() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.a.r(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i) {
            return h(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            return this.a.v(collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            return this.a.z(collection);
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            AbstractC13180fn4.a(this, i);
            return this.a.A(i, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return f();
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            AbstractC13180fn4.b(this, i, i2);
            return new b(this, i, i2);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return UW0.a(this);
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            this.a.a(i, obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            return this.a.i(collection);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            return new c(this, i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.a.t(obj);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return UW0.b(this, objArr);
        }
    }

    /* renamed from: ir.nasim.en4$b */
    private static final class b implements List, InterfaceC19688qm3 {
        private final List a;
        private final int b;
        private int c;

        public b(List list, int i, int i2) {
            this.a = list;
            this.b = i;
            this.c = i2;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            List list = this.a;
            int i = this.c;
            this.c = i + 1;
            list.add(i, obj);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            this.a.addAll(i + this.b, collection);
            int size = collection.size();
            this.c += size;
            return size > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i = this.c - 1;
            int i2 = this.b;
            if (i2 <= i) {
                while (true) {
                    this.a.remove(i);
                    if (i == i2) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            this.c = this.b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i = this.c;
            for (int i2 = this.b; i2 < i; i2++) {
                if (AbstractC13042fc3.d(this.a.get(i2), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public int f() {
            return this.c - this.b;
        }

        @Override // java.util.List
        public Object get(int i) {
            AbstractC13180fn4.a(this, i);
            return this.a.get(i + this.b);
        }

        public Object h(int i) {
            AbstractC13180fn4.a(this, i);
            this.c--;
            return this.a.remove(i + this.b);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i = this.c;
            for (int i2 = this.b; i2 < i; i2++) {
                if (AbstractC13042fc3.d(this.a.get(i2), obj)) {
                    return i2 - this.b;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.c == this.b;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i = this.c - 1;
            int i2 = this.b;
            if (i2 > i) {
                return -1;
            }
            while (!AbstractC13042fc3.d(this.a.get(i), obj)) {
                if (i == i2) {
                    return -1;
                }
                i--;
            }
            return i - this.b;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i) {
            return h(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            int i = this.c;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i != this.c;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            int i = this.c;
            int i2 = i - 1;
            int i3 = this.b;
            if (i3 <= i2) {
                while (true) {
                    if (!collection.contains(this.a.get(i2))) {
                        this.a.remove(i2);
                        this.c--;
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2--;
                }
            }
            return i != this.c;
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            AbstractC13180fn4.a(this, i);
            return this.a.set(i + this.b, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return f();
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            AbstractC13180fn4.b(this, i, i2);
            return new b(this, i, i2);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return UW0.a(this);
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            this.a.add(i + this.b, obj);
            this.c++;
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            return new c(this, i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i = this.c;
            for (int i2 = this.b; i2 < i; i2++) {
                if (AbstractC13042fc3.d(this.a.get(i2), obj)) {
                    this.a.remove(i2);
                    this.c--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return UW0.b(this, objArr);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            this.a.addAll(this.c, collection);
            int size = collection.size();
            this.c += size;
            return size > 0;
        }
    }

    /* renamed from: ir.nasim.en4$c */
    private static final class c implements ListIterator, InterfaceC17915nm3 {
        private final List a;
        private int b;

        public c(List list, int i) {
            this.a = list;
            this.b = i;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.a.add(this.b, obj);
            this.b++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            List list = this.a;
            int i = this.b;
            this.b = i + 1;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i = this.b - 1;
            this.b = i;
            return this.a.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i = this.b - 1;
            this.b = i;
            this.a.remove(i);
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.a.set(this.b, obj);
        }
    }

    public C12544en4(Object[] objArr, int i) {
        this.a = objArr;
        this.c = i;
    }

    public final Object A(int i, Object obj) {
        Object[] objArr = this.a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final void B(int i) {
        this.c = i;
    }

    public final void C(Comparator comparator) {
        AbstractC9648aK.L(this.a, comparator, 0, this.c);
    }

    public final Void D(String str) {
        throw new NoSuchElementException(str);
    }

    public final void a(int i, Object obj) {
        int i2 = this.c + 1;
        if (this.a.length < i2) {
            y(i2);
        }
        Object[] objArr = this.a;
        int i3 = this.c;
        if (i != i3) {
            System.arraycopy(objArr, i, objArr, i + 1, i3 - i);
        }
        objArr[i] = obj;
        this.c++;
    }

    public final boolean d(Object obj) {
        int i = this.c + 1;
        if (this.a.length < i) {
            y(i);
        }
        Object[] objArr = this.a;
        int i2 = this.c;
        objArr[i2] = obj;
        this.c = i2 + 1;
        return true;
    }

    public final boolean f(int i, C12544en4 c12544en4) {
        int i2 = c12544en4.c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.c + i2;
        if (this.a.length < i3) {
            y(i3);
        }
        Object[] objArr = this.a;
        int i4 = this.c;
        if (i != i4) {
            System.arraycopy(objArr, i, objArr, i + i2, i4 - i);
        }
        System.arraycopy(c12544en4.a, 0, objArr, i, i2);
        this.c += i2;
        return true;
    }

    public final boolean g(int i, Collection collection) {
        int i2 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        int size = collection.size();
        int i3 = this.c + size;
        if (this.a.length < i3) {
            y(i3);
        }
        Object[] objArr = this.a;
        int i4 = this.c;
        if (i != i4) {
            System.arraycopy(objArr, i, objArr, i + size, i4 - i);
        }
        for (Object obj : collection) {
            int i5 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            objArr[i2 + i] = obj;
            i2 = i5;
        }
        this.c += size;
        return true;
    }

    public final boolean h(int i, List list) {
        if (list.isEmpty()) {
            return false;
        }
        int size = list.size();
        int i2 = this.c + size;
        if (this.a.length < i2) {
            y(i2);
        }
        Object[] objArr = this.a;
        int i3 = this.c;
        if (i != i3) {
            System.arraycopy(objArr, i, objArr, i + size, i3 - i);
        }
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            objArr[i + i4] = list.get(i4);
        }
        this.c += size;
        return true;
    }

    public final boolean i(Collection collection) {
        return g(this.c, collection);
    }

    public final List j() {
        List list = this.b;
        if (list != null) {
            return list;
        }
        a aVar = new a(this);
        this.b = aVar;
        return aVar;
    }

    public final void k() {
        Object[] objArr = this.a;
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.c = 0;
    }

    public final boolean l(Object obj) {
        int iO = o() - 1;
        if (iO >= 0) {
            for (int i = 0; !AbstractC13042fc3.d(this.a[i], obj); i++) {
                if (i != iO) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean m(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!l(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object n() {
        if (o() != 0) {
            return this.a[0];
        }
        D("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final int o() {
        return this.c;
    }

    public final int p(Object obj) {
        Object[] objArr = this.a;
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (AbstractC13042fc3.d(obj, objArr[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public final Object q() {
        if (o() != 0) {
            return this.a[o() - 1];
        }
        D("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final int r(Object obj) {
        Object[] objArr = this.a;
        for (int i = this.c - 1; i >= 0; i--) {
            if (AbstractC13042fc3.d(obj, objArr[i])) {
                return i;
            }
        }
        return -1;
    }

    public final boolean t(Object obj) {
        int iP = p(obj);
        if (iP < 0) {
            return false;
        }
        w(iP);
        return true;
    }

    public final boolean v(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int i = this.c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            t(it.next());
        }
        return i != this.c;
    }

    public final Object w(int i) {
        Object[] objArr = this.a;
        Object obj = objArr[i];
        if (i != o() - 1) {
            int i2 = i + 1;
            System.arraycopy(objArr, i2, objArr, i, this.c - i2);
        }
        int i3 = this.c - 1;
        this.c = i3;
        objArr[i3] = null;
        return obj;
    }

    public final void x(int i, int i2) {
        if (i2 > i) {
            int i3 = this.c;
            if (i2 < i3) {
                Object[] objArr = this.a;
                System.arraycopy(objArr, i2, objArr, i, i3 - i2);
            }
            int i4 = this.c - (i2 - i);
            int iO = o() - 1;
            if (i4 <= iO) {
                int i5 = i4;
                while (true) {
                    this.a[i5] = null;
                    if (i5 == iO) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.c = i4;
        }
    }

    public final void y(int i) {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i, length * 2)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        this.a = objArr2;
    }

    public final boolean z(Collection collection) {
        int i = this.c;
        for (int iO = o() - 1; -1 < iO; iO--) {
            if (!collection.contains(this.a[iO])) {
                w(iO);
            }
        }
        return i != this.c;
    }
}
