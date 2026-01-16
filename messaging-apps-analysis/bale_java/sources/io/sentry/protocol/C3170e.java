package io.sentry.protocol;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.util.AbstractC3204c;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.protocol.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3170e implements A0 {
    private String A;
    private String B;
    private String D;
    private Float G;
    private Integer H;
    private Double J;
    private String Y;
    private String Z;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String[] g;
    private Float h;
    private Boolean i;
    private Boolean j;
    private b k;
    private Boolean l;
    private Long m;
    private Long n;
    private Long o;
    private Boolean p;
    private Long q;
    private Long r;
    private Long s;
    private Long t;
    private Integer u;
    private Integer v;
    private Float w;
    private Integer x;
    private Date y;
    private TimeZone z;
    private Map z0;

    /* renamed from: io.sentry.protocol.e$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3170e a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            C3170e c3170e = new C3170e();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "timezone":
                        c3170e.z = interfaceC3118g1.a0(iLogger);
                        break;
                    case "boot_time":
                        if (interfaceC3118g1.peek() != io.sentry.vendor.gson.stream.b.STRING) {
                            break;
                        } else {
                            c3170e.y = interfaceC3118g1.q0(iLogger);
                            break;
                        }
                    case "simulator":
                        c3170e.l = interfaceC3118g1.v0();
                        break;
                    case "manufacturer":
                        c3170e.b = interfaceC3118g1.g1();
                        break;
                    case "processor_count":
                        c3170e.H = interfaceC3118g1.Y0();
                        break;
                    case "orientation":
                        c3170e.k = (b) interfaceC3118g1.E0(iLogger, new b.a());
                        break;
                    case "battery_temperature":
                        c3170e.G = interfaceC3118g1.x1();
                        break;
                    case "family":
                        c3170e.d = interfaceC3118g1.g1();
                        break;
                    case "locale":
                        c3170e.B = interfaceC3118g1.g1();
                        break;
                    case "online":
                        c3170e.j = interfaceC3118g1.v0();
                        break;
                    case "battery_level":
                        c3170e.h = interfaceC3118g1.x1();
                        break;
                    case "model_id":
                        c3170e.f = interfaceC3118g1.g1();
                        break;
                    case "screen_density":
                        c3170e.w = interfaceC3118g1.x1();
                        break;
                    case "screen_dpi":
                        c3170e.x = interfaceC3118g1.Y0();
                        break;
                    case "free_memory":
                        c3170e.n = interfaceC3118g1.a1();
                        break;
                    case "id":
                        c3170e.A = interfaceC3118g1.g1();
                        break;
                    case "name":
                        c3170e.a = interfaceC3118g1.g1();
                        break;
                    case "low_memory":
                        c3170e.p = interfaceC3118g1.v0();
                        break;
                    case "archs":
                        List list = (List) interfaceC3118g1.H1();
                        if (list == null) {
                            break;
                        } else {
                            String[] strArr = new String[list.size()];
                            list.toArray(strArr);
                            c3170e.g = strArr;
                            break;
                        }
                    case "brand":
                        c3170e.c = interfaceC3118g1.g1();
                        break;
                    case "model":
                        c3170e.e = interfaceC3118g1.g1();
                        break;
                    case "cpu_description":
                        c3170e.Y = interfaceC3118g1.g1();
                        break;
                    case "processor_frequency":
                        c3170e.J = interfaceC3118g1.l0();
                        break;
                    case "connection_type":
                        c3170e.D = interfaceC3118g1.g1();
                        break;
                    case "chipset":
                        c3170e.Z = interfaceC3118g1.g1();
                        break;
                    case "screen_width_pixels":
                        c3170e.u = interfaceC3118g1.Y0();
                        break;
                    case "external_storage_size":
                        c3170e.s = interfaceC3118g1.a1();
                        break;
                    case "storage_size":
                        c3170e.q = interfaceC3118g1.a1();
                        break;
                    case "usable_memory":
                        c3170e.o = interfaceC3118g1.a1();
                        break;
                    case "memory_size":
                        c3170e.m = interfaceC3118g1.a1();
                        break;
                    case "charging":
                        c3170e.i = interfaceC3118g1.v0();
                        break;
                    case "external_free_storage":
                        c3170e.t = interfaceC3118g1.a1();
                        break;
                    case "free_storage":
                        c3170e.r = interfaceC3118g1.a1();
                        break;
                    case "screen_height_pixels":
                        c3170e.v = interfaceC3118g1.Y0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            c3170e.q0(concurrentHashMap);
            interfaceC3118g1.F();
            return c3170e;
        }
    }

    /* renamed from: io.sentry.protocol.e$b */
    public enum b implements A0 {
        PORTRAIT,
        LANDSCAPE;

        /* renamed from: io.sentry.protocol.e$b$a */
        public static final class a implements InterfaceC3176q0 {
            @Override // io.sentry.InterfaceC3176q0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
                return b.valueOf(interfaceC3118g1.T0().toUpperCase(Locale.ROOT));
            }
        }

        @Override // io.sentry.A0
        public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
            interfaceC3123h1.h(toString().toLowerCase(Locale.ROOT));
        }
    }

    public C3170e() {
    }

    public String I() {
        return this.D;
    }

    public String J() {
        return this.A;
    }

    public String K() {
        return this.B;
    }

    public void L(String[] strArr) {
        this.g = strArr;
    }

    public void M(Float f) {
        this.h = f;
    }

    public void N(Float f) {
        this.G = f;
    }

    public void O(Date date) {
        this.y = date;
    }

    public void P(String str) {
        this.c = str;
    }

    public void Q(Boolean bool) {
        this.i = bool;
    }

    public void R(String str) {
        this.Z = str;
    }

    public void S(String str) {
        this.D = str;
    }

    public void T(Long l) {
        this.t = l;
    }

    public void U(Long l) {
        this.s = l;
    }

    public void V(String str) {
        this.d = str;
    }

    public void W(Long l) {
        this.n = l;
    }

    public void X(Long l) {
        this.r = l;
    }

    public void Y(String str) {
        this.A = str;
    }

    public void Z(String str) {
        this.B = str;
    }

    public void a0(Boolean bool) {
        this.p = bool;
    }

    public void b0(String str) {
        this.b = str;
    }

    public void c0(Long l) {
        this.m = l;
    }

    public void d0(String str) {
        this.e = str;
    }

    public void e0(String str) {
        this.f = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3170e.class != obj.getClass()) {
            return false;
        }
        C3170e c3170e = (C3170e) obj;
        return io.sentry.util.u.a(this.a, c3170e.a) && io.sentry.util.u.a(this.b, c3170e.b) && io.sentry.util.u.a(this.c, c3170e.c) && io.sentry.util.u.a(this.d, c3170e.d) && io.sentry.util.u.a(this.e, c3170e.e) && io.sentry.util.u.a(this.f, c3170e.f) && Arrays.equals(this.g, c3170e.g) && io.sentry.util.u.a(this.h, c3170e.h) && io.sentry.util.u.a(this.i, c3170e.i) && io.sentry.util.u.a(this.j, c3170e.j) && this.k == c3170e.k && io.sentry.util.u.a(this.l, c3170e.l) && io.sentry.util.u.a(this.m, c3170e.m) && io.sentry.util.u.a(this.n, c3170e.n) && io.sentry.util.u.a(this.o, c3170e.o) && io.sentry.util.u.a(this.p, c3170e.p) && io.sentry.util.u.a(this.q, c3170e.q) && io.sentry.util.u.a(this.r, c3170e.r) && io.sentry.util.u.a(this.s, c3170e.s) && io.sentry.util.u.a(this.t, c3170e.t) && io.sentry.util.u.a(this.u, c3170e.u) && io.sentry.util.u.a(this.v, c3170e.v) && io.sentry.util.u.a(this.w, c3170e.w) && io.sentry.util.u.a(this.x, c3170e.x) && io.sentry.util.u.a(this.y, c3170e.y) && io.sentry.util.u.a(this.A, c3170e.A) && io.sentry.util.u.a(this.B, c3170e.B) && io.sentry.util.u.a(this.D, c3170e.D) && io.sentry.util.u.a(this.G, c3170e.G) && io.sentry.util.u.a(this.H, c3170e.H) && io.sentry.util.u.a(this.J, c3170e.J) && io.sentry.util.u.a(this.Y, c3170e.Y) && io.sentry.util.u.a(this.Z, c3170e.Z);
    }

    public void f0(Boolean bool) {
        this.j = bool;
    }

    public void g0(b bVar) {
        this.k = bVar;
    }

    public void h0(Integer num) {
        this.H = num;
    }

    public int hashCode() {
        return (io.sentry.util.u.b(this.a, this.b, this.c, this.d, this.e, this.f, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.D, this.G, this.H, this.J, this.Y, this.Z) * 31) + Arrays.hashCode(this.g);
    }

    public void i0(Double d) {
        this.J = d;
    }

    public void j0(Float f) {
        this.w = f;
    }

    public void k0(Integer num) {
        this.x = num;
    }

    public void l0(Integer num) {
        this.v = num;
    }

    public void m0(Integer num) {
        this.u = num;
    }

    public void n0(Boolean bool) {
        this.l = bool;
    }

    public void o0(Long l) {
        this.q = l;
    }

    public void p0(TimeZone timeZone) {
        this.z = timeZone;
    }

    public void q0(Map map) {
        this.z0 = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("name").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f(CommonUrlParts.MANUFACTURER).h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("brand").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("family").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f(CommonUrlParts.MODEL).h(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("model_id").h(this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("archs").l(iLogger, this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("battery_level").k(this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("charging").m(this.i);
        }
        if (this.j != null) {
            interfaceC3123h1.f("online").m(this.j);
        }
        if (this.k != null) {
            interfaceC3123h1.f("orientation").l(iLogger, this.k);
        }
        if (this.l != null) {
            interfaceC3123h1.f("simulator").m(this.l);
        }
        if (this.m != null) {
            interfaceC3123h1.f("memory_size").k(this.m);
        }
        if (this.n != null) {
            interfaceC3123h1.f("free_memory").k(this.n);
        }
        if (this.o != null) {
            interfaceC3123h1.f("usable_memory").k(this.o);
        }
        if (this.p != null) {
            interfaceC3123h1.f("low_memory").m(this.p);
        }
        if (this.q != null) {
            interfaceC3123h1.f("storage_size").k(this.q);
        }
        if (this.r != null) {
            interfaceC3123h1.f("free_storage").k(this.r);
        }
        if (this.s != null) {
            interfaceC3123h1.f("external_storage_size").k(this.s);
        }
        if (this.t != null) {
            interfaceC3123h1.f("external_free_storage").k(this.t);
        }
        if (this.u != null) {
            interfaceC3123h1.f("screen_width_pixels").k(this.u);
        }
        if (this.v != null) {
            interfaceC3123h1.f("screen_height_pixels").k(this.v);
        }
        if (this.w != null) {
            interfaceC3123h1.f("screen_density").k(this.w);
        }
        if (this.x != null) {
            interfaceC3123h1.f(CommonUrlParts.SCREEN_DPI).k(this.x);
        }
        if (this.y != null) {
            interfaceC3123h1.f("boot_time").l(iLogger, this.y);
        }
        if (this.z != null) {
            interfaceC3123h1.f("timezone").l(iLogger, this.z);
        }
        if (this.A != null) {
            interfaceC3123h1.f("id").h(this.A);
        }
        if (this.D != null) {
            interfaceC3123h1.f("connection_type").h(this.D);
        }
        if (this.G != null) {
            interfaceC3123h1.f("battery_temperature").k(this.G);
        }
        if (this.B != null) {
            interfaceC3123h1.f(CommonUrlParts.LOCALE).h(this.B);
        }
        if (this.H != null) {
            interfaceC3123h1.f("processor_count").k(this.H);
        }
        if (this.J != null) {
            interfaceC3123h1.f("processor_frequency").k(this.J);
        }
        if (this.Y != null) {
            interfaceC3123h1.f("cpu_description").h(this.Y);
        }
        if (this.Z != null) {
            interfaceC3123h1.f("chipset").h(this.Z);
        }
        Map map = this.z0;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.z0.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    C3170e(C3170e c3170e) {
        this.a = c3170e.a;
        this.b = c3170e.b;
        this.c = c3170e.c;
        this.d = c3170e.d;
        this.e = c3170e.e;
        this.f = c3170e.f;
        this.i = c3170e.i;
        this.j = c3170e.j;
        this.k = c3170e.k;
        this.l = c3170e.l;
        this.m = c3170e.m;
        this.n = c3170e.n;
        this.o = c3170e.o;
        this.p = c3170e.p;
        this.q = c3170e.q;
        this.r = c3170e.r;
        this.s = c3170e.s;
        this.t = c3170e.t;
        this.u = c3170e.u;
        this.v = c3170e.v;
        this.w = c3170e.w;
        this.x = c3170e.x;
        this.y = c3170e.y;
        this.A = c3170e.A;
        this.D = c3170e.D;
        this.G = c3170e.G;
        this.h = c3170e.h;
        String[] strArr = c3170e.g;
        this.g = strArr != null ? (String[]) strArr.clone() : null;
        this.B = c3170e.B;
        TimeZone timeZone = c3170e.z;
        this.z = timeZone != null ? (TimeZone) timeZone.clone() : null;
        this.H = c3170e.H;
        this.J = c3170e.J;
        this.Y = c3170e.Y;
        this.Z = c3170e.Z;
        this.z0 = AbstractC3204c.b(c3170e.z0);
    }
}
