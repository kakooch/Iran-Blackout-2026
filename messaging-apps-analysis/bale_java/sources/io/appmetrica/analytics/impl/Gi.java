package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Gi implements Ka {
    public final /* synthetic */ Throwable a;

    public Gi(Throwable th) {
        this.a = th;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportUnhandledException(this.a);
    }
}
