package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;

/* loaded from: classes3.dex */
public final class Mk implements InterfaceC2964x6 {
    public final /* synthetic */ StartupParamsCallback a;
    public final /* synthetic */ Nk b;

    public Mk(Nk nk, StartupParamsCallback startupParamsCallback) {
        this.b = nk;
        this.a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2964x6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.a);
    }
}
