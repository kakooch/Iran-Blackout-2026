package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Fi implements Ka {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Fi(String str, String str2, Throwable th) {
        this.a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportError(this.a, this.b, this.c);
    }
}
