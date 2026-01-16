package io.sentry;

import android.gov.nist.core.Separators;
import io.sentry.util.C3202a;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class C3 implements A0 {
    private final Date a;
    private Date b;
    private final AtomicInteger c;
    private final String d;
    private final String e;
    private Boolean f;
    private b g;
    private Long h;
    private Double i;
    private final String j;
    private String k;
    private final String l;
    private final String m;
    private String n;
    private final C3202a o;
    private Map p;

    public static final class a implements InterfaceC3176q0 {
        private Exception c(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + Separators.DOUBLE_QUOTE;
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.b(Y2.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public io.sentry.C3 a(io.sentry.InterfaceC3118g1 r28, io.sentry.ILogger r29) throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 648
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.C3.a.a(io.sentry.g1, io.sentry.ILogger):io.sentry.C3");
        }
    }

    public enum b {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public C3(b bVar, Date date, Date date2, int i, String str, String str2, Boolean bool, Long l, Double d, String str3, String str4, String str5, String str6, String str7) {
        this.o = new C3202a();
        this.g = bVar;
        this.a = date;
        this.b = date2;
        this.c = new AtomicInteger(i);
        this.d = str;
        this.e = str2;
        this.f = bool;
        this.h = l;
        this.i = d;
        this.j = str3;
        this.k = str4;
        this.l = str5;
        this.m = str6;
        this.n = str7;
    }

    private double a(Date date) {
        return Math.abs(date.getTime() - this.a.getTime()) / 1000.0d;
    }

    private long i(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C3 clone() {
        return new C3(this.g, this.a, this.b, this.c.get(), this.d, this.e, this.f, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
    }

    public void c() {
        d(AbstractC3141l.d());
    }

    public void d(Date date) {
        InterfaceC3102d0 interfaceC3102d0A = this.o.a();
        try {
            this.f = null;
            if (this.g == b.Ok) {
                this.g = b.Exited;
            }
            if (date != null) {
                this.b = date;
            } else {
                this.b = AbstractC3141l.d();
            }
            Date date2 = this.b;
            if (date2 != null) {
                this.i = Double.valueOf(a(date2));
                this.h = Long.valueOf(i(this.b));
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public int e() {
        return this.c.get();
    }

    public String f() {
        return this.n;
    }

    public Boolean g() {
        return this.f;
    }

    public String h() {
        return this.m;
    }

    public String j() {
        return this.e;
    }

    public Date k() {
        Date date = this.a;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public b l() {
        return this.g;
    }

    public boolean m() {
        return this.g != b.Ok;
    }

    public void n() {
        this.f = Boolean.TRUE;
    }

    public void o(Map map) {
        this.p = map;
    }

    public boolean p(b bVar, String str, boolean z) {
        return q(bVar, str, z, null);
    }

    public boolean q(b bVar, String str, boolean z, String str2) {
        boolean z2;
        InterfaceC3102d0 interfaceC3102d0A = this.o.a();
        boolean z3 = true;
        if (bVar != null) {
            try {
                this.g = bVar;
                z2 = true;
            } catch (Throwable th) {
                if (interfaceC3102d0A != null) {
                    try {
                        interfaceC3102d0A.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            z2 = false;
        }
        if (str != null) {
            this.k = str;
            z2 = true;
        }
        if (z) {
            this.c.addAndGet(1);
            z2 = true;
        }
        if (str2 != null) {
            this.n = str2;
        } else {
            z3 = z2;
        }
        if (z3) {
            this.f = null;
            Date dateD = AbstractC3141l.d();
            this.b = dateD;
            if (dateD != null) {
                this.h = Long.valueOf(i(dateD));
            }
        }
        if (interfaceC3102d0A != null) {
            interfaceC3102d0A.close();
        }
        return z3;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.e != null) {
            interfaceC3123h1.f("sid").h(this.e);
        }
        if (this.d != null) {
            interfaceC3123h1.f("did").h(this.d);
        }
        if (this.f != null) {
            interfaceC3123h1.f("init").m(this.f);
        }
        interfaceC3123h1.f("started").l(iLogger, this.a);
        interfaceC3123h1.f("status").l(iLogger, this.g.name().toLowerCase(Locale.ROOT));
        if (this.h != null) {
            interfaceC3123h1.f("seq").k(this.h);
        }
        interfaceC3123h1.f("errors").b(this.c.intValue());
        if (this.i != null) {
            interfaceC3123h1.f("duration").k(this.i);
        }
        if (this.b != null) {
            interfaceC3123h1.f("timestamp").l(iLogger, this.b);
        }
        if (this.n != null) {
            interfaceC3123h1.f("abnormal_mechanism").l(iLogger, this.n);
        }
        interfaceC3123h1.f("attrs");
        interfaceC3123h1.B();
        interfaceC3123h1.f("release").l(iLogger, this.m);
        if (this.l != null) {
            interfaceC3123h1.f("environment").l(iLogger, this.l);
        }
        if (this.j != null) {
            interfaceC3123h1.f("ip_address").l(iLogger, this.j);
        }
        if (this.k != null) {
            interfaceC3123h1.f("user_agent").l(iLogger, this.k);
        }
        interfaceC3123h1.F();
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

    public C3(String str, io.sentry.protocol.G g, String str2, String str3) {
        this(b.Ok, AbstractC3141l.d(), AbstractC3141l.d(), 0, str, A3.a(), Boolean.TRUE, null, null, g != null ? g.j() : null, null, str2, str3, null);
    }
}
