package io.sentry;

import io.sentry.C3095b3;
import io.sentry.EnumC3105d3;
import io.sentry.protocol.v;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.sentry.a3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3035a3 implements A0 {
    private io.sentry.protocol.v a;
    private Double b;
    private String c;
    private EnumC3105d3 d;
    private Integer e;
    private Map f;
    private Map g;

    /* renamed from: io.sentry.a3$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3035a3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            io.sentry.protocol.v vVar = null;
            Double dL0 = null;
            String strG1 = null;
            HashMap map = null;
            EnumC3105d3 enumC3105d3 = null;
            Map mapI1 = null;
            Integer numY0 = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "severity_number":
                        numY0 = interfaceC3118g1.Y0();
                        break;
                    case "body":
                        strG1 = interfaceC3118g1.g1();
                        break;
                    case "timestamp":
                        dL0 = interfaceC3118g1.l0();
                        break;
                    case "level":
                        enumC3105d3 = (EnumC3105d3) interfaceC3118g1.E0(iLogger, new EnumC3105d3.a());
                        break;
                    case "attributes":
                        mapI1 = interfaceC3118g1.i1(iLogger, new C3095b3.a());
                        break;
                    case "trace_id":
                        vVar = (io.sentry.protocol.v) interfaceC3118g1.E0(iLogger, new v.a());
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        interfaceC3118g1.j1(iLogger, map, strN0);
                        break;
                }
            }
            interfaceC3118g1.F();
            if (vVar == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                iLogger.b(Y2.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (dL0 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"timestamp\"");
                iLogger.b(Y2.ERROR, "Missing required field \"timestamp\"", illegalStateException2);
                throw illegalStateException2;
            }
            if (strG1 == null) {
                IllegalStateException illegalStateException3 = new IllegalStateException("Missing required field \"body\"");
                iLogger.b(Y2.ERROR, "Missing required field \"body\"", illegalStateException3);
                throw illegalStateException3;
            }
            if (enumC3105d3 == null) {
                IllegalStateException illegalStateException4 = new IllegalStateException("Missing required field \"level\"");
                iLogger.b(Y2.ERROR, "Missing required field \"level\"", illegalStateException4);
                throw illegalStateException4;
            }
            C3035a3 c3035a3 = new C3035a3(vVar, dL0, strG1, enumC3105d3);
            c3035a3.a(mapI1);
            c3035a3.b(numY0);
            c3035a3.c(map);
            return c3035a3;
        }
    }

    public C3035a3(io.sentry.protocol.v vVar, Double d, String str, EnumC3105d3 enumC3105d3) {
        this.a = vVar;
        this.b = d;
        this.c = str;
        this.d = enumC3105d3;
    }

    public void a(Map map) {
        this.f = map;
    }

    public void b(Integer num) {
        this.e = num;
    }

    public void c(Map map) {
        this.g = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("timestamp").l(iLogger, AbstractC3141l.c(this.b));
        interfaceC3123h1.f("trace_id").l(iLogger, this.a);
        interfaceC3123h1.f("body").h(this.c);
        interfaceC3123h1.f("level").l(iLogger, this.d);
        if (this.e != null) {
            interfaceC3123h1.f("severity_number").l(iLogger, this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("attributes").l(iLogger, this.f);
        }
        Map map = this.g;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.g.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
