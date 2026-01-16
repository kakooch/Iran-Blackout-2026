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

/* renamed from: io.sentry.protocol.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3167b implements A0 {
    private String a;
    private String b;
    private Map c;

    /* renamed from: io.sentry.protocol.b$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3167b a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            C3167b c3167b = new C3167b();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("name")) {
                    c3167b.a = interfaceC3118g1.g1();
                } else if (strN0.equals(ParameterNames.VERSION)) {
                    c3167b.b = interfaceC3118g1.g1();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                }
            }
            c3167b.c(concurrentHashMap);
            interfaceC3118g1.F();
            return c3167b;
        }
    }

    public C3167b() {
    }

    public void c(Map map) {
        this.c = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3167b.class != obj.getClass()) {
            return false;
        }
        C3167b c3167b = (C3167b) obj;
        return io.sentry.util.u.a(this.a, c3167b.a) && io.sentry.util.u.a(this.b, c3167b.b);
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b);
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
        Map map = this.c;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.c.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    C3167b(C3167b c3167b) {
        this.a = c3167b.a;
        this.b = c3167b.b;
        this.c = AbstractC3204c.b(c3167b.c);
    }
}
