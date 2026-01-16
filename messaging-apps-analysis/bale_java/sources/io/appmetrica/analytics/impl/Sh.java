package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.IAppMetricaService;

/* loaded from: classes3.dex */
public final class Sh extends Pg {
    public final Oe e;

    public Sh(C2552g0 c2552g0, Zj zj, Oe oe) {
        super(c2552g0, zj);
        this.e = oe;
    }

    @Override // io.appmetrica.analytics.impl.Pg
    public final void a(IAppMetricaService iAppMetricaService) {
        Bundle bundle = new Bundle();
        Oe oe = this.e;
        synchronized (oe) {
            bundle.putParcelable("PROCESS_CFG_OBJ", oe);
        }
        iAppMetricaService.resumeUserSession(bundle);
    }
}
