package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Z2;
import io.sentry.protocol.A;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class B implements A0 {
    private Long a;
    private Integer b;
    private String c;
    private String d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private A i;
    private Map j;
    private Map k;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public B a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            B b = new B();
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "daemon":
                        b.g = interfaceC3118g1.v0();
                        break;
                    case "priority":
                        b.b = interfaceC3118g1.Y0();
                        break;
                    case "held_locks":
                        Map mapI1 = interfaceC3118g1.i1(iLogger, new Z2.a());
                        if (mapI1 == null) {
                            break;
                        } else {
                            b.j = new HashMap(mapI1);
                            break;
                        }
                    case "id":
                        b.a = interfaceC3118g1.a1();
                        break;
                    case "main":
                        b.h = interfaceC3118g1.v0();
                        break;
                    case "name":
                        b.c = interfaceC3118g1.g1();
                        break;
                    case "state":
                        b.d = interfaceC3118g1.g1();
                        break;
                    case "crashed":
                        b.e = interfaceC3118g1.v0();
                        break;
                    case "current":
                        b.f = interfaceC3118g1.v0();
                        break;
                    case "stacktrace":
                        b.i = (A) interfaceC3118g1.E0(iLogger, new A.a());
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            b.A(concurrentHashMap);
            interfaceC3118g1.F();
            return b;
        }
    }

    public void A(Map map) {
        this.k = map;
    }

    public Map k() {
        return this.j;
    }

    public Long l() {
        return this.a;
    }

    public String m() {
        return this.c;
    }

    public A n() {
        return this.i;
    }

    public Boolean o() {
        return this.f;
    }

    public Boolean p() {
        return this.h;
    }

    public void q(Boolean bool) {
        this.e = bool;
    }

    public void r(Boolean bool) {
        this.f = bool;
    }

    public void s(Boolean bool) {
        this.g = bool;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("id").k(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("priority").k(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("name").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("state").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("crashed").m(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("current").m(this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("daemon").m(this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("main").m(this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("stacktrace").l(iLogger, this.i);
        }
        if (this.j != null) {
            interfaceC3123h1.f("held_locks").l(iLogger, this.j);
        }
        Map map = this.k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.k.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public void t(Map map) {
        this.j = map;
    }

    public void u(Long l) {
        this.a = l;
    }

    public void v(Boolean bool) {
        this.h = bool;
    }

    public void w(String str) {
        this.c = str;
    }

    public void x(Integer num) {
        this.b = num;
    }

    public void y(A a2) {
        this.i = a2;
    }

    public void z(String str) {
        this.d = str;
    }
}
