package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.AbstractC3099c2;
import io.sentry.AbstractC3141l;
import io.sentry.C3234z3;
import io.sentry.G3;
import io.sentry.H3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.V3;
import io.sentry.protocol.C3174i;
import io.sentry.protocol.E;
import io.sentry.protocol.y;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class C extends AbstractC3099c2 implements A0 {
    private String p;
    private Double q;
    private Double r;
    private final List s;
    private final String t;
    private final Map u;
    private E v;
    private Map w;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            C c = new C("", Double.valueOf(0.0d), null, new ArrayList(), new HashMap(), new E(F.CUSTOM.apiName()));
            AbstractC3099c2.a aVar = new AbstractC3099c2.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "start_timestamp":
                        try {
                            Double dL0 = interfaceC3118g1.l0();
                            if (dL0 == null) {
                                break;
                            } else {
                                c.q = dL0;
                                break;
                            }
                        } catch (NumberFormatException unused) {
                            Date dateQ0 = interfaceC3118g1.q0(iLogger);
                            if (dateQ0 == null) {
                                break;
                            } else {
                                c.q = Double.valueOf(AbstractC3141l.b(dateQ0));
                                break;
                            }
                        }
                    case "measurements":
                        Map mapI1 = interfaceC3118g1.i1(iLogger, new C3174i.a());
                        if (mapI1 == null) {
                            break;
                        } else {
                            c.u.putAll(mapI1);
                            break;
                        }
                    case "type":
                        interfaceC3118g1.T0();
                        break;
                    case "timestamp":
                        try {
                            Double dL02 = interfaceC3118g1.l0();
                            if (dL02 == null) {
                                break;
                            } else {
                                c.r = dL02;
                                break;
                            }
                        } catch (NumberFormatException unused2) {
                            Date dateQ02 = interfaceC3118g1.q0(iLogger);
                            if (dateQ02 == null) {
                                break;
                            } else {
                                c.r = Double.valueOf(AbstractC3141l.b(dateQ02));
                                break;
                            }
                        }
                    case "spans":
                        List listQ1 = interfaceC3118g1.Q1(iLogger, new y.a());
                        if (listQ1 == null) {
                            break;
                        } else {
                            c.s.addAll(listQ1);
                            break;
                        }
                    case "transaction_info":
                        c.v = new E.a().a(interfaceC3118g1, iLogger);
                        break;
                    case "transaction":
                        c.p = interfaceC3118g1.g1();
                        break;
                    default:
                        if (!aVar.a(c, strN0, interfaceC3118g1, iLogger)) {
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
            c.t0(concurrentHashMap);
            interfaceC3118g1.F();
            return c;
        }
    }

    public C(C3234z3 c3234z3) {
        super(c3234z3.b());
        this.s = new ArrayList();
        this.t = "transaction";
        this.u = new HashMap();
        io.sentry.util.u.c(c3234z3, "sentryTracer is required");
        this.q = Double.valueOf(AbstractC3141l.m(c3234z3.y().p()));
        this.r = Double.valueOf(AbstractC3141l.m(c3234z3.y().o(c3234z3.w())));
        this.p = c3234z3.getName();
        for (G3 g3 : c3234z3.H()) {
            if (Boolean.TRUE.equals(g3.l())) {
                this.s.add(new y(g3));
            }
        }
        C3168c c3168cC = C();
        c3168cC.l(c3234z3.I());
        H3 h3V = c3234z3.v();
        Map mapJ = c3234z3.J();
        H3 h3 = new H3(h3V.n(), h3V.k(), h3V.g(), h3V.e(), h3V.c(), h3V.j(), h3V.l(), h3V.f());
        for (Map.Entry entry : h3V.m().entrySet()) {
            d0((String) entry.getKey(), (String) entry.getValue());
        }
        if (mapJ != null) {
            for (Map.Entry entry2 : mapJ.entrySet()) {
                h3.o((String) entry2.getKey(), entry2.getValue());
            }
        }
        c3168cC.x(h3);
        this.v = new E(c3234z3.N().apiName());
    }

    public Map n0() {
        return this.u;
    }

    public V3 o0() {
        H3 h3I = C().i();
        if (h3I == null) {
            return null;
        }
        return h3I.j();
    }

    public List p0() {
        return this.s;
    }

    public String q0() {
        return this.p;
    }

    public boolean r0() {
        return this.r != null;
    }

    public boolean s0() {
        V3 v3O0 = o0();
        if (v3O0 == null) {
            return false;
        }
        return v3O0.e().booleanValue();
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.p != null) {
            interfaceC3123h1.f("transaction").h(this.p);
        }
        interfaceC3123h1.f("start_timestamp").l(iLogger, AbstractC3141l.c(this.q));
        if (this.r != null) {
            interfaceC3123h1.f("timestamp").l(iLogger, AbstractC3141l.c(this.r));
        }
        if (!this.s.isEmpty()) {
            interfaceC3123h1.f("spans").l(iLogger, this.s);
        }
        interfaceC3123h1.f("type").h("transaction");
        if (!this.u.isEmpty()) {
            interfaceC3123h1.f("measurements").l(iLogger, this.u);
        }
        interfaceC3123h1.f("transaction_info").l(iLogger, this.v);
        new AbstractC3099c2.b().a(this, interfaceC3123h1, iLogger);
        Map map = this.w;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.w.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public void t0(Map map) {
        this.w = map;
    }

    public C(String str, Double d, Double d2, List list, Map map, E e) {
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        this.t = "transaction";
        HashMap map2 = new HashMap();
        this.u = map2;
        this.p = str;
        this.q = d;
        this.r = d2;
        arrayList.addAll(list);
        map2.putAll(map);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.u.putAll(((y) it.next()).c());
        }
        this.v = e;
    }
}
