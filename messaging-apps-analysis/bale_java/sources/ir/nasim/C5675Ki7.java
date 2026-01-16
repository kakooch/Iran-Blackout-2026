package ir.nasim;

import android.os.SystemClock;
import ir.nasim.InterfaceC20297rm3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Ki7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5675Ki7 implements Map, InterfaceC20297rm3 {
    private final long a;
    private final SA2 b;
    private final Map c;
    private final long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ir.nasim.Ki7$a */
    public static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(SystemClock.elapsedRealtime());
        }
    }

    /* renamed from: ir.nasim.Ki7$b */
    private static final class b implements Map.Entry, InterfaceC20297rm3.a {
        private final Object a;
        private Object b;

        public b(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }

        public void b(Object obj) {
            this.b = obj;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
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
            Object obj = this.a;
            int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
            Object obj2 = this.b;
            return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object value = getValue();
            b(obj);
            return value;
        }

        public String toString() {
            return "MutableEntry(key=" + this.a + ", value=" + this.b + ')';
        }
    }

    /* renamed from: ir.nasim.Ki7$c */
    private static final class c {
        private final Object a;
        private final long b;

        public c(Object obj, long j) {
            this.a = obj;
            this.b = j;
        }

        public final Object a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public final Object c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && this.b == cVar.b;
        }

        public int hashCode() {
            Object obj = this.a;
            return ((obj == null ? 0 : obj.hashCode()) * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "TTLItem(value=" + this.a + ", expiresAt=" + this.b + ')';
        }
    }

    public /* synthetic */ C5675Ki7(long j, SA2 sa2, ED1 ed1) {
        this(j, sa2);
    }

    private final long e() {
        return ((Number) this.b.invoke()).longValue();
    }

    public final void b() {
        long jE = e();
        Iterator it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            if (((c) ((Map.Entry) it.next()).getValue()).b() < jE) {
                it.remove();
            }
        }
    }

    public Set c() {
        b();
        Set<Map.Entry> setEntrySet = this.c.entrySet();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            arrayList.add(new b(entry.getKey(), ((c) entry.getValue()).c()));
        }
        return AbstractC15401jX0.q1(arrayList);
    }

    @Override // java.util.Map
    public void clear() {
        this.c.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public Set d() {
        b();
        return this.c.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return c();
    }

    public int f() {
        b();
        return this.c.size();
    }

    public Collection g() {
        b();
        Collection collectionValues = this.c.values();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionValues, 10));
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(((c) it.next()).a());
        }
        return AbstractC15401jX0.p1(arrayList);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        c cVar = (c) this.c.get(obj);
        if (cVar == null) {
            return null;
        }
        if (cVar.b() >= e()) {
            return cVar.c();
        }
        this.c.remove(obj);
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        b();
        return this.c.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return d();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        long jE = e();
        long jR = Q12.R(this.a, W12.d);
        if (jE - this.d > jR / 2) {
            b();
        }
        this.c.put(obj, new c(obj2, jE + jR));
        return obj2;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        AbstractC13042fc3.i(map, "from");
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        c cVar = (c) this.c.remove(obj);
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return g();
    }

    private C5675Ki7(long j, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "clock");
        this.a = j;
        this.b = sa2;
        this.c = new LinkedHashMap();
        this.d = e();
    }

    public /* synthetic */ C5675Ki7(long j, SA2 sa2, int i, ED1 ed1) {
        this(j, (i & 2) != 0 ? a.e : sa2, null);
    }
}
