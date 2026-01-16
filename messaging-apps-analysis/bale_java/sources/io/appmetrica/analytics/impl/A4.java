package io.appmetrica.analytics.impl;

import android.os.ResultReceiver;

/* loaded from: classes3.dex */
public final class A4 {
    public final Yk a;
    public final C3010z4 b;
    public final ResultReceiver c;

    public A4(Y3 y3) {
        this(new Yk(y3), new C3010z4(y3.b(), y3.a().a()), y3.a().c());
    }

    public A4(Yk yk, C3010z4 c3010z4, ResultReceiver resultReceiver) {
        this.a = yk;
        this.b = c3010z4;
        this.c = resultReceiver;
    }
}
