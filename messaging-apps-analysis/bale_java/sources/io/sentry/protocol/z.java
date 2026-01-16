package io.sentry.protocol;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Z2;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class z implements A0 {
    private List a;
    private List b;
    private String c;
    private String d;
    private String e;
    private Integer f;
    private Integer g;
    private String h;
    private String i;
    private Boolean j;
    private String k;
    private Boolean l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private Map s;
    private String t;
    private Z2 u;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public z a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            z zVar = new z();
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "post_context":
                        zVar.b = (List) interfaceC3118g1.H1();
                        break;
                    case "image_addr":
                        zVar.n = interfaceC3118g1.g1();
                        break;
                    case "in_app":
                        zVar.j = interfaceC3118g1.v0();
                        break;
                    case "raw_function":
                        zVar.t = interfaceC3118g1.g1();
                        break;
                    case "lineno":
                        zVar.f = interfaceC3118g1.Y0();
                        break;
                    case "module":
                        zVar.e = interfaceC3118g1.g1();
                        break;
                    case "native":
                        zVar.l = interfaceC3118g1.v0();
                        break;
                    case "symbol":
                        zVar.r = interfaceC3118g1.g1();
                        break;
                    case "package":
                        zVar.k = interfaceC3118g1.g1();
                        break;
                    case "filename":
                        zVar.c = interfaceC3118g1.g1();
                        break;
                    case "symbol_addr":
                        zVar.o = interfaceC3118g1.g1();
                        break;
                    case "lock":
                        zVar.u = (Z2) interfaceC3118g1.E0(iLogger, new Z2.a());
                        break;
                    case "colno":
                        zVar.g = interfaceC3118g1.Y0();
                        break;
                    case "instruction_addr":
                        zVar.p = interfaceC3118g1.g1();
                        break;
                    case "pre_context":
                        zVar.a = (List) interfaceC3118g1.H1();
                        break;
                    case "addr_mode":
                        zVar.q = interfaceC3118g1.g1();
                        break;
                    case "context_line":
                        zVar.i = interfaceC3118g1.g1();
                        break;
                    case "function":
                        zVar.d = interfaceC3118g1.g1();
                        break;
                    case "abs_path":
                        zVar.h = interfaceC3118g1.g1();
                        break;
                    case "platform":
                        zVar.m = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            zVar.G(concurrentHashMap);
            interfaceC3118g1.F();
            return zVar;
        }
    }

    public void A(Integer num) {
        this.f = num;
    }

    public void B(Z2 z2) {
        this.u = z2;
    }

    public void C(String str) {
        this.e = str;
    }

    public void D(Boolean bool) {
        this.l = bool;
    }

    public void E(String str) {
        this.k = str;
    }

    public void F(String str) {
        this.m = str;
    }

    public void G(Map map) {
        this.s = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.c != null) {
            interfaceC3123h1.f("filename").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("function").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("module").h(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("lineno").k(this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("colno").k(this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("abs_path").h(this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("context_line").h(this.i);
        }
        if (this.j != null) {
            interfaceC3123h1.f("in_app").m(this.j);
        }
        if (this.k != null) {
            interfaceC3123h1.f("package").h(this.k);
        }
        if (this.l != null) {
            interfaceC3123h1.f(PluginErrorDetails.Platform.NATIVE).m(this.l);
        }
        if (this.m != null) {
            interfaceC3123h1.f("platform").h(this.m);
        }
        if (this.n != null) {
            interfaceC3123h1.f("image_addr").h(this.n);
        }
        if (this.o != null) {
            interfaceC3123h1.f("symbol_addr").h(this.o);
        }
        if (this.p != null) {
            interfaceC3123h1.f("instruction_addr").h(this.p);
        }
        if (this.q != null) {
            interfaceC3123h1.f("addr_mode").h(this.q);
        }
        if (this.t != null) {
            interfaceC3123h1.f("raw_function").h(this.t);
        }
        if (this.r != null) {
            interfaceC3123h1.f("symbol").h(this.r);
        }
        if (this.u != null) {
            interfaceC3123h1.f("lock").l(iLogger, this.u);
        }
        List list = this.a;
        if (list != null && !list.isEmpty()) {
            interfaceC3123h1.f("pre_context").l(iLogger, this.a);
        }
        List list2 = this.b;
        if (list2 != null && !list2.isEmpty()) {
            interfaceC3123h1.f("post_context").l(iLogger, this.b);
        }
        Map map = this.s;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.s.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public String u() {
        return this.e;
    }

    public void v(String str) {
        this.q = str;
    }

    public void w(String str) {
        this.c = str;
    }

    public void x(String str) {
        this.d = str;
    }

    public void y(Boolean bool) {
        this.j = bool;
    }

    public void z(String str) {
        this.p = str;
    }
}
