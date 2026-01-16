package com.google.protobuf;

import android.gov.nist.core.Separators;
import com.google.protobuf.C2399x;
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

/* loaded from: classes3.dex */
abstract class h0 extends AbstractMap {
    private final int a;
    private List b;
    private Map c;
    private boolean d;
    private volatile g e;
    private Map f;
    private volatile c g;

    class a extends h0 {
        a(int i) {
            super(i, null);
        }

        @Override // com.google.protobuf.h0
        public void s() {
            if (!q()) {
                for (int i = 0; i < l(); i++) {
                    Map.Entry entryK = k(i);
                    if (((C2399x.b) entryK.getKey()).b()) {
                        entryK.setValue(Collections.unmodifiableList((List) entryK.getValue()));
                    }
                }
                for (Map.Entry entry : o()) {
                    if (((C2399x.b) entry.getKey()).b()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.s();
        }
    }

    private class c extends g {
        private c() {
            super(h0.this, null);
        }

        @Override // com.google.protobuf.h0.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new b(h0.this, null);
        }

        /* synthetic */ c(h0 h0Var, a aVar) {
            this();
        }
    }

    private static class d {
        private static final Iterator a = new a();
        private static final Iterable b = new b();

        class a implements Iterator {
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

        class b implements Iterable {
            b() {
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return d.a;
            }
        }

        static Iterable b() {
            return b;
        }
    }

    private class e implements Map.Entry, Comparable {
        private final Comparable a;
        private Object b;

        e(h0 h0Var, Map.Entry entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        private boolean h(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return getKey().compareTo(eVar.getKey());
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
            h0.this.h();
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }

        public String toString() {
            return this.a + Separators.EQUALS + this.b;
        }

        e(Comparable comparable, Object obj) {
            this.a = comparable;
            this.b = obj;
        }
    }

    private class g extends AbstractSet {
        private g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = h0.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            if (contains(entry)) {
                return false;
            }
            h0.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new f(h0.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            h0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h0.this.size();
        }

        /* synthetic */ g(h0 h0Var, a aVar) {
            this();
        }
    }

    /* synthetic */ h0(int i, a aVar) {
        this(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int g(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List r2 = r4.b
            java.lang.Object r2 = r2.get(r1)
            com.google.protobuf.h0$e r2 = (com.google.protobuf.h0.e) r2
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
            com.google.protobuf.h0$e r3 = (com.google.protobuf.h0.e) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.h0.g(java.lang.Comparable):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    private void j() {
        h();
        if (!this.b.isEmpty() || (this.b instanceof ArrayList)) {
            return;
        }
        this.b = new ArrayList(this.a);
    }

    private SortedMap p() {
        h();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    static h0 t(int i) {
        return new a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object v(int i) {
        h();
        Object value = ((e) this.b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = p().entrySet().iterator();
            this.b.add(new e(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
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
        return g(comparable) >= 0 || this.c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.e == null) {
            this.e = new g(this, null);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return super.equals(obj);
        }
        h0 h0Var = (h0) obj;
        int size = size();
        if (size != h0Var.size()) {
            return false;
        }
        int iL = l();
        if (iL != h0Var.l()) {
            return entrySet().equals(h0Var.entrySet());
        }
        for (int i = 0; i < iL; i++) {
            if (!k(i).equals(h0Var.k(i))) {
                return false;
            }
        }
        if (iL != size) {
            return this.c.equals(h0Var.c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        return iG >= 0 ? ((e) this.b.get(iG)).getValue() : this.c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iL = l();
        int iHashCode = 0;
        for (int i = 0; i < iL; i++) {
            iHashCode += ((e) this.b.get(i)).hashCode();
        }
        return n() > 0 ? iHashCode + this.c.hashCode() : iHashCode;
    }

    Set i() {
        if (this.g == null) {
            this.g = new c(this, null);
        }
        return this.g;
    }

    public Map.Entry k(int i) {
        return (Map.Entry) this.b.get(i);
    }

    public int l() {
        return this.b.size();
    }

    public int n() {
        return this.c.size();
    }

    public Iterable o() {
        return this.c.isEmpty() ? d.b() : this.c.entrySet();
    }

    public boolean q() {
        return this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        if (iG >= 0) {
            return v(iG);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    public void s() {
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
        this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
        this.d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b.size() + this.c.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object put(Comparable comparable, Object obj) {
        h();
        int iG = g(comparable);
        if (iG >= 0) {
            return ((e) this.b.get(iG)).setValue(obj);
        }
        j();
        int i = -(iG + 1);
        if (i >= this.a) {
            return p().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            e eVar = (e) this.b.remove(i2 - 1);
            p().put(eVar.getKey(), eVar.getValue());
        }
        this.b.add(i, new e(comparable, obj));
        return null;
    }

    private class b implements Iterator {
        private int a;
        private Iterator b;

        private b() {
            this.a = h0.this.b.size();
        }

        private Iterator a() {
            if (this.b == null) {
                this.b = h0.this.f.entrySet().iterator();
            }
            return this.b;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List list = h0.this.b;
            int i = this.a - 1;
            this.a = i;
            return (Map.Entry) list.get(i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.a;
            return (i > 0 && i <= h0.this.b.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ b(h0 h0Var, a aVar) {
            this();
        }
    }

    private class f implements Iterator {
        private int a;
        private boolean b;
        private Iterator c;

        private f() {
            this.a = -1;
        }

        private Iterator a() {
            if (this.c == null) {
                this.c = h0.this.c.entrySet().iterator();
            }
            return this.c;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            this.b = true;
            int i = this.a + 1;
            this.a = i;
            return i < h0.this.b.size() ? (Map.Entry) h0.this.b.get(this.a) : (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a + 1 >= h0.this.b.size()) {
                return !h0.this.c.isEmpty() && a().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.b = false;
            h0.this.h();
            if (this.a >= h0.this.b.size()) {
                a().remove();
                return;
            }
            h0 h0Var = h0.this;
            int i = this.a;
            this.a = i - 1;
            h0Var.v(i);
        }

        /* synthetic */ f(h0 h0Var, a aVar) {
            this();
        }
    }

    private h0(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }
}
