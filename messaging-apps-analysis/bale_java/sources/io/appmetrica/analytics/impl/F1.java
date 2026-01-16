package io.appmetrica.analytics.impl;

import android.os.Bundle;

/* loaded from: classes3.dex */
public final class F1 implements InterfaceC2738nj {
    public static final E1 b = new E1();
    public static final int c = 1;
    public final InterfaceC2623j0 a;

    public F1(InterfaceC2623j0 interfaceC2623j0) {
        this.a = interfaceC2623j0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2738nj
    public final void reportData(int i, Bundle bundle) {
        ((C1) this.a).a(bundle);
    }
}
