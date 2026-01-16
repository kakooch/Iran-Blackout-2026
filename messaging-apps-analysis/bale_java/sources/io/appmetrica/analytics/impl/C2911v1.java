package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* renamed from: io.appmetrica.analytics.impl.v1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2911v1 extends SafeRunnable {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ C3007z1 b;

    public C2911v1(C3007z1 c3007z1, Intent intent) {
        this.b = c3007z1;
        this.a = intent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.b(this.a);
    }
}
