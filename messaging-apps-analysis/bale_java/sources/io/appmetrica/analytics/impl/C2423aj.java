package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.aj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2423aj implements Ka {
    public final /* synthetic */ String a;

    public C2423aj(String str) {
        this.a = str;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportEvent(this.a);
    }
}
