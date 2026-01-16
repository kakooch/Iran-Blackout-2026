package io.sentry.protocol;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Y2;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class w implements A0 {
    private String a;
    private String b;
    private Map c;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public w a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            String strT0 = null;
            String strT02 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("name")) {
                    strT0 = interfaceC3118g1.T0();
                } else if (strN0.equals(ParameterNames.VERSION)) {
                    strT02 = interfaceC3118g1.T0();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            interfaceC3118g1.F();
            if (strT0 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                iLogger.b(Y2.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strT02 != null) {
                w wVar = new w(strT0, strT02);
                wVar.c(map);
                return wVar;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
            iLogger.b(Y2.ERROR, "Missing required field \"version\"", illegalStateException2);
            throw illegalStateException2;
        }
    }

    public w(String str, String str2) {
        this.a = (String) io.sentry.util.u.c(str, "name is required.");
        this.b = (String) io.sentry.util.u.c(str2, "version is required.");
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void c(Map map) {
        this.c = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w.class != obj.getClass()) {
            return false;
        }
        w wVar = (w) obj;
        return Objects.equals(this.a, wVar.a) && Objects.equals(this.b, wVar.b);
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b);
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("name").h(this.a);
        interfaceC3123h1.f(ParameterNames.VERSION).h(this.b);
        Map map = this.c;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.c.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
