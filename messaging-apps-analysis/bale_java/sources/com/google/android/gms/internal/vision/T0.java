package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
abstract class T0 extends AbstractMap {
    private final int a;
    private List b;
    private Map c;
    private boolean d;
    private volatile a1 e;
    private Map f;
    private volatile U0 g;

    private T0(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int b(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L25
            java.util.List r2 = r4.b
            java.lang.Object r2 = r2.get(r1)
            com.google.android.gms.internal.vision.Y0 r2 = (com.google.android.gms.internal.vision.Y0) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L22
            int r0 = r0 + 1
        L20:
            int r5 = -r0
            return r5
        L22:
            if (r2 != 0) goto L25
            return r1
        L25:
            r0 = 0
        L26:
            if (r0 > r1) goto L49
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.b
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.vision.Y0 r3 = (com.google.android.gms.internal.vision.Y0) r3
            java.lang.Object r3 = r3.getKey()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L43
            int r1 = r2 + (-1)
            goto L26
        L43:
            if (r3 <= 0) goto L48
            int r0 = r2 + 1
            goto L26
        L48:
            return r2
        L49:
            int r0 = r0 + 1
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.T0.b(java.lang.Comparable):int");
    }

    static T0 c(int i) {
        return new S0(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(int i) {
        s();
        Object value = ((Y0) this.b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = t().entrySet().iterator();
            this.b.add(new Y0(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap t() {
        s();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        s();
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
        return b(comparable) >= 0 || this.c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        s();
        int iB = b(comparable);
        if (iB >= 0) {
            return ((Y0) this.b.get(iB)).setValue(obj);
        }
        s();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.a);
        }
        int i = -(iB + 1);
        if (i >= this.a) {
            return t().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            Y0 y0 = (Y0) this.b.remove(i2 - 1);
            t().put((Comparable) y0.getKey(), y0.getValue());
        }
        this.b.add(i, new Y0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.e == null) {
            this.e = new a1(this, null);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof T0)) {
            return super.equals(obj);
        }
        T0 t0 = (T0) obj;
        int size = size();
        if (size != t0.size()) {
            return false;
        }
        int iK = k();
        if (iK != t0.k()) {
            return entrySet().equals(t0.entrySet());
        }
        for (int i = 0; i < iK; i++) {
            if (!i(i).equals(t0.i(i))) {
                return false;
            }
        }
        if (iK != size) {
            return this.c.equals(t0.c);
        }
        return true;
    }

    public void f() {
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
        this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
        this.d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iB = b(comparable);
        return iB >= 0 ? ((Y0) this.b.get(iB)).getValue() : this.c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i = 0; i < iK; i++) {
            iHashCode += ((Y0) this.b.get(i)).hashCode();
        }
        return this.c.size() > 0 ? iHashCode + this.c.hashCode() : iHashCode;
    }

    public final Map.Entry i(int i) {
        return (Map.Entry) this.b.get(i);
    }

    public final boolean j() {
        return this.d;
    }

    public final int k() {
        return this.b.size();
    }

    public final Iterable o() {
        return this.c.isEmpty() ? X0.a() : this.c.entrySet();
    }

    final Set q() {
        if (this.g == null) {
            this.g = new U0(this, null);
        }
        return this.g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        s();
        Comparable comparable = (Comparable) obj;
        int iB = b(comparable);
        if (iB >= 0) {
            return l(iB);
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

    /* synthetic */ T0(int i, S0 s0) {
        this(i);
    }
}
