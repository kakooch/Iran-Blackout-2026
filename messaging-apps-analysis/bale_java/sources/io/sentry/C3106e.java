package io.sentry;

import io.sentry.Y2;
import io.sentry.util.AbstractC3204c;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3106e implements A0, Comparable {
    private final Long a;
    private Date b;
    private final Long c;
    private String d;
    private String e;
    private Map f;
    private String g;
    private String h;
    private Y2 i;
    private Map j;

    /* renamed from: io.sentry.e$a */
    public static final class a implements InterfaceC3176q0 {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.util.Map] */
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3106e a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            Date dateD = AbstractC3141l.d();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            String strG1 = null;
            String strG12 = null;
            String strG13 = null;
            String strG14 = null;
            Y2 y2A = null;
            ConcurrentHashMap concurrentHashMap2 = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "origin":
                        strG14 = interfaceC3118g1.g1();
                        break;
                    case "data":
                        ?? B = AbstractC3204c.b((Map) interfaceC3118g1.H1());
                        if (B == 0) {
                            break;
                        } else {
                            concurrentHashMap = B;
                            break;
                        }
                    case "type":
                        strG12 = interfaceC3118g1.g1();
                        break;
                    case "category":
                        strG13 = interfaceC3118g1.g1();
                        break;
                    case "timestamp":
                        Date dateQ0 = interfaceC3118g1.q0(iLogger);
                        if (dateQ0 == null) {
                            break;
                        } else {
                            dateD = dateQ0;
                            break;
                        }
                    case "level":
                        try {
                            y2A = new Y2.a().a(interfaceC3118g1, iLogger);
                            break;
                        } catch (Exception e) {
                            iLogger.a(Y2.ERROR, e, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                    case "message":
                        strG1 = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap2 == null) {
                            concurrentHashMap2 = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap2, strN0);
                        break;
                }
            }
            C3106e c3106e = new C3106e(dateD);
            c3106e.d = strG1;
            c3106e.e = strG12;
            c3106e.f = concurrentHashMap;
            c3106e.g = strG13;
            c3106e.h = strG14;
            c3106e.i = y2A;
            c3106e.D(concurrentHashMap2);
            interfaceC3118g1.F();
            return c3106e;
        }
    }

    public C3106e(Date date) {
        this.f = new ConcurrentHashMap();
        this.c = Long.valueOf(System.nanoTime());
        this.b = date;
        this.a = null;
    }

    public static C3106e E(String str, String str2, String str3, String str4, Map map) {
        C3106e c3106e = new C3106e();
        c3106e.C("user");
        c3106e.y("ui." + str);
        if (str2 != null) {
            c3106e.z("view.id", str2);
        }
        if (str3 != null) {
            c3106e.z("view.class", str3);
        }
        if (str4 != null) {
            c3106e.z("view.tag", str4);
        }
        for (Map.Entry entry : map.entrySet()) {
            c3106e.s().put((String) entry.getKey(), entry.getValue());
        }
        c3106e.A(Y2.INFO);
        return c3106e;
    }

    public void A(Y2 y2) {
        this.i = y2;
    }

    public void B(String str) {
        this.d = str;
    }

    public void C(String str) {
        this.e = str;
    }

    public void D(Map map) {
        this.j = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3106e.class != obj.getClass()) {
            return false;
        }
        C3106e c3106e = (C3106e) obj;
        return v().getTime() == c3106e.v().getTime() && io.sentry.util.u.a(this.d, c3106e.d) && io.sentry.util.u.a(this.e, c3106e.e) && io.sentry.util.u.a(this.g, c3106e.g) && io.sentry.util.u.a(this.h, c3106e.h) && this.i == c3106e.i;
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.b, this.d, this.e, this.g, this.h, this.i);
    }

    @Override // java.lang.Comparable
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int compareTo(C3106e c3106e) {
        return this.c.compareTo(c3106e.c);
    }

    public String r() {
        return this.g;
    }

    public Map s() {
        return this.f;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("timestamp").l(iLogger, v());
        if (this.d != null) {
            interfaceC3123h1.f(DialogEntity.COLUMN_MESSAGE).h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("type").h(this.e);
        }
        interfaceC3123h1.f("data").l(iLogger, this.f);
        if (this.g != null) {
            interfaceC3123h1.f(SearchSuggestion.CATEGORY_ICON).h(this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("origin").h(this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("level").l(iLogger, this.i);
        }
        Map map = this.j;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.j.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public Y2 t() {
        return this.i;
    }

    public String u() {
        return this.d;
    }

    public Date v() {
        Date date = this.b;
        if (date != null) {
            return (Date) date.clone();
        }
        Long l = this.a;
        if (l == null) {
            throw new IllegalStateException("No timestamp set for breadcrumb");
        }
        Date dateE = AbstractC3141l.e(l.longValue());
        this.b = dateE;
        return dateE;
    }

    public String w() {
        return this.e;
    }

    public void x(String str) {
        if (str == null) {
            return;
        }
        this.f.remove(str);
    }

    public void y(String str) {
        this.g = str;
    }

    public void z(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            x(str);
        } else {
            this.f.put(str, obj);
        }
    }

    public C3106e(long j) {
        this.f = new ConcurrentHashMap();
        this.c = Long.valueOf(System.nanoTime());
        this.a = Long.valueOf(j);
        this.b = null;
    }

    C3106e(C3106e c3106e) {
        this.f = new ConcurrentHashMap();
        this.c = Long.valueOf(System.nanoTime());
        this.b = c3106e.b;
        this.a = c3106e.a;
        this.d = c3106e.d;
        this.e = c3106e.e;
        this.g = c3106e.g;
        this.h = c3106e.h;
        Map mapB = AbstractC3204c.b(c3106e.f);
        if (mapB != null) {
            this.f = mapB;
        }
        this.j = AbstractC3204c.b(c3106e.j);
        this.i = c3106e.i;
    }

    public C3106e() {
        this(System.currentTimeMillis());
    }
}
