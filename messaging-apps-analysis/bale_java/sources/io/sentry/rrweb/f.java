package io.sentry.rrweb;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.rrweb.b;
import io.sentry.rrweb.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class f extends d implements A0 {
    private int d;
    private List e;
    private Map f;
    private Map g;

    public static final class a implements InterfaceC3176q0 {
        private void c(f fVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            d.a aVar = new d.a();
            interfaceC3118g1.B();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("pointerId")) {
                    fVar.d = interfaceC3118g1.r0();
                } else if (strN0.equals("positions")) {
                    fVar.e = interfaceC3118g1.Q1(iLogger, new b.a());
                } else if (!aVar.a(fVar, strN0, interfaceC3118g1, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            fVar.l(map);
            interfaceC3118g1.F();
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            f fVar = new f();
            b.a aVar = new b.a();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("data")) {
                    c(fVar, interfaceC3118g1, iLogger);
                } else if (!aVar.a(fVar, strN0, interfaceC3118g1, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            fVar.o(map);
            interfaceC3118g1.F();
            return fVar;
        }
    }

    public static final class b implements A0 {
        private int a;
        private float b;
        private float c;
        private long d;
        private Map e;

        public static final class a implements InterfaceC3176q0 {
            @Override // io.sentry.InterfaceC3176q0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
                String strN0;
                interfaceC3118g1.B();
                b bVar = new b();
                HashMap map = null;
                while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strN0 = interfaceC3118g1.n0();
                    strN0.hashCode();
                    switch (strN0) {
                        case "x":
                            bVar.b = interfaceC3118g1.e1();
                            break;
                        case "y":
                            bVar.c = interfaceC3118g1.e1();
                            break;
                        case "id":
                            bVar.a = interfaceC3118g1.r0();
                            break;
                        case "timeOffset":
                            bVar.d = interfaceC3118g1.K1();
                            break;
                        default:
                            if (map == null) {
                                map = new HashMap();
                            }
                            interfaceC3118g1.j1(iLogger, map, strN0);
                            break;
                    }
                }
                bVar.h(map);
                interfaceC3118g1.F();
                return bVar;
            }
        }

        public long e() {
            return this.d;
        }

        public void f(int i) {
            this.a = i;
        }

        public void g(long j) {
            this.d = j;
        }

        public void h(Map map) {
            this.e = map;
        }

        public void i(float f) {
            this.b = f;
        }

        public void j(float f) {
            this.c = f;
        }

        @Override // io.sentry.A0
        public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
            interfaceC3123h1.B();
            interfaceC3123h1.f("id").b(this.a);
            interfaceC3123h1.f("x").c(this.b);
            interfaceC3123h1.f("y").c(this.c);
            interfaceC3123h1.f("timeOffset").b(this.d);
            Map map = this.e;
            if (map != null) {
                for (String str : map.keySet()) {
                    Object obj = this.e.get(str);
                    interfaceC3123h1.f(str);
                    interfaceC3123h1.l(iLogger, obj);
                }
            }
            interfaceC3123h1.F();
        }
    }

    public f() {
        super(d.b.TouchMove);
    }

    private void k(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new d.c().a(this, interfaceC3123h1, iLogger);
        List list = this.e;
        if (list != null && !list.isEmpty()) {
            interfaceC3123h1.f("positions").l(iLogger, this.e);
        }
        interfaceC3123h1.f("pointerId").b(this.d);
        Map map = this.g;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.g.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public void l(Map map) {
        this.g = map;
    }

    public void m(int i) {
        this.d = i;
    }

    public void n(List list) {
        this.e = list;
    }

    public void o(Map map) {
        this.f = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new b.C0251b().a(this, interfaceC3123h1, iLogger);
        interfaceC3123h1.f("data");
        k(interfaceC3123h1, iLogger);
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
}
