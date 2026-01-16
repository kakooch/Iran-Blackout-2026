package io.sentry.rrweb;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import io.sentry.rrweb.b;
import io.sentry.util.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public final class j extends b implements A0 {
    private String c;
    private int d;
    private long e;
    private long f;
    private String g;
    private String h;
    private int i;
    private int j;
    private int k;
    private String l;
    private int m;
    private int n;
    private int o;
    private Map p;
    private Map q;
    private Map r;

    public static final class a implements InterfaceC3176q0 {
        private void c(j jVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("payload")) {
                    d(jVar, interfaceC3118g1, iLogger);
                } else if (strN0.equals(ParameterNames.TAG)) {
                    String strG1 = interfaceC3118g1.g1();
                    if (strG1 == null) {
                        strG1 = "";
                    }
                    jVar.c = strG1;
                } else {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                }
            }
            jVar.v(concurrentHashMap);
            interfaceC3118g1.F();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private void d(j jVar, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                char c = 65535;
                switch (strN0.hashCode()) {
                    case -1992012396:
                        if (strN0.equals("duration")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1627805778:
                        if (strN0.equals("segmentId")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1221029593:
                        if (strN0.equals("height")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -410956671:
                        if (strN0.equals("container")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -296512606:
                        if (strN0.equals("frameCount")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 115029:
                        if (strN0.equals("top")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3317767:
                        if (strN0.equals("left")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 3530753:
                        if (strN0.equals("size")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 113126854:
                        if (strN0.equals("width")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 545057773:
                        if (strN0.equals("frameRate")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 1711222099:
                        if (strN0.equals("encoding")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 2135109831:
                        if (strN0.equals("frameRateType")) {
                            c = 11;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        jVar.f = interfaceC3118g1.K1();
                        break;
                    case 1:
                        jVar.d = interfaceC3118g1.r0();
                        break;
                    case 2:
                        Integer numY0 = interfaceC3118g1.Y0();
                        jVar.i = numY0 != null ? numY0.intValue() : 0;
                        break;
                    case 3:
                        String strG1 = interfaceC3118g1.g1();
                        jVar.h = strG1 != null ? strG1 : "";
                        break;
                    case 4:
                        Integer numY02 = interfaceC3118g1.Y0();
                        jVar.k = numY02 != null ? numY02.intValue() : 0;
                        break;
                    case 5:
                        Integer numY03 = interfaceC3118g1.Y0();
                        jVar.o = numY03 != null ? numY03.intValue() : 0;
                        break;
                    case 6:
                        Integer numY04 = interfaceC3118g1.Y0();
                        jVar.n = numY04 != null ? numY04.intValue() : 0;
                        break;
                    case 7:
                        Long lA1 = interfaceC3118g1.a1();
                        jVar.e = lA1 == null ? 0L : lA1.longValue();
                        break;
                    case '\b':
                        Integer numY05 = interfaceC3118g1.Y0();
                        jVar.j = numY05 != null ? numY05.intValue() : 0;
                        break;
                    case '\t':
                        Integer numY06 = interfaceC3118g1.Y0();
                        jVar.m = numY06 != null ? numY06.intValue() : 0;
                        break;
                    case '\n':
                        String strG12 = interfaceC3118g1.g1();
                        jVar.g = strG12 != null ? strG12 : "";
                        break;
                    case 11:
                        String strG13 = interfaceC3118g1.g1();
                        jVar.l = strG13 != null ? strG13 : "";
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            jVar.B(concurrentHashMap);
            interfaceC3118g1.F();
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            interfaceC3118g1.B();
            j jVar = new j();
            b.a aVar = new b.a();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                if (strN0.equals("data")) {
                    c(jVar, interfaceC3118g1, iLogger);
                } else if (!aVar.a(jVar, strN0, interfaceC3118g1, iLogger)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    interfaceC3118g1.j1(iLogger, map, strN0);
                }
            }
            jVar.F(map);
            interfaceC3118g1.F();
            return jVar;
        }
    }

    public j() {
        super(c.Custom);
        this.g = "h264";
        this.h = "mp4";
        this.l = "constant";
        this.c = MediaStreamTrack.VIDEO_TRACK_KIND;
    }

    private void t(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f(ParameterNames.TAG).h(this.c);
        interfaceC3123h1.f("payload");
        u(interfaceC3123h1, iLogger);
        Map map = this.r;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.r.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    private void u(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("segmentId").b(this.d);
        interfaceC3123h1.f("size").b(this.e);
        interfaceC3123h1.f("duration").b(this.f);
        interfaceC3123h1.f("encoding").h(this.g);
        interfaceC3123h1.f("container").h(this.h);
        interfaceC3123h1.f("height").b(this.i);
        interfaceC3123h1.f("width").b(this.j);
        interfaceC3123h1.f("frameCount").b(this.k);
        interfaceC3123h1.f("frameRate").b(this.m);
        interfaceC3123h1.f("frameRateType").h(this.l);
        interfaceC3123h1.f("left").b(this.n);
        interfaceC3123h1.f("top").b(this.o);
        Map map = this.q;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.q.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public void A(int i) {
        this.n = i;
    }

    public void B(Map map) {
        this.q = map;
    }

    public void C(int i) {
        this.d = i;
    }

    public void D(long j) {
        this.e = j;
    }

    public void E(int i) {
        this.o = i;
    }

    public void F(Map map) {
        this.p = map;
    }

    public void G(int i) {
        this.j = i;
    }

    @Override // io.sentry.rrweb.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        j jVar = (j) obj;
        return this.d == jVar.d && this.e == jVar.e && this.f == jVar.f && this.i == jVar.i && this.j == jVar.j && this.k == jVar.k && this.m == jVar.m && this.n == jVar.n && this.o == jVar.o && u.a(this.c, jVar.c) && u.a(this.g, jVar.g) && u.a(this.h, jVar.h) && u.a(this.l, jVar.l);
    }

    @Override // io.sentry.rrweb.b
    public int hashCode() {
        return u.b(Integer.valueOf(super.hashCode()), this.c, Integer.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f), this.g, this.h, Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k), this.l, Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new b.C0251b().a(this, interfaceC3123h1, iLogger);
        interfaceC3123h1.f("data");
        t(interfaceC3123h1, iLogger);
        Map map = this.p;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.p.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public void v(Map map) {
        this.r = map;
    }

    public void w(long j) {
        this.f = j;
    }

    public void x(int i) {
        this.k = i;
    }

    public void y(int i) {
        this.m = i;
    }

    public void z(int i) {
        this.i = i;
    }
}
