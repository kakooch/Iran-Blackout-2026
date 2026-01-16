package ir.nasim;

import ir.nasim.Z33;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: ir.nasim.f43, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC12710f43 extends Z33 implements List, RandomAccess {
    private static final IB7 b = new b(DM5.e, 0);

    /* renamed from: ir.nasim.f43$a */
    public static final class a extends Z33.a {
        public a() {
            this(4);
        }

        @Override // ir.nasim.Z33.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            super.d(obj);
            return this;
        }

        public a g(Iterable iterable) {
            super.b(iterable);
            return this;
        }

        public AbstractC12710f43 h() {
            this.c = true;
            return AbstractC12710f43.F(this.a, this.b);
        }

        a(int i) {
            super(i);
        }
    }

    /* renamed from: ir.nasim.f43$b */
    static class b extends V0 {
        private final AbstractC12710f43 c;

        b(AbstractC12710f43 abstractC12710f43, int i) {
            super(abstractC12710f43.size(), i);
            this.c = abstractC12710f43;
        }

        @Override // ir.nasim.V0
        protected Object a(int i) {
            return this.c.get(i);
        }
    }

    /* renamed from: ir.nasim.f43$c */
    class c extends AbstractC12710f43 {
        final transient int c;
        final transient int d;

        c(int i, int i2) {
            this.c = i;
            this.d = i2;
        }

        @Override // ir.nasim.Z33
        int C() {
            return AbstractC12710f43.this.C() + this.c;
        }

        @Override // ir.nasim.Z33
        boolean D() {
            return true;
        }

        @Override // ir.nasim.AbstractC12710f43, java.util.List
        /* renamed from: a0, reason: merged with bridge method [inline-methods] */
        public AbstractC12710f43 subList(int i, int i2) {
            AbstractC4029Dj5.n(i, i2, this.d);
            AbstractC12710f43 abstractC12710f43 = AbstractC12710f43.this;
            int i3 = this.c;
            return abstractC12710f43.subList(i + i3, i2 + i3);
        }

        @Override // java.util.List
        public Object get(int i) {
            AbstractC4029Dj5.h(i, this.d);
            return AbstractC12710f43.this.get(i + this.c);
        }

        @Override // ir.nasim.AbstractC12710f43, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // ir.nasim.AbstractC12710f43, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // ir.nasim.Z33
        Object[] r() {
            return AbstractC12710f43.this.r();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.d;
        }

        @Override // ir.nasim.Z33
        int w() {
            return AbstractC12710f43.this.C() + this.c + this.d;
        }

        @Override // ir.nasim.AbstractC12710f43, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }
    }

    AbstractC12710f43() {
    }

    static AbstractC12710f43 E(Object[] objArr) {
        return F(objArr, objArr.length);
    }

    static AbstractC12710f43 F(Object[] objArr, int i) {
        return i == 0 ? V() : new DM5(objArr, i);
    }

    public static a L() {
        return new a();
    }

    private static AbstractC12710f43 N(Object... objArr) {
        return E(AbstractC16434lG4.b(objArr));
    }

    public static AbstractC12710f43 O(Collection collection) {
        if (!(collection instanceof Z33)) {
            return N(collection.toArray());
        }
        AbstractC12710f43 abstractC12710f43F = ((Z33) collection).f();
        return abstractC12710f43F.D() ? E(abstractC12710f43F.toArray()) : abstractC12710f43F;
    }

    public static AbstractC12710f43 P(Object[] objArr) {
        return objArr.length == 0 ? V() : N((Object[]) objArr.clone());
    }

    public static AbstractC12710f43 V() {
        return DM5.e;
    }

    public static AbstractC12710f43 W(Object obj) {
        return N(obj);
    }

    public static AbstractC12710f43 Y(Object obj, Object obj2) {
        return N(obj, obj2);
    }

    public static AbstractC12710f43 Z(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return N(obj, obj2, obj3, obj4, obj5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public DB7 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public IB7 listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public IB7 listIterator(int i) {
        AbstractC4029Dj5.l(i, size());
        return isEmpty() ? b : new b(this, i);
    }

    @Override // java.util.List
    /* renamed from: a0 */
    public AbstractC12710f43 subList(int i, int i2) {
        AbstractC4029Dj5.n(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? V() : b0(i, i2);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    AbstractC12710f43 b0(int i, int i2) {
        return new c(i, i2 - i);
    }

    @Override // ir.nasim.Z33, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return AbstractC18170oC3.b(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return AbstractC18170oC3.c(this, obj);
    }

    @Override // ir.nasim.Z33
    int j(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return AbstractC18170oC3.e(this, obj);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // ir.nasim.Z33
    public final AbstractC12710f43 f() {
        return this;
    }
}
