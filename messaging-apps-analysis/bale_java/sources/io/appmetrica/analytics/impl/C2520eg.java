package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.IAppMetricaService;

/* renamed from: io.appmetrica.analytics.impl.eg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2520eg extends Pg {
    public final Ng e;

    public C2520eg(C2552g0 c2552g0, Zj zj, Ng ng) {
        super(c2552g0, zj);
        this.e = ng;
    }

    @Override // io.appmetrica.analytics.impl.Pg
    public final void a(Throwable th) {
    }

    @Override // io.appmetrica.analytics.impl.Pg
    public final void a(IAppMetricaService iAppMetricaService) {
        Ng ng = this.e;
        iAppMetricaService.reportData(ng.c, ng.a.d(ng.e.c()));
    }
}
