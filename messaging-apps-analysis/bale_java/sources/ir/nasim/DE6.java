package ir.nasim;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes8.dex */
public final class DE6 extends AbstractSet {
    public static final b c = new b(null);
    private Object a;
    private int b;

    private static final class a implements Iterator, InterfaceC17915nm3 {
        private final Iterator a;

        public a(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "array");
            this.a = DJ.a(objArr);
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.a.next();
        }
    }

    public static final class b {
        private b() {
        }

        public final DE6 a() {
            return new DE6(null);
        }

        public final DE6 b(Collection collection) {
            AbstractC13042fc3.i(collection, "set");
            DE6 de6 = new DE6(null);
            de6.addAll(collection);
            return de6;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    private static final class c implements Iterator, InterfaceC17915nm3 {
        private final Object a;
        private boolean b = true;

        public c(Object obj) {
            this.a = obj;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            this.b = false;
            return this.a;
        }
    }

    public /* synthetic */ DE6(ED1 ed1) {
        this();
    }

    public static final DE6 f() {
        return c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.AbstractCollection, java.util.LinkedHashSet] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        Object[] objArr;
        if (size() == 0) {
            this.a = obj;
        } else if (size() == 1) {
            if (AbstractC13042fc3.d(this.a, obj)) {
                return false;
            }
            this.a = new Object[]{this.a, obj};
        } else if (size() < 5) {
            Object obj2 = this.a;
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
            Object[] objArr2 = (Object[]) obj2;
            if (AbstractC10242bK.U(objArr2, obj)) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr3 = new Object[objArr2.length];
                System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                ?? F = AbstractC4597Fu6.f(objArr3);
                F.add(obj);
                C19938rB7 c19938rB7 = C19938rB7.a;
                objArr = F;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, size() + 1);
                AbstractC13042fc3.h(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = obj;
                C19938rB7 c19938rB72 = C19938rB7.a;
                objArr = objArrCopyOf;
            }
            this.a = objArr;
        } else {
            Object obj3 = this.a;
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
            if (!AbstractC19810qy7.f(obj3).add(obj)) {
                return false;
            }
        }
        i(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a = null;
        i(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return AbstractC13042fc3.d(this.a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.a;
            if (obj2 != null) {
                return AbstractC10242bK.U((Object[]) obj2, obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        }
        Object obj3 = this.a;
        if (obj3 != null) {
            return ((Set) obj3).contains(obj);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
    }

    public int h() {
        return this.b;
    }

    public void i(int i) {
        this.b = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.a);
        }
        if (size() < 5) {
            Object obj = this.a;
            if (obj != null) {
                return new a((Object[]) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        }
        Object obj2 = this.a;
        if (obj2 != null) {
            return AbstractC19810qy7.f(obj2).iterator();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return h();
    }

    private DE6() {
    }
}
