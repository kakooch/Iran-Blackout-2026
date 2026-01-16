package io.sentry;

import io.sentry.C3106e;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.C3168c;
import io.sentry.protocol.C3169d;
import io.sentry.protocol.G;
import io.sentry.protocol.m;
import io.sentry.protocol.p;
import io.sentry.protocol.v;
import io.sentry.util.AbstractC3204c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.sentry.c2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3099c2 {
    private io.sentry.protocol.v a;
    private final C3168c b;
    private io.sentry.protocol.p c;
    private io.sentry.protocol.m d;
    private Map e;
    private String f;
    private String g;
    private String h;
    private io.sentry.protocol.G i;
    protected transient Throwable j;
    private String k;
    private String l;
    private List m;
    private C3169d n;
    private Map o;

    /* renamed from: io.sentry.c2$a */
    public static final class a {
        public boolean a(AbstractC3099c2 abstractC3099c2, String str, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            str.hashCode();
            switch (str) {
                case "debug_meta":
                    abstractC3099c2.n = (C3169d) interfaceC3118g1.E0(iLogger, new C3169d.a());
                    return true;
                case "server_name":
                    abstractC3099c2.k = interfaceC3118g1.g1();
                    return true;
                case "contexts":
                    abstractC3099c2.b.l(new C3168c.a().a(interfaceC3118g1, iLogger));
                    return true;
                case "environment":
                    abstractC3099c2.g = interfaceC3118g1.g1();
                    return true;
                case "breadcrumbs":
                    abstractC3099c2.m = interfaceC3118g1.Q1(iLogger, new C3106e.a());
                    return true;
                case "sdk":
                    abstractC3099c2.c = (io.sentry.protocol.p) interfaceC3118g1.E0(iLogger, new p.a());
                    return true;
                case "dist":
                    abstractC3099c2.l = interfaceC3118g1.g1();
                    return true;
                case "tags":
                    abstractC3099c2.e = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                    return true;
                case "user":
                    abstractC3099c2.i = (io.sentry.protocol.G) interfaceC3118g1.E0(iLogger, new G.a());
                    return true;
                case "extra":
                    abstractC3099c2.o = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                    return true;
                case "event_id":
                    abstractC3099c2.a = (io.sentry.protocol.v) interfaceC3118g1.E0(iLogger, new v.a());
                    return true;
                case "release":
                    abstractC3099c2.f = interfaceC3118g1.g1();
                    return true;
                case "request":
                    abstractC3099c2.d = (io.sentry.protocol.m) interfaceC3118g1.E0(iLogger, new m.a());
                    return true;
                case "platform":
                    abstractC3099c2.h = interfaceC3118g1.g1();
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: io.sentry.c2$b */
    public static final class b {
        public void a(AbstractC3099c2 abstractC3099c2, InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
            if (abstractC3099c2.a != null) {
                interfaceC3123h1.f("event_id").l(iLogger, abstractC3099c2.a);
            }
            interfaceC3123h1.f("contexts").l(iLogger, abstractC3099c2.b);
            if (abstractC3099c2.c != null) {
                interfaceC3123h1.f("sdk").l(iLogger, abstractC3099c2.c);
            }
            if (abstractC3099c2.d != null) {
                interfaceC3123h1.f("request").l(iLogger, abstractC3099c2.d);
            }
            if (abstractC3099c2.e != null && !abstractC3099c2.e.isEmpty()) {
                interfaceC3123h1.f("tags").l(iLogger, abstractC3099c2.e);
            }
            if (abstractC3099c2.f != null) {
                interfaceC3123h1.f("release").h(abstractC3099c2.f);
            }
            if (abstractC3099c2.g != null) {
                interfaceC3123h1.f("environment").h(abstractC3099c2.g);
            }
            if (abstractC3099c2.h != null) {
                interfaceC3123h1.f("platform").h(abstractC3099c2.h);
            }
            if (abstractC3099c2.i != null) {
                interfaceC3123h1.f("user").l(iLogger, abstractC3099c2.i);
            }
            if (abstractC3099c2.k != null) {
                interfaceC3123h1.f("server_name").h(abstractC3099c2.k);
            }
            if (abstractC3099c2.l != null) {
                interfaceC3123h1.f("dist").h(abstractC3099c2.l);
            }
            if (abstractC3099c2.m != null && !abstractC3099c2.m.isEmpty()) {
                interfaceC3123h1.f("breadcrumbs").l(iLogger, abstractC3099c2.m);
            }
            if (abstractC3099c2.n != null) {
                interfaceC3123h1.f("debug_meta").l(iLogger, abstractC3099c2.n);
            }
            if (abstractC3099c2.o == null || abstractC3099c2.o.isEmpty()) {
                return;
            }
            interfaceC3123h1.f("extra").l(iLogger, abstractC3099c2.o);
        }
    }

    protected AbstractC3099c2(io.sentry.protocol.v vVar) {
        this.b = new C3168c();
        this.a = vVar;
    }

    public List B() {
        return this.m;
    }

    public C3168c C() {
        return this.b;
    }

    public C3169d D() {
        return this.n;
    }

    public String E() {
        return this.l;
    }

    public String F() {
        return this.g;
    }

    public io.sentry.protocol.v G() {
        return this.a;
    }

    public Map H() {
        return this.o;
    }

    public String I() {
        return this.h;
    }

    public String J() {
        return this.f;
    }

    public io.sentry.protocol.m K() {
        return this.d;
    }

    public io.sentry.protocol.p L() {
        return this.c;
    }

    public String M() {
        return this.k;
    }

    public Map N() {
        return this.e;
    }

    public Throwable O() {
        Throwable th = this.j;
        return th instanceof ExceptionMechanismException ? ((ExceptionMechanismException) th).c() : th;
    }

    public Throwable P() {
        return this.j;
    }

    public io.sentry.protocol.G Q() {
        return this.i;
    }

    public void R(String str) {
        Map map = this.e;
        if (map == null || str == null) {
            return;
        }
        map.remove(str);
    }

    public void S(List list) {
        this.m = AbstractC3204c.a(list);
    }

    public void T(C3169d c3169d) {
        this.n = c3169d;
    }

    public void U(String str) {
        this.l = str;
    }

    public void V(String str) {
        this.g = str;
    }

    public void W(io.sentry.protocol.v vVar) {
        this.a = vVar;
    }

    public void X(Map map) {
        this.o = AbstractC3204c.c(map);
    }

    public void Y(String str) {
        this.h = str;
    }

    public void Z(String str) {
        this.f = str;
    }

    public void a0(io.sentry.protocol.m mVar) {
        this.d = mVar;
    }

    public void b0(io.sentry.protocol.p pVar) {
        this.c = pVar;
    }

    public void c0(String str) {
        this.k = str;
    }

    public void d0(String str, String str2) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        if (str == null) {
            return;
        }
        if (str2 == null) {
            R(str);
        } else {
            this.e.put(str, str2);
        }
    }

    public void e0(Map map) {
        this.e = AbstractC3204c.c(map);
    }

    public void f0(Throwable th) {
        this.j = th;
    }

    public void g0(io.sentry.protocol.G g) {
        this.i = g;
    }

    protected AbstractC3099c2() {
        this(new io.sentry.protocol.v());
    }
}
