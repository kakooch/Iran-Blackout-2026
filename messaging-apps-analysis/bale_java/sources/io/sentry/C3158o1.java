package io.sentry;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import io.sentry.profilemeasurements.a;
import io.sentry.protocol.C3169d;
import io.sentry.protocol.p;
import io.sentry.protocol.v;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.o1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3158o1 implements A0 {
    private C3169d a;
    private io.sentry.protocol.v b;
    private io.sentry.protocol.v c;
    private io.sentry.protocol.p d;
    private final Map e;
    private String f;
    private String g;
    private String h;
    private String i;
    private double j;
    private final File k;
    private String l;
    private Map m;

    /* renamed from: io.sentry.o1$a */
    public static final class a {
        private final io.sentry.protocol.v a;
        private final io.sentry.protocol.v b;
        private final Map c;
        private final File d;
        private final double e;

        public a(io.sentry.protocol.v vVar, io.sentry.protocol.v vVar2, Map map, File file, AbstractC3124h2 abstractC3124h2) {
            this.a = vVar;
            this.b = vVar2;
            this.c = new ConcurrentHashMap(map);
            this.d = file;
            this.e = AbstractC3141l.m(abstractC3124h2.p());
        }

        public C3158o1 a(C3155n3 c3155n3) {
            return new C3158o1(this.a, this.b, this.d, this.c, Double.valueOf(this.e), c3155n3);
        }
    }

    /* renamed from: io.sentry.o1$b */
    public static final class b implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3158o1 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            C3158o1 c3158o1 = new C3158o1();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "debug_meta":
                        C3169d c3169d = (C3169d) interfaceC3118g1.E0(iLogger, new C3169d.a());
                        if (c3169d == null) {
                            break;
                        } else {
                            c3158o1.a = c3169d;
                            break;
                        }
                    case "measurements":
                        Map mapI1 = interfaceC3118g1.i1(iLogger, new a.C0248a());
                        if (mapI1 == null) {
                            break;
                        } else {
                            c3158o1.e.putAll(mapI1);
                            break;
                        }
                    case "environment":
                        String strG1 = interfaceC3118g1.g1();
                        if (strG1 == null) {
                            break;
                        } else {
                            c3158o1.h = strG1;
                            break;
                        }
                    case "timestamp":
                        Double dL0 = interfaceC3118g1.l0();
                        if (dL0 == null) {
                            break;
                        } else {
                            c3158o1.j = dL0.doubleValue();
                            break;
                        }
                    case "profiler_id":
                        io.sentry.protocol.v vVar = (io.sentry.protocol.v) interfaceC3118g1.E0(iLogger, new v.a());
                        if (vVar == null) {
                            break;
                        } else {
                            c3158o1.b = vVar;
                            break;
                        }
                    case "version":
                        String strG12 = interfaceC3118g1.g1();
                        if (strG12 == null) {
                            break;
                        } else {
                            c3158o1.i = strG12;
                            break;
                        }
                    case "release":
                        String strG13 = interfaceC3118g1.g1();
                        if (strG13 == null) {
                            break;
                        } else {
                            c3158o1.g = strG13;
                            break;
                        }
                    case "client_sdk":
                        io.sentry.protocol.p pVar = (io.sentry.protocol.p) interfaceC3118g1.E0(iLogger, new p.a());
                        if (pVar == null) {
                            break;
                        } else {
                            c3158o1.d = pVar;
                            break;
                        }
                    case "platform":
                        String strG14 = interfaceC3118g1.g1();
                        if (strG14 == null) {
                            break;
                        } else {
                            c3158o1.f = strG14;
                            break;
                        }
                    case "sampled_profile":
                        String strG15 = interfaceC3118g1.g1();
                        if (strG15 == null) {
                            break;
                        } else {
                            c3158o1.l = strG15;
                            break;
                        }
                    case "chunk_id":
                        io.sentry.protocol.v vVar2 = (io.sentry.protocol.v) interfaceC3118g1.E0(iLogger, new v.a());
                        if (vVar2 == null) {
                            break;
                        } else {
                            c3158o1.c = vVar2;
                            break;
                        }
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
            }
            c3158o1.r(concurrentHashMap);
            interfaceC3118g1.F();
            return c3158o1;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C3158o1() {
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        this(vVar, vVar, new File("dummy"), new HashMap(), Double.valueOf(0.0d), C3155n3.empty());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3158o1)) {
            return false;
        }
        C3158o1 c3158o1 = (C3158o1) obj;
        return Objects.equals(this.a, c3158o1.a) && Objects.equals(this.b, c3158o1.b) && Objects.equals(this.c, c3158o1.c) && Objects.equals(this.d, c3158o1.d) && Objects.equals(this.e, c3158o1.e) && Objects.equals(this.f, c3158o1.f) && Objects.equals(this.g, c3158o1.g) && Objects.equals(this.h, c3158o1.h) && Objects.equals(this.i, c3158o1.i) && Objects.equals(this.l, c3158o1.l) && Objects.equals(this.m, c3158o1.m);
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.l, this.m);
    }

    public io.sentry.protocol.v l() {
        return this.c;
    }

    public C3169d m() {
        return this.a;
    }

    public String n() {
        return this.f;
    }

    public File o() {
        return this.k;
    }

    public void p(C3169d c3169d) {
        this.a = c3169d;
    }

    public void q(String str) {
        this.l = str;
    }

    public void r(Map map) {
        this.m = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("debug_meta").l(iLogger, this.a);
        }
        interfaceC3123h1.f("profiler_id").l(iLogger, this.b);
        interfaceC3123h1.f("chunk_id").l(iLogger, this.c);
        if (this.d != null) {
            interfaceC3123h1.f("client_sdk").l(iLogger, this.d);
        }
        if (!this.e.isEmpty()) {
            String strA = interfaceC3123h1.a();
            interfaceC3123h1.j("");
            interfaceC3123h1.f("measurements").l(iLogger, this.e);
            interfaceC3123h1.j(strA);
        }
        interfaceC3123h1.f("platform").l(iLogger, this.f);
        interfaceC3123h1.f("release").l(iLogger, this.g);
        if (this.h != null) {
            interfaceC3123h1.f("environment").l(iLogger, this.h);
        }
        interfaceC3123h1.f(ParameterNames.VERSION).l(iLogger, this.i);
        if (this.l != null) {
            interfaceC3123h1.f("sampled_profile").l(iLogger, this.l);
        }
        interfaceC3123h1.f("timestamp").l(iLogger, Double.valueOf(this.j));
        Map map = this.m;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.m.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public C3158o1(io.sentry.protocol.v vVar, io.sentry.protocol.v vVar2, File file, Map map, Double d, C3155n3 c3155n3) {
        this.l = null;
        this.b = vVar;
        this.c = vVar2;
        this.k = file;
        this.e = map;
        this.a = null;
        this.d = c3155n3.getSdkVersion();
        this.g = c3155n3.getRelease() != null ? c3155n3.getRelease() : "";
        this.h = c3155n3.getEnvironment();
        this.f = ConstantDeviceInfo.APP_PLATFORM;
        this.i = "2";
        this.j = d.doubleValue();
    }
}
