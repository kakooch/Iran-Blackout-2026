package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Y2;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.protocol.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3174i implements A0 {
    private final Number a;
    private final String b;
    private Map c;

    /* renamed from: io.sentry.protocol.i$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3174i a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            Number number = null;
            String strG1 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("unit")) {
                    strG1 = interfaceC3118g1.g1();
                } else if (strN0.equals("value")) {
                    number = (Number) interfaceC3118g1.H1();
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                }
            }
            interfaceC3118g1.F();
            if (number != null) {
                C3174i c3174i = new C3174i(number, strG1);
                c3174i.a(concurrentHashMap);
                return c3174i;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"value\"");
            iLogger.b(Y2.ERROR, "Missing required field \"value\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public C3174i(Number number, String str) {
        this.a = number;
        this.b = str;
    }

    public void a(Map map) {
        this.c = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("value").k(this.a);
        if (this.b != null) {
            interfaceC3123h1.f("unit").h(this.b);
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
}
