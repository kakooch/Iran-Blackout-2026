package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.protocol.z;
import io.sentry.util.AbstractC3204c;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class A implements A0 {
    private List a;
    private Map b;
    private Boolean c;
    private Map d;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public A a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            A a = new A();
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "frames":
                        a.a = interfaceC3118g1.Q1(iLogger, new z.a());
                        break;
                    case "registers":
                        a.b = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        break;
                    case "snapshot":
                        a.c = interfaceC3118g1.v0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            a.f(concurrentHashMap);
            interfaceC3118g1.F();
            return a;
        }
    }

    public A() {
    }

    public List d() {
        return this.a;
    }

    public void e(Boolean bool) {
        this.c = bool;
    }

    public void f(Map map) {
        this.d = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("frames").l(iLogger, this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("registers").l(iLogger, this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("snapshot").m(this.c);
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

    public A(List list) {
        this.a = list;
    }
}
