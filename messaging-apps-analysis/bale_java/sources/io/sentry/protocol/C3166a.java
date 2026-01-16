package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.util.AbstractC3204c;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.protocol.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3166a implements A0 {
    private String a;
    private Date b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Map h;
    private List i;
    private String j;
    private Boolean k;
    private Boolean l;
    private List m;
    private Map n;

    /* renamed from: io.sentry.protocol.a$a, reason: collision with other inner class name */
    public static final class C0249a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3166a a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            C3166a c3166a = new C3166a();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "split_names":
                        List list = (List) interfaceC3118g1.H1();
                        if (list == null) {
                            break;
                        } else {
                            c3166a.u(list);
                            break;
                        }
                    case "device_app_hash":
                        c3166a.c = interfaceC3118g1.g1();
                        break;
                    case "start_type":
                        c3166a.j = interfaceC3118g1.g1();
                        break;
                    case "view_names":
                        List list2 = (List) interfaceC3118g1.H1();
                        if (list2 == null) {
                            break;
                        } else {
                            c3166a.x(list2);
                            break;
                        }
                    case "app_version":
                        c3166a.f = interfaceC3118g1.g1();
                        break;
                    case "in_foreground":
                        c3166a.k = interfaceC3118g1.v0();
                        break;
                    case "build_type":
                        c3166a.d = interfaceC3118g1.g1();
                        break;
                    case "app_identifier":
                        c3166a.a = interfaceC3118g1.g1();
                        break;
                    case "app_start_time":
                        c3166a.b = interfaceC3118g1.q0(iLogger);
                        break;
                    case "permissions":
                        c3166a.h = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        break;
                    case "app_name":
                        c3166a.e = interfaceC3118g1.g1();
                        break;
                    case "app_build":
                        c3166a.g = interfaceC3118g1.g1();
                        break;
                    case "is_split_apks":
                        c3166a.l = interfaceC3118g1.v0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            c3166a.w(concurrentHashMap);
            interfaceC3118g1.F();
            return c3166a;
        }
    }

    public C3166a() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3166a.class != obj.getClass()) {
            return false;
        }
        C3166a c3166a = (C3166a) obj;
        return io.sentry.util.u.a(this.a, c3166a.a) && io.sentry.util.u.a(this.b, c3166a.b) && io.sentry.util.u.a(this.c, c3166a.c) && io.sentry.util.u.a(this.d, c3166a.d) && io.sentry.util.u.a(this.e, c3166a.e) && io.sentry.util.u.a(this.f, c3166a.f) && io.sentry.util.u.a(this.g, c3166a.g) && io.sentry.util.u.a(this.h, c3166a.h) && io.sentry.util.u.a(this.k, c3166a.k) && io.sentry.util.u.a(this.i, c3166a.i) && io.sentry.util.u.a(this.j, c3166a.j) && io.sentry.util.u.a(this.l, c3166a.l) && io.sentry.util.u.a(this.m, c3166a.m);
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.k, this.i, this.j, this.l, this.m);
    }

    public Boolean l() {
        return this.k;
    }

    public void m(String str) {
        this.g = str;
    }

    public void n(String str) {
        this.a = str;
    }

    public void o(String str) {
        this.e = str;
    }

    public void p(Date date) {
        this.b = date;
    }

    public void q(String str) {
        this.f = str;
    }

    public void r(Boolean bool) {
        this.k = bool;
    }

    public void s(Map map) {
        this.h = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("app_identifier").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("app_start_time").l(iLogger, this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("device_app_hash").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("build_type").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("app_name").h(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("app_version").h(this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("app_build").h(this.g);
        }
        Map map = this.h;
        if (map != null && !map.isEmpty()) {
            interfaceC3123h1.f("permissions").l(iLogger, this.h);
        }
        if (this.k != null) {
            interfaceC3123h1.f("in_foreground").m(this.k);
        }
        if (this.i != null) {
            interfaceC3123h1.f("view_names").l(iLogger, this.i);
        }
        if (this.j != null) {
            interfaceC3123h1.f("start_type").h(this.j);
        }
        if (this.l != null) {
            interfaceC3123h1.f("is_split_apks").m(this.l);
        }
        List list = this.m;
        if (list != null && !list.isEmpty()) {
            interfaceC3123h1.f("split_names").l(iLogger, this.m);
        }
        Map map2 = this.n;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.n.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public void t(Boolean bool) {
        this.l = bool;
    }

    public void u(List list) {
        this.m = list;
    }

    public void v(String str) {
        this.j = str;
    }

    public void w(Map map) {
        this.n = map;
    }

    public void x(List list) {
        this.i = list;
    }

    C3166a(C3166a c3166a) {
        this.g = c3166a.g;
        this.a = c3166a.a;
        this.e = c3166a.e;
        this.b = c3166a.b;
        this.f = c3166a.f;
        this.d = c3166a.d;
        this.c = c3166a.c;
        this.h = AbstractC3204c.b(c3166a.h);
        this.k = c3166a.k;
        this.i = AbstractC3204c.a(c3166a.i);
        this.j = c3166a.j;
        this.l = c3166a.l;
        this.m = c3166a.m;
        this.n = AbstractC3204c.b(c3166a.n);
    }
}
