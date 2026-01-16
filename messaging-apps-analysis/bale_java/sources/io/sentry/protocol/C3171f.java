package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Y2;
import io.sentry.protocol.v;
import io.sentry.util.AbstractC3204c;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.sentry.protocol.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3171f implements A0 {
    private String a;
    private String b;
    private String c;
    private v d;
    private v e;
    private String f;
    private Map g;

    /* renamed from: io.sentry.protocol.f$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3171f a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            String strG1 = null;
            String strG12 = null;
            String strG13 = null;
            v vVarA = null;
            v vVarA2 = null;
            String strG14 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "associated_event_id":
                        vVarA = new v.a().a(interfaceC3118g1, iLogger);
                        break;
                    case "replay_id":
                        vVarA2 = new v.a().a(interfaceC3118g1, iLogger);
                        break;
                    case "url":
                        strG14 = interfaceC3118g1.g1();
                        break;
                    case "name":
                        strG13 = interfaceC3118g1.g1();
                        break;
                    case "contact_email":
                        strG12 = interfaceC3118g1.g1();
                        break;
                    case "message":
                        strG1 = interfaceC3118g1.g1();
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
            if (strG1 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"message\"");
                iLogger.b(Y2.ERROR, "Missing required field \"message\"", illegalStateException);
                throw illegalStateException;
            }
            C3171f c3171f = new C3171f(strG1);
            c3171f.b = strG12;
            c3171f.c = strG13;
            c3171f.d = vVarA;
            c3171f.e = vVarA2;
            c3171f.f = strG14;
            c3171f.g = map;
            return c3171f;
        }
    }

    public C3171f(String str) {
        l(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3171f)) {
            return false;
        }
        C3171f c3171f = (C3171f) obj;
        return io.sentry.util.u.a(this.a, c3171f.a) && io.sentry.util.u.a(this.b, c3171f.b) && io.sentry.util.u.a(this.c, c3171f.c) && io.sentry.util.u.a(this.d, c3171f.d) && io.sentry.util.u.a(this.e, c3171f.e) && io.sentry.util.u.a(this.f, c3171f.f) && io.sentry.util.u.a(this.g, c3171f.g);
    }

    public String g() {
        return this.a;
    }

    public v h() {
        return this.e;
    }

    public int hashCode() {
        return io.sentry.util.u.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public String i() {
        return this.f;
    }

    public void j(v vVar) {
        this.d = vVar;
    }

    public void k(String str) {
        this.b = str;
    }

    public void l(String str) {
        if (str.length() > 4096) {
            this.a = str.substring(0, 4096);
        } else {
            this.a = str;
        }
    }

    public void m(String str) {
        this.c = str;
    }

    public void n(v vVar) {
        this.e = vVar;
    }

    public void o(String str) {
        this.f = str;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f(DialogEntity.COLUMN_MESSAGE).h(this.a);
        if (this.b != null) {
            interfaceC3123h1.f("contact_email").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("name").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("associated_event_id");
            this.d.serialize(interfaceC3123h1, iLogger);
        }
        if (this.e != null) {
            interfaceC3123h1.f("replay_id");
            this.e.serialize(interfaceC3123h1, iLogger);
        }
        if (this.f != null) {
            interfaceC3123h1.f("url").h(this.f);
        }
        Map map = this.g;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.g.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public String toString() {
        return "Feedback{message='" + this.a + "', contactEmail='" + this.b + "', name='" + this.c + "', associatedEventId=" + this.d + ", replayId=" + this.e + ", url='" + this.f + "', unknown=" + this.g + '}';
    }

    public C3171f(C3171f c3171f) {
        this.a = c3171f.a;
        this.b = c3171f.b;
        this.c = c3171f.c;
        this.d = c3171f.d;
        this.e = c3171f.e;
        this.f = c3171f.f;
        this.g = AbstractC3204c.b(c3171f.g);
    }
}
