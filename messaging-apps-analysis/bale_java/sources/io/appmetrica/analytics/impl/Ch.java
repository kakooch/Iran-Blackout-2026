package io.appmetrica.analytics.impl;

import android.content.Context;

/* loaded from: classes3.dex */
public final class Ch implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Eh b;

    public Ch(Eh eh, Context context) {
        this.b = eh;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2743o0 c2743o0 = this.b.b;
        Context context = this.a;
        c2743o0.getClass();
        C2719n0.a(context, false);
    }
}
