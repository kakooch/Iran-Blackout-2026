package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
final class zaah implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference<zaaf> zaa;
    private final Api<?> zab;
    private final boolean zac;

    public zaah(zaaf zaafVar, Api<?> api, boolean z) {
        this.zaa = new WeakReference<>(zaafVar);
        this.zab = api;
        this.zac = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        zaaf zaafVar = this.zaa.get();
        if (zaafVar == null) {
            return;
        }
        Preconditions.checkState(Looper.myLooper() == zaafVar.zaa.zad.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zaafVar.zab.lock();
        try {
            if (zaafVar.zab(0)) {
                if (!connectionResult.isSuccess()) {
                    zaafVar.zab(connectionResult, this.zab, this.zac);
                }
                if (zaafVar.zad()) {
                    zaafVar.zae();
                }
            }
        } finally {
            zaafVar.zab.unlock();
        }
    }
}
