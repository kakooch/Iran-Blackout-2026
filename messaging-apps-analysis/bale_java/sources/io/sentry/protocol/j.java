package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.util.AbstractC3204c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class j implements A0 {
    private final transient Thread a;
    private String b;
    private String c;
    private String d;
    private Boolean e;
    private Map f;
    private Map g;
    private Boolean h;
    private Integer i;
    private Integer j;
    private Boolean k;
    private Map l;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            j jVar = new j();
            interfaceC3118g1.B();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "description":
                        jVar.c = interfaceC3118g1.g1();
                        break;
                    case "exception_id":
                        jVar.i = interfaceC3118g1.Y0();
                        break;
                    case "data":
                        jVar.g = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        break;
                    case "meta":
                        jVar.f = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        break;
                    case "type":
                        jVar.b = interfaceC3118g1.g1();
                        break;
                    case "handled":
                        jVar.e = interfaceC3118g1.v0();
                        break;
                    case "synthetic":
                        jVar.h = interfaceC3118g1.v0();
                        break;
                    case "is_exception_group":
                        jVar.k = interfaceC3118g1.v0();
                        break;
                    case "help_link":
                        jVar.d = interfaceC3118g1.g1();
                        break;
                    case "parent_id":
                        jVar.j = interfaceC3118g1.Y0();
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
            jVar.q(map);
            return jVar;
        }
    }

    public j() {
        this(null);
    }

    public String k() {
        return this.b;
    }

    public Boolean l() {
        return this.e;
    }

    public void m(Integer num) {
        this.i = num;
    }

    public void n(Boolean bool) {
        this.e = bool;
    }

    public void o(Integer num) {
        this.j = num;
    }

    public void p(String str) {
        this.b = str;
    }

    public void q(Map map) {
        this.l = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.b != null) {
            interfaceC3123h1.f("type").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("description").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("help_link").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("handled").m(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("meta").l(iLogger, this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("data").l(iLogger, this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("synthetic").m(this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("exception_id").l(iLogger, this.i);
        }
        if (this.j != null) {
            interfaceC3123h1.f("parent_id").l(iLogger, this.j);
        }
        if (this.k != null) {
            interfaceC3123h1.f("is_exception_group").m(this.k);
        }
        Map map = this.l;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.l.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public j(Thread thread) {
        this.a = thread;
    }
}
