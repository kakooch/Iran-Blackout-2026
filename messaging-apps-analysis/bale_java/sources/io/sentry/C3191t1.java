package io.sentry;

import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.t1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3191t1 implements A0 {
    private String a;
    private String b;
    private String c;
    private Long d;
    private Long e;
    private Long f;
    private Long g;
    private Map h;

    /* renamed from: io.sentry.t1$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3191t1 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            C3191t1 c3191t1 = new C3191t1();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "relative_start_ns":
                        Long lA1 = interfaceC3118g1.a1();
                        if (lA1 == null) {
                            break;
                        } else {
                            c3191t1.d = lA1;
                            break;
                        }
                    case "relative_end_ns":
                        Long lA12 = interfaceC3118g1.a1();
                        if (lA12 == null) {
                            break;
                        } else {
                            c3191t1.e = lA12;
                            break;
                        }
                    case "id":
                        String strG1 = interfaceC3118g1.g1();
                        if (strG1 == null) {
                            break;
                        } else {
                            c3191t1.a = strG1;
                            break;
                        }
                    case "name":
                        String strG12 = interfaceC3118g1.g1();
                        if (strG12 == null) {
                            break;
                        } else {
                            c3191t1.c = strG12;
                            break;
                        }
                    case "trace_id":
                        String strG13 = interfaceC3118g1.g1();
                        if (strG13 == null) {
                            break;
                        } else {
                            c3191t1.b = strG13;
                            break;
                        }
                    case "relative_cpu_end_ms":
                        Long lA13 = interfaceC3118g1.a1();
                        if (lA13 == null) {
                            break;
                        } else {
                            c3191t1.g = lA13;
                            break;
                        }
                    case "relative_cpu_start_ms":
                        Long lA14 = interfaceC3118g1.a1();
                        if (lA14 == null) {
                            break;
                        } else {
                            c3191t1.f = lA14;
                            break;
                        }
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            c3191t1.l(concurrentHashMap);
            interfaceC3118g1.F();
            return c3191t1;
        }
    }

    public C3191t1() {
        this(C3098c1.e(), 0L, 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3191t1.class != obj.getClass()) {
            return false;
        }
        C3191t1 c3191t1 = (C3191t1) obj;
        return this.a.equals(c3191t1.a) && this.b.equals(c3191t1.b) && this.c.equals(c3191t1.c) && this.d.equals(c3191t1.d) && this.f.equals(c3191t1.f) && io.sentry.util.u.a(this.g, c3191t1.g) && io.sentry.util.u.a(this.e, c3191t1.e) && io.sentry.util.u.a(this.h, c3191t1.h);
    }

    public String h() {
        return this.a;
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public String i() {
        return this.c;
    }

    public String j() {
        return this.b;
    }

    public void k(Long l, Long l2, Long l3, Long l4) {
        if (this.e == null) {
            this.e = Long.valueOf(l.longValue() - l2.longValue());
            this.d = Long.valueOf(this.d.longValue() - l2.longValue());
            this.g = Long.valueOf(l3.longValue() - l4.longValue());
            this.f = Long.valueOf(this.f.longValue() - l4.longValue());
        }
    }

    public void l(Map map) {
        this.h = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("id").l(iLogger, this.a);
        interfaceC3123h1.f("trace_id").l(iLogger, this.b);
        interfaceC3123h1.f("name").l(iLogger, this.c);
        interfaceC3123h1.f("relative_start_ns").l(iLogger, this.d);
        interfaceC3123h1.f("relative_end_ns").l(iLogger, this.e);
        interfaceC3123h1.f("relative_cpu_start_ms").l(iLogger, this.f);
        interfaceC3123h1.f("relative_cpu_end_ms").l(iLogger, this.g);
        Map map = this.h;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.h.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public C3191t1(InterfaceC3127i0 interfaceC3127i0, Long l, Long l2) {
        this.a = interfaceC3127i0.b().toString();
        this.b = interfaceC3127i0.v().n().toString();
        this.c = interfaceC3127i0.getName().isEmpty() ? CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE : interfaceC3127i0.getName();
        this.d = l;
        this.f = l2;
    }
}
