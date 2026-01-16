package io.sentry;

import io.sentry.AbstractC3099c2;
import io.sentry.protocol.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: io.sentry.o3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3160o3 extends AbstractC3099c2 implements A0 {
    private File p;
    private int t;
    private Date v;
    private Map z;
    private io.sentry.protocol.v s = new io.sentry.protocol.v();
    private String q = "replay_event";
    private b r = b.SESSION;
    private List x = new ArrayList();
    private List y = new ArrayList();
    private List w = new ArrayList();
    private Date u = AbstractC3141l.d();

    /* renamed from: io.sentry.o3$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3160o3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            AbstractC3099c2.a aVar = new AbstractC3099c2.a();
            C3160o3 c3160o3 = new C3160o3();
            interfaceC3118g1.B();
            String strG1 = null;
            b bVar = null;
            Integer numY0 = null;
            Date dateQ0 = null;
            HashMap map = null;
            io.sentry.protocol.v vVar = null;
            Date dateQ02 = null;
            List list = null;
            List list2 = null;
            List list3 = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "replay_id":
                        vVar = (io.sentry.protocol.v) interfaceC3118g1.E0(iLogger, new v.a());
                        break;
                    case "replay_start_timestamp":
                        dateQ02 = interfaceC3118g1.q0(iLogger);
                        break;
                    case "type":
                        strG1 = interfaceC3118g1.g1();
                        break;
                    case "urls":
                        list = (List) interfaceC3118g1.H1();
                        break;
                    case "timestamp":
                        dateQ0 = interfaceC3118g1.q0(iLogger);
                        break;
                    case "error_ids":
                        list2 = (List) interfaceC3118g1.H1();
                        break;
                    case "trace_ids":
                        list3 = (List) interfaceC3118g1.H1();
                        break;
                    case "replay_type":
                        bVar = (b) interfaceC3118g1.E0(iLogger, new b.a());
                        break;
                    case "segment_id":
                        numY0 = interfaceC3118g1.Y0();
                        break;
                    default:
                        if (!aVar.a(c3160o3, strN0, interfaceC3118g1, iLogger)) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            interfaceC3118g1.j1(iLogger, map, strN0);
                            break;
                        } else {
                            break;
                        }
                }
            }
            interfaceC3118g1.F();
            if (strG1 != null) {
                c3160o3.q0(strG1);
            }
            if (bVar != null) {
                c3160o3.m0(bVar);
            }
            if (numY0 != null) {
                c3160o3.n0(numY0.intValue());
            }
            if (dateQ0 != null) {
                c3160o3.o0(dateQ0);
            }
            c3160o3.k0(vVar);
            c3160o3.l0(dateQ02);
            c3160o3.s0(list);
            c3160o3.j0(list2);
            c3160o3.p0(list3);
            c3160o3.r0(map);
            return c3160o3;
        }
    }

    /* renamed from: io.sentry.o3$b */
    public enum b implements A0 {
        SESSION,
        BUFFER;

        /* renamed from: io.sentry.o3$b$a */
        public static final class a implements InterfaceC3176q0 {
            @Override // io.sentry.InterfaceC3176q0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
                return b.valueOf(interfaceC3118g1.T0().toUpperCase(Locale.ROOT));
            }
        }

        @Override // io.sentry.A0
        public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
            interfaceC3123h1.h(name().toLowerCase(Locale.ROOT));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3160o3.class != obj.getClass()) {
            return false;
        }
        C3160o3 c3160o3 = (C3160o3) obj;
        return this.t == c3160o3.t && io.sentry.util.u.a(this.q, c3160o3.q) && this.r == c3160o3.r && io.sentry.util.u.a(this.s, c3160o3.s) && io.sentry.util.u.a(this.w, c3160o3.w) && io.sentry.util.u.a(this.x, c3160o3.x) && io.sentry.util.u.a(this.y, c3160o3.y);
    }

    public Date h0() {
        return this.u;
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.q, this.r, this.s, Integer.valueOf(this.t), this.w, this.x, this.y);
    }

    public File i0() {
        return this.p;
    }

    public void j0(List list) {
        this.x = list;
    }

    public void k0(io.sentry.protocol.v vVar) {
        this.s = vVar;
    }

    public void l0(Date date) {
        this.v = date;
    }

    public void m0(b bVar) {
        this.r = bVar;
    }

    public void n0(int i) {
        this.t = i;
    }

    public void o0(Date date) {
        this.u = date;
    }

    public void p0(List list) {
        this.y = list;
    }

    public void q0(String str) {
        this.q = str;
    }

    public void r0(Map map) {
        this.z = map;
    }

    public void s0(List list) {
        this.w = list;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("type").h(this.q);
        interfaceC3123h1.f("replay_type").l(iLogger, this.r);
        interfaceC3123h1.f("segment_id").b(this.t);
        interfaceC3123h1.f("timestamp").l(iLogger, this.u);
        if (this.s != null) {
            interfaceC3123h1.f("replay_id").l(iLogger, this.s);
        }
        if (this.v != null) {
            interfaceC3123h1.f("replay_start_timestamp").l(iLogger, this.v);
        }
        if (this.w != null) {
            interfaceC3123h1.f("urls").l(iLogger, this.w);
        }
        if (this.x != null) {
            interfaceC3123h1.f("error_ids").l(iLogger, this.x);
        }
        if (this.y != null) {
            interfaceC3123h1.f("trace_ids").l(iLogger, this.y);
        }
        new AbstractC3099c2.b().a(this, interfaceC3123h1, iLogger);
        Map map = this.z;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.z.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public void t0(File file) {
        this.p = file;
    }
}
