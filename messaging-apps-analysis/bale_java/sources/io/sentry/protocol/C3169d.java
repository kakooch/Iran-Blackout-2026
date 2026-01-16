package io.sentry.protocol;

import io.sentry.A0;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.sentry.protocol.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3169d implements A0 {
    private o a;
    private List b;
    private Map c;

    /* renamed from: io.sentry.protocol.d$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3169d a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            C3169d c3169d = new C3169d();
            interfaceC3118g1.B();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("images")) {
                    c3169d.b = interfaceC3118g1.Q1(iLogger, new DebugImage.a());
                } else if (strN0.equals("sdk_info")) {
                    c3169d.a = (o) interfaceC3118g1.E0(iLogger, new o.a());
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            interfaceC3118g1.F();
            c3169d.f(map);
            return c3169d;
        }
    }

    public static C3169d c(C3169d c3169d, C3155n3 c3155n3) {
        ArrayList arrayList = new ArrayList();
        if (c3155n3.getProguardUuid() != null) {
            DebugImage debugImage = new DebugImage();
            debugImage.setType(DebugImage.PROGUARD);
            debugImage.setUuid(c3155n3.getProguardUuid());
            arrayList.add(debugImage);
        }
        for (String str : c3155n3.getBundleIds()) {
            DebugImage debugImage2 = new DebugImage();
            debugImage2.setType(DebugImage.JVM);
            debugImage2.setDebugId(str);
            arrayList.add(debugImage2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (c3169d == null) {
            c3169d = new C3169d();
        }
        if (c3169d.d() == null) {
            c3169d.e(arrayList);
        } else {
            c3169d.d().addAll(arrayList);
        }
        return c3169d;
    }

    public List d() {
        return this.b;
    }

    public void e(List list) {
        this.b = list != null ? new ArrayList(list) : null;
    }

    public void f(Map map) {
        this.c = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("sdk_info").l(iLogger, this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("images").l(iLogger, this.b);
        }
        Map map = this.c;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.c.get(str));
            }
        }
        interfaceC3123h1.F();
    }
}
