package io.appmetrica.analytics.impl;

import android.app.Activity;

/* loaded from: classes3.dex */
public final class X0 implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ C2601i1 b;

    public X0(C2601i1 c2601i1, Activity activity) {
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
        if (xj.e.a(activity, EnumC2790q.RESUMED)) {
            ca.a(activity);
        }
    }
}
