package io.sentry.rrweb;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.rrweb.b;
import io.sentry.util.AbstractC3204c;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class i extends b implements A0 {
    private String c;
    private String d;
    private String e;
    private double f;
    private double g;
    private Map h;
    private Map i;
    private Map j;
    private Map k;

    public static final class a implements InterfaceC3176q0 {
        private void c(i iVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("payload")) {
                    d(iVar, interfaceC3118g1, iLogger);
                } else if (strN0.equals(ParameterNames.TAG)) {
                    String strG1 = interfaceC3118g1.g1();
                    if (strG1 == null) {
                        strG1 = "";
                    }
                    iVar.c = strG1;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                }
            }
            iVar.p(concurrentHashMap);
            interfaceC3118g1.F();
        }

        private void d(i iVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "description":
                        iVar.e = interfaceC3118g1.g1();
                        break;
                    case "endTimestamp":
                        iVar.g = interfaceC3118g1.f1();
                        break;
                    case "startTimestamp":
                        iVar.f = interfaceC3118g1.f1();
                        break;
                    case "op":
                        iVar.d = interfaceC3118g1.g1();
                        break;
                    case "data":
                        Map mapB = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        if (mapB == null) {
                            break;
                        } else {
                            iVar.h = mapB;
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
            iVar.t(concurrentHashMap);
            interfaceC3118g1.F();
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            i iVar = new i();
            b.a aVar = new b.a();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("data")) {
                    c(iVar, interfaceC3118g1, iLogger);
                } else if (!aVar.a(iVar, strN0, interfaceC3118g1, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            iVar.v(map);
            interfaceC3118g1.F();
            return iVar;
        }
    }

    public i() {
        super(c.Custom);
        this.c = "performanceSpan";
    }

    private void m(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f(ParameterNames.TAG).h(this.c);
        interfaceC3123h1.f("payload");
        n(interfaceC3123h1, iLogger);
        Map map = this.k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.k.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    private void n(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.d != null) {
            interfaceC3123h1.f("op").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("description").h(this.e);
        }
        interfaceC3123h1.f("startTimestamp").l(iLogger, BigDecimal.valueOf(this.f));
        interfaceC3123h1.f("endTimestamp").l(iLogger, BigDecimal.valueOf(this.g));
        if (this.h != null) {
            interfaceC3123h1.f("data").l(iLogger, this.h);
        }
        Map map = this.j;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.j.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public void o(Map map) {
        this.h = map == null ? null : new ConcurrentHashMap(map);
    }

    public void p(Map map) {
        this.k = map;
    }

    public void q(String str) {
        this.e = str;
    }

    public void r(double d) {
        this.g = d;
    }

    public void s(String str) {
        this.d = str;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new b.C0251b().a(this, interfaceC3123h1, iLogger);
        interfaceC3123h1.f("data");
        m(interfaceC3123h1, iLogger);
        Map map = this.i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.i.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public void t(Map map) {
        this.j = map;
    }

    public void u(double d) {
        this.f = d;
    }

    public void v(Map map) {
        this.i = map;
    }
}
