package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* renamed from: io.appmetrica.analytics.impl.p1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2768p1 extends SafeRunnable {
    public final /* synthetic */ Configuration a;
    public final /* synthetic */ C3007z1 b;

    public C2768p1(C3007z1 c3007z1, Configuration configuration) {
        this.b = c3007z1;
        this.a = configuration;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.onConfigurationChanged(this.a);
    }
}
