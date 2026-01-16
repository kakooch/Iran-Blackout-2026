package io.sentry;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.sentry.b3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3095b3 implements A0 {
    private String a;
    private Object b;
    private Map c;

    /* renamed from: io.sentry.b3$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3095b3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            String strG1 = null;
            Object objH1 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("type")) {
                    strG1 = interfaceC3118g1.g1();
                } else if (strN0.equals("value")) {
                    objH1 = interfaceC3118g1.H1();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            interfaceC3118g1.F();
            if (strG1 != null) {
                C3095b3 c3095b3 = new C3095b3(strG1, objH1);
                c3095b3.a(map);
                return c3095b3;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"type\"");
            iLogger.b(Y2.ERROR, "Missing required field \"type\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public C3095b3(String str, Object obj) {
        this.a = str;
        if (obj == null || !str.equals("string")) {
            this.b = obj;
        } else {
            this.b = obj.toString();
        }
    }

    public void a(Map map) {
        this.c = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("type").l(iLogger, this.a);
        interfaceC3123h1.f("value").l(iLogger, this.b);
        Map map = this.c;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.c.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
