package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.protocol.C3172g;
import io.sentry.util.AbstractC3204c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class G implements A0 {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private C3172g f;
    private Map g;
    private Map h;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public G a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            G g = new G();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "username":
                        g.c = interfaceC3118g1.g1();
                        break;
                    case "id":
                        g.b = interfaceC3118g1.g1();
                        break;
                    case "geo":
                        g.f = new C3172g.a().a(interfaceC3118g1, iLogger);
                        break;
                    case "data":
                        g.g = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        break;
                    case "name":
                        g.e = interfaceC3118g1.g1();
                        break;
                    case "email":
                        g.a = interfaceC3118g1.g1();
                        break;
                    case "ip_address":
                        g.d = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            g.n(concurrentHashMap);
            interfaceC3118g1.F();
            return g;
        }
    }

    public G() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || G.class != obj.getClass()) {
            return false;
        }
        G g = (G) obj;
        return io.sentry.util.u.a(this.a, g.a) && io.sentry.util.u.a(this.b, g.b) && io.sentry.util.u.a(this.c, g.c) && io.sentry.util.u.a(this.d, g.d);
    }

    public String h() {
        return this.a;
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b, this.c, this.d);
    }

    public String i() {
        return this.b;
    }

    public String j() {
        return this.d;
    }

    public String k() {
        return this.c;
    }

    public void l(String str) {
        this.b = str;
    }

    public void m(String str) {
        this.d = str;
    }

    public void n(Map map) {
        this.h = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("email").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("id").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("username").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("ip_address").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("name").h(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("geo");
            this.f.serialize(interfaceC3123h1, iLogger);
        }
        if (this.g != null) {
            interfaceC3123h1.f("data").l(iLogger, this.g);
        }
        Map map = this.h;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.h.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public G(G g) {
        this.a = g.a;
        this.c = g.c;
        this.b = g.b;
        this.d = g.d;
        this.e = g.e;
        this.f = g.f;
        this.g = AbstractC3204c.b(g.g);
        this.h = AbstractC3204c.b(g.h);
    }
}
