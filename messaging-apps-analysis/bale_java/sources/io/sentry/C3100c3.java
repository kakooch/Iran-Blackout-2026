package io.sentry;

import io.sentry.C3035a3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.sentry.c3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3100c3 implements A0 {
    private List a;
    private Map b;

    /* renamed from: io.sentry.c3$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3100c3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            List listQ1 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("items")) {
                    listQ1 = interfaceC3118g1.Q1(iLogger, new C3035a3.a());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            interfaceC3118g1.F();
            if (listQ1 != null) {
                C3100c3 c3100c3 = new C3100c3(listQ1);
                c3100c3.b(map);
                return c3100c3;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"items\"");
            iLogger.b(Y2.ERROR, "Missing required field \"items\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public C3100c3(List list) {
        this.a = list;
    }

    public List a() {
        return this.a;
    }

    public void b(Map map) {
        this.b = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("items").l(iLogger, this.a);
        Map map = this.b;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.b.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
