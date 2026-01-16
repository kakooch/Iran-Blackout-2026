package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* loaded from: classes3.dex */
public final class Zb extends AbstractC2527f {
    public Zb(Context context, Qf qf) {
        super(context, qf);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2527f
    public final void b(Q5 q5, A4 a4) {
        C2586ha.C.j().a(((Boolean) WrapUtils.getOrDefault(a4.b.b, Boolean.FALSE)).booleanValue());
        this.b.a(q5, a4);
    }
}
