package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.protocol.I;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class H implements A0 {
    private final String a;
    private final List b;
    private Map c;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public H a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            String strG1 = null;
            List listQ1 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("rendering_system")) {
                    strG1 = interfaceC3118g1.g1();
                } else if (strN0.equals("windows")) {
                    listQ1 = interfaceC3118g1.Q1(iLogger, new I.a());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            interfaceC3118g1.F();
            H h = new H(strG1, listQ1);
            h.a(map);
            return h;
        }
    }

    public H(String str, List list) {
        this.a = str;
        this.b = list;
    }

    public void a(Map map) {
        this.c = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("rendering_system").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("windows").l(iLogger, this.b);
        }
        Map map = this.c;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.c.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
