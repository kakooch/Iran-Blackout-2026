package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Eg extends AbstractC2568gg {
    public final He b;
    public final tn c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public Eg(C2484d5 c2484d5) {
        this(c2484d5, c2484d5.u(), C2586ha.h().q(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        C2484d5 c2484d5 = this.a;
        if (this.c.d()) {
            return false;
        }
        Q5 q5A = ((Cg) c2484d5.l.a()).f ? Q5.a(q5, Ta.EVENT_TYPE_APP_UPDATE) : Q5.a(q5, Ta.EVENT_TYPE_INIT);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c2484d5.a, c2484d5.b.a), ""));
            He he = this.b;
            he.h.a(he.a);
            jSONObject.put("preloadInfo", ((Ee) he.c()).b());
        } catch (Throwable unused) {
        }
        q5A.setValue(jSONObject.toString());
        C2537f9 c2537f9 = c2484d5.o;
        c2537f9.a(q5A, Sj.a(c2537f9.c.b(q5A), q5A.i));
        tn tnVar = this.c;
        synchronized (tnVar) {
            un unVar = tnVar.a;
            unVar.a(unVar.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public Eg(C2484d5 c2484d5, tn tnVar, He he, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c2484d5);
        this.c = tnVar;
        this.b = he;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
