package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* renamed from: io.appmetrica.analytics.impl.s1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2839s1 extends SafeRunnable {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ C3007z1 d;

    public C2839s1(C3007z1 c3007z1, Intent intent, int i, int i2) {
        this.d = c3007z1;
        this.a = intent;
        this.b = i;
        this.c = i2;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.d.b.a(this.a, this.b, this.c);
    }
}
