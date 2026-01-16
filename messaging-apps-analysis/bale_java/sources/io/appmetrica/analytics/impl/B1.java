package io.appmetrica.analytics.impl;

import android.content.Intent;

/* loaded from: classes3.dex */
public final class B1 implements L1 {
    public final /* synthetic */ C1 a;

    public B1(C1 c1) {
        this.a = c1;
    }

    @Override // io.appmetrica.analytics.impl.L1
    public final void a(Intent intent) {
        this.a.getClass();
        C2586ha.C.s().a(Ya.e(intent.getStringExtra("screen_size")));
    }
}
