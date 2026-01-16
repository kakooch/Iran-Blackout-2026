package io.sentry.rrweb;

import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.rrweb.b;
import io.sentry.rrweb.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class e extends d implements A0 {
    private b d;
    private int e;
    private float f;
    private float g;
    private int h;
    private int i;
    private Map j;
    private Map k;

    public static final class a implements InterfaceC3176q0 {
        private void c(e eVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            d.a aVar = new d.a();
            interfaceC3118g1.B();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "x":
                        eVar.f = interfaceC3118g1.e1();
                        break;
                    case "y":
                        eVar.g = interfaceC3118g1.e1();
                        break;
                    case "id":
                        eVar.e = interfaceC3118g1.r0();
                        break;
                    case "type":
                        eVar.d = (b) interfaceC3118g1.E0(iLogger, new b.a());
                        break;
                    case "pointerType":
                        eVar.h = interfaceC3118g1.r0();
                        break;
                    case "pointerId":
                        eVar.i = interfaceC3118g1.r0();
                        break;
                    default:
                        if (!aVar.a(eVar, strN0, interfaceC3118g1, iLogger)) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            interfaceC3118g1.j1(iLogger, map, strN0);
                            break;
                        } else {
                            break;
                        }
                }
            }
            eVar.p(map);
            interfaceC3118g1.F();
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            e eVar = new e();
            b.a aVar = new b.a();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("data")) {
                    c(eVar, interfaceC3118g1, iLogger);
                } else if (!aVar.a(eVar, strN0, interfaceC3118g1, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            eVar.t(map);
            interfaceC3118g1.F();
            return eVar;
        }
    }

    public enum b implements A0 {
        MouseUp,
        MouseDown,
        Click,
        ContextMenu,
        DblClick,
        Focus,
        Blur,
        TouchStart,
        TouchMove_Departed,
        TouchEnd,
        TouchCancel;

        public static final class a implements InterfaceC3176q0 {
            @Override // io.sentry.InterfaceC3176q0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
                return b.values()[interfaceC3118g1.r0()];
            }
        }

        @Override // io.sentry.A0
        public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
            interfaceC3123h1.b(ordinal());
        }
    }

    public e() {
        super(d.b.MouseInteraction);
        this.h = 2;
    }

    private void o(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new d.c().a(this, interfaceC3123h1, iLogger);
        interfaceC3123h1.f("type").l(iLogger, this.d);
        interfaceC3123h1.f("id").b(this.e);
        interfaceC3123h1.f("x").c(this.f);
        interfaceC3123h1.f("y").c(this.g);
        interfaceC3123h1.f("pointerType").b(this.h);
        interfaceC3123h1.f("pointerId").b(this.i);
        Map map = this.k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.k.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public void p(Map map) {
        this.k = map;
    }

    public void q(int i) {
        this.e = i;
    }

    public void r(b bVar) {
        this.d = bVar;
    }

    public void s(int i) {
        this.i = i;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new b.C0251b().a(this, interfaceC3123h1, iLogger);
        interfaceC3123h1.f("data");
        o(interfaceC3123h1, iLogger);
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

    public void t(Map map) {
        this.j = map;
    }

    public void u(float f) {
        this.f = f;
    }

    public void v(float f) {
        this.g = f;
    }
}
