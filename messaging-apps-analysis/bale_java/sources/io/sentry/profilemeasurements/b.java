package io.sentry.profilemeasurements;

import io.sentry.A0;
import io.sentry.AbstractC3141l;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.util.u;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class b implements A0 {
    private Map a;
    private double b;
    private String c;
    private double d;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            Double dValueOf;
            interfaceC3118g1.B();
            b bVar = new b();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "elapsed_since_start_ns":
                        String strG1 = interfaceC3118g1.g1();
                        if (strG1 == null) {
                            break;
                        } else {
                            bVar.c = strG1;
                            break;
                        }
                    case "timestamp":
                        try {
                            dValueOf = interfaceC3118g1.l0();
                        } catch (NumberFormatException unused) {
                            Date dateQ0 = interfaceC3118g1.q0(iLogger);
                            dValueOf = dateQ0 != null ? Double.valueOf(AbstractC3141l.b(dateQ0)) : null;
                        }
                        if (dValueOf == null) {
                            break;
                        } else {
                            bVar.b = dValueOf.doubleValue();
                            break;
                        }
                    case "value":
                        Double dL0 = interfaceC3118g1.l0();
                        if (dL0 == null) {
                            break;
                        } else {
                            bVar.d = dL0.doubleValue();
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
            bVar.e(concurrentHashMap);
            interfaceC3118g1.F();
            return bVar;
        }
    }

    public b() {
        this(0L, 0, 0L);
    }

    private BigDecimal d(Double d) {
        return BigDecimal.valueOf(d.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public void e(Map map) {
        this.a = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return u.a(this.a, bVar.a) && this.c.equals(bVar.c) && this.d == bVar.d && this.b == bVar.b;
    }

    public int hashCode() {
        return u.b(this.a, this.c, Double.valueOf(this.d));
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("value").l(iLogger, Double.valueOf(this.d));
        interfaceC3123h1.f("elapsed_since_start_ns").l(iLogger, this.c);
        interfaceC3123h1.f("timestamp").l(iLogger, d(Double.valueOf(this.b)));
        Map map = this.a;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.a.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public b(Long l, Number number, long j) {
        this.c = l.toString();
        this.d = number.doubleValue();
        this.b = AbstractC3141l.m(j);
    }
}
