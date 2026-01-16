package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.C3163p1;
import io.sentry.H3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.protocol.C3166a;
import io.sentry.protocol.C3167b;
import io.sentry.protocol.C3170e;
import io.sentry.protocol.C3171f;
import io.sentry.protocol.C3173h;
import io.sentry.protocol.D;
import io.sentry.protocol.l;
import io.sentry.protocol.n;
import io.sentry.protocol.x;
import io.sentry.util.C3202a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.protocol.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3168c implements A0 {
    private final ConcurrentHashMap a = new ConcurrentHashMap();
    protected final C3202a b = new C3202a();

    /* renamed from: io.sentry.protocol.c$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3168c a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            C3168c c3168c = new C3168c();
            interfaceC3118g1.B();
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "device":
                        c3168c.p(new C3170e.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "spring":
                        c3168c.w(new D.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "response":
                        c3168c.u(new n.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "profile":
                        c3168c.t(new C3163p1.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "feedback":
                        c3168c.q(new C3171f.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "os":
                        c3168c.s(new l.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "app":
                        c3168c.n(new C3166a.C0249a().a(interfaceC3118g1, iLogger));
                        break;
                    case "gpu":
                        c3168c.r(new C3173h.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "trace":
                        c3168c.x(new H3.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "browser":
                        c3168c.o(new C3167b.a().a(interfaceC3118g1, iLogger));
                        break;
                    case "runtime":
                        c3168c.v(new x.a().a(interfaceC3118g1, iLogger));
                        break;
                    default:
                        Object objH1 = interfaceC3118g1.H1();
                        if (objH1 == null) {
                            break;
                        } else {
                            c3168c.k(strN0, objH1);
                            break;
                        }
                }
            }
            interfaceC3118g1.F();
            return c3168c;
        }
    }

    public C3168c() {
    }

    private Object y(String str, Class cls) {
        Object objC = c(str);
        if (cls.isInstance(objC)) {
            return cls.cast(objC);
        }
        return null;
    }

    public boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.a.containsKey(obj);
    }

    public Set b() {
        return this.a.entrySet();
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.a.get(obj);
    }

    public C3166a d() {
        return (C3166a) y("app", C3166a.class);
    }

    public C3170e e() {
        return (C3170e) y("device", C3170e.class);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C3168c)) {
            return false;
        }
        return this.a.equals(((C3168c) obj).a);
    }

    public C3171f f() {
        return (C3171f) y("feedback", C3171f.class);
    }

    public l g() {
        return (l) y("os", l.class);
    }

    public x h() {
        return (x) y("runtime", x.class);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public H3 i() {
        return (H3) y("trace", H3.class);
    }

    public Enumeration j() {
        return this.a.keys();
    }

    public Object k(String str, Object obj) {
        if (str == null) {
            return null;
        }
        return obj == null ? this.a.remove(str) : this.a.put(str, obj);
    }

    public void l(C3168c c3168c) {
        if (c3168c == null) {
            return;
        }
        this.a.putAll(c3168c.a);
    }

    public Object m(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.a.remove(obj);
    }

    public void n(C3166a c3166a) {
        k("app", c3166a);
    }

    public void o(C3167b c3167b) {
        k("browser", c3167b);
    }

    public void p(C3170e c3170e) {
        k("device", c3170e);
    }

    public void q(C3171f c3171f) {
        k("feedback", c3171f);
    }

    public void r(C3173h c3173h) {
        k("gpu", c3173h);
    }

    public void s(l lVar) {
        k("os", lVar);
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        ArrayList<String> list = Collections.list(j());
        Collections.sort(list);
        for (String str : list) {
            Object objC = c(str);
            if (objC != null) {
                interfaceC3123h1.f(str).l(iLogger, objC);
            }
        }
        interfaceC3123h1.F();
    }

    public void t(C3163p1 c3163p1) {
        io.sentry.util.u.c(c3163p1, "profileContext is required");
        k("profile", c3163p1);
    }

    public void u(n nVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            k("response", nVar);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void v(x xVar) {
        k("runtime", xVar);
    }

    public void w(D d) {
        k("spring", d);
    }

    public void x(H3 h3) {
        io.sentry.util.u.c(h3, "traceContext is required");
        k("trace", h3);
    }

    public C3168c(C3168c c3168c) {
        for (Map.Entry entry : c3168c.b()) {
            if (entry != null) {
                Object value = entry.getValue();
                if ("app".equals(entry.getKey()) && (value instanceof C3166a)) {
                    n(new C3166a((C3166a) value));
                } else if ("browser".equals(entry.getKey()) && (value instanceof C3167b)) {
                    o(new C3167b((C3167b) value));
                } else if ("device".equals(entry.getKey()) && (value instanceof C3170e)) {
                    p(new C3170e((C3170e) value));
                } else if ("os".equals(entry.getKey()) && (value instanceof l)) {
                    s(new l((l) value));
                } else if ("runtime".equals(entry.getKey()) && (value instanceof x)) {
                    v(new x((x) value));
                } else if ("feedback".equals(entry.getKey()) && (value instanceof C3171f)) {
                    q(new C3171f((C3171f) value));
                } else if ("gpu".equals(entry.getKey()) && (value instanceof C3173h)) {
                    r(new C3173h((C3173h) value));
                } else if ("trace".equals(entry.getKey()) && (value instanceof H3)) {
                    x(new H3((H3) value));
                } else if ("profile".equals(entry.getKey()) && (value instanceof C3163p1)) {
                    t(new C3163p1((C3163p1) value));
                } else if ("response".equals(entry.getKey()) && (value instanceof n)) {
                    u(new n((n) value));
                } else if ("spring".equals(entry.getKey()) && (value instanceof D)) {
                    w(new D((D) value));
                } else {
                    k((String) entry.getKey(), value);
                }
            }
        }
    }
}
