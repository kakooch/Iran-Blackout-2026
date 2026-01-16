package io.appmetrica.analytics.network.impl;

import ir.nasim.AbstractC8614Ws3;
import ir.nasim.SA2;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public final class a extends AbstractC8614Ws3 implements SA2 {
    public final /* synthetic */ HttpsURLConnection a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(HttpsURLConnection httpsURLConnection) {
        super(0);
        this.a = httpsURLConnection;
    }

    @Override // ir.nasim.SA2
    public final Object invoke() {
        return this.a.getInputStream();
    }
}
