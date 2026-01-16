package io.sentry.android.core.performance;

import android.os.Looper;
import android.os.SystemClock;
import io.sentry.AbstractC3124h2;
import io.sentry.EnumC3152n0;
import io.sentry.InterfaceC3117g0;
import io.sentry.O3;
import io.sentry.android.core.AbstractC3082w;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class b {
    private final String a;
    private AbstractC3124h2 b = null;
    private AbstractC3124h2 c = null;
    private InterfaceC3117g0 d = null;
    private InterfaceC3117g0 e = null;

    public b(String str) {
        this.a = str;
    }

    private InterfaceC3117g0 d(InterfaceC3117g0 interfaceC3117g0, String str, AbstractC3124h2 abstractC3124h2) {
        InterfaceC3117g0 interfaceC3117g0S = interfaceC3117g0.s("activity.load", str, abstractC3124h2, EnumC3152n0.SENTRY);
        f(interfaceC3117g0S);
        return interfaceC3117g0S;
    }

    private void f(InterfaceC3117g0 interfaceC3117g0) {
        interfaceC3117g0.q("thread.id", Long.valueOf(Looper.getMainLooper().getThread().getId()));
        interfaceC3117g0.q("thread.name", "main");
        Boolean bool = Boolean.TRUE;
        interfaceC3117g0.q("ui.contributes_to_ttid", bool);
        interfaceC3117g0.q("ui.contributes_to_ttfd", bool);
    }

    public void a() {
        InterfaceC3117g0 interfaceC3117g0 = this.d;
        if (interfaceC3117g0 != null && !interfaceC3117g0.k()) {
            this.d.r(O3.CANCELLED);
        }
        this.d = null;
        InterfaceC3117g0 interfaceC3117g02 = this.e;
        if (interfaceC3117g02 != null && !interfaceC3117g02.k()) {
            this.e.r(O3.CANCELLED);
        }
        this.e = null;
    }

    public void b(InterfaceC3117g0 interfaceC3117g0) {
        if (this.b == null || interfaceC3117g0 == null) {
            return;
        }
        InterfaceC3117g0 interfaceC3117g0D = d(interfaceC3117g0, this.a + ".onCreate", this.b);
        this.d = interfaceC3117g0D;
        interfaceC3117g0D.m();
    }

    public void c(InterfaceC3117g0 interfaceC3117g0) {
        if (this.c == null || interfaceC3117g0 == null) {
            return;
        }
        InterfaceC3117g0 interfaceC3117g0D = d(interfaceC3117g0, this.a + ".onStart", this.c);
        this.e = interfaceC3117g0D;
        interfaceC3117g0D.m();
    }

    public void e() {
        InterfaceC3117g0 interfaceC3117g0 = this.d;
        if (interfaceC3117g0 == null || this.e == null) {
            return;
        }
        AbstractC3124h2 abstractC3124h2W = interfaceC3117g0.w();
        AbstractC3124h2 abstractC3124h2W2 = this.e.w();
        if (abstractC3124h2W == null || abstractC3124h2W2 == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        AbstractC3124h2 abstractC3124h2A = AbstractC3082w.a();
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long millis = timeUnit.toMillis(abstractC3124h2A.h(this.d.y()));
        long millis2 = timeUnit.toMillis(abstractC3124h2A.h(abstractC3124h2W));
        long millis3 = timeUnit.toMillis(abstractC3124h2A.h(this.e.y()));
        long millis4 = timeUnit.toMillis(abstractC3124h2A.h(abstractC3124h2W2));
        c cVar = new c();
        cVar.h().A(this.d.getDescription(), timeUnit.toMillis(this.d.y().p()), jUptimeMillis - millis, jUptimeMillis - millis2);
        cVar.i().A(this.e.getDescription(), timeUnit.toMillis(this.e.y().p()), jUptimeMillis - millis3, jUptimeMillis - millis4);
        h.p().e(cVar);
    }

    public void g(AbstractC3124h2 abstractC3124h2) {
        this.b = abstractC3124h2;
    }

    public void h(AbstractC3124h2 abstractC3124h2) {
        this.c = abstractC3124h2;
    }
}
