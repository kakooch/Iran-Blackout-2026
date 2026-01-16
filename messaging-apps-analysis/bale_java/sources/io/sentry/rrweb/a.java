package io.sentry.rrweb;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Y2;
import io.sentry.rrweb.b;
import io.sentry.util.AbstractC3204c;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.database.dailogLists.DialogEntity;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class a extends b implements A0 {
    private String c;
    private double d;
    private String e;
    private String f;
    private String g;
    private Y2 h;
    private Map i;
    private Map j;
    private Map k;
    private Map l;

    /* renamed from: io.sentry.rrweb.a$a, reason: collision with other inner class name */
    public static final class C0250a implements InterfaceC3176q0 {
        private void c(a aVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("payload")) {
                    d(aVar, interfaceC3118g1, iLogger);
                } else if (strN0.equals(ParameterNames.TAG)) {
                    String strG1 = interfaceC3118g1.g1();
                    if (strG1 == null) {
                        strG1 = "";
                    }
                    aVar.c = strG1;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                }
            }
            aVar.v(concurrentHashMap);
            interfaceC3118g1.F();
        }

        private void d(a aVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "data":
                        Map mapB = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        if (mapB == null) {
                            break;
                        } else {
                            aVar.i = mapB;
                            break;
                        }
                    case "type":
                        aVar.e = interfaceC3118g1.g1();
                        break;
                    case "category":
                        aVar.f = interfaceC3118g1.g1();
                        break;
                    case "timestamp":
                        aVar.d = interfaceC3118g1.f1();
                        break;
                    case "level":
                        try {
                            aVar.h = new Y2.a().a(interfaceC3118g1, iLogger);
                            break;
                        } catch (Exception e) {
                            iLogger.a(Y2.DEBUG, e, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                    case "message":
                        aVar.g = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            aVar.y(concurrentHashMap);
            interfaceC3118g1.F();
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            a aVar = new a();
            b.a aVar2 = new b.a();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("data")) {
                    c(aVar, interfaceC3118g1, iLogger);
                } else if (!aVar2.a(aVar, strN0, interfaceC3118g1, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            aVar.z(map);
            interfaceC3118g1.F();
            return aVar;
        }
    }

    public a() {
        super(c.Custom);
        this.c = "breadcrumb";
    }

    private void p(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f(ParameterNames.TAG).h(this.c);
        interfaceC3123h1.f("payload");
        q(interfaceC3123h1, iLogger);
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

    private void q(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.e != null) {
            interfaceC3123h1.f("type").h(this.e);
        }
        interfaceC3123h1.f("timestamp").l(iLogger, BigDecimal.valueOf(this.d));
        if (this.f != null) {
            interfaceC3123h1.f(SearchSuggestion.CATEGORY_ICON).h(this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f(DialogEntity.COLUMN_MESSAGE).h(this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("level").l(iLogger, this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("data").l(iLogger, this.i);
        }
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

    public String n() {
        return this.f;
    }

    public Map o() {
        return this.i;
    }

    public void r(double d) {
        this.d = d;
    }

    public void s(String str) {
        this.e = str;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new b.C0251b().a(this, interfaceC3123h1, iLogger);
        interfaceC3123h1.f("data");
        p(interfaceC3123h1, iLogger);
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

    public void t(String str) {
        this.f = str;
    }

    public void u(Map map) {
        this.i = map == null ? null : new ConcurrentHashMap(map);
    }

    public void v(Map map) {
        this.l = map;
    }

    public void w(Y2 y2) {
        this.h = y2;
    }

    public void x(String str) {
        this.g = str;
    }

    public void y(Map map) {
        this.k = map;
    }

    public void z(Map map) {
        this.j = map;
    }
}
