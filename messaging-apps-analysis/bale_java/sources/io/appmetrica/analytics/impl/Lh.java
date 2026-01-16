package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfiguration;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public final class Lh {
    public final Q4 a;
    public final Om b;
    public final Mh c;
    public final C2552g0 d;
    public Ok e;
    public final C2666kj f;

    public Lh(C2552g0 c2552g0, Om om, Q4 q4, C2666kj c2666kj) {
        this(c2552g0, om, q4, c2666kj, new Mh(c2552g0, c2666kj));
    }

    public final void a(Ng ng) {
        Wg wg = ng.e;
        Ok ok = this.e;
        if (ok != null) {
            wg.b.setUuid(((Nk) ok).g());
        } else {
            wg.getClass();
        }
        this.c.a(ng);
    }

    public final void b(String str) {
        Oe oe = this.a.a;
        synchronized (oe) {
            oe.a.put("PROCESS_CFG_INSTALL_REFERRER_SOURCE", str);
        }
    }

    public Lh(C2552g0 c2552g0, Om om, Q4 q4, C2666kj c2666kj, Mh mh) {
        this.d = c2552g0;
        this.a = q4;
        this.b = om;
        this.f = c2666kj;
        this.c = mh;
    }

    public final void a(Nk nk) {
        this.e = nk;
        this.a.b.setUuid(nk.g());
    }

    public final void a(Q5 q5, Wg wg, int i, Map map) {
        String str;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        this.d.b();
        if (!hn.a(map)) {
            q5.setValue(Ya.b(map));
            a(q5, wg);
        }
        Oe oe = new Oe(wg.a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
        synchronized (wg) {
            str = wg.f;
        }
        a(new Ng(q5, false, i, null, new Wg(oe, counterConfiguration, str)));
    }

    public static Q5 a(Q5 q5, Wg wg) {
        if (AbstractC2776p9.a.contains(Integer.valueOf(q5.d))) {
            q5.c = wg.d();
        }
        return q5;
    }

    public final void a(List list) {
        Oe oe = this.a.a;
        synchronized (oe) {
            oe.a.put("PROCESS_CFG_CUSTOM_HOSTS", hn.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
        }
    }

    public final void a(HashMap map) {
        Oe oe = this.a.a;
        synchronized (oe) {
            oe.a.put("PROCESS_CFG_CLIDS", Ya.b(map));
        }
    }

    public final void a(String str) {
        Oe oe = this.a.a;
        synchronized (oe) {
            oe.a.put("PROCESS_CFG_DISTRIBUTION_REFERRER", str);
        }
    }
}
