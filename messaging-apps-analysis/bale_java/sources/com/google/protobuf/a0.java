package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
final class a0 {
    private static final a0 c = new a0();
    private final ConcurrentMap b = new ConcurrentHashMap();
    private final f0 a = new H();

    private a0() {
    }

    public static a0 a() {
        return c;
    }

    public e0 b(Class cls, e0 e0Var) {
        B.b(cls, "messageType");
        B.b(e0Var, "schema");
        return (e0) this.b.putIfAbsent(cls, e0Var);
    }

    public e0 c(Class cls) {
        B.b(cls, "messageType");
        e0 e0Var = (e0) this.b.get(cls);
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0VarA = this.a.a(cls);
        e0 e0VarB = b(cls, e0VarA);
        return e0VarB != null ? e0VarB : e0VarA;
    }

    public e0 d(Object obj) {
        return c(obj.getClass());
    }
}
