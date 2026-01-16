package io.sentry;

import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import io.sentry.C3191t1;
import io.sentry.profilemeasurements.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.s1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3186s1 implements A0 {
    private final Map A;
    private String B;
    private Map D;
    private final File a;
    private final Callable b;
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private boolean j;
    private String k;
    private List l;
    private String m;
    private String n;
    private String o;
    private List p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private Date z;

    /* renamed from: io.sentry.s1$b */
    public static final class b implements InterfaceC3176q0 {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C3186s1 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            C3186s1 c3186s1 = new C3186s1();
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "device_manufacturer":
                        String strG1 = interfaceC3118g1.g1();
                        if (strG1 == null) {
                            break;
                        } else {
                            c3186s1.e = strG1;
                            break;
                        }
                    case "android_api_level":
                        Integer numY0 = interfaceC3118g1.Y0();
                        if (numY0 == null) {
                            break;
                        } else {
                            c3186s1.c = numY0.intValue();
                            break;
                        }
                    case "build_id":
                        String strG12 = interfaceC3118g1.g1();
                        if (strG12 == null) {
                            break;
                        } else {
                            c3186s1.o = strG12;
                            break;
                        }
                    case "device_locale":
                        String strG13 = interfaceC3118g1.g1();
                        if (strG13 == null) {
                            break;
                        } else {
                            c3186s1.d = strG13;
                            break;
                        }
                    case "profile_id":
                        String strG14 = interfaceC3118g1.g1();
                        if (strG14 == null) {
                            break;
                        } else {
                            c3186s1.w = strG14;
                            break;
                        }
                    case "device_os_build_number":
                        String strG15 = interfaceC3118g1.g1();
                        if (strG15 == null) {
                            break;
                        } else {
                            c3186s1.g = strG15;
                            break;
                        }
                    case "device_model":
                        String strG16 = interfaceC3118g1.g1();
                        if (strG16 == null) {
                            break;
                        } else {
                            c3186s1.f = strG16;
                            break;
                        }
                    case "device_is_emulator":
                        Boolean boolV0 = interfaceC3118g1.v0();
                        if (boolV0 == null) {
                            break;
                        } else {
                            c3186s1.j = boolV0.booleanValue();
                            break;
                        }
                    case "duration_ns":
                        String strG17 = interfaceC3118g1.g1();
                        if (strG17 == null) {
                            break;
                        } else {
                            c3186s1.r = strG17;
                            break;
                        }
                    case "measurements":
                        Map mapI1 = interfaceC3118g1.i1(iLogger, new a.C0248a());
                        if (mapI1 == null) {
                            break;
                        } else {
                            c3186s1.A.putAll(mapI1);
                            break;
                        }
                    case "device_physical_memory_bytes":
                        String strG18 = interfaceC3118g1.g1();
                        if (strG18 == null) {
                            break;
                        } else {
                            c3186s1.m = strG18;
                            break;
                        }
                    case "device_cpu_frequencies":
                        List list = (List) interfaceC3118g1.H1();
                        if (list == null) {
                            break;
                        } else {
                            c3186s1.l = list;
                            break;
                        }
                    case "version_code":
                        String strG19 = interfaceC3118g1.g1();
                        if (strG19 == null) {
                            break;
                        } else {
                            c3186s1.s = strG19;
                            break;
                        }
                    case "version_name":
                        String strG110 = interfaceC3118g1.g1();
                        if (strG110 == null) {
                            break;
                        } else {
                            c3186s1.t = strG110;
                            break;
                        }
                    case "environment":
                        String strG111 = interfaceC3118g1.g1();
                        if (strG111 == null) {
                            break;
                        } else {
                            c3186s1.x = strG111;
                            break;
                        }
                    case "timestamp":
                        Date dateQ0 = interfaceC3118g1.q0(iLogger);
                        if (dateQ0 == null) {
                            break;
                        } else {
                            c3186s1.z = dateQ0;
                            break;
                        }
                    case "transaction_name":
                        String strG112 = interfaceC3118g1.g1();
                        if (strG112 == null) {
                            break;
                        } else {
                            c3186s1.q = strG112;
                            break;
                        }
                    case "device_os_name":
                        String strG113 = interfaceC3118g1.g1();
                        if (strG113 == null) {
                            break;
                        } else {
                            c3186s1.h = strG113;
                            break;
                        }
                    case "architecture":
                        String strG114 = interfaceC3118g1.g1();
                        if (strG114 == null) {
                            break;
                        } else {
                            c3186s1.k = strG114;
                            break;
                        }
                    case "transaction_id":
                        String strG115 = interfaceC3118g1.g1();
                        if (strG115 == null) {
                            break;
                        } else {
                            c3186s1.u = strG115;
                            break;
                        }
                    case "device_os_version":
                        String strG116 = interfaceC3118g1.g1();
                        if (strG116 == null) {
                            break;
                        } else {
                            c3186s1.i = strG116;
                            break;
                        }
                    case "truncation_reason":
                        String strG117 = interfaceC3118g1.g1();
                        if (strG117 == null) {
                            break;
                        } else {
                            c3186s1.y = strG117;
                            break;
                        }
                    case "trace_id":
                        String strG118 = interfaceC3118g1.g1();
                        if (strG118 == null) {
                            break;
                        } else {
                            c3186s1.v = strG118;
                            break;
                        }
                    case "platform":
                        String strG119 = interfaceC3118g1.g1();
                        if (strG119 == null) {
                            break;
                        } else {
                            c3186s1.n = strG119;
                            break;
                        }
                    case "sampled_profile":
                        String strG120 = interfaceC3118g1.g1();
                        if (strG120 == null) {
                            break;
                        } else {
                            c3186s1.B = strG120;
                            break;
                        }
                    case "transactions":
                        List listQ1 = interfaceC3118g1.Q1(iLogger, new C3191t1.a());
                        if (listQ1 == null) {
                            break;
                        } else {
                            c3186s1.p.addAll(listQ1);
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
            c3186s1.H(concurrentHashMap);
            interfaceC3118g1.F();
            return c3186s1;
        }
    }

    private boolean D() {
        return this.y.equals("normal") || this.y.equals("timeout") || this.y.equals("backgrounded");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List E() {
        return new ArrayList();
    }

    public String B() {
        return this.w;
    }

    public File C() {
        return this.a;
    }

    public void F() {
        try {
            this.l = (List) this.b.call();
        } catch (Throwable unused) {
        }
    }

    public void G(String str) {
        this.B = str;
    }

    public void H(Map map) {
        this.D = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("android_api_level").l(iLogger, Integer.valueOf(this.c));
        interfaceC3123h1.f("device_locale").l(iLogger, this.d);
        interfaceC3123h1.f("device_manufacturer").h(this.e);
        interfaceC3123h1.f("device_model").h(this.f);
        interfaceC3123h1.f("device_os_build_number").h(this.g);
        interfaceC3123h1.f("device_os_name").h(this.h);
        interfaceC3123h1.f("device_os_version").h(this.i);
        interfaceC3123h1.f("device_is_emulator").d(this.j);
        interfaceC3123h1.f("architecture").l(iLogger, this.k);
        interfaceC3123h1.f("device_cpu_frequencies").l(iLogger, this.l);
        interfaceC3123h1.f("device_physical_memory_bytes").h(this.m);
        interfaceC3123h1.f("platform").h(this.n);
        interfaceC3123h1.f("build_id").h(this.o);
        interfaceC3123h1.f("transaction_name").h(this.q);
        interfaceC3123h1.f("duration_ns").h(this.r);
        interfaceC3123h1.f("version_name").h(this.t);
        interfaceC3123h1.f("version_code").h(this.s);
        if (!this.p.isEmpty()) {
            interfaceC3123h1.f("transactions").l(iLogger, this.p);
        }
        interfaceC3123h1.f("transaction_id").h(this.u);
        interfaceC3123h1.f("trace_id").h(this.v);
        interfaceC3123h1.f("profile_id").h(this.w);
        interfaceC3123h1.f("environment").h(this.x);
        interfaceC3123h1.f("truncation_reason").h(this.y);
        if (this.B != null) {
            interfaceC3123h1.f("sampled_profile").h(this.B);
        }
        String strA = interfaceC3123h1.a();
        interfaceC3123h1.j("");
        interfaceC3123h1.f("measurements").l(iLogger, this.A);
        interfaceC3123h1.j(strA);
        interfaceC3123h1.f("timestamp").l(iLogger, this.z);
        Map map = this.D;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.D.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    private C3186s1() {
        this(new File("dummy"), C3098c1.e());
    }

    public C3186s1(File file, InterfaceC3127i0 interfaceC3127i0) {
        this(file, AbstractC3141l.d(), new ArrayList(), interfaceC3127i0.getName(), interfaceC3127i0.b().toString(), interfaceC3127i0.v().n().toString(), "0", 0, "", new Callable() { // from class: io.sentry.r1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C3186s1.E();
            }
        }, null, null, null, null, null, null, null, null, "normal", new HashMap());
    }

    public C3186s1(File file, Date date, List list, String str, String str2, String str3, String str4, int i, String str5, Callable callable, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, String str13, Map map) {
        this.l = new ArrayList();
        this.B = null;
        this.a = file;
        this.z = date;
        this.k = str5;
        this.b = callable;
        this.c = i;
        this.d = Locale.getDefault().toString();
        this.e = str6 != null ? str6 : "";
        this.f = str7 != null ? str7 : "";
        this.i = str8 != null ? str8 : "";
        this.j = bool != null ? bool.booleanValue() : false;
        this.m = str9 != null ? str9 : "0";
        this.g = "";
        this.h = ConstantDeviceInfo.APP_PLATFORM;
        this.n = ConstantDeviceInfo.APP_PLATFORM;
        this.o = str10 != null ? str10 : "";
        this.p = list;
        this.q = str.isEmpty() ? CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE : str;
        this.r = str4;
        this.s = "";
        this.t = str11 != null ? str11 : "";
        this.u = str2;
        this.v = str3;
        this.w = A3.a();
        this.x = str12 != null ? str12 : "production";
        this.y = str13;
        if (!D()) {
            this.y = "normal";
        }
        this.A = map;
    }
}
