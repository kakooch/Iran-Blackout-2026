package ir.nasim;

import ir.nasim.Z33;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

/* renamed from: ir.nasim.h43, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC13937h43 implements Map, Serializable {
    static final Map.Entry[] d = new Map.Entry[0];
    private transient AbstractC14535i43 a;
    private transient AbstractC14535i43 b;
    private transient Z33 c;

    /* renamed from: ir.nasim.h43$a */
    public static class a {
        Comparator a;
        Object[] b;
        int c;
        boolean d;

        public a() {
            this(4);
        }

        private void c(int i) {
            int i2 = i * 2;
            Object[] objArr = this.b;
            if (i2 > objArr.length) {
                this.b = Arrays.copyOf(objArr, Z33.b.c(objArr.length, i2));
                this.d = false;
            }
        }

        public AbstractC13937h43 a() {
            return b();
        }

        public AbstractC13937h43 b() {
            g();
            this.d = true;
            return EM5.s(this.c, this.b);
        }

        public a d(Object obj, Object obj2) {
            c(this.c + 1);
            MW0.a(obj, obj2);
            Object[] objArr = this.b;
            int i = this.c;
            objArr[i * 2] = obj;
            objArr[(i * 2) + 1] = obj2;
            this.c = i + 1;
            return this;
        }

        public a e(Map.Entry entry) {
            return d(entry.getKey(), entry.getValue());
        }

        public a f(Iterable iterable) {
            if (iterable instanceof Collection) {
                c(this.c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                e((Map.Entry) it.next());
            }
            return this;
        }

        void g() {
            int i;
            if (this.a != null) {
                if (this.d) {
                    this.b = Arrays.copyOf(this.b, this.c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.c];
                int i2 = 0;
                while (true) {
                    i = this.c;
                    if (i2 >= i) {
                        break;
                    }
                    int i3 = i2 * 2;
                    Object obj = this.b[i3];
                    Objects.requireNonNull(obj);
                    Object obj2 = this.b[i3 + 1];
                    Objects.requireNonNull(obj2);
                    entryArr[i2] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
                    i2++;
                }
                Arrays.sort(entryArr, 0, i, UL4.a(this.a).c(AbstractC17096mO3.j()));
                for (int i4 = 0; i4 < this.c; i4++) {
                    int i5 = i4 * 2;
                    this.b[i5] = entryArr[i4].getKey();
                    this.b[i5 + 1] = entryArr[i4].getValue();
                }
            }
        }

        a(int i) {
            this.b = new Object[i * 2];
            this.c = 0;
            this.d = false;
        }
    }

    AbstractC13937h43() {
    }

    public static a b() {
        return new a();
    }

    public static a c(int i) {
        MW0.b(i, "expectedSize");
        return new a(i);
    }

    public static AbstractC13937h43 d(Iterable iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.f(iterable);
        return aVar.a();
    }

    public static AbstractC13937h43 e(Map map) {
        if ((map instanceof AbstractC13937h43) && !(map instanceof SortedMap)) {
            AbstractC13937h43 abstractC13937h43 = (AbstractC13937h43) map;
            if (!abstractC13937h43.l()) {
                return abstractC13937h43;
            }
        }
        return d(map.entrySet());
    }

    public static AbstractC13937h43 p() {
        return EM5.h;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return AbstractC17096mO3.c(this, obj);
    }

    abstract AbstractC14535i43 f();

    abstract AbstractC14535i43 g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return AbstractC3895Cu6.d(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    abstract Z33 j();

    @Override // java.util.Map
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractC14535i43 entrySet() {
        AbstractC14535i43 abstractC14535i43 = this.a;
        if (abstractC14535i43 != null) {
            return abstractC14535i43;
        }
        AbstractC14535i43 abstractC14535i43F = f();
        this.a = abstractC14535i43F;
        return abstractC14535i43F;
    }

    abstract boolean l();

    @Override // java.util.Map
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public AbstractC14535i43 keySet() {
        AbstractC14535i43 abstractC14535i43 = this.b;
        if (abstractC14535i43 != null) {
            return abstractC14535i43;
        }
        AbstractC14535i43 abstractC14535i43G = g();
        this.b = abstractC14535i43G;
        return abstractC14535i43G;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Z33 values() {
        Z33 z33 = this.c;
        if (z33 != null) {
            return z33;
        }
        Z33 z33J = j();
        this.c = z33J;
        return z33J;
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return AbstractC17096mO3.i(this);
    }
}
