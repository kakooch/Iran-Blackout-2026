package io.sentry;

import android.gov.nist.core.Separators;
import io.sentry.X2;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class K2 implements A0 {
    private final String a;
    private final Integer b;
    private final String c;
    private final String d;
    private final X2 e;
    private final int f;
    private final Callable g;
    private final String h;
    private Map i;

    public static final class a implements InterfaceC3176q0 {
        private Exception c(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + Separators.DOUBLE_QUOTE;
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.b(Y2.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public K2 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) throws Exception {
            String strN0;
            interfaceC3118g1.B();
            HashMap map = null;
            X2 x2 = null;
            String strG1 = null;
            String strG12 = null;
            String strG13 = null;
            String strG14 = null;
            Integer numY0 = null;
            int iR0 = 0;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "item_count":
                        numY0 = interfaceC3118g1.Y0();
                        break;
                    case "length":
                        iR0 = interfaceC3118g1.r0();
                        break;
                    case "filename":
                        strG12 = interfaceC3118g1.g1();
                        break;
                    case "attachment_type":
                        strG13 = interfaceC3118g1.g1();
                        break;
                    case "type":
                        x2 = (X2) interfaceC3118g1.E0(iLogger, new X2.a());
                        break;
                    case "content_type":
                        strG1 = interfaceC3118g1.g1();
                        break;
                    case "platform":
                        strG14 = interfaceC3118g1.g1();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        interfaceC3118g1.j1(iLogger, map, strN0);
                        break;
                }
            }
            if (x2 == null) {
                throw c("type", iLogger);
            }
            K2 k2 = new K2(x2, iR0, strG1, strG12, strG13, strG14, numY0);
            k2.c(map);
            interfaceC3118g1.F();
            return k2;
        }
    }

    public K2(X2 x2, int i, String str, String str2, String str3, String str4, Integer num) {
        this.e = (X2) io.sentry.util.u.c(x2, "type is required");
        this.a = str;
        this.f = i;
        this.c = str2;
        this.g = null;
        this.h = str3;
        this.d = str4;
        this.b = num;
    }

    public int a() {
        Callable callable = this.g;
        if (callable == null) {
            return this.f;
        }
        try {
            return ((Integer) callable.call()).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public X2 b() {
        return this.e;
    }

    public void c(Map map) {
        this.i = map;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.a != null) {
            interfaceC3123h1.f("content_type").h(this.a);
        }
        if (this.c != null) {
            interfaceC3123h1.f("filename").h(this.c);
        }
        interfaceC3123h1.f("type").l(iLogger, this.e);
        if (this.h != null) {
            interfaceC3123h1.f("attachment_type").h(this.h);
        }
        if (this.d != null) {
            interfaceC3123h1.f("platform").h(this.d);
        }
        if (this.b != null) {
            interfaceC3123h1.f("item_count").k(this.b);
        }
        interfaceC3123h1.f("length").b(a());
        Map map = this.i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.i.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    K2(X2 x2, Callable callable, String str, String str2, String str3) {
        this(x2, callable, str, str2, str3, (String) null, (Integer) null);
    }

    K2(X2 x2, Callable callable, String str, String str2, String str3, String str4, Integer num) {
        this.e = (X2) io.sentry.util.u.c(x2, "type is required");
        this.a = str;
        this.f = -1;
        this.c = str2;
        this.g = callable;
        this.h = str3;
        this.d = str4;
        this.b = num;
    }

    K2(X2 x2, Callable callable, String str, String str2) {
        this(x2, callable, str, str2, null);
    }
}
