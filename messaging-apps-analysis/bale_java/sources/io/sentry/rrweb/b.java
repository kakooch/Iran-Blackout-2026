package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.rrweb.c;
import io.sentry.util.u;

/* loaded from: classes3.dex */
public abstract class b {
    private c a;
    private long b = System.currentTimeMillis();

    public static final class a {
        public boolean a(b bVar, String str, InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            str.hashCode();
            if (str.equals("type")) {
                bVar.a = (c) u.c((c) interfaceC3118g1.E0(iLogger, new c.a()), "");
                return true;
            }
            if (!str.equals("timestamp")) {
                return false;
            }
            bVar.b = interfaceC3118g1.K1();
            return true;
        }
    }

    /* renamed from: io.sentry.rrweb.b$b, reason: collision with other inner class name */
    public static final class C0251b {
        public void a(b bVar, InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
            interfaceC3123h1.f("type").l(iLogger, bVar.a);
            interfaceC3123h1.f("timestamp").b(bVar.b);
        }
    }

    protected b(c cVar) {
        this.a = cVar;
    }

    public long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.b == bVar.b && this.a == bVar.a;
    }

    public void f(long j) {
        this.b = j;
    }

    public int hashCode() {
        return u.b(this.a, Long.valueOf(this.b));
    }
}
