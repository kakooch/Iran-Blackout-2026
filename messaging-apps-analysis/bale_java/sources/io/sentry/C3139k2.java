package io.sentry;

import io.sentry.T3;
import io.sentry.protocol.p;
import io.sentry.protocol.v;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.sentry.k2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3139k2 implements A0 {
    private final io.sentry.protocol.v a;
    private final io.sentry.protocol.p b;
    private final T3 c;
    private Date d;
    private Map e;

    /* renamed from: io.sentry.k2$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3139k2 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            io.sentry.protocol.v vVar = null;
            io.sentry.protocol.p pVar = null;
            T3 t3 = null;
            Date dateQ0 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "sdk":
                        pVar = (io.sentry.protocol.p) interfaceC3118g1.E0(iLogger, new p.a());
                        break;
                    case "trace":
                        t3 = (T3) interfaceC3118g1.E0(iLogger, new T3.a());
                        break;
                    case "event_id":
                        vVar = (io.sentry.protocol.v) interfaceC3118g1.E0(iLogger, new v.a());
                        break;
                    case "sent_at":
                        dateQ0 = interfaceC3118g1.q0(iLogger);
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        interfaceC3118g1.j1(iLogger, map, strN0);
                        break;
                }
            }
            C3139k2 c3139k2 = new C3139k2(vVar, pVar, t3);
            c3139k2.d(dateQ0);
            c3139k2.e(map);
            interfaceC3118g1.F();
            return c3139k2;
        }
    }

    public C3139k2(io.sentry.protocol.v vVar, io.sentry.protocol.p pVar) {
        this(vVar, pVar, null);
    }

    public io.sentry.protocol.v a() {
        return this.a;
    }

    public io.sentry.protocol.p b() {
        return this.b;
    }

    public T3 c() {
        return this.c;
    }

    public void d(Date date) {
        this.d = date;
    }

    public void e(Map map) {
        this.e = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("event_id").l(iLogger, this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("sdk").l(iLogger, this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("trace").l(iLogger, this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("sent_at").l(iLogger, AbstractC3141l.h(this.d));
        }
        Map map = this.e;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.e.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public C3139k2(io.sentry.protocol.v vVar, io.sentry.protocol.p pVar, T3 t3) {
        this.a = vVar;
        this.b = pVar;
        this.c = t3;
    }
}
