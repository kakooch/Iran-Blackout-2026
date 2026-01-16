package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.protocol.A;
import io.sentry.protocol.j;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class q implements A0 {
    private String a;
    private String b;
    private String c;
    private Long d;
    private A e;
    private j f;
    private Map g;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public q a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            q qVar = new q();
            interfaceC3118g1.B();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "thread_id":
                        qVar.d = interfaceC3118g1.a1();
                        break;
                    case "module":
                        qVar.c = interfaceC3118g1.g1();
                        break;
                    case "type":
                        qVar.a = interfaceC3118g1.g1();
                        break;
                    case "value":
                        qVar.b = interfaceC3118g1.g1();
                        break;
                    case "mechanism":
                        qVar.f = (j) interfaceC3118g1.E0(iLogger, new j.a());
                        break;
                    case "stacktrace":
                        qVar.e = (A) interfaceC3118g1.E0(iLogger, new A.a());
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        interfaceC3118g1.j1(iLogger, map, strN0);
                        break;
                }
            }
            interfaceC3118g1.F();
            qVar.q(map);
            return qVar;
        }
    }

    public j g() {
        return this.f;
    }

    public String h() {
        return this.c;
    }

    public A i() {
        return this.e;
    }

    public Long j() {
        return this.d;
    }

    public String k() {
        return this.a;
    }

    public void l(j jVar) {
        this.f = jVar;
    }

    public void m(String str) {
        this.c = str;
    }

    public void n(A a2) {
        this.e = a2;
    }

    public void o(Long l) {
        this.d = l;
    }

    public void p(String str) {
        this.a = str;
    }

    public void q(Map map) {
        this.g = map;
    }

    public void r(String str) {
        this.b = str;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("type").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("value").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("module").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("thread_id").k(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("stacktrace").l(iLogger, this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("mechanism").l(iLogger, this.f);
        }
        Map map = this.g;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.g.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
