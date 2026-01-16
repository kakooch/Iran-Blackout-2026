package io.sentry.clientreport;

import android.gov.nist.core.Separators;
import io.sentry.A0;
import io.sentry.AbstractC3141l;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Y2;
import io.sentry.clientreport.g;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class c implements A0 {
    private final Date a;
    private final List b;
    private Map c;

    public static final class a implements InterfaceC3176q0 {
        private Exception c(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + Separators.DOUBLE_QUOTE;
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.b(Y2.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) throws Exception {
            ArrayList arrayList = new ArrayList();
            interfaceC3118g1.B();
            Date dateQ0 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("discarded_events")) {
                    arrayList.addAll(interfaceC3118g1.Q1(iLogger, new g.a()));
                } else if (strN0.equals("timestamp")) {
                    dateQ0 = interfaceC3118g1.q0(iLogger);
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            interfaceC3118g1.F();
            if (dateQ0 == null) {
                throw c("timestamp", iLogger);
            }
            if (arrayList.isEmpty()) {
                throw c("discarded_events", iLogger);
            }
            c cVar = new c(dateQ0, arrayList);
            cVar.b(map);
            return cVar;
        }
    }

    public c(Date date, List list) {
        this.a = date;
        this.b = list;
    }

    public List a() {
        return this.b;
    }

    public void b(Map map) {
        this.c = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("timestamp").h(AbstractC3141l.h(this.a));
        interfaceC3123h1.f("discarded_events").l(iLogger, this.b);
        Map map = this.c;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.c.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
