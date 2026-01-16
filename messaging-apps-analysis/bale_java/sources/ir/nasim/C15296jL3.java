package ir.nasim;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.jL3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15296jL3 implements Map, InterfaceC20297rm3 {
    private static final a b = new a(null);
    private final /* synthetic */ Map a;

    /* renamed from: ir.nasim.jL3$a */
    private static final class a {

        /* renamed from: ir.nasim.jL3$a$a, reason: collision with other inner class name */
        public static final class C1312a extends LinkedHashMap {
            final /* synthetic */ int a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1312a(int i, float f, int i2) {
                super(i, f, true);
                this.a = i2;
            }

            public /* bridge */ Set b() {
                return super.entrySet();
            }

            public /* bridge */ Set c() {
                return super.keySet();
            }

            public /* bridge */ int d() {
                return super.size();
            }

            public /* bridge */ Collection e() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set entrySet() {
                return b();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set keySet() {
                return c();
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry entry) {
                AbstractC13042fc3.i(entry, "eldest");
                return size() > this.a;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return d();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection values() {
                return e();
            }
        }

        private a() {
        }

        public final LinkedHashMap a(int i) {
            int iHighestOneBit = Integer.highestOneBit((i - 1) << 1);
            return new C1312a(iHighestOneBit, AbstractC23053wG5.h((i / iHighestOneBit) + 0.1f, 1.0f), i);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private C15296jL3(Map map) {
        this.a = map;
    }

    public Set b() {
        return this.a.entrySet();
    }

    public Set c() {
        return this.a.keySet();
    }

    @Override // java.util.Map
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.a.containsValue(obj);
    }

    public int d() {
        return this.a.size();
    }

    public Collection e() {
        return this.a.values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return b();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.a.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return c();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return this.a.put(obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        AbstractC13042fc3.i(map, "from");
        this.a.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.a.remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return e();
    }

    public C15296jL3(int i) {
        this(b.a(i));
    }
}
