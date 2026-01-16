package io.appmetrica.analytics.coreutils.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;

/* loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ ActivationBarrierCallback a;

    public l(ActivationBarrierCallback activationBarrierCallback) {
        this.a = activationBarrierCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onWaitFinished();
    }
}
