package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Ui implements Ka {
    public final /* synthetic */ String a;
    public final /* synthetic */ byte[] b;

    public Ui(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.setSessionExtra(this.a, this.b);
    }
}
