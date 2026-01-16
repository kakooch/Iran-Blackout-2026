package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
final class I {
    private final int a;
    private final ConnectionResult b;

    I(ConnectionResult connectionResult, int i) {
        AbstractC3795Cj5.j(connectionResult);
        this.b = connectionResult;
        this.a = i;
    }

    final int a() {
        return this.a;
    }

    final ConnectionResult b() {
        return this.b;
    }
}
