package io.sentry;

import io.sentry.M3;
import io.sentry.O3;
import io.sentry.protocol.v;
import io.sentry.util.AbstractC3204c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class H3 implements A0 {
    private final io.sentry.protocol.v a;
    private final M3 b;
    private M3 c;
    private transient V3 d;
    protected String e;
    protected String f;
    protected O3 g;
    protected Map h;
    protected String i;
    protected Map j;
    private Map k;
    private EnumC3152n0 l;
    protected C3101d m;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public H3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            String strT0 = null;
            io.sentry.protocol.v vVarA = null;
            M3 m3B = null;
            M3 m3 = null;
            ConcurrentHashMap concurrentHashMap = null;
            String strT02 = null;
            O3 o3 = null;
            String strT03 = null;
            Map mapB = null;
            Map map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "span_id":
                        m3B = new M3.a().a(interfaceC3118g1, iLogger);
                        break;
                    case "parent_span_id":
                        m3 = (M3) interfaceC3118g1.E0(iLogger, new M3.a());
                        break;
                    case "description":
                        strT02 = interfaceC3118g1.T0();
                        break;
                    case "origin":
                        strT03 = interfaceC3118g1.T0();
                        break;
                    case "status":
                        o3 = (O3) interfaceC3118g1.E0(iLogger, new O3.a());
                        break;
                    case "op":
                        strT0 = interfaceC3118g1.T0();
                        break;
                    case "data":
                        map = (Map) interfaceC3118g1.H1();
                        break;
                    case "tags":
                        mapB = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        break;
                    case "trace_id":
                        vVarA = new v.a().a(interfaceC3118g1, iLogger);
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            if (vVarA == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                iLogger.b(Y2.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (m3B == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
                iLogger.b(Y2.ERROR, "Missing required field \"span_id\"", illegalStateException2);
                throw illegalStateException2;
            }
            H3 h3 = new H3(vVarA, m3B, strT0 == null ? "" : strT0, m3, null);
            h3.p(strT02);
            h3.t(o3);
            h3.r(strT03);
            if (mapB != null) {
                h3.h = mapB;
            }
            if (map != null) {
                h3.j = map;
            }
            h3.u(concurrentHashMap);
            interfaceC3118g1.F();
            return h3;
        }
    }

    public H3(String str) {
        this(new io.sentry.protocol.v(), new M3(), str, null, null);
    }

    public H3 a(String str, M3 m3, M3 m32) {
        io.sentry.protocol.v vVar = this.a;
        if (m32 == null) {
            m32 = new M3();
        }
        return new H3(vVar, m32, m3, str, null, this.d, null, "manual");
    }

    public C3101d b() {
        return this.m;
    }

    public String c() {
        return this.f;
    }

    public EnumC3152n0 d() {
        return this.l;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H3)) {
            return false;
        }
        H3 h3 = (H3) obj;
        return this.a.equals(h3.a) && this.b.equals(h3.b) && io.sentry.util.u.a(this.c, h3.c) && this.e.equals(h3.e) && io.sentry.util.u.a(this.f, h3.f) && l() == h3.l();
    }

    public String f() {
        return this.i;
    }

    public M3 g() {
        return this.c;
    }

    public Boolean h() {
        V3 v3 = this.d;
        if (v3 == null) {
            return null;
        }
        return v3.b();
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b, this.c, this.e, this.f, l());
    }

    public Boolean i() {
        V3 v3 = this.d;
        if (v3 == null) {
            return null;
        }
        return v3.e();
    }

    public V3 j() {
        return this.d;
    }

    public M3 k() {
        return this.b;
    }

    public O3 l() {
        return this.g;
    }

    public Map m() {
        return this.h;
    }

    public io.sentry.protocol.v n() {
        return this.a;
    }

    public void o(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            this.j.remove(str);
        } else {
            this.j.put(str, obj);
        }
    }

    public void p(String str) {
        this.f = str;
    }

    public void q(EnumC3152n0 enumC3152n0) {
        this.l = enumC3152n0;
    }

    public void r(String str) {
        this.i = str;
    }

    public void s(V3 v3) {
        this.d = v3;
        C3101d c3101d = this.m;
        if (c3101d != null) {
            c3101d.G(v3);
        }
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("trace_id");
        this.a.serialize(interfaceC3123h1, iLogger);
        interfaceC3123h1.f("span_id");
        this.b.serialize(interfaceC3123h1, iLogger);
        if (this.c != null) {
            interfaceC3123h1.f("parent_span_id");
            this.c.serialize(interfaceC3123h1, iLogger);
        }
        interfaceC3123h1.f("op").h(this.e);
        if (this.f != null) {
            interfaceC3123h1.f("description").h(this.f);
        }
        if (l() != null) {
            interfaceC3123h1.f("status").l(iLogger, l());
        }
        if (this.i != null) {
            interfaceC3123h1.f("origin").l(iLogger, this.i);
        }
        if (!this.h.isEmpty()) {
            interfaceC3123h1.f("tags").l(iLogger, this.h);
        }
        if (!this.j.isEmpty()) {
            interfaceC3123h1.f("data").l(iLogger, this.j);
        }
        Map map = this.k;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.k.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public void t(O3 o3) {
        this.g = o3;
    }

    public void u(Map map) {
        this.k = map;
    }

    public H3(io.sentry.protocol.v vVar, M3 m3, String str, M3 m32, V3 v3) {
        this(vVar, m3, m32, str, null, v3, null, "manual");
    }

    public H3(io.sentry.protocol.v vVar, M3 m3, M3 m32, String str, String str2, V3 v3, O3 o3, String str3) {
        this.h = new ConcurrentHashMap();
        this.i = "manual";
        this.j = new ConcurrentHashMap();
        this.l = EnumC3152n0.SENTRY;
        this.a = (io.sentry.protocol.v) io.sentry.util.u.c(vVar, "traceId is required");
        this.b = (M3) io.sentry.util.u.c(m3, "spanId is required");
        this.e = (String) io.sentry.util.u.c(str, "operation is required");
        this.c = m32;
        this.f = str2;
        this.g = o3;
        this.i = str3;
        s(v3);
        io.sentry.util.thread.a threadChecker = N1.c().e().getThreadChecker();
        this.j.put("thread.id", String.valueOf(threadChecker.c()));
        this.j.put("thread.name", threadChecker.b());
    }

    public H3(H3 h3) {
        this.h = new ConcurrentHashMap();
        this.i = "manual";
        this.j = new ConcurrentHashMap();
        this.l = EnumC3152n0.SENTRY;
        this.a = h3.a;
        this.b = h3.b;
        this.c = h3.c;
        s(h3.d);
        this.e = h3.e;
        this.f = h3.f;
        this.g = h3.g;
        Map mapB = AbstractC3204c.b(h3.h);
        if (mapB != null) {
            this.h = mapB;
        }
        Map mapB2 = AbstractC3204c.b(h3.k);
        if (mapB2 != null) {
            this.k = mapB2;
        }
        this.m = h3.m;
        Map mapB3 = AbstractC3204c.b(h3.j);
        if (mapB3 != null) {
            this.j = mapB3;
        }
    }
}
