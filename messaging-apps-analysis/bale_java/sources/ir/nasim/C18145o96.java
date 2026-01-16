package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.o96, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C18145o96 implements Iterable {
    c a;
    private c b;
    private final WeakHashMap c = new WeakHashMap();
    private int d = 0;

    /* renamed from: ir.nasim.o96$a */
    static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // ir.nasim.C18145o96.e
        c b(c cVar) {
            return cVar.d;
        }

        @Override // ir.nasim.C18145o96.e
        c c(c cVar) {
            return cVar.c;
        }
    }

    /* renamed from: ir.nasim.o96$b */
    private static class b extends e {
        b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // ir.nasim.C18145o96.e
        c b(c cVar) {
            return cVar.c;
        }

        @Override // ir.nasim.C18145o96.e
        c c(c cVar) {
            return cVar.d;
        }
    }

    /* renamed from: ir.nasim.o96$c */
    static class c implements Map.Entry {
        final Object a;
        final Object b;
        c c;
        c d;

        c(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.b.equals(cVar.b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.a + Separators.EQUALS + this.b;
        }
    }

    /* renamed from: ir.nasim.o96$d */
    public class d extends f implements Iterator {
        private c a;
        private boolean b = true;

        d() {
        }

        @Override // ir.nasim.C18145o96.f
        void a(c cVar) {
            c cVar2 = this.a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.d;
                this.a = cVar3;
                this.b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.b) {
                this.b = false;
                this.a = C18145o96.this.a;
            } else {
                c cVar = this.a;
                this.a = cVar != null ? cVar.c : null;
            }
            return this.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b) {
                return C18145o96.this.a != null;
            }
            c cVar = this.a;
            return (cVar == null || cVar.c == null) ? false : true;
        }
    }

    /* renamed from: ir.nasim.o96$e */
    private static abstract class e extends f implements Iterator {
        c a;
        c b;

        e(c cVar, c cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        private c e() {
            c cVar = this.b;
            c cVar2 = this.a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // ir.nasim.C18145o96.f
        public void a(c cVar) {
            if (this.a == cVar && cVar == this.b) {
                this.b = null;
                this.a = null;
            }
            c cVar2 = this.a;
            if (cVar2 == cVar) {
                this.a = b(cVar2);
            }
            if (this.b == cVar) {
                this.b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.b;
            this.b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }
    }

    /* renamed from: ir.nasim.o96$f */
    public static abstract class f {
        abstract void a(c cVar);
    }

    public Iterator descendingIterator() {
        b bVar = new b(this.b, this.a);
        this.c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C18145o96)) {
            return false;
        }
        C18145o96 c18145o96 = (C18145o96) obj;
        if (size() != c18145o96.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c18145o96.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry f() {
        return this.a;
    }

    protected c h(Object obj) {
        c cVar = this.a;
        while (cVar != null && !cVar.a.equals(obj)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    public d i() {
        d dVar = new d();
        this.c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.a, this.b);
        this.c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Map.Entry j() {
        return this.b;
    }

    c o(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.d++;
        c cVar2 = this.b;
        if (cVar2 == null) {
            this.a = cVar;
            this.b = cVar;
            return cVar;
        }
        cVar2.c = cVar;
        cVar.d = cVar2;
        this.b = cVar;
        return cVar;
    }

    public Object r(Object obj, Object obj2) {
        c cVarH = h(obj);
        if (cVarH != null) {
            return cVarH.b;
        }
        o(obj, obj2);
        return null;
    }

    public int size() {
        return this.d;
    }

    public Object t(Object obj) {
        c cVarH = h(obj);
        if (cVarH == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarH);
            }
        }
        c cVar = cVarH.d;
        if (cVar != null) {
            cVar.c = cVarH.c;
        } else {
            this.a = cVarH.c;
        }
        c cVar2 = cVarH.c;
        if (cVar2 != null) {
            cVar2.d = cVar;
        } else {
            this.b = cVar;
        }
        cVarH.c = null;
        cVarH.d = null;
        return cVarH.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
