package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* renamed from: io.appmetrica.analytics.impl.r1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2815r1 extends SafeRunnable {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ int b;
    public final /* synthetic */ C3007z1 c;

    public C2815r1(C3007z1 c3007z1, Intent intent, int i) {
        this.c = c3007z1;
        this.a = intent;
        this.b = i;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.a(this.a, this.b);
    }
}
