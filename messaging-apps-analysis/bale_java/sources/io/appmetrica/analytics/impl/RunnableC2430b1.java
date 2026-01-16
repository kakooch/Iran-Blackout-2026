package io.appmetrica.analytics.impl;

import android.app.Activity;

/* renamed from: io.appmetrica.analytics.impl.b1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2430b1 implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ C2601i1 b;

    public RunnableC2430b1(C2601i1 c2601i1, Activity activity) {
        this.b = c2601i1;
        this.a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1 c2601i1 = this.b;
        Xj xj = c2601i1.h;
        Activity activity = this.a;
        Ca ca = c2601i1.d().a;
        if (activity != null) {
            xj.f.a(activity);
        }
        if (xj.e.a(activity, EnumC2790q.PAUSED)) {
            ca.b(activity);
        }
    }
}
