package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* renamed from: ir.nasim.qB3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19343qB3 extends AbstractMap implements Serializable {
    private static final Comparator i = new a();
    private final Comparator a;
    private final boolean b;
    e c;
    int d;
    int e;
    final e f;
    private b g;
    private c h;

    /* renamed from: ir.nasim.qB3$a */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* renamed from: ir.nasim.qB3$b */
    class b extends AbstractSet {

        /* renamed from: ir.nasim.qB3$b$a */
        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C19343qB3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && C19343qB3.this.d((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e eVarD;
            if (!(obj instanceof Map.Entry) || (eVarD = C19343qB3.this.d((Map.Entry) obj)) == null) {
                return false;
            }
            C19343qB3.this.g(eVarD, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C19343qB3.this.d;
        }
    }

    /* renamed from: ir.nasim.qB3$c */
    final class c extends AbstractSet {

        /* renamed from: ir.nasim.qB3$c$a */
        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a().f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C19343qB3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C19343qB3.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return C19343qB3.this.j(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C19343qB3.this.d;
        }
    }

    /* renamed from: ir.nasim.qB3$d */
    private abstract class d implements Iterator {
        e a;
        e b = null;
        int c;

        d() {
            this.a = C19343qB3.this.f.d;
            this.c = C19343qB3.this.e;
        }

        final e a() {
            e eVar = this.a;
            C19343qB3 c19343qB3 = C19343qB3.this;
            if (eVar == c19343qB3.f) {
                throw new NoSuchElementException();
            }
            if (c19343qB3.e != this.c) {
                throw new ConcurrentModificationException();
            }
            this.a = eVar.d;
            this.b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != C19343qB3.this.f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            C19343qB3.this.g(eVar, true);
            this.b = null;
            this.c = C19343qB3.this.e;
        }
    }

    public C19343qB3() {
        this(i, true);
    }

    private boolean b(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void f(e eVar, boolean z) {
        while (eVar != null) {
            e eVar2 = eVar.b;
            e eVar3 = eVar.c;
            int i2 = eVar2 != null ? eVar2.i : 0;
            int i3 = eVar3 != null ? eVar3.i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e eVar4 = eVar3.b;
                e eVar5 = eVar3.c;
                int i5 = (eVar4 != null ? eVar4.i : 0) - (eVar5 != null ? eVar5.i : 0);
                if (i5 == -1 || (i5 == 0 && !z)) {
                    l(eVar);
                } else {
                    n(eVar3);
                    l(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e eVar6 = eVar2.b;
                e eVar7 = eVar2.c;
                int i6 = (eVar6 != null ? eVar6.i : 0) - (eVar7 != null ? eVar7.i : 0);
                if (i6 == 1 || (i6 == 0 && !z)) {
                    n(eVar);
                } else {
                    l(eVar2);
                    n(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.a;
        }
    }

    private void k(e eVar, e eVar2) {
        e eVar3 = eVar.a;
        eVar.a = null;
        if (eVar2 != null) {
            eVar2.a = eVar3;
        }
        if (eVar3 == null) {
            this.c = eVar2;
        } else if (eVar3.b == eVar) {
            eVar3.b = eVar2;
        } else {
            eVar3.c = eVar2;
        }
    }

    private void l(e eVar) {
        e eVar2 = eVar.b;
        e eVar3 = eVar.c;
        e eVar4 = eVar3.b;
        e eVar5 = eVar3.c;
        eVar.c = eVar4;
        if (eVar4 != null) {
            eVar4.a = eVar;
        }
        k(eVar, eVar3);
        eVar3.b = eVar;
        eVar.a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.i : 0, eVar4 != null ? eVar4.i : 0) + 1;
        eVar.i = iMax;
        eVar3.i = Math.max(iMax, eVar5 != null ? eVar5.i : 0) + 1;
    }

    private void n(e eVar) {
        e eVar2 = eVar.b;
        e eVar3 = eVar.c;
        e eVar4 = eVar2.b;
        e eVar5 = eVar2.c;
        eVar.b = eVar5;
        if (eVar5 != null) {
            eVar5.a = eVar;
        }
        k(eVar, eVar2);
        eVar2.c = eVar;
        eVar.a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.i : 0, eVar5 != null ? eVar5.i : 0) + 1;
        eVar.i = iMax;
        eVar2.i = Math.max(iMax, eVar4 != null ? eVar4.i : 0) + 1;
    }

    e c(Object obj, boolean z) {
        int iCompareTo;
        e eVar;
        Comparator comparator = this.a;
        e eVar2 = this.c;
        if (eVar2 != null) {
            Comparable comparable = comparator == i ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f) : comparator.compare(obj, eVar2.f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e eVar3 = iCompareTo < 0 ? eVar2.b : eVar2.c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        e eVar4 = this.f;
        if (eVar2 != null) {
            eVar = new e(this.b, eVar2, obj, eVar4, eVar4.e);
            if (iCompareTo < 0) {
                eVar2.b = eVar;
            } else {
                eVar2.c = eVar;
            }
            f(eVar2, true);
        } else {
            if (comparator == i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.b, eVar2, obj, eVar4, eVar4.e);
            this.c = eVar;
        }
        this.d++;
        this.e++;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.c = null;
        this.d = 0;
        this.e++;
        e eVar = this.f;
        eVar.e = eVar;
        eVar.d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return e(obj) != null;
    }

    e d(Map.Entry entry) {
        e eVarE = e(entry.getKey());
        if (eVarE == null || !b(eVarE.h, entry.getValue())) {
            return null;
        }
        return eVarE;
    }

    e e(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return c(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.g = bVar2;
        return bVar2;
    }

    void g(e eVar, boolean z) {
        int i2;
        if (z) {
            e eVar2 = eVar.e;
            eVar2.d = eVar.d;
            eVar.d.e = eVar2;
        }
        e eVar3 = eVar.b;
        e eVar4 = eVar.c;
        e eVar5 = eVar.a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                k(eVar, eVar3);
                eVar.b = null;
            } else if (eVar4 != null) {
                k(eVar, eVar4);
                eVar.c = null;
            } else {
                k(eVar, null);
            }
            f(eVar5, false);
            this.d--;
            this.e++;
            return;
        }
        e eVarB = eVar3.i > eVar4.i ? eVar3.b() : eVar4.a();
        g(eVarB, false);
        e eVar6 = eVar.b;
        if (eVar6 != null) {
            i2 = eVar6.i;
            eVarB.b = eVar6;
            eVar6.a = eVarB;
            eVar.b = null;
        } else {
            i2 = 0;
        }
        e eVar7 = eVar.c;
        if (eVar7 != null) {
            i3 = eVar7.i;
            eVarB.c = eVar7;
            eVar7.a = eVarB;
            eVar.c = null;
        }
        eVarB.i = Math.max(i2, i3) + 1;
        k(eVar, eVarB);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e eVarE = e(obj);
        if (eVarE != null) {
            return eVarE.h;
        }
        return null;
    }

    e j(Object obj) {
        e eVarE = e(obj);
        if (eVarE != null) {
            g(eVarE, true);
        }
        return eVarE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.b) {
            throw new NullPointerException("value == null");
        }
        e eVarC = c(obj, true);
        Object obj3 = eVarC.h;
        eVarC.h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e eVarJ = j(obj);
        if (eVarJ != null) {
            return eVarJ.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.d;
    }

    public C19343qB3(boolean z) {
        this(i, z);
    }

    public C19343qB3(Comparator comparator, boolean z) {
        this.d = 0;
        this.e = 0;
        this.a = comparator == null ? i : comparator;
        this.b = z;
        this.f = new e(z);
    }

    /* renamed from: ir.nasim.qB3$e */
    static final class e implements Map.Entry {
        e a;
        e b;
        e c;
        e d;
        e e;
        final Object f;
        final boolean g;
        Object h;
        int i;

        e(boolean z) {
            this.f = null;
            this.g = z;
            this.e = this;
            this.d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.b; eVar2 != null; eVar2 = eVar2.b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.c; eVar2 != null; eVar2 = eVar2.c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.h;
            if (obj3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.h;
            this.h = obj;
            return obj2;
        }

        public String toString() {
            return this.f + Separators.EQUALS + this.h;
        }

        e(boolean z, e eVar, Object obj, e eVar2, e eVar3) {
            this.a = eVar;
            this.f = obj;
            this.g = z;
            this.i = 1;
            this.d = eVar2;
            this.e = eVar3;
            eVar3.d = this;
            eVar2.e = this;
        }
    }
}
