package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
import ir.nasim.ZI4;

/* loaded from: classes3.dex */
final class g implements b.InterfaceC0173b {
    final /* synthetic */ ZI4 a;

    g(ZI4 zi4) {
        this.a = zi4;
    }

    @Override // com.google.android.gms.common.internal.b.InterfaceC0173b
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.a.onConnectionFailed(connectionResult);
    }
}
