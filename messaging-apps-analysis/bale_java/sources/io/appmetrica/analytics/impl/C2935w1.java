package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* renamed from: io.appmetrica.analytics.impl.w1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2935w1 extends SafeRunnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ C3007z1 c;

    public C2935w1(C3007z1 c3007z1, int i, Bundle bundle) {
        this.c = c3007z1;
        this.a = i;
        this.b = bundle;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.reportData(this.a, this.b);
    }
}
