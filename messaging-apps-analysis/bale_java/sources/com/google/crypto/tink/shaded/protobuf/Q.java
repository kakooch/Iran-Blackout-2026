package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
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
        AbstractC2360w.b(cls, "messageType");
        AbstractC2360w.b(v, "schema");
        return (V) this.b.putIfAbsent(cls, v);
    }

    public V c(Class cls) {
        AbstractC2360w.b(cls, "messageType");
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
