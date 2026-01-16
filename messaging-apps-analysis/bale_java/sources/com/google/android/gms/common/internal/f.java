package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.b;
import ir.nasim.InterfaceC17823nd1;

/* loaded from: classes3.dex */
final class f implements b.a {
    final /* synthetic */ InterfaceC17823nd1 a;

    f(InterfaceC17823nd1 interfaceC17823nd1) {
        this.a = interfaceC17823nd1;
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void onConnected(Bundle bundle) {
        this.a.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void onConnectionSuspended(int i) {
        this.a.onConnectionSuspended(i);
    }
}
