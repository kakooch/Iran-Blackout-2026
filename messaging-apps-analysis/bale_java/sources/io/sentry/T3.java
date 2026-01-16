package io.sentry;

import android.gov.nist.core.Separators;
import io.sentry.protocol.v;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class T3 implements A0 {
    private final io.sentry.protocol.v a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final io.sentry.protocol.v j;
    private Map k;

    public static final class a implements InterfaceC3176q0 {
        private Exception c(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + Separators.DOUBLE_QUOTE;
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.b(Y2.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public T3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) throws Exception {
            String strN0;
            interfaceC3118g1.B();
            ConcurrentHashMap concurrentHashMap = null;
            io.sentry.protocol.v vVarA = null;
            String strT0 = null;
            String strG1 = null;
            String strG12 = null;
            String strG13 = null;
            String strG14 = null;
            String strG15 = null;
            String strG16 = null;
            io.sentry.protocol.v vVarA2 = null;
            String strG17 = null;
            while (true) {
                String str = strG17;
                if (interfaceC3118g1.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                    if (vVarA == null) {
                        throw c("trace_id", iLogger);
                    }
                    if (strT0 == null) {
                        throw c("public_key", iLogger);
                    }
                    T3 t3 = new T3(vVarA, strT0, strG1, strG12, strG13, strG14, strG15, strG16, vVarA2, str);
                    t3.c(concurrentHashMap);
                    interfaceC3118g1.F();
                    return t3;
                }
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "replay_id":
                        vVarA2 = new v.a().a(interfaceC3118g1, iLogger);
                        break;
                    case "user_id":
                        strG13 = interfaceC3118g1.g1();
                        break;
                    case "environment":
                        strG12 = interfaceC3118g1.g1();
                        break;
                    case "sample_rand":
                        strG17 = interfaceC3118g1.g1();
                        continue;
                    case "sample_rate":
                        strG15 = interfaceC3118g1.g1();
                        break;
                    case "release":
                        strG1 = interfaceC3118g1.g1();
                        break;
                    case "trace_id":
                        vVarA = new v.a().a(interfaceC3118g1, iLogger);
                        break;
                    case "sampled":
                        strG16 = interfaceC3118g1.g1();
                        break;
                    case "public_key":
                        strT0 = interfaceC3118g1.T0();
                        break;
                    case "transaction":
                        strG14 = interfaceC3118g1.g1();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        interfaceC3118g1.j1(iLogger, concurrentHashMap, strN0);
                        break;
                }
                strG17 = str;
            }
        }
    }

    T3(io.sentry.protocol.v vVar, String str) {
        this(vVar, str, null, null, null, null, null, null, null);
    }

    public String a() {
        return this.h;
    }

    public String b() {
        return this.g;
    }

    public void c(Map map) {
        this.k = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f("trace_id").l(iLogger, this.a);
        interfaceC3123h1.f("public_key").h(this.b);
        if (this.c != null) {
            interfaceC3123h1.f("release").h(this.c);
        }
        if (this.d != null) {
            interfaceC3123h1.f("environment").h(this.d);
        }
        if (this.e != null) {
            interfaceC3123h1.f("user_id").h(this.e);
        }
        if (this.f != null) {
            interfaceC3123h1.f("transaction").h(this.f);
        }
        if (this.g != null) {
            interfaceC3123h1.f("sample_rate").h(this.g);
        }
        if (this.h != null) {
            interfaceC3123h1.f("sample_rand").h(this.h);
        }
        if (this.i != null) {
            interfaceC3123h1.f("sampled").h(this.i);
        }
        if (this.j != null) {
            interfaceC3123h1.f("replay_id").l(iLogger, this.j);
        }
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

    T3(io.sentry.protocol.v vVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, io.sentry.protocol.v vVar2) {
        this(vVar, str, str2, str3, str4, str5, str6, str7, vVar2, null);
    }

    T3(io.sentry.protocol.v vVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, io.sentry.protocol.v vVar2, String str8) {
        this.a = vVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.i = str7;
        this.j = vVar2;
        this.h = str8;
    }
}
