package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class o implements A0 {
    private String a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Map e;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public o a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            o oVar = new o();
            interfaceC3118g1.B();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "sdk_name":
                        oVar.a = interfaceC3118g1.g1();
                        break;
                    case "version_patchlevel":
                        oVar.d = interfaceC3118g1.Y0();
                        break;
                    case "version_major":
                        oVar.b = interfaceC3118g1.Y0();
                        break;
                    case "version_minor":
                        oVar.c = interfaceC3118g1.Y0();
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
            oVar.e(map);
            return oVar;
        }
    }

    public void e(Map map) {
        this.e = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("sdk_name").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("version_major").k(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("version_minor").k(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("version_patchlevel").k(this.d);
        }
        Map map = this.e;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.e.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
