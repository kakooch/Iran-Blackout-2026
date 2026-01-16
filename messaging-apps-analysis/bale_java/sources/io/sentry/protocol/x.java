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
public final class x implements A0 {
    private String a;
    private String b;
    private String c;
    private Map d;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            x xVar = new x();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "raw_description":
                        xVar.c = interfaceC3118g1.g1();
                        break;
                    case "name":
                        xVar.a = interfaceC3118g1.g1();
                        break;
                    case "version":
                        xVar.b = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            xVar.g(concurrentHashMap);
            interfaceC3118g1.F();
            return xVar;
        }
    }

    public x() {
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public void f(String str) {
        this.a = str;
    }

    public void g(Map map) {
        this.d = map;
    }

    public void h(String str) {
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
        Map map = this.d;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.d.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    x(x xVar) {
        this.a = xVar.a;
        this.b = xVar.b;
        this.c = xVar.c;
        this.d = AbstractC3204c.b(xVar.d);
    }
}
