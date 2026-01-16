package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.util.AbstractC3204c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class n implements A0 {
    private String a;
    private Map b;
    private Integer c;
    private Long d;
    private Object e;
    private Map f;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public n a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            n nVar = new n();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "status_code":
                        nVar.c = interfaceC3118g1.Y0();
                        break;
                    case "data":
                        nVar.e = interfaceC3118g1.H1();
                        break;
                    case "headers":
                        Map map = (Map) interfaceC3118g1.H1();
                        if (map == null) {
                            break;
                        } else {
                            nVar.b = AbstractC3204c.b(map);
                            break;
                        }
                    case "cookies":
                        nVar.a = interfaceC3118g1.g1();
                        break;
                    case "body_size":
                        nVar.d = interfaceC3118g1.a1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            nVar.f(concurrentHashMap);
            interfaceC3118g1.F();
            return nVar;
        }
    }

    public n() {
    }

    public void f(Map map) {
        this.f = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("cookies").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("headers").l(iLogger, this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("status_code").l(iLogger, this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("body_size").l(iLogger, this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("data").l(iLogger, this.e);
        }
        Map map = this.f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public n(n nVar) {
        this.a = nVar.a;
        this.b = AbstractC3204c.b(nVar.b);
        this.f = AbstractC3204c.b(nVar.f);
        this.c = nVar.c;
        this.d = nVar.d;
        this.e = nVar.e;
    }
}
