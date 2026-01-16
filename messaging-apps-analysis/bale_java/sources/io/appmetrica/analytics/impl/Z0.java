package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;

/* loaded from: classes3.dex */
public final class Z0 implements Runnable {
    public final /* synthetic */ AnrListener a;
    public final /* synthetic */ C2601i1 b;

    public Z0(C2601i1 c2601i1, AnrListener anrListener) {
        this.b = c2601i1;
        this.a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).a(this.a);
    }
}
