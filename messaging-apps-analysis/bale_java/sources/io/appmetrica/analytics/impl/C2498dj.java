package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.dj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2498dj implements Ka {
    public final /* synthetic */ String a;
    public final /* synthetic */ Throwable b;

    public C2498dj(String str, Throwable th) {
        this.a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportError(this.a, this.b);
    }
}
