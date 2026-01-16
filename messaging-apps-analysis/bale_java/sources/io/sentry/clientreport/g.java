package io.sentry.clientreport;

import android.gov.nist.core.Separators;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.Y2;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class g implements A0 {
    private final String a;
    private final String b;
    private final Long c;
    private Map d;

    public static final class a implements InterfaceC3176q0 {
        private Exception c(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + Separators.DOUBLE_QUOTE;
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.b(Y2.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) throws Exception {
            String strN0;
            interfaceC3118g1.B();
            String strG1 = null;
            String strG12 = null;
            Long lA1 = null;
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "quantity":
                        lA1 = interfaceC3118g1.a1();
                        break;
                    case "reason":
                        strG1 = interfaceC3118g1.g1();
                        break;
                    case "category":
                        strG12 = interfaceC3118g1.g1();
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
                throw c("reason", iLogger);
            }
            if (strG12 == null) {
                throw c(SearchSuggestion.CATEGORY_ICON, iLogger);
            }
            if (lA1 == null) {
                throw c("quantity", iLogger);
            }
            g gVar = new g(strG1, strG12, lA1);
            gVar.d(map);
            return gVar;
        }
    }

    public g(String str, String str2, Long l) {
        this.a = str;
        this.b = str2;
        this.c = l;
    }

    public String a() {
        return this.b;
    }

    public Long b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public void d(Map map) {
        this.d = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("reason").h(this.a);
        interfaceC3123h1.f(SearchSuggestion.CATEGORY_ICON).h(this.b);
        interfaceC3123h1.f("quantity").k(this.c);
        Map map = this.d;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.d.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public String toString() {
        return "DiscardedEvent{reason='" + this.a + "', category='" + this.b + "', quantity=" + this.c + '}';
    }
}
