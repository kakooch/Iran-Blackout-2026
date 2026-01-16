package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
final class l1 {
    private static final l1 c = new l1();
    private final ConcurrentMap b = new ConcurrentHashMap();
    private final p1 a = new Z0();

    private l1() {
    }

    public static l1 a() {
        return c;
    }

    public final o1 b(Class cls) {
        R0.f(cls, "messageType");
        o1 o1VarA = (o1) this.b.get(cls);
        if (o1VarA == null) {
            o1VarA = this.a.a(cls);
            R0.f(cls, "messageType");
            R0.f(o1VarA, "schema");
            o1 o1Var = (o1) this.b.putIfAbsent(cls, o1VarA);
            if (o1Var != null) {
                return o1Var;
            }
        }
        return o1VarA;
    }
}
