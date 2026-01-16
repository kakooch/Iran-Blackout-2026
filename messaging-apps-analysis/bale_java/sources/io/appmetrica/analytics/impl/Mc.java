package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* loaded from: classes3.dex */
public final class Mc extends SafeRunnable {
    public final /* synthetic */ Oc a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public Mc(Oc oc, int i, String str) {
        this.a = oc;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Oc.a(this.a).a(new C3015z9(this.b, this.c));
    }
}
