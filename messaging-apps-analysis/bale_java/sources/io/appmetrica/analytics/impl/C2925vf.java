package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;

/* renamed from: io.appmetrica.analytics.impl.vf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2925vf implements InstallReferrerStateListener {
    public final /* synthetic */ Hf a;
    public final /* synthetic */ C2973xf b;

    public C2925vf(C2973xf c2973xf, Hf hf) {
        this.b = c2973xf;
        this.a = hf;
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            try {
                ReferrerDetails installReferrer = this.b.a.getInstallReferrer();
                this.b.b.execute(new RunnableC2901uf(this, new Cf(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), Bf.c)));
            } catch (Throwable th) {
                this.b.b.execute(new RunnableC2949wf(this.a, th));
            }
        } else {
            this.b.b.execute(new RunnableC2949wf(this.a, new IllegalStateException("Referrer check failed with error " + i)));
        }
        try {
            this.b.a.endConnection();
        } catch (Throwable unused) {
        }
    }
}
