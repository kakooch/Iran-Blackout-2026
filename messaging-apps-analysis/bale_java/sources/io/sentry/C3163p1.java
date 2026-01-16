package io.sentry;

import io.sentry.protocol.v;
import io.sentry.util.AbstractC3204c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.p1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3163p1 implements A0 {
    private io.sentry.protocol.v a;
    private Map b;

    /* renamed from: io.sentry.p1$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3163p1 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            C3163p1 c3163p1 = new C3163p1();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("profiler_id")) {
                    io.sentry.protocol.v vVar = (io.sentry.protocol.v) interfaceC3118g1.E0(iLogger, new v.a());
                    if (vVar != null) {
                        c3163p1.a = vVar;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                }
            }
            c3163p1.b(concurrentHashMap);
            interfaceC3118g1.F();
            return c3163p1;
        }
    }

    public C3163p1() {
        this(io.sentry.protocol.v.b);
    }

    public void b(Map map) {
        this.b = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3163p1) {
            return this.a.equals(((C3163p1) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a);
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("profiler_id").l(iLogger, this.a);
        Map map = this.b;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.b.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public C3163p1(io.sentry.protocol.v vVar) {
        this.a = vVar;
    }

    public C3163p1(C3163p1 c3163p1) {
        this.a = c3163p1.a;
        Map mapB = AbstractC3204c.b(c3163p1.b);
        if (mapB != null) {
            this.b = mapB;
        }
    }
}
