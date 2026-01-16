package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.KJ;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2330y0 extends W0 {
    private final Map b;
    private final Map c;
    private long d;

    public C2330y0(H1 h1) {
        super(h1);
        this.c = new KJ();
        this.b = new KJ();
    }

    static /* synthetic */ void i(C2330y0 c2330y0, String str, long j) {
        c2330y0.h();
        AbstractC3795Cj5.f(str);
        if (c2330y0.c.isEmpty()) {
            c2330y0.d = j;
        }
        Integer num = (Integer) c2330y0.c.get(str);
        if (num != null) {
            c2330y0.c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (c2330y0.c.size() >= 100) {
            c2330y0.a.b().w().a("Too many ads visible");
        } else {
            c2330y0.c.put(str, 1);
            c2330y0.b.put(str, Long.valueOf(j));
        }
    }

    static /* synthetic */ void j(C2330y0 c2330y0, String str, long j) {
        c2330y0.h();
        AbstractC3795Cj5.f(str);
        Integer num = (Integer) c2330y0.c.get(str);
        if (num == null) {
            c2330y0.a.b().r().b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        M2 m2S = c2330y0.a.K().s(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            c2330y0.c.put(str, Integer.valueOf(iIntValue));
            return;
        }
        c2330y0.c.remove(str);
        Long l = (Long) c2330y0.b.get(str);
        if (l == null) {
            c2330y0.a.b().r().a("First ad unit exposure time was never set");
        } else {
            long jLongValue = l.longValue();
            c2330y0.b.remove(str);
            c2330y0.p(str, j - jLongValue, m2S);
        }
        if (c2330y0.c.isEmpty()) {
            long j2 = c2330y0.d;
            if (j2 == 0) {
                c2330y0.a.b().r().a("First ad exposure time was never set");
            } else {
                c2330y0.o(j - j2, m2S);
                c2330y0.d = 0L;
            }
        }
    }

    private final void o(long j, M2 m2) {
        if (m2 == null) {
            this.a.b().v().a("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            this.a.b().v().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        f4.y(m2, bundle, true);
        this.a.I().u("am", "_xa", bundle);
    }

    private final void p(String str, long j, M2 m2) {
        if (m2 == null) {
            this.a.b().v().a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            this.a.b().v().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        f4.y(m2, bundle, true);
        this.a.I().u("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(long j) {
        Iterator it = this.b.keySet().iterator();
        while (it.hasNext()) {
            this.b.put((String) it.next(), Long.valueOf(j));
        }
        if (this.b.isEmpty()) {
            return;
        }
        this.d = j;
    }

    public final void l(String str, long j) {
        if (str == null || str.length() == 0) {
            this.a.b().r().a("Ad unit id must be a non-empty string");
        } else {
            this.a.a().z(new RunnableC2210a(this, str, j));
        }
    }

    public final void m(String str, long j) {
        if (str == null || str.length() == 0) {
            this.a.b().r().a("Ad unit id must be a non-empty string");
        } else {
            this.a.a().z(new RunnableC2314v(this, str, j));
        }
    }

    public final void n(long j) {
        M2 m2S = this.a.K().s(false);
        for (String str : this.b.keySet()) {
            p(str, j - ((Long) this.b.get(str)).longValue(), m2S);
        }
        if (!this.b.isEmpty()) {
            o(j - this.d, m2S);
        }
        q(j);
    }
}
