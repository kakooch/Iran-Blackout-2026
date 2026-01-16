package io.sentry.protocol;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.util.AbstractC3204c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class l implements A0 {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Boolean f;
    private Map g;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            l lVar = new l();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "rooted":
                        lVar.f = interfaceC3118g1.v0();
                        break;
                    case "raw_description":
                        lVar.c = interfaceC3118g1.g1();
                        break;
                    case "name":
                        lVar.a = interfaceC3118g1.g1();
                        break;
                    case "build":
                        lVar.d = interfaceC3118g1.g1();
                        break;
                    case "version":
                        lVar.b = interfaceC3118g1.g1();
                        break;
                    case "kernel_version":
                        lVar.e = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            lVar.l(concurrentHashMap);
            interfaceC3118g1.F();
            return lVar;
        }
    }

    public l() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return io.sentry.util.u.a(this.a, lVar.a) && io.sentry.util.u.a(this.b, lVar.b) && io.sentry.util.u.a(this.c, lVar.c) && io.sentry.util.u.a(this.d, lVar.d) && io.sentry.util.u.a(this.e, lVar.e) && io.sentry.util.u.a(this.f, lVar.f);
    }

    public String g() {
        return this.a;
    }

    public void h(String str) {
        this.d = str;
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b, this.c, this.d, this.e, this.f);
    }

    public void i(String str) {
        this.e = str;
    }

    public void j(String str) {
        this.a = str;
    }

    public void k(Boolean bool) {
        this.f = bool;
    }

    public void l(Map map) {
        this.g = map;
    }

    public void m(String str) {
        this.b = str;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("name").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f(ParameterNames.VERSION).h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("raw_description").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("build").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("kernel_version").h(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("rooted").m(this.f);
        }
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

    l(l lVar) {
        this.a = lVar.a;
        this.b = lVar.b;
        this.c = lVar.c;
        this.d = lVar.d;
        this.e = lVar.e;
        this.f = lVar.f;
        this.g = AbstractC3204c.b(lVar.g);
    }
}
