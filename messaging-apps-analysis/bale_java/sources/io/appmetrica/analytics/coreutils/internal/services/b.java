package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;

/* loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ WaitForActivationDelayBarrier.ActivationBarrierHelper a;

    public b(WaitForActivationDelayBarrier.ActivationBarrierHelper activationBarrierHelper) {
        this.a = activationBarrierHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.a.b;
        aVar.b.a = true;
        aVar.a.run();
    }
}
