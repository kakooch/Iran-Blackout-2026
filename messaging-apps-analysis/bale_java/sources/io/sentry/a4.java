package io.sentry;

import io.sentry.protocol.v;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a4 implements A0 {
    private final io.sentry.protocol.v a;
    private String b;
    private String c;
    private String d;
    private Map e;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a4 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            io.sentry.protocol.v vVarA = null;
            String strG1 = null;
            String strG12 = null;
            String strG13 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "comments":
                        strG13 = interfaceC3118g1.g1();
                        break;
                    case "name":
                        strG1 = interfaceC3118g1.g1();
                        break;
                    case "email":
                        strG12 = interfaceC3118g1.g1();
                        break;
                    case "event_id":
                        vVarA = new v.a().a(interfaceC3118g1, iLogger);
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
            if (vVarA != null) {
                a4 a4Var = new a4(vVarA, strG1, strG12, strG13);
                a4Var.a(map);
                return a4Var;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"event_id\"");
            iLogger.b(Y2.ERROR, "Missing required field \"event_id\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public a4(io.sentry.protocol.v vVar, String str, String str2, String str3) {
        this.a = vVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public void a(Map map) {
        this.e = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("event_id");
        this.a.serialize(interfaceC3123h1, iLogger);
        if (this.b != null) {
            interfaceC3123h1.f("name").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("email").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("comments").h(this.d);
        }
        Map map = this.e;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.e.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public String toString() {
        return "UserFeedback{eventId=" + this.a + ", name='" + this.b + "', email='" + this.c + "', comments='" + this.d + "'}";
    }
}
