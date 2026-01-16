package io.sentry.protocol;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.W2;
import io.sentry.Y2;
import io.sentry.protocol.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public final class p implements A0 {
    private String a;
    private String b;
    private Set c;
    private Set d;
    private Map e;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public p a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            interfaceC3118g1.B();
            String strT0 = null;
            String strT02 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "name":
                        strT0 = interfaceC3118g1.T0();
                        break;
                    case "version":
                        strT02 = interfaceC3118g1.T0();
                        break;
                    case "packages":
                        List listQ1 = interfaceC3118g1.Q1(iLogger, new w.a());
                        if (listQ1 == null) {
                            break;
                        } else {
                            arrayList.addAll(listQ1);
                            break;
                        }
                    case "integrations":
                        List list = (List) interfaceC3118g1.H1();
                        if (list == null) {
                            break;
                        } else {
                            arrayList2.addAll(list);
                            break;
                        }
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        interfaceC3118g1.j1(iLogger, map, strN0);
                        break;
                }
            }
            interfaceC3118g1.F();
            if (strT0 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                iLogger.b(Y2.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strT02 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                iLogger.b(Y2.ERROR, "Missing required field \"version\"", illegalStateException2);
                throw illegalStateException2;
            }
            p pVar = new p(strT0, strT02);
            pVar.c = new CopyOnWriteArraySet(arrayList);
            pVar.d = new CopyOnWriteArraySet(arrayList2);
            pVar.i(map);
            return pVar;
        }
    }

    public p(String str, String str2) {
        this.a = (String) io.sentry.util.u.c(str, "name is required.");
        this.b = (String) io.sentry.util.u.c(str2, "version is required.");
    }

    public static p k(p pVar, String str, String str2) {
        io.sentry.util.u.c(str, "name is required.");
        io.sentry.util.u.c(str2, "version is required.");
        if (pVar == null) {
            return new p(str, str2);
        }
        pVar.h(str);
        pVar.j(str2);
        return pVar;
    }

    public void c(String str, String str2) {
        W2.d().b(str, str2);
    }

    public Set d() {
        Set set = this.d;
        return set != null ? set : W2.d().e();
    }

    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.a.equals(pVar.a) && this.b.equals(pVar.b);
    }

    public Set f() {
        Set set = this.c;
        return set != null ? set : W2.d().f();
    }

    public String g() {
        return this.b;
    }

    public void h(String str) {
        this.a = (String) io.sentry.util.u.c(str, "name is required.");
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b);
    }

    public void i(Map map) {
        this.e = map;
    }

    public void j(String str) {
        this.b = (String) io.sentry.util.u.c(str, "version is required.");
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("name").h(this.a);
        interfaceC3123h1.f(ParameterNames.VERSION).h(this.b);
        Set setF = f();
        Set setD = d();
        if (!setF.isEmpty()) {
            interfaceC3123h1.f("packages").l(iLogger, setF);
        }
        if (!setD.isEmpty()) {
            interfaceC3123h1.f("integrations").l(iLogger, setD);
        }
        Map map = this.e;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.e.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
