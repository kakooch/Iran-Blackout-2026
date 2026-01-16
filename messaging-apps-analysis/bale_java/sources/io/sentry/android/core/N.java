package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import io.sentry.AbstractC3099c2;
import io.sentry.C3155n3;
import io.sentry.C3183r3;
import io.sentry.H3;
import io.sentry.InterfaceC3096c;
import io.sentry.L2;
import io.sentry.M2;
import io.sentry.Y2;
import io.sentry.android.core.AbstractC3060k0;
import io.sentry.protocol.C3166a;
import io.sentry.protocol.C3168c;
import io.sentry.protocol.C3169d;
import io.sentry.protocol.C3170e;
import io.sentry.protocol.DebugImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public final class N implements InterfaceC3096c {
    private final Context a;
    private final SentryAndroidOptions b;
    private final Y c;
    private final M2 d;
    private final io.sentry.cache.q e;

    public N(Context context, SentryAndroidOptions sentryAndroidOptions, Y y) {
        this.a = AbstractC3060k0.g(context);
        this.b = sentryAndroidOptions;
        this.c = y;
        this.e = sentryAndroidOptions.findPersistingScopeObserver();
        this.d = new M2(new C3183r3(sentryAndroidOptions));
    }

    private void A(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.I() == null) {
            abstractC3099c2.Y("java");
        }
    }

    private void B(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.J() == null) {
            abstractC3099c2.Z((String) io.sentry.cache.h.i(this.b, "release.json", String.class));
        }
    }

    private void C(L2 l2) {
        String str = (String) m(this.b, "replay.json", String.class);
        if (!new File(this.b.getCacheDirPath(), "replay_" + str).exists()) {
            if (!n(l2)) {
                return;
            }
            File[] fileArrListFiles = new File(this.b.getCacheDirPath()).listFiles();
            String strSubstring = null;
            if (fileArrListFiles != null) {
                long jLastModified = Long.MIN_VALUE;
                for (File file : fileArrListFiles) {
                    if (file.isDirectory() && file.getName().startsWith("replay_") && file.lastModified() > jLastModified && file.lastModified() <= l2.w0().getTime()) {
                        jLastModified = file.lastModified();
                        strSubstring = file.getName().substring(7);
                    }
                }
            }
            str = strSubstring;
        }
        if (str == null) {
            return;
        }
        io.sentry.cache.q.C(this.b, str, "replay.json");
        l2.C().k("replay_id", str);
    }

    private void D(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.K() == null) {
            abstractC3099c2.a0((io.sentry.protocol.m) m(this.b, "request.json", io.sentry.protocol.m.class));
        }
    }

    private void E(AbstractC3099c2 abstractC3099c2) {
        Map map = (Map) m(this.b, "tags.json", Map.class);
        if (map == null) {
            return;
        }
        if (abstractC3099c2.N() == null) {
            abstractC3099c2.e0(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!abstractC3099c2.N().containsKey(entry.getKey())) {
                abstractC3099c2.d0((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void F(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.L() == null) {
            abstractC3099c2.b0((io.sentry.protocol.p) io.sentry.cache.h.i(this.b, "sdk-version.json", io.sentry.protocol.p.class));
        }
    }

    private void G(AbstractC3099c2 abstractC3099c2) {
        try {
            AbstractC3060k0.a aVarL = C3072q0.i(this.a, this.b).l();
            if (aVarL != null) {
                for (Map.Entry entry : aVarL.a().entrySet()) {
                    abstractC3099c2.d0((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting side loaded info.", th);
        }
    }

    private void H(L2 l2) {
        l(l2);
        G(l2);
    }

    private void I(L2 l2) {
        H3 h3 = (H3) m(this.b, "trace.json", H3.class);
        if (l2.C().i() != null || h3 == null || h3.k() == null || h3.n() == null) {
            return;
        }
        l2.C().x(h3);
    }

    private void J(L2 l2) {
        String str = (String) m(this.b, "transaction.json", String.class);
        if (l2.x0() == null) {
            l2.I0(str);
        }
    }

    private void K(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.Q() == null) {
            abstractC3099c2.g0((io.sentry.protocol.G) m(this.b, "user.json", io.sentry.protocol.G.class));
        }
    }

    private void d(L2 l2, Object obj) {
        B(l2);
        u(l2);
        t(l2);
        r(l2);
        F(l2);
        o(l2, obj);
        z(l2);
    }

    private void e(L2 l2, Object obj) {
        D(l2);
        K(l2);
        E(l2);
        p(l2);
        w(l2);
        q(l2);
        J(l2);
        x(l2, obj);
        y(l2);
        I(l2);
        C(l2);
    }

    private io.sentry.protocol.B f(List list) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            io.sentry.protocol.B b = (io.sentry.protocol.B) it.next();
            String strM = b.m();
            if (strM != null && strM.equals("main")) {
                return b;
            }
        }
        return null;
    }

    private C3170e g() {
        C3170e c3170e = new C3170e();
        c3170e.b0(Build.MANUFACTURER);
        c3170e.P(Build.BRAND);
        c3170e.V(AbstractC3060k0.l(this.b.getLogger()));
        c3170e.d0(Build.MODEL);
        c3170e.e0(Build.ID);
        c3170e.L(AbstractC3060k0.j());
        ActivityManager.MemoryInfo memoryInfoN = AbstractC3060k0.n(this.a, this.b.getLogger());
        if (memoryInfoN != null) {
            c3170e.c0(i(memoryInfoN));
        }
        c3170e.n0(this.c.f());
        DisplayMetrics displayMetricsK = AbstractC3060k0.k(this.a, this.b.getLogger());
        if (displayMetricsK != null) {
            c3170e.m0(Integer.valueOf(displayMetricsK.widthPixels));
            c3170e.l0(Integer.valueOf(displayMetricsK.heightPixels));
            c3170e.j0(Float.valueOf(displayMetricsK.density));
            c3170e.k0(Integer.valueOf(displayMetricsK.densityDpi));
        }
        if (c3170e.J() == null) {
            c3170e.Y(h());
        }
        List listC = io.sentry.android.core.internal.util.l.a().c();
        if (!listC.isEmpty()) {
            c3170e.i0(Double.valueOf(((Integer) Collections.max(listC)).doubleValue()));
            c3170e.h0(Integer.valueOf(listC.size()));
        }
        return c3170e;
    }

    private String h() {
        try {
            return AbstractC3081v0.a(this.a);
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting installationId.", th);
            return null;
        }
    }

    private Long i(ActivityManager.MemoryInfo memoryInfo) {
        return Long.valueOf(memoryInfo.totalMem);
    }

    private boolean j(Object obj) {
        if (obj instanceof io.sentry.hints.a) {
            return "anr_background".equals(((io.sentry.hints.a) obj).h());
        }
        return false;
    }

    private void k(AbstractC3099c2 abstractC3099c2) {
        String str;
        io.sentry.protocol.l lVarG = abstractC3099c2.C().g();
        abstractC3099c2.C().s(C3072q0.i(this.a, this.b).j());
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

    private void l(AbstractC3099c2 abstractC3099c2) {
        io.sentry.protocol.G gQ = abstractC3099c2.Q();
        if (gQ == null) {
            gQ = new io.sentry.protocol.G();
            abstractC3099c2.g0(gQ);
        }
        if (gQ.i() == null) {
            gQ.l(h());
        }
        if (gQ.j() == null && this.b.isSendDefaultPii()) {
            gQ.m("{{auto}}");
        }
    }

    private Object m(C3155n3 c3155n3, String str, Class cls) {
        io.sentry.cache.q qVar = this.e;
        if (qVar == null) {
            return null;
        }
        return qVar.z(c3155n3, str, cls);
    }

    private boolean n(L2 l2) {
        String str = (String) io.sentry.cache.h.i(this.b, "replay-error-sample-rate.json", String.class);
        if (str == null) {
            return false;
        }
        try {
            if (Double.parseDouble(str) >= io.sentry.util.z.a().d()) {
                return true;
            }
            this.b.getLogger().c(Y2.DEBUG, "Not capturing replay for ANR %s due to not being sampled.", l2.G());
            return false;
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error parsing replay sample rate.", th);
            return false;
        }
    }

    private void o(AbstractC3099c2 abstractC3099c2, Object obj) {
        C3166a c3166aD = abstractC3099c2.C().d();
        if (c3166aD == null) {
            c3166aD = new C3166a();
        }
        c3166aD.o(AbstractC3060k0.i(this.a));
        c3166aD.r(Boolean.valueOf(!j(obj)));
        PackageInfo packageInfoP = AbstractC3060k0.p(this.a, this.c);
        if (packageInfoP != null) {
            c3166aD.n(packageInfoP.packageName);
        }
        String strJ = abstractC3099c2.J() != null ? abstractC3099c2.J() : (String) io.sentry.cache.h.i(this.b, "release.json", String.class);
        if (strJ != null) {
            try {
                String strSubstring = strJ.substring(strJ.indexOf(64) + 1, strJ.indexOf(43));
                String strSubstring2 = strJ.substring(strJ.indexOf(43) + 1);
                c3166aD.q(strSubstring);
                c3166aD.m(strSubstring2);
            } catch (Throwable unused) {
                this.b.getLogger().c(Y2.WARNING, "Failed to parse release from scope cache: %s", strJ);
            }
        }
        try {
            AbstractC3060k0.b bVarM = C3072q0.i(this.a, this.b).m();
            if (bVarM != null) {
                c3166aD.t(Boolean.valueOf(bVarM.b()));
                if (bVarM.a() != null) {
                    c3166aD.u(Arrays.asList(bVarM.a()));
                }
            }
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.ERROR, "Error getting split apks info.", th);
        }
        abstractC3099c2.C().n(c3166aD);
    }

    private void p(AbstractC3099c2 abstractC3099c2) {
        List list = (List) m(this.b, "breadcrumbs.json", List.class);
        if (list == null) {
            return;
        }
        if (abstractC3099c2.B() == null) {
            abstractC3099c2.S(list);
        } else {
            abstractC3099c2.B().addAll(list);
        }
    }

    private void q(AbstractC3099c2 abstractC3099c2) {
        C3168c c3168c = (C3168c) m(this.b, "contexts.json", C3168c.class);
        if (c3168c == null) {
            return;
        }
        C3168c c3168cC = abstractC3099c2.C();
        for (Map.Entry entry : new C3168c(c3168c).b()) {
            Object value = entry.getValue();
            if (!"trace".equals(entry.getKey()) || !(value instanceof H3)) {
                if (!c3168cC.a(entry.getKey())) {
                    c3168cC.k((String) entry.getKey(), value);
                }
            }
        }
    }

    private void r(AbstractC3099c2 abstractC3099c2) {
        C3169d c3169dD = abstractC3099c2.D();
        if (c3169dD == null) {
            c3169dD = new C3169d();
        }
        if (c3169dD.d() == null) {
            c3169dD.e(new ArrayList());
        }
        List listD = c3169dD.d();
        if (listD != null) {
            String str = (String) io.sentry.cache.h.i(this.b, "proguard-uuid.json", String.class);
            if (str != null) {
                DebugImage debugImage = new DebugImage();
                debugImage.setType(DebugImage.PROGUARD);
                debugImage.setUuid(str);
                listD.add(debugImage);
            }
            abstractC3099c2.T(c3169dD);
        }
    }

    private void s(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.C().e() == null) {
            abstractC3099c2.C().p(g());
        }
    }

    private void t(AbstractC3099c2 abstractC3099c2) {
        String str;
        if (abstractC3099c2.E() == null) {
            abstractC3099c2.U((String) io.sentry.cache.h.i(this.b, "dist.json", String.class));
        }
        if (abstractC3099c2.E() != null || (str = (String) io.sentry.cache.h.i(this.b, "release.json", String.class)) == null) {
            return;
        }
        try {
            abstractC3099c2.U(str.substring(str.indexOf(43) + 1));
        } catch (Throwable unused) {
            this.b.getLogger().c(Y2.WARNING, "Failed to parse release from scope cache: %s", str);
        }
    }

    private void u(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.F() == null) {
            String environment = (String) io.sentry.cache.h.i(this.b, "environment.json", String.class);
            if (environment == null) {
                environment = this.b.getEnvironment();
            }
            abstractC3099c2.V(environment);
        }
    }

    private void v(L2 l2, Object obj) {
        io.sentry.protocol.j jVar = new io.sentry.protocol.j();
        if (((io.sentry.hints.c) obj).a()) {
            jVar.p("AppExitInfo");
        } else {
            jVar.p("HistoricalAppExitInfo");
        }
        String str = "ANR";
        if (j(obj)) {
            str = "Background ANR";
        }
        ApplicationNotResponding applicationNotResponding = new ApplicationNotResponding(str, Thread.currentThread());
        io.sentry.protocol.B bF = f(l2.v0());
        if (bF == null) {
            bF = new io.sentry.protocol.B();
            bF.y(new io.sentry.protocol.A());
        }
        l2.B0(this.d.f(bF, jVar, applicationNotResponding));
    }

    private void w(AbstractC3099c2 abstractC3099c2) {
        Map map = (Map) m(this.b, "extras.json", Map.class);
        if (map == null) {
            return;
        }
        if (abstractC3099c2.H() == null) {
            abstractC3099c2.X(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!abstractC3099c2.H().containsKey(entry.getKey())) {
                abstractC3099c2.H().put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    private void x(L2 l2, Object obj) {
        List list = (List) m(this.b, "fingerprint.json", List.class);
        if (l2.r0() == null) {
            l2.C0(list);
        }
        boolean zJ = j(obj);
        if (l2.r0() == null) {
            l2.C0(Arrays.asList("{{ default }}", zJ ? "background-anr" : "foreground-anr"));
        }
    }

    private void y(L2 l2) {
        Y2 y2 = (Y2) m(this.b, "level.json", Y2.class);
        if (l2.s0() == null) {
            l2.D0(y2);
        }
    }

    private void z(AbstractC3099c2 abstractC3099c2) {
        Map map = (Map) io.sentry.cache.h.i(this.b, "tags.json", Map.class);
        if (map == null) {
            return;
        }
        if (abstractC3099c2.N() == null) {
            abstractC3099c2.e0(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!abstractC3099c2.N().containsKey(entry.getKey())) {
                abstractC3099c2.d0((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, io.sentry.I i) {
        Object objG = io.sentry.util.m.g(i);
        if (!(objG instanceof io.sentry.hints.c)) {
            this.b.getLogger().c(Y2.WARNING, "The event is not Backfillable, but has been passed to BackfillingEventProcessor, skipping.", new Object[0]);
            return l2;
        }
        v(l2, objG);
        A(l2);
        k(l2);
        s(l2);
        if (!((io.sentry.hints.c) objG).a()) {
            this.b.getLogger().c(Y2.DEBUG, "The event is Backfillable, but should not be enriched, skipping.", new Object[0]);
            return l2;
        }
        e(l2, objG);
        d(l2, objG);
        H(l2);
        return l2;
    }

    @Override // io.sentry.D
    public io.sentry.protocol.C c(io.sentry.protocol.C c, io.sentry.I i) {
        return c;
    }
}
