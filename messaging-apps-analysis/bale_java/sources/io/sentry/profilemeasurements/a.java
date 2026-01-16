package io.sentry.profilemeasurements;

import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.profilemeasurements.b;
import io.sentry.util.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class a implements A0 {
    private Map a;
    private String b;
    private Collection c;

    /* renamed from: io.sentry.profilemeasurements.a$a, reason: collision with other inner class name */
    public static final class C0248a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            a aVar = new a();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("values")) {
                    List listQ1 = interfaceC3118g1.Q1(iLogger, new b.a());
                    if (listQ1 != null) {
                        aVar.c = listQ1;
                    }
                } else if (strN0.equals("unit")) {
                    String strG1 = interfaceC3118g1.g1();
                    if (strG1 != null) {
                        aVar.b = strG1;
                    }
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                }
            }
            aVar.c(concurrentHashMap);
            interfaceC3118g1.F();
            return aVar;
        }
    }

    public a() {
        this(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE, new ArrayList());
    }

    public void c(Map map) {
        this.a = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return u.a(this.a, aVar.a) && this.b.equals(aVar.b) && new ArrayList(this.c).equals(new ArrayList(aVar.c));
    }

    public int hashCode() {
        return u.b(this.a, this.b, this.c);
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("unit").l(iLogger, this.b);
        interfaceC3123h1.f("values").l(iLogger, this.c);
        Map map = this.a;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.a.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public a(String str, Collection collection) {
        this.b = str;
        this.c = collection;
    }
}
