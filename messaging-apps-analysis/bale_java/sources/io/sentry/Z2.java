package io.sentry;

import io.sentry.util.AbstractC3204c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class Z2 implements A0 {
    private int a;
    private String b;
    private String c;
    private String d;
    private Long e;
    private Map f;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Z2 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            Z2 z2 = new Z2();
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "package_name":
                        z2.c = interfaceC3118g1.g1();
                        break;
                    case "thread_id":
                        z2.e = interfaceC3118g1.a1();
                        break;
                    case "address":
                        z2.b = interfaceC3118g1.g1();
                        break;
                    case "class_name":
                        z2.d = interfaceC3118g1.g1();
                        break;
                    case "type":
                        z2.a = interfaceC3118g1.r0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            z2.m(concurrentHashMap);
            interfaceC3118g1.F();
            return z2;
        }
    }

    public Z2() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Z2.class != obj.getClass()) {
            return false;
        }
        return io.sentry.util.u.a(this.b, ((Z2) obj).b);
    }

    public String f() {
        return this.b;
    }

    public int g() {
        return this.a;
    }

    public void h(String str) {
        this.b = str;
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.b);
    }

    public void i(String str) {
        this.d = str;
    }

    public void j(String str) {
        this.c = str;
    }

    public void k(Long l) {
        this.e = l;
    }

    public void l(int i) {
        this.a = i;
    }

    public void m(Map map) {
        this.f = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("type").b(this.a);
        if (this.b != null) {
            interfaceC3123h1.f("address").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("package_name").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("class_name").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("thread_id").k(this.e);
        }
        Map map = this.f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public Z2(Z2 z2) {
        this.a = z2.a;
        this.b = z2.b;
        this.c = z2.c;
        this.d = z2.d;
        this.e = z2.e;
        this.f = AbstractC3204c.b(z2.f);
    }
}
