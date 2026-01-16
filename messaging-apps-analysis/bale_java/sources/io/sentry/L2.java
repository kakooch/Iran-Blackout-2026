package io.sentry;

import io.sentry.AbstractC3099c2;
import io.sentry.Y2;
import io.sentry.protocol.B;
import io.sentry.protocol.k;
import io.sentry.protocol.q;
import io.sentry.util.AbstractC3204c;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class L2 extends AbstractC3099c2 implements A0 {
    private Date p;
    private io.sentry.protocol.k q;
    private String r;
    private B3 s;
    private B3 t;
    private Y2 u;
    private String v;
    private List w;
    private Map x;
    private Map y;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public L2 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            L2 l2 = new L2();
            AbstractC3099c2.a aVar = new AbstractC3099c2.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "fingerprint":
                        List list = (List) interfaceC3118g1.H1();
                        if (list == null) {
                            break;
                        } else {
                            l2.w = list;
                            break;
                        }
                    case "threads":
                        interfaceC3118g1.B();
                        interfaceC3118g1.n0();
                        l2.s = new B3(interfaceC3118g1.Q1(iLogger, new B.a()));
                        interfaceC3118g1.F();
                        break;
                    case "logger":
                        l2.r = interfaceC3118g1.g1();
                        break;
                    case "timestamp":
                        Date dateQ0 = interfaceC3118g1.q0(iLogger);
                        if (dateQ0 == null) {
                            break;
                        } else {
                            l2.p = dateQ0;
                            break;
                        }
                    case "level":
                        l2.u = (Y2) interfaceC3118g1.E0(iLogger, new Y2.a());
                        break;
                    case "message":
                        l2.q = (io.sentry.protocol.k) interfaceC3118g1.E0(iLogger, new k.a());
                        break;
                    case "modules":
                        l2.y = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        break;
                    case "exception":
                        interfaceC3118g1.B();
                        interfaceC3118g1.n0();
                        l2.t = new B3(interfaceC3118g1.Q1(iLogger, new q.a()));
                        interfaceC3118g1.F();
                        break;
                    case "transaction":
                        l2.v = interfaceC3118g1.g1();
                        break;
                    default:
                        if (!aVar.a(l2, strN0, interfaceC3118g1, iLogger)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                            break;
                        } else {
                            break;
                        }
                }
            }
            l2.J0(concurrentHashMap);
            interfaceC3118g1.F();
            return l2;
        }
    }

    L2(io.sentry.protocol.v vVar, Date date) {
        super(vVar);
        this.p = date;
    }

    public boolean A0() {
        B3 b3 = this.t;
        return (b3 == null || b3.a().isEmpty()) ? false : true;
    }

    public void B0(List list) {
        this.t = new B3(list);
    }

    public void C0(List list) {
        this.w = list != null ? new ArrayList(list) : null;
    }

    public void D0(Y2 y2) {
        this.u = y2;
    }

    public void E0(io.sentry.protocol.k kVar) {
        this.q = kVar;
    }

    public void F0(Map map) {
        this.y = AbstractC3204c.c(map);
    }

    public void G0(List list) {
        this.s = new B3(list);
    }

    public void H0(Date date) {
        this.p = date;
    }

    public void I0(String str) {
        this.v = str;
    }

    public void J0(Map map) {
        this.x = map;
    }

    public List q0() {
        B3 b3 = this.t;
        if (b3 == null) {
            return null;
        }
        return b3.a();
    }

    public List r0() {
        return this.w;
    }

    public Y2 s0() {
        return this.u;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("timestamp").l(iLogger, this.p);
        if (this.q != null) {
            interfaceC3123h1.f(DialogEntity.COLUMN_MESSAGE).l(iLogger, this.q);
        }
        if (this.r != null) {
            interfaceC3123h1.f("logger").h(this.r);
        }
        B3 b3 = this.s;
        if (b3 != null && !b3.a().isEmpty()) {
            interfaceC3123h1.f("threads");
            interfaceC3123h1.B();
            interfaceC3123h1.f("values").l(iLogger, this.s.a());
            interfaceC3123h1.F();
        }
        B3 b32 = this.t;
        if (b32 != null && !b32.a().isEmpty()) {
            interfaceC3123h1.f("exception");
            interfaceC3123h1.B();
            interfaceC3123h1.f("values").l(iLogger, this.t.a());
            interfaceC3123h1.F();
        }
        if (this.u != null) {
            interfaceC3123h1.f("level").l(iLogger, this.u);
        }
        if (this.v != null) {
            interfaceC3123h1.f("transaction").h(this.v);
        }
        if (this.w != null) {
            interfaceC3123h1.f("fingerprint").l(iLogger, this.w);
        }
        if (this.y != null) {
            interfaceC3123h1.f("modules").l(iLogger, this.y);
        }
        new AbstractC3099c2.b().a(this, interfaceC3123h1, iLogger);
        Map map = this.x;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.x.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public io.sentry.protocol.k t0() {
        return this.q;
    }

    Map u0() {
        return this.y;
    }

    public List v0() {
        B3 b3 = this.s;
        if (b3 != null) {
            return b3.a();
        }
        return null;
    }

    public Date w0() {
        return (Date) this.p.clone();
    }

    public String x0() {
        return this.v;
    }

    public io.sentry.protocol.q y0() {
        B3 b3 = this.t;
        if (b3 == null) {
            return null;
        }
        for (io.sentry.protocol.q qVar : b3.a()) {
            if (qVar.g() != null && qVar.g().l() != null && !qVar.g().l().booleanValue()) {
                return qVar;
            }
        }
        return null;
    }

    public boolean z0() {
        return y0() != null;
    }

    public L2(Throwable th) {
        this();
        this.j = th;
    }

    public L2() {
        this(new io.sentry.protocol.v(), AbstractC3141l.d());
    }
}
