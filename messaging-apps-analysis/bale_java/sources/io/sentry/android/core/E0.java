package io.sentry.android.core;

import io.sentry.E0;
import io.sentry.H3;
import io.sentry.InterfaceC3102d0;
import io.sentry.L2;
import io.sentry.M3;
import io.sentry.O3;
import io.sentry.android.core.performance.h;
import io.sentry.protocol.C3166a;
import io.sentry.protocol.C3174i;
import io.sentry.util.C3202a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class E0 implements io.sentry.D {
    private final C3050h b;
    private final SentryAndroidOptions c;
    private boolean a = false;
    private final C3202a d = new C3202a();

    E0(SentryAndroidOptions sentryAndroidOptions, C3050h c3050h) {
        this.c = (SentryAndroidOptions) io.sentry.util.u.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.b = (C3050h) io.sentry.util.u.c(c3050h, "ActivityFramesTracker is required");
    }

    private void d(io.sentry.android.core.performance.h hVar, io.sentry.protocol.C c) {
        H3 h3I;
        M3 m3E;
        if (hVar.m() == h.a.COLD && (h3I = c.C().i()) != null) {
            io.sentry.protocol.v vVarN = h3I.n();
            Iterator it = c.p0().iterator();
            while (true) {
                if (!it.hasNext()) {
                    m3E = null;
                    break;
                }
                io.sentry.protocol.y yVar = (io.sentry.protocol.y) it.next();
                if (yVar.d().contentEquals("app.start.cold")) {
                    m3E = yVar.e();
                    break;
                }
            }
            io.sentry.android.core.performance.i iVarG = hVar.g();
            if (iVarG.w() && Math.abs(iVarG.i()) <= 10000) {
                c.p0().add(h(iVarG, m3E, vVarN, "process.load"));
            }
            List listO = hVar.o();
            if (!listO.isEmpty()) {
                Iterator it2 = listO.iterator();
                while (it2.hasNext()) {
                    c.p0().add(h((io.sentry.android.core.performance.i) it2.next(), m3E, vVarN, "contentprovider.load"));
                }
            }
            io.sentry.android.core.performance.i iVarN = hVar.n();
            if (iVarN.x()) {
                c.p0().add(h(iVarN, m3E, vVarN, "application.load"));
            }
        }
    }

    private boolean e(io.sentry.protocol.C c) {
        for (io.sentry.protocol.y yVar : c.p0()) {
            if (yVar.d().contentEquals("app.start.cold") || yVar.d().contentEquals("app.start.warm")) {
                return true;
            }
        }
        H3 h3I = c.C().i();
        return h3I != null && (h3I.e().equals("app.start.cold") || h3I.e().equals("app.start.warm"));
    }

    private static boolean f(double d, io.sentry.protocol.y yVar) {
        return d >= yVar.f().doubleValue() && (yVar.g() == null || d <= yVar.g().doubleValue());
    }

    private void g(io.sentry.protocol.C c) {
        Object obj;
        io.sentry.protocol.y yVar = null;
        io.sentry.protocol.y yVar2 = null;
        for (io.sentry.protocol.y yVar3 : c.p0()) {
            if ("ui.load.initial_display".equals(yVar3.d())) {
                yVar = yVar3;
            } else if ("ui.load.full_display".equals(yVar3.d())) {
                yVar2 = yVar3;
            }
            if (yVar != null && yVar2 != null) {
                break;
            }
        }
        if (yVar == null && yVar2 == null) {
            return;
        }
        for (io.sentry.protocol.y yVar4 : c.p0()) {
            if (yVar4 != yVar && yVar4 != yVar2) {
                Map mapB = yVar4.b();
                boolean z = false;
                boolean z2 = yVar != null && f(yVar4.f().doubleValue(), yVar) && (mapB == null || (obj = mapB.get("thread.name")) == null || "main".equals(obj));
                if (yVar2 != null && f(yVar4.f().doubleValue(), yVar2)) {
                    z = true;
                }
                if (z2 || z) {
                    Map mapB2 = yVar4.b();
                    if (mapB2 == null) {
                        mapB2 = new ConcurrentHashMap();
                        yVar4.h(mapB2);
                    }
                    if (z2) {
                        mapB2.put("ui.contributes_to_ttid", Boolean.TRUE);
                    }
                    if (z) {
                        mapB2.put("ui.contributes_to_ttfd", Boolean.TRUE);
                    }
                }
            }
        }
    }

    private static io.sentry.protocol.y h(io.sentry.android.core.performance.i iVar, M3 m3, io.sentry.protocol.v vVar, String str) {
        HashMap map = new HashMap(2);
        map.put("thread.id", Long.valueOf(io.sentry.android.core.internal.util.i.b));
        map.put("thread.name", "main");
        Boolean bool = Boolean.TRUE;
        map.put("ui.contributes_to_ttid", bool);
        map.put("ui.contributes_to_ttfd", bool);
        return new io.sentry.protocol.y(Double.valueOf(iVar.s()), Double.valueOf(iVar.p()), vVar, new M3(), m3, str, iVar.h(), O3.OK, "auto.ui", new ConcurrentHashMap(), new ConcurrentHashMap(), map);
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, io.sentry.I i) {
        return l2;
    }

    @Override // io.sentry.D
    public io.sentry.protocol.C c(io.sentry.protocol.C c, io.sentry.I i) {
        Map mapQ;
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            if (!this.c.isTracingEnabled()) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                return c;
            }
            io.sentry.android.core.performance.h hVarP = io.sentry.android.core.performance.h.p();
            if (e(c)) {
                if (hVarP.B()) {
                    long jI = hVarP.l(this.c).i();
                    if (jI != 0) {
                        c.n0().put(hVarP.m() == h.a.COLD ? "app_start_cold" : "app_start_warm", new C3174i(Float.valueOf(jI), E0.a.MILLISECOND.apiName()));
                        d(hVarP, c);
                        hVarP.v();
                    }
                }
                C3166a c3166aD = c.C().d();
                if (c3166aD == null) {
                    c3166aD = new C3166a();
                    c.C().n(c3166aD);
                }
                c3166aD.v(hVarP.m() == h.a.COLD ? "cold" : "warm");
            }
            g(c);
            io.sentry.protocol.v vVarG = c.G();
            H3 h3I = c.C().i();
            if (vVarG != null && h3I != null && h3I.e().contentEquals("ui.load") && (mapQ = this.b.q(vVarG)) != null) {
                c.n0().putAll(mapQ);
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return c;
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
}
