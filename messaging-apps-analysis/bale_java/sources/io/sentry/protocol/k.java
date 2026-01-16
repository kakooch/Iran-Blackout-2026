package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class k implements A0 {
    private String a;
    private String b;
    private List c;
    private Map d;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            k kVar = new k();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "params":
                        List list = (List) interfaceC3118g1.H1();
                        if (list == null) {
                            break;
                        } else {
                            kVar.c = list;
                            break;
                        }
                    case "message":
                        kVar.b = interfaceC3118g1.g1();
                        break;
                    case "formatted":
                        kVar.a = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            kVar.g(concurrentHashMap);
            interfaceC3118g1.F();
            return kVar;
        }
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public void f(String str) {
        this.a = str;
    }

    public void g(Map map) {
        this.d = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("formatted").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f(DialogEntity.COLUMN_MESSAGE).h(this.b);
        }
        List list = this.c;
        if (list != null && !list.isEmpty()) {
            interfaceC3123h1.f("params").l(iLogger, this.c);
        }
        Map map = this.d;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.d.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }
}
