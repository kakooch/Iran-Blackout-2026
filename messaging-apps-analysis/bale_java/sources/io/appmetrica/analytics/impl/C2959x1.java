package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* renamed from: io.appmetrica.analytics.impl.x1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2959x1 extends SafeRunnable {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ C3007z1 b;

    public C2959x1(C3007z1 c3007z1, Bundle bundle) {
        this.b = c3007z1;
        this.a = bundle;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.resumeUserSession(this.a);
    }
}
