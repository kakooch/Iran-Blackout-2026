package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;

/* renamed from: io.appmetrica.analytics.impl.lh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2688lh implements Runnable {
    public final /* synthetic */ ModuleEvent a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2688lh(C2951wh c2951wh, ModuleEvent moduleEvent) {
        this.b = c2951wh;
        this.a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportEvent(this.a);
    }
}
