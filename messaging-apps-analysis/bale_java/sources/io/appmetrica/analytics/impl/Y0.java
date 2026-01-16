package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.StartupParamsCallback;
import java.util.List;

/* loaded from: classes3.dex */
public final class Y0 implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ StartupParamsCallback b;
    public final /* synthetic */ List c;
    public final /* synthetic */ C2601i1 d;

    public Y0(C2601i1 c2601i1, Context context, StartupParamsCallback startupParamsCallback, List list) {
        this.d = c2601i1;
        this.a = context;
        this.b = startupParamsCallback;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2743o0 c2743o0 = this.d.a;
        Context applicationContext = this.a.getApplicationContext();
        c2743o0.getClass();
        C2719n0 c2719n0A = C2719n0.a(applicationContext, false);
        c2719n0A.j().a(this.b, this.c);
    }
}
