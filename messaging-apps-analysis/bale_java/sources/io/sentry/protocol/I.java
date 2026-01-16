package io.sentry.protocol;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class I implements A0 {
    private String a;
    private String b;
    private String c;
    private String d;
    private Double e;
    private Double f;
    private Double g;
    private Double h;
    private String i;
    private Double j;
    private List k;
    private Map l;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public I a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            I i = new I();
            interfaceC3118g1.B();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "rendering_system":
                        i.a = interfaceC3118g1.g1();
                        break;
                    case "identifier":
                        i.c = interfaceC3118g1.g1();
                        break;
                    case "height":
                        i.f = interfaceC3118g1.l0();
                        break;
                    case "x":
                        i.g = interfaceC3118g1.l0();
                        break;
                    case "y":
                        i.h = interfaceC3118g1.l0();
                        break;
                    case "tag":
                        i.d = interfaceC3118g1.g1();
                        break;
                    case "type":
                        i.b = interfaceC3118g1.g1();
                        break;
                    case "alpha":
                        i.j = interfaceC3118g1.l0();
                        break;
                    case "width":
                        i.e = interfaceC3118g1.l0();
                        break;
                    case "children":
                        i.k = interfaceC3118g1.Q1(iLogger, this);
                        break;
                    case "visibility":
                        i.i = interfaceC3118g1.g1();
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
            i.q(map);
            return i;
        }
    }

    public void l(Double d) {
        this.j = d;
    }

    public void m(List list) {
        this.k = list;
    }

    public void n(Double d) {
        this.f = d;
    }

    public void o(String str) {
        this.c = str;
    }

    public void p(String str) {
        this.b = str;
    }

    public void q(Map map) {
        this.l = map;
    }

    public void r(String str) {
        this.i = str;
    }

    public void s(Double d) {
        this.e = d;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("rendering_system").h(this.a);
        }
        if (this.b != null) {
            interfaceC3123h1.f("type").h(this.b);
        }
        if (this.c != null) {
            interfaceC3123h1.f("identifier").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f(ParameterNames.TAG).h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("width").k(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("height").k(this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("x").k(this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("y").k(this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("visibility").h(this.i);
        }
        if (this.j != null) {
            interfaceC3123h1.f("alpha").k(this.j);
        }
        List list = this.k;
        if (list != null && !list.isEmpty()) {
            interfaceC3123h1.f("children").l(iLogger, this.k);
        }
        Map map = this.l;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.l.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public void t(Double d) {
        this.g = d;
    }

    public void u(Double d) {
        this.h = d;
    }
}
