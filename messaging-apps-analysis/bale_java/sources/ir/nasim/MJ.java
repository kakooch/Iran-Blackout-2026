package ir.nasim;

import ir.nasim.C9475a16;

/* loaded from: classes8.dex */
public abstract class MJ {
    private static final int a;

    static {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            AbstractC13042fc3.h(property, "getProperty(...)");
            objB = C9475a16.b(AbstractC19562qZ6.o(property));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        Integer num = (Integer) objB;
        a = num != null ? num.intValue() : 2097152;
    }
}
