package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Ni implements Ka {
    public final /* synthetic */ boolean a;

    public Ni(boolean z) {
        this.a = z;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.setDataSendingEnabled(this.a);
    }
}
