package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
final class Q {
    private static final Q c = new Q();
    private final ConcurrentMap b = new ConcurrentHashMap();
    private final W a = new A();

    private Q() {
    }

    public static Q a() {
        return c;
    }

    public V b(Class cls, V v) {
        AbstractC1952v.b(cls, "messageType");
        AbstractC1952v.b(v, "schema");
        return (V) this.b.putIfAbsent(cls, v);
    }

    public V c(Class cls) {
        AbstractC1952v.b(cls, "messageType");
        V v = (V) this.b.get(cls);
        if (v != null) {
            return v;
        }
        V vA = this.a.a(cls);
        V vB = b(cls, vA);
        return vB != null ? vB : vA;
    }

    public V d(Object obj) {
        return c(obj.getClass());
    }
}
