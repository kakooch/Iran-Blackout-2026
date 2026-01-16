package kotlin.reflect.jvm.internal.impl.protobuf;

import android.gov.nist.core.Separators;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.reflect.jvm.internal.impl.protobuf.g;

/* loaded from: classes8.dex */
abstract class n extends AbstractMap {
    private final int a;
    private List b;
    private Map c;
    private boolean d;
    private volatile e e;

    static class a extends n {
        a(int i) {
            super(i, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void o() {
            if (!n()) {
                for (int i = 0; i < j(); i++) {
                    Map.Entry entryI = i(i);
                    if (((g.b) entryI.getKey()).b()) {
                        entryI.setValue(Collections.unmodifiableList((List) entryI.getValue()));
                    }
                }
                for (Map.Entry entry : k()) {
                    if (((g.b) entry.getKey()).b()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.o();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.q((g.b) obj, obj2);
        }
    }

    private static class b {
        private static final Iterator a = new a();
        private static final Iterable b = new C1830b();

        static class a implements Iterator {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.n$b$b, reason: collision with other inner class name */
        static class C1830b implements Iterable {
            C1830b() {
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return b.a;
            }
        }

        static Iterable b() {
            return b;
        }
    }

    private class c implements Comparable, Map.Entry {
        private final Comparable a;
        private Object b;

        c(n nVar, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean h(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return h(this.a, entry.getKey()) && h(this.b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Comparable comparable = this.a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.b;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Comparable getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            n.this.g();
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
            sb.append(strValueOf);
            sb.append(Separators.EQUALS);
            sb.append(strValueOf2);
            return sb.toString();
        }

        c(Comparable comparable, Object obj) {
            this.a = comparable;
            this.b = obj;
        }
    }

    private class e extends AbstractSet {
        private e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            n.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = n.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            n.this.q((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new d(n.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            n.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return n.this.size();
        }

        /* synthetic */ e(n nVar, a aVar) {
            this();
        }
    }

    /* synthetic */ n(int i, a aVar) {
        this(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int f(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.b
            java.lang.Object r2 = r2.get(r1)
            kotlin.reflect.jvm.internal.impl.protobuf.n$c r2 = (kotlin.reflect.jvm.internal.impl.protobuf.n.c) r2
            java.lang.Comparable r2 = r2.getKey()
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L20
            int r0 = r0 + 1
        L1e:
            int r5 = -r0
            return r5
        L20:
            if (r2 != 0) goto L23
            return r1
        L23:
            r0 = 0
        L24:
            if (r0 > r1) goto L47
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.b
            java.lang.Object r3 = r3.get(r2)
            kotlin.reflect.jvm.internal.impl.protobuf.n$c r3 = (kotlin.reflect.jvm.internal.impl.protobuf.n.c) r3
            java.lang.Comparable r3 = r3.getKey()
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L40
            int r2 = r2 + (-1)
            r1 = r2
            goto L24
        L40:
            if (r3 <= 0) goto L46
            int r2 = r2 + 1
            r0 = r2
            goto L24
        L46:
            return r2
        L47:
            int r0 = r0 + 1
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.n.f(java.lang.Comparable):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    private void h() {
        g();
        if (!this.b.isEmpty() || (this.b instanceof ArrayList)) {
            return;
        }
        this.b = new ArrayList(this.a);
    }

    private SortedMap l() {
        g();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
        }
        return (SortedMap) this.c;
    }

    static n p(int i) {
        return new a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object s(int i) {
        g();
        Object value = ((c) this.b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = l().entrySet().iterator();
            this.b.add(new c(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.e == null) {
            this.e = new e(this, null);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((c) this.b.get(iF)).getValue() : this.c.get(comparable);
    }

    public Map.Entry i(int i) {
        return (Map.Entry) this.b.get(i);
    }

    public int j() {
        return this.b.size();
    }

    public Iterable k() {
        return this.c.isEmpty() ? b.b() : this.c.entrySet();
    }

    public boolean n() {
        return this.d;
    }

    public void o() {
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
        this.d = true;
    }

    public Object q(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((c) this.b.get(iF)).setValue(obj);
        }
        h();
        int i = -(iF + 1);
        if (i >= this.a) {
            return l().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            c cVar = (c) this.b.remove(i2 - 1);
            l().put(cVar.getKey(), cVar.getValue());
        }
        this.b.add(i, new c(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return s(iF);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b.size() + this.c.size();
    }

    private class d implements Iterator {
        private int a;
        private boolean b;
        private Iterator c;

        private d() {
            this.a = -1;
        }

        private Iterator a() {
            if (this.c == null) {
                this.c = n.this.c.entrySet().iterator();
            }
            return this.c;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.b = true;
            int i = this.a + 1;
            this.a = i;
            return i < n.this.b.size() ? (Map.Entry) n.this.b.get(this.a) : (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a + 1 < n.this.b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.b = false;
            n.this.g();
            if (this.a >= n.this.b.size()) {
                a().remove();
                return;
            }
            n nVar = n.this;
            int i = this.a;
            this.a = i - 1;
            nVar.s(i);
        }

        /* synthetic */ d(n nVar, a aVar) {
            this();
        }
    }

    private n(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
    }
}
