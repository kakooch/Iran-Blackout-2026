package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Xi implements Ka {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public Xi(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.putAppEnvironmentValue(this.a, this.b);
    }
}
