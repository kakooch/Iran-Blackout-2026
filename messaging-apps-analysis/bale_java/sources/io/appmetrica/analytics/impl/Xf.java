package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;

/* loaded from: classes3.dex */
public final class Xf implements Jk {
    public final Bl a;

    public Xf(Bl bl) {
        this.a = bl;
    }

    @Override // io.appmetrica.analytics.impl.Jk
    public final void a() {
        NetworkTask networkTaskC = this.a.c();
        if (networkTaskC != null) {
            C2586ha.C.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTaskC);
        }
    }
}
