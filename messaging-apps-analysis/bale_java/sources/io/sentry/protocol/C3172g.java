package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.protocol.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3172g implements A0 {
    private String a;
    private String b;
    private String c;
    private Map d;

    /* renamed from: io.sentry.protocol.g$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3172g a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            C3172g c3172g = new C3172g();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "region":
                        c3172g.c = interfaceC3118g1.g1();
                        break;
                    case "city":
                        c3172g.a = interfaceC3118g1.g1();
                        break;
                    case "country_code":
                        c3172g.b = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            c3172g.d(concurrentHashMap);
            interfaceC3118g1.F();
            return c3172g;
        }
    }

    public void d(Map map) {
        this.d = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("city").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("country_code").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("region").h(this.c);
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
}
