package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* loaded from: classes3.dex */
public final class Lc extends SafeRunnable {
    public final /* synthetic */ Oc a;
    public final /* synthetic */ ModuleEvent b;

    public Lc(Oc oc, ModuleEvent moduleEvent) {
        this.a = oc;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Oc.a(this.a).reportEvent(this.b);
    }
}
