package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import io.sentry.AbstractC3099c2;
import io.sentry.AbstractC3141l;
import io.sentry.C3160o3;
import io.sentry.L2;
import io.sentry.Y2;
import io.sentry.android.core.AbstractC3060k0;
import io.sentry.protocol.C3166a;
import io.sentry.util.q;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: io.sentry.android.core.o0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3068o0 implements io.sentry.D {
    final Context a;
    private final Y b;
    private final SentryAndroidOptions c;
    private final Future d;
    private final io.sentry.util.q e = new io.sentry.util.q(new q.a() { // from class: io.sentry.android.core.m0
        @Override // io.sentry.util.q.a
        public final Object a() {
            return C3068o0.g();
        }
    });

    public C3068o0(Context context, Y y, final SentryAndroidOptions sentryAndroidOptions) {
        this.a = (Context) io.sentry.util.u.c(AbstractC3060k0.g(context), "The application context is required.");
        this.b = (Y) io.sentry.util.u.c(y, "The BuildInfoProvider is required.");
        this.c = (SentryAndroidOptions) io.sentry.util.u.c(sentryAndroidOptions, "The options object is required.");
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.d = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: io.sentry.android.core.n0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.h(sentryAndroidOptions);
            }
        });
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    private static void f(L2 l2) {
        io.sentry.protocol.A aI;
        List listD;
        List listQ0 = l2.q0();
        if (listQ0 == null || listQ0.size() <= 1) {
            return;
        }
        io.sentry.protocol.q qVar = (io.sentry.protocol.q) listQ0.get(listQ0.size() - 1);
        if (!"java.lang".equals(qVar.h()) || (aI = qVar.i()) == null || (listD = aI.d()) == null) {
            return;
        }
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            if ("com.android.internal.os.RuntimeInit$MethodAndArgsCaller".equals(((io.sentry.protocol.z) it.next()).u())) {
                Collections.reverse(listQ0);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g() {
        return AbstractC3060k0.l(io.sentry.L0.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C3072q0 h(SentryAndroidOptions sentryAndroidOptions) {
        return C3072q0.i(this.a, sentryAndroidOptions);
    }

    private void i(AbstractC3099c2 abstractC3099c2) {
        String str;
        io.sentry.protocol.l lVarG = abstractC3099c2.C().g();
        try {
            abstractC3099c2.C().s(((C3072q0) this.d.get()).j());
        } catch (Throwable th) {
            this.c.getLogger().b(Y2.ERROR, "Failed to retrieve os system", th);
        }
        if (lVarG != null) {
            String strG = lVarG.g();
            if (strG == null || strG.isEmpty()) {
                str = "os_1";
            } else {
                str = "os_" + strG.trim().toLowerCase(Locale.ROOT);
            }
            abstractC3099c2.C().k(str, lVarG);
        }
    }

    private void j(AbstractC3099c2 abstractC3099c2) {
        io.sentry.protocol.G gQ = abstractC3099c2.Q();
        if (gQ == null) {
            gQ = new io.sentry.protocol.G();
            abstractC3099c2.g0(gQ);
        }
        if (gQ.i() == null) {
            gQ.l(AbstractC3081v0.a(this.a));
        }
        if (gQ.j() == null && this.c.isSendDefaultPii()) {
            gQ.m("{{auto}}");
        }
    }

    private void k(AbstractC3099c2 abstractC3099c2, io.sentry.I i) {
        C3166a c3166aD = abstractC3099c2.C().d();
        if (c3166aD == null) {
            c3166aD = new C3166a();
        }
        l(c3166aD, i);
        p(abstractC3099c2, c3166aD);
        abstractC3099c2.C().n(c3166aD);
    }

    private void l(C3166a c3166a, io.sentry.I i) {
        Boolean boolK;
        c3166a.o(AbstractC3060k0.i(this.a));
        io.sentry.android.core.performance.i iVarL = io.sentry.android.core.performance.h.p().l(this.c);
        if (iVarL.w()) {
            c3166a.p(AbstractC3141l.o(iVarL.q()));
        }
        if (io.sentry.util.m.i(i) || c3166a.l() != null || (boolK = X.j().k()) == null) {
            return;
        }
        c3166a.r(Boolean.valueOf(!boolK.booleanValue()));
    }

    private void m(AbstractC3099c2 abstractC3099c2, boolean z, boolean z2) {
        j(abstractC3099c2);
        n(abstractC3099c2, z, z2);
        q(abstractC3099c2);
    }

    private void n(AbstractC3099c2 abstractC3099c2, boolean z, boolean z2) {
        if (abstractC3099c2.C().e() == null) {
            try {
                abstractC3099c2.C().p(((C3072q0) this.d.get()).a(z, z2));
            } catch (Throwable th) {
                this.c.getLogger().b(Y2.ERROR, "Failed to retrieve device info", th);
            }
            i(abstractC3099c2);
        }
    }

    private void o(AbstractC3099c2 abstractC3099c2, String str) {
        if (abstractC3099c2.E() == null) {
            abstractC3099c2.U(str);
        }
    }

    private void p(AbstractC3099c2 abstractC3099c2, C3166a c3166a) {
        C3072q0 c3072q0;
        PackageInfo packageInfoO = AbstractC3060k0.o(this.a, 4096, this.c.getLogger(), this.b);
        if (packageInfoO != null) {
            o(abstractC3099c2, AbstractC3060k0.q(packageInfoO, this.b));
            try {
                c3072q0 = (C3072q0) this.d.get();
            } catch (Throwable th) {
                this.c.getLogger().b(Y2.ERROR, "Failed to retrieve device info", th);
                c3072q0 = null;
            }
            AbstractC3060k0.C(packageInfoO, this.b, c3072q0, c3166a);
        }
    }

    private void q(AbstractC3099c2 abstractC3099c2) {
        try {
            AbstractC3060k0.a aVarL = ((C3072q0) this.d.get()).l();
            if (aVarL != null) {
                for (Map.Entry entry : aVarL.a().entrySet()) {
                    abstractC3099c2.d0((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.c.getLogger().b(Y2.ERROR, "Error getting side loaded info.", th);
        }
    }

    private void r(L2 l2, io.sentry.I i) {
        if (l2.v0() != null) {
            boolean zI = io.sentry.util.m.i(i);
            for (io.sentry.protocol.B b : l2.v0()) {
                boolean zG = io.sentry.android.core.internal.util.i.e().g(b);
                if (b.o() == null) {
                    b.r(Boolean.valueOf(zG));
                }
                if (!zI && b.p() == null) {
                    b.v(Boolean.valueOf(zG));
                }
            }
        }
    }

    private boolean s(AbstractC3099c2 abstractC3099c2, io.sentry.I i) {
        if (io.sentry.util.m.u(i)) {
            return true;
        }
        this.c.getLogger().c(Y2.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", abstractC3099c2.G());
        return false;
    }

    @Override // io.sentry.D
    public C3160o3 a(C3160o3 c3160o3, io.sentry.I i) {
        boolean zS = s(c3160o3, i);
        if (zS) {
            k(c3160o3, i);
        }
        m(c3160o3, false, zS);
        return c3160o3;
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, io.sentry.I i) {
        boolean zS = s(l2, i);
        if (zS) {
            k(l2, i);
            r(l2, i);
        }
        m(l2, true, zS);
        f(l2);
        return l2;
    }

    @Override // io.sentry.D
    public io.sentry.protocol.C c(io.sentry.protocol.C c, io.sentry.I i) {
        boolean zS = s(c, i);
        if (zS) {
            k(c, i);
        }
        m(c, false, zS);
        return c;
    }
}
