package io.sentry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.a2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3034a2 implements A0 {
    boolean a;
    Double b;
    boolean c;
    Double d;
    String e;
    boolean f;
    boolean g;
    int h;
    boolean i;
    boolean j;
    boolean k;
    EnumC3177q1 l;
    private Map m;

    /* renamed from: io.sentry.a2$a */
    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3034a2 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            C3034a2 c3034a2 = new C3034a2();
            ConcurrentHashMap concurrentHashMap = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "is_enable_app_start_profiling":
                        Boolean boolV0 = interfaceC3118g1.v0();
                        if (boolV0 == null) {
                            break;
                        } else {
                            c3034a2.j = boolV0.booleanValue();
                            break;
                        }
                    case "trace_sampled":
                        Boolean boolV02 = interfaceC3118g1.v0();
                        if (boolV02 == null) {
                            break;
                        } else {
                            c3034a2.c = boolV02.booleanValue();
                            break;
                        }
                    case "profiling_traces_dir_path":
                        String strG1 = interfaceC3118g1.g1();
                        if (strG1 == null) {
                            break;
                        } else {
                            c3034a2.e = strG1;
                            break;
                        }
                    case "is_continuous_profiling_enabled":
                        Boolean boolV03 = interfaceC3118g1.v0();
                        if (boolV03 == null) {
                            break;
                        } else {
                            c3034a2.g = boolV03.booleanValue();
                            break;
                        }
                    case "is_profiling_enabled":
                        Boolean boolV04 = interfaceC3118g1.v0();
                        if (boolV04 == null) {
                            break;
                        } else {
                            c3034a2.f = boolV04.booleanValue();
                            break;
                        }
                    case "is_start_profiler_on_app_start":
                        Boolean boolV05 = interfaceC3118g1.v0();
                        if (boolV05 == null) {
                            break;
                        } else {
                            c3034a2.k = boolV05.booleanValue();
                            break;
                        }
                    case "profile_sampled":
                        Boolean boolV06 = interfaceC3118g1.v0();
                        if (boolV06 == null) {
                            break;
                        } else {
                            c3034a2.a = boolV06.booleanValue();
                            break;
                        }
                    case "profile_lifecycle":
                        String strG12 = interfaceC3118g1.g1();
                        if (strG12 == null) {
                            break;
                        } else {
                            try {
                                c3034a2.l = EnumC3177q1.valueOf(strG12);
                                break;
                            } catch (IllegalArgumentException unused) {
                                iLogger.c(Y2.ERROR, "Error when deserializing ProfileLifecycle: " + strG12, new Object[0]);
                                break;
                            }
                        }
                    case "continuous_profile_sampled":
                        Boolean boolV07 = interfaceC3118g1.v0();
                        if (boolV07 == null) {
                            break;
                        } else {
                            c3034a2.i = boolV07.booleanValue();
                            break;
                        }
                    case "profiling_traces_hz":
                        Integer numY0 = interfaceC3118g1.Y0();
                        if (numY0 == null) {
                            break;
                        } else {
                            c3034a2.h = numY0.intValue();
                            break;
                        }
                    case "trace_sample_rate":
                        Double dL0 = interfaceC3118g1.l0();
                        if (dL0 == null) {
                            break;
                        } else {
                            c3034a2.d = dL0;
                            break;
                        }
                    case "profile_sample_rate":
                        Double dL02 = interfaceC3118g1.l0();
                        if (dL02 == null) {
                            break;
                        } else {
                            c3034a2.b = dL02;
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
            c3034a2.m(concurrentHashMap);
            interfaceC3118g1.F();
            return c3034a2;
        }
    }

    public C3034a2() {
        this.c = false;
        this.d = null;
        this.a = false;
        this.b = null;
        this.i = false;
        this.e = null;
        this.f = false;
        this.g = false;
        this.l = EnumC3177q1.MANUAL;
        this.h = 0;
        this.j = true;
        this.k = false;
    }

    public EnumC3177q1 a() {
        return this.l;
    }

    public Double b() {
        return this.b;
    }

    public String c() {
        return this.e;
    }

    public int d() {
        return this.h;
    }

    public Double e() {
        return this.d;
    }

    public boolean f() {
        return this.i;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.j;
    }

    public boolean i() {
        return this.a;
    }

    public boolean j() {
        return this.f;
    }

    public boolean k() {
        return this.k;
    }

    public boolean l() {
        return this.c;
    }

    public void m(Map map) {
        this.m = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("profile_sampled").l(iLogger, Boolean.valueOf(this.a));
        interfaceC3123h1.f("profile_sample_rate").l(iLogger, this.b);
        interfaceC3123h1.f("continuous_profile_sampled").l(iLogger, Boolean.valueOf(this.i));
        interfaceC3123h1.f("trace_sampled").l(iLogger, Boolean.valueOf(this.c));
        interfaceC3123h1.f("trace_sample_rate").l(iLogger, this.d);
        interfaceC3123h1.f("profiling_traces_dir_path").l(iLogger, this.e);
        interfaceC3123h1.f("is_profiling_enabled").l(iLogger, Boolean.valueOf(this.f));
        interfaceC3123h1.f("is_continuous_profiling_enabled").l(iLogger, Boolean.valueOf(this.g));
        interfaceC3123h1.f("profile_lifecycle").l(iLogger, this.l.name());
        interfaceC3123h1.f("profiling_traces_hz").l(iLogger, Integer.valueOf(this.h));
        interfaceC3123h1.f("is_enable_app_start_profiling").l(iLogger, Boolean.valueOf(this.j));
        interfaceC3123h1.f("is_start_profiler_on_app_start").l(iLogger, Boolean.valueOf(this.k));
        Map map = this.m;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.m.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    C3034a2(C3155n3 c3155n3, V3 v3) {
        this.c = v3.e().booleanValue();
        this.d = v3.d();
        this.a = v3.b().booleanValue();
        this.b = v3.a();
        this.i = c3155n3.getInternalTracesSampler().c(io.sentry.util.z.a().d());
        this.e = c3155n3.getProfilingTracesDirPath();
        this.f = c3155n3.isProfilingEnabled();
        this.g = c3155n3.isContinuousProfilingEnabled();
        this.l = c3155n3.getProfileLifecycle();
        this.h = c3155n3.getProfilingTracesHz();
        this.j = c3155n3.isEnableAppStartProfiling();
        this.k = c3155n3.isStartProfilerOnAppStart();
    }
}
