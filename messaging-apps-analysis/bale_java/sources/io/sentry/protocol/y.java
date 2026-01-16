package io.sentry.protocol;

import android.gov.nist.core.Separators;
import io.sentry.A0;
import io.sentry.AbstractC3141l;
import io.sentry.G3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.M3;
import io.sentry.O3;
import io.sentry.Y2;
import io.sentry.protocol.C3174i;
import io.sentry.protocol.v;
import io.sentry.util.AbstractC3204c;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class y implements A0 {
    private final Double a;
    private final Double b;
    private final v c;
    private final M3 d;
    private final M3 e;
    private final String f;
    private final String g;
    private final O3 h;
    private final String i;
    private final Map j;
    private Map k;
    private final Map l;
    private Map m;

    public static final class a implements InterfaceC3176q0 {
        private Exception c(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + Separators.DOUBLE_QUOTE;
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.b(Y2.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public y a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) throws Exception {
            String strN0;
            interfaceC3118g1.B();
            Map map = null;
            Double dValueOf = null;
            Double dValueOf2 = null;
            v vVarA = null;
            M3 m3A = null;
            M3 m3 = null;
            String strG1 = null;
            String strG12 = null;
            O3 o3 = null;
            String strG13 = null;
            Map mapI1 = null;
            ConcurrentHashMap concurrentHashMap = null;
            Map map2 = null;
            while (true) {
                String str = strG13;
                O3 o32 = o3;
                String str2 = strG12;
                M3 m32 = m3;
                if (interfaceC3118g1.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                    if (dValueOf == null) {
                        throw c("start_timestamp", iLogger);
                    }
                    if (vVarA == null) {
                        throw c("trace_id", iLogger);
                    }
                    if (m3A == null) {
                        throw c("span_id", iLogger);
                    }
                    if (strG1 == null) {
                        throw c("op", iLogger);
                    }
                    Map map3 = map == null ? new HashMap() : map;
                    Map map4 = mapI1 == null ? new HashMap() : mapI1;
                    y yVar = new y(dValueOf, dValueOf2, vVarA, m3A, m32, strG1, str2, o32, str, map3, map4, map2);
                    yVar.i(concurrentHashMap);
                    interfaceC3118g1.F();
                    return yVar;
                }
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "span_id":
                        m3A = new M3.a().a(interfaceC3118g1, iLogger);
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "parent_span_id":
                        m3 = (M3) interfaceC3118g1.E0(iLogger, new M3.a());
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        break;
                    case "description":
                        strG12 = interfaceC3118g1.g1();
                        strG13 = str;
                        o3 = o32;
                        m3 = m32;
                        break;
                    case "start_timestamp":
                        try {
                            dValueOf = interfaceC3118g1.l0();
                        } catch (NumberFormatException unused) {
                            Date dateQ0 = interfaceC3118g1.q0(iLogger);
                            dValueOf = dateQ0 != null ? Double.valueOf(AbstractC3141l.b(dateQ0)) : null;
                        }
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "origin":
                        strG13 = interfaceC3118g1.g1();
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "status":
                        o3 = (O3) interfaceC3118g1.E0(iLogger, new O3.a());
                        strG13 = str;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "measurements":
                        mapI1 = interfaceC3118g1.i1(iLogger, new C3174i.a());
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "op":
                        strG1 = interfaceC3118g1.g1();
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "data":
                        map2 = (Map) interfaceC3118g1.H1();
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "tags":
                        map = (Map) interfaceC3118g1.H1();
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "timestamp":
                        try {
                            dValueOf2 = interfaceC3118g1.l0();
                        } catch (NumberFormatException unused2) {
                            Date dateQ02 = interfaceC3118g1.q0(iLogger);
                            dValueOf2 = dateQ02 != null ? Double.valueOf(AbstractC3141l.b(dateQ02)) : null;
                        }
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    case "trace_id":
                        vVarA = new v.a().a(interfaceC3118g1, iLogger);
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        strG13 = str;
                        o3 = o32;
                        strG12 = str2;
                        m3 = m32;
                        break;
                }
            }
        }
    }

    public y(G3 g3) {
        this(g3, g3.e());
    }

    private BigDecimal a(Double d) {
        return BigDecimal.valueOf(d.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public Map b() {
        return this.k;
    }

    public Map c() {
        return this.l;
    }

    public String d() {
        return this.f;
    }

    public M3 e() {
        return this.d;
    }

    public Double f() {
        return this.a;
    }

    public Double g() {
        return this.b;
    }

    public void h(Map map) {
        this.k = map;
    }

    public void i(Map map) {
        this.m = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("start_timestamp").l(iLogger, a(this.a));
        if (this.b != null) {
            interfaceC3123h1.f("timestamp").l(iLogger, a(this.b));
        }
        interfaceC3123h1.f("trace_id").l(iLogger, this.c);
        interfaceC3123h1.f("span_id").l(iLogger, this.d);
        if (this.e != null) {
            interfaceC3123h1.f("parent_span_id").l(iLogger, this.e);
        }
        interfaceC3123h1.f("op").h(this.f);
        if (this.g != null) {
            interfaceC3123h1.f("description").h(this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("status").l(iLogger, this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("origin").l(iLogger, this.i);
        }
        if (!this.j.isEmpty()) {
            interfaceC3123h1.f("tags").l(iLogger, this.j);
        }
        if (this.k != null) {
            interfaceC3123h1.f("data").l(iLogger, this.k);
        }
        if (!this.l.isEmpty()) {
            interfaceC3123h1.f("measurements").l(iLogger, this.l);
        }
        Map map = this.m;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.m.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public y(G3 g3, Map map) {
        io.sentry.util.u.c(g3, "span is required");
        this.g = g3.getDescription();
        this.f = g3.h();
        this.d = g3.C();
        this.e = g3.z();
        this.c = g3.E();
        this.h = g3.j();
        this.i = g3.v().f();
        Map mapB = AbstractC3204c.b(g3.D());
        this.j = mapB == null ? new ConcurrentHashMap() : mapB;
        Map mapB2 = AbstractC3204c.b(g3.g());
        this.l = mapB2 == null ? new ConcurrentHashMap() : mapB2;
        this.b = g3.w() == null ? null : Double.valueOf(AbstractC3141l.m(g3.y().o(g3.w())));
        this.a = Double.valueOf(AbstractC3141l.m(g3.y().p()));
        this.k = map;
    }

    public y(Double d, Double d2, v vVar, M3 m3, M3 m32, String str, String str2, O3 o3, String str3, Map map, Map map2, Map map3) {
        this.a = d;
        this.b = d2;
        this.c = vVar;
        this.d = m3;
        this.e = m32;
        this.f = str;
        this.g = str2;
        this.h = o3;
        this.i = str3;
        this.j = map;
        this.l = map2;
        this.k = map3;
    }
}
