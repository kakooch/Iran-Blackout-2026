package io.sentry.rrweb;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.rrweb.b;
import io.sentry.util.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class g extends b implements A0 {
    private String c;
    private int d;
    private int e;
    private Map f;
    private Map g;

    public static final class a implements InterfaceC3176q0 {
        private void c(g gVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "height":
                        Integer numY0 = interfaceC3118g1.Y0();
                        gVar.d = numY0 != null ? numY0.intValue() : 0;
                        break;
                    case "href":
                        String strG1 = interfaceC3118g1.g1();
                        if (strG1 == null) {
                            strG1 = "";
                        }
                        gVar.c = strG1;
                        break;
                    case "width":
                        Integer numY02 = interfaceC3118g1.Y0();
                        gVar.e = numY02 != null ? numY02.intValue() : 0;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            gVar.k(concurrentHashMap);
            interfaceC3118g1.F();
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            g gVar = new g();
            b.a aVar = new b.a();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("data")) {
                    c(gVar, interfaceC3118g1, iLogger);
                } else if (!aVar.a(gVar, strN0, interfaceC3118g1, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            gVar.m(map);
            interfaceC3118g1.F();
            return gVar;
        }
    }

    public g() {
        super(c.Meta);
        this.c = "";
    }

    private void j(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("href").h(this.c);
        interfaceC3123h1.f("height").b(this.d);
        interfaceC3123h1.f("width").b(this.e);
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

    @Override // io.sentry.rrweb.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        g gVar = (g) obj;
        return this.d == gVar.d && this.e == gVar.e && u.a(this.c, gVar.c);
    }

    @Override // io.sentry.rrweb.b
    public int hashCode() {
        return u.b(Integer.valueOf(super.hashCode()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
    }

    public void k(Map map) {
        this.g = map;
    }

    public void l(int i) {
        this.d = i;
    }

    public void m(Map map) {
        this.f = map;
    }

    public void n(int i) {
        this.e = i;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new b.C0251b().a(this, interfaceC3123h1, iLogger);
        interfaceC3123h1.f("data");
        j(interfaceC3123h1, iLogger);
        interfaceC3123h1.F();
    }
}
