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

/* renamed from: io.sentry.protocol.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3173h implements A0 {
    private String a;
    private Integer b;
    private String c;
    private String d;
    private Integer e;
    private String f;
    private Boolean g;
    private String h;
    private String i;
    private Map j;

    /* renamed from: io.sentry.protocol.h$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3173h a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            C3173h c3173h = new C3173h();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "npot_support":
                        c3173h.i = interfaceC3118g1.g1();
                        break;
                    case "vendor_id":
                        c3173h.c = interfaceC3118g1.g1();
                        break;
                    case "multi_threaded_rendering":
                        c3173h.g = interfaceC3118g1.v0();
                        break;
                    case "id":
                        c3173h.b = interfaceC3118g1.Y0();
                        break;
                    case "name":
                        c3173h.a = interfaceC3118g1.g1();
                        break;
                    case "vendor_name":
                        c3173h.d = interfaceC3118g1.g1();
                        break;
                    case "version":
                        c3173h.h = interfaceC3118g1.g1();
                        break;
                    case "api_type":
                        c3173h.f = interfaceC3118g1.g1();
                        break;
                    case "memory_size":
                        c3173h.e = interfaceC3118g1.Y0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            c3173h.j(concurrentHashMap);
            interfaceC3118g1.F();
            return c3173h;
        }
    }

    public C3173h() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3173h.class != obj.getClass()) {
            return false;
        }
        C3173h c3173h = (C3173h) obj;
        return io.sentry.util.u.a(this.a, c3173h.a) && io.sentry.util.u.a(this.b, c3173h.b) && io.sentry.util.u.a(this.c, c3173h.c) && io.sentry.util.u.a(this.d, c3173h.d) && io.sentry.util.u.a(this.e, c3173h.e) && io.sentry.util.u.a(this.f, c3173h.f) && io.sentry.util.u.a(this.g, c3173h.g) && io.sentry.util.u.a(this.h, c3173h.h) && io.sentry.util.u.a(this.i, c3173h.i);
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public void j(Map map) {
        this.j = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("name").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("id").k(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("vendor_id").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("vendor_name").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("memory_size").k(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("api_type").h(this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("multi_threaded_rendering").m(this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f(ParameterNames.VERSION).h(this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("npot_support").h(this.i);
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

    C3173h(C3173h c3173h) {
        this.a = c3173h.a;
        this.b = c3173h.b;
        this.c = c3173h.c;
        this.d = c3173h.d;
        this.e = c3173h.e;
        this.f = c3173h.f;
        this.g = c3173h.g;
        this.h = c3173h.h;
        this.i = c3173h.i;
        this.j = AbstractC3204c.b(c3173h.j);
    }
}
