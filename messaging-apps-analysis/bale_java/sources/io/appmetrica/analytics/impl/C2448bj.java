package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.bj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2448bj implements Ka {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public C2448bj(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportEvent(this.a, this.b);
    }
}
