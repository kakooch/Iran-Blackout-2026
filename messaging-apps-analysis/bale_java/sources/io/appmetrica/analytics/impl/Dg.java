package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes3.dex */
public final class Dg implements Runnable {
    public final Context a;
    public final Q5 b;
    public final Bundle c;
    public final C2723n4 d;

    public Dg(Context context, Q5 q5, Bundle bundle, C2723n4 c2723n4) {
        this.a = context;
        this.b = q5;
        this.c = bundle;
        this.d = c2723n4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y3 y3A = Y3.a(this.a, this.c);
        if (y3A == null) {
            return;
        }
        C2508e4 c2508e4A = C2508e4.a(y3A);
        C2880ti c2880tiS = C2586ha.C.s();
        c2880tiS.a(y3A.b.getAppVersion(), y3A.b.getAppBuildNumber());
        c2880tiS.a(y3A.b.getDeviceType());
        A4 a4 = new A4(y3A);
        this.d.a(c2508e4A, a4).a(this.b, a4);
    }
}
