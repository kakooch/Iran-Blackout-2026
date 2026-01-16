package ir.nasim;

import ir.nasim.AbstractC19670qk5;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.Gm4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4772Gm4 extends AbstractC19670qk5 {
    private final Map a;
    private final AtomicBoolean b;

    /* renamed from: ir.nasim.Gm4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry entry) {
            AbstractC13042fc3.i(entry, "entry");
            return "  " + ((AbstractC19670qk5.a) entry.getKey()).a() + " = " + entry.getValue();
        }
    }

    public /* synthetic */ C4772Gm4(Map map, boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? new LinkedHashMap() : map, (i & 2) != 0 ? true : z);
    }

    @Override // ir.nasim.AbstractC19670qk5
    public Map a() {
        Map mapUnmodifiableMap = Collections.unmodifiableMap(this.a);
        AbstractC13042fc3.h(mapUnmodifiableMap, "unmodifiableMap(preferencesMap)");
        return mapUnmodifiableMap;
    }

    @Override // ir.nasim.AbstractC19670qk5
    public Object b(AbstractC19670qk5.a aVar) {
        AbstractC13042fc3.i(aVar, "key");
        return this.a.get(aVar);
    }

    public final void e() {
        if (!(!this.b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C4772Gm4) {
            return AbstractC13042fc3.d(this.a, ((C4772Gm4) obj).a);
        }
        return false;
    }

    public final void f() {
        e();
        this.a.clear();
    }

    public final void g() {
        this.b.set(true);
    }

    public final void h(AbstractC19670qk5.b... bVarArr) {
        AbstractC13042fc3.i(bVarArr, "pairs");
        e();
        if (bVarArr.length <= 0) {
            return;
        }
        AbstractC19670qk5.b bVar = bVarArr[0];
        throw null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final Object i(AbstractC19670qk5.a aVar) {
        AbstractC13042fc3.i(aVar, "key");
        e();
        return this.a.remove(aVar);
    }

    public final void j(AbstractC19670qk5.a aVar, Object obj) {
        AbstractC13042fc3.i(aVar, "key");
        k(aVar, obj);
    }

    public final void k(AbstractC19670qk5.a aVar, Object obj) {
        AbstractC13042fc3.i(aVar, "key");
        e();
        if (obj == null) {
            i(aVar);
            return;
        }
        if (!(obj instanceof Set)) {
            this.a.put(aVar, obj);
            return;
        }
        Map map = this.a;
        Set setUnmodifiableSet = Collections.unmodifiableSet(AbstractC15401jX0.r1((Iterable) obj));
        AbstractC13042fc3.h(setUnmodifiableSet, "unmodifiableSet(value.toSet())");
        map.put(aVar, setUnmodifiableSet);
    }

    public String toString() {
        return AbstractC15401jX0.A0(this.a.entrySet(), ",\n", "{\n", "\n}", 0, null, a.e, 24, null);
    }

    public C4772Gm4(Map map, boolean z) {
        AbstractC13042fc3.i(map, "preferencesMap");
        this.a = map;
        this.b = new AtomicBoolean(z);
    }
}
