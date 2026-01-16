package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.ResultReceiver;

/* loaded from: classes3.dex */
public final class Nh extends L4 {
    public Nh(I4 i4) {
        super(i4);
    }

    @Override // io.appmetrica.analytics.impl.L4
    public final boolean a(Q5 q5, F4 f4) {
        Bundle bundle = q5.m;
        this.a.l.a(new H4(bundle != null ? (ResultReceiver) bundle.getParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver") : null));
        return false;
    }
}
