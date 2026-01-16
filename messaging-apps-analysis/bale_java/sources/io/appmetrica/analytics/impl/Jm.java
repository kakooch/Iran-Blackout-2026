package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;

/* loaded from: classes3.dex */
public final class Jm extends Pg {
    public final int e;
    public final Bundle f;

    public Jm(C2552g0 c2552g0, Zj zj, int i, Bundle bundle) {
        super(c2552g0, zj);
        this.e = i;
        this.f = bundle;
    }

    @Override // io.appmetrica.analytics.impl.Pg
    public final void a(IAppMetricaService iAppMetricaService) {
        iAppMetricaService.reportData(this.e, this.f);
    }
}
