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
public final class m implements A0 {
    private String a;
    private String b;
    private String c;
    private Object d;
    private String e;
    private Map f;
    private Map g;
    private Long h;
    private Map i;
    private String j;
    private String k;
    private Map l;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            m mVar = new m();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "fragment":
                        mVar.j = interfaceC3118g1.g1();
                        break;
                    case "method":
                        mVar.b = interfaceC3118g1.g1();
                        break;
                    case "env":
                        Map map = (Map) interfaceC3118g1.H1();
                        if (map == null) {
                            break;
                        } else {
                            mVar.g = AbstractC3204c.b(map);
                            break;
                        }
                    case "url":
                        mVar.a = interfaceC3118g1.g1();
                        break;
                    case "data":
                        mVar.d = interfaceC3118g1.H1();
                        break;
                    case "other":
                        Map map2 = (Map) interfaceC3118g1.H1();
                        if (map2 == null) {
                            break;
                        } else {
                            mVar.i = AbstractC3204c.b(map2);
                            break;
                        }
                    case "headers":
                        Map map3 = (Map) interfaceC3118g1.H1();
                        if (map3 == null) {
                            break;
                        } else {
                            mVar.f = AbstractC3204c.b(map3);
                            break;
                        }
                    case "cookies":
                        mVar.e = interfaceC3118g1.g1();
                        break;
                    case "body_size":
                        mVar.h = interfaceC3118g1.a1();
                        break;
                    case "query_string":
                        mVar.c = interfaceC3118g1.g1();
                        break;
                    case "api_target":
                        mVar.k = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            mVar.m(concurrentHashMap);
            interfaceC3118g1.F();
            return mVar;
        }
    }

    public m() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return io.sentry.util.u.a(this.a, mVar.a) && io.sentry.util.u.a(this.b, mVar.b) && io.sentry.util.u.a(this.c, mVar.c) && io.sentry.util.u.a(this.e, mVar.e) && io.sentry.util.u.a(this.f, mVar.f) && io.sentry.util.u.a(this.g, mVar.g) && io.sentry.util.u.a(this.h, mVar.h) && io.sentry.util.u.a(this.j, mVar.j) && io.sentry.util.u.a(this.k, mVar.k);
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b, this.c, this.e, this.f, this.g, this.h, this.j, this.k);
    }

    public Map l() {
        return this.f;
    }

    public void m(Map map) {
        this.l = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("url").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("method").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("query_string").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("data").l(iLogger, this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("cookies").h(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("headers").l(iLogger, this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("env").l(iLogger, this.g);
        }
        if (this.i != null) {
            interfaceC3123h1.f("other").l(iLogger, this.i);
        }
        if (this.j != null) {
            interfaceC3123h1.f("fragment").l(iLogger, this.j);
        }
        if (this.h != null) {
            interfaceC3123h1.f("body_size").l(iLogger, this.h);
        }
        if (this.k != null) {
            interfaceC3123h1.f("api_target").l(iLogger, this.k);
        }
        Map map = this.l;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.l.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public m(m mVar) {
        this.a = mVar.a;
        this.e = mVar.e;
        this.b = mVar.b;
        this.c = mVar.c;
        this.f = AbstractC3204c.b(mVar.f);
        this.g = AbstractC3204c.b(mVar.g);
        this.i = AbstractC3204c.b(mVar.i);
        this.l = AbstractC3204c.b(mVar.l);
        this.d = mVar.d;
        this.j = mVar.j;
        this.h = mVar.h;
        this.k = mVar.k;
    }
}
