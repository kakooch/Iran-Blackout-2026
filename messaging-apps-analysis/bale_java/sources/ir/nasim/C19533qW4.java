package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.qW4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19533qW4 implements Iterable, InterfaceC17915nm3 {
    public static final b b = new b(null);
    public static final C19533qW4 c = new C19533qW4();
    private final Map a;

    /* renamed from: ir.nasim.qW4$a */
    public static final class a {
        private final Map a;

        public a(C19533qW4 c19533qW4) {
            this.a = AbstractC20051rO3.A(c19533qW4.a);
        }

        public final C19533qW4 a() {
            return new C19533qW4(AbstractC12074e.b(this.a), null);
        }
    }

    /* renamed from: ir.nasim.qW4$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C19533qW4(Map map, ED1 ed1) {
        this(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C19533qW4) && AbstractC13042fc3.d(this.a, ((C19533qW4) obj).a);
    }

    public final Map h() {
        if (isEmpty()) {
            return AbstractC20051rO3.k();
        }
        Map map = this.a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return linkedHashMap;
        }
        AbstractC18350oW3.a(((Map.Entry) it.next()).getValue());
        throw null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final a i() {
        return new a(this);
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Map map = this.a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            AbstractC18350oW3.a(entry.getValue());
            arrayList.add(AbstractC4616Fw7.a(str, null));
        }
        return arrayList.iterator();
    }

    public final Object j(String str) {
        AbstractC18350oW3.a(this.a.get(str));
        return null;
    }

    public String toString() {
        return "Parameters(entries=" + this.a + ')';
    }

    private C19533qW4(Map map) {
        this.a = map;
    }

    public C19533qW4() {
        this(AbstractC20051rO3.k());
    }
}
